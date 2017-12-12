package com.admin.login.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.admin.action.mapper.ActionModelMapper;
import com.admin.action.model.ActionModel;
import com.admin.action.model.ModelActionBase;
import com.admin.action.model.ModelActionUnit;

import BasicSession.sessionAdminUserinfo;
import paramter.OutPutParam;
import utility.EncryptUtility;
import utility.UrlReplace;

@RestController
@RequestMapping("/admin/auth")
@SessionAttributes(value = { "sessionAdminUserinfo" })
public class GetActionRestController {

	@Autowired
	ActionModelMapper actionModelMapper;
	
	@RequestMapping(value="/getAction", method=RequestMethod.GET)
	public OutPutParam getAction(Model model,HttpServletRequest request,HttpServletResponse response,SessionStatus sessionStatus) {
		{
			utility.Log.logger.error("getAction:");
			
			//回传参数
			OutPutParam mRet = new OutPutParam();
			
			List<ModelActionBase> baseList = new ArrayList<ModelActionBase>();
			
			OutPutParam outParam = new OutPutParam();
			try {
				Map modelMap = model.asMap();
				if (modelMap.get("sessionAdminUserinfo") != null) {
					
					// 获取用户session信息
					sessionAdminUserinfo mSessionUserinfo = (sessionAdminUserinfo) modelMap.get("sessionAdminUserinfo");

//					logEntity.setToken(mSessionUserinfo.getToken());
//					logEntity.setUser_id(mSessionUserinfo.getUserId());
					String mKey = mSessionUserinfo.getUserActionKey();
					//int role= Integer.parseInt(mSessionUserinfo.getUserRole());
					// 获取所有可见权限
					List<ActionModel> resultList = actionModelMapper.selectAll();

					if (resultList != null) {
						String mItemNames = "";
						for (ActionModel mAction : resultList) {
							if (mAction.getPaid() == 0) {
								ModelActionBase base = new ModelActionBase();
								base.setId(mAction.getAid());
								base.setText(mAction.getAdescribe());
								base.setItems(new ArrayList<ModelActionUnit>());
								baseList.add(base);
							}
						}
						// 组织返回数据
						for (ActionModel mAction : resultList) {
							int pid;
							if ((pid = mAction.getPaid()) > 0) {
								for (ModelActionBase base : baseList) {
									if (base.getId() == pid) {
										ModelActionUnit unit = new ModelActionUnit();
										unit.setId(mAction.getAid());
										unit.setPath(UrlReplace
												.getEncodeStr(EncryptUtility.encrypt(mAction.getAid().toString(), mKey)));
										unit.setText(mAction.getAdescribe());
										base.getItems().add(unit);
										mItemNames += " " + mAction.getAdescribe();
									}
								}
							}
						}

						utility.Log.logger.error("获取到权限数目" + resultList.size() + "项。" + mItemNames + "。");

					} else {
						// 写日志

						utility.Log.logger.error("获取到权限数目0项。");

					}
					outParam.setSuccess();
					outParam.setBody(baseList);
				}
				else
				{
					// 写日志

					utility.Log.logger.error("用户登录过期，session不存在。");

					outParam.setFailure();
					outParam.setBody(null);
					outParam.setMessage("expire");
				}			
				return outParam;
			} catch (Exception ex) {
				// 写日志

				utility.Log.logger.error( "获取权限异常：" + ex.getMessage() + "。");

				outParam.setFailure();
				outParam.setMessage(null);
				return outParam; 
			} finally {

//				utility.Log.logger.error(getLog_Url(), logEntity);

			}
			
		}
	}
}

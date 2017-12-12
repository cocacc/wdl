package com.admin.login.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.admin.action.mapper.ActionModelMapper;
import com.admin.action.model.ActionModel;

import BasicSession.sessionAdminUserinfo;
import utility.EncryptUtility;
import utility.UrlReplace;
import utility.WriteLogUtility;

@Controller
@RequestMapping("/admin/auth")
@SessionAttributes(value = { "sessionAdminUserinfo" })
public class GetTranslateActionController {

	// session名称
	private String mSessionName = "sessionAdminUserinfo";
	// 验证码session名称
	private String mValideCodeSessionName = "valideCode";
	// 验证码过期时间session名称
	private String mValideDateTimeName = "valideCodeTime";
	
	@Autowired
	ActionModelMapper actionModelMapper;
	
	@RequestMapping(value = "translateAction/{actionID}", method = RequestMethod.GET)
	public ModelAndView Action(Model model, @PathVariable String actionID) {
		utility.Log.logger.error("GetTranslateActionController:调用成功");
		// 跳转到指定界面
		ModelAndView mav = new ModelAndView();
		try {
			String actionPath = UrlReplace.getDecodeStr(actionID);
			Map modelMap = model.asMap();
			// 判断是否登录
			if (modelMap.get(mSessionName) != null) {
				sessionAdminUserinfo mSessionUserinfo = (sessionAdminUserinfo) modelMap.get(mSessionName);
				
				
				String mKey = mSessionUserinfo.getUserActionKey();
				List<ActionModel> resultAction = actionModelMapper.selectByUserKey(EncryptUtility.decrypt(actionPath, mKey));
				String viewName = "error";
				if (resultAction.size() > 0) {
					// 有记录就处理窗口
					viewName = ((ActionModel) resultAction.get(0)).getAwindow();
				}
				System.err.println("viewName="+viewName);
				mav.setViewName(viewName);
				
			} else {
				
				mav.setViewName("error");
			}
			return mav;
		} catch (Exception ex) {
			
			mav.setViewName("error");
			return mav;
		} finally {
			
		}

	}
}

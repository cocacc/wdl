package com.admin.login.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.weixin.userinfo.mapper.UserinfoModelMapper;
import com.weixin.userinfo.model.UserinfoModel;

import utility.EncryptUtility;

import BasicSession.sessionAdminUserinfo;
import paramter.OutPutParam;

@RestController
@RequestMapping("/admin/auth")
@SessionAttributes(value = { "sessionAdminUserinfo" })
public class GetLoginRestController {

	// session名称
		private String mSessionName = "sessionAdminUserinfo";
		// 验证码session名称
		private String mValideCodeSessionName = "valideCode";
		// 验证码过期时间session名称
		private String mValideDateTimeName = "valideCodeTime";

		@Autowired
		UserinfoModelMapper userinfoModelMapper;
		
	@RequestMapping(value="/getAdminLogin", method=RequestMethod.POST)
	public OutPutParam getAdminLogin(Model model,HttpServletRequest request,HttpServletResponse response) {
		{
			
			//回传参数
			OutPutParam mRet = new OutPutParam();
			
			String mUserCode = request.getParameter("usercode");
			String mUserPassword = request.getParameter("password");
			String minPutValideCode= request.getParameter("validecode");
			
			utility.Log.logger.error("getAdminLogin:参数信息:"+mUserCode+"|"+mUserPassword+"|"+minPutValideCode);
			
			UserinfoModel mUserinfoModel =  userinfoModelMapper.selectByMobile(mUserCode);
			
			if (mUserinfoModel == null)
			{
				utility.Log.logger.error("getAdminLogin:获取用户信息为空");
				
				mRet.setBody(null);
	    		mRet.setFailure();
				return mRet;
			}
			
			Map modelMap = model.asMap();
			
			if (mUserinfoModel.getPassword().equals(EncryptUtility.MD5To32(mUserPassword)))
			{
				utility.Log.logger.error("getAdminLogin:登入成功");
				//处理登录
				//登录验证，登录成功后，写session
				sessionAdminUserinfo mSessionAdminUserinfo = new sessionAdminUserinfo();
				//处理密钥
				// 用户actionKey
				mSessionAdminUserinfo.setUserActionKey(EncryptUtility.genKey());
				//用户手机
				mSessionAdminUserinfo.setUser_phone(mUserCode);
				//
				mSessionAdminUserinfo.setId(mUserinfoModel.getId());
				
				utility.Log.logger.error("getAdminLogin:mSessionAdminUserinfo："+mSessionAdminUserinfo.getUserActionKey());
				//绑定页面
	    		model.addAttribute(mSessionName, mSessionAdminUserinfo);
				
	    		ArrayList<String> mRetList = new ArrayList<>();
	    		mRet.setBody(mRetList);
	    		mRet.setSuccess();
				return mRet;
				
			}
			else
			{
				utility.Log.logger.error("getAdminLogin:密码校验失败");
				mRet.setBody(null);
	    		mRet.setFailure();
				return mRet;
			}
			
			
			
			
			
			
			
		}
	}
}

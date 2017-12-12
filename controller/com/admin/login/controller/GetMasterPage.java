package com.admin.login.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import BasicSession.sessionAdminUserinfo;


@RestController
@Transactional
@SessionAttributes(value={"sessionAdminUserinfo"})

@RequestMapping(value = "/admin")
public class GetMasterPage {

	private String mSessionName = "sessionAdminUserinfo";
	// 验证码session名称
	private String mValideCodeSessionName = "valideCode";
	// 验证码过期时间session名称
	private String mValideDateTimeName = "valideCodeTime";
	
	@RequestMapping(value = "/masterpage", method = RequestMethod.GET)
	public ModelAndView masterpage(Model model, HttpServletRequest request, HttpServletResponse response) {
		// 判断是否有已经登录的信息，如果有已经登录的信息，就直接登陆到主页面
		Map modelMap = model.asMap();
		if (modelMap.get("sessionAdminUserinfo") != null) {
			System.out.println(
					"sessionUserinfo:" + " -- " + ((sessionAdminUserinfo) modelMap.get("sessionAdminUserinfo")).getusername());
		}
		ModelAndView mav;
		Map value = new HashMap();
		value.put("userType", "user");
		if (modelMap.get("sessionAdminUserinfo") == null) {
			utility.Log.logger.error("masterpage:没有session返回登录");
			mav = new ModelAndView("/manager/login");
		} else {
			utility.Log.logger.error("masterpage:登录成功，显示master");
			mav = new ModelAndView("/manager/masterpage", value);
		}
		return mav;
	}
}

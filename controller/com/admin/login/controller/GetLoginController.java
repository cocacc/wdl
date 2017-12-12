package com.admin.login.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@RestController
//s@Transactional
@SessionAttributes(value={"sessionAdminUserinfo"})
@RequestMapping(value = "/admin")
public class GetLoginController {

	@RequestMapping(value="/getAdminLoginPage", method=RequestMethod.GET)
	public ModelAndView getAdminLoginPage(Model model,HttpServletRequest request,HttpServletResponse response) {
		{
			utility.Log.logger.error("getAdminLoginPage:");
			
			
			ModelAndView mav;
			
			mav =new ModelAndView("manager/login");
			
			return mav;
		}
	}
}

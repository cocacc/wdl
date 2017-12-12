package com.admin.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Transactional
@SessionAttributes(value={"sessionAdminUserinfo"})

@RequestMapping(value = "/admin")
public class GetMainController {

	@RequestMapping(value = "/main")
	public ModelAndView defaultPage(HttpServletRequest request, HttpServletResponse response,
			SessionStatus sessionStatus) {
		ModelAndView mav = new ModelAndView("/manager/welcome");
		return mav;
	}
	
}

package com.weixin.menu.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.soecode.wxtools.exception.WxErrorException;


@RestController
@RequestMapping(value = "/")
public class GetManualMenuController {

	@RequestMapping(value="/TaiguoManualMenu", method=RequestMethod.GET)
	public ModelAndView MyOrderMenu(Model model,HttpServletRequest request,HttpServletResponse response) throws IOException, WxErrorException{
		ModelAndView mav = new ModelAndView("manual/taiguo/taiguo");
		
		return mav;
	}
}

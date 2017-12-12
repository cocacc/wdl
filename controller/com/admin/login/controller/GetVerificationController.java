package com.admin.login.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import paramter.OutPutParam;
import utility.Log;


@Controller
@RequestMapping("/admin/auth")
@SessionAttributes(value = { "sessionAdminUserinfo", "valideCode","valideCodeTime" })
public class GetVerificationController {
	
	// session名称
	private String mSessionName = "sessionAdminUserinfo";
	// 验证码session名称
	private String mValideCodeSessionName = "valideCode";
	// 验证码过期时间session名称
	private String mValideDateTimeName = "valideCodeTime";
	
	@RequestMapping(value = "/getValidCode", method = RequestMethod.GET)
	public void getValidCode(Model model, HttpServletRequest request, HttpServletResponse response) {
		Map modelMap = model.asMap();
		OutPutParam op = new OutPutParam();
		utility.Log.logger.error("GetVerificationController:提交值：:"+modelMap.size());
		try {
			utility.ValidcodeImageUtility utility= new utility.ValidcodeImageUtility();
			String valideCode =utility.createValideCode(4);
			String base64String =utility.convertToBase64(utility.drawPicture(80, 32, valideCode));
			Log.logger.error("valideCode=="+valideCode);
			modelMap.put(mValideCodeSessionName, valideCode.toLowerCase());
			modelMap.put(mValideDateTimeName, new Date());
			op.setSuccess();
			op.setBody(base64String);
			//utility.Log.logger.error("length="+base64String.length()+"   "+base64String);
			Log.logger.error("GetVerificationController:提交值：:"+modelMap.size());
			
			
		} catch (IOException e) {
			op.setFailure();
			op.setMessage("请稍后再试");
		} finally {
			try {
					response.setCharacterEncoding("UTF-8");
					response.getWriter().write(utility.SerializableUtility.Serialize(op));
					try
					{
						response.getWriter().close();
					}catch(Exception ex)
					{
						
					}
			} catch (IOException e) 
			{
			}
		}

	}
}

package com.weixin.callback.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxConfig;
import com.soecode.wxtools.api.WxMessageRouter;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.bean.WxXmlOutMessage;
import com.soecode.wxtools.bean.result.WxOAuth2AccessTokenResult;
import com.soecode.wxtools.util.xml.XStreamTransformer;
import com.weixin.userinfo.mapper.UserinfoModelMapper;

import wx.process.SubscribeHandler;
import wx.process.TextHandler;
import wx.test.DemoHandler;

@RestController
@Transactional
@RequestMapping(value = "/Validate")
public class WexinCallbackController {
	
	@Autowired
	UserinfoModelMapper userinfoModelMapper;
	
	
	@RequestMapping(value = "/doValidate", method = RequestMethod.POST)
	public void doValidatePost(HttpServletRequest request, HttpServletResponse response) throws Exception {
	        request.setCharacterEncoding("UTF-8");
	        response.setCharacterEncoding("UTF-8");
	        // 返回消息给微信服务器
	        PrintWriter out = response.getWriter();
	        // 获取encrypt_type 消息加解密方式标识
	        String encrypt_type = request.getParameter("encrypt_type");
	        // 创建一个路由器
	        IService iService = null;
			WxMessageRouter router = new WxMessageRouter(iService);
	        try {
	            // 判断消息加解密方式，如果是加密模式。encrypt_type==aes
	            if (encrypt_type != null && "aes".equals(encrypt_type)) {
//	              String signature = request.getParameter("signature");
	                String timestamp = request.getParameter("timestamp");
	                String nonce = request.getParameter("nonce");
	                String msg_signature = request.getParameter("msg_signature");
	                // 微信服务器推送过来的加密消息是XML格式。使用WxXmlMessage中的decryptMsg()解密得到明文。
	                WxXmlMessage wx = WxXmlMessage.decryptMsg(request.getInputStream(), WxConfig.getInstance(), timestamp,
	                        nonce, msg_signature);
	                utility.Log.logger.error("密文消息：\n " + wx.toString());
	                // 添加规则；这里的规则是指所有消息都交给交给DemoHandler处理
	                // 注意！！每一个规则，必须由end()或者next()结束。不然不会生效。
	                // end()是指消息进入该规则后不再进入其他规则。 而next()是指消息进入了一个规则后，如果满足其他规则也能进入，处理。
	                router.rule().handler(new DemoHandler()).end();
	                // 把消息传递给路由器进行处理，得到最后一个handler处理的结果
	                WxXmlOutMessage xmlOutMsg = router.route(wx);
	                if (xmlOutMsg != null) {
	                    // 将要返回的消息加密，返回
	                    out.print(WxXmlOutMessage.encryptMsg(WxConfig.getInstance(), xmlOutMsg.toXml(), timestamp, nonce));// 返回给用户。
	                }
	            //如果是明文模式，执行以下语句
	            } else {
	                // 微信服务器推送过来的是XML格式。
	                WxXmlMessage wx = XStreamTransformer.fromXml(WxXmlMessage.class, request.getInputStream());
	                utility.Log.logger.error("明文消息：\n " + wx.toString());
	                // 添加规则；这里的规则是指所有消息都交给DemoHandler处理
	                // 注意！！每一个规则，必须由end()或者next()结束。不然不会生效。
	                // end()是指消息进入该规则后不再进入其他规则。 而next()是指消息进入了一个规则后，如果满足其他规则也能进入，处理。
	                //router.rule().matcher(matcher)
	                //WxOAuth2AccessTokenResult result = iService.oauth2ToGetAccessToken(request.getParameter("code"));
	                utility.Log.logger.error("开始处理");
	                router.rule().handler(new SubscribeHandler(userinfoModelMapper)).end();
	                //router.rule().handler(new TextHandler(userinfoModelMapper)).end();
	                // 把消息传递给路由器进行处理
	                WxXmlOutMessage xmlOutMsg = router.route(wx);
	                if (xmlOutMsg != null)
	                    out.print(xmlOutMsg.toXml());// 因为是明文，所以不用加密，直接返回给用户。
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            out.close();
	        }
	
	
	}
}

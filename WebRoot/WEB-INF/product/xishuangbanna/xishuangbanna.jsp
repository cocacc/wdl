<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
	<title>西双版纳</title>
	 <script src="http://g.tbcdn.cn/mtb/lib-flexible/0.3.4/??flexible_css.js,flexible.js"></script>
	<style type="text/css">
	*{
		margin:0;
		padding: 0;
	}
	body { 
     -webkit-text-size-adjust: 100% !important;
     margin: 0;padding: 0;
     font-family: -apple-system-font,"Helvetica Neue","PingFang SC","Hiragino Sans GB","Microsoft YaHei",sans-serif;
	}
	img{
		width:100%;
	}
	.a4{
		height: 1.5rem;
		position: fixed;
		left: 0;
		bottom:0rem;
	}
	.a4 span{
		color: #2c5c86;
		font-size: .45rem;
		background: #fff;
		width: 5rem;
		float: left;
		height: 1.5rem;
		text-align: center;
		line-height: 1.5rem;
	}

	.a5{
		color: #fff;
		width:5rem;
		height:1.5rem;
		background: #e88e2e;
		font-size: #fff;
		font-size: .45rem;
		text-align: center;
		line-height: 1.5rem;
		display: inline-block;
		float: left;
	}
	.a10{
		height: 1.5rem;
	}
	</style>
</head>
<body>
	<div id="app">
	<div class="a4">
			<a href="tel:12345">
				<span>在线客服</span>
			</a>
			<p class="a5" onclick="location.href=${AddPrdUid}">立刻报名</p>
		</div>
		<img src="http://cdn.wdl666.cn/wdl/static/product/xishuangbanna/1.jpg" alt="" border="0">
		<img src="http://cdn.wdl666.cn/wdl/static/product/xishuangbanna/2.png" alt="" border="0">
		<img src="http://cdn.wdl666.cn/wdl/static/product/xishuangbanna/3.png" alt="" border="0">
		<img src="http://cdn.wdl666.cn/wdl/static/product/xishuangbanna/4.png" alt="" border="0">
		<img src="http://cdn.wdl666.cn/wdl/static/product/xishuangbanna/5.png" alt="" border="0">
		<img src="http://cdn.wdl666.cn/wdl/static/product/xishuangbanna/6.png" alt="" border="0">
		<img src="http://cdn.wdl666.cn/wdl/static/product/xishuangbanna/7.png" alt="" border="0" />
		<img src="http://cdn.wdl666.cn/wdl/static/product/xishuangbanna/8.png" alt="" border="0" />
		<img src="http://cdn.wdl666.cn/wdl/static/product/xishuangbanna/9.png" alt="" border="0" />
		<img src="http://cdn.wdl666.cn/wdl/static/product/xishuangbanna/10.jpg" alt="" border="0" />
		<img src="http://cdn.wdl666.cn/wdl/static/product/xishuangbanna/11.jpg" alt="" border="0" />
		<img src="http://cdn.wdl666.cn/wdl/static/product/xishuangbanna/12.jpg" alt="" border="0" />
		<img src="http://cdn.wdl666.cn/wdl/static/product/xishuangbanna/13.jpg" alt="" border="0" />
		<img src="http://cdn.wdl666.cn/wdl/static/product/xishuangbanna/14.jpg" alt="" border="0" />
		
		<div class="a10"></div>
	</div>
</body>
<script type="text/javascript">
     (function () {
		if(typeof WeixinJSBridge == "object" && typeof WeixinJSBridge.invoke == "function") {handleFontSize();}else{if(document.addEventListener){document.addEventListener("WeixinJSBridgeReady", handleFontSize, false);} else if(document.attachEvent) {document.attachEvent("WeixinJSBridgeReady", handleFontSize);document.attachEvent("onWeixinJSBridgeReady", handleFontSize);}}
		function handleFontSize(){WeixinJSBridge.invoke('setFontSizeCallback', {'fontSize': 0});WeixinJSBridge.on('menu:setfont',function(){WeixinJSBridge.invoke('setFontSizeCallback',{'fontSize':0});});}
		})();
  </script>
</html>
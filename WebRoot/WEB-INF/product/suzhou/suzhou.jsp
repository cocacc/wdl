<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
	<title>路线详情</title>
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
		<img src="https://t1.picb.cc/uploads/2017/10/23/W0Xuu.jpg" alt="W0Xuu.jpg" border="0">
		<img src="https://t1.picb.cc/uploads/2017/10/23/W0BvD.jpg" alt="W0BvD.jpg" border="0">
		<img src="https://t1.picb.cc/uploads/2017/10/23/W00Ya.jpg" alt="W00Ya.jpg" border="0">
		<img src="https://t1.picb.cc/uploads/2017/10/23/W0bV0.jpg" alt="W0bV0.jpg" border="0">
		<img src="https://t1.picb.cc/uploads/2017/10/23/W0UGR.jpg" alt="W0UGR.jpg" border="0">
		<img src="https://t1.picb.cc/uploads/2017/10/23/W0FUv.jpg" alt="W0FUv.jpg" border="0">
		<img src="https://t1.picb.cc/uploads/2017/10/23/W0QPJ.jpg" alt="W0QPJ.jpg" border="0" />
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>玩到老 在线平台</title>

<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<script src="/extreme/js/jquery.placeholder.js" language="javascript"
	type="text/javascript"></script>
<script src="/extreme/js/respond.js" language="javascript"
	type="text/javascript"></script>

<!-- <link href="/css/bootstrap/bootstrap.css" rel="stylesheet" /> -->
<link href="/css/elements.css" rel="stylesheet" type="text/css" />
<link href="/extreme/css/dx.common.css" rel="stylesheet" />
<link href="/extreme/css/styles.css" rel="stylesheet" />
<link href="/extreme/css/dx.common.css" rel="stylesheet" />
<link href="/extreme/css/dx.spa.css" rel="stylesheet" type="text/css" />

<link rel="dx-theme" data-theme="generic.dark"
	href="/extreme/css/dx.dark.css" data-active="false" />
<link rel="dx-theme" data-theme="generic.light"
	href="/extreme/css/dx.light.css" data-active="true" />
<!--[if lt IE 9]>
   <script type="text/javascript" src="/extreme/js/jquery-1.12.3.min.js"></script>
   <![endif]-->
<!--[if gte IE 9]><!-->
<script src="/extreme/js/jquery-2.2.3.min.js"></script>
<!--<![endif]-->
<script src="/extreme/js/knockout-3.4.0.js"></script>
<script src="/extreme/js/cldr.min.js"></script>
<script src="/extreme/js/cldr/event.min.js"></script>
<script src="/extreme/js/cldr/supplemental.min.js"></script>
<script src="/extreme/js/cldr/unresolved.min.js"></script>
<script src="/extreme/js/globalize.min.js"></script>
<script src="/extreme/js/globalize/message.min.js"></script>
<script src="/extreme/js/globalize/number.min.js"></script>
<script src="/extreme/js/globalize/date.min.js"></script>
<script src="/extreme/js/globalize/currency.min.js"></script>
<script src="/extreme/js/jszip.min.js"></script>

<script src="/extreme/js/dx.all.js"></script>
<script src="/extreme/js/underscore-1.5.1.min.js"></script>

<!-- this page specific styles -->
<link rel="stylesheet" href="/css/compiled/signin.css" type="text/css"
	media="screen" />
<script type="text/javascript" src="/extreme/js/layer.min.js"></script>


<style type="text/css" media="screen">
body {
	background-color: #2E363F;
	background: url('/css/image/bgs/background.png') no-repeat center center
		fixed;
}
</style>
</head>
<body>

	<script>
		function jsmainModels() {
			var self = this;
			self.usercode = ko.observable("");
			self.password = ko.observable("");
			self.validecode = ko.observable("");
			self.submit = function() {
				if (self.usercode().trim().length == 0 || self.password().trim().length == 0) {
					DevExpress.ui.notify("请输入用户名和密码", "error", 1500);
					return;
				}
				$.ajax({
					url : "<%=request.getContextPath() %>/admin/auth/getAdminLogin",
					type : "post",
					data : {
						usercode : self.usercode(),
						password : self.password(),
						validecode:self.validecode(),
					},
					success : function(data, status, code) {
					console.log(data);
						//var retValue = JSON.parse(data);
						console.log(data.success);
						if (data != undefined && data.success == 'true') {
							DevExpress.ui.notify("登录成功", "success", 1500);
							location.href = "<%=request.getContextPath() %>/admin/masterpage"
						}
						else if (data != undefined && data.success == 'false') {
							self.password("");
							var message = "";
							if (data.message != undefined && data.message.length > 0) {
								message = data.message;
							}
							else {
								message = "登录失败，请稍后再试";
							}
							DevExpress.ui.notify(message, "error", 1500);
						}
					},
					error : function(XMLHttpRequest, textStatus, errorThrown) {
						self.password("");
						DevExpress.ui.notify("网络异常，请稍后再试", "error", 1500);
					}
				});
			}
		}
	
		$(document).ready(function() {
			JsMain = new jsmainModels();
			ko.applyBindings(JsMain);
			getValidCode();
	
		});
	
		function getValidCode() {
			$.ajax({
				url : "<%=request.getContextPath()%>/admin/auth/getValidCode",
				type : "get",
				success : function(data, status, code) {
					var retValue = JSON.parse(data);
					if (retValue != undefined && retValue.success == 'false') {
						var message="操作过于频繁，请稍后再试！";
						if(retValue.message!=undefined)
						{
							message=retValue.message
						}
						DevExpress.ui.notify(message, "error", 1500);
					}
					else
					{
						$("#image_validcode").attr('src', retValue.body)
					}
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					DevExpress.ui.notify("网络异常，请稍后再试", "error", 1500);
				}
			});
		}
	</script>
	<div class="login-wrapper" style="width:100%">
		<div></div>
		<div class="span4 box"  >
			<form id="form_login"  >
				<div class="content-wrap">
					<img class="logo" src="/images/login_logo1.png"/> 
					<input type="hidden" name="usercode"
						id="usercode" data-bind='value:usercode'/>
					<div
						data-bind="dxTextBox: {
						    placeholder: '',
						    maxLength: 1000,			    
						    value: usercode
						}"
						style="margin:0px 25px 0px 25px;height:40px">
					</div>


					<input type="hidden" /> <br/>
					<div
						data-bind="dxTextBox: {
						    placeholder: '',
						    maxLength: 1000,
						    mode:'password',
						    value: password
						}"
						style="margin:0px 25px 0px 25px"></div>
					<div style="float: inherit;margin:15px 25px 0px 25px;height: 40px">
						<div
							data-bind="dxButton:{ text:'登录',onClick: submit ,type: 'default' ,width:75}"
							style="float:left;display:inline;" ></div>
						<div style="cursor:pointer;margin:0px 0px 0px 35px;width:65;float:left;display:inline;height: 32px">
							<img id="image_validcode" src="" 
								onclick="getValidCode()" title="点击获取验证码" />
						</div>
						<div
								data-bind="dxTextBox: {
							    placeholder: '验证码',
							    maxLength: 8,
							    value: validecode,
							    width:75
								}"
								style="margin:0px 0px 0px 0px;float:right;display:inline;height: 35px"></div>
						</div>
					</div>
				</div>
				<div>
					<h5>
						<p>&copy;</p>
					</h5>
				</div>
			</form>
		</div>
		
	</div>
</body>
</html>
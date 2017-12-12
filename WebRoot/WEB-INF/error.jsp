<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="gb2312" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>新掌柜后台系统</title>
<!-- Theme -->
<link href="/extreme/css/styles.css" rel="stylesheet" />
<link href="/extreme/css/dx.common.css" rel="stylesheet" />
<link href="/extreme/css/dx.spa.css"  rel="stylesheet" type="text/css"  />


<link rel="dx-theme" data-theme="generic.dark" href="/extreme/css/dx.dark.css" data-active="true" />
<link rel="dx-theme" data-theme="generic.light" href="/extreme/css/dx.light.css" data-active="false" />

<script src="/extreme/js/jquery.placeholder.js" language="javascript" type="text/javascript" ></script>	
<script src="/extreme/js/respond.js" language="javascript" type="text/javascript" ></script>	

<script src="/extreme/js/jquery-2.2.3.min.js"></script>

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
<link rel="stylesheet" href="/css/compiled/signin.css" type="text/css" media="screen" /> 
<script type="text/javascript" src="/extreme/js/layer.min.js"></script>

	<style type="text/css">
        body {
		    text-align: center;
		}
		.toolbar{
		    position: absolute;
		    top:0;
		    left: 0;
		    width: 90%;
		    height: 25px;
		    padding: 5%;
		}
		.box {
		    height: 100%;
		}
		.header{ 
		    background-color: #267cdf; 
		    text-align: left;
		}
		.content{ 
		    background-color: #ffffff; 
		    text-align: center;
		}
		.left-side-bar{ 
		    background-color: #484848;
		}
		.right-side-bar{ 
		    background-color: #484848; 
		}
		.footer{ 
		    background-color: #267cdf; 
		    height: 60px;
		}
		.selection{
		    margin: auto;
		    font-size: 14px;
		    color: #ffffff;
		    background-color: #2a2a2a;
		    padding: 10px,;
		    border: solid 2px #c36e3c;
		}
		
		.left 
		{
		    float:left;
		}
		.right_ul
		{
		    float:right; 
		    list-style-type:none; 
		    margin-top:0px; 
		    height: 30px;
		}
	</style>
	<script>
		var loginOut =function()
		{
			if(parent!=null)
			{
				parent.refleshPage();
			}
		}
		$(document).ready(function () {
		   setTimeout(loginOut,2000);
		   DevExpress.ui.notify("页面已经过期，请重新登录", "error", 2000);
		   
		});
		
	</script>
</head>
<body>
	
</body>
</html>
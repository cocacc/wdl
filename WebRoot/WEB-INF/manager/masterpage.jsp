<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="GBK" %>
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
var userType = "${userType}";

var refleshPage=function()
{
	location.reload(false);   	
}

function getjsonModels(){

    var self = this;
    if(userType=="user")
    {
    	self.UserPath=ko.observable("");
    }
    else
    {
    	self.UserPath=ko.observable("/admin");	
    }
    self.dataSource = ko.observable(new DevExpress.data.DataSource);
    setLayout = function (layout) {
	    currentLayout = layout;
	    $(".box").dxResponsiveBox("instance").repaint();
	};
	currentLayout = "lg";
	menuItems= ko.observable();
    rowItems= [
            { ratio: 1 ,baseSize: 50, screen: 'lg'},
            { ratio: 1000 , screen: 'lg'}
    ],
    
    colItems= [
            { ratio: 1,baseSize: 120, screen: 'lg' },
            { ratio: 1000, screen: 'lg' }
    ],
    
    getScreenFactor= function (width) {
        return currentLayout;
    };
    
    mainItemClicked = function (data) {
        
        if (data.itemData.path != null){
    		$("#iframepage").attr("src","<%=request.getContextPath() %>/admin/auth/translateAction/"+data.itemData.path);
    	}
    };
    self.getAction = function () {
   	 $.ajax({
			url: "<%=request.getContextPath() %>/admin/auth/getAction",
			type: "get",
			data: {},
			success: function (data, status) {
				if(data.success=="true")
				{
        			menuItems (new DevExpress.data.DataSource(data.body));
        		}
        		else if(data.message=="expire")
        		{
        			DevExpress.ui.notify("页面已经过期，请重新登录", "error", 2000);
        			refleshPage();
        		}
        		else
        		{
        			DevExpress.ui.notify("加载边栏异常，请稍后再试", "error", 2000);
        		}
			}
		});
	};
	
    iFrameHeight =   function () {
       var ifm= document.getElementById("iframepage");
       var ifmContent= document.getElementById("ifrcontent");
       var subWeb = document.frames ? document.frames["iframepage"].document : ifm.contentDocument;
       if(ifm != null && subWeb != null) {
           ifm.height = $("#ifrcontent").height();
       }
   }
}
</script >

<script>
$(document).ready(function () {
    getjson1 = new getjsonModels(); 
    ko.applyBindings(getjson1); 
    getjson1.getAction();
});

</script>

</head>
<body onresize="iFrameHeight() " style="overflow:hidden;">

<div class="toolbar">
    
</div>
<div class="box" data-bind="dxResponsiveBox: {
    singleColumnScreen: 'xs',
    rows: rowItems,
    cols: colItems,
    screenByWidth: getScreenFactor
}">
    <div class="header" data-options="dxItem: { 
    
        location: [{ row: 0, col: 0, colspan: 2, screen: 'lg'}]}">
        <p>
        	<div class="dx-field" style="margin:10px">
	            <a class="dropdown-toggle"   id="homelink" name="showmenu">
	              <img alt="logo" class="logo left" src="/images/newlogo3.png" />
	            </a>
	            <ul class="right_ul">
		            <a href="logout" title="退出">
		              <img alt="退出" class="out" src="/images/Out.png" href="<%=request.getContextPath() %>/auth"+self.UserPath()+"/logout" />
		            </a>
	            </ul>
	            <ul class="right_ul">
		            <a  title="首页" href="masterpage" >
		                <img alt="主页" class="out" src="/images/Home.png" href="<%=request.getContextPath() %>/auth"+self.UserPath()+"/masterpage"/> 
		            </a>
	            </ul>
            </div>
        </p>
        </div>
        
    <div id="ifrcontent" class="content" data-options="dxItem: { 
        location: [{ row: 1, col: 1, screen: 'lg' }]}">
        <p>
        <div class="dx-field">
        <iframe id="iframepage" src="<%=request.getContextPath() %>/admin/main" width = "100%"  frameBorder=0 scrolling=yes onLoad="iFrameHeight()">
        </iframe>
        </div>
        </p>
        </div>
    <div class="left-side-bar" data-options="dxItem: { 
        location: [ { row: 1, col: 0, screen: 'lg' }]}">
        <p>
        <div data-bind="dxMenu: {
								    dataSource: menuItems,
								    orientation: 'vertical',
								    onItemClick: mainItemClicked
								}"></div>
        </p>
    </div>    
</div>
</body>
</html>
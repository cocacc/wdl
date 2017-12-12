<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	 <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
   <script src="http://g.tbcdn.cn/mtb/lib-flexible/0.3.4/??flexible_css.js,flexible.js"></script>
<script src="http://cdn.wdl666.cn/js/vue.min.js"></script>
   <script src="http://cdn.wdl666.cn/js/vue-resource.min.js"></script>
	<title>订单详情</title>
</head>
<body>
	<div id="app">
		<div class="titel-box">
			<ul class="title-ul" id="uls">
				<li @click="go($event)" class="coloryellow">
					全部
				</li>
				<li @click="go($event,'1')">
					处理中
				</li>
				<li @click="go($event,'2')">
					已确认
				</li>
			</ul>
		</div>
		<div class="list-info">
			<ul>
				<li v-for="item in list" class="info-li">
					<div style="width: 10rem;display: inline-block;background: #fff;">
						<span class="nubing">订单编号:{{item.orderNo}}</span>
						<span class="scd-2" v-if="item.SCD==2">已确认</span>
						<span class="scd-1"	v-if="item.SCD==1">处理中</span>
						<span class="scd-0" v-if="item.SCD==0">已取消</span>
					</div>	
					<div class="info">
						<span class="content">{{item.content}}</span>
						<span class="number">{{item.number}}人</span>
						<span class="date">出行日期：{{item.datestart}}至{{item.dateend}}</span>
						<span class="price">￥{{item.price}}</span>
					</div>
					<div class="kong">
						
					</div>
				</li>
			</ul>
		</div>
	</div>
</body>
<script type="text/javascript">
	var app = new Vue({
	  el: '#app',
	  data: {
	  	num:true,
	    list:''
	  },
	  computed:{
	        filterShoppingList: function () {
	            let key = this.num;
	            let shoppingList = this.list;
	            if(typeof(key)!=='string'){
		            	return shoppingList.filter(function(item) {
		             	return item.SCD.indexOf(key);
		            });
	            }if(typeof(key)=='string'){
		            return shoppingList.filter(function(item) {
		             	return item.SCD.indexOf(key)!= -1;
		            });
	            }
	        }
	    },
	    methods:{
	    	go:function (event,num) {
	    		this.num = num;
	    		var a = document.getElementById("uls").getElementsByTagName("li");
	    		for(var i=0;i<a.length;i++){
	       	 		a[i].className='';
	       	 	}
	       	 	event.target.className='coloryellow';
	    	}
	    },
        created(){
		
			let postdata ={ "param":"{}","userid":"","token":"","devid":"","version":"","verifycode":"","appid":""};
			 this.$http.post('/wdl/getMyProduct',postdata).then(data=>{
			 	console.log(data.body.body);
			 	this.list = data.body.body;
			 	console.log(this.list);
			 })
		}
	})
</script>
<style type="text/css">
	.list-info{
		padding-top: 1.4rem;
	}
	.coloryellow{
		border-bottom: .08rem solid #F5A623;
	}
	.info-li{
		margin-top: .2rem;
	}
	.kong{
		width: 10rem;
		height: .3rem;
		background: #fff;
	}
	body{
		font-family: 'MicrosoftYaHei';
		background: #f8f8f8;
		height: 100vh;
	}
	.price{
		width: 2rem;
		color: #F5A623;
		font-size: .45rem;
		float: right;
	}
	.date{
		padding-top: .2rem;
	    float: left;
	    width: 6.5rem;
	}
	.number{
		font-size: .45rem;
	    float: right;
	    display: inline-block;
	    width: 1.1rem;
	    height: 1rem;
	    text-align: center;
	    line-height: 1rem;
	}
	.content{
		float: left;
		font-size: .37rem;
	    word-wrap: unset;
	    width: 6.27rem;
	    height: 1rem;
	    clear: both;
	    display: inline-block;
	    overflow: hidden;
	    text-overflow: ellipsis;
	    display: -webkit-box;
	    -webkit-line-clamp: 2;
	    -webkit-box-orient: vertical;
	}
	.info{
		clear: both;
		width: 8.6rem;
		height:1.8rem;
		margin: 0 auto;
		padding: 0 .7rem;
		background: #f8f8f8;
	}
	.scd-1{
		color: #ff6800;
		font-size: .35rem;
		float: right;margin-right: .7rem;
		height: 1rem;
		line-height: 1rem;
	}
	.scd-2,.scd-0{
		color: #909090;
		font-size: .35rem;
		float: right;margin-right: .7rem;
		height: 1rem;
		line-height: 1rem;
	}
	.nubing{
		color: #909090;
		font-size: .35rem;
		margin-left: .71rem;
		width: 7rem;
		float: left;
		text-align: left;
		height: 1rem;
		line-height: 1rem;
	}
	.title-ul{
		display: flex;
    	width: 10rem;

	}
	.titel-box{
		position: fixed;
	    background: #fff;
	    padding-top: .5rem;
	    width: 10rem;
	    height: .85rem;
	    display: flex;
	    border-bottom: .03rem solid #979797;
	}
	.titel-box li{
		width: 1.5rem;
	    line-height: .85rem;
	    text-align: center;
	    height: .8rem;
	    font-size: .45rem;
	    margin-left: 1.4rem;
	}
</style>
</html>
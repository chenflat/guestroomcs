/* [ ---- service manage javascript ---- ] */

$(document).ready(function() {
	
	services.requests();
	uniform.init();
});

services = {
	requests:function(){
		
		if($("#reqlist_nav").length>0) {
			$("#reqlist_nav").hide();
		}
	
		var $roomcontainer = $("#roomcontainer");
		
		var cacheContainer = $roomcontainer.html();
		
		var $headtitle = $(".service-title h4");
		
		//颜色名称
		var colors = ["green","greenLight","greenDark","red","yellow","orange","orangeDark","pink","pinkDark","purple","darken","grayDark","blue","blueLight","blueDark","green","greenLight","greenDark","","pink","pinkDark","purple","darken","grayDark","yellow","orange","orangeDark","pink"];
		var items = [];  //客房请求数据
		var floors = []; //所有楼层 
		
		//根据请求类型异步获取服务请求数据
		$("ul#reqtype > li").click(function(){
			//获取请求类型
			var reqtype = $(this).attr("type");
			console.log("service request type : " + reqtype);
			//set active class name
			$(this).parent().children().removeClass('active');
			$(this).addClass("active");
			
			//没有类型,则返回
			if(typeof(reqtype)=='undefined' || reqtype=="") {
				$.sticky("service type attribute not undefined!", {autoclose : 5000, position: "top-right", type: "st-error" });
				return;
			}
			
			//获取指定类型的客房请求数据
			$.getJSON(contextPath+"service/roomviews",{type:reqtype},function(data){
				items.length = 0;
				floors.length = 0;
				$.each(data, function(key, val) {
				    items.push(val);
					var floorNo = val.roomNo.substring(0,2).toString();
					floors.push(floorNo);
				  });
				$.unique(floors);
				$.unique(floors); //去除重复的楼层
				floors.sort(); //楼层排序
				console.log("Floor list : "+ floors.join(","));
				
				/*if(floors.length==0) {
					$roomcontainer.empty();
					return;
				}*/
				
				if(reqtype==1) {
					services();
				} else if (reqtype==2) {
					sos();
				} else {
					all();
				}
			});

		});
		
		
		
		var services = function() {
			$roomcontainer.empty();
			$roomcontainer.html(cacheContainer);
			
			var serviceTotals = 0;
			
			//定义显示
			var html = "";
			$.each(floors,function(index,floorNo){
				//服务请求选择列表
				$("#reqlist_nav").show();
				//显示客房
				$.each(items,function(key,val){
					console.log(val);
					var floor = val.roomNo.substring(0,2).toString();
					if(floorNo==floor){
						//请求类型数组
						var roomservs = [];
						roomservs = getRoomservs(val.reqServ);
						var roomElement = $("li#"+ val.roomNo);
						$roomcontainer.find(roomElement).attr('title','request totals '+ roomservs.length).html(roomservs.length);
						console.log("roomNo:"+ val.roomNo);
						serviceTotals += roomservs.length;
					}
				});
				$headtitle.text("待处理请求服务总数："+ serviceTotals +"");
				selectFloor();
			});
		};
		
		//sos紧急事件
		var sos = function() {
			console.log("reqtype name sos");
			var html = "";
			$.each(floors,function(index,floorNo){
				
			});
			
			$headtitle.text("SOS总数：2");
			
			html += "<div class='span2'>";
			html += "<div class='pull-left'>";
			html += "<label><h4>F16</h4> </label>";
			html += "<div class='tile-large'>";
			html += "<div class='tile-large-list'><ul>";
			html += "<li class='tile bg-color-white border-color-blue bg-color-yellow'><p><i class='icon-user'></i> 0101</p><h3 class='text-error'>SOS</h3></li>";
			html += "<li class='tile bg-color-white border-color-blue bg-color-yellow'><p><i class='icon-user'></i> 0102</p><h3 class='text-error'>SOS</h3></li>";
			html += "</ul></div>";
			html += "</div>";
			
			html += "</div>";
			html += "</div>";
			
			$roomcontainer.html(html);
		};
		
		//选择客户
		var selectFloor = function() {
			$roomcontainer.find(".tile-small").click(function(){
				$(this).addClass('selected');
			});
		};
		//所有请求
		var all = function() {
			var html = "";
			$.each(floors,function(index,floorNo){
				var i = colors.length>index?index:colors.length-index;
				html += "<div class='span2'>";
				html += "<div class='pull-left'>";
				html += "<label><h4>F"+ floorNo +"</h4> </label>";
				html += "<div class='tile bg-color-"+colors[i] +"'>";
				html += "<div class='tile-small'><ul class='tile-smaill-list'>";
				$.each(items,function(key,val){
					var floor = val.roomNo.substring(0,2).toString();
					if(floorNo==floor){
						html += "<li id='"+ val +"'>"+ val.roomNo.substring(2).toString() +"</li>";
					}
				});
				html += "</ul></div>";
				html += "</div>";
				
				
				html += "</div>";
				html += "</div>";
			});
			$roomcontainer.html(html);
		};

		//服务请求类型有
		var getRoomservs = function(reqServ) {
			var roomservs = [];
			if (reqServ & 1) 
				roomservs.push("订餐");
			if (reqServ & 2) 
				roomservs.push("收餐盘");
			if (reqServ & 4)
				roomservs.push("管家服务");
			if (reqServ & 8)
				roomservs.push("叫服务员");
			if (reqServ & 16)
				roomservs.push("叫经理");
			if (reqServ & 32)
				roomservs.push("擦鞋");
			if (reqServ & 64)
				roomservs.push("毛巾");
			if (reqServ & 128)
				roomservs.push("浴巾");
			if (reqServ & 256)
				roomservs.push("纸巾");
			if (reqServ & 512)
				roomservs.push("遥控器");
			if (reqServ & 1024)
				roomservs.push("插线板");
			if (reqServ & 2048)
				roomservs.push("");
			return roomservs;
		};
	}	
		
};

uniform = {
	init:function(){
		$(".checkbox").uniform();
	}	
};
/* [ ---- service manage javascript ---- ] */

var console=console||{"log":function(){}};

$(document).ready(function() {
	
	services.requests();  //必须放在第一行
	services.forward();
	hvac.forward();

	uniform.init();
	
	 $(window).unload(function() {
		 console.log('page unload');
	 });
});

//HVAC操作
var hvac = {
	//页面首次加载时，默认选择列表第一项;刷新重载时，定位在刷新前的选择位置。
	forward:function() {
		//当前页面路径
		var pathname = window.location.pathname;
		//用户管理员路径
		var hvacPath = contextPath+"service/hvac";
		
		if(pathname==hvacPath) {
			var activeli = $("#reqtype .active");		

			console.log($.cookie('reqtype_selecteditem'));
			console.log($.cookie('reqtype_urlpath'));
			
			var cookieReqType = $.cookie('reqtype_selecteditem');
			var cookieUrlPath = $.cookie('reqtype_urlpath');
			
			if(cookieUrlPath!=null && cookieUrlPath==hvacPath) {
				if(cookieReqType!=null) {
					$("#"+ cookieReqType).addClass('active');
					$("#"+ cookieReqType).click();
				} else {
					$("#reqtype li:first").addClass('active');
					$("#reqtype li:first").click();
				}
			}else {
				$("#reqtype li:first").addClass('active');
				$("#reqtype li:first").click();
				$.cookie('reqtype_urlpath',hvacPath);
				$.cookie('reqtype_selecteditem',$("#reqtype li:first").attr("id"));
			}
			
		}
	}

};

//Request Services
var services = {
	//页面首次加载时，默认选择列表第一项;刷新重载时，定位在刷新前的选择位置。
	forward:function() {
			//当前页面路径
			var pathname = window.location.pathname;
			//用户管理员路径
			var urlpath = contextPath+"service/requests";
			
			if(pathname==urlpath) {
					
				//console.log($.cookie('reqtype_selecteditem'));
				//console.log($.cookie('reqtype_urlpath'));
				
				var cookieReqtypeItem = $.cookie('reqtype_selecteditem');
				var cookieUrlPath = $.cookie('reqtype_urlpath');

				if(cookieUrlPath!=null && cookieUrlPath==urlpath) {
					if(cookieReqtypeItem!=null) {
						var itemid = $("#"+ cookieReqtypeItem);
						$(itemid).addClass('active');
						$("#"+ cookieReqtypeItem).click();
					} else {
						$("#reqtype li:first").addClass('active');
						$("#reqtype li:first").click();
					} 
				}else {
					$("#reqtype li:first").addClass('active');
					$("#reqtype li:first").click();
					console.log("last request service type is :" + $("#reqtype li:first"));
					$.cookie('reqtype_urlpath',urlpath);
					$.cookie('reqtype_selecteditem',$("#reqtype li:first").attr("id"));
				}
			}
	},
	requests:function(){
		
		var m_roomWrap = $("#tileWrap");
		var m_viewMode = $("#viewmode li");
		var m_tempRoomWrap = "";//m_roomWrap.html();
		var m_curFloorNo = "";
		
		//服务标题记录
		var m_headTitle = $(".service-title h4");
		
		//颜色名称
		var m_colorArray = ["green","greenLight","greenDark","red","yellow","orange","orangeDark","pink","pinkDark","purple","darken","grayDark","blue","blueLight","blueDark","green","greenLight","greenDark","","pink","pinkDark","purple","darken","grayDark","yellow","orange","orangeDark","pink"];

		/**
		 * 客房请求数据
		 * */
		var m_itemArray = [];  
		/**
		 * 所有楼层 
		 * */
		var m_floorArray = [];
		
		m_viewMode.click(function(e){
			//console.log($(this));
		});
		
		
		//根据请求类型异步获取服务请求数据
		$("ul#reqtype > li").click(function(){
			//获取请求类型
			var m_reqtype = $(this).attr("type");
			console.log("current service request type : " + m_reqtype);
			
			$.cookie('reqtype_selecteditem',$(this).attr("id"));
			$.cookie('reqtype_urlpath',window.location.pathname);
			
			//set the active style class name
			$(this).parent().children().removeClass('active'); 
			$(this).addClass("active");
			
			//没有类型,则返回提示信息
			if(typeof(m_reqtype)=='undefined' || m_reqtype=="") {
				$.sticky("service type attribute not undefined!", {autoclose : 5000, position: "top-right", type: "st-error" });
				return;
			}
			
			/*
			 * 通过REST服务获取指定类型的客房请求数据
			 * @param type 请求数据类型
			 */
			$.getJSON(contextPath+"service/roomviews",{type:m_reqtype},function(data){
				m_itemArray.length = 0;
				m_floorArray.length = 0;
				
				
				//未联系服务异常处理
				var refused = false;
				if(data!=null && data.length>0 && data.length<3) {
					$.each(data,function(key,obj){
						if(typeof obj.error !='undefined') {
							refused = true;
							m_headTitle.text(obj.error);
							console.log("remote request error message:"+ obj.error);
							$("#conn-status").removeClass("icomoon-link").addClass("icomoon-link-2").attr('title',"未连接到服务器");
							return;
						}
					});
				}
				//服务请求
				if(!refused) {
					$.each(data, function(key, val) {
					    m_itemArray.push(val);
					    //取房间编前前两位作为楼层编号
						var floorNo = val.roomNo.substring(0,2).toString();
						m_floorArray.push(floorNo);
					  });
					$.unique(m_floorArray);
					$.unique(m_floorArray); //去除重复的楼层
					m_floorArray.sort(); //楼层排序
					console.log("Requesting build floor list : "+ m_floorArray.join(","));
	
					switch (m_reqtype) {
						case '1':   //服务请求
							services();
							break;
						case '4':
							services();
							break;
						case '21':
							services();
							break;
						case '2':  //SOS紧急事件
							sos();
							break;
						case '1024':  //保洁
							cleaning();
							break;
						case '8':  //HVAC
							hvac();
							break;
						case '64':  //门磁
							doorAlarm();
							break;
						case '128':  //窗磁
							windowAlarm();
							break;
						case '65535':
							floorHeating();
							break;
						case '121':
							emtRoom();
							break;
						}
				}
			});

		});
		
		
		//请求服务
		var services = function() {
			//m_roomWrap.empty();
			//m_roomWrap.html(m_tempRoomWrap);
			var serviceTotals = 0;
			
			$("#thumbnail").parent().children().removeClass("active");
			$("#thumbnail").addClass("active");
			
			//服务请求选择列表
			$("#lease_nav").show();
			$("#reqlist_nav").show();
			
			//定义显示,先楼层，再房间
			var html = "";
			$.each(m_floorArray,function(index,floorNo){

				//显示请求客房服务
				var roomservs = [];
				//定义楼层服务数组
				var floorservs = [];
				//设置每个房间属性
				$.each(m_itemArray,function(key,roomVal){
					//console.log(roomVal);
					var currFloorNo = roomVal.roomNo.substring(0,2).toString();
					if(floorNo==currFloorNo){
						var roomElement = $("li#"+ roomVal.roomNo);
						//请求类型数组
						if(roomVal.reqServ>0) {
							roomservs = getRoomservs(roomVal.reqServ);  //服务请求类型
							m_roomWrap.find(roomElement).attr('title','request totals '+ roomservs.length).html(roomservs.length);
							console.log("房间'"+roomVal.roomNo + "'请求服务对象:"+ roomservs);
						}
						var commerr = "";
						if(typeof roomVal.commerr !='undefined') {
							if(roomVal.commerr>0) {
								commerr = "bg-color-grayDark";
								roomElement.addClass(commerr);
							}
						}
						if(commerr.length==0){
							if(typeof roomVal.rentState !='undefined') {
								//租赁状态0=待租状态1=出租状态2=退房状态3=空置状态4=预订状
								switch(roomVal.rentState) {
								case '0':
									roomElement.addClass('bg-color-green');
									break;
								case '1':
									roomElement.addClass('bg-color-blueLight');
									break;
								case '2':
									roomElement.addClass('bg-color-yellow');
									break;
								case '3':
									roomElement.addClass('bg-color-white');
									break;
								case '4':
									roomElement.addClass('bg-color-pinkDark');
									break;
								default:
									break;
								}
							}
						}
						serviceTotals += roomservs.length;
						floorservs.push({"roomNo":roomVal.roomNo,"services":roomservs});
						
						
					}
				});
				m_headTitle.text("待处理请求服务总数："+ serviceTotals +"");
				selectFloor(floorservs);
				
			});
		};
		
		/**
		 * 保洁
		 * */
		var cleaning = function() {

			//转到请求明细页
			$(".main_content_sidebar").load(contextPath+'service/cleaning',function(response, status, xhr) {
				if (status == "error") {
					
				 } else if (status="success") {
					/* $.each(floorservs,function(index,obj){

						 $.each(obj.services,function(index,serv){
							 $("<li>").text(serv).appendTo("#room_"+obj.roomNo+" .service-list");
							 $("#room_"+obj.roomNo).addClass("bg-color-blueLight");
							 
						 });
					 });*/

					 
				 }
			});
		};
		
		
		//sos紧急事件
		var sos = function() {
			$("#lease_nav").show();
			$("#reqlist_nav").hide();
			
			$.each(m_floorArray,function(index,floorNo){
				
			});

			m_roomWrap.load(contextPath+'service/sos',function(response, status, xhr) {
				if (status == "error") {
					
				 } else if (status="success") {
					/* $.each(floorservs,function(index,obj){

						 $.each(obj.services,function(index,serv){
							 $("<li>").text(serv).appendTo("#room_"+obj.roomNo+" .service-list");
							 $("#room_"+obj.roomNo).addClass("bg-color-blueLight");
							 
						 });
					 });*/ 
				 }
			});
			
/*			
			m_headTitle.text("SOS总数：2");
			
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
			
			m_roomWrap.html(html);*/
		};
		
		//选择楼层
		var selectFloor = function(floorservs) {
			
			//点击缩略图磁贴，加载并设置对应楼层的房间状态
			m_roomWrap.find(".tile-small").click(function(){
				$(this).addClass('selected');
				//获取当前楼层ID
				var curFloorId = $(this).attr("id");
				var curFloorNo = $(this).attr("floorno");
				console.log("Line161 当前操作楼层ID:"+ curFloorId + " NO:"+ curFloorNo);
				//
				$("#viewmode li").removeClass("active");
				$("#details").addClass("active");
				
				 //楼层间切换
				 $("a[rel=popover]").click(function(e){
					 var id = $(this).text();
					 $(this).parent().parent().children().removeClass("active");
					 $(this).parent().addClass("active");
					 console.log($(this));
					 var cont = $(this).parent().find("#cont_"+ id).html();
					 $("#floors-nav").html(cont);
				 });
				 
				 floorDetails(curFloorId,curFloorNo,floorservs);
			});
		};
		/**
		 * 设置楼层明细
		 * @param floorId 楼层ID
		 * @param floorNo 楼层编号
		 * */
		var floorDetails = function(floorId,floorNo,floorservs) {		
			//转到请求明细页
			m_roomWrap.load(contextPath+'service/requests/details/'+floorId,function(response, status, xhr) {
				if (status == "error") {
					
				 } else if (status="success") {
					 $.each(floorservs,function(index,obj){

						 $.each(obj.services,function(index,serv){
							 $("<li>").text(serv).appendTo("#room_"+obj.roomNo+" .service-list");
							 $("#room_"+obj.roomNo).addClass("bg-color-blueLight");
							 
						 });
					 });
					 m_curFloorNo = floorNo;
					 floorNavigation();
					 
				 }
			});
		};
		
		//设置楼层导航条
		var floorNavigation = function(curFloorId) {
			//所有楼层
			var lis = $("#floors-nav div li");
			
			$.each(lis,function(index,li){
				var txt = $(li).find('a').text();
				$(li).removeClass("active");
				//设置当前楼层No对应的样式
				if(txt==m_curFloorNo) {
					$(li).addClass("active");

					var parentDiv = $(li).parent().parent();
					$(parentDiv).parent().children().hide();
					$(parentDiv).show();
					
					var floorSectionId = parentDiv.attr("id").replace("cont_","");
					console.log("floor Section Id is "+ floorSectionId);
					$("#"+floorSectionId).parent().children().removeClass("active");
					$("#"+floorSectionId).addClass("active");
					
					console.log(parentDiv.attr("id"));
				}
				
			});
			
			
			$("#floorSections li").click(function(e){
				console.log($(this));
				$(this).parent().children().removeClass("active");
				$(this).addClass("active");
				
				$("#floors-nav div").hide();
				$("#cont_"+ $(this).attr("id")).show();
				
			});
			
		};
		
		/**
		 * HVAC说明：
		 * m_fTempSetting;		//温度设定值
		 * m_fTemp;				//温度值
	     * m_nFanSpeed;			//风速0=停1=低2=中3=高
		 * m_nVal;					//阀门状态0=送风/无阀1=冷2=热3=无效
		 * m_nFanAutoMode;			//风机模式0=手动1=自动
		 * m_nWinterSeason;		//季节模式0=夏季模式1=冬季模式
		 * m_nFanPowerOn;			//风机开关控制0=电源关闭1=电源开启
		 * */
		var hvac = function() {
			$("#temp_nav").show();
			$("#hvac_nav").show();
			
			var tiles = $(".thumbnails .tile-large");
			
			$.each(m_itemArray,function(key,roomVal){
				var tile = $(tiles).find("li#"+ roomVal.roomNo);
				$(tile).find(".tile-text").text(roomVal.hvTemp0+"°/"+roomVal.hvTempSet0+"°");
				//hvFanPower0  风机开关控制  0=电源关闭1=电源开启
				if(roomVal.hvFanPower0==0) {
					$(tile).addClass('bg-color-white').attr('style','border:1px solid #ccc;');
					$(tile).find(".tile-badge").removeClass('fg-color-white').text("OFF");
					$(tile).find(".tile-caption").removeClass('fg-color-white');
				} else {
					$(tile).removeClass('fg-color-white');
					//手动与自动控制
					if(roomVal.hvFanAuto0==1) {
						$(tile).find(".tile-badge").text("AUTO");
					}
					//季节
					if(roomVal.hvSeason0==0) {
						
					}
					//阀门状态
					if(roomVal.hvVal0==1) {  //冷
						$(tile).addClass('bg-color-blue');
					} else if (roomVal.hvVal0==2) { //热
						$(tile).addClass('bg-color-red');
						console.log("heat");
					} else if (roomVal.hvVal0==3) { //无效
						
					} else {  //送风/无阀
						
					}
					
					
				}
						
			});
			
			m_roomWrap.find(".tile").toggle(
				function(){
					$(this).addClass('selected');
				},function(){
					$(this).removeClass('selected');
				});
		};
		
		//门磁报警
		var doorAlarm = function() {
			$("#lease_nav").show();
			$("#reqlist_nav").hide();
			
			$(m_roomWrap).empty();
			
			
		};
		//窗磁报警
		var windowAlarm = function() {
			$("#lease_nav").show();
			$("#reqlist_nav").hide();
			$(m_roomWrap).empty();
			
		};
		
		//地址加热
		var floorHeating = function() {		
			$("#lease_nav").hide();
			$("#reqlist_nav").hide();
			$("#temp_nav").show();
		
			//$(m_roomWrap).empty();	
		
			console.log("current request page is :"+ contextPath+"service/heating");

			//转到请求明细页
			m_roomWrap.load(contextPath+'service/heating',function(response, status, xhr) {
				if (status == "error") {
					
				 } else if (status="success") {
					/* $.each(floorservs,function(index,obj){

						 $.each(obj.services,function(index,serv){
							 $("<li>").text(serv).appendTo("#room_"+obj.roomNo+" .service-list");
							 $("#room_"+obj.roomNo).addClass("bg-color-blueLight");
							 
						 });
					 });*/

					 
				 }
			});
			
		};
		
		//EMT参考房间
		var emtRoom = function() {
			$("#lease_nav").hide();
			$("#reqlist_nav").hide();
			$("#temp_nav").show();
			
			
			//转到请求明细页
			m_roomWrap.load(contextPath+'service/heating',function(response, status, xhr) {
				if (status == "error") {
					
				 } else if (status="success") {
					/* $.each(floorservs,function(index,obj){

						 $.each(obj.services,function(index,serv){
							 $("<li>").text(serv).appendTo("#room_"+obj.roomNo+" .service-list");
							 $("#room_"+obj.roomNo).addClass("bg-color-blueLight");
							 
						 });
					 });*/

					 
				 }
			});
		};
		
		//所有请求
		var all = function() {
			var html = "";
			$.each(m_floorArray,function(index,floorNo){
				var i = m_colorArray.length>index?index:m_colorArray.length-index;
				html += "<div class='span2'>";
				html += "<div class='pull-left'>";
				html += "<label><h4>F"+ floorNo +"</h4> </label>";
				html += "<div class='tile bg-color-"+m_colorArray[i] +"'>";
				html += "<div class='tile-small'><ul class='tile-smaill-list'>";
				$.each(m_itemArray,function(key,val){
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
			m_roomWrap.html(html);
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
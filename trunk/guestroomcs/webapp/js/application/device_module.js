/* [ ---- DEVICE MODULE ---- ] */

var console=console||{"log":function(){}};


//这里在页面载入时执行
$(document).ready(function() {
	//调用定义的方法
	device_module.init();
	device_module.clickRow();
});


var properties = $("#accordion"),
	moduleRows = $("#modules > tbody > tr"),
	propContainer = $("#propContainer"),
	moduleRowCheckbox = $("#modules > tbody > tr").find(":checkbox");
	

/*设备模块*/
var device_module = {
	//初始化时
	init : function() {
		$(properties).hide();
		var rownum = $(moduleRows).length;
		var moduleinfo = "<div id='moduleinfo'><h3>"+ rownum+"项</h3></div>";
		$(propContainer).append(moduleinfo);
	},
	//选择所有行
	checkall : function() {
		
	},
	//点击行事件,显示属性
	clickRow : function() {;
		$(moduleRows).click(function(e){
			//移除信息
			$("#moduleinfo").remove();
			//显示属性
			$(properties).show();
			$(moduleRowCheckbox).attr('checked',false);
			$(moduleRows).find(".checker span.checked").removeClass('checked');

			$(this).find(":checkbox").attr('checked',true);
			$(this).find(".checker span").addClass("checked");

		});
		
		
	}
};









//定义一个类
userlist_opt = {
	//定义一个方法
	click : function() {
		$("#userlist li").click(function() {
			// 选择多个人员时,内容区显示选择的人员列表
			// 选择单个人员时,加载人员信息页
			//alert($(this).find('span').text());
			var username = $(this).find('span').text();
			var cb = $(this).find(":checkbox")[0];
			if (cb.checked == false) {
				$(this).parent().find(':checkbox').attr('checked', false);
				$(this).parent().children().removeClass('active');
				$(this).addClass("active");
				$(".main_content .heading").text(username);
			} else {
				var cklen = $(this).parent().find('input:checked').length;
				$(".main_content .heading").text("已选择"+ cklen +"个联系人");
				
				$(this).addClass("active");
			}
		});
	}
};


/* [ ---- user manage javascript ---- ] */


//这里在页面载入时执行
$(document).ready(function() {
	//调用定义的方法
	userlist_opt.click();
});

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


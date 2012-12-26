/* [ ---- user manage javascript ---- ] */

$(document).ready(function() {
	userlist_opt.init();
	userlist_opt.select();
	userlist_opt.operate();
	userlist_opt.edit();
	user_validation.ttip();
});

//用户列表操作
var userlist_opt = {
	//初始化
	init:function() {
		//页面跳转后重新选择
		if($.cookie('userlist_selecteditem')!=null) {
			var selId = $.cookie('userlist_selecteditem');
			$("#"+selId).addClass("active");
			$.cookie('userlist_selecteditem',null);
			
			var username = $("#"+selId).find('span').text();
			var userId = $("#"+selId).find(":checkbox")[0].value;
			
			$(".main_content .heading").remove();
			$("<h4 class='heading'>"+ username +"</h4>").insertBefore("#loaduserinfo");
			
			//清除所有HTML元素
			$("#loaduserinfo").empty();
			//异步加载查看页
			$("#loaduserinfo").load(contextPath+'user/users/view/'+userId,function(response, status, xhr) {
				if (status == "error") {
					alert();
				 } else if (status="success") {
					$("#user_edit").show();
					$("#user_copy").show();
					$("#user_delete").show();
					$("#user_setstatus").show();
				 }
			});
		}
	}, 
	//选择用户
	select : function() {
		//当前页面路径
		var pathname = window.location.pathname;
		//用户管理员路径
		var usersPath = contextPath+"user/users";
		
		//隐藏编辑、复制、删除、状态设置按钮,只有选择了用户才显示
		$("#user_add").show();
		$("#user_edit").hide();
		$("#user_copy").hide();
		$("#user_delete").hide();
		$("#user_setstatus").hide();
		

		//点击用户列表事件
		$("#userlist li").click(function() {
			// 选择多个人员时,内容区显示选择的人员列表
			// 选择单个人员时,加载人员信息页
			var username = $(this).find('span').text();
			var cb = $(this).find(":checkbox")[0];
			//如果不是在user/users 页上选择用户，记录当前选择的元素ID
			if(pathname!=usersPath) {
				$.cookie('userlist_selecteditem',$(this).attr("id"));
				 window.location.href = usersPath;
			}

			//显示编辑、复制、删除、状态设置按钮
			$("#user_add").show();
			$("#user_edit").show();
			$("#user_copy").show();
			$("#user_delete").show();
			$("#user_setstatus").show();
			
			$("#error-info").remove();
			
			//如果选择人员时显示人员信息
			if (cb.checked == false) {
				$(this).parent().find(':checkbox').attr('checked', false);
				$(this).parent().children().removeClass('active');
				$(this).addClass("active");
				$(".main_content .heading").remove();
				$("<h4 class='heading'>"+ username +"</h4>").insertBefore("#loaduserinfo");
				
				//清除所有HTML元素
				$("#loaduserinfo").empty();
				//异步加载查看页
				$("#loaduserinfo").load(contextPath+'user/users/view/'+cb.value,function(response, status, xhr) {
					  if (status == "error") {
						  alert();
					  }
				});
				
			} else {
				$("#user_edit").hide();
				$("#user_copy").hide();
				
				var ckusers =  $(this).parent().find('input:checked');
				$(".main_content .heading").remove();
				$("<h4 class='heading'>已选择"+ ckusers.length +"个联系人</h4>").insertBefore("#loaduserinfo");
				$(this).addClass("active");
				
				$("#loaduserinfo").empty();
				var html = "<ul class=\"thumbnails\">";
				$.each(ckusers,function(index,val){
					var name = $(this).parent().find('span').text();
					html +="<li class=\"span2\"><a href='javascript:void(0);' class=\"thumbnail\">";
					html +="<div class=\"caption\"><span class='pull-left'>"+ name +"</span>" +
							"<span class='pull-right'><input type='checkbox' checked='true' value='"+ val.value +"' /></span>" +
							"</div>";
					html += "<img src='/guestroomcs/img/metro_user.png' width='170' height='170' />";
					html += "<p></p>";
					html += "</a></li>";
				});
				html +="</ul>";
				$("#loaduserinfo").html(html);
			}
		});
	},
	//用户操作
	operate : function() {
		
		//新增用户
		$("#user_add").click(function(){

			$("#user_add").hide();
			$("#user_manage").hide();
			$("#user_edit").hide();
			$("#user_copy").hide();
			$("#user_delete").hide();
			$("#user_setstatus").hide();
			
			$(".main_content .heading").remove();
			$("#loaduserinfo").load(contextPath+'user/users/add',function(response, status, xhr) {
				  if (status == "error") {
					  alert('user add form loadd fail');
				  }
				  user_validation.ttip();
				  removeMenuItem();
			});
		});
		//编辑用户
		$("#user_edit").click(function(){

			$("#user_add").hide();
			$("#user_manage").hide();
			$("#user_edit").hide();
			$("#user_copy").hide();
			$("#user_delete").hide();
			$("#user_setstatus").hide();
			
			var userId = $("#userId").val();
			//选择单个用户
			if(typeof(userId)!='undefined') {
				//异步加载编辑页
				$(".main_content .heading").remove();
				$("#loaduserinfo").load(contextPath+'user/users/edit/'+userId,function(response, status, xhr) {
					  if (status == "error") {
						  alert('user edit form loadd fail');
					  }
					  user_validation.ttip();
					  $("#username").attr("disabled","disabled");
					  
					  removeMenuItem();			  
				});
			}
		});
		
		/**
		 * 移除菜单项方法
		 * */
		var removeMenuItem = function() {
			//设置联系信息新增按钮隐藏项
			var formRows = $("#user > .formRow > div");
			//所有联系信息新增按钮对应的菜单条目项
			var menuEntries = $(".menu-entry a");
			$.each(formRows,function(index,row){
				var rowtype = $(row).attr("type");
				if(rowtype!=null && rowtype=='list') {
					//查找非隐藏项
					if(!$(row).is(":hidden") ) {
						console.log($(row).attr("id"));
						var rowId = $(row).attr("id");
						$.each(menuEntries,function(i,menuitem){
							var menuEntryId = $(menuitem).attr("id");
							//移除已经显示的菜单条目
							if(rowId==menuEntryId) {
								$(menuitem).parent().remove();
							}
						});
					}
				}
			});
		}
		
		
		//删除用户确认提示
		$("#user_delete").click(function(){
			var userId = $("#userId").val();
			var username = "";
			var usernames = [];
			if(typeof(userId)!='undefined') {
				username = $(".main_content .heading").text();
				$("#userDelModal .modal-body .lead").text(username);
			} else {
				$(".thumbnail").each(function(){
					username = $(this).find(".pull-left").text();
					usernames.push(username);
				});
				$("#userDelModal .modal-body .lead").text(usernames.join(","));
			}
			$("#userDelModal").modal('show');

		});
		//执行用户删除
		$("#btn-delete").click(function(){
			var url = $(this).attr('url');
			var userId = $("#userId").val();
			//删除单个用户
			if(typeof(userId)!='undefined') {
				$.post(url,{userId:userId},function(result){	
					
				}).success(function(msg){	
					$("#userlist li.active").remove();
					$.sticky("remove user successfule!", {autoclose : 5000, position: "top-right", type: "st-success" });		
				}).error(function(msg){
					alert(msg);
				});
			} else {
				//同时删除多个用户
				var userids = [];
				$(".thumbnail").each(function(){
					var id  = $(this).find("input:checked").val();
					userids.push(id);
				});
				//alert(userids.join(","));
				$.post(url,{userId:userids.join(",")},function(result){	
				}).success(function(msg){	
					$("#userlist li.active").remove();
					$(".thumbnails")
					$.sticky("remove users successfule!", {autoclose : 5000, position: "top-right", type: "st-success" });		
				}).error(function(msg){
					var msg = "";
					$.each(msg,function(index,txt){
						msg += txt;
					});
					alert("error:"+ msg);
				
				});
			}
			$("#userDelModal").modal('hide');
			
		});
		
	
		
		//为动态元素添加事件
		$("#user_pic").live('click',function(){
			var userId = $("#userId").val();
			if(typeof(userId)!='undefined') {
				$(".main_content .heading").remove();
				$("#loaduserinfo").load(contextPath+'user/users/editpic/'+userId,function(response, status, xhr) {
					  if (status == "error") {
						  
					  }
				});
			}
		});
		
		/**
		 * 验证用户是否存在
		 * */
		$("#username").live('change',function(){
			console.log('username change');
			var url = contextPath + "user/users/validusername";
			$.post(url,{username:$("#username").val()},function(result){
				if(result=='true') {
					console.log('user is exists');
					$.sticky("用户名已经存在!", {autoclose : 5000, position: "top-right", type: "st-error" });
					$("#username").closest("div.control-group").addClass("error f_error");
					$("#username").parent().find(".help-inline").text('用户名已经存在');
				} else if(result=='false') {
					$("#username").closest("div.control-group").removeClass("error f_error");
					$("#username").parent().find(".help-inline").text('');
				}
			}).success(function(msg){									
			}).error(function(msg){
				var msg = "";
				$.each(msg,function(index,txt){
					msg += txt;
				});
				alert("error:"+ msg);
			
			});
		});
		
		//为动态添加的元素绑定事件
		$(".thumbnail").live('click',function(){
			//用户ID
			var userId = $(this).find(":checkbox").val();
			//异步加载编辑页
			$("#loaduserinfo").load(contextPath+'user/users/edit/'+ userId,function(response, status, xhr) {
				  if (status == "error") {
					  alert();
				  } else if(status == "success") {
					   $("#username").attr("disabled","disabled");
					  	$("#user_add").hide();
						$("#user_manage").hide();
						$("#user_edit").hide();
						$("#user_copy").hide();
						$("#user_delete").hide();
						$("#user_setstatus").hide();
						$(".main_content .heading").remove();
						
						$("#userlist li").find(':checkbox').attr('checked', false);
						$("#userlist li").removeClass('active');
						$("#"+userId).addClass('active');					
				  }
				  console.log(status);
			});
			
		});
		
		$("#user_statuslist li").click(function(){
			var status = $(this).attr("value");	
			var initstatus = $("#status").val();
			var isSuperUser = $("#isSuperUser").val();
			console.log("is supper user："+ isSuperUser);
			if(isSuperUser=='true') {
				$.sticky("超级用户不能设置状态!",{
					autoclose : 5000,
					position : "top-right",
					type : "st-error"
				});
				return false;
			}
			console.log("init status："+ initstatus);
			if(status==initstatus) {
				console.log("状态相同,不设置");
				return false;
			}
			console.log("new status："+ status);
			$.post(contextPath+"/user/users/setstatus",{userId:$("#userId").val(),status:status},function(html){
				
			}).success(function(result){	
				if(result.success=='true') {
					$("#status").val(status);
					$.sticky("用户状态设置成功!",{
						autoclose : 5000,
						position : "top-right",
						type : "st-success"
					});
				} else {
					console.log('error:'+result.msg);
					$("#loaduserinfo").before("<div class='alert fade in' id='error-info'><button type='button' class='close' data-dismiss='alert'>&times;</button>"+ result.msg +"</div");
				}
				}).error(function(msg){
					console.log("error:"+msg);
				});
		});
	}

	//编辑信息
	,edit : function() {
		
		//点击工具条目时事件
		$(".menu-entry").live("click",function(e){
			//工具条对应的ID
			var divId = $(this).find("a").attr("id");	
			//在Form中查询与ID相配置的DIV,并设置为显示
			var divObj = $("#user").find("div#"+ divId);
			$(divObj).show();
			
			//移除当前项	
			var parent = $(this).parent().children();
			var wincommand = $(this).parent().prev();  //新增按钮
			//console.log(parent.length);
			//当所有项都显示时，隐藏新增按钮
			if(parent.length-1>0) {
				$(this).remove();
			} else {
				$(wincommand).hide();
			}
			
		});
		
	}
};

// * validation
var user_validation = {
	ttip : function() {
		var ttip_validator = $('.form_validation_ttip').validate({
			onkeyup : false,
			errorClass : 'error',
			validClass : 'valid',
			highlight : function(element) {
				$(element).closest('div').addClass("f_error");
			},
			unhighlight : function(element) {
				$(element).closest('div').removeClass("f_error");
			},
			rules : {
				emailAddress : {
					required : true,
					email : true
				},
				username : {
					required : true,
					minlength : 2
				},
				password : {
					required : true,
					minlength : 6
				},
				confirmpwd: {
					required : true,
					equalTo: "#password",
					minlength : 6
				}
			},
			submitHandler : function() {
				console.log('submit user object');
				var $form = $("#user");
				$.post($form.attr('action'),$form.serialize(),function(html){
						console.log(html);
				}).success(function(result){	
					if(result.success=='true') {
						//window.location.href = contextPath + "user/users";
					} else {
						console.log('error:'+result.msg);
						$("#loaduserinfo").before("<div class='alert fade in' id='error-info'><button type='button' class='close' data-dismiss='alert'>&times;</button>"+ result.msg +"</div");
					}
					}).error(function(msg){
					console.log("error:"+msg);
					});
					return false;
				},
				invalidHandler : function(form, validator) {
					$.sticky("There are some errors. Please corect them and submit again.",{
						autoclose : 5000,
						position : "top-right",
						type : "st-error"
					});
				},
				errorPlacement : function(error, element) {
								// Set positioning based on the elements
								// position in the form
								var elem = $(element);

								// Check we have a valid error message
								if (!error.is(':empty')) {
									if ((elem.is(':checkbox'))
											|| (elem.is(':radio'))) {
										// Apply the tooltip only if it isn't
										// valid
										elem
												.filter(':not(.valid)')
												.parent('label')
												.parent('div')
												.find('.error_placement')
												.qtip(
														{
															overwrite : false,
															content : error,
															position : {
																my : 'left bottom',
																at : 'center right',
																viewport : $(window),
																adjust : {
																	x : 6
																}
															},
															show : {
																event : false,
																ready : true
															},
															hide : false,
															style : {
																classes : 'ui-tooltip-red ui-tooltip-rounded' // Make
															// it
															// red...
															// the
															// classic
															// error
															// colour!
															}
														})
												// If we have a tooltip on this
												// element already, just update
												// its content
												.qtip('option', 'content.text',
														error);
									} else {
										// Apply the tooltip only if it isn't
										// valid
										elem
												.filter(':not(.valid)')
												.qtip(
														{
															overwrite : false,
															content : error,
															position : {
																my : 'bottom left',
																at : 'top right',
																viewport : $(window),
																adjust : {
																	x : -8,
																	y : 6
																}
															},
															show : {
																event : false,
																ready : true
															},
															hide : false,
															style : {
																classes : 'ui-tooltip-red ui-tooltip-rounded' // Make
															// it
															// red...
															// the
															// classic
															// error
															// colour!
															}
														})
												// If we have a tooltip on this
												// element already, just update
												// its content
												.qtip('option', 'content.text',
														error);
									}
									;
								}
								// If the error is empty, remove the qTip
								else {
									if ((elem.is(':checkbox'))
											|| (elem.is(':radio'))) {
										elem.parent('label').parent('div')
												.find('.error_placement').qtip(
														'destroy');
									} else {
										elem.qtip('destroy');
									}
								}
							},
							success : $.noop
						// Odd workaround for errorPlacement not firing!
						})
	}
};
/* [ ---- roles manage javascript ---- ] */

$(document).ready(function() {

	rolelist_opt.operate();
	resource.methods();
	role_validation.ttip();
});

//用户列表操作
rolelist_opt = {
	//用户操作
	operate : function() {
		
		//当前页面路径
		var pathname = window.location.pathname;
		//用户管理员路径
		var addpath = contextPath+"user/roles/add";
		
		console.log(pathname);
		console.log(addpath);
		
		/**
		 * 新增角色时不显示工具栏
		 * */
		if(pathname==addpath) {
			$("#role-nav").hide();
		}
			
		//删除角色确认提示
		$("#role_delete").click(function(){
			var roleDesc = $("#roleDesc").val();
			$("#roleDelModal .modal-body .lead").text(roleDesc);
			$("#roleDelModal").modal('show');
		});
		
		//执行角色删除
		$("#btn-delete").click(function(){
			var url = $(this).attr('url');
			var roleId = $("#roleId").val();
			$.post(url,{roleId:roleId},function(result){	
				if(result.success=='true') {
					$("#rolelist li.active").remove();
					$.sticky("remove role success!", {autoclose : 5000, position: "top-right", type: "st-success" });	
					var secondUrl = $("#rolelist li:eq(1) a").attr('href');
					window.location.href = secondUrl;
					console.log($("#rolelist li:eq(1) a").attr('href'));
				} else {
					$(".main_content form:first-child").before("<div class='alert fade in'><button type='button' class='close' data-dismiss='alert'>&times;</button>"+ result.msg +"</div");
				}
			}).success(function(msg){	
						
			}).error(function(msg){
				alert(msg);
			});
			$("#roleDelModal").modal('hide');
		});
		
	
		/**
		 * 验证用户是否存在
		 * */
		$("#roleName").bind('change',function(){
			console.log('roleName change');
			var url = contextPath + "user/roles/validroleinfo";
			$.post(url,{roleName:$("#roleName").val()},function(result){
				if(result.success=='false') {
					console.log('roleName is exists');
					$.sticky("权限组已经存在!", {autoclose : 5000, position: "top-right", type: "st-error" });
					$("#roleName").closest("div.control-group").addClass("error f_error");
					$("#roleName").parent().find(".help-inline").text('权限组已经存在');
				} else if(result.success=='true') {
					$("#roleName").closest("div.control-group").removeClass("error f_error");
					$("#roleName").parent().find(".help-inline").text('');
				}
			}).success(function(msg){									
			}).error(function(msg){
				//alert("error:"+ msg);
			});
		});
		
/*		*//**
		 * 提交新增表单
		 * *//*
		$("#role").submit(function(){
			console.log("submit to :" + $(this).attr('action'));
			
		});*/
		
		
	}
};
/**
 * 角色资源操作
 * */
resource = {
	methods:function(){
		$("#resource-list li").click(function(){
			//console.log($(this).attr("id"));
			var resId = $(this).attr("id").replace('res_','');
			var remoteUrl = contextPath + "/user/roles/methodsofresource";
			console.log(resId);
			$.get(remoteUrl,{resourceId:resId},function(html){
				
			}).success(function(result){
				var $methodlist = $("#authority-method-list li:last");
				$.each(result,function(index,entry){
					if($("#authority-method-list").find("#method_"+ entry.resourceId +"").length==0) {
						$methodlist.after("<li id='method_"+ entry.resourceId +"'>" +
								"<a href='javascript:void(0);'><span class='span10'>"+ entry.resourceName +"</span> " +
								"<span class='span2'><input type='checkbox' name='resourcelist["+index+"].resourceId' value='"+ entry.resourceId +"' />" +
								"</span></a></li>");
					}
				});
			}).error(function(result){
				
			});
			
		});
	}
};

// * validation
role_validation = {
	ttip : function() {
		var ttip_validator = $('.form_validation_ttip')
				.validate(
						{
							onkeyup : false,
							errorClass : 'error',
							validClass : 'valid',
							highlight : function(element) {
								$(element).closest('div').addClass("f_error");
							},
							unhighlight : function(element) {
								$(element).closest('div')
										.removeClass("f_error");
							},
							rules : {
								roleName : {
									required : true,
									minlength : 4
								},
								roleDesc : {
									required : true,
									minlength : 3
								}
							}, //提交表单
							submitHandler : function(){
								var $form = $("#role");
								console.log("submit to :" + $form.attr('action'));
								$.post($(this).attr("action"), $form.serialize(), function(html) {		
								}).success(function(result){	
									if(result.success=='true') {
										//当前页面路径
										var pathname = window.location.pathname;
										//新增资源路径
										var addpath = contextPath+"user/roles/add";
										if(pathname==addpath) {
											window.location.href = contextPath + "user/roles/edit/"+result.msg;
										} 
										$(".main_content form:first-child").before("<div class='alert fade in '><button type='button' class='close' data-dismiss='alert'>&times;</button>success!</div");
									} else {
										$(".main_content form:first-child").before("<div class='alert fade in'><button type='button' class='close' data-dismiss='alert'>&times;</button>"+ result.msg +"</div");
									}
								}).error(function(msg){
									console.log("error:"+msg);
								});
								return false;
							},
							invalidHandler : function(form, validator) {
								$.sticky(
												"There are some errors. Please corect them and submit again.",
												{
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
/* [ ---- resource manage javascript ---- ] */

$(document).ready(function() {

	resource_opt.operate();
	resource_validation.ttip();
});

//资源操作
var resource_opt = {
	//用户操作
	operate : function() {
		
		//当前页面路径
		var pathname = window.location.pathname;
		//新增资源路径
		var addpath = contextPath+"user/resources/add";
		//资源列表路径
		var listpath = contextPath+"user/resources";
		var listpath2 = contextPath+"user/resources/";

		
		/**
		 * 新增角色时不显示工具栏
		 * */
		if(pathname==addpath) {
			$("#resource-nav").hide();
		} else if (pathname==listpath || pathname==listpath2) {
			$("#resource-edit").hide();
			$("#resource-delete").hide();
		}
			
		//删除角色确认提示
		$("#resource-delete").click(function(){
			var resourceName = $("#resourceName").val();
			$("#resourceDelModal .modal-body .lead").text(resourceName);
			$("#resourceDelModal").modal('show');
		});
		
		//执行角色删除
		$("#btn-delete").click(function(){
			var url = $(this).attr('url');
			var resourceId = $("#resourceId").val();
			$.post(url,{resourceId:resourceId},function(result){	
				if(result.success=='true') {
					$("#resource-tree li.active").remove();
					$.sticky("remove role success!", {autoclose : 5000, position: "top-right", type: "st-success" });	
					var secondUrl = $("#resource-tree li:eq(1) a").attr('href');
					window.location.href = secondUrl;
					console.log($("#rolelist li:eq(1) a").attr('href'));
				} else {
					$(".main_content form:first-child").before("<div class='alert fade in'><button type='button' class='close' data-dismiss='alert'>&times;</button>"+ result.msg +"</div");
				}
			}).success(function(msg){	
						
			}).error(function(msg){
				alert(msg);
			});
			$("#resourceDelModal").modal('hide');
		});
		
		//方法组表单clone
		 $('#resourcelist').sheepIt({
		        separator: '',
		        allowRemoveLast: true,
		        allowRemoveCurrent: true,
		        allowRemoveAll: true,
		        allowAdd: true,
		        allowAddN: true,
		        maxFormsCount: 20,
		        minFormsCount: 0,
		        iniFormsCount: 2,
		      	data:methodsdata
		   });
	}
};

// * validation
var resource_validation = {
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
								resourceName : {
									required : true,
									minlength : 2
								},
								resourceType  : "required",
								resourceString : "required",
								priority : {
									required : true,
									number: true,
									min: 0,
									max:100
								},								
								status : "required"
							},
							submitHandler : function(){
								var $form = $("#resource");
								console.log("submit to :" + $form.attr('action'));
								
								$.post($form.attr("action"), $form.serialize(), function(result) {
									
								}).success(function(result){	
									console.log(result.success);
									console.log(result.msg);
									if(result.success=='true') {
										//当前页面路径
										var pathname = window.location.pathname;
										//新增资源路径
										var addpath = contextPath+"user/resources/add";
										if(pathname==addpath) {
											$.sticky("success",{autoclose : 5000,position : "top-right",type : "st-success"});
											window.location.href = contextPath + "user/resources/edit/"+result.msg;	
										} 
										$(".main_content form:first-child").before("<div class='alert fade in '><button type='button' class='close' data-dismiss='alert'>&times;</button>success!</div");
									} else {
										$(".main_content form:first-child").before("<div class='alert alert-block alert-error fade in '><button type='button' class='close' data-dismiss='alert'>&times;</button>"+ result.msg +"</div");
									}
									
								}).error(function(msg){
									console.log("error:"+msg);
								});
								return false;
							},
							invalidHandler : function(form, validator) {
								$.sticky("There are some errors. Please corect them and submit again.",{autoclose : 5000,position : "top-right",type : "st-error"});
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
										elem.filter(':not(.valid)').qtip({
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
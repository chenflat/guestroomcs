/* [ ---- account profile javascript ---- ] */

;
(function($, window, document, undefined) {
	var contact = {
		info : function() {
			
			//设置联系信息新增按钮隐藏项
			var formRows = $("#user > .formRow > div");
			//所有联系信息新增按钮对应的菜单条目项
			var menuEntries = $(".menu-entry a");
			$.each(formRows,function(index,row){
				var rowtype = $(row).attr("type");
				if(rowtype!=null && rowtype=='list') {
					//查找非隐藏项
					if(!$(row).is(":hidden") ) {
						//console.log($(row).attr("id"));
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
		},
		submit : function(){
			/**
			 * 提交保存交接班记录
			 * */
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
					firstName : {
						required : true
					},
					lastName : {
						required : true
					}
					
				}, //提交表单
				submitHandler : function(){
					var $form = $("#user");
					console.log("edit contact,submit to :" + $form.attr('action'));
					$.post($(this).attr("action"), $form.serialize(), function(html) {		
					}).success(function(result){	
							//console.log('edit contact,process result:'+ result);
							if(result.success=='true') {
							//当前页面路径
								$("form#user").before("<div class='alert fade in '><button type='button' class='close' data-dismiss='alert'>&times;</button>success!</div");
							} else {
								$("form#user").before("<div class='alert fade in'><button type='button' class='close' data-dismiss='alert'>&times;</button>"+ result.msg +"</div");
							}
						}).error(function(msg){
							//console.log("error:"+msg);
							$("form#user").before("<div class='alert fade in'><button type='button' class='close' data-dismiss='alert'>&times;</button>"+ msg +"</div");
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
						if ((elem.is(':checkbox'))|| (elem.is(':radio'))) {
							// Apply the tooltip only if it isn't
							// valid
							elem
							.filter(':not(.valid)')
							.parent('label')
							.parent('div')
							.find('.error_placement')
							.qtip({
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
							show : {event : false,ready : true},
							hide : false,
							style : {classes : 'ui-tooltip-red ui-tooltip-rounded' }})
							.qtip('option', 'content.text',error);
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
																}
															})

													.qtip('option', 'content.text',
															error);
										};
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

	$(window).load(function() {
	});
	$(document).ready(function() {
		contact.info();
		contact.submit();
	});
})(jQuery, window, document);

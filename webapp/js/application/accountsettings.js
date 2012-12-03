/* [ ---- account profile javascript ---- ] */

;
(function($, window, document, undefined) {
	var account = {
		profiles : function() {
			if($("#hide_userPhoto").length >0){
				$("img#userPhoto").attr('src',$("#hide_userPhoto").val());
				$("input#userPhoto").val($("#hide_userPhoto").val());
			}
			if($("#hide_defRequest").length >0){
				$("#defRequest").find("option[value='"+$("#hide_defRequest").val()+"']").attr("selected", "selected");
			} 
			if($("#hide_season").length >0){
				$("#season").find("option[value='"+$("#hide_season").val()+"']").attr("selected", "selected");		
			} 
			if($("#hide_synCycle").length >0){
				$("#synCycle").find("option[value='"+$("#hide_synCycle").val()+"']").attr("selected", "selected");		
			} 
			if($("#hide_isSynTime").length >0){
				$('#isSynTime').attr('checked',$("#hide_isSynTime").val());
			} 
			if($("#hide_langCode").length >0){
				$("#langCode").find("option[value='"+$("#hide_langCode").val()+"']").attr("selected", "selected");
			} 
			if($("#hide_timeZone").length >0){
				$("#timeZone").find("option[value='"+$("#hide_timeZone").val()+"']").attr("selected", "selected");
			} 
			
			if($("#hide_isSynTime").length >0){
				var isSynTime = $("#hide_isSynTime").val();
				$('#isSynTime').attr('checked',(isSynTime=='on'));
			} 
			
			if($("#hide_showAllNotification").length >0){
				var showAllNotification = $("#hide_showAllNotification").val();
				$('#showAllNotification').attr('checked',(showAllNotification=='on'));
			} 
			
			if($("#hide_showHvacNotification").length >0){
				var showHvacNotification = $("#hide_showHvacNotification").val();
				$('#showHvacNotification').attr('checked',(showHvacNotification=='on'));
			} 
			
			if($("#hide_notificationMusic").length >0){
				$("#notificationMusic").find("option[value='"+$("#hide_notificationMusic").val()+"']").attr("selected", "selected");
			} 
			
			if($("#hide_autoComplete").length >0){
				var autoComplete = $("#hide_autoComplete").val();
				$('#autoComplete').attr('checked',(autoComplete=='on'));
			} 
			if($("#hide_autoCompleteOrder").length >0){
				var autoCompleteOrder = $("#hide_autoCompleteOrder").val();
				$('#autoCompleteOrder').attr('checked',(autoCompleteOrder=='on'));
			} 
			
			if($("#hide_showKeywords").length >0){
				$("#showKeywords").find("option[value='"+$("#hide_showKeywords").val()+"']").attr("selected", "selected");
			} 
			
			if($("#hide_switchDevice").length >0){
				$("#switchDevice").find("option[value='"+$("#hide_switchDevice").val()+"']").attr("selected", "selected");
			} 
			
			if($("#hide_isHintSound").length >0){
				var isHintSound = $("#hide_isHintSound").val();
				$('#isHintSound').attr('checked',(isHintSound=='on'));
			} 
			
			if($("#hide_isDdlClickConfirm").length >0){
				var isDdlClickConfirm = $("#hide_isDdlClickConfirm").val();
				$('#isDdlClickConfirm').attr('checked',(isDdlClickConfirm=='on'));
			} 

			$('input:checkbox').change(function() {
				console.log($(this));
				 $(this).parent().find('span').text($(this).is(':checked')?'On':'Off');	
				 $(this).attr('checked',$(this).is(':checked'));
			});
			
			/**
			 * 验证接班人
			 * */
			if($("#shiftworkerName").length>0) {
				$("#shiftworkerName").change(function(){
					var nameVal  = $("#shiftworkerName").val();
					console.log('shiftworker query Name:' + nameVal);
					if(nameVal!="") {
						var url = contextPath + "account/shiftwork/"+ nameVal;
						console.log("validate url:"+ url);
						$.get(url,function(result){}).success(function(msg){
							if(msg.userId=="" || typeof(msg.userId)=='undefined') {
								$("#shiftworkerName").parent().parent().addClass("error");
								console.log("shiftwork object is null");
								$.sticky("shiftwork object is null",{
									autoclose : 5000,
									position : "top-right",
									type : "st-error"
								});
							} else {
								$("#shiftworkerName").parent().parent().addClass("success");
								$("#shiftworker").val(msg.userId);
								console.log("shiftworker is:"+ msg.userId);
							}
						}).error(function(msg){
							var msg = "";
							$.each(msg,function(index,txt){
								msg += txt;
							});
							$.sticky(msg,{
								autoclose : 5000,
								position : "top-right",
								type : "st-error"
							});
							$("#shiftworkerName").parent().parent().addClass("error");
						});
					} else {
						$("#shiftworkerName").parent().parent().removeClass("success");
					}
				});
			}
		}, 
		shiftwork_history : function() {
			//当前页面路径
			var pathname = window.location.pathname;
			var shiftwork_url = contextPath + "account/shiftwork";
			if(pathname==shiftwork_url) {
				//shiftwork_url+"/{username}/{pageIndex}/{pageSize}"
				$('table#shiftworklog').dataTable();
				console.log("shiftworklog");
				
			}
		},
		shiftwork_validate : function() {
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
					"user.username" : "required",
					shiftworkerName : {
						required : true,
						minlength : 3
					},
					"floorNo":"required"
				}, //提交表单
				submitHandler : function(){
					var $form = $("#shiftwork");
					console.log("submit to :" + $form.attr('action'));
					$.post($(this).attr("action"), $form.serialize(), function(html) {		
					}).success(function(result){	
						if(result.success=='true') {
						//当前页面路径
							$(".main_content form:first-child").before("<div class='alert fade in '><button type='button' class='close' data-dismiss='alert'>&times;</button>success!</div");
							$("#shiftworkModal").modal('hide');
						} else {
							$(".main_content form:first-child").before("<div class='alert fade in'><button type='button' class='close' data-dismiss='alert'>&times;</button>"+ result.msg +"</div");
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
		account.profiles();
		account.shiftwork_validate();
		account.shiftwork_history();
	});
})(jQuery, window, document);

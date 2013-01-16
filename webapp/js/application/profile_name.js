/* [ ---- account profile javascript ---- ] */

;
(function($, window, document, undefined) {
	var validate = {	
		name : function() {
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
					var $form = $("#name");
					console.log("change password,submit to :" + $form.attr('action'));
					$.post($(this).attr("action"), $form.serialize(), function(html) {		
					}).success(function(result){	
							console.log('change password,process result:'+ result);
							if(result.success=='true') {
							//当前页面路径
								$("form#name").before("<div class='alert fade in '><button type='button' class='close' data-dismiss='alert'>&times;</button>success!</div");
							} else {
								$("form#name").before("<div class='alert fade in'><button type='button' class='close' data-dismiss='alert'>&times;</button>"+ result.msg +"</div");
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
		validate.name();
	});
})(jQuery, window, document);

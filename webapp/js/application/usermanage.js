/* [ ---- user manage javascript ---- ] */

$(document).ready(function() {
	// setting_validation.ttip();

	userlist_opt.click();
});

userlist_opt = {
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

// * validation
setting_validation = {
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
								systemName : {
									required : true,
									minlength : 3
								},
								systemEnname : {
									required : true,
									minlength : 3
								},
								copyRight : {
									required : true,
									minlength : 3
								}
							},
							invalidHandler : function(form, validator) {
								$
										.sticky(
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
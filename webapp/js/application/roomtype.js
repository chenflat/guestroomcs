/* [ ---- room manage javascript ---- ] */

$(document).ready(function() {
	roomtype_validation.ttip();
	roomtype.remove();
});
var roomtype_validation = {
		ttip: function() {
			var validator = $('.form_validation_ttip').validate({
				onkeyup: false,
				errorClass: 'error', 
				validClass: 'valid',
				highlight: function(element) {
					$(element).closest('div').addClass("f_error");
				},
				unhighlight: function(element) {
					$(element).closest('div').removeClass("f_error");
				},
                rules: {
                	'roomtypeName': { required: true, minlength: 3 },
                	'hotel.hotelId': { required: true}
				},
				invalidHandler: function(form, validator) {
					$.sticky("There are some errors. Please corect them and submit again.", {autoclose : 5000, position: "top-right", type: "st-error" });
				},
				errorPlacement: function(error, element) {
					// Set positioning based on the elements position in the form
					var elem = $(element);
					
					// Check we have a valid error message
					if(!error.is(':empty')) {
						if( (elem.is(':checkbox')) || (elem.is(':radio')) ) {
							// Apply the tooltip only if it isn't valid
							elem.filter(':not(.valid)').parent('label').parent('div').find('.error_placement').qtip({
								overwrite: false,
								content: error,
								position: {
									my: 'left bottom',
									at: 'center right',
									viewport: $(window),
									adjust: {
										x: 6
									}
								},
								show: {
									event: false,
									ready: true
								},
								hide: false,
								style: {
									classes: 'ui-tooltip-red ui-tooltip-rounded' // Make it red... the classic error colour!
								}
							})
							// If we have a tooltip on this element already, just update its content
							.qtip('option', 'content.text', error);
						} else {
							// Apply the tooltip only if it isn't valid
							elem.filter(':not(.valid)').qtip({
								overwrite: false,
								content: error,
								position: {
									my: 'bottom left',
									at: 'top right',
									viewport: $(window),
                                    adjust: { x: -8, y: 6 }
								},
								show: {
									event: false,
									ready: true
								},
								hide: false,
								style: {
									classes: 'ui-tooltip-red ui-tooltip-rounded' // Make it red... the classic error colour!
								}
							})
							// If we have a tooltip on this element already, just update its content
							.qtip('option', 'content.text', error);
						};            
					}
					// If the error is empty, remove the qTip
					else {
						if( (elem.is(':checkbox')) || (elem.is(':radio')) ) {
							elem.parent('label').parent('div').find('.error_placement').qtip('destroy');
						} else {
							elem.qtip('destroy');
						}
					}
				},
				success: $.noop // Odd workaround for errorPlacement not firing!
			})
		}		
		
};
var roomtype = {
		remove:function(){
			$("#linkDelete").click(function(){
				$("#roomtypeDelModal").modal('show');
			});
			
			$("#btn-delete").click(function(){
				var url = $(this).attr('url');
				var roomtypeId = $("#roomtypeId").val();
				
				$.post(url,{roomtypeId:roomtypeId},function(result){
					
				}).success(function(msg){
					//
					window.location.href = $("#redirect").val();
					$.sticky("remove room "+ nos +" successfule!", {autoclose : 5000, position: "top-right", type: "st-success" });
					
				}).error(function(msg){
					alert(msg);
				});
			});
			
			
		}
};

	
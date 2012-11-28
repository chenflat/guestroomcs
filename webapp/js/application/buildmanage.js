/* [ ---- build setting validation ---- ] */

	$(document).ready(function() {
		
		build.opt();
		
		validation.ttip();
	});
	
	
	//btn_delete
	
	build = {
		opt:function(){
			
			//当前页面路径
			var pathname = window.location.pathname;
			//用户管理员路径
			var addpath = contextPath+"hotel/build/add";
			var listpath = contextPath+"hotel/build";
			
			console.log(pathname);
			console.log(addpath);
			console.log("listpath is "+ listpath);
			/**
			 * 新增角色时不显示工具栏
			 * */
			if(pathname==addpath || pathname==listpath) {
				$("#build_delete").hide();
			}
						
			//删除建筑确认提示
			$("#build_delete").click(function(){
				var buildName = $("#buildName").val();
				$("#buildDelModal .modal-body .lead").text(buildName);
				$("#buildDelModal").modal('show');
			});
			
			//执行角色删除
			$("#btn-delete").click(function(){
				var url = $(this).attr('url');
				var buildId = $("#buildId").val();
				$.post(url,{buildId:buildId},function(result){	
					if(result.success=='true') {
						$.sticky("remove build success!", {autoclose : 5000, position: "top-right", type: "st-success" });	
						window.location.href = listpath ;
					} else {
						$(".main_content form:first-child").before("<div class='alert fade in'><button type='button' class='close' data-dismiss='alert'>&times;</button>"+ result.msg +"</div");
					}
				}).success(function(msg){	
							
				}).error(function(msg){
					alert(msg);
				});
				$("#buildDelModal").modal('hide');
			});
			
		}	
	};
	
	
	//* validation
	validation = {
		ttip: function() {
			var ttip_validator = $('.form_validation_ttip').validate({
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
                	buildName: { required: true, minlength: 3 }
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
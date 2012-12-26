/* [ ---- room manage javascript ---- ] */

$(document).ready(function() {
	// * wizard with validation
	init_wizard.validation();
	// * add step numbers to titles
	init_wizard.steps_nb();
	init_wizard.metro_switch();
	
	//* enhanced select elements
	chosen.init();
	
	tiles.selected();
	
	room.group();
	room.del();
	room.del_batch();
	room.add_batch();
});

var init_wizard = {
	validation : function() {
		$('#initRoom').stepy({
			nextLabel : 'Next <i class="icon-chevron-right icon-white"></i>',
			backLabel : '<i class="icon-chevron-left"></i> Back',
			block : true,
			errorImage : true,
			titleClick : true,
			validate : true
		});
		stepy_validation = $('#initRoom').validate({
				onfocusout : false,
					errorPlacement : function(error, element) {
					error.appendTo(element.closest("div.controls"));
				},
				highlight : function(element) {
					$(element).closest("div.control-group").addClass("error f_error");
					var thisStep = $(element).closest('form').prev('ul').find('.current-step');
					thisStep.addClass('error-image');
				},
				unhighlight : function(element) {
					$(element).closest("div.control-group").removeClass("error f_error");
					if (!$(element).closest('form').find('div.error').length) {
						var thisStep = $(element).closest('form').prev('ul').find('.current-step');
						thisStep.removeClass('error-image');
					};
				},
				rules : {
					hotel : 'required',
					build : 'required',
					floor : {required:true,number:true},
					room :  {required:true,number:true}
				},
				messages : {
					hotel : {required : '必须选择酒店!'},
					build : {required : '必须选择酒店建筑!'},
					floor : {required : '必须填写楼层数!'},
					room : {required : '必须填写楼层房间数!'}
				}/*,
				ignore : ':hidden'*/
			});
	},
	// * add numbers to step titles
	steps_nb : function() {
		$('.stepy-titles').each(function() {
			$(this).children('li').each(function(index) {
				var myIndex = index + 1
				$(this).append('<span class="stepNb">' + myIndex + '</span>');
			})
		})
	},
	metro_switch : function() {
		$('.switch').each(function(){
			var span = $('.switch span');
			$('input:checkbox').click(function(){
				span.text($(this).is(':checked')?'On':'Off');
			});
		})
	}
};

	var chosen = {
		init: function(){
			$(".chzn_a").chosen({
				allow_single_deselect: true
			});
			$(".chzn_b").chosen();
		}
	};
	
	tiles = {
		selected:function() {
			$(".tiles .tile").bind('click',function(e){
			      e.preventDefault();
			     
			      $(this).toggleClass('selected');
			   });
		}
	};
	/**房间操作*/
	var room = {
		//房间组操作
		group:function(){
			$("#linkRoomgroup").click(function(){
				$("#roomgroupModal").modal('show');
			});
			$("#btnSaveroomgroup").click(function(){
				$("#roomgroupForm").submit(function() {  	
					$.post($(this).attr("action"), $(this).serialize(), function(html) {	
						if(html=='success') {
						$("#roomgroupModal").modal('hide');
						}
					}).success(function(msg){
						$.sticky("roomgroup save successfule!", {autoclose : 5000, position: "top-right", type: "st-success" });						
					});
					return false;
				});
			});
			//房间组表单clone
			 var sheepItForm = $('#roomgroups').sheepIt({
			        separator: '',
			        allowRemoveLast: true,
			        allowRemoveCurrent: true,
			        allowRemoveAll: true,
			        allowAdd: true,
			        allowAddN: true,
			        maxFormsCount: 20,
			        minFormsCount: 0,
			        iniFormsCount: 2,
			      	data:roomgroupdata
			    });
		},//删除房间
		del:function() {
			$("#linkDelete").click(function(){
				var ss = [];  
				$(".tiles .selected").each(function(e){
					ss.push($(this).text());
				});
				var nos="";
				nos = ss.join(",");
				if(nos!='') {
					$("#roomDelModal .modal-body").html("<p>客户号为 <span class='lead text-error'>"+ nos +"</span> 的房间将被删除。</p>");
					$('#roomDelModal').modal('show');
				}	
			});
			
			$("#btn-delete").click(function(){
				var url = $(this).attr('url');
				var ss = [];  
				var nos="";
				$(".tiles .selected").each(function(e){
					ss.push($(this).text());
				});
				nos = ss.join(",");
				$.post(url,{roomNos:nos},function(result){
					
				}).success(function(msg){
					$('#roomDelModal').modal('hide');
					//remove element
					$(".tiles .selected").each(function(e){
						$(this).remove();
						
					});
					$.sticky("remove room "+ nos +" successfule!", {autoclose : 5000, position: "top-right", type: "st-success" });
				}).error(function(msg){
					alert(msg);
				});
			});
		}, //批量删除
		del_batch:function() {
			$("#linkDelete_batch").click(function(){
				$("#roomBatchdelModal").modal('show');
			});
		}, //批量新增
		add_batch:function(){
			$("#linkAdd_batch").click(function(){
				$('#roomBatchaddModal').modal('show');
			});
		}
	};
	
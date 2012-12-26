/* [ ---- guest prefs validation ---- ] */
$(document).ready(function() {
	dictionary.list();
	
	
});


var dictionary = {
	list:function(){
		$("#listinfos").hide();
		$("#category li a").click(function(){
			var text = $(this).text();
			if(typeof(text)=='undefined' || text=='')  {
				return false;
			}
			console.log(text);
			var url = $(this).context.baseURI;
			
			$("#category li").removeClass("active");
			$(this).parent().addClass('active');
			$.post(url,{listname:text},function(html){
				
			}).success(function(data){
				$("#listinfos").show();
				$("#listinfos tbody").empty();
				var html = "";
				$.each(data,function(index,obj){
					html += "<tr>";
					html += "<td></td>";
					html += "<td>"+ obj.listname +"</td>";
					html += "<td>"+ obj.text +"</td>";
					html += "<td>"+ obj.value +"</td>";
					html += "</tr>";
				});
				$("#listinfos tbody").html(html);
				console.log(data);
			}).error(function(result){
				
			});
			
			
			
			
		});
	}	
};
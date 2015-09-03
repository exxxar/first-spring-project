

$(document).ready(function(){	
	$('.get-userlist').click(function(){           
            $.get("../user/list",{},function(data){
				$(".content-place").html(data);
			});	
          	
	});	

});
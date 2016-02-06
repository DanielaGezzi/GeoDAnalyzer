/**
 * 
 */

$(document).ready(function(){
	
	$("#searchButtonTwitter").on("click", function(){
			$.ajax({
				type: "POST",
				url: "http://localhost:8080/geoDAnalyzer/webapi/myresource/admin/search/twitter",
				data: $("#searchTwitter").serialize(),
				contentType: "application/ x-www-form-urlencoded",
				success: function(result){
					alert(result);
				}
			});
	});
	
});
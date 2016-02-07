/**
 * 
 */

$(document).ready(function(){
	
	$("#buttonTwitter").on("click", function(){
		var json = {
				param : $("#queryParamT").val()
		}
		$.ajax({
			type: "POST",
			url: "http://localhost:8080/geoDAnalyzer/webapi/myresource/admin/search/twitter",
			contentType: "application/json",
			data: JSON.stringify(json),
			success: function(response){
				alert("Success!");
				$("form").trigger("reset");

			},
			error: function(result, status, error){
				alert("Sorry, an error occurred. Please try again later");
			}
			});
		});
	$("#buttonFacebook").on("click", function(){
		var json = {
				param : $("#queryParamF").val()
		}
		$.ajax({
			type: "POST",
			url: "http://localhost:8080/geoDAnalyzer/webapi/myresource/admin/search/facebook",
			contentType: "application/json",
			data: JSON.stringify(json),
			success: function(response){
				alert("Success!");
				$("form").trigger("reset");
			},
			error: function(result, status, error){
				alert("Sorry, an error occurred. Please try again later");
			}
			});
		});
	$("#buttonFlickr").on("click", function(){
		var json = {
				param : $("#queryParamFl").val()
		}
		$.ajax({
			type: "POST",
			url: "http://localhost:8080/geoDAnalyzer/webapi/myresource/admin/search/flickr",
			contentType: "application/json",
			data: JSON.stringify(json),
			success: function(response){
				alert("Success!");
				$("form").trigger("reset");
			},
			error: function(result, status, error){
				alert("Sorry, an error occurred. Please try again later");
			}
			});
		});
	});
	
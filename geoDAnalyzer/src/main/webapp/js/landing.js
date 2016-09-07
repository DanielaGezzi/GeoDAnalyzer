/**
 * 
 */


var map;
function initialize() {
  geocoder = new google.maps.Geocoder();
  var latlng = new google.maps.LatLng(0, 0);
  var mapOptions = {
    zoom: 2,
    center: latlng,
    mapTypeId: google.maps.MapTypeId.ROADMAP,
    mapTypeControl: true,
    mapTypeControlOptions:{
    	position:google.maps.ControlPosition.TOP_CENTER
    }
  }
  map = new google.maps.Map(document.getElementById("map-canvas"), mapOptions);
}

function urlify(text) {
	    var urlRegex = /(https?:\/\/[^\s]+)/g;
	    return text.replace(urlRegex, function(url) {
	        return '<a href="' + url + '">' + url + '</a>';
	    })
}

$(document).ready(function(){
	$("#searchButton").on("click", function(){
		
		  $('#Twitter_table').empty();
 	 	  $('#Facebook_table').empty();
 	 	  $('#Flickr_table').empty();
		  
		  var oms = new OverlappingMarkerSpiderfier(map);
		  var address = document.getElementById("address").value;
		  geocoder.geocode( {'address': address}, function(results, status) {
		    if (status == google.maps.GeocoderStatus.OK) {
		       
		      map.setCenter(results[0].geometry.location);
		      map.setZoom(15);
		      var marker = new google.maps.Marker({
		          map: map,
		          position: results[0].geometry.location
		      });
		      $.getJSON("http://localhost:8080/geoDAnalyzer/webapi/myresource/events/"+marker.getPosition().lat()+"/"+marker.getPosition().lng()+"")
		      .done(function(data){
	     	 		 	
		    	  	 var infowindow = new google.maps.InfoWindow();
		     	 	 oms.addListener('click', function(marker,event){
		     	 	    	infowindow.setContent(marker.desc);
		     	 	    	infowindow.open(map,marker);
		     	 	    });

		     	 	 
		    	  $.each(data, function(key,val){
		        	 var myLatLng = {lat: val.location.coordinates[1], lng: val.location.coordinates[0]};
		        		 if (val.platform == "Twitter"){
		        			 var text = "<div class=\"infowindow-content\"><blockquote class=\"twitter-tweet\" lang=\"en\">" +
		        			 			"<p>"+urlify(val.body)+"</p>" + val.author +" (@"+val.author+")</br>" +
		        			 			"<a href=\"https://twitter.com/statuses/"+val.id+"\">expand</a></blockquote></div>";
		        		        	 
			     	 		 var marker = new google.maps.Marker({
						          map: map,
						          position: myLatLng,
						          animation: google.maps.Animation.DROP,
						          desc:text
								});
			     	 		
			     	 		oms.addMarker(marker);
			     	 		/*google.maps.event.addListener(marker, 'click', function () {
			     	 	        infowindow.close();
			     	 			infowindow.open(map, marker);
			     	 	    });*/
			     	 		/*oms.addMarker(marker);
			     	 	    
			     	 	    oms.addListener('click', function(marker,event){
			     	 	    	infowindow.close();
			     	 	    	infowindow.open(map,marker);
			     	 	    });
			     	 	    
			     	   	  oms.addListener('spiderfy', function(markers) {
			     	 		  infowindow.close();
			     	 		});
			     	   
			     	 	google.maps.event.addListener(infowindow, 'domready', function () {
			     	 	        ! function (d, s, id) {
			     	 	            var js, fjs = d.getElementsByTagName(s)[0];
			     	 	            if (!d.getElementById(id)) {
			     	 	                js = d.createElement(s);
			     	 	                js.id = id;
			     	 	                js.src = "//platform.twitter.com/widgets.js";
			     	 	                fjs.parentNode.insertBefore(js, fjs);
			     	 	            }
			     	 	        }(document, "script", "twitter-wjs");
			     	 	    });	*/
			     	 		var texttable = "<div class=\"infowindow-content\"><blockquote class=\"twitter-tweet\" lang=\"en\">" +
    			 			"<p>"+urlify(val.body)+"</p>" + val.author +" (@"+val.author+")</br>" +
    			 			"<a href=\"https://twitter.com/statuses/"+val.id+"\">expand</a></br>" +
							"" + val.areaNation + " - " + val.areaRegion + " - " + val.areaDistrict + "<span class=\"ui-icon ui-icon-search\" value=\""+val._idAdminArea.$oid+"\"></span></blockquote></div>";
			     	 		var table = $('<table></table>');
			     	 		var row = $('<tr></tr>').append(texttable);
			     	 		table.append(row);
			     	 		$('#Twitter_table').append(table);
			     	 	
		        		 }//chiudo if twitter
		        		 else if (val.platform == "Facebook"){
		        			 var body = "no description available";
		        			 if(val.body!=null) {body = val.body.substr(0,50);}
		        			 //var text = "<div id=\"fb-root\"></div><div class=\"fb-post\" data-href=\"https://www.facebook.com/events/"+val.id+"/\" data-width=\"500\"></div>";
							 var text = "<div class=\"infowindow-content2\"><blockquote class=\"facebook-event\" lang=\"en\">" +
							 			"<p>"+val.title+"</p>" + body +" </br><a href=\"https://www.facebook.com/events/"+val.id+"\">more...</a></blockquote></div>";

		        			 //var text = ""+val.title+"</br>"+val.body;
				        	 /*var infowindow = new google.maps.InfoWindow({
				        		    content: text
				        		  });*/
		        	 
			     	 		 var marker = new google.maps.Marker({
						          map: map,
						          position: myLatLng,
						          animation: google.maps.Animation.DROP,
						          desc:text
								});
			     	 		 oms.addMarker(marker);
				     	 	    
				     	 	 /*oms.addListener('click', function(marker,event){
				     	 	    	infowindow.close();
				     	 	    	infowindow.open(map,marker);
				     	 	    });
				     	 	 
				     	 	 oms.addListener('spiderfy', function(markers) {
				     	 		  infowindow.close();
				     	 		});*/
			     	 		 
			     	 		/*google.maps.event.addListener(marker, 'click', function () {
			     	 	        infowindow.close();
			     	 			infowindow.open(map, marker);
			     	 	    });*/
			     	 		
			     	 		/*google.maps.event.addListener(infowindow, 'domready', function () {
			     	 	        ! function (d, s, id) {
			     	 	            var js, fjs = d.getElementsByTagName(s)[0];
			     	 	            if (!d.getElementById(id)) {
			     	 	                js = d.createElement(s);
			     	 	                js.id = id;
			     	 	                js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.3";
			     	 	                fjs.parentNode.insertBefore(js, fjs);
			     	 	            }
			     	 	        }(document, "script", "facebook-jssdk");
			     	 	    });*/
							var texttable = "<div class=\"infowindow-content\"\"><blockquote class=\"facebook-event\" style=\"width:400px\"\ lang=\"en\">" +
									"<p>"+val.title+"</p>" + body +" </br><a href=\"https://www.facebook.com/events/"+val.id+"\">more...</a></br>" +
											"" + val.areaNation + " - " + val.areaRegion + " - " + val.areaDistrict + "<span class=\"ui-icon ui-icon-search\"></span></blockquote></div>";
			     	 		var table = $('<table></table>');
			     	 		var row = $('<tr></tr>').append(texttable);
			     	 		table.append(row);
			     	 		$('#Facebook_table').append(table).hide();
		        		 }//chiudo if facebook
		        		 else if (val.platform == "Flickr"){
		        			 var text = "<img src=\""+val.body+"\"></br><a href=\""+val.title+"\">view on Flickr -></a>";
		        		        	 
			     	 		 var marker = new google.maps.Marker({
						          map: map,
						          position: myLatLng,
						          animation: google.maps.Animation.DROP,
						          desc:text
								});
			     	 		
			     	 		oms.addMarker(marker);
			     	 		     	   
			     	 		var texttable = "<img src=\""+val.body+"\"></br><a href=\""+val.title+"\">view on Flickr -></a></br>" +
											"" + val.areaNation + " - " + val.areaRegion + " - " + val.areaDistrict + "<span class=\"ui-icon ui-icon-search\"></span>";
			     	 		var table = $('<table></table>');
			     	 		var row = $('<tr></tr>').append(texttable);
			     	 		table.append(row);
			     	 		$('#Flickr_table').append(table).hide();
		        		 }//chiudo if Flickr
	     	 		});//chiudo each

		           });//chiudo get

		   
		     } else { //geocoder status is not OK
		      alert("Geocode was not successful for the following reason: " + status);
		    }//chiudo else
		  });//chiudo geocoder.geocode
	});//chiudo search button on click
	$("#Facebook_Button").on("click", function(){
		$('#Twitter_table').hide();
	 	$('#Facebook_table').show();
	 	$('#Flickr_table').hide();
	});
	$("#Twitter_Button").on("click", function(){
		$('#Twitter_table').show();
	 	$('#Facebook_table').hide();
	 	$('#Flickr_table').hide();
	});
	$("#Flickr_Button").on("click", function(){
		$('#Twitter_table').hide();
	 	$('#Facebook_table').hide();
	 	$('#Flickr_table').show();
	});
});//chiudo document ready


/*function codeAddress() {
  var address = document.getElementById("address").value;
  geocoder.geocode( {'address': address}, function(results, status) {
    if (status == google.maps.GeocoderStatus.OK) {
      map.setCenter(results[0].geometry.location);
      map.setZoom(15);
      var marker = new google.maps.Marker({
          map: map,
          position: results[0].geometry.location
      });
      
     } else {
      alert("Geocode was not successful for the following reason: " + status);
    }
  });
  
}*/

//marker.getPosition().lat();
$.material.init();



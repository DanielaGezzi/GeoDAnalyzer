<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>GeoDataSearcher - AdminSearch</title>
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/bootstrap-material-design.css" rel="stylesheet">
<script src="https://maps.googleapis.com/maps/api/js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/material.js"></script>
<script src="js/admin.js"></script>
    
</head>
<body>
<div class="row">
<div class="col-md-12">
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">GDA</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="index.jsp">Home</a></li>
        <li class="active"><a href="#">Admin<span class="sr-only">(current)</span></a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
</div>
</div>
<div class = "row">
<div class="col-md-3">
<div class="container-fluid">
	<div id="searchTwitterContainer" style="display: in-line">
      <form id="searchTwitter" name="searchTwitter">
        <input id="queryParamT" name="queryParam" type="text" class="form-control" placeholder="Insert Keyword">     
      </form>
       <button id="buttonTwitter" type="submit" class="btn btn-default">Search on Twitter</button>
     </div>
     <div id="searchFacebookContainer">
      <form id="searchFacebook" name="searchFacebook">
        <input id="queryParamF" name="queryParamF" type="text" class="form-control" placeholder="Insert Keyword"> 
      </form>
        <button id="buttonFacebook" type="submit" class="btn btn-default">Search on Facebook</button>
     </div>
     <div id="searchFlickrContainer">
      <form id="searchFlickr" name="searchFlickr">
        <input id="queryParamFl" name="queryParam" type="text" class="form-control" placeholder="Insert Keyword">     
      </form>
		<button id="buttonFlickr" type="submit" class="btn btn-default">Search on Flickr</button>
     </div>
    </div>
   </div>
  </div>
</body>

</html>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>GeoDataSearcher</title>
<link href="css/landing.css" rel="stylesheet"> 
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/bootstrap-material-design.css" rel="stylesheet">
 
<script src="https://maps.googleapis.com/maps/api/js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/material.js"></script>
<script src="js/oms.min.js"></script>
<script type="text/javascript" src="js/landing.js"></script>

<style>
      #map-canvas {
        width: 1000px;
        height: 400px;
      }
    </style>
    
</head>
<body onload="initialize()">
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
        <li class="active"><a href="#">Home<span class="sr-only">(current)</span></a></li>
        <li><a href="#">Admin</a></li>
      </ul>
      <form class="navbar-form navbar-right">
        <div class="form-group">
          <input id="address" type="text" class="form-control" placeholder="Insert Location">
        </div>
        <button id="searchButton" type="button" value="Search" class="btn btn-default">Search</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
        
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
</div>
</div>


 <div id="map-canvas" style="width: 1000px; height: 480px;" align="center"></div>
  </body>

</html>
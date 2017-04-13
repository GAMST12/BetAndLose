<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>

  <title>Profile</title>

  <meta name="viewport" content="initial-scale=1, maximum-scale=1">
  <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
  <link rel="stylesheet" href="/resources/core/adminprofile.css">

  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <jsp:useBean id="userDto" scope="request" type="ua.skillsup.betandlose.model.UserDto"/>


</head>

<body>

<!-- Fixed navbar -->
<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container header">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <div class="navbar-brand" >${userDto.login}</div>
    </div>
    <div id="navbar" class="navbar-collapse collapse">
      <ul class="nav navbar-nav">
        <li class="active"><a id="home-tab">Home</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a id="logout">Logout</a></li>
      </ul>
    </div><!--/.nav-collapse -->
  </div>
</nav>

<div class="container body" id="home-panel" >

  <!-- Main component for a primary marketing message or call to action -->
  <div class="jumbotron">
    <h1>Hello, ${userDto.firstName} ${userDto.lastName}</h1>
    <p>Your email: ${userDto.email}</p>
    <p>
      <a class="btn btn-lg btn-primary" id="add-kind-sport" href="../addkindsport" role="button">Add kind sport &raquo;</a>
      <a class="btn btn-lg btn-primary" id="add-tournament" href="../addtournament" role="button">Add tournament &raquo;</a>
      <a class="btn btn-lg btn-primary" id="add-team" href="../addteam" role="button">Add team &raquo;</a>
    </p>
    <p>
      <a class="btn btn-lg btn-primary" id="add-item" href="../additem" role="button">Add item &raquo;</a>
      <a class="btn btn-lg btn-primary" id="add-result" href="../addresult" role="button">Add result &raquo;</a>
    </p>

  </div>

</div> <!-- /container -->


<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resources/core/adminprofile.js"></script>

</body>
</html>

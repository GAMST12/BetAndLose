<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>

  <title>Add kind sport</title>

  <meta name="viewport" content="initial-scale=1, maximum-scale=1">
  <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
  <link rel="stylesheet" href="/resources/core/addkindsport.css">

  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


</head>

<body>
<h2 class="text-centred">Add kind sport</h2>

<form id="kind-sport-form" class="form-horizontal">
  <div class="form-group">
    <label class="control-label col-xs-3" for="kind-sport">Kind sport:</label>
    <div class="col-xs-9">
      <input type="text" class="form-control" id="kind-sport" placeholder="Enter kind sport">
    </div>
  </div>
  <div class="form-group">
    <div class="col-xs-offset-3 col-xs-9">
      <input id="save" type="submit" class="btn btn-lg btn-primary" value="Add">
      <input type="reset" class="btn btn-lg btn-default" value="Clean the form">
      <a class="btn btn-lg btn-default" id="back" href="../adminprofile" role="button">Back</a>
    </div>
  </div>
</form>


<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resources/core/addkindsport.js"></script>

</body>
</html>


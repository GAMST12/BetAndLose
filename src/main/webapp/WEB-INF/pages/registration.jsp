
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>

  <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
  <link rel="stylesheet" href="/resources/core/registration.css">

</head>
<body>
<h2 class="text-centred">Registration form</h2>
<form id="register-form" class="form-horizontal">
  <div class="form-group">
    <label class="control-label col-xs-3" for="login">Login:</label>
    <div class="col-xs-9">
      <input type="text" class="form-control" id="login" placeholder="Enter your login">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-xs-3" for="firstName">Name:</label>
    <div class="col-xs-9">
      <input type="text" class="form-control" id="firstName" placeholder="Enter your name">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-xs-3" for="lastName">Surname:</label>
    <div class="col-xs-9">
      <input type="text" class="form-control" id="lastName" placeholder="Enter your surname">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-xs-3" for="inputEmail">Email:</label>
    <div class="col-xs-9">
      <input type="email" class="form-control" id="inputEmail" placeholder="Email">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-xs-3" for="inputPassword">Password:</label>
    <div class="col-xs-9">
      <input type="password" class="form-control" id="inputPassword" placeholder="Enter password">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-xs-3" for="confirmPassword">Confirm password:</label>
    <div class="col-xs-9">
      <input type="password" class="form-control" id="confirmPassword" placeholder="Confirm password">
    </div>
  </div>
  <div class="form-group">
    <div class="col-xs-offset-3 col-xs-9">
      <label class="checkbox-inline">
        <input type="checkbox" value="agree">  I accept the <a href="#">conditions</a>.
      </label>
    </div>
  </div>
  <br />
  <div class="form-group">
    <div class="col-xs-offset-3 col-xs-9">
      <input id="save" type="submit" class="btn btn-primary" value="Registration">
      <input type="reset" class="btn btn-default" value="Clean the form">
    </div>
  </div>
</form>

<div class="container">
  <div class="alert alert-success hidden" id="success-alert">
    <h2>Success</h2>
    <div>Registration success.</div>
  </div>
</div>

<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resources/core/registration.js"></script>

</body>
</html>

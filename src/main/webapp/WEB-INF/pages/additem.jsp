<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>

  <title>Add item</title>

  <meta name="viewport" content="initial-scale=1, maximum-scale=1">
  <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
  <link rel="stylesheet" href="/resources/core/additem.css">

  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <jsp:useBean id="tournamentDto" scope="request" type="java.util.List<ua.skillsup.betandlose.model.TournamentDto>"/>
  <jsp:useBean id="teamDto" scope="request" type="java.util.List<ua.skillsup.betandlose.model.TeamDto>"/>

</head>

<body>
<h2 class="text-centred">Add item</h2>

<form id="tournament-form" class="form-horizontal">
  <div class="form-group">
    <label class="control-label col-xs-3" for="date">Item date:</label>
    <div class="col-xs-9">
      <input type="date" class="form-control" id="date" />
    </div>

    <label class="control-label col-xs-3" for="tournament">Tournament:</label>
    <div class="col-xs-9">
      <select class="form-control" id="tournament">
        <c:forEach items="${tournamentDto}" var="tournament">
          <option id="${tournament.id}">${tournament.tournament}</option>
        </c:forEach>
      </select>
    </div>

    <label class="control-label col-xs-3" for="hometeam">Home team:</label>
    <div class="col-xs-9">
      <select class="form-control" id="hometeam">
        <c:forEach items="${teamDto}" var="team">
          <option id="${team.id}">${team.team}(${team.city},${team.country};${team.sex}) </option>
        </c:forEach>
      </select>
    </div>

    <label class="control-label col-xs-3" for="awayteam">Away team:</label>
    <div class="col-xs-9">
      <select class="form-control" id="awayteam">
        <c:forEach items="${teamDto}" var="team">
          <option id="${team.id}">${team.team}(${team.city},${team.country};${team.sex}) </option>
        </c:forEach>
      </select>
    </div>

    <label class="control-label col-xs-3" for="win1">Win1:</label>
    <div class="col-xs-9">
      <input type="number" class="form-control" id="win1" name="win1" pattern="[0-9\/]*"  step="0.01"/>
    </div>

    <label class="control-label col-xs-3" for="draw">Draw:</label>
    <div class="col-xs-9">
      <input type="number" class="form-control" id="draw" name="draw" pattern="[0-9\/]*"  step="0.01"/>
    </div>

    <label class="control-label col-xs-3" for="win2">Win2:</label>
    <div class="col-xs-9">
      <input type="number" class="form-control" id="win2" name="win2" pattern="[0-9\/]*"  step="0.01"/>
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
<script type="text/javascript" src="/resources/core/additem.js"></script>

</body>
</html>



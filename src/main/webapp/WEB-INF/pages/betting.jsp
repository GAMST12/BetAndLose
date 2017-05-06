<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>

  <title>Betting</title>

  <meta name="viewport" content="initial-scale=1, maximum-scale=1">
  <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
  <link rel="stylesheet" href="/resources/core/betting.css">

  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <jsp:useBean id="userDto" scope="request" type="ua.skillsup.betandlose.model.UserDto"/>
  <jsp:useBean id="itemDto" scope="request" type="java.util.List<ua.skillsup.betandlose.model.ItemDto>"/>


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
        <li class="active"><a id="history-tab">Place Bet</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="../about">Contact Info</a></li>
        <li><a href="" id="logout">Logout</a></li>
      </ul>
    </div><!--/.nav-collapse -->
  </div>
</nav>

<div class="container body" id="history-panel" >

  <!-- Main component for a primary marketing message or call to action -->
  <div class="jumbotron">
    <table class="table table-hover">
      <thead>
      <tr>
        <th>Date</th>
        <th>Kind Sport</th>
        <th>Tournament</th>
        <th>Team1</th>
        <th>Team2</th>
        <th>Win1</th>
        <th>Draw</th>
        <th>Win2</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${itemDto}" var="item">
        <tr id="${item.id}">
          <td id="item-date">${item.itemDate}</td>
          <td id="sport">${item.tournamentDto.sportDto.sport}</td>
          <td id="tournament">${item.tournamentDto.tournament}</td>
          <td id="team1">${item.homeTeamDto.team}(${item.homeTeamDto.city}, ${item.homeTeamDto.country}; ${item.homeTeamDto.sex})</td>
          <td id="team2">${item.awayTeamDto.team}(${item.awayTeamDto.city}, ${item.awayTeamDto.country}; ${item.awayTeamDto.sex})</td>
          <td id="win1" class="koef"><a class="nonselected">${item.win1Koef}</a></td>
          <td id="draw" class="koef"><a class="nonselected">${item.drawKoef}</a></td>
          <td id="win2" class="koef"><a class="nonselected">${item.win2Koef}</a></td>
        </tr>
      </c:forEach>

      </tbody>
    </table>

    <div class="form-group">
      <div class="col-xs-offset-3 col-xs-9">
        <p>
          <input type="text" class="form-control" id="sum" placeholder="Bet sum">
          <input id="save" type="submit" class="btn btn-lg btn-primary" value="Bet">
          <a class="btn btn-lg btn-default" id="back" href="../profile" role="button">Back to profile</a>
        </p>
      </div>
    </div>


  </div>

</div> <!-- /container -->


<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resources/core/betting.js"></script>

</body>
</html>

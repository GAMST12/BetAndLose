<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>

  <title>Profile</title>

  <meta name="viewport" content="initial-scale=1, maximum-scale=1">
  <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
  <link rel="stylesheet" href="/resources/core/profile.css">

  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <jsp:useBean id="userDto" scope="request" type="ua.skillsup.betandlose.model.UserDto"/>
  <jsp:useBean id="betDto" scope="request" type="java.util.List<ua.skillsup.betandlose.model.BetDto>"/>


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
        <li><a id="history-tab">Bet History</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="../about">Contact Info</a></li>
        <li><a id="logout">Logout</a></li>
      </ul>
    </div><!--/.nav-collapse -->
  </div>
</nav>

<div class="container body" id="home-panel" >

  <!-- Main component for a primary marketing message or call to action -->
  <div class="jumbotron">
    <h1>Hello, ${userDto.firstName} ${userDto.lastName}</h1>
    <p>Your registered date: ${userDto.loginDate}</p>
    <p>Your email: ${userDto.email}</p>
    <p>Your account balance: ${userDto.okv} UAH</p>
    <p>
      <a class="btn btn-lg btn-primary" id="place-bet" href="../bet" role="button">Place bet &raquo;</a>
      <a class="btn btn-lg btn-primary" id="deposit" href="../deposit" role="button">Deposit &raquo;</a>
      <a class="btn btn-lg btn-primary" id="withdrawal" href="../withdrawal" role="button">Withdrawal &raquo;</a>
    </p>
  </div>

</div> <!-- /container -->

<div class="container body hidden" id="history-panel" >

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
        <th>Event</th>
        <th>Score1</th>
        <th>Score2</th>
        <th>Sum</th>
        <th>Result</th>
        <th>Finished</th>
      </tr>
      </thead>
      <tbody>
        <c:forEach items="${betDto}" var="bet">
          <tr>
            <td id="bet-date">${bet.betDate}</td>
            <td id="sport">${bet.itemDto.tournamentDto.sportDto.sport}</td>
            <td id="tournament">${bet.itemDto.tournamentDto.tournament}</td>
            <td id="team1">${bet.itemDto.homeTeamDto.team}(${bet.itemDto.homeTeamDto.city})</td>
            <td id="team2">${bet.itemDto.awayTeamDto.team}(${bet.itemDto.awayTeamDto.city})</td>
            <td id="event">${bet.event}</td>
            <td id="score1">${bet.itemDto.homeScore}</td>
            <td id="score2">${bet.itemDto.awayScore}</td>
            <td id="sum">${bet.betSum}</td>
            <td id="sum-result">${bet.betResultSum}</td>
            <c:if test="${bet.finished}">
              <td id="finished">Yes</td>
            </c:if>
            <c:if test="${!bet.finished}">
              <td id="finished">No</td>
            </c:if>
          </tr>
        </c:forEach>

      </tbody>
    </table>

  </div>

</div> <!-- /container -->


<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resources/core/profile.js"></script>

</body>
</html>

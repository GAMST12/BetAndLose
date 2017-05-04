<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>

  <title>Add result</title>

  <meta name="viewport" content="initial-scale=1, maximum-scale=1">
  <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
  <link rel="stylesheet" href="/resources/core/addresult.css">

  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  </div>
</nav>

<div class="container body" id="result-panel" >

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
        <th>Score1</th>
        <th>Score2</th>
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
          <td id="score1" class="score"><input type="text" class="form-control" placeholder="Score1"></td>
          <td id="score2" class="score"><input type="text" class="form-control" placeholder="Score2"></td>
          <td id="save" ><input type="submit" class="btn btn-lg btn-primary" value="Add result"></td>
        </tr>
      </c:forEach>

      </tbody>
    </table>

    <div class="form-group">
      <div class="col-xs-offset-3 col-xs-9">
        <a class="btn btn-lg btn-default" id="back" href="../adminprofile" role="button">Back</a>
      </div>
    </div>


  </div>

</div> <!-- /container -->


<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resources/core/addresult.js"></script>

</body>
</html>

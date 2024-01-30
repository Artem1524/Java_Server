<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<% String contextPath = request.getContextPath(); %>
<html>
	<head>
	  <meta http-equiv="Content-Type" content="text/html" charset="utf-8">
	  <title>Главная страница</title>
	  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	</head>
	<body class="w3-light-grey">
		<div class="w3-container w3-purple w3-opacity w3-right-align">
			<h3>Главная страница</h3>
		</div>
		
		<div class="w3-container w3-center">
			<div class="w3-bar w3-padding-large w3-padding-48">
				<%
					out.println("<button class=\"w3-btn w3-green w3-hover-light-blue w3-round-large\" " +
					"onclick=\"location.href='" + contextPath + "/list'\">Список клиентов</button>");
				%>
				
				</br>
				</br>
				
				<%
					out.println("<button class=\"w3-btn w3-light-blue w3-hover-green w3-round-large\" " +
					"onclick=\"location.href='" + contextPath + "/new'\">Новый пользователь</button>");
				%>
			</div>
		</div>
	</body>
</html>
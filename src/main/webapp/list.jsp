<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<%@page import="java.util.List" %>

<% String contextPath = request.getContextPath(); %>
<html>
	
	<head>
	  <meta http-equiv="Content-Type" content="text/html" charset="utf-8">
	  <title>Список клиентов</title>
	  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	</head>
	
	<body class="w3-light-grey">
		<div class="w3-container w3-purple w3-opacity w3-center">
			<h3>Список клиентов</h3>
		</div>
		
		<div class="w3-container w3-padding w3-margin-bottom w3-center">
			<div class="w3-card-4">
				<div class="w3-container w3-light-blue">
					<h2>Пользователи</h2>
				</div>
				<%
					List<String> names = (List<String>) request.getAttribute("userNames");
					
					if (names != null && !names.isEmpty()) {
						out.println("<ul class=\"w3-ul\">");
						
						for (String name : names) {
							out.println("<li class=\"w3-hover-sand\">" + name + "</li>");
						}
						
						out.println("</ul>");
					} else {
						out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n" +
							"<span onclick=\"this.parentElement.style.display='none'\" " +
								"class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-grey w3-hover-border-red\">х</span>\n" +
							"<h5>Нет добавленных названий</h5>\n" +
						"</div>");
					}
				%>
					
			</div>
		</div>
		
		<div class="w3-container w3-grey w3-padding-24 w3-center">
			<%
				out.println("<button class=\"w3-btn w3-blue w3-hover-light-blue w3-round-large\" " +
					"onclick=\"location.href='" + contextPath + "/'\">Главная страница</button>");
			%>
		</div>
	</body>
	
</html>
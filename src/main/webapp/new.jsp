<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<% String contextPath = request.getContextPath(); %>
<html>
	
	<head>
	  <meta http-equiv="Content-Type" content="text/html" charset="utf-8">
	  <title>Добавление пользователя</title>
	  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	</head>
	
	<body class="w3-light-grey">
		<div class="w3-container w3-purple w3-opacity w3-center">
			<h3>Добавление пользователя</h3>
		</div>
		
		<div class="w3-light-green">
			<%
				String newUserName = (String) request.getAttribute("newUserName");
				
				if (newUserName != null) {
					out.println("<p>Пользователь '" + newUserName + "' успешно добавлен!</p>");
					
					out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n" +
							"<span onclick=\"this.parentElement.style.display='none'\" " +
								"class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-grey w3-hover-border-red\">х</span>\n" +
							"<h5>Пользователь '" + newUserName + "' успешно добавлен!</h5>\n" +
						"</div>");
				}
			%>
		</div>
		
		<form  class="w3-container w3-grey w3-padding-24 w3-right-align" method="post">
			<label>Фамилия:
				<input type="text" name="familyName">
			</label>
			
			</br>
			<label>Имя:
				<input type="text" name="firstName">
			</label>
			
			</br>
			<label>Отчество:
				<input type="text" name="secondName">
			</label>
			
			</br>
			<label>Email:
				<input type="text" name="email">
			</label>
			
			</br>
			<label>Пароль:
				<input type="pass" name="password">
			</label>
			
			</br>
			<button type="submit">Регистрация</button>
		</form>
		
		<div class="w3-container w3-center">
			<div class="w3-bar w3-padding-large w3-padding-48">
				<%
				out.println("<button class=\"w3-btn w3-blue w3-hover-light-blue w3-round-large\" " +
					"onclick=\"location.href='" + contextPath + "/'\">Главная страница</button>");
				%>
			</div>
		</div>
	</body>
	
</html>
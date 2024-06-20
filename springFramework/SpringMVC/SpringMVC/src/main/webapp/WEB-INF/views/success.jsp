<%-- page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1" --%>

<%@ page import="java.time.LocalDateTime" %> <%-- importing LocalDateTime class to be used --%>



<%@page isELIgnored="false"%> <%-- enables ${    } --%>


<!DOCTYPE html >
<html>

<head>
<meta charset=ISO-8859-1>
<title>Help Page</title>
</head>

<body>

    <h1> ${title}</h1>
    <p>${desc}</p><hr>
     <h1>Welcome ${user.username}</h1>
     <h1>Your email is ${user.email}</h1>
     <h1>Your password is ${user.password}</h1>
</body>
</html>

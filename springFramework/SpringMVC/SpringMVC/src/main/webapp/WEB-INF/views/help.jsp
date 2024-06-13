<%-- page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1" --%>

<%@ page import="java.time.LocalDateTime" %> <%-- importing LocalDateTime class to be used --%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>


<%@page isELIgnored="false"%> <%-- enables ${    } --%>


<!DOCTYPE html >
<html>

<head>
<meta charset=ISO-8859-1>
<title>Help Page</title>
</head>

<body>
     <h1>This is Help page</h1>
     <% String name = (String) request.getAttribute("name");
        String tech = (String) request.getAttribute("tech");
        LocalDateTime now = (LocalDateTime) request.getAttribute("time");
        %>

     <h1>from here you can submit any complain about our website</h1>

     <h1> name:  <%= name %> Tech:  <%= tech %> </h1>

     <h1> time is <%= now.toString() %> </h1>

     <h1> time is ${time}  </h1>

     <h1> another method to access attributes: ${name} </h1>


      ${marks}
      </h1>   <%-- explicitly call the toString method and entire list is printed --%>

        <c:forEach var="item" items="${marks}">
            <h1>${item}</h1>


        </c:forEach>
</body>
</html>

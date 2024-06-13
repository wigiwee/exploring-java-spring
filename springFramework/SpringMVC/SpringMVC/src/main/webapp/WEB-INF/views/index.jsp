<%-- page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1" --%>
<!DOCTYPE html >
<html>

<head>
<meta charset=ISO-8859-1>
<title>Home Page</title>
</head>

<body>
     <h1>This is home page</h1>
     <h1> Called By home controller</h1>
     <%String name = (String) request.getAttribute("name");%>
     <h1> name is <%= name%></h1>
</body>
</html>

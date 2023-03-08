<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="com.techpalle.util.SuccessPage" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success Home Page</title>
</head>
<body>
<%
   SuccessPage spJSP =(SuccessPage)request.getAttribute("SuccessDetails");
%>

 <header>
<h1><%=spJSP.h1 %></h1>
</header>

  <p><%=spJSP.p %></p>
  
<footer>
   <h3><%=spJSP.h3 %></h3>
</footer>

</body>
</html>
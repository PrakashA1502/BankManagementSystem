<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
  
  <h1>Customer Login Page</h1>
<form action ="logCustomer" method="post">
  <label  for="tbemail">Email :</label>
  <input type="email" name="tbemail" id="tbemail" value="<%=request.getParameter("tbEmail") %> "/>
  <br/>
  
  <label  for="tbpass">Password :</label>
  <input type="password" name="tbpass" id="tbpass" value="<%=request.getParameter("tbPass") %>"/>
  <br/>
  
  <input type="submit" value="Login"/>
 </form>
</body>
</html>
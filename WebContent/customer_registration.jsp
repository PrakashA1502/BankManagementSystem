<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REgistration Page</title>
</head>
<body>

<h1>Customer Registration page</h1>

<form action="regCustomer" method="post">

    Name : <input type="text" name="tbName" id="tbName"/>
    <br/>
    Email : <input type="email" name="tbEmail" id="tbEmail"/>
    <br/>
    Mobile : <input type="tel" name="tbMobile" id="tbMobile"/>
    <br/>
    Password : <input type="password" name="tbPass" id="tbPass"/>
    <br/>
    State : <select name="ddlstates">
            <option value="Null">--select--</option>
            <option value="Tamilnadu">TN</option>
            <option value="Karnataka">KA</option>
            <option value="Andhra Pradesh">AP</option>
            <option value="Kerala">KL</option>
    
    </select>
    <br/>
    <input type="submit" value="Register"/>
</form>
</body>
</html>
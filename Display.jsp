<%@page import="bank.bean.AccountBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import = "java.sql.ResultSet" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href = "Account.css">
</head>
<body>

<%
AccountBean bean = (AccountBean) application.getAttribute("resultset");

%>
<form action="UpdateAccountServlet_1" method = "post">
<h2>Displaying All Accounts</h2>
<table>
<tr>
<td><b>Account Number</b></td>
<td><input type="text" name = "acno" value="<%= bean.getAccountNumber() %>" readonly="readonly"></td>
</tr>
<tr>
<td><b>Customer Name</b></td>
<td><input type="text" name = "cname" value="<%= bean.getCustomerName() %>" readonly="readonly"></td>
</tr>
<tr>	   
<td><b>Contact Number(Updatable)</b></td>
<td><input type="text" name = "cnumber" value="<%= bean.getContactNumber() %>"></td>
</tr>
<tr>   
<td><b>Gender</b></td>
<td><input type="text" name = "gender"   value="<%= bean.getGender() %>" readonly="readonly"></td>
</tr>
<tr>
<td><b>Address(Updatable)</b></td>
<td><input type="text" name = "address"value="<%= bean.getAddress() %>"></td>
</tr>
<tr>
<td><b>Age</b></td>
<td><input type="text" name = "age"   value="<%= bean.getAge() %>" readonly="readonly"></td>
</tr>
<tr>
<td><b>mail-ID(Updatable)</b></td>
<td><input type="text" name = "mail-id" value="<%= bean.getMailId() %>"></td>
</tr>
<tr>
<td><b>Date</b></td>
<td><input type="text" name = "date"   value="<%= bean.getDate() %>" readonly="readonly"></td>
</tr>
<tr>
<td><b>Account Type</b></td>
<td><input type="text" name = "accountType"   value="<%= bean.getAccountType() %>" readonly="readonly"></td>
</tr>
</table><br>
<input type= "submit" value = "Update" class = "h">
<input type= "reset" value = "Reset" class = "h">

</form>
</body>
</html>
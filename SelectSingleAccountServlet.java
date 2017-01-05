package bank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.bean.AccountBean;
import bank.daoimpl.AccountDAOImpl;
import bank.dbconnection.DatabaseConnection;

public class SelectSingleAccountServlet extends HttpServlet {
	 
	 Connection connection = DatabaseConnection.getConnection();
	 ResultSet resultSet = null;
	 PreparedStatement preparedStatement = null;
		 
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doPost(request, response);
	 }   
	 
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		 response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
	 
		 int accountNumber = Integer.parseInt(request.getParameter("accountNumber"));
		 
		 AccountBean accountBean = new AccountBean(accountNumber);
		 AccountDAOImpl accountDaoImpl = new AccountDAOImpl();
		 
		 AccountBean bean = new AccountBean();
		  
		 bean =   accountDaoImpl.selectSingleAccount(accountBean);
		  
		 out.println("<html><head><style>table{box-shadow:13px 15px 42px black; background-color:white;}</style></head><body bgcolor = #1891d3><h2>Displaying All Accounts</h2>");
		 out.println("<hr></br><table cellspacing='0' cellpadding='5' border='1'>");
		 out.println("<tr>");
		 out.println("<td><b>Account Number</b></td>");
		 out.println("<td><b>Customer Name</b></td>");
		 out.println("<td><b>Contact Number</b></td>");
		 out.println("<td><b>Gender</b></td>");
		 out.println("<td><b>Address</b></td>");
		 out.println("<td><b>Age</b></td>");
		 out.println("<td><b>Mail-Id</b></td>");
		 out.println("<td><b>Date</b></td>");
		 out.println("<td><b>Account Type</b></td>");  
		 out.println("</tr>");
		 try{
			if(bean!=null) {
				out.println("<tr>");
				out.println("<td>"+bean.getAccountNumber() + "</td>");
				out.println("<td>"+bean.getCustomerName() + "</td>");
				out.println("<td>"+bean.getContactNumber() + "</td>");
				out.println("<td>"+bean.getGender() + "</td>");
				out.println("<td>"+bean.getAddress() + "</td>");
				out.println("<td>"+bean.getAge() + "</td>");
				out.println("<td>"+bean.getMailId() + "</td>");
				out.println("<td>"+bean.getDate() + "</td>");
				out.println("<td>"+bean.getAccountType() + "</td>");
				out.println("</tr>");
			}
		 }
		 catch(Exception e){
			 e.printStackTrace();
		 }
		 out.println("</table></br><hr></body></html>");
	}
}
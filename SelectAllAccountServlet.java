package bank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.bean.AccountBean;
import bank.daoimpl.AccountDAOImpl;
import bank.dbconnection.DatabaseConnection;

public class SelectAllAccountServlet extends HttpServlet {
	 
	 Connection connection = DatabaseConnection.getConnection();
	 ResultSet resultSet = null;
	 PreparedStatement preparedStatement = null;
		 
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doPost(request, response);
	 }   
	 
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
	  
		 AccountBean accountBean = new AccountBean();
		 AccountDAOImpl accountDAOImpl = new AccountDAOImpl();
		 
		 
		 ArrayList<AccountBean> arrayList = accountDAOImpl.selectAllAccount(accountBean);
	 
		 if(arrayList!=null){
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
			 
			 for(int i=0; i<arrayList.size();i++){
				 accountBean = arrayList.get(i);
				 out.println("<tr>");
					out.println("<td>"+accountBean.getAccountNumber() + "</td>");
					out.println("<td>"+accountBean.getCustomerName() + "</td>");
					out.println("<td>"+accountBean.getContactNumber() + "</td>");
					out.println("<td>"+accountBean.getGender() + "</td>");
					out.println("<td>"+accountBean.getAddress() + "</td>");
					out.println("<td>"+accountBean.getAge() + "</td>");
					out.println("<td>"+accountBean.getMailId() + "</td>");
					out.println("<td>"+accountBean.getDate() + "</td>");
					out.println("<td>"+accountBean.getAccountType() + "</td>");
				 out.println("</tr>");
			 }
			 out.println("</table></br><hr></body></html>");
		 }
		 else{
			 out.println("no records");
		 }
	}
}
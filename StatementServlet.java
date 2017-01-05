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
import bank.bean.TransactionsBean;
import bank.daoimpl.AccountDAOImpl;
import bank.daoimpl.TransactionsDAOImpl;
import bank.dbconnection.DatabaseConnection;

public class StatementServlet extends HttpServlet {
	 
	 Connection connection = DatabaseConnection.getConnection();
	 ResultSet resultSet = null;
	 PreparedStatement preparedStatement = null;
	 
	 public StatementServlet(){
		 super();
	 }
		 
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doPost(request, response);
	 }   
	 
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		 response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
	 
		 int accountNumber = Integer.parseInt(request.getParameter("accountNumber"));
		 
		 TransactionsBean transactionBean = new TransactionsBean(accountNumber);
		 TransactionsDAOImpl transactionDAOImpl = new TransactionsDAOImpl();
			
		  
		 resultSet =   transactionDAOImpl.statement(transactionBean);
		  if(resultSet!=null){
			  out.println("<html><head><style>table{box-shadow:13px 15px 42px black; background-color:white;}</style></head><body bgcolor = #1891d3><h2>Displaying Statement for the  Account Number "+transactionBean.getAccountNumber()+"</h2>");
				out.println("<hr></br><table cellspacing='0' cellpadding='5' border='1'>");
				out.println("<tr>");
				out.println("<td><b>Transaction ID</b></td>");
				out.println("<td><b>Account Number</b></td>");
				out.println("<td><b>Amount Deposited</b></td>");
				out.println("<td><b>Amount Withdrawled</b></td>");
				out.println("<td><b>Transfer Date</b></td>");  
				out.println("</tr>");

		 try{
			while(resultSet.next()) {
				
				
			
				out.println("<tr>");
				out.println("<td>"+resultSet.getString(1) + "</td>");
				out.println("<td>"+resultSet.getString(2) + "</td>");
				out.println("<td>"+resultSet.getString(3) + "</td>");
				out.println("<td>"+resultSet.getString(4) + "</td>");
				out.println("<td>"+resultSet.getString(5) + "</td>");
				out.println("</tr>");
			}
		 }
		 catch(Exception e){
			 e.printStackTrace();
		 }
		 }
		  else{
			  out.println("error");
		  }
		out.println("</table></br><hr></body></html>");
	}
}
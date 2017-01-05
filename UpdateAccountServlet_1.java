package bank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.bean.AccountBean;
import bank.daoimpl.AccountDAOImpl;
import bank.dbconnection.DatabaseConnection;
 
public class UpdateAccountServlet_1 extends HttpServlet {
	
	public UpdateAccountServlet_1(){
		super();
	}
 
	Connection connection = DatabaseConnection.getConnection();
	ResultSet resultSet = null;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
	 	response.setContentType("text/html"); 
	    PrintWriter out = response.getWriter();
 
	    try {
	    	String acno = request.getParameter("acno"); 
	    	int acno1 = Integer.parseInt(acno);
	    	String cname = request.getParameter("cname"); 
	    	String cnumber = request.getParameter("cnumber");
	    	long cnumber1 = Long.parseLong(cnumber);
	    	String gender = request.getParameter("gender"); 
	    	String address = request.getParameter("address"); 
	    	String age = request.getParameter("age"); 
	    	int age1 = Integer.parseInt(age);
	    	String mailid = request.getParameter("mail-id"); 
	    	String date = request.getParameter("date"); 
	    	String accountType = request.getParameter("accountType"); 

	    	Date cdate = null;
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			try{
				cdate = format.parse(date);
			}
			catch(Exception e){
				e.printStackTrace();
			}

			AccountBean accountBean = new AccountBean(acno1,cname,cnumber1, gender, address, age1, mailid, cdate, accountType);
			AccountDAOImpl accountDaoImpl = new AccountDAOImpl();
	    
			if(accountDaoImpl.updateAccount(accountBean)) {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Update.jsp");
				requestDispatcher.include(request, response);
			} 
			else { 
				out.println("Your data could not be updated");
			} 	 
	  }
	  catch (Exception e) {  
		   e.printStackTrace();
	  }
	}
}

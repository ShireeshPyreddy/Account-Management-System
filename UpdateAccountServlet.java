package bank.controller;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.bean.AccountBean;
import bank.daoimpl.AccountDAOImpl;

public class UpdateAccountServlet extends HttpServlet {
	PreparedStatement statement = null;
	ResultSet resultSet = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
	   
		System.out.println("acno=="+request.getParameter("accountNumber"));
		int accountNumber = Integer.parseInt(request.getParameter("accountNumber"));
		 
		AccountBean accountBean = new AccountBean(accountNumber);
		AccountDAOImpl accountDaoImpl = new AccountDAOImpl();
		
		AccountBean bean = new AccountBean();
		  
		bean = accountDaoImpl.selectSingleAccount(accountBean);
		  
		try{
			if(bean!=null) {
				ServletContext context = getServletContext();
				context.setAttribute("resultset", bean);
				response.sendRedirect("Display.jsp");
			}
	    }
		catch(Exception e){
			e.printStackTrace();
		}
   }	
}


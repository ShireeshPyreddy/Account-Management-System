package bank.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.bean.AccountBean;
import bank.bean.LoginBean;
import bank.daoimpl.AccountDAOImpl;
import bank.daoimpl.LoginDAOImpl;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UserLoginServlet() {
        super();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String mailid = request.getParameter("mailid");
		String password = request.getParameter("password");
		
		LoginBean loginBean = new LoginBean(mailid,password);
		LoginDAOImpl loginDAOImpl = new LoginDAOImpl();
		
		ResultSet resultSet = loginDAOImpl.login(loginBean);
         
		try {
			if(resultSet.next()){
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Account.html");
				requestDispatcher.include(request, response);
			}
			else{
				out.println("<h1><center>Please Enter The Correct MailID And Password<center></h1>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

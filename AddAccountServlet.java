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
import bank.daoimpl.AccountDAOImpl;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AddAccountServlet() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String customerName = request.getParameter("customerName");
		String contactNumber = request.getParameter("contactNumber");
		long cNumber = Long.parseLong(contactNumber);
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String age = request.getParameter("age");
		int cage = Integer.parseInt(age);
		String email = request.getParameter("email");
		String date = request.getParameter("date");
		String accountType = request.getParameter("account");
		
		Date cdate = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try{
			cdate = format.parse(date);
		}
		catch(Exception e){
			e.printStackTrace();
		}

		AccountBean accountBean = new AccountBean(customerName, cNumber,gender, address, cage, email, cdate, accountType);
		AccountDAOImpl accountDAOImpl = new AccountDAOImpl();
         
		if(accountDAOImpl.addAccount(accountBean)){
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/RegistrationSuccess.jsp");
			requestDispatcher.include(request, response);
		}
		else{
			out.println("Failed To Add Account");
		}
	}
}

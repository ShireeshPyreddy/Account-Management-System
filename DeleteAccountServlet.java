package bank.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.bean.AccountBean;
import bank.daoimpl.AccountDAOImpl;

import java.io.PrintWriter;

public class DeleteAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteAccountServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int accountNumber = Integer.parseInt(request.getParameter("accountNumber"));

		AccountBean accountBean= new AccountBean(accountNumber);
		AccountDAOImpl accountDAOImpl = new AccountDAOImpl();

		if(accountDAOImpl.deleteAccount(accountBean)){
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Delete.jsp");
			requestDispatcher.include(request, response);
		}
		else{
			out.println("Failed to Delete Contact ");
		}
	}
}

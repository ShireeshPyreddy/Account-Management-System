package bank.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.bean.AccountBean;
import bank.bean.TransactionsBean;
import bank.daoimpl.AccountDAOImpl;
import bank.daoimpl.TransactionsDAOImpl;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DepositAmountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DepositAmountServlet() {
        super();
    }
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String accountNumber = request.getParameter("accountNumber");
		int accountNumber1 = Integer.parseInt(accountNumber);
		String deposit = request.getParameter("deposit");
		int deposit1 = Integer.parseInt(deposit);

		TransactionsBean transactionBean = new TransactionsBean(accountNumber1, deposit1);
		TransactionsDAOImpl transactionDAOImpl = new TransactionsDAOImpl();
         
		if(transactionDAOImpl.depositAmount(transactionBean)){
			out.println("Deposit Added for the Account Number: "+transactionBean.getAccountNumber()+"<br><br>");
			out.println("Deposited Amount = "+transactionBean.getDepositAmount()+"<br><br>");
			out.println("Current balance = "+transactionBean.getBalance());
		}
		else{
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/DepositFailed.jsp");
			requestDispatcher.include(request, response);
		}
	}
}

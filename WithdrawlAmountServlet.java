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

public class WithdrawlAmountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public WithdrawlAmountServlet() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String accountNumber = request.getParameter("accountNumber");
		int accountNumber1 = Integer.parseInt(accountNumber);
		String withdrawl = request.getParameter("withdrawl");
		int withdrawl1 = Integer.parseInt(withdrawl);
		System.out.println("withdrawl amount = "+withdrawl1);

		TransactionsBean transactionBean = new TransactionsBean();
		transactionBean.setAccountNumber(accountNumber1);
		transactionBean.setWithdrawlAmount(withdrawl1);
		TransactionsDAOImpl transactionDAOImpl = new TransactionsDAOImpl();
		
		if(transactionDAOImpl.withdrawlAmount(transactionBean)){
			out.println("Amount Withdrawled from the Account Number: "+transactionBean.getAccountNumber()+"<br><br>");
			out.println("Withdrawled Amount = "+transactionBean.getWithdrawlAmount()+"<br>");
			out.println("Current Balance = " +transactionBean.getBalance());
		}
		else{
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Withdrawl Failed.jsp");
			requestDispatcher.include(request, response);
		}
	}
}

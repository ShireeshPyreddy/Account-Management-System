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

public class TransferAmountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public TransferAmountServlet() {
        super();
    }
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String accountNumber1 = request.getParameter("accountNumber1");
		int accountNumber_1 = Integer.parseInt(accountNumber1);
		String accountNumber2 = request.getParameter("accountNumber2");
		int accountNumber_2 = Integer.parseInt(accountNumber2);
		String balance = request.getParameter("amount");
		int balance1 = Integer.parseInt(balance);
		
		TransactionsBean transactionBean = new TransactionsBean(accountNumber_1, accountNumber_2, balance1 );
		TransactionsDAOImpl transactionDAOImpl = new TransactionsDAOImpl();
         
		int currentBalance = transactionDAOImpl.transferAmount(transactionBean);
			if(currentBalance>0){
			out.println("Amount Transfered"+"<br><br>");
			out.println("Amount Withdrawled From The Account Number "+transactionBean.getAccountNumber()+"<br>");
			out.println("Withdrawled Amount = "+transactionBean.getBalance()+"<br><br>");
			out.println("Current Balance = "+currentBalance+"<br><br>");
			}
			else{
				out.println("Transfer Failed");
			}
	}
}

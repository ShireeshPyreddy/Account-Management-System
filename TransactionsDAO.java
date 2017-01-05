package bank.dao;

import java.sql.ResultSet;

import bank.bean.TransactionsBean;

public interface TransactionsDAO {
	
	boolean  depositAmount(TransactionsBean transactionBean);
	boolean  withdrawlAmount(TransactionsBean transactionBean);
	int  transferAmount(TransactionsBean transactionBean);
	ResultSet  statement(TransactionsBean transactionBean);
	ResultSet  balance(TransactionsBean transactionBean);

	
}

package bank.bean;

import java.util.Date;

public class TransactionsBean {
	
	private int depositAmount;
	private int withdrawlAmount;
	private Date transferDate;
	private int accountNumber;
	private int accountNumber1;
	private int balance;

	public TransactionsBean(){
		super();
	}
	
	public TransactionsBean(int accountNumber){
		this.accountNumber = accountNumber;
	}
	
	public TransactionsBean(int accountNumber, int depositAmount){
		super();
		this.accountNumber = accountNumber;
		this.depositAmount = depositAmount;
	}
	
	public TransactionsBean(int accountNumber, int accountNumber1, int balance){
		super();
		this.accountNumber = accountNumber;
		this.accountNumber1 = accountNumber1;
		this.balance = balance;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getDepositAmount() {
		return depositAmount;
	}
	public void setDepositAmount(int depositAmount) {
		this.depositAmount = depositAmount;
	}
	public int getWithdrawlAmount() {
		return withdrawlAmount;
	}
	public void setWithdrawlAmount(int withdrawlAmount) {
		this.withdrawlAmount = withdrawlAmount;
	}
	public Date getTransferDate() {
		return transferDate;
	}
	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
	}
	public int getAccountNumber1() {
		return accountNumber1;
	}

	public void setAccountNumber1(int accountNumber1) {
		this.accountNumber1 = accountNumber1;
	}
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
}

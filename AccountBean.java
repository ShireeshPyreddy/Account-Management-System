package bank.bean;

import java.util.Date;

public class AccountBean {
	
	private String customerName;
	private long contactNumber;
	private String gender;
	private String address;
	private int age;
	private String mailId;
	private Date date;
	private String accountType;
	private int accountNumber;
	
	public AccountBean(){
		super();
	}
	public AccountBean(int accountNumber){
		super();
		this.accountNumber = accountNumber;
	}
	public AccountBean(String customerName, long contactNumber, String gender, String address, int age, String mailId, Date date, String accountType){
		super();
		this.customerName = customerName;
		this.contactNumber = contactNumber;
		this.gender = gender;
		this.address = address;
		this.age = age;
		this.mailId = mailId;
		this.date = date;
		this.accountType = accountType;
	}
	public AccountBean(int accountNumber, String customerName, long contactNumber, String gender, String address, int age, String mailId, Date date, String accountType){
		super();
		this.accountNumber = accountNumber;
		this.customerName = customerName;
		this.contactNumber = contactNumber;
		this.gender = gender;
		this.address = address;
		this.age = age;
		this.mailId = mailId;
		this.date = date;
		this.accountType = accountType;
	}
	
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}		
}
	

package bank.bean;

public class LoginBean {
	
	private String mailID;
	private String password;
	
	
	public LoginBean(){
		
	}
	
	public LoginBean(String mailID, String password){
		this.mailID = mailID;
		this.password = password;
	}
	
	
	public String getMailID() {
		return mailID;
	}
	public void setMailID(String mailID) {
		this.mailID = mailID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
}

package bank.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import bank.bean.AccountBean;
import bank.dao.AccountDAO;
import bank.dbconnection.DatabaseConnection;

public class AccountDAOImpl implements AccountDAO {
	
	public AccountDAOImpl() {
        super();
    }
	
	Connection connection = DatabaseConnection.getConnection();
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;
	
	public boolean addAccount(AccountBean accountBean) {
		
		try{
			preparedStatement = connection.prepareStatement("insert into Customer(customerName, contactNumber,gender, address, age, mailId, createDate, accountType)values(?,?,?,?,?,?,?,?)");
			
			preparedStatement.setString(1,accountBean.getCustomerName());
			preparedStatement.setLong(2,accountBean.getContactNumber());
			preparedStatement.setString(3,accountBean.getGender());
			preparedStatement.setString(4,accountBean.getAddress());
			preparedStatement.setLong(5,accountBean.getAge());
			preparedStatement.setString(6,accountBean.getMailId());
			Date date = accountBean.getDate(); 
			java.sql.Date cdate = new java.sql.Date(date.getTime()); 
			preparedStatement.setDate(7,cdate);
			preparedStatement.setString(8, accountBean.getAccountType());
			int a = preparedStatement.executeUpdate();
			
			preparedStatement = connection.prepareStatement("select * from customer");
			
			resultSet = preparedStatement.executeQuery();
			if(resultSet!=null){
				resultSet.afterLast();
				resultSet.previous();
				int accountNumber = (resultSet.getInt(1));
				preparedStatement = connection.prepareStatement("insert into account values(?,?)");
				preparedStatement.setInt(1, accountNumber);
				preparedStatement.setInt(2, 0);
				
				int n = preparedStatement.executeUpdate();
			}
			
			if(a>0){
				System.out.println("true");
				return true;
			}
			else{
				return false;
			}
		}		
		catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteAccount(AccountBean accountBean) {
		
		try{
			int n = 0;
			preparedStatement = connection.prepareStatement("select * from customer");
			resultSet = preparedStatement.executeQuery();

			preparedStatement = connection.prepareStatement("delete from Customer where accountNumber = ?");
			
			preparedStatement.setInt(1,accountBean.getAccountNumber());
				
			int a = preparedStatement.executeUpdate();
			
			
			if(resultSet!=null){
				resultSet.afterLast();
				resultSet.previous();
				int accountNumber = (resultSet.getInt(1));
				preparedStatement = connection.prepareStatement("delete from account where accountNumber = ?");
				preparedStatement.setInt(1, accountNumber);
				
				n = preparedStatement.executeUpdate();
			}
			
			if(a>0&&n>0){
				System.out.println("true");
				return true;
			}
			else{
				return false;
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<AccountBean> selectAllAccount(AccountBean accountBean) {
		ArrayList<AccountBean> arrayList = new ArrayList<AccountBean>();
		try{
			preparedStatement = connection.prepareStatement("select * from Customer");
							
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				//AccountBean bean = new AccountBean();
				int accountNumber = resultSet.getInt(1);
				String customerName = resultSet.getString(2);
				long contactNumber = resultSet.getLong(3);
				String gender = resultSet.getString(4);
				String address = resultSet.getString(5);
				int age = resultSet.getInt(6);
				String mailId = resultSet.getString(7);
				Date createDate = resultSet.getDate(8);
				String accountType = resultSet.getString(9);
				
				AccountBean bean = new AccountBean(accountNumber,customerName,contactNumber,gender, address, age, mailId,createDate, accountType);
				
				arrayList.add(bean);
				
			}
			return arrayList;
		}		
		catch (Exception e){
			e.printStackTrace();
		}
		return null;
    }
	
	public AccountBean selectSingleAccount(AccountBean accountBean) {
		
		try{
			preparedStatement = connection.prepareStatement("select * from Customer where accountNumber = ? ");
			
			preparedStatement.setInt(1,accountBean.getAccountNumber());
			
			resultSet = preparedStatement.executeQuery();
						
			if(resultSet.next()){
				System.out.println("true");
				int accountNumber = resultSet.getInt(1);
				String customerName = resultSet.getString(2);
				long contactNumber = resultSet.getLong(3);
				String gender = resultSet.getString(4);
				String address = resultSet.getString(5);
				int age = resultSet.getInt(6);
				String mailId = resultSet.getString(7);
				Date createDate = resultSet.getDate(8);
				String accountType = resultSet.getString(9);
				
				accountBean = new AccountBean(accountNumber,customerName,contactNumber,gender, address, age, mailId,createDate, accountType);
				
				return accountBean;
			}
			else{
				return null;
			}
		}		
		catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public boolean updateAccount(AccountBean accountBean) {
		
		try{
		  preparedStatement = connection.prepareStatement("update customer set accountNumber = ?, customerName = ?, contactNumber=? , gender = ?, address=?, age = ?, mailId = ?, createDate = ?, accountType = ? where customerName= ?");
	      
		  preparedStatement.setInt(1,accountBean.getAccountNumber()); 
	      preparedStatement.setString(2,accountBean.getCustomerName()); 
	      preparedStatement.setLong(3,accountBean.getContactNumber()); 
	      preparedStatement.setString(4,accountBean.getGender()); 
	      preparedStatement.setString(5,accountBean.getAddress()); 
	      preparedStatement.setInt(6,accountBean.getAge()); 
	      preparedStatement.setString(7,accountBean.getMailId()); 
	      Date date = accountBean.getDate(); 
	      java.sql.Date cdate = new java.sql.Date(date.getTime()); 
	      preparedStatement.setDate(8,cdate);
	      preparedStatement.setString(9,accountBean.getAccountType()); 
	      preparedStatement.setString(10,accountBean.getCustomerName()); 

	      int i = preparedStatement.executeUpdate(); 
	      
	      if(i>0){
				System.out.println("true");
				return true;
			}
			else{
				return false;
			}
		}		
		catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}
}

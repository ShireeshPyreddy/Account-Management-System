package bank.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import bank.bean.AccountBean;
import bank.bean.TransactionsBean;
import bank.dao.TransactionsDAO;
import bank.dbconnection.DatabaseConnection;

public class TransactionsDAOImpl implements TransactionsDAO {
	
	public TransactionsDAOImpl(){
		super();
	}
	
	Connection connection = DatabaseConnection.getConnection();
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet1 = null;

	public boolean depositAmount(TransactionsBean transactionBean) {
				
		try{
			preparedStatement = connection.prepareStatement("select * from account where accountNumber = ?");
				
			preparedStatement.setInt(1,transactionBean.getAccountNumber());
				
			resultSet = preparedStatement.executeQuery();
			
			int a = 0;
			
			if(resultSet.next()){
				preparedStatement = connection.prepareStatement("update account set balance = (balance+?) where accountNumber = ?");
				
				preparedStatement.setInt(1, transactionBean.getDepositAmount());
				preparedStatement.setInt(2, transactionBean.getAccountNumber());
				
				preparedStatement.executeUpdate();
				
				int balance = resultSet.getInt(2);
				
				transactionBean.setBalance((balance+transactionBean.getDepositAmount()));
				preparedStatement = connection.prepareStatement("insert into transaction(accountNumber, depositAmount, withdrawlAmount, transferDate)values(?,?,?,now())");
				
				preparedStatement.setInt(1, transactionBean.getAccountNumber());
				preparedStatement.setInt(2,transactionBean.getDepositAmount());
				preparedStatement.setInt(3, transactionBean.getWithdrawlAmount());
				
				a = preparedStatement.executeUpdate();
			}
			
			/*else{
				preparedStatement = connection.prepareStatement("insert into account values(?,?)");
				
				preparedStatement.setInt(1, transactionBean.getAccountNumber());
				preparedStatement.setInt(2, transactionBean.getDepositAmount());
					
				preparedStatement.executeUpdate();
					
				int balance = resultSet.getInt(2);
				
				transactionBean.setBalance(balance);
			}*/
			if(a>0){
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

	public boolean withdrawlAmount(TransactionsBean transactionBean) {
					
		try{
			preparedStatement = connection.prepareStatement("select * from account where accountNumber = ?");
			
			preparedStatement.setInt(1,transactionBean.getAccountNumber());
			
			resultSet = preparedStatement.executeQuery();
				
			if(resultSet.next()){
				int balance = resultSet.getInt(2);
					
				if(balance>=transactionBean.getWithdrawlAmount()){
					preparedStatement = connection.prepareStatement("update account set balance = (balance-?) where accountNumber = ?");
					
					preparedStatement.setInt(1, transactionBean.getWithdrawlAmount());
					preparedStatement.setInt(2, transactionBean.getAccountNumber());
					
					preparedStatement.executeUpdate();
					
					transactionBean.setBalance((balance-transactionBean.getWithdrawlAmount()));
					
					preparedStatement = connection.prepareStatement("insert into transaction(accountNumber, depositAmount, withdrawlAmount, transferDate)values(?,?,?,now())");
					
					preparedStatement.setInt(1, transactionBean.getAccountNumber());
					preparedStatement.setInt(2,transactionBean.getDepositAmount());
					preparedStatement.setInt(3, transactionBean.getWithdrawlAmount());
					
					preparedStatement.executeUpdate();

					return true;
				}
				else{
					return false;
				}
			}
		}		
		catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}

	public int transferAmount(TransactionsBean transactionBean) {
					
		try{		
			preparedStatement = connection.prepareStatement("select * from account where accountNumber = ?");
			
			preparedStatement.setInt(1,transactionBean.getAccountNumber());
				
			resultSet = preparedStatement.executeQuery();
			
			preparedStatement = connection.prepareStatement("select * from account where accountNumber = ?");
			
			preparedStatement.setInt(1,transactionBean.getAccountNumber1());
				
			resultSet1 = preparedStatement.executeQuery();
			
			if(resultSet.next() && resultSet1.next()){
				
			preparedStatement = connection.prepareStatement("update account set balance = (balance-?) where accountNumber = ?");
			
			preparedStatement.setInt(1, transactionBean.getBalance());
			preparedStatement.setInt(2, transactionBean.getAccountNumber());
			
			preparedStatement.executeUpdate();
							
			preparedStatement = connection.prepareStatement("update account set balance = (balance+?) where accountNumber = ?");
			
			preparedStatement.setInt(1, transactionBean.getBalance());
			preparedStatement.setInt(2, transactionBean.getAccountNumber1());
			
			preparedStatement.executeUpdate();
				
			preparedStatement = connection.prepareStatement("insert into transaction(accountNumber,depositAmount, withdrawlAmount, transferDate ) values(?,?,?,now()) ");
			
			preparedStatement.setInt(1, transactionBean.getAccountNumber());
			preparedStatement.setInt(2,transactionBean.getDepositAmount());
			preparedStatement.setInt(3,transactionBean.getBalance());
			
			preparedStatement.executeUpdate();
				
			preparedStatement = connection.prepareStatement("insert into transaction(accountNumber,depositAmount, withdrawlAmount, transferDate ) values(?,?,?,now()) ");
			
			preparedStatement.setInt(1, transactionBean.getAccountNumber1());
			preparedStatement.setInt(2,transactionBean.getBalance());
			preparedStatement.setInt(3,transactionBean.getWithdrawlAmount());
			
			preparedStatement.executeUpdate();

			preparedStatement = connection.prepareStatement("select * from account where accountNumber = ?");
			preparedStatement.setInt(1, transactionBean.getAccountNumber());
			System.out.println(preparedStatement);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int balance = resultSet.getInt(2);
			System.out.print(balance);
			return balance;
			}
		}		
		catch (Exception e){
			e.printStackTrace();
		}
		return 0;
	}

	public ResultSet statement(TransactionsBean transactionBean) {
					
		try{
			preparedStatement = connection.prepareStatement("select * from transaction where accountNumber = ?");
			
			preparedStatement.setInt(1,transactionBean.getAccountNumber());
			
			resultSet = preparedStatement.executeQuery();
				
			return resultSet;
		}		
		catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public ResultSet balance(TransactionsBean transactionBean) {
		try{
			preparedStatement = connection.prepareStatement("select * from account where accountNumber = ?");
			
			preparedStatement.setInt(1,transactionBean.getAccountNumber());
			
			resultSet = preparedStatement.executeQuery();
				
			return resultSet;
		}		
		catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
}

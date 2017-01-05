package bank.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import bank.bean.LoginBean;
import bank.dao.UserLoginDAO;
import bank.dbconnection.DatabaseConnection;

public class LoginDAOImpl implements UserLoginDAO {
	
	Connection connection = DatabaseConnection.getConnection();
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;

	public ResultSet login(LoginBean loginBean) {
		// TODO Auto-generated method stub
		try{
			preparedStatement = connection.prepareStatement("select * from userLogin where mailId = ? and password = ?");
			
			preparedStatement.setString(1,loginBean.getMailID());
			preparedStatement.setString(2,loginBean.getPassword());

			resultSet = preparedStatement.executeQuery();
			if(resultSet!=null){
				return resultSet;
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

}

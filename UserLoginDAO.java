package bank.dao;

import java.sql.ResultSet;

import bank.bean.LoginBean;

public interface UserLoginDAO {
	ResultSet login(LoginBean loginBean);
}

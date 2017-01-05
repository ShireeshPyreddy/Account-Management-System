package bank.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import bank.bean.AccountBean;

public interface AccountDAO {
		
	boolean addAccount(AccountBean accountBean);
	boolean deleteAccount(AccountBean accountBean);
	ArrayList<AccountBean> selectAllAccount(AccountBean accountBean);
	AccountBean selectSingleAccount(AccountBean accountBean);
	boolean updateAccount(AccountBean accountBean);

}

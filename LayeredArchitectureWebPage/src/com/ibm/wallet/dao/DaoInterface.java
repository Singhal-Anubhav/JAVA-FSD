package com.ibm.wallet.dao;

import java.util.List;

import com.ibm.wallet.bean.*;

public interface DaoInterface {
	
	int insertData(Bean b);
	int updateName(Bean b);
	int updateNumber(Bean b);
	Bean getBalance(Bean b);
	boolean checkBalance(Bean b);
	int depositInAccount(Bean b);
	int withdrawFromAccount(Bean b);
	List<Bean> getTransaction(Bean b);
	List<Bean> getAllData(Bean b);
	int checkPassword(Bean b);
	
	

}

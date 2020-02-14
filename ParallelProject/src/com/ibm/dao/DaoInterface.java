package com.ibm.dao;

import java.sql.Connection;


public  interface DaoInterface {
	
	
	void insertCustomerDetails(Connection dbCon, String Name, double Phone_Number, String Aadhar_Number,int Balance);
	void updateCustomerDetails(Connection dbCon,int n);
	void moneyWithdrawal(Connection dbCon);
	void moneyDeposit(Connection dbCon);
	void AccountToAccountTransfer(Connection dbCon);
    void getCustomerdetails(Connection dbCon);
    void getTransactiondetails(Connection dbCon);
    public void getBalance(Connection dbCon);
}

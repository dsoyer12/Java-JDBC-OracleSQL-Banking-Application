package com.revature.dao;

import java.io.IOException;
import java.util.List;

import com.revature.beans.ACCOUNT;

public interface Dao2 {


		public List<ACCOUNT> getAccount() throws IOException;
		public ACCOUNT getAccountbyId(int id) throws IOException;
		public void createAccount(ACCOUNT account);
		public void updateAccount(ACCOUNT account);
		public void deleteAccount(ACCOUNT account);
		
		
	
}

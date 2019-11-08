package com.revature.dao;


import java.io.IOException;
import java.util.List;

import com.revature.beans.ACCOUNT;
import com.revature.beans.BANK_USER;


public interface Dao {

	public List<BANK_USER> getUser() throws IOException;
	public BANK_USER getUserbyId(int id) throws IOException;
	
	public void updateUser(BANK_USER user);
	public void deleteUser(BANK_USER user);
	BANK_USER createUser();
	
}


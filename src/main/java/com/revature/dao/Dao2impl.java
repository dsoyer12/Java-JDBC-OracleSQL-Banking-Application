package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.ACCOUNT;
import com.revature.beans.BANK_USER;

import com.revature.util.ConnectionUtil;

public class Dao2impl implements Dao2{
	
	@Override
	public List<ACCOUNT> getAccount() throws IOException {
		List<ACCOUNT> cl = new ArrayList<>();
		// try-with-resources... resources included in the try args will be closed at the end of the block
		// works with all AutoCloseable resources
		try (Connection conn = ConnectionUtil.getConnection("src\\main\\java\\connection.properties")) {
			String sql = "SELECT * FROM BANK_ACCOUNT";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				
				int ACCOUNT_ID = rs.getInt("ACCOUNT_ID");
				
				int USER_ID = rs.getInt("USER_ID");
				
				double BALANCE = rs.getDouble("BALANCE");
				
				int ACCOUNT_TYPE = rs.getInt("ACCOUNT_TYPE");
				
				
				cl.add(new ACCOUNT(ACCOUNT_ID, USER_ID,BALANCE,ACCOUNT_TYPE));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return cl;
	}

	@Override
	public ACCOUNT getAccountbyId(int id) {
		ACCOUNT c = null;
		// try-with-resources... resources included in the try args will be closed at the end of the block
		// works with all AutoCloseable resources
		try (Connection conn = ConnectionUtil.getConnection("src\\main\\java\\connection.properties")) {
			String sql = "SELECT * FROM ACCOUNT WHERE ACCOUNT_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				
int ACCOUNT_ID = rs.getInt("ACCOUNT_ID");
				
				int USER_ID = rs.getInt("USER_ID");
				
				double BALANCE = rs.getDouble("BALANCE");
				
				int ACCOUNT_TYPE = rs.getInt("ACCOUNT_TYPE");
				c= new ACCOUNT(ACCOUNT_ID, USER_ID,BALANCE,ACCOUNT_TYPE);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return c;
	}

	@Override
	public void createAccount(ACCOUNT department) {
		// TODO Auto-generated method stub
		
	}


	

	@Override
	public void updateAccount(ACCOUNT account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAccount(ACCOUNT account) {
		// TODO Auto-generated method stub
		
	}
}
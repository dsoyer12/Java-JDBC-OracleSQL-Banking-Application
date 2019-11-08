package com.revature.beans;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.util.ConnectionUtil;

public class ADMIN {

	public static void ViewAllAccounts() {
		
		
		try (Connection conn = ConnectionUtil.getConnection("src\\main\\java\\connection.properties")) {
			String sql = "SELECT * FROM BANK_ACCOUNT A INNER JOIN BANK_USER B ON A.ACCOUNT_ID = B.ACCOUNT_ID ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {

				float balance = rs.getFloat("BALANCE");
				
				int id = rs.getInt("USER_ID");
				int Accid = rs.getInt("ACCOUNT_ID");
				String Name= rs.getString("USER_NAME");

				String fname = rs.getString("USER_FIRSTNAME");
				String lname = rs.getString("USER_LASTNAME");
				
				System.out.println("USER ID:"+id +" | USER ACCOUNT:"+ Accid +" | USER NAME:"+ Name+" | NAME:" + fname +" "+ lname + " | BALANCE:" + balance);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
	}
public static void DeleteAccount(int accid) {
		
	float balance = 0;
		try (Connection conn = ConnectionUtil.getConnection("src\\main\\java\\connection.properties")) {
			String sql = "SELECT * FROM BANK_ACCOUNT A INNER JOIN BANK_USER B ON A.ACCOUNT_ID = B.ACCOUNT_ID WHERE A.ACCOUNT_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, accid);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {

			     balance = rs.getFloat("BALANCE");
				
				int id = rs.getInt("USER_ID");
				int Accid = rs.getInt("ACCOUNT_ID");
				String Name= rs.getString("USER_NAME");

				String fname = rs.getString("USER_FIRSTNAME");
				String lname = rs.getString("USER_LASTNAME");
				
				System.out.println("USER ID:"+id +" | USER ACCOUNT:"+ Accid +" | USER NAME:"+ Name+" | NAME:" + fname +" "+ lname + " | BALANCE:" + balance);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	if (balance == 0) {
		
		try (Connection conn = ConnectionUtil.getConnection("src\\main\\java\\connection.properties")) {
			String sql = "DELETE * FROM BANK_ACCOUNT WHERE ACCOUNT_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, accid);
			pstmt.execute();
			sql = "DELETE * FROM BANK_USER WHERE ACCOUNT_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, accid);
			pstmt.execute();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	else {System.out.println("");
		System.out.println("cannot delete user. The user has funds in their account");}
		
	}

static void viewAccount(int accid) {
	

	try (Connection conn = ConnectionUtil.getConnection("src\\main\\java\\connection.properties")) {
		String sql = "SELECT * FROM BANK_ACCOUNT A INNER JOIN BANK_USER B ON A.ACCOUNT_ID = B.ACCOUNT_ID WHERE A.ACCOUNT_ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, accid);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {

			float balance = rs.getFloat("BALANCE");
			
			int id = rs.getInt("USER_ID");
			int Accid = rs.getInt("ACCOUNT_ID");
			String Name= rs.getString("USER_NAME");

			String fname = rs.getString("USER_FIRSTNAME");
			String lname = rs.getString("USER_LASTNAME");
			
			System.out.println("USER ID:"+id +" | USER ACCOUNT:"+ Accid +" | USER NAME:"+ Name+" | NAME:" + fname +" "+ lname + " | BALANCE:" + balance);

		}
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (IOException e1) {
		e1.printStackTrace();
	}
	
	
	
	
	
	
}

static void viewTransactions(int accid) {
	

	try (Connection conn = ConnectionUtil.getConnection("src\\main\\java\\connection.properties")) {
		String sql = "SELECT * FROM TRANSACTIONS WHERE ACCOUNT_ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, accid);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {

			float balance = rs.getFloat("AMOUNT");
			
			
			int Accid = rs.getInt("ACCOUNT_ID");
			String TIME= rs.getString("TIME");

			int TRANSACTIONID = rs.getInt("TRANSID");
			
			
			System.out.println("USER ACCOUNT:"+ Accid +" | TIME:" + TIME +" "+  " | AMOUNT:" + balance+  " | TRANSACTION ID:" + TRANSACTIONID);

		}
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (IOException e1) {
		e1.printStackTrace();
	}
	
	
	
	
	
	
}
	
}

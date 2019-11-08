package com.revature.beans;
import java.text.SimpleDateFormat; 
import java.util.Date;  

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;

import com.revature.util.ConnectionUtil;

public class ACC_BALANCE {
	private static Connection con;

	public static double getBalance(int id) {
		double balance = 0;
		// try-with-resources... resources included in the try args will be closed at
		// the end of the block
		// works with all AutoCloseable resources
		try (Connection conn = ConnectionUtil.getConnection("src\\main\\java\\connection.properties")) {
			String sql = "SELECT BALANCE FROM BANK_ACCOUNT A INNER JOIN BANK_USER B ON A.ACCOUNT_ID = B.ACCOUNT_ID WHERE A.ACCOUNT_ID = ? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {

				balance = rs.getFloat("BALANCE");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		return balance;
	}

	public static void withdrawBalance(float withdrawal,int ACCOUNT_ID) throws SQLException, IOException {
		double balance = 0;
		
		
		balance = ACC_BALANCE.getBalance(ACCOUNT_ID);
		
		System.out.println(balance);
		if((balance>withdrawal)&&(withdrawal>0)){
			try(Connection con = ConnectionUtil.getConnection("src\\main\\java\\connection.properties")){
				
				
				balance = balance - withdrawal;
				CallableStatement cstmt = con.prepareCall("UPDATE BANK_ACCOUNT SET BALANCE = ? WHERE ACCOUNT_ID = ?");
				cstmt.setDouble(1, balance);
				cstmt.setInt(2, ACCOUNT_ID);
				cstmt.executeQuery();
			}catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}}
		
			
			
			else System.out.println("Insufficient funds to complete transaction");
		


		try(Connection con = ConnectionUtil.getConnection("src\\main\\java\\connection.properties")){
			
			
			
			CallableStatement cstmt = con.prepareCall("INSERT INTO TRANSACTIONS\r\n" + 
					"(AMOUNT, ACCOUNT_ID,TIME )\r\n" + 
					"VALUES\r\n" + 
					"(?, ?, to_date(?,'DD/MM/YYYY'))");
			cstmt.setDouble(1, withdrawal*-1);
			cstmt.setInt(2, ACCOUNT_ID);
			Date date = new Date();  
		    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		    String strDate= formatter.format(date); 
		    cstmt.setString(3, strDate);
			cstmt.executeQuery();
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	
	
	
		System.out.println("Cash Withdrawn"
				+ "");

	}
	public static void DepositBalance(float deposit,int ACCOUNT_ID) throws SQLException, IOException {
		double balance = 0;
		
		
		
		
		balance = ACC_BALANCE.getBalance(ACCOUNT_ID);
		
			try(Connection con = ConnectionUtil.getConnection("src\\main\\java\\connection.properties")){
				
				
				balance = balance + deposit;
				CallableStatement cstmt = con.prepareCall("UPDATE BANK_ACCOUNT SET BALANCE = ? WHERE ACCOUNT_ID = ?");
				cstmt.setDouble(1, balance);
				cstmt.setInt(2, ACCOUNT_ID);
				cstmt.executeQuery();
			}catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		
			
			
			
			balance = ACC_BALANCE.getBalance(ACCOUNT_ID);

			System.out.println(balance);
			

			try(Connection con = ConnectionUtil.getConnection("src\\main\\java\\connection.properties")){
				
				
				balance = balance + deposit;
				CallableStatement cstmt = con.prepareCall("INSERT INTO TRANSACTIONS\r\n" + 
						"(AMOUNT, ACCOUNT_ID,TIME )\r\n" + 
						"VALUES\r\n" + 
						"(?, ?, to_date(?,'DD/MM/YYYY'))");
				cstmt.setDouble(1, deposit);
				cstmt.setInt(2, ACCOUNT_ID);
				Date date = new Date();  
			    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
			    String strDate= formatter.format(date); 
			    cstmt.setString(3, strDate);
				cstmt.executeQuery();
			}catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	
	
		System.out.println("Cash Deposited");

	}
}

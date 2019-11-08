package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.ACCOUNT;
import com.revature.beans.BANK_USER;

import com.revature.util.ConnectionUtil;

public class Daoimpl implements Dao{
	
	private Scanner accin;

	@Override
	public List<BANK_USER> getUser() {
		List<BANK_USER> cl = new ArrayList<>();
		// try-with-resources... resources included in the try args will be closed at the end of the block
		// works with all AutoCloseable resources
		try (Connection conn = ConnectionUtil.getConnection("src\\main\\java\\connection.properties")) {
			String sql = "SELECT * FROM BANK_USER";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				
				int USER_ID = rs.getInt("USER_ID");
				String USER_FIRSTNAME = rs.getString("USER_FIRSTNAME");
				String USER_LASTNAME = rs.getString("USER_LASTNAME");
				String USER_NAME = rs.getString("USER_NAME");
				
				int ACCOUNT_ID = rs.getInt("ACCOUNT_ID");
				cl.add( new BANK_USER( USER_ID,  USER_FIRSTNAME,USER_LASTNAME, ACCOUNT_ID,USER_NAME));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return cl;
	}

	@Override
	public BANK_USER getUserbyId(int id) {
		BANK_USER c = null;
		// try-with-resources... resources included in the try args will be closed at the end of the block
		// works with all AutoCloseable resources
		try (Connection conn = ConnectionUtil.getConnection("src\\main\\java\\connection.properties")) {
			String sql = "SELECT * FROM BANK_USER WHERE USER_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int USER_ID = rs.getInt("USER_ID");
				String USER_FIRSTNAME = rs.getString("USER_FIRSTNAME");
				String USER_LASTNAME = rs.getString("USER_LASTNAME");
				String USER_NAME = rs.getString("USER_NAME");
				
				int ACCOUNT_ID = rs.getInt("ACCOUNT_ID");
				
				c = new BANK_USER( USER_ID,  USER_FIRSTNAME,USER_LASTNAME, ACCOUNT_ID,USER_NAME);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return c;
	}


	@Override
	public void updateUser(BANK_USER employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(BANK_USER employee) {
		// TODO Auto-generated method stub
		
	}

	public BANK_USER createUser() {
		BANK_USER c = null;
		// TODO Auto-generated method stub
		int type = 1;
		int accid = 0;
		double balance = 0;
		
		
		String choice;
boolean checking = true;
		boolean yn = true;
		while(yn)
		{
		    System.out.println("please enter the amount of money you would like to deposit");
		    accin = new Scanner (System.in);
		    String tempbal;
		    boolean isdouble = false;
		    while(isdouble == false) {
		   try { 
			   tempbal = accin.nextLine();
			   balance =  Double.parseDouble(tempbal);
		   isdouble = true;}
		   catch (InputMismatchException e) {
			   
			 System.out.println("Please enter a number");
		   }catch (NumberFormatException d) {
			   
			 System.out.println("Please enter a number");
		   }}

		    System.out.println("Will this be a checking account?");

		    System.out.println("enter : yes or no");
		    choice = accin.nextLine();


		    switch(choice)
		    {
		        case "yes":
		            yn = false;
		            
		            break;

		        case "no":
		            yn = false;
		            checking = false;
		            break;

		        default:
		            System.out.println("please enter again ");
		            boolean repeat = true;

		            while (repeat)
		            {
		                System.out.println("Will this be a checking account? : yes or no");
		                choice = accin.nextLine();

		                switch (choice)
		                {
		                    case "yes":
		                        yn = repeat = false;
		                        break;

		                    case "no":
		                        yn = repeat = false;
		                        checking = false;
		                        break;
		                }
		            }
		            break;
		    }
		}
		if (checking == false) {
			
			type = 0;
		}
		try (Connection conn = ConnectionUtil.getConnection("src\\main\\java\\connection.properties")) {
			String sql = "BEGIN INSERT INTO BANK_ACCOUNT (BALANCE, ACCOUNT_TYPE) VALUES (-965, ?); END;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, type);
			ResultSet rs;
			pstmt.execute();

			
			 sql = "SELECT * FROM BANK_ACCOUNT WHERE BALANCE = -965";
			 pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
				accid = rs.getInt("ACCOUNT_ID");
								
						
								
							}
			
			
			    System.out.println("please enter a username");
			    Scanner accin = new Scanner (System.in);
			    String username = accin.nextLine();
			  

			    System.out.println("please enter your first name");
			    String fname = accin.nextLine();
			    
			    System.out.println("please enter your last name");
			    String lname = accin.nextLine();
			    System.out.println("please enter your password");
			    String password = accin.nextLine();

			 
			
//			 sql = "UPDATE BANK_USER SET ACCOUNT_ID= ? WHERE ACCOUNT_ID IS NULL";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, accid);
//			 rs = pstmt.executeQuery();
			
			
			 sql = "{call NEW_ACC(?, ?,?,?,?)}";
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setString(1, fname);
			 pstmt.setString(2, lname);
			 pstmt.setString(3, password);
			 pstmt.setInt(4, accid);
			 pstmt.setString(5,username);
			 
			 
			
			 
				pstmt.executeQuery();
				
				 sql = "UPDATE BANK_ACCOUNT SET BALANCE = ? WHERE ACCOUNT_ID = ? ";
				 pstmt = conn.prepareStatement(sql);
				pstmt.setDouble(1, balance);
				pstmt.setInt(2, accid);
				
				pstmt.execute();
			
			 sql = "SELECT * FROM BANK_USER WHERE USER_NAME = ?";
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setString(1,username);
			
			 
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
int ACCOUNT_ID = rs.getInt("ACCOUNT_ID");
				
				int USER_ID = rs.getInt("USER_ID");
				String USER_FIRSTNAME= rs.getString("USER_FIRSTNAME");
				String USER_LASTNAME = rs.getString("USER_LASTNAME");
				String USER_NAME = rs.getString("USER_NAME");
				
				
				
				
				c= new BANK_USER(USER_ID,USER_FIRSTNAME,USER_LASTNAME,ACCOUNT_ID,USER_NAME);
				System.out.println("USER CREATED");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return c;
		
		
		
		
	}
}

package com.revature.beans;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.util.ConnectionUtil;

public class Login {
	
	public Login() throws SQLException, IOException, InterruptedException{

		BANK_USER c = null;
		// TODO Auto-generated method stub
		
		
		
		
		
		String choice;

String username = null;
String password = null;
		boolean choices = true;
		
		  while(choices) { System.out.println("Please enter your username");
		    Scanner accin = new Scanner (System.in);
		     username = accin.nextLine();
		    System.out.println("Please enter your password");
		     password = accin.nextLine();

		try (Connection conn = ConnectionUtil.getConnection("src\\main\\java\\connection.properties")) {
			String sql = "SELECT COUNT(USER_NAME) AS COUNT FROM BANK_USER A INNER JOIN BANK_ACCOUNT B ON A.ACCOUNT_ID = B.ACCOUNT_ID WHERE USER_NAME = ? AND PASSWORD = ? GROUP BY A.USER_NAME";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs= pstmt.executeQuery();

			while(rs.next()) {
				
				int checker = rs.getInt("COUNT");
				
				if(checker==1) {
					
					
					System.out.println("Logging You in");
					Thread.sleep(1000);
					System.out.print(".");
					Thread.sleep(1000);
					System.out.print(".");
					Thread.sleep(1000);
					System.out.print(".");
					Thread.sleep(1000);
					System.out.print(".");
					System.out.println(" ");
					
					choices=false;
					
				}
				else {
					
					System.out.println("Username and Password Not Found");
				}
								
						
								
							}}}
			try (Connection conn = ConnectionUtil.getConnection("src\\main\\java\\connection.properties")) {
				String sql = "SELECT * FROM BANK_USER A INNER JOIN BANK_ACCOUNT B ON A.ACCOUNT_ID = B.ACCOUNT_ID WHERE USER_NAME = ? AND PASSWORD = ? ";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, username);
				pstmt.setString(2, password);
				ResultSet rs= pstmt.executeQuery();

				while(rs.next()) {
					
					int ACCOUNT_ID = rs.getInt("ACCOUNT_ID");
					
					int USER_ID = rs.getInt("USER_ID");
					String USER_FIRSTNAME= rs.getString("USER_FIRSTNAME");
					String USER_LASTNAME = rs.getString("USER_LASTNAME");
					String USER_NAME = rs.getString("USER_NAME");
					c= new BANK_USER(USER_ID,USER_FIRSTNAME,USER_LASTNAME,ACCOUNT_ID,USER_NAME);
					
						
					}
					
									
							
									
								}
			System.out.println(c.getUserName());
if (c.getUserName().equals("Dsoyer12")) {choices = true;
			
			while(choices)
			{
			    System.out.println("What would you like to do today?");
			    Scanner accin = new Scanner (System.in);
			   
			   

			    System.out.println("Please enter your selection (case sensitive)");

			    System.out.println("enter :\n'check balance'\n'deposit'\n'withdraw'\n'view all accounts'\n'view account by ID'\n'delete account'\n'view transactions by ID'\n'logout' ");
			    choice = accin.nextLine();


			    switch(choice)
			    {
			        case "check balance":
			        	float bal = (float) ACC_BALANCE.getBalance(c.getAccid());
			        	System.out.println("Your balance is : $"+bal );
			            
			            break;

			        case "deposit":
			           
			            c.Deposit(c.getAccid());
			            break;
			        case "withdraw":
			        	c.Withdraw(c.getAccid());
			        case "logout":
			        	choices = false;
			        	break;
			        case "view all accounts":
			        	ADMIN.ViewAllAccounts();
			        	break;
			        case "delete account":
			        	Scanner dep2 = new Scanner(System.in);
			    		int accid = 0;
			    		boolean isint = false;

			    		while (isint == false) {
			    			try {
			    				System.out.println("Please enter the users account ID");
			    				String tempdep = dep2.nextLine();
			    				accid = Integer.parseInt(tempdep);
			    				isint = true;
			    				 ADMIN.DeleteAccount(accid);
			    			} catch (InputMismatchException d) {

			    			} catch (NumberFormatException e) {
			    			}
			    		}
			        	
			       
			        case "view transactions by ID":
			        	Scanner dep4 = new Scanner(System.in);
			    		int accid2 = 0;
			    		boolean isint2 = false;

			    		while (isint2 == false) {
			    			try {
			    				System.out.println("Please enter the users account ID");
			    				String tempdep = dep4.nextLine();
			    				accid2 = Integer.parseInt(tempdep);
			    				isint2 = true;
			    				 ADMIN.viewTransactions(accid2);
			    			} catch (InputMismatchException d) {

			    			} catch (NumberFormatException e) {
			    			}}
			        
			        case "view account by ID":
			        	
			        	Scanner dep3 = new Scanner(System.in);
			    		int accid1 = 0;
			    		boolean isint1 = false;

			    		while (isint1 == false) {
			    			try {
			    				System.out.println("Please enter the users account ID");
			    				String tempdep = dep3.nextLine();
			    				accid1 = Integer.parseInt(tempdep);
			    				isint1 = true;
			    				 ADMIN.DeleteAccount(accid1);
			    			} catch (InputMismatchException d) {

			    			} catch (NumberFormatException e) {
			    			}
			    		}
			        
			    }
			}
	
			}else  {choices = true;
			
			while(choices)
			{
			    System.out.println("What would you like to do today?");
			    Scanner accin = new Scanner (System.in);
			   
			   

			    System.out.println("Please enter your selection (case sensitive)");

			    System.out.println("enter :\n'check balance'\n'deposit'\n'withdraw',\n'logout' ");
			    choice = accin.nextLine();


			    switch(choice)
			    {
			        case "check balance":
			            c.CheckBalance();
			            
			            break;

			        case "deposit":
			           
			            c.Deposit(c.getAccid());
			            break;
			        case "withdraw":
			        	c.Withdraw(c.getAccid());
			        case "logout":
			        	choices = false;
			        	break;

			        default:
			            System.out.println("please enter again ");
			            boolean repeat = true;

			            while (repeat)
			            {
			            	System.out.println("enter : 'check balance','deposit','withdraw',or 'logout' ");
			                choice = accin.nextLine();

			                switch (choice)
			                {

					        case "check balance":
					        	repeat = false;
					            c.CheckBalance();
					            
					            break;

					        case "deposit":
					        	repeat = false;
					           
					            c.Deposit(c.getAccid());
					            break;
					        case "withdraw":
					        	repeat = false;
					        	c.Withdraw(c.getAccid());
					        case "logout":
					        	choices = false;
					        	repeat = false;
					        	break;
			                }
			            }
			            break;
			    }
			}
	
			}

	
		
	}
	
	
	public Login(BANK_USER c) throws SQLException, IOException{
		
		
		// TODO Auto-generated method stub
		
		
		
		System.out.println("Welcome to DGS Bank");
		
		String choice;


			boolean choices = true;
			
			while(choices)
			{
			    System.out.println("What would you like to do today?");
			    Scanner accin = new Scanner (System.in);
			   
			   

			    System.out.println("Please enter your selection (case sensitive)");

			    System.out.println("enter : 'check balance','deposit','withdraw',or 'logout' ");
			    choice = accin.nextLine();


			    switch(choice)
			    {
			        case "check balance":
			        	float bal = (float) ACC_BALANCE.getBalance(c.getAccid());
			        	System.out.println("Your balance is : $"+bal );
			            
			            break;

			        case "deposit":
			           
			            c.Deposit(c.getAccid());
			            break;
			        case "withdraw":
			        	c.Withdraw(c.getAccid());
			        case "logout":
			        	choices = false;
			        	break;

			        default:
			            System.out.println("please enter again ");
			            boolean repeat = true;

			            while (repeat)
			            {
			            	System.out.println("enter : 'check balance','deposit','withdraw',or 'logout' ");
			                choice = accin.nextLine();

			                switch (choice)
			                {

					        case "check balance":
					        	repeat = false;
					            c.CheckBalance();
					            
					            break;

					        case "deposit":
					        	repeat = false;
					           
					            c.Deposit(c.getAccid());
					            break;
					        case "withdraw":
					        	repeat = false;
					        	c.Withdraw(c.getAccid());
					        case "logout":
					        	choices = false;
					        	repeat = false;
					        	break;
			                }
			            }
			            break;
			    }
			}
	
		
		
		
		
		
		
	}
	

}

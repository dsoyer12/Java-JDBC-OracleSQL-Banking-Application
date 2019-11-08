package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.beans.ACCOUNT;
import com.revature.beans.ACC_BALANCE;
import com.revature.beans.BANK_USER;
import com.revature.beans.Login;
import com.revature.dao.Dao;
import com.revature.dao.Dao2;
import com.revature.dao.Dao2impl;
import com.revature.dao.Daoimpl;

public class Driver {
	public static void main(String[] args) throws SQLException, IOException, InterruptedException  {
		Scanner accin = new Scanner(System.in);
		String choice;
		
		System.out.println(" /$$$$$$$   /$$$$$$   /$$$$$$        /$$$$$$$                     /$$      \r\n" + 
				"| $$__  $$ /$$__  $$ /$$__  $$      | $$__  $$                   | $$      \r\n" + 
				"| $$  \\ $$| $$  \\__/| $$  \\__/      | $$  \\ $$ /$$$$$$  /$$$$$$$ | $$   /$$\r\n" + 
				"| $$  | $$| $$ /$$$$|  $$$$$$       | $$$$$$$ |____  $$| $$__  $$| $$  /$$/\r\n" + 
				"| $$  | $$| $$|_  $$ \\____  $$      | $$__  $$ /$$$$$$$| $$  \\ $$| $$$$$$/ \r\n" + 
				"| $$  | $$| $$  \\ $$ /$$  \\ $$      | $$  \\ $$/$$__  $$| $$  | $$| $$_  $$ \r\n" + 
				"| $$$$$$$/|  $$$$$$/|  $$$$$$/      | $$$$$$$/  $$$$$$$| $$  | $$| $$ \\  $$\r\n" + 
				"|_______/  \\______/  \\______/       |_______/ \\_______/|__/  |__/|__/  \\__/");
		Thread.sleep(1000);
		System.out.println("                         *,.                            \r\n" + 
				"                        .,...(.*./.                        \r\n" + 
				"                     ,.,./*#//(//,,./.                     \r\n" + 
				"                 .,..,/(/*...,,**/(/(.*./.                 \r\n" + 
				"              * ../*&%/,.,,..,,,*((#(%%/,..*.              \r\n" + 
				"          ./.,./*(/,*./.,,.,,(..#/*..(/*/(//.,.*           \r\n" + 
				"       * , (*#(,...,*.&./&&.*#(%./*./.,.***/(%(*,.*.       \r\n" + 
				"        ,******/*/****/**//*******///****/**//****         \r\n" + 
				"          **************************************,          \r\n" + 
				"          ,/((((((#//((((((((/#(((((((//(((((((*.          \r\n" + 
				"             *//*(####/*/*(#####///*###(((//**             \r\n" + 
				"             ,..,((###*...*#####*,..#((((*...,             \r\n" + 
				"             ,...(((((*.,..%%%%%*,..#((((*....             \r\n" + 
				"             ,...(((((*....####%*,..(((((*....             \r\n" + 
				"             ,...(((((*....####%,,..((((**....             \r\n" + 
				"             ,...(((((*....####%*,,.(((***....             \r\n" + 
				"             ,...(((((*....%###%*,..((**,*....             \r\n" + 
				"            .*,../####/,,.,%%%%#*,,.((**,/,,.,             \r\n" + 
				"          .*,,,,,,/*(,,,,,,,*/%,,,,,,**(*,,,,,,.           \r\n" + 
				"        ...........................................        \r\n" + 
				"     .,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,.      \r\n" + 
				"       .        ......  . . ..   ....... .         . .     \r\n" + 
				"");
		Thread.sleep(1000);
		System.out.println("Welcome to DGS Bank");
	   
	    

boolean choices = true;
	  while(choices) {  System.out.println("Do you have an account with us?");

	    System.out.println("enter : yes or no");choice = accin.nextLine(); switch(choice)
	    {
	        case "yes":
	        	choices = false;
	            Login login = new Login();
	            
	            break;

	        case "no":
	        	System.out.println("Alright. Let's set up an account for you");
	            
	            Daoimpl user = new Daoimpl();
	            BANK_USER users = user.createUser();
	            choices= false;
	            Login nulogin = new Login(users);
	            
	            
	            break;

//	        default:
//	            System.out.println("please enter again ");
////	            boolean repeat = true;

//	            while (repeat)
//	            {
//	                System.out.println("Will this be a checking account? : yes or no");
//	                choice = accin.nextLine();
//
//	                switch (choice)
//	                {
//	                    case "yes":
//	                    	 Login login2 = new Login();
//	                        break;
//
//	                    case "no":
//	                    	System.out.println("Alright. Let's set up an account for you");
//	                    	  Daoimpl user2 = new Daoimpl();
//	          	            BANK_USER users2 = user2.createUser();
//	          	            
//	          	            Login nulogin2 = new Login(users2);
//	                        break;
//	                }
//	            }
//	            break;
	    }
		
	}
	  Thread.sleep(1000);
	  System.out.println("Thank you for banking with us");
	  Thread.sleep(1000);
	  System.out.println(" ___      ___      ___      ___                ___    __   __    ___   \r\n" + 
			"  / __|    / _ \\    / _ \\    |   \\      o O O   | _ )   \\ \\ / /   | __|  \r\n" + 
			" | (_ |   | (_) |  | (_) |   | |) |    o        | _ \\    \\ V /    | _|   \r\n" + 
			"  \\___|    \\___/    \\___/    |___/    TS__[O]   |___/    _|_|_    |___|  \r\n" + 
			"_|\"\"\"\"\"| _|\"\"\"\"\"| _|\"\"\"\"\"| _|\"\"\"\"\"|  {======| _|\"\"\"\"\"| _| \"\"\" | _|\"\"\"\"\"| \r\n" + 
			"\"`-0-0-' \"`-0-0-' \"`-0-0-' \"`-0-0-' ./o--000' \"`-0-0-' \"`-0-0-' \"`-0-0-' ");}

	}



package com.Client;

import java.util.Scanner;

import com.Service.Service;

public class Main {
	


		
		public static void main(String[]args)
		{
			Scanner sc =new Scanner(System.in);
			Service er =new Service();
			while(true)
			{
			System.out.println("1...Add new item");
			System.out.println("2...RemoveItem");
			System.out.println("3...Update Price");
			System.out.println("4...Calculate Bill");
			System.out.println("5...Exiting");
			System.out.println("Enter your Choice");
			int ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				
				er.addNewItem();
				
				break;
			case 2:
				er.removeItem();
				break;
			case 3:
				er.updatePrice();
				break;
			case 4:
			    er.calculateBill();
				break;
			case 5:
				System.out.println("Exiting...");
				System.exit(ch);
			

			default:
				System.out.println("Invalid choice");
				break;
				
			}
			
			
			
			
			
			
			
			
			}
		}

	}




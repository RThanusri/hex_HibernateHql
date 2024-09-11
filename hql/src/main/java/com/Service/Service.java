package com.Service;

import java.util.Scanner;

import com.Dao.Dao;

public class Service {
	Scanner sc;
	Dao d=new Dao();
	public Service()
	{
		sc=new Scanner(System.in);
		
	}
	public void addNewItem()
	{
		System.out.println("Enter the Product code");
		int pid=sc.nextInt();
		System.out.println("Enter the Product name");
		sc.nextLine();
		String name=sc.nextLine();
		System.out.println("Enter the Product price");
		double price=sc.nextDouble();

		System.out.println("Enter the Product quantity");
		int quantity=sc.nextInt();
		d.addNewItem(pid, name, price,quantity);
	}
	public void removeItem()
	{
		System.out.println("Enter the Product code");
		int pid=sc.nextInt();
		d.removeItem(pid);
		
	}
	public void updatePrice()
	{
		System.out.println("Enter the Product code");
		int pid=sc.nextInt();
		d.updatePrice(pid);
	}
	public void calculateBill()
	{
		System.out.println("Enter the Product code");
		int pid=sc.nextInt();
		System.out.println("Enter the Product quantity");
		int quantity=sc.nextInt();
		d.calculateTotalBill(pid, quantity);
	}

}

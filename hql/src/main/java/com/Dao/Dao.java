package com.Dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.Connect.Connect;
import com.Model.Product;



public class Dao implements DaoInterface{
	SessionFactory sf;
	Session ses;
	Transaction tx;
	Scanner sc=new Scanner(System.in);
	
	public Dao()
	{
		sf=Connect.getSessionConnect();
		
		
	}
	public boolean addNewItem(int pid, String name, Double price,int quantity) {
		ses=sf.openSession();
		tx=ses.beginTransaction();
		String hql="from Product p where p.pid=:p";
		Query q=ses.createQuery(hql, Product.class);
		q.setParameter("p", pid);
		List<Product> l=q.getResultList();
		
		if(l!=null &&!l.isEmpty() )
		{
			System.out.println("Product already exists");
		}
		else
		{
			Product p =new Product();
			p.setPid(pid);
			p.setName(name);
			p.setPrice(price);
			p.setQuantity(quantity);
			ses.save(p);
			tx.commit();
			System.out.println("Product added successfully");
			
			
			
		}
		ses.close();
		
		
		return false;
	}

	public boolean removeItem(int pid) {
		ses=sf.openSession();
		tx=ses.beginTransaction();
		String hql="from Product p where p.pid=:p";
		Query q=ses.createQuery(hql, Product.class);
		q.setParameter("p", pid);
		List<Product> l=q.getResultList();
		
		if(l!=null&&!l.isEmpty() )
		{
			String hql1="Delete from Product p where p.pid=:p";
			Query q1=ses.createQuery(hql1);
			q1.setParameter("p", pid);
			int a=q1.executeUpdate();
			if(a>0)
			{
				System.out.println("Product removed successfully");
				tx.commit();
			}
			else
			{
				System.out.println("Failed to remove product successfully");
			}
			
		}
		else
		{
			System.out.println("Product doesn't exist");
			
		}
		ses.close();
		return false;
	}

	public boolean updatePrice(int pid) {
		ses=sf.openSession();
		tx=ses.beginTransaction();
		String hql="from Product p where p.pid=:p";
		Query q=ses.createQuery(hql, Product.class);
		q.setParameter("p", pid);
		List<Product> l=q.getResultList();
		
		if(l!=null&&!l.isEmpty() )
		{
		   System.out.println("Enter the new price to update");
		   Double price=sc.nextDouble();
		   String hql1="update Product p set p.price=:pri where p.pid=:p";
		   Query q1=ses.createQuery(hql1);
		   q1.setParameter("pri", price);
		   q1.setParameter("p", pid);
		   int result=q1.executeUpdate();
		   if(result>0) {
			   tx.commit();
			   System.out.println(" Price  updated successfully");
			   
		   }
		   else
		   {
			   System.out.println("Failed to update price ");
		   }
		}
		else
		{
			System.out.println("Product doesn't exist ");
		}
		return false;
	}

	public boolean calculateTotalBill(int pid, int quantity) {
		Double totalBill=0.0;
		ses=sf.openSession();
		tx=ses.beginTransaction();
		String hql="from Product p where p.pid=:p";
		Query q=ses.createQuery(hql, Product.class);
		q.setParameter("p", pid);
		List<Product> l=q.getResultList();
		
		if(l!=null&&!l.isEmpty() )
		{
			Product p = l.get(0);
			
			int totQuantity=p.getQuantity();
			if(totQuantity<quantity)
			{
				System.out.println("Sorry the required quantity is not available");
			}
			else
			{
				totalBill=quantity*p.getPrice();
				System.out.println("The Total bill is   :" + totalBill);
			}
			ses.close();
			
		}
		else
		{
			System.out.println("Requested Product is not available");
		}
	   
		return false;
	}

}

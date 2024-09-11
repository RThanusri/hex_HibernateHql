package com.Connect;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Model.Product;



public class Connect {
	private static SessionFactory sf;
	public Connect()
	{
		sf=new Configuration().configure("hiberConfig.xml").addAnnotatedClass(Product.class).buildSessionFactory();
		Session ses=sf.openSession();
	}
	public static SessionFactory getSessionConnect()
	{
		Connect c =new Connect();
		return sf;
	}

}

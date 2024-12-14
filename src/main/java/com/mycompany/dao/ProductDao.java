package com.mycompany.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mycompany.beans.Customer;
import com.mycompany.beans.Product;
import com.mycompany.beans.Sale;

public class ProductDao {
	
	private static Configuration con=new Configuration().configure("hibernate.cfg.xml")
														.addAnnotatedClass(Product.class)
														.addAnnotatedClass(Customer.class)
														.addAnnotatedClass(Sale.class);
	private static SessionFactory sf=con.buildSessionFactory();
	
	public static Product viewProduct(int pid) {
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		Product p=session.get(Product.class,pid);
		tx.commit();
		session.close();
		return p;
	}
	
	public static void insertProduct(Product p) {
		if(viewProduct(p.getPid())!=null) {
			System.out.println("Product with same id exists already!");
			return;
		}
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.save(p);
		tx.commit();
		session.close();
	}
	
	public static void updateProduct(Product p) {
		if(viewProduct(p.getPid())==null) {
			System.out.println("No Product found to update!");
			return;
		}
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.update(p);
		tx.commit();
		session.close();
	}
	
	public static void deleteProduct(int pid) {
		Product p=viewProduct(pid);
		if(p==null) {
			System.out.println("No Product found to delete!");
			return;
		}
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.delete(p);
		tx.commit();
		session.close();
	}
	
	public static List<Product> getAllProduct(){
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		List<Product> products=(List<Product>)session.createQuery("from Product").getResultList(); 
		tx.commit();
		session.close();
		return products;
	}
	
	public static Product updater(Product p) {
		boolean sw=true;
		int ch=0;
		Scanner sc=new Scanner(System.in);
		while(sw) {
			System.out.println("Enter your choice...");
			System.out.println("1. Name\n2. Category\n3. Price\n4. Exit");
			ch=sc.nextInt();
			switch(ch) {
				case 1: {
					System.out.println("Enter new product name: ");
					p.setPname(sc.next());
					break;
				}
				case 2: {
					System.out.println("Enter new category: ");
					p.setCategory(sc.next());
					break;
				}
				case 3: {
					System.out.println("Enter new price: ");
					p.setPrice(sc.nextLong());
					break;
				}
				case 4: {
					System.out.println("Exiting updater...");
					sw=false;
					break;
				}
				default:{
					System.out.println("enter a valid choice!");
					break;
				}
			}
		}
		return p;
	}
}

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

public class CustomerDao {
	private static Configuration con=new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Product.class)
			.addAnnotatedClass(Customer.class)
			.addAnnotatedClass(Sale.class);
	private static SessionFactory sf=con.buildSessionFactory();
	
	public static Customer viewCustomer(int pid) {
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		Customer p=session.get(Customer.class,pid);
		tx.commit();
		session.close();
		return p;
	}
	
	public static void insertCustomer(Customer c) {
		if(viewCustomer(c.getCid())!=null) {
			System.out.println("Customer with same id exists already!");
			return;
		}
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.save(c);
		tx.commit();
		session.close();
	}
	
	public static void updateCustomer(Customer c) {
		if(viewCustomer(c.getCid())==null) {
			System.out.println("No Customer found to update!");
			return;
		}
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.update(c);
		tx.commit();
		session.close();
	}
	
	public static void deleteCustomer(int cid) {
		Customer c=viewCustomer(cid);
		if(c==null) {
			System.out.println("No Customer found to delete!");
			return;
		}
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.delete(c);
		tx.commit();
		session.close();
	}
	
	public static List<Customer> getAllCustomer(){
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		List<Customer> customers=(List<Customer>)session.createQuery("from Customer").getResultList(); 
		tx.commit();
		session.close();
		return customers;
	}
	
	public static Customer updater(Customer c) {
		boolean sw=true;
		int ch=0;
		Scanner sc=new Scanner(System.in);
		while(sw) {
			System.out.println("Enter your choice...");
			System.out.println("1. Name\n2. Region\n3. Exit");
			ch=sc.nextInt();
			switch(ch) {
				case 1:{
					System.out.println("Enter new customer name : ");
					c.setCname(sc.next());
					break;
				}
				case 2:{
					System.out.println("Enter new customer region : ");
					c.setRegion(sc.next());
					break;
				}
				case 3:{
					System.out.println("Exiting updater...");
					sw=false;
					break;
				}
				default:{
					System.out.println("Enter a valid choice!");
					break;
				}
				
			}
		}
		return c;
	}
}

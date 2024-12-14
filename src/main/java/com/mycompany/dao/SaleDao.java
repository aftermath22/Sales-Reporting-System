package com.mycompany.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mycompany.SalesReportingSystem.App;
import com.mycompany.beans.Customer;
import com.mycompany.beans.Product;
import com.mycompany.beans.Sale;

public class SaleDao {
	private static Configuration con=new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Product.class)
			.addAnnotatedClass(Customer.class)
			.addAnnotatedClass(Sale.class);
	private static SessionFactory sf=con.buildSessionFactory();
	//basic crud's
//###############################################################################################################	
	public static Sale viewSale(int sid) {
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		Sale s=session.get(Sale.class,sid);
		tx.commit();
		session.close();
		return s;
	}
	
	public static void insertSale(Sale s) {
		if(viewSale(s.getSid())!=null) {
			System.out.println("Sale with same id exists already!");
			return;
		}
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.save(s);
		tx.commit();
		session.close();
	}
	
	public static void updateSale(Sale s) {
		if(viewSale(s.getSid())==null) {
			System.out.println("No Sale found to update!");
			return;
		}
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.update(s);
		tx.commit();
		session.close();
	}
	
	public static void deleteSale(int sid) {
		Sale s=viewSale(sid);
		if(s==null) {
			System.out.println("No Sale found to delete!");
			return;
		}
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.delete(s);
		tx.commit();
		session.close();
	}
//###################################################################################################################
	public static List<Sale> getAllSale(){
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		List<Sale> sales=(List<Sale>)session.createQuery("from Sale").getResultList(); 
		tx.commit();
		session.close();
		return sales;
	}
	
	public static List<Object[]> getSalebyRegion(){
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		List<Object[]> sales=session.createQuery("SELECT c.region, SUM(s.total_amt) as totalSales FROM Customer c JOIN Sale s ON c.cid = s.cid GROUP BY c.region").getResultList();
		tx.commit();
		session.close();
		return sales;
	}
	
	public static List<Object[]> getMonthlySale(){
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		List<Object[]> sales=session.createQuery("select year(s.sdate) as saleYear , month(s.sdate) as saleMonth , sum(total_amt) as totalSales from Sale s group by year(s.sdate), month(s.sdate) order by saleYear, saleMonth").getResultList();
		tx.commit();
		session.close();
		return sales;
	}
	
	public static List<Object[]> getSalebyProduct(){
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		List<Object[]> sales=session.createQuery("select pid as ProductId, sum(total_amt) as totalSales from Sale group by pid order by totalSales").getResultList();
		tx.commit();
		session.close();
		return sales;
	}
	
	public static Sale updater(Sale s) {
		boolean sw=true;
		int ch=0;
		Scanner sc=new Scanner(System.in);
		Product p=null;
		while(sw) {
			System.out.println("Enter your choice...");
			System.out.println("1. Product Id\n2. Customer Id\n3. Quantity\n4. Date\n5. Exit");
			ch=sc.nextInt();
			switch(ch) {
				case 1:{
					System.out.println("Enter new product id: ");
					int pid=sc.nextInt();
					p=ProductDao.viewProduct(pid);
					while(p==null) {
        				System.out.println("No such product with that id exists ..enter a valid product id!");
        				System.out.println("Enter id of product : ");
	        			pid=sc.nextInt();
	        			p=ProductDao.viewProduct(pid);
        			}
					s.setPid(pid);
					break;
				}
				case 2:{
					System.out.println("Enter new id of customer that made the sale : ");
        			int cid=sc.nextInt();
        			while(CustomerDao.viewCustomer(cid)==null) {
        				System.out.println("No such customer with that id exists ..enter a valid product id!");
        				System.out.println("Enter id of customer that made the sale : ");
	        			cid=sc.nextInt();
        			}
        			s.setCid(cid);
					break;
				}
				case 3:{
					System.out.println("Enter new quantity: ");
					s.setQuant(sc.nextLong());
					break;
				}
				case 4:{
					System.out.println("Enter new Date: ");
					s.setSdate(App.getUserInputDate());
					break;
				}
				case 5:{
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
		p=ProductDao.viewProduct(s.getPid());
		s.setTotal_amt(s.getQuant()*p.getPrice());
		return s;
	}
	
}

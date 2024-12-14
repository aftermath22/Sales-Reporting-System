package com.mycompany.SalesReportingSystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.mycompany.beans.Customer;
import com.mycompany.beans.Product;
import com.mycompany.beans.Sale;
import com.mycompany.dao.CustomerDao;
import com.mycompany.dao.ProductDao;
import com.mycompany.dao.SaleDao;


public class App 
{
	
	public static java.sql.Date getUserInputDate() {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false); 

        Date date = null;
        boolean validDate = false;

        while (!validDate) {
            System.out.print("Enter a valid date (yyyy-MM-dd): ");
            String input = scanner.nextLine();

            try {
                date = dateFormat.parse(input);
                validDate = true; 
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please try again.");
            }
        }
        java.sql.Date d=new java.sql.Date(date.getTime());
        return d;
    }
	
    public static void main( String[] args )
    {
        System.out.println( "Welcome to Sales Reporting System !" );
        boolean sw=true;
        Scanner sc=new Scanner(System.in);
        int ch=0;
        while(sw) {
        	System.out.println("Enter your choice...");
        	System.out.println("1. Insert Product\n2. Insert Customer\n3. Insert Sale");
        	System.out.println("4. View Customer\n5. View Product\n6. View Sale");
        	System.out.println("7. Update Customer\n8. Update Product\n9. Update Sale");
        	System.out.println("10. Delete Customer\n11. Delete Product\n12. Delete Sale");
        	System.out.println("13. Get All Products\n14. Get All Customers\n15. Get All Sales");
        	System.out.println("16. Get Monthly Sales\n17. Get Sales by Product\n18. Get Sales by Region");
        	System.out.println("19. Exit");
        	ch=sc.nextInt();
        	switch(ch) {
	        	case 1: {
	        		System.out.println("Enter product id: ");
	        		int pid=sc.nextInt();
	        		if(ProductDao.viewProduct(pid)!=null) {
	        			System.out.println("Product with the same id already exists...enter a different one!");
	        		}else {
	        			Product p=new Product();
	        			p.setPid(pid);
	        			System.out.println("Enter product name : ");
	        			p.setPname(sc.next());
	        			System.out.println("Enter product category : ");
	        			p.setCategory(sc.next().toLowerCase());
	        			System.out.println("Enter product price : ");
	        			p.setPrice(sc.nextLong());
	        			ProductDao.insertProduct(p);
	        		}
	        		break;
	        	}
	        	case 2: {
	        		System.out.println("Enter customer id: ");
	        		int cid=sc.nextInt();
	        		if(CustomerDao.viewCustomer(cid)!=null) {
	        			System.out.println("Customer with the same id already exists...enter a different one!");
	        		}else {
	        			Customer c=new Customer();
	        			c.setCid(cid);
	        			System.out.println("Enter customer name (first name only) : ");
	        			c.setCname(sc.next());
	        			System.out.println("Enter customer region : ");
	        			c.setRegion(sc.next().toLowerCase());
	        			CustomerDao.insertCustomer(c);
	        		}
	        		break;
	        	}
	        	case 3: {
	        		System.out.println("Enter sale id: ");
	        		int sid=sc.nextInt();
	        		if(SaleDao.viewSale(sid)!=null) {
	        			System.out.println("Sale with the same id already exists...enter a different one!");
	        		}else {
	        			Sale s=new Sale();
	        			s.setSid(sid);
	        			System.out.println("Enter id of product : ");
	        			int pid=sc.nextInt();
	        			Product p=ProductDao.viewProduct(pid);
	        			while(p==null) {
	        				System.out.println("No such product with that id exists ..enter a valid product id!");
	        				System.out.println("Enter id of product : ");
		        			pid=sc.nextInt();
		        			p=ProductDao.viewProduct(pid);
	        			}
	        			s.setPid(pid);
	        			System.out.println("Enter id of customer that made the sale : ");
	        			int cid=sc.nextInt();
	        			while(CustomerDao.viewCustomer(cid)==null) {
	        				System.out.println("No such customer with that id exists ..enter a valid product id!");
	        				System.out.println("Enter id of customer that made the sale : ");
		        			cid=sc.nextInt();
	        			}
	        			s.setCid(cid);
	        			
	        			System.out.println("Enter Quantity : ");
	        			s.setQuant(sc.nextLong());
	        			
	        			System.out.println("Enter Date of the sale : ");
	        			s.setSdate(getUserInputDate());
	        			
	        			long tot=s.getQuant()*p.getPrice();
	        			System.out.println("Thus the total amount of the sale becomes : "+tot);
	        			s.setTotal_amt(tot);
	        			
	        			SaleDao.insertSale(s);
	        		}
	        		break;
	        	}
	        	case 4: {
	        		System.out.println("Enter product id: ");
	        		int pid=sc.nextInt();
	        		Product p=ProductDao.viewProduct(pid);
	        		if(p==null) System.out.println("No product with id : "+pid+" found!");
	        		else {
	        			System.out.println(p.toString());
	        		}
	        		break;
	        	}
	        	case 5: {
	        		System.out.println("Enter customer id: ");
	        		int cid=sc.nextInt();
	        		Customer c=CustomerDao.viewCustomer(cid);
	        		if(c==null) System.out.println("No customer with id : "+cid+" found!");
	        		else {
	        			System.out.println(c.toString());
	        		}
	        		break;
	        	}
	        	case 6: {
	        		System.out.println("Enter sale id: ");
	        		int sid=sc.nextInt();
	        		Sale s=SaleDao.viewSale(sid);
	        		if(s==null) System.out.println("No sale with id : "+sid+" found!");
	        		else {
	        			System.out.println(s.toString());
	        		}
	        		break;
	        	}
	        	case 7: {
	        		System.out.println("Enter product id: ");
	        		int pid=sc.nextInt();
	        		Product p=ProductDao.viewProduct(pid);
	        		if(p==null) System.out.println("No product with id : "+pid+" found!");
	        		else {
	        			
	        		}
	        		break;
	        	}
	        	case 8: {
	        		System.out.println("Enter customer id: ");
	        		int cid=sc.nextInt();
	        		Customer c=CustomerDao.viewCustomer(cid);
	        		if(c==null) System.out.println("No customer with id : "+cid+" found!");
	        		else {
	        			
	        		}
	        		break;
	        	}
	        	case 9: {
	        		System.out.println("Enter sale id: ");
	        		int sid=sc.nextInt();
	        		Sale s=SaleDao.viewSale(sid);
	        		if(s==null) System.out.println("No sale with id : "+sid+" found!");
	        		else {
	        			
	        		}
	        		break;
	        	}
	        	case 10: {
	        		System.out.println("Enter product id: ");
	        		int pid=sc.nextInt();
	        		Product p=ProductDao.viewProduct(pid);
	        		if(p==null) System.out.println("No product with id : "+pid+" found!");
	        		else {
	        			Product up=ProductDao.updater(p);
	        			ProductDao.updateProduct(up);
	        		}
	        		break;
	        	}
	        	case 11: {
	        		System.out.println("Enter customer id: ");
	        		int cid=sc.nextInt();
	        		Customer c=CustomerDao.viewCustomer(cid);
	        		if(c==null) System.out.println("No customer with id : "+cid+" found!");
	        		else {
	        			Customer uc=CustomerDao.updater(c);
	        			CustomerDao.updateCustomer(uc);
	        		}
	        		break;
	        	}
	        	case 12: {
	        		System.out.println("Enter sale id: ");
	        		int sid=sc.nextInt();
	        		Sale s=SaleDao.viewSale(sid);
	        		if(s==null) System.out.println("No sale with id : "+sid+" found!");
	        		else {
	        			Sale us=SaleDao.updater(s);
	        			SaleDao.updateSale(us);
	        		}
	        		break;
	        	}
	        	case 13: {
	        		List<Product> products=ProductDao.getAllProduct();
	        		if(products==null || products.isEmpty()) {
	        			System.out.println("No Products Found!");
	        		}else {
	        			for(Product x:products) {
	        				System.out.println(x.toString());
	        			}
	        		}
	        		break;
	        	}
	        	case 14: {
	        		List<Customer> custs=CustomerDao.getAllCustomer();
	        		if(custs==null || custs.isEmpty()) {
	        			System.out.println("No Products Found!");
	        		}else {
	        			for(Customer x:custs) {
	        				System.out.println(x.toString());
	        			}
	        		}
	        		break;
	        	}
	        	case 15: {
	        		List<Sale> sales=SaleDao.getAllSale();
	        		if(sales==null || sales.isEmpty()) {
	        			System.out.println("No Products Found!");
	        		}else {
	        			for(Sale x:sales) {
	        				System.out.println(x.toString());
	        			}
	        		}
	        		break;	
	        	}
	        	case 16: {
	        		List<Object[]> ls=SaleDao.getMonthlySale();
	        		if(ls==null || ls.isEmpty()) {
	        			System.out.println("No records found!");
	        		}else {
	        			System.out.println("THIS IS THE MONTHLY SALES REPORT...");
	        			for(Object[] x:ls) {
	        				System.out.println("saleYear: "+x[0]);
	        				System.out.println("saleMonth: "+x[1]);
	        				System.out.println("totalSales: "+x[2]);
	        				System.out.println();
	        			}
	        		}
	        		break;	
	        	}
	        	case 17: {
	        		List<Object[]> ls=SaleDao.getSalebyProduct();
	        		if(ls==null || ls.isEmpty()) {
	        			System.out.println("No records found!");
	        		}else {
	        			System.out.println("THIS IS THE SALES REPORT by PRODUCT...");
	        			for(Object[] x:ls) {
	        				System.out.println("Product ID: "+x[0]);
	        				System.out.println("totalSales: "+x[1]);
	        				System.out.println();
	        			}
	        			
	        		}
	        		break;	
	        	}
	        	case 18: {
	        		List<Object[]> ls=SaleDao.getSalebyRegion();
	        		if(ls==null || ls.isEmpty()) {
	        			System.out.println("No records found!");
	        		}else {
	        			System.out.println("THIS IS THE SALES REPORT by REGION...");
	        			for(Object[] x:ls) {
	        				System.out.println("Region : "+x[0]);
	        				System.out.println("totalSales : "+x[1]);
	        				System.out.println();
	        			}
	        			
	        		}
	        		break;	
	        	}
	        	case 19: {
	        		System.out.println("Exiting App ...");
	        		sw=false;
	        		break;
	        	}
	        	default:{
	        		System.out.println("Enter a valid choice !");
	        		break;
	        	}
	        	
        	}
        	
        }
    }
}


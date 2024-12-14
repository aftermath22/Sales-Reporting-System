# Sales Reporting System

Welcome to the **Sales Reporting System**, a Java-based application designed to manage and report on sales data efficiently. This system allows users to manage customers, products, and sales records while also generating insightful sales reports.

## Features

### Product Management
- Add new products.
- View details of a specific product.
- Update existing products.
- Delete products.
- List all products.

### Customer Management
- Add new customers.
- View details of a specific customer.
- Update existing customers.
- Delete customers.
- List all customers.

### Sales Management
- Add new sales records.
- View details of a specific sale.
- Update existing sales records.
- Delete sales records.
- List all sales.

### Reporting
- Generate monthly sales reports.
- View sales reports by product.
- View sales reports by region.

### HQL Queries
- Retrieve all sales records.
- Retrieve all customer records.
- Retrieve all product records.
- Fetch sales grouped by region.
- Generate monthly sales summaries.
- Get total sales grouped by product.

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- MySQL database
- Maven build tool

### Setup
1. Clone the repository:
   ```bash
   git clone 'https://github.com/aftermath22/Sales-Reporting-System.git'
   ```

2. Import the project into your favorite Java IDE (e.g., IntelliJ IDEA, Eclipse).

3. Configure the database connection in the DAO classes (`CustomerDao`, `ProductDao`, `SaleDao`). Ensure that the database schema is set up as required.

4. Build the project using Maven:
   ```bash
   mvn clean install
   ```

5. Run the `App.java` file to start the application.

## Usage
1. Launch the application by running the `App.java` file.
2. Follow the menu prompts to interact with the system.

### Main Menu Options
1. Insert Product
2. Insert Customer
3. Insert Sale
4. View Product
5. View Customer
6. View Sale
7. Update Product
8. Update Customer
9. Update Sale
10. Delete Product
11. Delete Customer
12. Delete Sale
13. Get All Products
14. Get All Customers
15. Get All Sales
16. Get Monthly Sales
17. Get Sales by Product
18. Get Sales by Region
19. Exit

## Code Structure

### Packages
- `com.mycompany.beans`
  - Contains data models: `Customer`, `Product`, and `Sale`.

- `com.mycompany.dao`
  - Provides Data Access Object (DAO) classes: `CustomerDao`, `ProductDao`, and `SaleDao`.

- `com.mycompany.SalesReportingSystem`
  - Contains the `App` class, which serves as the entry point and manages user interactions.

### Key Classes
#### App.java
The main class that serves as the entry point to the application. It handles user input, navigates through various operations, and invokes methods from DAO classes.

#### DAO Classes
- **CustomerDao**: Handles CRUD operations for customers.
- **ProductDao**: Handles CRUD operations for products.
- **SaleDao**: Handles CRUD operations and reporting for sales.
  - Implements advanced HQL queries:
    - `getAllSale()`: Fetch all sales records.
    - `getSalebyRegion()`: Summarize sales by region.
    - `getMonthlySale()`: Retrieve sales totals by month.
    - `getSalebyProduct()`: List total sales grouped by product.

## Technologies and Frameworks Used

### Maven
- **Merits**:
  - Simplifies dependency management and build processes.
  - Provides a standardized project structure.
  - Supports a wide range of plugins for added functionality.
- **Demerits**:
  - Steep learning curve for beginners.
  - Dependency conflicts can occur if not managed carefully.

### Hibernate
- **Merits**:
  - Simplifies database interactions with Object-Relational Mapping (ORM).
  - Reduces boilerplate SQL code.
  - Supports caching for improved performance.
- **Demerits**:
  - Can be complex to configure for beginners.
  - May lead to performance overhead for complex queries.

### MySQL
- **Merits**:
  - Reliable and widely used relational database system.
  - Offers high performance and scalability.
  - Comprehensive support and documentation available.
- **Demerits**:
  - Requires manual optimization for large datasets.
  - Limited support for non-relational data.

## Example Usage
1. To add a new product:
   - Select option `1` from the main menu.
   - Enter the product details when prompted.

2. To generate a monthly sales report:
   - Select option `16` from the main menu.
   - View the formatted report in the console.

## Some Simulation Results
![WhatsApp Image 2024-12-11 at 16 25 30_bc7cc8a6](https://github.com/user-attachments/assets/209f4aa8-9773-4041-ad47-2c2fee7f8e5c) \
![WhatsApp Image 2024-12-11 at 16 25 30_24f78812](https://github.com/user-attachments/assets/e71e31f2-7282-4405-b1fc-1bf35047484a) \
![WhatsApp Image 2024-12-11 at 16 25 30_413fb0b1](https://github.com/user-attachments/assets/92c63fb0-59a7-4ce0-92e2-5888a59dbf02) \
![WhatsApp Image 2024-12-11 at 16 25 30_08c60156](https://github.com/user-attachments/assets/7dd49c97-753f-4561-8ac1-2b3dff288ea9) \
![WhatsApp Image 2024-12-11 at 16 25 31_73fe73ee](https://github.com/user-attachments/assets/df3bbdcf-8bfb-4683-95f3-770e7f6af942) \
![WhatsApp Image 2024-12-11 at 16 25 31_38dda634](https://github.com/user-attachments/assets/044cff2c-0c74-4f1f-8aff-c8ab295bfd79) \
![WhatsApp Image 2024-12-11 at 16 25 31_de17063a](https://github.com/user-attachments/assets/e1c43b14-4a1f-41c1-accd-c6d24607b40e) \
![WhatsApp Image 2024-12-11 at 16 25 31_bafe10bf](https://github.com/user-attachments/assets/83fe9f20-f739-4840-a6a9-cb4db8474b03) 

### Database Implications
![image](https://github.com/user-attachments/assets/b733ea36-46e8-49fc-9a2d-ad5f9bdd95e0) \
![image](https://github.com/user-attachments/assets/17f1a574-e13c-414e-8e49-42b01b9800ed) 





## Contribution
Feel free to fork the repository and submit pull requests to enhance the application. Contributions are welcome!

## License
This project is licensed under the [MIT License](LICENSE).

---

Happy Coding!

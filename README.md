## UC16: Database Integration & Persistence Support

### 📖 About

This use case adds **database integration** to the application.

It enables the system to store, retrieve, and manage data using a structured persistence layer.

The focus is on **clean database interaction, performance, and maintainability**.

---

### Supported Components

- Maven Project Structure  
- JDBC (Java Database Connectivity)  
- Connection Pooling  
- Parameterized SQL Queries  
- Transaction Management  

---

### Supported Features

#### Database Connectivity

The application connects to the database using JDBC.

- Executes SQL queries  
- Retrieves and stores data  
- Acts as a bridge between application and database  

---

#### Connection Management

Database connections are reused using connection pooling.

Benefits:
- Improved performance  
- Reduced overhead  

---

#### Secure Queries

Parameterized SQL queries are used for safety.

Example:
- `SELECT * FROM users WHERE id = ?`

Prevents:
- SQL injection  
- Unsafe query execution  

---

#### Transaction Handling

Ensures data consistency:

- All operations succeed, or  
- All operations are rolled back  

---

#### Layer Integration

Data flows through layers:

Controller → Service → Repository → Database  

---

### Rules

- Only the repository layer can interact with the database  
- Always use parameterized queries  
- Resources must be properly closed  
- Transactions must ensure consistency  
- Business logic must not be mixed with database logic  

---

### Concepts Used

- JDBC API  
- Connection pooling  
- Resource management  
- Exception handling  
- Database schema design  
- Separation of concerns  
- Configuration management  
- SQL best practices  
- Transaction management  
- Performance optimization  

---

### Improvement Over UC15

- UC15 focused on architecture and design principles  
- UC16 extends the system by:
  - Adding a **persistence layer**
  - Enabling **real data storage and retrieval**
  - Improving **performance and reliability**

---

### Summary

UC16 enhances the system by introducing:

- Reliable database connectivity  
- Clean separation of persistence logic  
- Efficient and secure data handling  

This makes the application more practical and ready for real-world use.

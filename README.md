#  StudentResults - Java Servlet Web Application
This is a simple Java Servlet-based web application to display student result details from a MySQL database using roll number input.
---
##  Features
- Enter Roll Number to fetch result
- Uses Servlets, JDBC, MySQL
- Simple HTML interface
- Styled result display using basic CSS
---
##  Requirements
- Java JDK 8+
- Eclipse IDE for Enterprise Java Developers
- Apache Tomcat 9.0+
- MySQL Server
- mysql-connector-j (JDBC driver)
---
##  Clone this Project
https://github.com/knagapraveenkumar/StudentResult.git
---
## Set Up MySQL Database
CREATE DATABASE studentdb;

USE studentdb;

CREATE TABLE students (
  roll_no INT PRIMARY KEY,
  name VARCHAR(100),
  marks INT
);

INSERT INTO students VALUES (1, 'Praveen', 90), (2, 'Sneha', 85);
---
## Screenshots

## Result Page Example:
![Result Page]
![studentform](https://github.com/user-attachments/assets/c2fb753d-d8b3-40c3-bf43-6c02a56347d0)
![Result](https://github.com/user-attachments/assets/30c0293f-4076-4c78-830c-e5e6a5f61a5c)




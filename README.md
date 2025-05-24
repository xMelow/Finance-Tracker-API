# 💸 Finance Tracker – Backend

A simple finance tracker built with Next.js as the frontend and Quarkus as the backend.
This project helps me refine my skills, master new concepts, and keep learning by coding consistently.

# 🧰 Tech Stack

- Quarkus
- Java 20+
- MarineDB

# ✅ Functionality

- Full CRUD opertations for expenses
- Retrieve expense categories
- Calculate totals
    - Total spending
    - Total spending per month

# 🔧 Setup

Start the Quarkus development server:

```bash
./mvnw quarkus:dev
```

or (if you have Quarkus cli installed) 
```bash 
quarkus dev
```
Ensure your database is running and accessible

# 🗃️ Database script

```sql
-- Create Database
CREATE DATABASE IF NOT EXISTS Finance;

USE Finance;

-- Create tables
CREATE TABLE IF NOT EXISTS Categories(
	CategoryId INT PRIMARY KEY AUTO_INCREMENT,
	Name VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS Expenses(
	ExpenseId INT PRIMARY KEY AUTO_INCREMENT,
	Amount DECIMAL(10, 2),
	CategoryId INT,
	Description VARCHAR(255),
	Date DATE
	CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  UpdatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  FOREIGN KEY (CategoryId) REFERENCES Categories(CategoryId)
);

-- Add data
INSERT IGNORE INTO Categories (Name) VALUES
	("Food"),
	("Transport"),
	("Rent"),
	("Sport"),
	("Going out"),
	("Cloths"),
	("Other");
```

# 📁 Environment Variables

Add your database and CORS settings in `src/main/resources/application.properties`:

```
quarkus.datasource.db-kind=mariadb
quarkus.datasource.username=your_username
quarkus.datasource.password=your_password
quarkus.datasource.jdbc.url=jdbc:mariadb://localhost:3306/Finance

quarkus.hibernate-orm.database.generation=none

# CORS configuration
quarkus.http.cors=true
quarkus.http.cors.methods=GET,PUT,POST,DELETE,OPTIONS
quarkus.http.cors.headers=accept,authorization,content-type,x-requested-with
```

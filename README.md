# Java Swing Registration Form

This is a Java Swing application that allows users to enter their details through a registration form and stores the data in a MySQL database.

## Features
- User registration form with fields: Name, Mobile, Gender, DOB, Address
- Stores data in MySQL database
- Displays entered data on the right panel
- Uses JDBC for database connectivity

## Requirements
- Java (JDK 8 or later)
- MySQL Server
- MySQL Connector (`mysql-connector-java.jar`)
- IDE (e.g., IntelliJ, Eclipse, NetBeans)

## Project Structure

registration-form/ │── src/ │   ├── config/ │   │   ├── DBConnection.java │   ├── controllers/ │   │   ├── UserController.java │   ├── models/ │   │   ├── User.java │  
├── RegistrationForm.java 
│── lib/ │   ├── mysql-connector-java.jar 
│── README.md 
│── .gitignore

## Database Setup
1. Create a MySQL database:
   ```sql
   CREATE DATABASE registration_db;

2. Create the users table:

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    mobile VARCHAR(20),
    gender VARCHAR(10),
    dob DATE,
    address TEXT
);

3. Update database connection details in DBConnection.java.

Running the Application
1. Compile and run RegistrationForm.java using an IDE.

2. Ensure MySQL is running and properly configured.

3. The form allows users to input data and stores it in the database.


Author
Developed by Ian Opicho

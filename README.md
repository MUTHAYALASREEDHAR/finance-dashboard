Finance Dashboard API

Overview:
Backend REST API to manage financial records with JWT authentication.

Tech Stack:
- Java (Spring Boot)
- MySQL
- Spring Data JPA
- JWT

Features:
- User Login
- JWT Authentication
- Role-based Access (ADMIN)
- Add Income/Expense Records
- Delete Records
- Dashboard Summary

Setup:
1. Create database:
   CREATE DATABASE finance_db;
2. Update application.properties
3. Run project:
   mvn spring-boot:run

Database Details:
spring.datasource.url=jdbc:mysql://localhost:3306/finance_db
spring.datasource.username=YOUR_DB_USERNAME
spring.datasource.password=YOUR_DB_PASSWORD
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect


API Endpoints:--

Users:
Add user: /users
{"email":"prasad@gmail.com","password":"password123","role":"ADMIN"}

Get users: /users 

Records:
Add record: /records 
{"amount":5000,"type":"INCOME","category":"Salary","date":"2026-04-05","notes":"Monthly salary"}

Delete record: /records/{id} 

Get all records: /records

Dashboard summary:

Get summary: /dashboard/summary


Authentication:

Login: /auth/login 

{"email":"prasad@gmail.com","password":"password123"}

JWT Token example:
eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwcmFzYWRAZ21haWwuY29tIiwicm9sZSI6IkFETUlOIiwiaWF0IjoxNzc1NDA2ODc3LCJleHAiOjE3NzU0MTA0Nzd9.Yy69q2wHwpZWsAYuJUOkx1PD5Bk-O0eWKDWWE2HtyJ8


URLs:

URL for Adding the User details: http://localhost:8080/users 
URL for Getting the User details:  http://localhost:8080/users
URL for Adding the Record details: http://localhost:8080/records
URL for Deleting the record details by ID: http://localhost:8080/records/1
URL for Getting the all Record details: http://localhost:8080/records
URL for Getting the Summery:  http://localhost:8080/dashboard/summary
URL for Authentication : http://localhost:8080/auth/login

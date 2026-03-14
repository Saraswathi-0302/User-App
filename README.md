# User Management System 

This project is a **Spring Boot REST API application** developed to manage **user information and Aadhaar details**.

The system allows users to **register, retrieve, update, and delete user records** while maintaining a **One-to-One relationship between User and Aadhaar entities**. The application also implements **password security using Spring Security and BCrypt encryption**.

The backend is built using **Java, Spring Boot, Hibernate (JPA), and MySQL**, and follows a **layered architecture** for better code organization and maintainability.

---

## Technologies Used

- Java  
- Spring Boot  
- Spring Security  
- Hibernate (JPA)  
- MySQL  
- Maven  
- Postman  
- Git & GitHub  

---

## Features

- User registration  
- Retrieve all users  
- Update user details  
- Delete user records  
- Add Aadhaar details for users  
- One-to-One mapping between **User and Aadhaar**  
- Password encryption using **BCrypt**  
- REST API development using **Spring Boot**  
- Global exception handling  
- Custom API response structure  

---

## Project Architecture

The project follows a **layered architecture**:

Controller → Service → DAO → Repository → Database

This architecture separates **API handling, business logic, and database operations**, making the application easier to maintain and extend.

---

## API Endpoints

**POST /user/register** – Register new user  

**GET /user/getallusers** – Retrieve all users  

**PUT /user/updateuser** – Update user details  

**DELETE /user/deleteuser** – Delete user  

**POST /aadhar/register** – Add Aadhaar details  

**GET /aadhar/getbyid** – Get Aadhaar details  

---

## Security

Spring Security is implemented to protect user credentials.

- Passwords are encrypted using **BCrypt**
- Plain text passwords are never stored in the database
- Password verification is handled securely during authentication

---

## Database

The application uses **MySQL** to store user and Aadhaar information.

- **Hibernate (JPA)** is used for Object Relational Mapping
- A **One-to-One relationship** is implemented between **User and Aadhaar** entities

---

## Tools Used

- **Postman** – API testing  
- **Maven** – Dependency management  
- **GitHub** – Version control and repository hosting  

---

## Developer

**Saraswathi M**  
Java Backend Developer  

GitHub: https://github.com/Saraswathi-0302  

LinkedIn: https://www.linkedin.com/in/saraswathim02

# User Management System

A production-style User Management REST API with secure authentication, Aadhar entity mapping, and input validation — built with Spring Boot and Spring Security.

---

## Tech Stack

| Layer | Technology |
|-------|-----------|
| Language | Java (Core Java, Advanced Java, J2EE) |
| Framework | Spring Boot, Spring MVC, Spring Security |
| ORM | Hibernate (JPA), Spring Data JPA |
| Database | MySQL |
| Security | BCrypt Password Hashing |
| Validation | Bean Validation (@Valid) |
| Build Tool | Maven |
| API Testing | Postman |
| Version Control | Git, GitHub |

---

## Features

- User registration with BCrypt encrypted password
- Secure login with credential validation
- Get user by ID with custom exception handling
- Get all users
- Update user details
- Delete user
- Paginated user retrieval
- Aadhar card — OneToOne entity mapping with User
- Input validation with meaningful error messages
- Password never exposed in API response (@JsonProperty WRITE_ONLY)
- Global exception handling

---

## Security Highlights

| Feature | Implementation |
|---------|---------------|
| Password hashing | BCryptPasswordEncoder |
| Password protection | @JsonProperty(WRITE_ONLY) |
| Input validation | @Valid, @NotBlank, @Email, @Pattern |
| Exception handling | GlobalExceptionController (@RestControllerAdvice) |

---

## Project Architecture

```
Controller → Service → DAO → Repository → Database
```

| Layer | Responsibility |
|-------|---------------|
| Controller | Handles HTTP requests and responses |
| Service | Business logic + password encoding |
| DAO | Data access operations |
| Repository | JPA repository interface |

---

## API Endpoints

### User APIs

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/user/register` | Register a new user |
| GET | `/user/getUser?userId=` | Get user by ID |
| GET | `/user/getAllUser` | Get all users |
| PUT | `/user/update?userId=` | Update user |
| DELETE | `/user/delete?userId=` | Delete user |
| GET | `/user/getUserPage?pageNo=` | Get users with pagination |
| POST | `/user/login` | User login |

### Aadhar APIs

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/aadhar/register?userId=` | Link Aadhar to user |

---

## Sample Request — Register User

```
POST /user/register
{
  "userName": "John Doe",
  "userEmail": "johndoe@example.com",
  "userPassword": "password123",
  "userContact": "98XXXXXXXX",
  "address": "Tamil Nadu, India",
  "age": 25
}
```

---

## How to Run

1. Clone the repository
```
git clone https://github.com/Saraswathi-0302/User-App.git
```

2. Configure MySQL in `src/main/resources/application.properties`
```
spring.datasource.url=jdbc:mysql://localhost:3306/userapp
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

3. Run the application
```
mvn spring-boot:run
```

4. Test APIs using Postman at http://localhost:8080

---

## Developer

**Saraswathi M** — Java Backend Developer
- LinkedIn: https://www.linkedin.com/in/saraswathim02
- GitHub: https://github.com/Saraswathi-0302

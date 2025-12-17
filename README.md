# User Registration System

A Spring Boot application for managing user registration and authentication.

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.8-brightgreen)
![Maven](https://img.shields.io/badge/Maven-3.6+-blue)
![Status](https://img.shields.io/badge/Status-In%20Development-yellow)

---

📖 **Additional Documentation:**
- [Quick Start Guide](QUICKSTART.md) - Get up and running in 5 minutes
- [Project Summary](PROJECT_SUMMARY.md) - Current status and development roadmap

---

## 🚀 Quick Start

```bash
# Clone the repository
git clone https://github.com/PasinduOG/Project-01-Spring-Boot.git
cd Project-01-Spring-Boot

# Build and run
mvn spring-boot:run

# Test the API
curl http://localhost:8080/
```

## 📋 Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Technologies](#technologies)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Project Structure](#project-structure)
- [API Endpoints](#api-endpoints)
- [Database Schema](#database-schema)
- [Configuration](#configuration)
- [Running the Application](#running-the-application)
- [Testing](#testing)
- [Future Enhancements](#future-enhancements)
- [Contributing](#contributing)

## 🎯 Overview

This project is a user registration system built with Spring Boot that provides RESTful APIs for user management. The system currently implements basic user registration and retrieval functionality with an in-memory data store, and is designed to be extended with database integration, authentication, and more advanced features.

### Current Status
This is a **work in progress** project. The basic REST API structure is implemented, and the application is ready for extension with database connectivity, security features, and more comprehensive user management functionality.

## ✨ Features

### Current Features
- ✅ RESTful API architecture
- ✅ Spring Boot 3.5.8 framework with Spring Web
- ✅ User model with basic attributes (id, firstName, lastName, age, city)
- ✅ Lombok integration for reduced boilerplate code
- ✅ Generic API response wrapper for consistent response format
- ✅ User registration endpoint (POST /add-user)
- ✅ Get all users endpoint (GET /get-all-users)
- ✅ Welcome message endpoint (GET /)
- ✅ In-memory user storage using ArrayList

### Planned Features
- 🔲 Database integration (Spring Data JPA with MySQL/PostgreSQL)
- 🔲 User login and authentication
- 🔲 Password field and encryption (BCrypt)
- 🔲 JWT token-based authentication
- 🔲 Email field and email validation
- 🔲 User profile management (update, delete by ID)
- 🔲 Email verification for new registrations
- 🔲 Password reset functionality
- 🔲 Role-based access control (Admin, User)
- 🔲 Input validation with Bean Validation
- 🔲 Global exception handling
- 🔲 Logging and monitoring
- 🔲 Unit and integration tests

## 🛠 Technologies

### Current Stack
- **Java**: 17
- **Spring Boot**: 3.5.8
- **Spring Web**: RESTful API development
- **Lombok**: 1.18.42 - Reduces boilerplate code (getters, setters, constructors)
- **Maven**: Dependency management and build tool

### Planned Dependencies
- **Spring Data JPA** - Database interaction and ORM
- **Spring Security** - Authentication and authorization
- **MySQL/PostgreSQL** - Relational database
- **JWT (jjwt)** - Token-based authentication
- **Spring Validation** - Input validation with Bean Validation
- **Spring Boot Mail** - Email functionality
- **H2 Database** - In-memory database for testing
- **JUnit & Mockito** - Unit and integration testing

## 📦 Prerequisites

Before running this application, ensure you have the following installed:

- **Java Development Kit (JDK)** 17 or higher
- **Maven** 3.6 or higher
- **An IDE** (IntelliJ IDEA, Eclipse, VS Code, etc.)
- **Postman or similar** (optional, for API testing)

> **Note**: Database is not required yet as the application currently uses in-memory storage.

## 🚀 Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/PasinduOG/Project-01-Spring-Boot.git
   cd Project-01-Spring-Boot
   ```

2. **Build the project**
   ```bash
   mvn clean install
   ```

3. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

The application will start on `http://localhost:8080`

## 📁 Project Structure

```
Project-01-Spring-Boot/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           ├── Main.java                    # Main Spring Boot application class
│   │   │           ├── controller/
│   │   │           │   └── UserController.java      # REST endpoints for user operations
│   │   │           ├── model/
│   │   │           │   └── User.java                # User entity/model class
│   │   │           ├── dto/
│   │   │           │   └── ApiResponse.java         # Generic API response wrapper
│   │   │           ├── repository/                  # [To be added] Data access layer
│   │   │           ├── service/                     # [To be added] Business logic layer
│   │   │           ├── config/                      # [To be added] Configuration classes
│   │   │           ├── security/                    # [To be added] Security configurations
│   │   │           └── exception/                   # [To be added] Custom exceptions & handlers
│   │   └── resources/
│   │       └── (empty - configuration files to be added)
│   └── test/
│       └── java/                                    # Unit and integration tests (to be added)
├── target/                                          # Compiled classes and build artifacts
├── pom.xml                                          # Maven dependencies and build configuration
├── .gitignore                                       # Git ignore rules
└── README.md                                        # Project documentation
```

### Current Files Overview

#### Main.java
The entry point of the Spring Boot application with `@SpringBootApplication` annotation.

#### User.java (Model)
User entity with Lombok annotations (@AllArgsConstructor, @NoArgsConstructor, @Getter, @Setter, @ToString) and the following fields:
- `id` (int) - Unique identifier
- `firstName` (String) - User's first name
- `lastName` (String) - User's last name
- `age` (int) - User's age
- `city` (String) - User's city

#### UserController.java
REST controller with the following endpoints:
- `GET /` - Welcome message
- `GET /get-all-users` - Retrieve all registered users
- `POST /add-user` - Register a new user

#### ApiResponse.java
Generic response wrapper providing:
- `status` (String) - Response status (e.g., "success", "error")
- `message` (String) - Descriptive message
- `data` (T) - Generic data payload
- `timestamp` (LocalDateTime) - Response timestamp

## 🔌 API Endpoints

### Current Endpoints

#### Welcome Message
```http
GET /
```
**Response:**
```
Welcome to User Management System
```

#### Get All Users
```http
GET /get-all-users
```
**Response:**
```json
[
  {
    "id": 1,
    "firstName": "John",
    "lastName": "Doe",
    "age": 30,
    "city": "New York"
  },
  {
    "id": 2,
    "firstName": "Jane",
    "lastName": "Smith",
    "age": 28,
    "city": "San Francisco"
  }
]
```

#### Add New User
```http
POST /add-user
Content-Type: application/json

{
  "id": 1,
  "firstName": "John",
  "lastName": "Doe",
  "age": 30,
  "city": "New York"
}
```
**Response:**
```json
{
  "status": "success",
  "message": "User registered successfully",
  "data": {
    "id": 1,
    "firstName": "John",
    "lastName": "Doe",
    "age": 30,
    "city": "New York"
  },
  "timestamp": "2025-12-17T10:30:45"
}
```

### Planned Endpoints

#### User Login
```http
POST /api/users/login
Content-Type: application/json

{
  "email": "john@example.com",
  "password": "SecurePass123!"
}
```

#### Get User Profile
```http
GET /api/users/profile
Authorization: Bearer <jwt-token>
```

#### Update User Profile
```http
PUT /api/users/{userId}
Authorization: Bearer <jwt-token>
Content-Type: application/json

{
  "firstName": "John",
  "lastName": "Doe",
  "age": 31,
  "city": "Boston"
}
```

#### Delete User Account
```http
DELETE /api/users/{userId}
Authorization: Bearer <jwt-token>
```

#### Password Reset Request
```http
POST /api/users/forgot-password
Content-Type: application/json

{
  "email": "john@example.com"
}
```


## 🗄 Database Schema

> **Note**: Database integration is planned for future releases. Currently, the application uses in-memory storage.

### Planned Users Table
```sql
CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    phone_number VARCHAR(20),
    is_verified BOOLEAN DEFAULT FALSE,
    is_active BOOLEAN DEFAULT TRUE,
    role VARCHAR(20) DEFAULT 'USER',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
```

### Email Verification Tokens Table
```sql
CREATE TABLE verification_tokens (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    token VARCHAR(255) UNIQUE NOT NULL,
    user_id BIGINT NOT NULL,
    expiry_date TIMESTAMP NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);
```

### Password Reset Tokens Table
```sql
CREATE TABLE password_reset_tokens (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    token VARCHAR(255) UNIQUE NOT NULL,
    user_id BIGINT NOT NULL,
    expiry_date TIMESTAMP NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);
```

## ⚙ Configuration

> **Note**: Currently, the application runs with default Spring Boot configuration. No `application.properties` file is needed yet.

### Future Configuration (when database is added)

Create an `application.properties` file in `src/main/resources/`:

```properties
# Server Configuration
server.port=8080
spring.application.name=User Registration System

# Database Configuration (MySQL)
spring.datasource.url=jdbc:mysql://localhost:3306/user_registration_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# JWT Configuration
jwt.secret=your-secret-key-here
jwt.expiration=86400000

# Email Configuration
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your-email@gmail.com
spring.mail.password=your-app-password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

# Logging Configuration
logging.level.com.example=DEBUG
logging.level.org.springframework.web=INFO
logging.pattern.console=%d{yyyy-MM-dd HH:mm:ss} - %msg%n
```

## 🏃 Running the Application

### Using Maven
```bash
mvn spring-boot:run
```

### Using JAR
```bash
mvn clean package
java -jar target/Project-01-Spring-Boot-1.0-SNAPSHOT.jar
```

### Using IDE
Right-click on `Main.java` and select "Run Main.main()"

### Testing the API

Once the application is running, you can test the endpoints:

#### 1. Using cURL (Command Line)

**Welcome Message:**
```bash
curl http://localhost:8080/
```

**Add a User:**
```bash
curl -X POST http://localhost:8080/add-user -H "Content-Type: application/json" -d "{\"id\":1,\"firstName\":\"John\",\"lastName\":\"Doe\",\"age\":30,\"city\":\"New York\"}"
```

**Get All Users:**
```bash
curl http://localhost:8080/get-all-users
```

#### 2. Using PowerShell

**Add a User:**
```powershell
$body = @{
    id = 1
    firstName = "John"
    lastName = "Doe"
    age = 30
    city = "New York"
} | ConvertTo-Json

Invoke-RestMethod -Uri "http://localhost:8080/add-user" -Method Post -Body $body -ContentType "application/json"
```

**Get All Users:**
```powershell
Invoke-RestMethod -Uri "http://localhost:8080/get-all-users" -Method Get
```

#### 3. Using Postman

1. Open Postman
2. For **GET /**: Set method to GET and URL to `http://localhost:8080/`
3. For **POST /add-user**: 
   - Set method to POST and URL to `http://localhost:8080/add-user`
   - In Headers, add `Content-Type: application/json`
   - In Body (raw), paste:
     ```json
     {
       "id": 1,
       "firstName": "John",
       "lastName": "Doe",
       "age": 30,
       "city": "New York"
     }
     ```
4. For **GET /get-all-users**: Set method to GET and URL to `http://localhost:8080/get-all-users`

## 🧪 Testing

> **Note**: Unit and integration tests are planned for future implementation.

### Planned Test Commands

**Run all tests:**
```bash
mvn test
```

**Run specific test class:**
```bash
mvn test -Dtest=UserServiceTest
```

**Generate test coverage report:**
```bash
mvn clean test jacoco:report
```

## ⚠️ Current Limitations

- **No Data Persistence**: Users are stored in memory (ArrayList) and will be lost when the application restarts
- **No Authentication**: All endpoints are publicly accessible without any security
- **No Validation**: User input is not validated (e.g., duplicate IDs, invalid data)
- **No Error Handling**: Limited error handling for edge cases
- **No Logging**: Application events and errors are not logged
- **No ID Generation**: User IDs must be manually provided and can conflict
- **No Update/Delete**: No endpoints to modify or remove existing users
- **No Pagination**: All users are returned at once, which won't scale well

## 🔮 Future Enhancements

### High Priority
- [ ] Add Spring Data JPA and database integration (MySQL/PostgreSQL)
- [ ] Implement auto-generated IDs using database sequences
- [ ] Add Bean Validation for input validation
- [ ] Implement global exception handling with @ControllerAdvice
- [ ] Add update (PUT) and delete (DELETE) endpoints
- [ ] Implement Spring Security with JWT authentication
- [ ] Add password field with BCrypt encryption
- [ ] Add email field and email validation
- [ ] Implement proper logging with SLF4J

### Medium Priority
- [ ] Add pagination and sorting for user lists
- [ ] Implement user search functionality
- [ ] Add comprehensive API documentation with Swagger/OpenAPI
- [ ] Create unit and integration tests with JUnit and Mockito
- [ ] Implement email verification for new registrations
- [ ] Add password reset functionality
- [ ] Implement role-based access control (Admin, User)

### Low Priority (Advanced Features)
- [ ] Implement OAuth2 integration (Google, Facebook, GitHub)
- [ ] Add two-factor authentication (2FA)
- [ ] Implement rate limiting for API endpoints
- [ ] Add user activity logging
- [ ] Create admin dashboard for user management
- [ ] Implement account lockout after failed login attempts
- [ ] Add profile picture upload functionality
- [ ] Implement caching with Redis
- [ ] Add internationalization (i18n) support
- [ ] Create Docker containerization
- [ ] Set up CI/CD pipeline with GitHub Actions

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 📧 Contact

For questions or support, please contact:
- GitHub: [@PasinduOG](https://github.com/PasinduOG)
- Project Link: [https://github.com/PasinduOG/Project-01-Spring-Boot](https://github.com/PasinduOG/Project-01-Spring-Boot)

---

**Note**: This project is currently under active development. Many features listed above are planned and will be implemented progressively.

**Last Updated**: December 17, 2025


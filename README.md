# User Registration System

A Spring Boot application for managing user registration and authentication.

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
- [License](#license)

## 🎯 Overview

This project is a user registration system built with Spring Boot that provides RESTful APIs for user management, including registration, authentication, and profile management. The system is designed to be secure, scalable, and easy to integrate with frontend applications.

## ✨ Features

### Current Features
- RESTful API architecture
- Spring Boot 3.5.8 framework

### Planned Features
- User registration with email validation
- User login and authentication
- Password encryption (BCrypt)
- JWT token-based authentication
- User profile management (view, update, delete)
- Email verification for new registrations
- Password reset functionality
- Role-based access control (Admin, User)
- Input validation and error handling
- Logging and monitoring

## 🛠 Technologies

- **Java**: 17
- **Spring Boot**: 3.5.8
- **Spring Web**: RESTful API development
- **Maven**: Dependency management and build tool
- **Planned Dependencies**:
  - Spring Data JPA - Database interaction
  - Spring Security - Authentication and authorization
  - MySQL/PostgreSQL - Database
  - JWT - Token-based authentication
  - Spring Validation - Input validation
  - Lombok - Reduce boilerplate code
  - Spring Boot Mail - Email functionality

## 📦 Prerequisites

Before running this application, ensure you have the following installed:

- Java Development Kit (JDK) 17 or higher
- Maven 3.6 or higher
- MySQL 8.0 or PostgreSQL 13+ (when database is added)
- An IDE (IntelliJ IDEA, Eclipse, VS Code, etc.)

## 🚀 Installation

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd Project-01-Spring-Boot
   ```

2. **Build the project**
   ```bash
   mvn clean install
   ```

3. **Configure the database** (when database is added)
   - Create a database named `user_registration_db`
   - Update the `application.properties` file with your database credentials

4. **Run the application**
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
│   │   │           ├── Main.java                    # Main application class
│   │   │           ├── controller/                  # REST controllers
│   │   │           ├── model/                       # Entity classes
│   │   │           ├── repository/                  # Data access layer
│   │   │           ├── service/                     # Business logic layer
│   │   │           ├── dto/                         # Data Transfer Objects
│   │   │           ├── config/                      # Configuration classes
│   │   │           ├── security/                    # Security configurations
│   │   │           └── exception/                   # Custom exceptions
│   │   └── resources/
│   │       ├── application.properties               # Application configuration
│   │       └── application-dev.properties          # Development configuration
│   └── test/
│       └── java/                                    # Unit and integration tests
├── pom.xml                                          # Maven dependencies
└── README.md                                        # Project documentation
```

## 🔌 API Endpoints

### User Registration
```http
POST /api/users/register
Content-Type: application/json

{
  "username": "johndoe",
  "email": "john@example.com",
  "password": "SecurePass123!",
  "firstName": "John",
  "lastName": "Doe"
}
```

### User Login
```http
POST /api/users/login
Content-Type: application/json

{
  "email": "john@example.com",
  "password": "SecurePass123!"
}
```

### Get User Profile
```http
GET /api/users/profile
Authorization: Bearer <jwt-token>
```

### Update User Profile
```http
PUT /api/users/profile
Authorization: Bearer <jwt-token>
Content-Type: application/json

{
  "firstName": "John",
  "lastName": "Doe",
  "phoneNumber": "+1234567890"
}
```

### Delete User Account
```http
DELETE /api/users/{userId}
Authorization: Bearer <jwt-token>
```

### Password Reset Request
```http
POST /api/users/forgot-password
Content-Type: application/json

{
  "email": "john@example.com"
}
```

### Password Reset
```http
POST /api/users/reset-password
Content-Type: application/json

{
  "token": "reset-token",
  "newPassword": "NewSecurePass123!"
}
```

## 🗄 Database Schema

### Users Table
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

## 🧪 Testing

### Run all tests
```bash
mvn test
```

### Run specific test class
```bash
mvn test -Dtest=UserServiceTest
```

### Generate test coverage report
```bash
mvn clean test jacoco:report
```

## 🔮 Future Enhancements

- [ ] Implement OAuth2 integration (Google, Facebook, GitHub)
- [ ] Add two-factor authentication (2FA)
- [ ] Implement rate limiting for API endpoints
- [ ] Add user activity logging
- [ ] Create admin dashboard for user management
- [ ] Implement account lockout after failed login attempts
- [ ] Add profile picture upload functionality
- [ ] Implement pagination for user lists
- [ ] Add comprehensive API documentation with Swagger/OpenAPI
- [ ] Implement caching with Redis
- [ ] Add internationalization (i18n) support
- [ ] Create Docker containerization
- [ ] Set up CI/CD pipeline

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
- Email: your-email@example.com
- Project Link: [https://github.com/yourusername/Project-01-Spring-Boot](https://github.com/yourusername/project-url)

---

**Note**: This project is currently under development. Many features listed above are planned and will be implemented progressively.

**Last Updated**: December 17, 2025


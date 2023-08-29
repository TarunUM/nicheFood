# Niche Food - A Spring Boot Application with JWT Authentication, Registration, and Login

This project is a Spring Boot application that demonstrates JWT (JSON Web Token) authentication, user registration, and login functionality. It includes two main models: `Hotel` and `Food`. The application uses MySQL as the database.

## Prerequisites

- Java 8 or higher
- Spring Boot
- MySQL
- Lombok
- JWT

## Getting Started

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/TarunUM/nicheFood.git
   cd nicheFood
   ```

2. **Database Configuration:**

    - Create a MySQL database named `spring_jwt_auth`.
    - Update the `application.properties` file in `src/main/resources` with your MySQL database credentials:

      ```properties
      spring.datasource.url=jdbc:mysql://localhost:3306/nichefood
      spring.datasource.username=your_username
      spring.datasource.password=your_password
      ```

3. **Run the Application:**

   ```bash
   ./mvnw spring-boot:run
   ```

   The application will be accessible at `http://localhost:8080`.

## Endpoints

### User Registration

- **Endpoint:** `/api/v1/auth/register`
- **Method:** POST
- **Request Body:**
  ```json
  {
    "username": "your_username",
    "password": "your_password"
  }
  ```

### User Login

- **Endpoint:** `/api/v1/auth/login`
- **Method:** POST
- **Request Body:**
  ```json
  {
    "username": "your_username",
    "password": "your_password"
  }
  ```

- **Response:**
  ```json
  {
    "token": "your_generated_jwt_token"
  }
  ```

### Welcome Page

- **Endpoint:** `/`
- **Method:** GET
- **Description:** Welcome page for the application.

### Secured Endpoints

#### Hotels

- **Endpoint:** `/api/v1/hotels/`
- **Methods:** GET, POST, PUT, DELETE
- **Authorization:** Bearer Token (Include the JWT token received after login)

- **Endpoint:** `/api/v1/hotels/{hotel_id}`
- **Method:** GET
- **Authorization:** Bearer Token (Include the JWT token received after login)

- **Endpoint:** `/api/v1/hotels/{hotel_name}`
- **Method:** GET
- **Authorization:** Bearer Token (Include the JWT token received after login)

- **Endpoint:** `/api/v1/hotels/city`
- **Method:** GET
- **Authorization:** Bearer Token (Include the JWT token received after login)

- **Endpoint:** `/api/v1/hotels/hotellist`
- **Method:** POST
- **Authorization:** Bearer Token (Include the JWT token received after login)

#### Food

- **Endpoint:** `/api/v1/food/{id}`
- **Methods:** GET, POST, PUT, DELETE
- **Authorization:** Bearer Token (Include the JWT token received after login)

- **Endpoint:** `/api/v1/food/{id}`
- **Method:** GET
- **Authorization:** Bearer Token (Include the JWT token received after login)

- **Endpoint:** `/api/v1/food/{name}`
- **Method:** GET
- **Authorization:** Bearer Token (Include the JWT token received after login)

- **Endpoint:** `/api/v1/food/{hotelId}`
- **Method:** GET
- **Authorization:** Bearer Token (Include the JWT token received after login)

- **Endpoint:** `/api/v1/food/{cuisine}`
- **Method:** GET
- **Authorization:** Bearer Token (Include the JWT token received after login)

- **Endpoint:** `/api/v1/food/{availability}`
- **Method:** GET
- **Authorization:** Bearer Token (Include the JWT token received after login)

- **Endpoint:** `/api/v1/food/list`
- **Method:** POST
- **Authorization:** Bearer Token (Include the JWT token received after login)

## Security

The application uses JWT tokens for authentication. The `JwtTokenProvider` class handles token creation, validation, and parsing. Make sure to secure sensitive endpoints using proper authorization checks.

---

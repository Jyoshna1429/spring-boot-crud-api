# Spring Boot CRUD API

A REST API built using Spring Boot, Spring Data JPA, and MySQL to perform CRUD (Create, Read, Update, Delete) operations on student records.
This project was developed to gain hands-on experience with Java backend development, REST APIs, database integration, and API testing using Postman.

## About the Project
The application allows users to manage student records through REST API endpoints.
It demonstrates how a Spring Boot application handles HTTP requests, processes business logic, communicates with a MySQL database, and returns responses to clients.

## Technologies Used
- **Java** — Programming language
- **Spring Boot** — Backend application development
- **Spring Web** — Building REST APIs
- **Spring Data JPA** — Database operations and repository management
- **Hibernate** — ORM for mapping Java objects to database tables
- **MySQL** — Relational database
- **Maven** — Dependency management and build automation
- **Postman** — API testing
- **IntelliJ IDEA** — Development environment

## Features

- Create student records
- Retrieve student information
- Update existing student records
- Delete student records
- Persist student data in MySQL
- Test API endpoints using Postman

## Project Structure

```text
CRUDspringBootDemo/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── in/strikes/CRUDspringBootDemo/
│   │   │       ├── controller/
│   │   │       │   └── StudentController.java
│   │   │       ├── entity/
│   │   │       │   └── Student.java
│   │   │       ├── repository/
│   │   │       │   └── StudentRepository.java
│   │   │       ├── service/
│   │   │       │   └── StudentService.java
│   │   │       └── CruDspringBootDemoApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## Application Architecture

The application follows a layered architecture:

**Client (Postman) → Controller → Service → Repository → MySQL Database**

- **Controller:** Receives HTTP requests and returns HTTP responses.
- **Service:** Contains the business logic for student operations.
- **Repository:** Uses Spring Data JPA to interact with the database.
- **Entity:** Represents the student data stored in the database.
- **MySQL:** Stores student records persistently.

## API Endpoints

Base URL:

```text
http://localhost:8080/api/students
```

| Operation | HTTP Method | Endpoint |
|---|---|---|
| Create a student | POST | `/api/students/create` |
| Retrieve a student | GET | `/api/students/get/{id}` |
| Update a student | PUT | `/api/students/update/{id}` |
| Delete a student | DELETE | `/api/students/delete/{id}` |

Replace `{id}` with the ID of the student you want to access.

> Note: These endpoints describe the intended CRUD routes. Verify the update route and all mappings against `StudentController.java` before using this table.

## Database Configuration

This project uses MySQL to store student records.

### 1. Create a database

Open MySQL Workbench or your MySQL client and execute:

```sql
CREATE DATABASE studentdb;
```

You can use a different database name if you update the application configuration accordingly.

### 2. Configure database credentials

Create or update the following file locally:

`src/main/resources/application.properties`

Add your own MySQL configuration:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/studentdb
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Set the `DB_USERNAME` and `DB_PASSWORD` environment variables to your MySQL credentials before starting the application.

**Security note:** The `application.properties` file is excluded from this repository to prevent database credentials from being committed to GitHub. Never publish real passwords or other secrets.

Ensure that your MySQL server is running before starting the application.

## How to Run the Project

### Prerequisites

Make sure you have installed:

- Java compatible with the version configured in `pom.xml`
- MySQL Server
- Git

### 1. Clone the repository

```bash
git clone https://github.com/Jyoshna1429/spring-boot-crud-api.git
```

### 2. Open the project

Open the cloned project in IntelliJ IDEA or another Java IDE.

### 3. Configure MySQL

Create the database and configure your local `application.properties` file as explained above.

### 4. Run the application

On Windows, open a terminal in the project directory and execute:

```powershell
.\mvnw.cmd spring-boot:run
```

Alternatively, run the main application class from your IDE.

Once the application starts successfully, the API will be available at:

```text
http://localhost:8080
```

## Testing with Postman

You can test the CRUD endpoints using Postman.

1. Start the Spring Boot application.
2. Open Postman.
3. Enter the appropriate endpoint URL.
4. Select the corresponding HTTP method.
5. For requests that require a student object, select **Body → raw → JSON** and provide the required fields.
6. Send the request and inspect the HTTP status code and response.
7. Verify database changes in MySQL Workbench.

## Learning Outcomes

Through this project, I gained practical experience with:

- Developing REST APIs using Spring Boot
- Understanding the Controller, Service, Repository, and Entity layers
- Performing CRUD operations using Spring Data JPA
- Connecting a Java application to MySQL
- Handling HTTP methods and responses
- Testing APIs with Postman
- Debugging application and database errors
- Using Git and GitHub for version control

## Future Improvements

- Add request validation
- Improve exception handling and error responses
- Implement pagination and sorting
- Add automated tests for CRUD operations
- Introduce authentication and authorization

## Author

**Jyoshna Choudhury**

GitHub: [@Jyoshna1429](https://github.com/Jyoshna1429)

---

*This project was developed as part of my journey toward becoming a Java Backend Developer.*

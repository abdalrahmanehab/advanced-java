# 🎓 University System REST API

A Spring Boot REST API for managing university users and students. The project demonstrates REST API development using a layered architecture with in-memory repositories.

> **Note:** This project uses in-memory storage and is intended for learning purposes.

---

## 🏗️ Overview & Architecture

The system is designed following the standard Spring Boot **Multi-Tiered (Layered) Architecture** to ensure clean separation of concerns, scalability, and maintainability:

```text
com.pioneers.universitysystem/
├── controller/        # REST Controllers exposing HTTP Endpoints
│   ├── AuthController.java
│   └── StudentController.java
├── service/           # Service Layer handling Business Logic
│   ├── AuthService.java
│   └── StudentService.java
├── repository/        # Data Access Layer (In-Memory Java Collections)
│   ├── UserRepository.java
│   └── StudentRepository.java
├── dto/               # Immutable Data Transfer Objects (Requests & Responses)
│   ├── LoginRequest.java
│   ├── SignupRequest.java
│   ├── StudentRequest.java
│   └── StudentResponse.java
└── entity/            # Core Domain Model Objects
    ├── User.java
    └── Student.java

## 🛠️ Tech Stack

* Java 21
* Spring Boot 3.x
* Maven

---

## ✨ Features

### 🔐 Authentication (`/user`)

* User Signup
* User Login
* User Logout

### 👨‍🎓 Student Management (`/student`)

* Create a student
* Create multiple students
* Retrieve all students
* Retrieve a student by ID
* Update a student
* Delete a student

### 🎯 Student Filtering

* Filter students by **major**
* Filter students by **minimum GPA**

---

## 🚀 Running the Project

```bash
git clone <repository-url>
cd <project-directory>
mvn spring-boot:run
```

The application will start at:

```
http://localhost:8080
```

---

## 📚 API Endpoints

### Authentication

| Method | Endpoint       | Description             |
| ------ | -------------- | ----------------------- |
| POST   | `/user/signup` | Register a new user     |
| POST   | `/user/login`  | Authenticate a user     |
| POST   | `/user/logout` | Logout the current user |

### Student

| Method | Endpoint          | Description                             |
| ------ | ----------------- | --------------------------------------- |
| POST   | `/student`        | Create a new student                    |
| POST   | `/student/bulk`   | Create multiple students                |
| GET    | `/student`        | Retrieve all students                   |
| GET    | `/student/{id}`   | Retrieve a student by ID                |
| PUT    | `/student/{id}`   | Update an existing student              |
| DELETE | `/student/{id}`   | Delete a student                        |
| GET    | `/student/filter` | Filter students by `major` and `minGpa` |

---

## 🧪 Sample Request

### `POST /student`

```json
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@university.edu",
  "major": "Computer Science",
  "gpa": 3.8,
  "birthDate": "2003-09-12"
}
```

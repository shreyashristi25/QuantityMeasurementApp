# 🚀 Quantity Measurement App – Dev Branch

The **`dev` branch** serves as the central integration branch for all features of the Quantity Measurement Application.
All feature branches are merged here before being promoted to `main`.

This branch represents the **latest stable development state** of the application, combining all implemented functionalities including measurement logic, backend architecture, and authentication systems.

---

## 📌 Purpose of Dev Branch

* 🔄 Integrate all feature branches
* 🧪 Serve as a testing ground before production
* ⚙️ Maintain stable development builds
* 🚀 Prepare code for release into `main`

---

## 🌳 Branch Workflow

```
main
└── dev   ← (YOU ARE HERE)
    ├── feature/*
```

### 🔁 Workflow Strategy

1. Create feature branch from `dev`
2. Implement functionality
3. Test locally
4. Merge back into `dev`
5. After full validation → merge `dev` → `main`

---

## ⚙️ Integrated Functionalities

### 📏 Measurement System

* Unit conversion (cm ↔ m, kg ↔ g, etc.)
* Multi-domain support:

  * Length
  * Weight
  * Volume
  * Temperature
* Base unit standardization
* Precision-safe calculations

---

### ➕ Arithmetic Operations

* Addition of quantities
* Subtraction
* Division
* Target unit conversion after operations
* Centralized arithmetic logic

---

### 🌡️ Special Handling

* Temperature conversions using formulas
* Restricted invalid operations on temperature

---

### 🏗️ Architecture (N-Tier)

```
Controller → Service → Repository → Database
```

* DTO Layer
* Dependency Injection
* SOLID Principles
* Clean Code Practices

---

### 🗄️ Persistence Layer

* JDBC integration
* Spring Data JPA
* ORM using Hibernate
* Configurable database (MySQL / H2)

---

### 🔐 Authentication & Security

#### JWT Authentication

* Stateless authentication
* Token-based API access
* Secure endpoints

#### OAuth2 Integration

* Google Login
* Auto user registration
* JWT generation after OAuth login

---

### 👤 User Management

* User entity handling
* Role-based access (if implemented)
* Secure session handling

---

## 📂 Project Structure

```
src/
 ├── controller      # REST Controllers
 ├── service         # Business Logic
 ├── repository      # Database Layer
 ├── model           # Entity Classes
 ├── security        # JWT & OAuth2 Configurations
 ├── config          # App Configurations
 └── exception       # Global Exception Handling
```

---

## 🌐 API Overview

| Endpoint                   | Description        |
| -------------------------- | ------------------ |
| `/auth/login`              | JWT login          |
| `/oauth2/authorize/google` | Google OAuth login |
| `/auth/user`               | Get user details   |
| `/api/**`                  | Protected APIs     |

---

## 🔄 Authentication Flow

### 🔑 JWT Flow

1. User logs in
2. Backend validates credentials
3. JWT token generated
4. Token sent to client
5. Client sends token in headers
6. Backend validates each request

---

### 🌍 OAuth2 Flow

1. User selects Google login
2. Redirect to Google
3. Google authenticates user
4. Backend receives user info
5. JWT token generated
6. User logged in securely

---

## 🛠️ Tech Stack

| Technology      | Description                    |
| --------------- | ------------------------------ |
| Java            | Programming Language           |
| Spring Boot     | Backend Framework              |
| Spring Security | Authentication & Authorization |
| JWT             | Token-based Authentication     |
| OAuth2          | Google Login                   |
| Hibernate / JPA | ORM Framework                  |
| MySQL / H2      | Database                       |
| Maven           | Build Tool                     |

---

## 🧪 Development Guidelines

* Always branch from `dev`
* Follow naming: `feature/UCXX-description`
* Write unit tests (TDD preferred)
* Ensure no breaking changes before merging
* Pull latest `dev` before pushing

---

## ⚠️ Important Notes

* `dev` is **not production-ready at all times**
* Conflicts should be resolved before merging
* Authentication flows must be tested thoroughly
* API contracts should remain consistent

---

## 🏁 Final Goal

The `dev` branch ensures:

✔ Smooth integration of all modules
✔ Stable development environment
✔ Scalable and maintainable backend
✔ Production-ready code preparation

---

## 🔗 Repository

👉 https://github.com/Saud0786/QuantityMeasurementApp/tree/dev

---

## 👨‍💻 Contribution

* Fork the repo
* Create a feature branch
* Commit changes
* Raise a Pull Request to `dev`

---

## 📌 Summary

The **dev branch** is the backbone of development for the Quantity Measurement App, combining:

* 📏 Accurate measurement system
* 🔐 Secure authentication (JWT + OAuth2)
* 🏗️ Clean architecture
* ⚡ Scalable backend



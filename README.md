## UC18: Google Authentication & User Management

### 📖 About

This use case introduces **authentication and user management** into the application.

It enables secure access using:
- Google OAuth2 login  
- JWT-based authentication  

The goal is to ensure **secure, scalable, and stateless user authentication**.

---

### Supported Components

- Spring Security  
- JWT (JSON Web Token)  
- OAuth2 (Google Authentication)  
- User Management System  

---

### Supported Features

#### Google Authentication (OAuth2)

Users can log in using their Google account.

- Redirects user to Google login  
- Authenticates using OAuth2  
- Retrieves user profile information  

---

#### JWT Authentication

After successful login:

- A JWT token is generated  
- Token is sent to the client  
- Used for authenticating future requests  

---

#### User Management

- Stores authenticated user details  
- Supports user registration and retrieval  
- Manages user roles (if applicable)  

---

#### Secure API Access

- Protected endpoints require JWT token  
- Unauthorized access is restricted  
- Ensures only authenticated users can access resources  

---

### Rules

- All protected APIs must require a valid JWT token  
- Tokens must be included in request headers  
- OAuth2 is used only for authentication (login)  
- JWT is used for authorization (API access)  
- Sensitive data must not be exposed  

---

### Concepts Used

- Spring Security  
- OAuth2 authentication flow  
- JWT token generation and validation  
- Stateless authentication  
- Secure API design  
- User session management  

---

### Improvement Over UC17

- UC17 introduced Spring Boot backend and REST APIs  
- UC18 enhances the system by:
  - Adding **authentication and authorization**
  - Securing APIs using **JWT**
  - Integrating **Google OAuth2 login**
  - Managing users securely  

---

### Summary

UC18 strengthens the application by adding:

- Secure **Google-based login system**  
- Stateless **JWT authentication**  
- Protected and secure **API access**  

This makes the application safe, user-aware, and ready for real-world deployment.

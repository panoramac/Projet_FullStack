# 🚗 Voiture Management App - Spring Boot & React

## 📘 Project Overview
Full-stack web application to manage cars and their owners.  
The backend exposes RESTful APIs built with Spring Boot, and the frontend provides an intuitive React interface for CRUD operations.

---

## 🛠 Tech Stack
**Backend:** Spring Boot, Spring Data REST, JPA, MariaDB  
**Frontend:** React, Bootstrap, Axios, React Router

---

## 🚀 Quick Start

### 🧩 Backend (Spring Boot)
```bash
# Run the backend
mvn spring-boot:run
# Access:
#   Main API: http://localhost:9090
#   Swagger UI: http://localhost:9090/swagger-ui
#   REST Endpoints: http://localhost:9090/api/voitures
```
## 💻 Frontend (React)

```bash
cd src/main/webapp/reactjs
npm install
npm start
# Access: http://localhost:3000
# liste voiture: http://localhost:3000/list
# ajout voiture: http://localhost:3000/add

```


## 📱 Features

- ✅ Add new cars with form validation
- ✅ View all cars in a responsive table
- ✅ Delete cars with confirmation
- ✅ Custom Toast notifications (Green for add, Red for delete)
- ✅ Spring Data REST automatic endpoints
- ✅ Custom controller endpoints

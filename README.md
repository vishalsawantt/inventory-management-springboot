# Inventory & Purchase Management System – Spring Boot

A backend **Inventory & Purchase Management System** built using **Spring Boot**, designed to simulate ERP-style workflows such as vendor management, purchase orders, goods receipt, inventory tracking, and payment recording.

The project follows a **clean layered architecture** and focuses on **data consistency, transaction handling, and real-world business flow**.

---

## 🚀 Features

- Vendor management
- Product management
- Purchase order creation & approval
- Goods receipt with automatic inventory update
- Inventory stock tracking
- Vendor payment tracking
- RESTful APIs
- Centralized exception handling
- Transaction management for critical operations

---

## 🧩 Business Flow

1. Vendors and products are created by Admin  
2. User raises a purchase order  
3. Admin approves the purchase order  
4. Goods receipt is recorded  
5. Inventory is updated automatically  
6. Vendor payment is recorded for tracking  

---

## 🏗️ Architecture


- **Controller**: Handles HTTP requests and responses  
- **Service**: Business logic & validations  
- **Repository**: Database access using JPA  
- **Entity**: Domain models  
- **Exception Layer**: Global error handling  

---

## 🛠️ Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- REST APIs
- PostgreSQL
- Maven
- Docker (for deployment)

---

## 📂 Project Modules

- Vendor
- Product
- Purchase Order
- Goods Receipt
- Inventory
- Payment

---

## 🗄️ Database

- **PostgreSQL**
- Relationships managed using JPA annotations
- Inventory maintained per product
- Transactional consistency during goods receipt

---

## 🐳 Docker Deployment

The application is containerized using Docker and deployed on Render.
- docker build -t inventory-backend .
- docker run -p 8080:8080 inventory-backend

---

## 🌐 Deployed API

Backend is deployed on Render
Base URL:
- https://inventory-management-springboot.onrender.com

---

## ⚙️ API Highlights

- POST /vendors
- POST /products
- POST /purchase-orders
- PUT /purchase-orders/{id}/approve
- POST /goods-receipts
- GET /inventory
- POST /payments

---

## Error Handling

- Custom exceptions for:
- Resource not found
- Invalid requests
- Centralized global exception handler
- Meaningful HTTP status codes

---

## Purpose

This project is built for:
- Learning backend architecture
- Understanding ERP-style workflows
- Interview demonstration
- Full-stack integration with Flutter frontend

---

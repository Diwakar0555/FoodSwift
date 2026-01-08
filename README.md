# FoodSwift 🍽️

FoodSwift is a **Java-based food delivery web application** developed to demonstrate backend web development concepts using Java EE technologies.  
The project follows a clean layered architecture and focuses on server-side logic, data handling, and request–response flow.

---

## Project Overview

FoodSwift provides a web interface for browsing restaurants and menu items, managing a cart, and placing orders.  
The application is built using **JSP for views**, **Servlets for controllers**, and **JDBC for database interaction**, following an **MVC-style design**.

---

## Key Highlights

- Structured MVC-based architecture  
- Clear separation of DAO, Service, and Controller layers  
- Maven-based dependency and build management  
- Deployed and tested using Apache Tomcat  

---

## Technologies Used

- Java 17  
- JSP & Servlets  
- JDBC  
- Apache Tomcat 10.1  
- Maven  
- MySQL  
- HTML & CSS  

---

## Application Features

- User registration and authentication  
- Restaurant and menu browsing *(UI-level implementation)*  
- Cart management  
- Order placement and confirmation  

---

## Project Structure

- **controller (servlets)** – Handles HTTP requests and responses  
- **dao** – Database access logic  
- **model** – Entity classes  
- **utility** – Database connection and helpers  
- **webapp** – JSP pages, CSS, and images  

---

## How to Run Locally

1. Clone the repository  
2. Import the project into Eclipse as a **Maven Project**  
3. Ensure **Java 17** is configured in Eclipse  
4. Configure **Apache Tomcat 10.1**  
5. Update database credentials in `DBConnection.java`  
6. Run the project on Tomcat  

Access the application at:

http://localhost:8080/FoodSwift/

---

## Notes

- Restaurant and menu browsing is currently implemented at the **UI level**  
- Backend logic focuses on **user management and order flow**  
- This project is intended for **learning and demonstration purposes**

---

## Author

**Diwakar**

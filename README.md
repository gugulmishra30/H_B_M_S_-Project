✅ Summary for Project

📌 Project Name := Hotel Management System

📝 Description:_
⏩ Hotel Management System is a full-featured web-based application built using Java 8, Spring Boot, JSP, Hibernate, and MySQL. It supports both RESTful APIs and JSP-based web views, enabling hotel staff to manage room bookings, customers, employees, and invoices efficiently. The project includes full CRUD functionality, role-based login (admin/staff), room availability tracking, and dynamic data display using Bootstrap and JSTL.

---

🔧 Tech Stack:

✅ Backend Language: Java 8  
✅ Framework: Spring Boot 2.4.x  
✅ ORM & Persistence: Hibernate + Spring Data JPA  
✅ Database: MySQL 8+  
✅ View Layer: JSP (via `tomcat-embed-jasper`), JSTL  
✅ API Support: `@RestController` for REST endpoints  
✅ Validation: Hibernate Validator (`@Valid`, JSR-380)  
✅ Build Tool: Maven  
✅ IDE Compatible: Eclipse  
✅ Logging: SLF4J / Logback  
✅ Hot Reloading: Spring Boot DevTools  

---

💡 Key Features:

✅ Role-Based Login (Admin, Receptionist)  
✅ Room Booking (Create/Update/Delete/View)  
✅ Customer Details Management  
✅ Invoice Generation & Bill Calculation  
✅ Room Availability Tracking  
✅ Add/View/Remove Hotel Staff  
✅ Global Exception Handling  
✅ Validation on all forms using `@Valid`  
✅ Logging & Error Tracking  
✅ JSP-based front-end with Bootstrap UI  
✅ REST API for frontend or mobile use  

---

🚀 Access Points:

✅ Web App: `http://localhost:8080`  
✅ REST API (Sample): `http://localhost:8080/bookings`  

---

🌐 API Examples:

| Method | Endpoint           | Description               |
|--------|--------------------|---------------------------|
| GET    | `/rooms`           | Get all rooms             |
| GET    | `/bookings`        | View all bookings         |
| POST   | `/bookings`        | Create a new booking      |
| DELETE | `/bookings/{id}`   | Delete booking by ID      |
| PUT    | `/rooms/{id}`      | Update room status        |

---

🧩 Basic Swagger Configuration:-

@Configuration
@EnableOpenApi
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.hotel"))
                .paths(PathSelectors.any())
                .build();
    }
}

✍️ Usage in Controller:-

@RestController
@RequestMapping("/bookings")
@Api(value = "Booking Controller", tags = "Bookings")
public class BookingController {
    @ApiOperation(value = "Get all bookings", response = List.class)
    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }
}

---

📘 Swagger UI Integration (API Testing):-

## 📘 Swagger UI – API Documentation
This project supports API documentation using **Swagger**.
✅ Swagger UI helps test, document, and visualize all REST endpoints in the system.
### 🔗 Access URL:-  http://localhost:8080/swagger-ui/

### 🔧 Maven Dependency (Add in `pom.xml`)
``xml <!-- Swagger - SpringFox -->
<dependency>
  <groupId>io.springfox</groupId>
  <artifactId>springfox-boot-starter</artifactId>
  <version>3.0.0</version>
</dependency>

---

📁 Folder Structure Highlights:

Hotel_Management_System_Project/
├── src/main/java/
│ ├── controller/ # Handles web/API requests
│ ├── model/ # Entity classes
│ ├── repository/ # JPA repositories
│ └── service/ # Business logic
├── src/main/webapp/
│ └── WEB-INF/jsp/ # JSP view templates
├── src/main/resources/
│ ├── application.properties
│ └── static/ # Static assets (if any)
├── pom.xml # Maven project dependencies
├── .project/.classpath # Eclipse config

---

📌 Bonus:

💠Suitable for showcasing Java Full-Stack Web Development
💠Demonstrates real-world usage of Spring MVC + JSP + Hibernate
💠Easy to deploy on any Apache Tomcat-compatible server

---

⏩ Ensure that your local MySQL server is running and the hotel_db database exists before running the app.
⏩ Use a tool like Postman to test REST endpoints separately if required.

---

📢‼️ Some Important Notes:

⏩ After cloning or downloading the project, make sure to update your `application.properties` file with the correct MySQL credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/hotel_db
spring.datasource.username=your_username
spring.datasource.password=your_password

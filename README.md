# Aqua Notes — Water Issue Reporting System (Spring Boot)

Backend system developed with Java and Spring Boot for reporting and tracking water-related issues in a specific area. Users can submit reports with geographic coordinates, which are then processed and made available for map-based visualization.

## 🚀 Features

* Report creation with geographic coordinates
* Retrieval of reports for map visualization
* REST API for managing incidents
* Data validation and persistence
* User-associated reporting (if aplica)

## 🛠️ Tech Stack

* **Backend:** Spring Boot (Java)
* **Database:** MySQL
* **API:** RESTful services
* **Tools:** Maven / Gradle (ajusta según tu proyecto)

## 🧠 Architecture

The system follows a typical Spring Boot structure:

* Controllers → Handle HTTP requests
* Services → Business logic and validations
* Repositories → Data access with JPA/Hibernate
* Entities → Domain models (reports, users, etc.)

## ⚙️ How to Run

1. Clone the repository

   ```bash
   git clone https://github.com/PabloMU115/aqua_notes.git
   ```

2. Configure database connection
   Update `application.properties` or `application.yml` with your MySQL credentials.

3. Run the application

   ```bash
   ./mvnw spring-boot:run
   ```

   or

   ```bash
   ./gradlew bootRun
   ```

## 📡 Example Endpoint

```http
POST /api/reports
```

```json
{
  "description": "Water leakage in street",
  "latitude": 9.9281,
  "longitude": -84.0907
}
```

## 📌 Notes

* Designed to simulate real-world incident reporting workflows.
* Focused on backend architecture, data integrity, and geolocation handling.

## 👨‍💻 Author

Pablo Mora Ureña
📧 [pablomu1999@gmail.com](mailto:pablomu1999@gmail.com)
🔗 LinkedIn: https://linkedin.com/in/pablo-mora-ureña-969bb5251

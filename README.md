# Repository Pattern with Spring JDBC (PostgreSQL) — Teaching Skeleton

This repo demonstrates the **foundational moving parts** of the **Repository pattern** using **Spring** and **JDBC** with **PostgreSQL**.  
It is intentionally minimal for educational purposes (not a full CRUD app).

**Goal:** separate **domain/service logic** from **data access** while keeping SQL explicit and swappable.

---

## What’s here (by design, minimal)
- A **Repository interface** (decouples app from persistence)
- A **Spring JDBC** implementation (e.g., `JdbcTemplate`/`NamedParameterJdbcTemplate`)
- Basic **Spring configuration** for a DataSource/JdbcTemplate
- Room for you/students to add entities, queries, and tests during lessons

> No JPA/Hibernate. No production frameworks beyond what’s needed to teach the pattern.

---

## Prerequisites
- Java 17+
- Gradle (wrapper included)
- PostgreSQL (local or Docker)

Optional PostgreSQL with Docker:
```bash
docker run --name repo-pg   -e POSTGRES_PASSWORD=postgres   -e POSTGRES_USER=postgres   -e POSTGRES_DB=appdb   -p 5432:5432 -d postgres:16
```

---

## Configure the datasource
Create or edit `src/main/resources/application.properties` (example values):
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/appdb
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.datasource.driver-class-name=org.postgresql.Driver

# Optional: auto-run SQL scripts if present
spring.sql.init.mode=always
spring.sql.init.platform=postgres
```

---

## Build & run
If using **Spring Boot**:
```bash
./gradlew bootRun
# or
./gradlew clean build
java -jar build/libs/*.jar
```

If **plain Spring** (no Boot), run the main class via IDE or:
```bash
./gradlew run
```
---

## Troubleshooting
- **DB connection**: confirm Postgres is running and URL/credentials match.
- **Driver**: ensure the PostgreSQL JDBC driver exists in `build.gradle`.
- **Tables**: create them via `schema.sql` or your preferred migration tool.

---

## License
MIT (or your preference).

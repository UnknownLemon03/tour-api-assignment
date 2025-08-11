# Simple Tour Package API

A RESTful API built with Java Spring Boot for managing tour packages. This API supports creating, listing, and retrieving tour packages with validation and error handling.

## Features

* Create a new tour package
* List all tour packages
* Retrieve a single tour package by ID
* Input validation and error responses
* Interactive API documentation with Swagger UI

## Technologies Used

* Java 21
* Spring Boot 3.5.4
* PostgreSQL
* Maven
* Spring Data JPA
* Hibernate Validator
* Springdoc OpenAPI (Swagger)

## API Endpoints

| Method | Endpoint          | Description               | Request Body / Params                |
| ------ | ----------------- | ------------------------- | ------------------------------------ |
| POST   | `/api/tours`      | Create a new tour package | JSON object with tour package fields |
| GET    | `/api/tours`      | List all tour packages    | None                                 |
| GET    | `/api/tours/{id}` | Get tour package by ID    | Path parameter: `id`                 |

## Sample Request Body for Creating Tour Package

```json
{
  "id": 1,
  "image": "https://images.unsplash.com/photo-1598275277521-1885382d523a",
  "discountInPercentage": "21%",
  "title": "Himalayan Trek Adventure",
  "description": "14-day trek through the Himalayas",
  "duration": "14Days/13Nights",
  "actualPrice": "$1200",
  "discountedPrice": "$1000"
}
```

## API Documentation with Swagger UI

Once the application is running, access the Swagger UI at:

```
http://localhost:8080/swagger-ui.html
```

## Running PostgreSQL with Docker (Optional)

```bash
docker run --name my-postgres \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=postgres \
  -e POSTGRES_DB=makemytourdb \
  -p 5432:5432 \
  -d postgres:15
```

## Validation & Error Handling

* Requests with empty or invalid fields will return HTTP 400 Bad Request with details.
* Requests for non-existent IDs will return HTTP 404 Not Found.

## Getting Started

### Prerequisites

* Java 21 or later
* Maven
* PostgreSQL (local or remote)
* Docker (optional, for containerized setup)

### 1. Start Normally (Local JVM)

1. Clone the repo:

   ```bash
   git clone https://github.com/yourusername/simple-tour-package-api.git
   cd simple-tour-package-api
   ```

2. Configure your database connection in `src/main/resources/application.properties`:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/makemytourdb
   spring.datasource.username=postgres
   spring.datasource.password=postgres
   spring.jpa.hibernate.ddl-auto=update
   ```

3. Make sure PostgreSQL is running locally (or remotely accessible).

4. Build and run the app:

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

5. Access API at: `http://localhost:8080/api/tours`
   Swagger UI at: `http://localhost:8080/swagger-ui.html`

### 2. Start Using Docker Image

1. Build the Docker image:

   ```bash
   docker build -t simple-tour-backend .
   ```

2. Run PostgreSQL separately (if you don’t have a database running):

   ```bash
   docker run --name my-postgres \
     -e POSTGRES_USER=postgres \
     -e POSTGRES_PASSWORD=postgres \
     -e POSTGRES_DB=makemytourdb \
     -p 5432:5432 \
     -d postgres:15
   ```

3. Run the backend container:

   ```bash
   docker run -p 8080:8080 \
     -e SPRING_DATASOURCE_URL=jdbc:postgresql://host.docker.internal:5432/makemytourdb \
     -e SPRING_DATASOURCE_USERNAME=postgres \
     -e SPRING_DATASOURCE_PASSWORD=postgres \
     simple-tour-backend
   ```

4. Access API at: `http://localhost:8080/api/tours`
   Swagger UI at: `http://localhost:8080/swagger-ui.html`

### 3. Start Using Docker Compose (Backend + PostgreSQL)

1. Run both services:

   ```bash
   docker-compose up --build
   ```

2. Access API at: `http://localhost:8080/api/tours`
   Swagger UI at: `http://localhost:8080/swagger-ui.html`

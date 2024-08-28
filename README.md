## Prerequisites
1. Database: Set up a database (MySQL) and configure the database connection details in application.properties


## Access API Endpoints

### Base URL
- **Courses API:** `http://localhost:8080/api/courses`
- **Instances API:** `http://localhost:8080/api/instances`

## Running the Application with Docker
1. Build the Docker Image
         `docker build -t 7rahul/iitassignment-backend:latest .`
2. Run the Docker Container
          `docker run -d -p 8080:8080 7rahul/iitassignment-backend:latest`

## Running the Full Application with Docker Compose (Start all services (backend and database) using Docker Compose:)
         `Change the  docker-compose.yml File according to your requirement  `
 1. Run Docker Compose => `docker-compose up`

 





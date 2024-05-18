# Employee Management System

### Example web application using Java Spring Web + REACT.js

### Technology Stack:

- Spring Boot 3
- Spring Data JPA (Hibernate 6)
- MySQL Database
- Maven

---

- REACT.js 18+
- Vite.js
- Bootstrap CSS
- JavaScript
- NPM
- Axios

### Running an application in Docker


```
# Collect images for all services
docker-compose -p ems-fullstack build

# Start all services
docker-compose -p ems-fullstack up -d

# Check the status of running containers
docker-compose -p ems-fullstack ps

# View logs (optional)
docker-compose -p ems-fullstack logs -f

# Stop all services (if necessary)
docker-compose -p ems-fullstack down
```
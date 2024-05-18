# Employee Management System

## Example web application using Java Spring Web + REACT.js

### 1. Technology Stack:

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

### 2. Running an application in Docker

```
# Collect images for all services
docker-compose -p ems build

# Start all services
docker-compose -p ems up -d

# Check the status of running containers
docker-compose -p ems ps

# View logs (optional)
docker-compose -p ems logs -f

# Stop all services
docker-compose -p ems stop

# Start all services
docker-compose -p ems start

# Deactivate all services (if necessary)
docker-compose -p ems down
```

### [3. Veiw](http://localhost:3000/employees)
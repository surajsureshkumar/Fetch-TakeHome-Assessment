# Fetch-TakeHome-Assessment - Receipt Processor API

## 🛠️ Tech Stack
- Java 17
- Spring Boot 3.4.5
- Maven
- H2 Database (runtime)
- Docker (optional, if you want to create a docker image and run it anywhere)

## 🚀 Getting Started

### Prerequisites
- Java 17+
- Maven 3.8+
- (Optional) Docker installed if you want to containerize

### The initial application was built using [spring initializr](https://start.spring.io/)

### The following dependencies were added
- Spring Web
- Spring Data JPA
- Lombok (for boiler plate code reduction)
- Jackson Mapper (from [maven dependency repo](https://mvnrepository.com/))
- H2 Database
- Jakarta Validation (from the maven repository linked above)
- Mockito (if you want to run tests to test your service layer or controller layer)

### 📦 Build and Run (Locally)
```
- Clone the repo
- git clone https://github.com/surajsureshkumar/Fetch-TakeHome-Assessment.git
- cd Fetch-TakeHome-Assessment/fetch
- Open in IntelliJIdea
- Go to the main program file which will be named Fetch Application
- Click on run and the spring boot application start, which starts an embedded server, mainly apache tomcat
```

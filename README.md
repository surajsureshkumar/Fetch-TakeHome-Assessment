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
- Once the application starts, open postman ( I will be giving the postman steps in this) but you can use any other tool that you use to test endpoints (another one maybe insomnia or whatever you are comfortable with)
- Your server will start at http://localhost:8080 ,
- Create an environment if you dont have one
- Then click on New where the red arrow mark is at as shown in the image, it will give you a new pop-up window as shown in the image and select http in this
```
![image](https://github.com/user-attachments/assets/0343adcd-88a8-4e4d-970d-cb36c9416ffb)
![image](https://github.com/user-attachments/assets/8c1954e0-0a11-42f0-acbd-c6ad1258a24a)


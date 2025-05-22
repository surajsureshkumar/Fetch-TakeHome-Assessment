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
- Then click on New where the red arrow mark is at as shown in the image
```
![image](https://github.com/user-attachments/assets/0343adcd-88a8-4e4d-970d-cb36c9416ffb)

```A new pop-up window as shown in the image and select http in this```
![image](https://github.com/user-attachments/assets/d9e3e693-bccc-4acc-8e71-554f13a70a10)


```So make sure to create two http request one for post and another for get, the initial created request will be get, you can click on that and select other methods```
![image](https://github.com/user-attachments/assets/562c7974-6ee3-4a4f-af11-47307fbd6516)

```
So after the methods have been created lets first do the post request to generate an id for the receipt and associate that id with the receipt
You will have to select the body -> raw -> json(by default) if not selected then select json
Add the request body as shown in the image and the url as shown and click on send
You will receive a response which will be UUID as string and 200 OK response
```
![image](https://github.com/user-attachments/assets/2fc88b52-4b90-4d8a-90e4-74eae0328d04)


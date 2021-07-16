#Credit Card Processor Application

A spring boot application which exposes 2 RestEndpoints to execute credit card related operation basically to execute ADD and ListAll cards from the system.

```
* Spring Boot  2.4.8 RELEASE
* H2 Database Runtime in Memory
* Spring Data JPA
* SpringFox Swagger
* SpringFox UI
* Junits
* Gradle
```

## <U>Installation</U> 

The application is built using gradle and all the depednecies will be added automatically

####Build the application:
```
./gradlew build
```

Note: On Windows use gradlew instead of ./gradlew

####Start the application:

```
./gradlew bootRun
```

For Running Tests and Generating the Test Report:
```
$ gradle bootrun

$ gradle test

```

## <U>Documentation</U>

* SpringFox Swagger

* Swagger UI is available on the link:
```
http://localhost:8080/swagger-ui/#/
http://localhost:8080/v2/api-docs
```


## <U>Testing API</U>

Testing with Postman Runner

Import the \artifacts\PublicisSapientTask.postman_collection.json file into postman and run the API tests (Spring Boot service should be running).


Testing with Maven

* Run Only unit tests

```
$./gradlew test
```

## Accessing Data in H2 Database

H2 Console

URL to access console : http://localhost:8080/h2-console/login.jsp

Fill the login form as below and click connect :

```
*
  Saved Settings: Generic H2 (Embedded)
* Setting Name: Generic H2 (Embedded)
* Driver Class: org.h2.Driver
* JDBC URL: jdbc:h2:mem:testdb
* User Name: sa
* Password: password
```

You can find your newly packaged JAR file in the lib/build/libs directory with the name lib.jar. Verify that the archive is valid by running the following command:


Microservices-with-Spring-Boot

REST Full web Service with Spring Boot

Introduction to Web Services
1. What is a Web Service?
2. Important How Questions related to Web Services
3. Web Services - Key Terminology
4. Introduction to SOAP Web Services
5. Introduction to RESTful Web Services
6. SOAP vs RESTful Web Services

SOAP:

1. Format - SOAP XML Request - SOAP XML Response

2. Transport -  
  OAP over MQ.   
  SOAP over HTTP.  
3. Service Definition -   
  WSDL
   
REST(REpresentational State Transfer):  
Def: REST is a style of software architecture for distributed hypermedia systems.

Make best use of HTTP:

Key abstraction - Resource

 1. A resource has an URI (Uniform Resource Identifier)
 2. /users/Ranga/todos/1
 3. /users/Ranga/todos
 4. /users/Ranga
 5. A resource can have different representations
 6. XML
 7. HTML
 8. JSON
 
Example

1. Create a User -  POST /users
2. Delete a User -  DELETE /users/1
3. Get all Users -  GET /users
4. Get one Users -  GET /users/1

REST
1. Data Exchange Format - No Restriction. JSON is popular
2. Transport - 
   Only HTTP
  
Service Definition

  1. No Standard. WADL/Swagger/…

REST vs SOAP
 
  1. Restrictions vs Architectural Approach
  2. Data Exchange Format
  3. Service Definition
  4. Transport
  5. Ease of implementation


Restful Web Services with Spring Boot

1. Step 01 - Initializing a RESTful Services Project with Spring Boot
2. Step 02 - Understanding the RESTful Services we would create in this course
3. Step 03 - Creating a Hello World Service
4. Step 04 - Enhancing the Hello World Service to return a Bean
5. Step 05 - Quick Review of Spring Boot Auto Configuration and Dispatcher Servlet
6. Step 06 - Enhancing the Hello World Service with a Path Variable
7. Step 07 - Creating User Bean and User Service
8. Step 08 - Implementing GET Methods for User Resource
9. Step 09 - Implementing POST Method to create User Resource
10. Step 10 - Enhancing POST Method to return correct HTTP Status Code and Location
11. Step 11 - Implementing Exception Handling - 404 Resource Not Found
12. Step 12 - Implementing Generic Exception Handling for all Resources
13. Step 13 - Exercise : User Post Resource and Exception Handling
14. Step 14 - Implementing DELETE Method to delete a User Resource
15. Step 15 - Implementing Validations for RESTful Services
16. Step 16 - Implementing HATEOAS for RESTful Services
17. Step 17 - Overview of Advanced RESTful Service Features
18. Step 18 - Internationalization for RESTful Services
19. Step 19 - Content Negotiation - Implementing Support for XML
20. Step 20 - Configuring Auto Generation of Swagger Documentation
21. Step 21 - Introduction to Swagger Documentation Format
22. Step 22 - Enhancing Swagger Documentation with Custom Annotations
23. Step 23 - Monitoring APIs with Spring Boot Actuator
24. Step 24 - Implementing Static Filtering for RESTful Service
25. Step 25 - Implementing Dynamic Filtering for RESTful Service
26. Step 26 - Versioning RESTful Services - Basic Approach with URIs
27. Step 27 - Versioning RESTful Services - Header and Content Negotiation Approach
28. Step 28 - Implementing Basic Authentication with Spring Security
29. Step 29 - Overview of Connecting RESTful Service to JPA
30. Step 30 - Creating User Entity and some test data
31. Step 31 - Updating GET methods on User Resource to use JPA
32. Step 32 - Updating POST and DELETE methods on User Resource to use JPA
33. Step 33 - Creating Post Entity and Many to One Relationship with User Entity
34. Step 34 - Implementing a GET service to retrieve all Posts of a User
35. Step 35 - Implementing a POST service to create a Post for a User
36. Step 36 - Richardson Maturity Model
37. Step 37 - RESTful Web Services - Best Practices

You will learn

1. What is a RESTful Web Service?
2. How to implement RESTful Web Services with Spring and Spring Boot?
3. What are the best practices in designing RESTful Web Services?
4. How to design Resources and GET, POST and DELETE operations?
5. How to implement Validation for RESTful Web Services?
6. How to implement Exception Handling for RESTful Web Services?
7. What is HATEOAS? How to implement HATEOAS for a Resource?
8. What are the different approach in versioning RESTful Services?
9. How to use Postman to execute RESTful Service Requests?
10. How to implement basic authentication with Spring Security?
11. How to implement filtering for RESTful Services?
12. How to monitor RESTful Services with Spring Boot Actuator?
13. How to document RESTful Web Services with Swagger?
14. How to connect RESTful Services to a backend with JPA?

Useful Links

POSTMAN - http://www.getpostman.com

Links from course examples

Basic Resources

http://localhost:8080/hello-world
http://localhost:8080/hello-world-bean
http://localhost:8080/hello-world/path-variable/Ranga
http://localhost:8080/users/
http://localhost:8080/users/1

JPA Resources

http://localhost:8080/jpa/users/
http://localhost:8080/jpa/users/1
http://localhost:8080/jpa/users/10001/posts

Filtering

http://localhost:8080/filtering
http://localhost:8080/filtering-list

Actuator

http://localhost:8080/actuator

Versioning

http://localhost:8080/v1/person
http://localhost:8080/v2/person
http://localhost:8080/person/param

params=[version=1]

http://localhost:8080/person/param

params=[version=2]

http://localhost:8080/person/header

headers=[X-API-VERSION=1]

http://localhost:8080/person/header

headers=[X-API-VERSION=2]

http://localhost:8080/person/produces

produces=[application/vnd.company.app-v1+json]

http://localhost:8080/person/produces

produces=[application/vnd.company.app-v2+json]

Swagger

http://localhost:8080/swagger-ui.html
http://localhost:8080/v2/api-docs

H2-Console

http://localhost:8080/h2-console

Error in the Log:

##############################################
Resolved exception caused by Handler execution:
org.springframework.http.converter.HttpMessageNotWritableEx
ception:
No converter found for return value of type:
class
com.in28minutes.rest.webservices.restfulwebservices.HelloWo
rldBean
##################################################

This happened because there were no getters in HelloWorldBean class

Questions to Answer

1. What is dispatcher servlet?
2. Who is configuring dispatcher servlet?
3. What does dispatcher servlet do?
4. How does the HelloWorldBean object get converted to JSON?
5. Who is configuring the error mapping?
6. Mapping servlet: ‘dispatcherServlet’ to [/]
7. Mapped “{[/hello-world],methods=[GET]}” onto public java.lang.String
   com.in28minutes.rest.webservices.restfulwebservices.HelloWorldController.helloWorld()
8. Mapped “{[/hello-world-bean],methods=[GET]}” onto public
   com.in28minutes.rest.webservices.restfulwebservices.HelloWorldBean
   com.in28minutes.rest.webservices.restfulwebservices.HelloWorldController.helloWorldBean()
9. Mapped “{[/error]}” onto public
   org.springframework.http.ResponseEntity<java.util.Map<java.lang.String,java.lang.Object»
   org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController.err or(javax.servlet.http.HttpServletRequest)
10. Mapped “{[/error],produces=[text/html]}” onto public org.springframework.web.servlet.ModelAndView
    org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController.err
    orHtml(javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse)

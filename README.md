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

.Create a User - POST /users
.Delete a User - DELETE /users/1
.Get all Users - GET /users
.Get one Users - GET /users/1

REST

>ata Exchange Format - No Restriction. JSON is popular
>ransport
  
   #Only HTTP
  
>Service Definition

  #No Standard. WADL/Swagger/…

REST vs SOAP
 
  #Restrictions vs Architectural Approach
  #Data Exchange Format
  #Service Definition
  #Transport
  #Ease of implementation


Restful Web Services with Spring Boot

#Step 01 - Initializing a RESTful Services Project with Spring Boot
#Step 02 - Understanding the RESTful Services we would create in this course
#Step 03 - Creating a Hello World Service
#Step 04 - Enhancing the Hello World Service to return a Bean
#Step 05 - Quick Review of Spring Boot Auto Configuration and Dispatcher Servlet
#Step 06 - Enhancing the Hello World Service with a Path Variable
#Step 07 - Creating User Bean and User Service
#Step 08 - Implementing GET Methods for User Resource
#Step 09 - Implementing POST Method to create User Resource
#Step 10 - Enhancing POST Method to return correct HTTP Status Code and Location
#Step 11 - Implementing Exception Handling - 404 Resource Not Found
#Step 12 - Implementing Generic Exception Handling for all Resources
#Step 13 - Exercise : User Post Resource and Exception Handling
#Step 14 - Implementing DELETE Method to delete a User Resource
#Step 15 - Implementing Validations for RESTful Services
#Step 16 - Implementing HATEOAS for RESTful Services
#Step 17 - Overview of Advanced RESTful Service Features
#Step 18 - Internationalization for RESTful Services
#Step 19 - Content Negotiation - Implementing Support for XML
#Step 20 - Configuring Auto Generation of Swagger Documentation
#Step 21 - Introduction to Swagger Documentation Format
#Step 22 - Enhancing Swagger Documentation with Custom Annotations
#Step 23 - Monitoring APIs with Spring Boot Actuator
#Step 24 - Implementing Static Filtering for RESTful Service
#Step 25 - Implementing Dynamic Filtering for RESTful Service
#Step 26 - Versioning RESTful Services - Basic Approach with URIs
#Step 27 - Versioning RESTful Services - Header and Content Negotiation Approach
#Step 28 - Implementing Basic Authentication with Spring Security
#Step 29 - Overview of Connecting RESTful Service to JPA
#Step 30 - Creating User Entity and some test data
#Step 31 - Updating GET methods on User Resource to use JPA
#Step 32 - Updating POST and DELETE methods on User Resource to use JPA
#Step 33 - Creating Post Entity and Many to One Relationship with User Entity
#Step 34 - Implementing a GET service to retrieve all Posts of a User
#Step 35 - Implementing a POST service to create a Post for a User
#Step 36 - Richardson Maturity Model
#Step 37 - RESTful Web Services - Best Practices

You will learn

What is a RESTful Web Service?
How to implement RESTful Web Services with Spring and Spring Boot?
What are the best practices in designing RESTful Web Services?
How to design Resources and GET, POST and DELETE operations?
How to implement Validation for RESTful Web Services?
How to implement Exception Handling for RESTful Web Services?
What is HATEOAS? How to implement HATEOAS for a Resource?
What are the different approach in versioning RESTful Services?
How to use Postman to execute RESTful Service Requests?
How to implement basic authentication with Spring Security?
How to implement filtering for RESTful Services?
How to monitor RESTful Services with Spring Boot Actuator?
How to document RESTful Web Services with Swagger?
How to connect RESTful Services to a backend with JPA?

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

Error in the Log
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

What is dispatcher servlet?
Who is configuring dispatcher servlet?
What does dispatcher servlet do?
How does the HelloWorldBean object get converted to JSON?
Who is configuring the error mapping?
Mapping servlet: ‘dispatcherServlet’ to [/]
Mapped “{[/hello-world],methods=[GET]}” onto public java.lang.String
com.in28minutes.rest.webservices.restfulwebservices.HelloWorldController.helloW
orld()
Mapped “{[/hello-world-bean],methods=[GET]}” onto public
com.in28minutes.rest.webservices.restfulwebservices.HelloWorldBean
com.in28minutes.rest.webservices.restfulwebservices.HelloWorldController.helloW
orldBean()
Mapped “{[/error]}” onto public
org.springframework.http.ResponseEntity<java.util.Map<java.lang.String,
java.lang.Object»
org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController.err
or(javax.servlet.http.HttpServletRequest)
Mapped “{[/error],produces=[text/html]}” onto public
org.springframework.web.servlet.ModelAndView
org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController.err
orHtml(javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletRespons
e)

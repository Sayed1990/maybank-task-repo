******************************
INTRODUCTION
******************************

This is a micro-service based API for Maybank Assignement task.

****************
Pre-Requirement:-
*****************

1) Install Docker on windows or Linus or Mac machine
2) Install IDE for packaging the war with jdk version 23
3) kafka with zookeeper ( if want to run locally)
4) Postman Rest Api Client

*******************
TECHNOLOGY USED
*******************

1) Spring-boot version 3.4.0
2) Java Version 21 used but targeted compiler is 23
3) Apache Camel for dynamic routing for calling third Party API
4) RestTemplate for calling third party API
5) Feign Client for interacting with microservices registered under Eureka Server
6) Eureka Server
7) Kafka for event-driver and partially saga pattern
8) docker for containarization.
9) Swagger-UI to access documentation
10) Log SLF4J


**************
Important Note
**************

1) When you are running in local, make sure that you change these details first before build your project :-


   A) On User management Application.yml under resources folder set these values:-

       - bootstrap-servers: localhost:9092
       - micro-service.book-service.url: 127.0.0.1:8071 
   B) On Book management Application.yml under resources folder set these values:-	  

       - spring.kafka.consumer.bootstrap-servers: localhost:9092



	  
*****************
HOW TO RUN LOCALLY
*****************

1) import through maven and choose project as 'maven"
2) let the IDE finish indexes and imports of dependencies. Execute "mvn clean install -Dskiptests"
3) Run as APPLication and choose main springboot class
4) once successfully run, open postman and call the APIS
5) Make sure to change this value from user-management application.yml file when running in local machine :-
    micro-service:
     book-service:
               name: book-management
               url: 127.0.0.1:8071

Note : There is one endpoint which requires Kafka to be setup locally. And the endpoint is "/data/add". Please download zookeeper and kafka in local machine to run otherwise, please skip testing this api.

To Access swagger API from browser:-

1) USER-MANAGEMENT SWAGGER URL : http://localhost:8070/swagger-ui/index.html
2) BOOK-MANAGEMENT SWAGGER URL : http://localhost:8071/swagger-ui/index.html



**************************
HOW TO RUN THROUGH DOCKER
**************************

Before these steps, ensure that build the war file of all microservices ( user-microservice, eureka-server, and book-microservice). use "mvn clean install" then wait until finishes.

1) open CMD or PowerShell or Linux Shell and Navigate to "../maybank-task-repo\run-as-microservices-docker" folder where you can find the "docker-compose.yml" file
2) type " docker-compose up" if first time or "docker-compose up --build" for the subsequent build if any changes made in the code
3) Once the image is pulled, containerized, please inspect if network named as in docker-compose.yml file created. If not, try to run the batch file named as "add_To_Network.bat". If it gives error then,   please create manually by using this command "docker network create maybank-network" , then add all the services into the network using these commands:-
     docker network connect maybank-network eureka-server
     docker network connect maybank-network user-management
     docker network connect maybank-network book-management
     docker network connect maybank-network mysql-db
 After connected all the network, please inspect it to see if all mounted . use command "docker network inspect maybank-network"
4) once connected, now open postmaan and hit the api to test.


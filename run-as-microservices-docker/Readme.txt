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



*****************
HOW TO RUN LOCALLY
*****************

1) import through maven and choose project as 'maven"
2) let the IDE finish indexes and imports of dependencies
3) Run as APPLication and choose main springboot class
4) once successfully run, open postman and call the APIS

Note : There is one endpoint which requires Kafka to be setup locally. And the endpoint is "/data/add". Please download zookeeper and kafka in local machine to run otherwise, please skip testing this api.

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
     docker network connect maybank-network kafka-ui
     docker network connect maybank-network kafka
     docker network connect maybank-network mysql-db
     docker network connect maybank-network zookeeper
4) once connected, now open postmaan and hit the api to test.


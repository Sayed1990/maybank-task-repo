******************************
INTRODUCTION
******************************

This is a standalone single application based API for Maybank Assignement task.

****************
Pre-Requirement:-
*****************

1) Install Docker on windows or Linus or Mac machine
2) Install IDE for packaging the war with jdk version 23
3) Postman Rest Api Client

*******************
TECHNOLOGY USED
*******************

1) Spring-boot version 3.4.0
2) Java Version 21 used but targeted compiler is 23
3) Apache Camel for dynamic routing for calling third Party API
4) RestTemplate for calling third party API
5) Swagger-UI to access documentation
6) Log SLF4J
7) JUNIT springboot junit jupiter


**************
Important Note
**************

	  
*****************
HOW TO RUN LOCALLY
*****************

1) import through maven and choose project as 'maven"
2) let the IDE finish indexes and imports of dependencies. Execute "mvn clean install -Dskiptests"
3) Run as APPLication and choose main springboot class
4) once successfully run, open postman and call the APIS

To Access swagger API from browser:-

1) SWAGGER URL : http://localhost:8070/swagger-ui/index.html




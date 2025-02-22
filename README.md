***************
INTRODUCTION
***************

The system is about user registration, book management system and calling third party endpoint. Multi approach have been implemented to ease the Maybank side to run the program. The easiest way to run the program is by running as jar provided in the "run-as-jar" folder. 

The second easiest way to run is that by running the batch file created inside the "run-from-docker-images" folder in which the dockers images will be mounted to docker and no further setup needed from user end except just normally install the docker like any applications in Windows.

The third easiset way is directly run the code in IDE of any programmes inside "run-as-microservices-docker" or "run-as-single-standalone-application".

****************************
TECHNOLOGY USED AND PURPOSE
****************************

1) Eureka - To register microservices so that it will be visible to one another to connect and keep monitoring the status of the each services. In out case, both book-management and user-management need to interact with one another using feign clients.

2) Kafka - event streamer, to publish the message so that consumer pick it up. It is an event-driven based approach and why I used is because we are saving data from microservice#1 to microservice#2 which is from user management to book management. Assuming the data sent must be saved whenever the book service two is available. Also, Kafka's contents published to topics can be read whenever the consume wanted. As the data is consistent.

3) Apache camel - just for the sake of fun, but in User-management to call third party api, we use two ways; (1) restTemplate and (2) camel route. camel route is more dynamic and less codes and robust compared to restTemplate.

4) docker - for the purpose of containerization. 

5) JWT - for authorization token creation and invalidation upon logout.

6) microservices - decoupling the projects and increase the portability and maintaineability. Also for easy rollback approach. SAGA-LIKE PATTERN were used.

7) SWAGGER - For Documentation purposes
8) kafka-UI - To see kafka instances via browser
9) JUNIT - Functional testing ( however no surfire plugins included to run along with mvn clean install" only manually shold run
10) JDK21 and compiler is 23
11) Springboot latest version.
12) SPring AOP - to validate request before entering the controller layer. In our case, we used this for user management before request comes into login controller, certain detals will be checked.

***********
USE_CASE
***********

+-----------------------------+
|            Actors           |
+-----------------------------+
|           User              |
|           Public User       |
+-----------------------------+
           /         \
          /           \
+-----------------------------+
|           Use Cases         |
+-----------------------------+
| [Login to the system]       |
| [Save book details]         |
| [Get book details]          |
| [Delete book details]       |
| [Update user details]       |
| [Logout]                    |
| [Fetch list of countries]   |
| [Register user]             |
+-----------------------------+
             |
             |
       +-------------+
       |             |
+-------------+ +-------------+
| JWT Secured | | Public APIs |
|   Services  | |             |
|             | |             |
+-------------+ +-------------+



README

A) TO RUN AS "SINGLE STANDALONE APPLICATION" please navigate to directory "run-as-single-standalone-application" and read the readMe before running the application.

B) TO RUN AS "MiCRO-SERVICE APPLICATION" either locally or dockerly, please navigate to directory "run-as-microservices-docker" and read the readMe before running the application.

C) TO RUN Just a JAR File and test,  please navigate to directory "run-as-jar" and read the readMe before running the application.	

D) TO MOUNT THE DOCKER IMAGES AND RUN IN DOCKER WITHOUT PULLING NEWLY TO CREAATE IMAGE, Please navigate to directory "run-from-docker-images"



*************************
IMPORTANT NOTICE
*************************

Before running any application , please make sure to setup database as below:-

url : localhose
port : 3306
username : root
password: toor
schema-name: maybank-db




Once the schema is created, springboot will map the entity class to create table using hibernate ORM mapping functions.

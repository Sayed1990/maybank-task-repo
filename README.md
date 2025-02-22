README

A) TO RUN AS "SINGLE STANDALONE APPLICATION" please navigate to directory "run-as-single-standalone-application" and read the readMe before running the application.

B) TO RUN AS "MiCRO-SERVICE APPLICATION" either locally or dockerly, please navigate to directory "run-as-microservices-docker" and read the readMe before running the application.

C) A) TO RUN Just a JAR File and test,  please navigate to directory "run-as-jar" and read the readMe before running the application.	



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

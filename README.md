# weekend-planner
Weekend Planner is a portal for Practeon where they can post a trip with some details and get more number of people in there Trip

Travis Build Status:
[![Travis-ci Build Status](https://travis-ci.org/ankitsin/weekend-planner.svg?branch=master)](https://travis-ci.org/ankitsin/weekend-planner)

###Amazon EC2 running instance url:
<http://52.27.31.124/weekend_planner/>

### Dependency Required
Java Version: 1.8.0
Maven
MySql

### Installation and Running
1. This application is packaged as a war.
2. Make changes in hibernate.xml (specify your entity folder) and application.properties(change database name, MySQL username and password)
3. First, clone the repo.git clone https://github.com/ankitsin/weekend-planner.git
4. Create the database schema in local. Please download the sql file and import it into your database. [Link](https://drive.google.com/file/d/0B8mDgmNLi0iDVlptZ1poMzRyNkU/view?usp=sharing)
5. To create a JAR 

        mvn clean generate-sources package

6. To start application

  1. Using jar 

            java -jar target/car-pool-0.0.1-SNAPSHOT.jar

 2. Without Jar

            jar mvn spring-boot:run


### Schema Design
[My Schema Design]
(https://drive.google.com/open?id=0B8mDgmNLi0iDRTJHVnppUXdlN1U)

### Apiary Documentation Link
Here the Apiary documnetation of the API. [Link](http://docs.weekendplanner.apiary.io/)


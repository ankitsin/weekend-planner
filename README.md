# Weekend-planner
Weekend Planner is a portal for Practeon where they can post a trip with details and get more number of people involved there Trip so that the per person cost of the Trip can be minimized. This will also increase interaction between employees.

##Requirements:
###Must Have:

1. User Creation
2. Posting
3. Listing
4. Signup for trip
5. View personal listing

###Good to Have:

1. Mail send containing details of trip to the user who has signed up and the user who has posted it
2. API can be used by third party software.

### Schema Design
My Schema Design [Link]
(https://drive.google.com/open?id=0B8mDgmNLi0iDRTJHVnppUXdlN1U)

### Apiary Documentation Link
Here the Apiary documnetation of the API. [Link](http://docs.weekendplanner.apiary.io/)

### Tools Used/Reqiured for the Project
1. Java Version: 1.8.0
2. Maven
3. MySql Database
4. HSQL(In Memory) Database
5. New Relic
6. Travis
7. Google Auth for Login
8. Sentry
9. Amazon EC2
10. Google Checkstyle
11. Google Code fromatter

## Installation and Running
1. Install Tomcat using the [script](https://drive.google.com/open?id=0B8mDgmNLi0iDRExNMDVqWEhmLU0) provide 
2. Make changes in hibernate.xml (specify your entity folder) and application.properties(change database name, MySQL username and password)
4. Create the database schema in local. Please download the sql file and import it into your database. [Link](https://drive.google.com/file/d/0B8mDgmNLi0iDVlptZ1poMzRyNkU/view?usp=sharing)
5. Download and run the [script](https://drive.google.com/open?id=0B8mDgmNLi0iDRVktYTZja1hBZHM). This will create a war file tomcat folder and run it on the port:8080 (localhost:8080/wp)

## Tools Result

### Java Doc
Link to Java Doc[Link] of the Code.
(http://ec2-52-27-31-124.us-west-2.compute.amazonaws.com/wp/doc/index.html)

### New Relic
Link to New Relic[Link]
(https://rpm.newrelic.com/accounts/1403528)
1. UserName: ankitsin37@gmail.com
2. Password: qwerty123

### Sentry
Link to Sentry[Link]
(https://app.getsentry.com/practo-sp/weekend_planner/dashboard/)
1. Username: ankitsin37@gmail.com
2. Password: qwerty123

###Travis Build Status:
[![Travis-ci Build Status](https://travis-ci.org/ankitsin/weekend-planner.svg?branch=master)](https://travis-ci.org/ankitsin/weekend-planner)

### Jacoco Code coverage:
Link to code coverage generated by Jacoc [Link](http://ec2-52-27-31-124.us-west-2.compute.amazonaws.com/wp/code/index.html)

### Jmeter Test Results:
Link to Jmeter result [Link](http://ec2-52-27-31-124.us-west-2.compute.amazonaws.com/wp/jmeter/image.png)

###Amazon EC2 running instance url:
<http://ec2-52-27-31-124.us-west-2.compute.amazonaws.com/wp/>

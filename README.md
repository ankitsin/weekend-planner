# weekend-planner
Weekend Planner is a portal for Practeon where they can post a trip with some details and get more number of people in there Trip

Travis Build Status:
[![Travis-ci Build Status](https://travis-ci.org/ankitsin/weekend-planner.svg?branch=master)](https://travis-ci.org/ankitsin/weekend-planner)

###Amazon EC2 running instance url:
<http://ec2-52-27-31-124.us-west-2.compute.amazonaws.com/wp/>

### Dependency Required
1. Java Version: 1.8.0
2. Maven
3. MySql Database
4. HSQL In Memory Database
5. New Relic
6. Travis
7. Google Auth for Login
8. Sentry
9. Amazon EC2

### Installation and Running
1. Install Tomcat using the script provide (https://drive.google.com/open?id=0B8mDgmNLi0iDRVktYTZja1hBZHM)
2. Make changes in hibernate.xml (specify your entity folder) and application.properties(change database name, MySQL username and password)
4. Create the database schema in local. Please download the sql file and import it into your database. [Link](https://drive.google.com/file/d/0B8mDgmNLi0iDVlptZ1poMzRyNkU/view?usp=sharing)
5. Download and run the [script](https://drive.google.com/open?id=0B8mDgmNLi0iDRExNMDVqWEhmLU0). This will create a war file tomcat folder and run it on the port:8080 (localhost:8080/wp)

### New Relic
1. UserName: ankitsin37@gmail.com
2. Password: qwerty123

[New Relic Link]
(https://rpm.newrelic.com/accounts/1403528)

### Sentry
1. Username: ankitsin37@gmail.com
2. Password: qwerty123

[Sentry]
(https://app.getsentry.com/practo-sp/weekend_planner/dashboard/)

### Java Doc
[Java Doc]
(http://ec2-52-27-31-124.us-west-2.compute.amazonaws.com/wp/doc/index.html)

### Schema Design
[My Schema Design]
(https://drive.google.com/open?id=0B8mDgmNLi0iDRTJHVnppUXdlN1U)

### Apiary Documentation Link
Here the Apiary documnetation of the API. [Link](http://docs.weekendplanner.apiary.io/)


# Initializing a Dockerized PostgreSQL Database Using Liquibase in Java

This project explores how to leverage Liquibase to initialize a Dockerized PostgreSQL database 
in a Java application. 

### The [DatabaseInitializer](./src/main/java/com/heliorodri/db/DatabaseInitializer.java) class 
It handles the connection establishment and Liquibase integration. 
Additionally, 

### the [DatabaseVerification](./src/main/java/com/heliorodri/db/DatabaseVerification.java) class 
it verifies the existence of specific tables. 

### the [Main](./src/main/java/com/heliorodri/Main.java) class
By running it we are able to initialize the database and validate the process using log statements.

### [changelog.xml](./src/main/resources/changelog.xml) file 
defines a changeSet for creating a "users" table. 

### [Docker compose file](docker-compose.yml) to run the PostgreSQL database.

### By following these steps, you can enhance and customize the database initialization process based on your specific requirements.
# Jokes Application - Backend
This is an application that tells jokes, based on REST API and using an external api: http://www.icndb.com/api/ to generate jokes.

## Technology stack and tools:
* Java 11
* Spring Boot (v 2.4.4)
* Maven
* H2 and PostgrSQL

## The content of the task:

* After launching, the application should automatically read the path to the person_db.csv file in the local file system 
(defined e.g. in application.properties), and then parse and load the file into the "in-memory" structure designed for this purpose, 
hereinafter referred to as the repository.
Note: The first line in the file is the header. The "name" field is the unique identifier of the record, the "age" field is mandatory for a record, 
and one record can have multiple "hobby" items. Acceptable "hobby" values are: Sports, Gaming, Traveling, Movies, Music, Cooking, Reading, Dancing. 
If the record does not have a defined age or has an unacceptable "hobby" value, then such an entry must be ignored.

* (4) Implement a service class that will be able to return the following data based on the data from the repository:
- the number of all persons,
- the number of people above the set age,
- the average age of all people,
- a collection of hobbies of all people.

* (5) Implement a service class that will check for the person with the given name if that person is in the repository and if so, 
generate and then return a random joke (String) using an external service (http://www.icndb.com/api/) . 
The joke should be personalized so that "firstName" is the first name and "lastName" is the age of the repository person. 
Use RestTemplate to communicate with an external API.

* Implement a controller that will issue an endpoint (REST API) returning data provided by the website from point 5.
* Extend the controller from point 6 with endpoints that display data provided by the service from point 4.
* Cover your repository, services and controllers (as desired) with unit tests (jUnit 5).
* Pay attention to handling exceptional situations in each of the above points, e.g. the lack of availability of external services.

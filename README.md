# Jokes Application - Backend
This is an application that tells jokes, based on REST API 
and using an external api: http://www.icndb.com/api/ to generate jokes.

The application will read the .csv file from the local path on your computer 
and generate a random joke with the name specified in the file.

Have fun!

## Technology stack and tools:
* Java 11
* Spring Boot (v 2.4.4)
* Maven
* H2

## CSV file property
To add and read an external .csv file into the application, please set the file path 
directly in application properties to "resource.path.InputDirectory".

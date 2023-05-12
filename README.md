# DoctorAnywhere Assessment

## Task

To build a simple RESTful API using Java and Spring Boot.

## Tech

- Spring Boot
- Maven
- MySQL
- lombok

## Features

- CRUD endpoints
- Spring Data JPA to store task data in a MySQL database
- Custom Error handling for each endpoint

## Requirements

- MySQL server running on port 3306
- create MySQL database with name 'da_todo'

## Base URL

The base URL for all API endpoints is: http://localhost:8080

## Endpoints

### Get all tasks

URL: http://localhost:8080/tasks

Method: GET

### Get all tasks

URL: http://localhost:8080/tasks

Method: GET

Description: Get a list of all tasks

### Create new task

URL: http://localhost:8080/tasks

Method: POST

Description: Create a new task

Request Body: Task object in JSON format with the following properties:

- 'title' (string, required): title of the task
- 'description' (string, optional): description of the task

### Get single task

URL: http://localhost:8080/tasks/{id}

Method: GET

Description: Get a single task by ID

Parameters:

- '{id}': the ID of the task

### Update task

URL: http://localhost:8080/tasks/{id}

Method: PUT

Description: Update a task by ID

Parameters:

- '{id}': the ID of the task

### Delete task

URL: http://localhost:8080/tasks/{id}

Method: DELETE

Description: Delete a task by ID

Parameters:

- '{id}': the ID of the task

### Delete all tasks

URL: http://localhost:8080/tasks/

Method: DELETE

Description: Delete all tasks for testing purpose, not part of assessment

Parameters:

- '{id}': the ID of the task

## Custom Error handling

- TaskNotFoundException: error thrown when task id does not exist

- FieldIncompleteException: error thrown when 'title' field is empty when creating a new task

## Assumptions:

- only title field is required when creating a task; description optional
- when updating a specified task, the body of the request must contain 'title','description' and 'column', updated or not. This will be processed on the client side.

# JDBC Student Management App

This repository contains the source code and resources for building a Student Management App using JDBC (Java Database Connectivity). The project is inspired by the crash course provided by the YouTube channel "Learn Code with Durgesh," which can be found [here](https://www.youtube.com/watch?v=lZbl7Q21t4s).

JDBC is a Java API that allows Java programs to interact with relational databases. This project leverages JDBC to create a comprehensive student management system that can perform CRUD (Create, Read, Update, Delete) operations on student records stored in a database.

## Key Features

- Connect to a database using JDBC and establish a connection with the database server.
- Create tables to store student information using SQL statements.
- Implement functionality to add, retrieve, update, and delete student records in the database.
- Build a user-friendly command-line interface for interacting with the application.
- Utilize JDBC prepared statements to prevent SQL injection attacks and enhance security.
- Perform database operations such as querying and filtering student records based on specific criteria.



## Getting Started

To get started with the project, follow the step-by-step tutorial provided by Learn Code with Durgesh [here](https://www.youtube.com/watch?v=lZbl7Q21t4s&t=1364s). The tutorial covers the basics of JDBC and guides you through the process of building the Student Management App.

## Usage

1. Clone the repository:

```bash
git clone https://github.com/your-username/jdbc-student-management-app.git 

```

2. Open the project in your favorite Java IDE.

3. Configure your database connection details in the code, including the database URL, username, and password in a environment variable file (.env).

4. Run the application and interact with the command-line interface to perform CRUD operations on student records.

## Available Commands

1. **ADD** - Add a new student to the database.
   Usage: java -jar target/jdbc-student-management-app.jar add [options]
   
   Options:
            <div>-n, --name <student_name>: Specify the name of the student.</div>
            <div>-p, --phone <phone_number>: Specify the phone number of the student.</div>
            <div>-c, --city <city_name>: Specify the city of residence of the student.</div>

2. **DELETE** - Delete a student from the database.
   Usage: java -jar target/jdbc-student-management-app.jar delete [options]
   
   Options:
            <div>-id, --student-id <student_id>: Specify the ID of the student to delete.</div>

3. **UPDATE** - Update a student in the database.
   Usage: java -jar target/jdbc-student-management-app.jar update [options]
   
   Options:
            <div>-id, --student-id <student_id>: Specify the ID of the student to update.</div>
            <div>-n, --name <student_name>: Specify the updated name of the student.</div>
            <div>-p, --phone <phone_number>: Specify the updated phone number of the student.</div>
            <div>-c, --city <city_name>: Specify the updated city of residence of the student.</div>

4. **DISPLAY** - Display all students in the database.
   Usage: java -jar target/jdbc-student-management-app.jar display

5. **EXIT** - Exit the application.
   Usage: java -jar target/jdbc-student-management-app.jar exit



## Contributions

Contributions to the project are welcome! If you find any issues or have suggestions for improvements, please open an issue or submit a pull request.

## License

This project is licensed under the MIT License.

# Human Resource Management System (HRMS)

## Project Overview

The Human Resource Management System (HRMS) is a console-based Java application developed to manage employee information, attendance records, and leave requests efficiently.

The system allows HR administrators to perform employee-related operations such as adding, updating, deleting, and searching employee records. It also provides attendance tracking, leave management, report generation, user authentication, and file-based data persistence.

---

## Features

### Employee Management

* Add Employee
* View Employees
* Update Employee
* Delete Employee
* Search Employee by:

  * Employee ID
  * Employee Name
  * Department

### Attendance Management

* Mark Attendance
* View Attendance Records
* Present/Absent Status Tracking

### Leave Management

* Add Leave Request
* View Leave Requests
* Approve Leave Requests
* Reject Leave Requests

### Reports

* Employee Report
* Attendance Report
* Leave Report
* Generate All Reports

### Authentication

* Secure Login for HR Administrator

### Data Persistence

* Employee data stored in employees.txt
* Attendance data stored in attendance.txt
* Leave data stored in leaves.txt

---

## Technologies Used

* Java
* Object-Oriented Programming (OOP)
* ArrayList
* File Handling
* Exception Handling
* Interface Implementation
* VS Code

---

## Project Structure

Employee.java

EmployeeService.java

Attendance.java

AttendanceService.java

LeaveRequest.java

LeaveService.java

AuthService.java

ReportGenerator.java

ReportService.java

Main.java

employees.txt

attendance.txt

leaves.txt

---

## OOP Concepts Implemented

* Classes and Objects
* Encapsulation
* Constructors
* Methods
* Interfaces
* Abstraction
* File Handling
* Exception Handling

---

## How to Run

1. Open the project in VS Code.
2. Open the terminal.
3. Compile all Java files:

javac *.java

4. Run the application:

java Main

5. Login using:

Username: admin

Password: admin123
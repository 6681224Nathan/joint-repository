#for airline schemas and stuff, HOMEWORK

CREATE DATABASE air_transportation;
USE air_transportation;

CREATE TABLE airport(
	airport_code char(4), #usuall in three-four capital letters 
    airport_names varchar(50),
    latitude decimal(9,6), #a more precise version of long
    longitude decimal(9,6),
    airport_city varchar(50),
    airport_state varchar(50),
    
    PRIMARY KEY (airport_code)
    
);

CREATE TABLE airline(
	airline_no int,
    airline_name varchar(40),
    
    PRIMARY KEY (airline_no)
);

CREATE TABLE airplane(
	airplane_no int,
    airplane_name varchar(40),
    airplane_model varchar(40),
    airline_no int,
    
    PRIMARY KEY (airplane_no),
    FOREIGN KEY (airline_no) REFERENCES airline(airline_no)
);

CREATE TABLE flight(
	flight_no int,
	flight_distance int,
    flight_duration int,
    departure_time datetime,
    arrival_time datetime,
    departure_location char(4),
    arrival_location char(4),
    airline_no int,
    airplane_no int,
    
    PRIMARY KEY (flight_no),
    FOREIGN KEY (departure_location) REFERENCES airport(airport_code),
    FOREIGN KEY (arrival_location) REFERENCES airport(airport_code),
    FOREIGN KEY (airline_no) REFERENCES airline(airline_no),
    FOREIGN KEY (airplane_no) REFERENCES airplane(airplane_no)
    
);

#02

CREATE TABLE Emp(
	Eid int,
	Ename varchar(50),
	Age int,
	Salary real
);
CREATE TABLE Works(
	Eid int,
	Did int,
	Begindata int
);
CREATE TABLE Dept(
	Did int,
	Budget real,
	Managerid int
);

#(a) Show the list of employees who make the salary between 30,000 Baht and 50,000 Baht.

Select * From Emp where Salary > 30000 And Salary < 50000;

#(b) Show the manager id and name who have a lowest salary.

Select Eid, Ename From ( Select * from Emp INNER JOIN Dept ON Emp.eid = Dept.managerid) ORDER BY 
Salary asc limit 1;

#c) Find the department that the total salary of over all employees is higher than department budget
SELECT Dept.did, 
       SUM(salary) AS total_salary, 
       Dept.budget
FROM Emp 
INNER JOIN Works ON Emp.eid = Works.eid
INNER JOIN Dept ON Works.did = Dept.did
GROUP BY Dept.did, Dept.budget
HAVING SUM(salary) > Dept.budget;




	
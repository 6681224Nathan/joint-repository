CREATE DATABASE lecture10_people; 

USE lecture10_people;



CREATE TABLE Gender(
	GenderID int NOT NULL PRIMARY KEY,
	Gender varchar(255) NOT NULL
);

INSERT Gender (GenderID, Gender) VALUES (1, 'Female');
INSERT Gender (GenderID, Gender) VALUES (2, 'Male');
INSERT Gender (GenderID, Gender) VALUES (3, 'Unknown');


CREATE TABLE Person(
	PersonID int Auto_Increment PRIMARY KEY NOT NULL,
	FirstName varchar(20),
	LastName varchar(20) NOT NULL,
	GenderID int NULL,
	FOREIGN KEY (GenderID) REFERENCES Gender(GenderID)
);

INSERT Person (PersonID, FirstName, LastName, GenderID) VALUES (1, 'Grude', 'Larson', 1);
INSERT Person (PersonID, FirstName, LastName, GenderID) VALUES (2, 'Raymond', 'Kouma', NULL);
INSERT Person (PersonID, FirstName, LastName, GenderID) VALUES (3, 'Peter', 'Mukoko', 2);
INSERT Person (PersonID, FirstName, LastName, GenderID) VALUES (4, 'Wally', 'Baston', 2);
INSERT Person (PersonID, FirstName, LastName, GenderID) VALUES (5, 'Sylvai', 'Nguyen', NULL);
INSERT Person (PersonID, FirstName, LastName, GenderID) VALUES (6, 'Donald', 'Wallace', 2);
INSERT Person (PersonID, FirstName, LastName, GenderID) VALUES (7, 'Hermine', 'Kana', 1);
INSERT Person (PersonID, FirstName, LastName, GenderID) VALUES (8, 'Charlotte', 'Thomas', NULL);
INSERT Person (PersonID, FirstName, LastName, GenderID) VALUES (9, 'Paula', 'Barbers', NULL);
INSERT Person (PersonID, FirstName, LastName, GenderID) VALUES (10, 'Crissie', 'Dentd', 1);
INSERT Person (PersonID, FirstName, LastName, GenderID) VALUES (11, 'Ernestine', 'Essien', 1);
INSERT Person (PersonID, FirstName, LastName, GenderID) VALUES (12, 'Barbara', 'Randt', NULL);
INSERT Person (PersonID, FirstName, LastName, GenderID) VALUES (13, 'Helene', 'Cranston', 1);
INSERT Person (PersonID, FirstName, LastName, GenderID) VALUES (14, 'Robert', 'Palau', 3);
INSERT Person (PersonID, FirstName, LastName, GenderID) VALUES (15, 'Paulette', 'Krazucky', 1);
INSERT Person (PersonID, FirstName, LastName, GenderID) VALUES (16, 'Frank', 'Cranston', NULL);

SELECT
Person.PersonID, 
Person.FirstName,
Person.LastName, 
Person.GenderID, 
gender.GenderID AS Gender_ID,
gender.Gender
FROM   Person
 INNER JOIN   gender 
ON Person.GenderID = gender.GenderID;

SELECT
Person.PersonID, 
Person.FirstName,
Person.LastName, 
Person.GenderID, 
gender.GenderID AS Gender_ID,
gender.Gender
FROM   Person
 LEFT JOIN   gender 
ON Person.GenderID = gender.GenderID;

SELECT
Person.PersonID, 
Person.FirstName,
Person.LastName, 
Person.GenderID, 
gender.GenderID AS Gender_ID,
gender.Gender
FROM   Person
 RIGHT JOIN   gender 
ON Person.GenderID = gender.GenderID;
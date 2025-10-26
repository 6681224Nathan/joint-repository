Create database YugoNationalBank;
USE YugoNationalBank;


CREATE TABLE Locations
(
    LocationID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    LocationCode varchar(10) NOT NULL,
    Address varchar(120),
    City varchar(50),
    State varchar(50),
    ZIPCode varchar(12)
);

INSERT INTO Locations
VALUES(0, '826005', '3925 Euler Ave', 'Silver Spring', 'MD', '20904');

INSERT INTO Locations
VALUES(0, '249615', '', 'Alexandria', 'VA', '22132');

INSERT INTO Locations
VALUES(0, '936486', '', 'Washington', 'DC', '20008');

INSERT INTO Locations
VALUES(0, '824405', '', 'Silver Spring', 'MD', '20906');

INSERT INTO Locations
VALUES(0, '429025', '', 'Rockville', 'MD', '20854');

INSERT INTO Locations
VALUES(0, '703648', '', 'Washington', 'DC', '21090');

-- =========================================
-- Table:    AccountTypes
-- =========================================

CREATE TABLE AccountTypes
(
    AccountTypeID int NOT NULL AUTO_INCREMENT PRIMARY KEY, 
    AccountType varchar(40) NOT NULL, 
    Notes text NULL
);

INSERT INTO AccountTypes
VALUES(0, 'Checking', 'Used to regularly deposit and withdraw money at will');
INSERT INTO AccountTypes
VALUES(0, 'Saving', 'Used to deposit money to save it but hardly withdraw it');
INSERT INTO AccountTypes
VALUES(0, 'CD', 'Certificate of Deposit');


-- =========================================
-- Table:    Employees
-- =========================================

CREATE TABLE Employees
(
    EmployeeID int NOT NULL AUTO_INCREMENT PRIMARY KEY, 
    EmployeeNumber char(6),
    FirstName varchar(32),
    LastName varchar(32) NOT NULL,
    Title varchar(50),
    WorkPhone varchar(20),
    Extension smallint,
    Address varchar(120),
    City varchar(40),
    State varchar(40),
    Country varchar(50),
    HourlySalary float
);

INSERT INTO Employees
VALUES(0, '22082', 'Matt', 'Yuen', 'Head Cashier', '(410) 653-1309', 228, '828 John Booker St', 'Baltimore', 'MD', 'USA', 22.82);
INSERT INTO Employees
VALUES(0, '46288', 'Catherine', 'Marconi', 'Customer Account Manager', '(410) 653-1309', 145, '845 Arcadia Ave. #1512', 'Townson', 'MD', 'USA', 22.55);
INSERT INTO Employees
VALUES(0, '27199', 'Leonie', 'Ankoma', 'Cashier', '(410) 653-1309', 616, '1277 Cecil Maurice Av.', 'Baltimore', 'MD', 'USA', 14.88);
INSERT INTO Employees
VALUES(0, '19804', 'Sylvie', 'Young', 'Regional Manager', '(410) 653-1309', 208, '273 S. Independence Ave.', 'Baltimore', 'MD', 'USA', 16.22);
INSERT INTO Employees
VALUES(0, '27284', 'Andy', 'Holland', 'Assistant Manager', '(410) 653-1309', 106, '8254 12th St. N.E.', 'Washington', 'DC', 'USA', 24.12);
INSERT INTO Employees
VALUES(0, '66286', 'Lienev', 'Zbrnitz', 'Cashier', '(410) 653-1309', 105, '15328 Crystal St.', 'Baltimore', 'MD', 'USA', 15.75);
INSERT INTO Employees
VALUES(0, '48725', 'Paulin', 'Santia', 'Intern', '(410) 653-1309', 226, '4445 Blue Oak St. #6A', 'Baltimore', 'MD', 'USA', 16.35);
INSERT INTO Employees
VALUES(0, '39538', 'Plant', 'Waste', 'Head Teller', '(410) 653-1309', 222, '2888 Gwett Richards Av.', 'Glen Burnie', 'MD', 'USA', 16.75);
INSERT INTO Employees
VALUES(0, '82730', 'Steven', 'Chang', 'Accountant', '(410) 653-1309', 128, '308 Capitol Blvd', 'Baltimore', 'MD', 'USA', 16.15);
INSERT INTO Employees
VALUES(0, '93077', 'Abedi', 'Kombo', 'Shift Programmer', '(410) 653-1309', 144, '12 16th St. S. W.', 'Washington','DC', 'USA', 10.56);
INSERT INTO Employees
VALUES(0, '11914','Samuel', 'McCain','Cashier', '(410) 653-1309', 142,'9337 Cachet St', 'Baltimore', 'MD','USA', 15.25);
INSERT INTO Employees 
VALUES(0, '92493', 'Kirsten', 'Roberts', 'Cashier', '(410) 653-1309', 164, '1336 Philadelphia St.', 'Baltimore', 'MD', 'USA', 18.05);
INSERT INTO Employees 
VALUES(0, '22086', 'William', 'Fake-Eye', 'Public Relations', '(410) 653-1309', 152, '58 North Assault St.', 'Baltimore', 'MD', 'USA',16.32);
INSERT INTO Employees 
VALUES(0, '90026', 'Roger', 'Lamy', 'Cashier', '(410) 653-1309', 174, '8252 Eleven Sons Rd', 'College Park', 'MD', 'USA', 10.24);
INSERT INTO Employees 
VALUES(0, '27707', 'Ada', 'Zeran', 'Administrative Assistant', '(410) 653-1309', 132, '992 White Horse Rd', 'Baltimore', 'MD', 'USA', 15.48);
INSERT INTO Employees 
VALUES(0, '27283', 'Milicien', 'Drudge', 'Cashier', '(410) 653-1309', 225, '13622 Washington Blvd', 'Laurel', 'MD', 'USA', 18.34);
INSERT INTO Employees
VALUES(0, '38525', 'Aaron', 'Kast', 'Accounts Manager', '(410) 653-1309', 214, '2991 Justine Ave.', 'Baltimore', 'MD', 'USA', 12.34);
INSERT INTO Employees 
VALUES(0, '71728', 'Antoine', 'Lourde', 'Regional Assistant Manager', '(410) 653-1309', 206, '720 Oak Tree Rd.', 'Columbia', 'MD', 'USA', 15.62);
INSERT INTO Employees 
VALUES(0, '40550', 'Lorraine', 'Kirkland','Assistant Manager', '(410) 653-1309', 136,'104 G St. S. E.', 'Washington', 'DC','USA', 12.86);
INSERT INTO Employees
VALUES(0, '55528','Jeffrey', 'Salomons','Cashier', '(410) 653-1309', 194,'3832 Great River Rd', 'Baltimore', 'MD','USA', 24.52);



-- =========================================
-- Table:    Deposits
-- =========================================

CREATE TABLE Deposits
(
    DepositID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    LocationID int NOT NULL,
    EmployeeID int,
    CustomerID int NOT NULL,
    DepositDate datetime NOT NULL,
    DepositAmount float NOT NULL,
    Notes text
);

INSERT INTO Deposits 
VALUES(0, 1, 1, 1, '2007-1-2', 250.00, 'New Account');

INSERT INTO Deposits 
VALUES(0, 1, 4, 6, '2007-1-5', 500.00, 'New Account');

INSERT INTO Deposits 
VALUES(0, 3, 3, 8, '2007-1-2', 50.00, 'New Account');

INSERT INTO Deposits
VALUES(0, 5, 6, 2, '2007-1-3', 740.00, 'New Account');

INSERT INTO Deposits 
VALUES(0, 1, 2, 5, '2007-1-4', 1350.00, 'New Account');

INSERT INTO Deposits 
VALUES(0, 1, 3, 3, '2007-1-8', 125.00, '');

INSERT INTO Deposits 
VALUES(0, 3, 7, 1, '2007-1-22', 200.00, '');

INSERT INTO Deposits 
VALUES(0, 2, 5, 4, '2007-1-4', 750.00, 'New Account');

INSERT INTO Deposits 
VALUES(0, 2, 8, 7, '2007-1-10', 250.00, '');

INSERT INTO Deposits 
VALUES(0, 4, 10, 9, '2007-1-2', 3200.00, 'New Account');

INSERT INTO Deposits 
VALUES(0, 3, 12, 8, '2007-1-22', 1850.00, 'New Account');

-- =========================================
-- Table:    Withdrawals
-- =========================================

CREATE TABLE Withdrawals
(
    WithdrawalID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    LocationID int NOT NULL,
    EmployeeID int,
    CustomerID int NOT NULL,
    WithdrawalDate datetime NOT NULL,
    WithdrawalAmount float NOT NULL
);

INSERT INTO Withdrawals 
VALUES(0, 5, 1, 1, '2007-1-4', 80.00);

INSERT INTO Withdrawals 
VALUES(0, 3, 3, 4, '2007-2-6', 200.00);

INSERT INTO Withdrawals 
VALUES(0, 2, 4, 6, '2007-1-26', 80.00);

INSERT INTO Withdrawals 
VALUES(0, 4, 2, 2, '2007-1-13', 100.00);

INSERT INTO Withdrawals 
VALUES(0, 1, 5, 3, '2007-1-18', 100.00);

INSERT INTO Withdrawals 
VALUES(0, 1, 4, 6, '2007-2-12', 20.00);

INSERT INTO Withdrawals 
VALUES(0, 3, 2, 8, '2007-1-20', 300.00);

INSERT INTO Withdrawals 
VALUES(0, 5, 6, 1, '2007-2-20', 300);

INSERT INTO Withdrawals 
VALUES(0, 6, 1, 5, '2007-1-24', 200.00);

INSERT INTO Withdrawals 
VALUES(0, 1, 3, 4, '2007-2-6', 60);

CREATE TABLE customer(
	CustomerID int PRIMARY KEY,
    

);


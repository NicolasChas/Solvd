
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
Drop database Persons;
CREATE DATABASE IF NOT EXISTS `Persons` ;
USE `Persons` ;

-- -----------------------------------------------------
-- Table `Person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Person (
  idPerson INT NOT NULL,
  Name VARCHAR(45) NOT NULL,
  Age INT NOT NULL,
  PRIMARY KEY (idPerson)
);

CREATE TABLE IF NOT EXISTS Student (
	StudentId INT NOT NULL,
	Grade VARCHAR(45) NOT NULL,
    idPerson INT unique,
    PRIMARY KEY (StudentId),
    FOREIGN KEY (idPerson) REFERENCES Person(idPerson)
);

CREATE TABLE IF NOT EXISTS ElementaryStudent (
	ElementaryStudentId INT NOT NULL,
	FavColor VARCHAR(45) NOT NULL,
    idStudent INT unique,
    PRIMARY KEY (ElementaryStudentId),
    FOREIGN KEY (idStudent) REFERENCES Student(StudentId)
);

CREATE TABLE IF NOT EXISTS HighSchoolStudent (
	HsStudentId INT NOT NULL,
	privateSchool bool NOT NULL,
    idStudent INT unique,
    PRIMARY KEY (HsStudentId),
    FOREIGN KEY (idStudent) REFERENCES Student(StudentId)
);

CREATE TABLE IF NOT EXISTS CollegeStudent (
	CollegeId INT NOT NULL,
	Career VARCHAR(45) NOT NULL,
    idStudent INT unique,
    PRIMARY KEY (CollegeId),
    FOREIGN KEY (idStudent) REFERENCES Student(StudentId)
);

CREATE TABLE IF NOT EXISTS Worker (
	WorkerId INT NOT NULL,
	CardNumber VARCHAR(45) NOT NULL,
    idPerson INT unique,
    PRIMARY KEY (WorkerId),
    FOREIGN KEY (idPerson) REFERENCES Person(idPerson)
);

CREATE TABLE IF NOT EXISTS Banker (
	BankerId INT NOT NULL,
	Bank VARCHAR(45) NOT NULL,
    idWorker INT unique,
    PRIMARY KEY (BankerId),
    FOREIGN KEY (idWorker) REFERENCES Worker(WorkerId)
);

CREATE TABLE IF NOT EXISTS Chef (
	ChefId INT NOT NULL,
	Specialization VARCHAR(45) NOT NULL,
    idWorker INT unique,
    PRIMARY KEY (ChefId),
    FOREIGN KEY (idWorker) REFERENCES Worker(WorkerId)
);

CREATE TABLE IF NOT EXISTS Farmer (
	FarmerId INT NOT NULL,
	FarmType VARCHAR(45) NOT NULL,
    idWorker INT unique,
    PRIMARY KEY (FarmerId),
    FOREIGN KEY (idWorker) REFERENCES Worker(WorkerId)
);

CREATE TABLE IF NOT EXISTS Lawyer (
	LawyerId INT NOT NULL,
	Firm VARCHAR(45) NOT NULL,
    idWorker INT unique,
    PRIMARY KEY (LawyerId),
    FOREIGN KEY (idWorker) REFERENCES Worker(WorkerId)
);

CREATE TABLE IF NOT EXISTS Plumber (
	PlumberId INT NOT NULL,
	License bool NOT NULL,
    idWorker INT unique,
    PRIMARY KEY (PlumberId),
    FOREIGN KEY (idWorker) REFERENCES Worker(WorkerId)
);

CREATE TABLE IF NOT EXISTS Teacher (
	TeacherId INT NOT NULL,
	Field VARCHAR(45) NOT NULL,
    idWorker INT unique,
    PRIMARY KEY (TeacherId),
    FOREIGN KEY (idWorker) REFERENCES Worker(WorkerId)
);

CREATE TABLE IF NOT EXISTS Politician (
	PoliticianId INT NOT NULL,
	Position VARCHAR(45) NOT NULL,
    idWorker INT unique,
    PRIMARY KEY (PoliticianId),
    FOREIGN KEY (idWorker) REFERENCES Worker(WorkerId)
);

INSERT INTO Person  VALUES
(1,"Peter Cerk",15),
(2,"Thomas Plank",10),
(3,"Carter Jones",21),
(4,"Helena Pierce",32),
(5,"Kevin Doyle",37),
(6,"Tim Becker",55),
(7,"Lisa Clark",28),
(8,"Saul Goodman",43),
(9,"Gordon Letterman",51),
(10,"Mario Luigi",62),
(11,"Peter Cerk",15),
(12,"Thomas Plank",10),
(13,"Carter Jones",21),
(14,"Helena Pierce",32),
(15,"Kevin Doyle",37),
(16,"Tim Becker",55),
(17,"Lisa Clark",28),
(18,"Saul Goodman",43),
(19,"Gordon Letterman",51),
(20,"Mario Luigi",62);

Insert into Student Values
(1,"Second Year",1),
(2,"Sixth Grade",2),
(3,"Sophomore",3);

Insert into Worker Values
(1,"5554432",4),
(2,"3321224",5),
(3,"7657765",6),
(4,"2235643",7),
(5,"7702813",8),
(6,"3813833",9),
(7,"4918163",10);

Insert into ElementaryStudent values
(1,"Blue",2);

Insert into HighSchoolStudent values
(1,false,1);

Insert into CollegeStudent values
(1,"Engineering",3);

Insert into Banker values
(1,"Central Bank",2);

Insert into Teacher values
(1,"Math",1);

Insert into Politician values
(1,"Senator",3);

Insert into Farmer values
(1,"Chicken Farm",4);

Insert into Lawyer values
(1,"Goodman Firm",5);

Insert into Chef values
(1,"Master Chef",6);

Insert into Plumber values
(1,true,7);

Update Person Set age=age+1 where Name="Peter Cerk";
Update Person Set age=age+1 where Name="Thomas Plank";
Update Person Set age=age+1 where Name="Carter Jones";
Update Person Set age=age+1 where Name="Helena Pierce";
Update Person Set age=age+1 where Name="Kevin Doyle";
Update Person Set age=age+1 where Name="Tim Becker";
Update Person Set age=age+1 where Name="Lisa Clark";
Update Person Set age=age+1 where Name="Saul Goodman";
Update Person Set age=age+1 where Name="Gordon Letterman";
Update Person Set age=age+1 where Name="Mario Luigi";

Delete from Person where idPerson=11;
Delete from Person where idPerson=12;
Delete from Person where idPerson=13;
Delete from Person where idPerson=14;
Delete from Person where idPerson=15;
Delete from Person where idPerson=16;
Delete from Person where idPerson=17;
Delete from Person where idPerson=18;
Delete from Person where idPerson=19;
Delete from Person where idPerson=20;

Alter table Banker add password VARCHAR(45);
Alter table Lawyer add debt boolean;
Alter table Politician add Salary bigint;
Alter table Chef add Specialty VARCHAR(60);
Alter table CollegeStudent add highSchoolTitle boolean;

SELECT Person.idPerson, Person.Name, Person.Age, Student.StudentId, Student.Grade, Student.idPerson,ElementaryStudent.ElementaryStudentId, ElementaryStudent.FavColor, 
ElementaryStudent.idStudent,HighSchoolStudent.HsStudentId, HighSchoolStudent.privateSchool, HighschoolStudent.idStudent, CollegeStudent.CollegeId, CollegeStudent.Career, 
CollegeStudent.idStudent, Worker.WorkerId, Worker.CardNumber, Worker.idPerson, Banker.BankerId, Banker.Bank, Banker.idWorker, Chef.ChefId, Chef.Specialization, Chef.idWorker, Farmer.FarmerId,
Farmer.FarmType, Farmer.idWorker, Lawyer.LawyerId, Lawyer.Firm, Lawyer.idWorker, Plumber.PlumberId, Plumber.License, Plumber.idWorker, Teacher.TeacherId, Teacher.Field, 
Teacher.idWorker, Politician.PoliticianId, Politician.Position, Politician.idWorker
FROM Person
LEFT JOIN Student ON Person.idPerson = Student.idPerson
LEFT JOIN ElementaryStudent ON Student.StudentId = ElementaryStudent.idStudent
LEFT JOIN HighSchoolStudent ON Student.StudentId = HighSchoolStudent.idStudent
LEFT JOIN CollegeStudent ON Student.StudentId = CollegeStudent.idStudent
LEFT JOIN Worker ON Person.idPerson = Worker.idPerson
LEFT JOIN Banker ON Worker.WorkerId = Banker.idWorker
LEFT JOIN Chef ON Worker.WorkerId = Chef.idWorker
LEFT JOIN Farmer ON Worker.WorkerId = Farmer.idWorker
LEFT JOIN Lawyer ON Worker.WorkerId = Lawyer.idWorker
LEFT JOIN Plumber ON Worker.WorkerId = Plumber.idWorker
LEFT JOIN Teacher ON Worker.WorkerId = Teacher.idWorker
LEFT JOIN Politician ON Worker.WorkerId = Politician.idWorker;
--5 statements with left, right, inner, outer joins.
Select Person.Name, Student.StudentId, CollegeStudent.idStudent
from Person
LEFT JOIN Student ON Person.idPerson = Student.idPerson
LEFT JOIN CollegeStudent ON Student.StudentId = CollegeStudent.idStudent;

Select Person.Name, Student.StudentId, HighSchoolStudent.idStudent
from Person
RIGHT JOIN Student ON Person.idPerson = Student.idPerson
RIGHT JOIN HighSchoolStudent ON Student.StudentId = HighSchoolStudent.idStudent;

Select Person.Name, Student.StudentId, ElementaryStudent.idStudent
from Person
INNER JOIN Student ON Person.idPerson = Student.idPerson
INNER JOIN ElementaryStudent ON Student.StudentId = ElementaryStudent.idStudent;

Select Person.Name, Worker.WorkerId, Farmer.idWorker
from Person
RIGHT JOIN Worker ON Person.idPerson = Worker.idPerson
RIGHT JOIN Farmer ON Worker.WorkerId = Farmer.idWorker;

Select Person.Name, Worker.WorkerId, Lawyer.idWorker
from Person
LEFT JOIN Worker ON Person.idPerson = Worker.idPerson
LEFT JOIN Lawyer ON Worker.WorkerId = Lawyer.idWorker
UNION
Select Person.Name, Worker.WorkerId, Lawyer.idWorker
from Person
RIGHT JOIN Worker ON Person.idPerson = Worker.idPerson
RIGHT JOIN Lawyer ON Worker.WorkerId = Lawyer.idWorker;

--7 statements with aggregate functions and group by and without having.
Select Name, Count(*)
From Person
Group by Name;

Select PoliticianId, MAX(Salary) 
From Politician
GROUP BY PoliticianId;

Select MIN(CardNumber), WorkerId
FROM Worker
Group by WorkerId;

Select idWorker, SUM(FarmerId)
FROM Farmer
Group by idWorker;

Select PoliticianId, AVG(Salary)
FROM Politician
Group by PoliticianId;

Select Count(LawyerId), idWorker
From Lawyer
Group by idWorker;
	
Select Count(TeacherId), idWorker
From Teacher
Group by idWorker;

--7 statements with aggregate functions and group by and with having.
Select Age, Count(idPerson)
From Person
Group By Age
Having COUNT(idPerson)>1;

Select CardNumber, Count(WorkerId)
From Worker
Group By CardNumber
Having COUNT(WorkerId)>1;

Select idPerson, MAX(Age)
From Person
Group by idPerson
Having MAX(Age)>18;

Select PoliticianId, MIN(Salary)
From Politician
Group by PoliticianId
Having Min(Salary)<1000000;

Select idPerson, AVG(Age)
From Person
Group by idPerson
Having AVG(Age)>18;

Select idPerson, MIN(Age)
From Person
Group by idPerson
Having MIN(Age)<18;

Select CardNumber, Count(WorkerId)
From Worker
Group By CardNumber
Having COUNT(WorkerId)<2;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

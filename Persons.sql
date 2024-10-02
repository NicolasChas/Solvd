
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE DATABASE IF NOT EXISTS `Persons` ;
USE `Persons` ;

-- -----------------------------------------------------
-- Table `Person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Person (
  idPerson INT NOT NULL AUTO_INCREMENT,
  PersonName VARCHAR(45) NOT NULL,
  Age INT NOT NULL,
  PRIMARY KEY (idPerson)
);

CREATE TABLE IF NOT EXISTS Student (
	StudentId INT NOT NULL AUTO_INCREMENT,
	Grade VARCHAR(45) NOT NULL,
    idPerson INT unique,
    PRIMARY KEY (StudentId),
    FOREIGN KEY (idPerson) REFERENCES Person(idPerson)
);

CREATE TABLE IF NOT EXISTS ElementaryStudent (
	ElementaryStudentId INT NOT NULL AUTO_INCREMENT,
	FavColor VARCHAR(45) NOT NULL,
    idStudent INT unique,
    PRIMARY KEY (ElementaryStudentId),
    FOREIGN KEY (idStudent) REFERENCES Student(idStudent)
);

CREATE TABLE IF NOT EXISTS HighSchoolStudent (
	HsStudentId INT NOT NULL AUTO_INCREMENT,
	privateSchool bool NOT NULL,
    idStudent INT unique,
    PRIMARY KEY (HsStudentId),
    FOREIGN KEY (idStudent) REFERENCES Student(idStudent)
);

CREATE TABLE IF NOT EXISTS CollegeStudent (
	CollegeId INT NOT NULL AUTO_INCREMENT,
	Career VARCHAR(45) NOT NULL,
    idStudent INT unique,
    PRIMARY KEY (CollegeId),
    FOREIGN KEY (idStudent) REFERENCES Student(idStudent)
);

CREATE TABLE IF NOT EXISTS Worker (
	WorkerId INT NOT NULL AUTO_INCREMENT,
	CardNumber VARCHAR(45) NOT NULL,
    idPerson INT unique,
    PRIMARY KEY (WorkerId),
    FOREIGN KEY (idPerson) REFERENCES Person(idPerson)
);

CREATE TABLE IF NOT EXISTS Banker (
	BankerId INT NOT NULL AUTO_INCREMENT,
	Bank VARCHAR(45) NOT NULL,
    idWorker INT unique,
    PRIMARY KEY (BankerId),
    FOREIGN KEY (idWorker) REFERENCES Worker(idWorker)
);

CREATE TABLE IF NOT EXISTS Chef (
	ChefId INT NOT NULL AUTO_INCREMENT,
	Specialization VARCHAR(45) NOT NULL,
    idWorker INT unique,
    PRIMARY KEY (ChefId),
    FOREIGN KEY (idWorker) REFERENCES Worker(idWorker)
);

CREATE TABLE IF NOT EXISTS Farmer (
	FarmerId INT NOT NULL AUTO_INCREMENT,
	FarmType VARCHAR(45) NOT NULL,
    idWorker INT unique,
    PRIMARY KEY (FarmerId),
    FOREIGN KEY (idWorker) REFERENCES Worker(idWorker)
);

CREATE TABLE IF NOT EXISTS Lawyer (
	LawyerId INT NOT NULL AUTO_INCREMENT,
	Firm VARCHAR(45) NOT NULL,
    idWorker INT unique,
    PRIMARY KEY (LawyerId),
    FOREIGN KEY (idWorker) REFERENCES Worker(idWorker)
);

CREATE TABLE IF NOT EXISTS Plumber (
	PlumberId INT NOT NULL AUTO_INCREMENT,
	License bool NOT NULL,
    idWorker INT unique,
    PRIMARY KEY (PlumberId),
    FOREIGN KEY (idWorker) REFERENCES Worker(idWorker)
);

CREATE TABLE IF NOT EXISTS Teacher (
	TeacherId INT NOT NULL AUTO_INCREMENT,
	Field VARCHAR(45) NOT NULL,
    idWorker INT unique,
    PRIMARY KEY (TeacherId),
    FOREIGN KEY (idWorker) REFERENCES Worker(idWorker)
);

CREATE TABLE IF NOT EXISTS Politician (
	PoliticianId INT NOT NULL AUTO_INCREMENT,
	Position VARCHAR(45) NOT NULL,
    idWorker INT unique,
    PRIMARY KEY (PoliticianId),
    FOREIGN KEY (idWorker) REFERENCES Worker(idWorker)
);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

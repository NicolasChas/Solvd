-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
Drop database Products;
CREATE DATABASE IF NOT EXISTS `Products` DEFAULT CHARACTER SET utf8mb4 ;
USE `Products` ;


CREATE TABLE IF NOT EXISTS Product (
  idProduct INT(11) NOT NULL,
  Name VARCHAR(45) NOT NULL,
  Price VARCHAR(45) NOT NULL,
  PRIMARY KEY (idProduct)
  );

CREATE TABLE Meat (
  idMeat INT NOT NULL,
  Cut VARCHAR(45) NULL,
  Brand VARCHAR(45) NULL,
  idProduct INT(11) UNIQUE,
  FOREIGN KEY (idProduct) REFERENCES Product(idProduct),
  PRIMARY KEY (idMeat)
  );
  
  CREATE TABLE Vegetables (
  idVegetable INT NOT NULL,
  Name VARCHAR(45) NULL,
  Brand VARCHAR(45) NULL,
  idProduct INT(11) UNIQUE,
  FOREIGN KEY (idProduct) REFERENCES Product(idProduct),
  PRIMARY KEY (idVegetable)
  );
  
  CREATE TABLE Fruits (
  idFruit INT NOT NULL,
  Name VARCHAR(45) NULL,
  Brand VARCHAR(45) NULL,
  idProduct INT(11) UNIQUE,
  FOREIGN KEY (idProduct) REFERENCES Product(idProduct),
  PRIMARY KEY (idFruit)
  );
  
  CREATE TABLE Dairy (
  idDairy INT NOT NULL,
  Name VARCHAR(45) NULL,
  Brand VARCHAR(45) NULL,
  idProduct INT(11) UNIQUE,
  FOREIGN KEY (idProduct) REFERENCES Product(idProduct),
  PRIMARY KEY (idDairy)
  );
  
  CREATE TABLE Bread (
  idBread INT NOT NULL,
  Name VARCHAR(45) NULL,
  Brand VARCHAR(45) NULL,
  idProduct INT(11) UNIQUE,
  FOREIGN KEY (idProduct) REFERENCES Product(idProduct),
  PRIMARY KEY (idBread)
  );
  
  CREATE TABLE Candy (
  idCandy INT NOT NULL,
  Name VARCHAR(45) NULL,
  Brand VARCHAR(45) NULL,
  idProduct INT(11) UNIQUE,
  FOREIGN KEY (idProduct) REFERENCES Product(idProduct),
  PRIMARY KEY (idCandy)
  );
  
  CREATE TABLE Chocolate (
  idChocolate INT NOT NULL,
  Name VARCHAR(45) NULL,
  Brand VARCHAR(45) NULL,
  idProduct INT(11) UNIQUE,
  FOREIGN KEY (idProduct) REFERENCES Product(idProduct),
  PRIMARY KEY (idChocolate)
  );
  
  CREATE TABLE Charcuterie (
  idCharcuterie INT NOT NULL,
  Name VARCHAR(45) NULL,
  Brand VARCHAR(45) NULL,
  idProduct INT(11) UNIQUE,
  FOREIGN KEY (idProduct) REFERENCES Product(idProduct),
  PRIMARY KEY (idCharcuterie)
  );

CREATE TABLE Snacks (
  idSnack INT NOT NULL,
  Name VARCHAR(45) NULL,
  Brand VARCHAR(45) NULL,
  idProduct INT(11) UNIQUE,
  FOREIGN KEY (idProduct) REFERENCES Product(idProduct),
  PRIMARY KEY (idSnack)
  );
  
  CREATE TABLE Drinks (
  idDrink INT NOT NULL,
  Name VARCHAR(45) NULL,
  Brand VARCHAR(45) NULL,
  idProduct INT(11) UNIQUE,
  FOREIGN KEY (idProduct) REFERENCES Product(idProduct),
  PRIMARY KEY (idDrink)
  );
  
  CREATE TABLE Cereals (
  idCereal INT NOT NULL,
  Name VARCHAR(45) NULL,
  Brand VARCHAR(45) NULL,
  idProduct INT(11) UNIQUE,
  FOREIGN KEY (idProduct) REFERENCES Product(idProduct),
  PRIMARY KEY (idCereal)
  );

Insert into Product Values
(1,"Meat",50),
(2,"Meat",80),
(3,"Vegetable",20),
(4,"Vegetable",15),
(5,"Fruit",18),
(6,"Fruit",12),
(7,"Dairy",20),
(8,"Dairy",43),
(9,"Bread",11),
(10,"Bread",15),
(11,"Candy",5),
(12,"Candy",10),
(13,"Chocolate",12),
(14,"Chocolate",17),
(15,"Charcuterie",18),
(16,"Charcuterie",21),
(17,"Snack",21),
(18,"Snack",13),
(19,"Drink",25),
(20,"Drink",15),
(21,"Cereal",14),
(22,"Cereal",19);

Insert into Meat Values
(1,"Milanesa","MeatStar",1),
(2,"Asado","Campo",2);

Insert into Vegetables Values
(1,"Onion","Fresher",3),
(2,"Eggplant","Debbier",4);

Insert into Fruits Values
(1,"Tomato","Fresher",5),
(2,"Banana","Chiquita Banana",6);

Insert into Dairy Values
(1,"Whole Milk","LaSerenisima",7),
(2,"Mozzarela","Finlandia",8);

Insert into Bread Values
(1,"Sliced Bread","Bimbo",9),
(2,"Baguette","Frimbo",10);

Insert into Candy Values
(1,"Flynn Paff","Georgalos",11),
(2,"Palito de la selva","Arcor",12);

Insert into Chocolate Values
(1,"Dark Chocolate","Aguila",13),
(2,"Dos Corazones","Fel Fort",14);

Insert into Charcuterie Values
(1,"Ham","MeatStar",15),
(2,"Salami","Campo",16);

Insert into Snacks Values
(1,"Onion and Cream Chips","Quento",17),
(2,"Cheese Tubes","Cheetos",18);

Insert into Drinks Values
(1,"Coca Cola","The Coca Cola Company",19),
(2,"Water","Smart Water",20);

Insert into Cereals Values
(1,"Zucaritas","Kellogs",21),
(2,"Nesquik","Nestle",22);



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

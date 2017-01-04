CREATE DATABASE HibernateXML;

CREATE TABLE tblPerson (
   id SERIAL PRIMARY KEY,

   firstName VARCHAR(20) NOT NULL,
   lastName VARCHAR(20) NOT NULL,
   middleName VARCHAR(20) NULL,
   suffix VARCHAR(20) NULL,
   title VARCHAR(20) NULL,
   
   birthday DATE NULL,
   gwa FLOAT NULL,
   dateHired DATE NULL,
   currentlyEmployed BOOLEAN NULL,
   gender VARCHAR(20) NULL
);

CREATE TABLE tblAddress (
   id SERIAL PRIMARY KEY,

   streetNumber INT NULL,
   barangay VARCHAR(20) NULL,
   city VARCHAR(20) NULL,
   zipcode INT NULL
);

CREATE TABLE tblContact (
   id SERIAL PRIMARY KEY,

   type VARCHAR(20) NOT NULL,
   value VARCHAR(30) NOT NULL
);
#sudo -u postgres psql hibernateannotation
#ex1stgl0bal
$psql \
-c "CREATE TABLE tblPerson (
   id SERIAL PRIMARY KEY NOT NULL,

   firstName   VARCHAR(20) NOT NULL,
   lastName    VARCHAR(20) NOT NULL,
   middleName  VARCHAR(20) NULL,
   suffix      VARCHAR(20) NULL,
   title       VARCHAR(20) NULL,
   
   birthday    DATE NULL,
   gwa         FLOAT NULL,
   dateHired   DATE NULL,
   currentlyEmployed BOOLEAN NULL,
   gender      VARCHAR(20) NULL,

   addressId   INT NOT NULL REFERENCES tblAddress(id);
);

CREATE TABLE tblAddress (
   id SERIAL PRIMARY KEY,

   streetNumber INT NULL,
   barangay    VARCHAR(20) NULL,
   city        VARCHAR(20) NULL,
   zipcode     INT NULL,

   --addressId   INT NOT NULL REFERENCES tblPerson(id)
);

CREATE TABLE tblContact (
   id SERIAL PRIMARY KEY,

   type  VARCHAR(20) NOT NULL,
   value VARCHAR(30) NOT NULL,

   personId INT NOT NULL REFERENCES tblPerson(id)
);

CREATE TABLE tblRole (
   id SERIAL PRIMARY KEY,

   value    VARCHAR(50) NOT NULL
);

CREATE TABLE tblPerson_Role (
   personId INT PRIMARY KEY NOT NULL REFERENCES tblPerson(id),
   roleId   INT PRIMARY KEY NOT NULL REFERENCES tblRole(id)
);"
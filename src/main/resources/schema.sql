DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS employeeHealthInsurance;


CREATE TABLE customer (
  custId INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  door VARCHAR(25) NOT NULL,
  address VARCHAR(100) NOT NULL
);

CREATE TABLE billdetails (
  ackNo INT IDENTITY(100, 1)  PRIMARY KEY,
  custId INT NOT NULL,
  date date NOT NULL,
  units INT NOT NULL,
  billamount DOUBLE not NUll
);
alter table billdetails add constraint FKcaf6ht0hfw93lwc13ny0sdmvo foreign key (custId) references customer(custId);
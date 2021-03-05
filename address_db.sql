CREATE DATABASE address_db;
USE address_db;
CREATE TABLE address (
id INT,
city VARCHAR(50) NOT NULL,
street VARCHAR(50) NOT NULL,
house_number INT NOT NULL,
building INT,
flat INT,
PRIMARY KEY(id));
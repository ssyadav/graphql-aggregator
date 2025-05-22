DROP TABLE IF EXISTS GX_USER;

CREATE TABLE GX_USER(
    id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    firstname VARCHAR(255),
    lastname VARCHAR(255),
    email VARCHAR(255),
    phone varchar(255),
    status varchar(50),
    age INT,
    city VARCHAR(50)
);

insert into GX_USER(firstname, lastname, email, phone, status, age, city)
values
    ('satya', 'yadav', 'ssyadav.in@gmail.com', '9620265604', 'active', 38, 'bangalore'),
    ('sam', 'sir', 'sam@gmail.com', '5467674637', 'active', 35, 'atlanta'),
    ('mike', 'dabad', 'mike@gmail.com', '1234567880', 'active', 35, 'houston'),
    ('jake', 'jake', 'jake@gmail.com', '9876543210', 'active', 45, 'miami'),
    ('john', 'john', 'jake@gmail.com', '9876543210', 'active', 45, 'las vegas');

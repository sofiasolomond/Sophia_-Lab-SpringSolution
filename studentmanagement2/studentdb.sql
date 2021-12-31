
drop database  studentdb;
create database studentdb;
use studentdb;

create table users (
user_id int primary key auto_increment,
user_name varchar(200),
user_password varchar(200)
);

create table roles (
role_id int primary key auto_increment,
role_name varchar(50)
);

create table users_roles
(
user_id int,
role_id int,
foreign key(user_id) references users(user_id),
foreign key(role_id) references roles(role_id)
);


create table student
(
student_id int primary key auto_increment,
first_Name varchar(50),
last_Name varchar(50),
course varchar(50),
country varchar(50)
);

insert into users(user_name, user_password) values ("admin", "$2a$12$jydFr09G7.Dfvhy/fPH4zuzTIxUnOsNepsBQcBF8qoAPhpfo2mEvy");
insert into users(user_name, user_password) values ("user", "$2a$12$aYITGWsqi0D61Y9MqLthHuhOELIFV/3pZ3QTwQYB./wnTxVob1Mqe");



insert into roles(role_name) values ("ADMIN");
insert into roles(role_name) values ("USER");

insert into users_roles(user_id, role_id) values(1,1);
insert into users_roles(user_id, role_id) values(2,2);
select * from users;
insert into student (first_Name, last_Name,course, country ) values ("Suresh", "Kumar", "B.Tech", "India");

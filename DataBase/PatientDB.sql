create database hospital;
use hospital;

create table patient(
id tinyint not null auto_increment primary key,
name varchar(50),
adress varchar(200),
id_disease tinyint

);

create table disease(
id tinyint not null auto_increment primary key,
name varchar(200)
);

alter table patient
add foreign key(id_disease) references disease(id);

create table doctor(
id tinyint not null auto_increment primary key,
name varchar(50),
username varchar(50),
password varchar(50)
);

insert into doctor values(null,'Popescu Marcel','popescumarcel','12345'),(null,'Ionecu Ana-Maria','ionescuana','12345');

insert into disease values(null,'Bronchitis'),(null,'Cold'),(null,'Acid Reflux'),(null,'Adison Disease'),
(null,'Alzheimer'),(null,'Laryngitis'),(null,'Cancer'),(null,'Dehydration'),(null,'Dementia');

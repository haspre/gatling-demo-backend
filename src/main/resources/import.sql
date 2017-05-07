drop table if exists unicorns;

create table unicorns (id int primary key auto_increment, firstName varchar, lastName varchar, gender varchar, age int);

insert into unicorns (firstName, lastName, gender, age) values ('pinky', 'pie', 'female', 120);
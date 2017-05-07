drop table if exists unicorns;

create table unicorns (id int primary key auto_increment, firstName varchar, lastName varchar, gender varchar, age int);

insert into unicorns (firstName, lastName, gender, age) values ('Pinkie', 'Pie', 'female', 120);
insert into unicorns (firstName, lastName, gender, age) values ('rainbow', 'dash', 'female', 49);
insert into unicorns (firstName, lastName, gender, age) values ('Bluebell', 'Plum', 'female', 222);
insert into unicorns (firstName, lastName, gender, age) values ('Fern', 'Nostrils', 'female', 99);
insert into unicorns (firstName, lastName, gender, age) values ('Daffodil', 'Sparkle', 'female', 78);

insert into unicorns (firstName, lastName, gender, age) values ('Champion', 'Stallion', 'male', 92);
insert into unicorns (firstName, lastName, gender, age) values ('Dapple', 'dash', 'male', 78);
insert into unicorns (firstName, lastName, gender, age) values ('Sage', 'Dainty', 'male', 412);
insert into unicorns (firstName, lastName, gender, age) values ('Chestnut', 'Dapple', 'male', 44);
insert into unicorns (firstName, lastName, gender, age) values ('Cherry', 'Pony', 'male', 25);
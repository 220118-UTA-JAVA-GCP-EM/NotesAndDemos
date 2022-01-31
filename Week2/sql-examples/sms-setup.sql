create table person(
	id serial primary key,
	type smallint not null,
	first varchar(50),
	last varchar(50),
	email varchar(100) unique,
	password varchar(50)
);

create table course(
	id serial primary key,
	subject varchar(50),
	number smallint,
	name varchar(50),
	teacher integer references person
)

create table course_topic( 
	course_id integer references course,
	topic varchar(75),
	primary key (course_id, topic)
)

create table course_student( 
	course_id integer references course,
	student_id integer references person,
	primary key (course_id, student_id)
)

create table assignment( 
	id serial primary key, 
	student integer references person,
	grade numeric(5,2) check (grade <= 100 and grade >= 0) ,
	done boolean,
	past_due boolean,
	due_date date
)


insert into person (type, first, last, email, password) values (0, 'Dorie', 'Paolotto', 'dpaolotto0@wunderground.com', 'UcUtfy');
insert into person (type, first, last, email, password) values (0, 'Raynard', 'Rowbottam', 'rrowbottam1@gizmodo.com', 'MwnBBA4');
insert into person (type, first, last, email, password) values (0, 'Chris', 'Hawkshaw', 'chawkshaw2@samsung.com', 'qptVqDt');
insert into person (type, first, last, email, password) values (1, 'Roberto', 'Barrowcliff', 'rbarrowcliff3@goo.ne.jp', 'hGipA6zw1');
insert into person (type, first, last, email, password) values (1, 'Klaus', 'Balf', 'kbalf4@shop-pro.jp', 'iQg91U6gAVEu');
insert into person (type, first, last, email, password) values (1, 'Gilligan', 'Guerro', 'gguerro5@flickr.com', 'v8bw8QT3uEhY');
insert into person (type, first, last, email, password) values (1, 'Marisa', 'Peach', 'mpeach6@biglobe.ne.jp', 'Pcf2PZwL');
insert into person (type, first, last, email, password) values (1, 'Cornie', 'Medlin', 'cmedlin7@posterous.com', 'qS7AoQXpC');
insert into person (type, first, last, email, password) values (1, 'Athena', 'Heinlein', 'aheinlein8@usatoday.com', 'BrWUkQYoIWT');
insert into person (type, first, last, email, password) values (1, 'Karyn', 'Cordelette', 'kcordelette9@mashable.com', 'ztrwxhf7uh');
insert into person (type, first, last, email, password) values (1, 'Kitti', 'Faulder', 'kfauldera@webeden.co.uk', 'UZ4tutFhOUhS');
insert into person (type, first, last, email, password) values (1, 'Marcile', 'Feehely', 'mfeehelyb@sbwire.com', 'r9pIrfETLOY');
insert into person (type, first, last, email, password) values (1, 'Daphne', 'Duffyn', 'dduffync@posterous.com', 'lngIgjBp');
insert into person (type, first, last, email, password) values (1, 'Rickie', 'Dorie', 'rdoried@mapquest.com', 'pfT7xmF1g');
insert into person (type, first, last, email, password) values (1, 'Lyle', 'Lambal', 'llambale@tiny.cc', '2ycMSB');
insert into person (type, first, last, email, password) values (1, 'Agace', 'McGuffie', 'amcguffief@discuz.net', 'CZIIetZd');
insert into person (type, first, last, email, password) values (1, 'Madison', 'Levitt', 'mlevittg@un.org', 'kyeeWI6Z');
insert into person (type, first, last, email, password) values (1, 'Bern', 'Ferronel', 'bferronelh@japanpost.jp', 'ilt3pUSrqlb2');
insert into person (type, first, last, email, password) values (1, 'Linus', 'Knudsen', 'lknudseni@usatoday.com', 'ocHAMyz');
insert into person (type, first, last, email, password) values (1, 'Ardeen', 'Eddie', 'aeddiej@netvibes.com', 'x9oXqcw3');

insert into course (subject, number, name, teacher) values ('HIST', 101, 'Modern Europe', 1);
insert into course (subject, number, name, teacher) values ('HIST', 201, 'US History I', 1);
insert into course (subject, number, name, teacher) values ('PHYS', 101, 'General Physics I', 2);

insert into course_topic (course_id, topic) values (1, 'Prehistory of Western civilization');
insert into course_topic (course_id, topic) values (1, 'History of ancient Greece'); 
insert into course_topic (course_id, topic) values (1, 'The Roman Empire'); 
insert into course_topic (course_id, topic) values (1, 'The Dark and Middle Ages'); 
insert into course_topic (course_id, topic) values (1, 'The Renaissance and Reformation'); 
insert into course_topic (course_id, topic) values (1, 'Colonialism'); 
insert into course_topic (course_id, topic) values (2, 'Colonialism'); 
insert into course_topic (course_id, topic) values (2, 'Revolutionary War'); 
insert into course_topic (course_id, topic) values (2, 'Westward Expansion'); 
insert into course_topic (course_id, topic) values (2, 'Civil War'); 
insert into course_topic (course_id, topic) values (2, 'Reconstruction Era'); 
insert into course_topic (course_id, topic) values (3, 'Newtonian kinematics');  
insert into course_topic (course_id, topic) values (3, 'Momentum');  
insert into course_topic (course_id, topic) values (3, 'Energy');  
insert into course_topic (course_id, topic) values (3, 'Heat'); 

insert into course_student (course_id, student_id) values (1,4);
insert into course_student (course_id, student_id) values (1,5);
insert into course_student (course_id, student_id) values (1,6);
insert into course_student (course_id, student_id) values (1,7);
insert into course_student (course_id, student_id) values (1,8);
insert into course_student (course_id, student_id) values (1,9);
insert into course_student (course_id, student_id) values (1,10);
insert into course_student (course_id, student_id) values (2,11);
insert into course_student (course_id, student_id) values (2,12);
insert into course_student (course_id, student_id) values (2,13);
insert into course_student (course_id, student_id) values (2,14);
insert into course_student (course_id, student_id) values (2,15);
insert into course_student (course_id, student_id) values (2,5);
insert into course_student (course_id, student_id) values (2,8);
insert into course_student (course_id, student_id) values (3,16);
insert into course_student (course_id, student_id) values (3,17);
insert into course_student (course_id, student_id) values (3,18);
insert into course_student (course_id, student_id) values (3,7);
insert into course_student (course_id, student_id) values (3,9);
insert into course_student (course_id, student_id) values (3,11);

insert into assignment (student, grade, done, past_due, due_date) values (4, 87, true, false, '2022-01-20');
insert into assignment (student, grade, done, past_due, due_date) values (5, 89, true, false, '2022-01-20');
insert into assignment (student, grade, done, past_due, due_date) values (6, null, false, true, '2022-01-20');
insert into assignment (student, grade, done, past_due, due_date) values (7, 76, true, false, '2022-01-20');
insert into assignment (student, grade, done, past_due, due_date) values (8, 97, true, false, '2022-01-20');
insert into assignment (student, grade, done, past_due, due_date) values (9, 62, true, false, '2022-01-20');
insert into assignment (student, grade, done, past_due, due_date) values (10, 75, true, false, '2022-01-20');
insert into assignment (student, grade, done, past_due, due_date) values (11, 100, true, false, '2022-01-30');
insert into assignment (student, grade, done, past_due, due_date) values (12, 95, true, false, '2022-01-30');
insert into assignment (student, grade, done, past_due, due_date) values (13, null, false, false, '2022-01-30');
insert into assignment (student, grade, done, past_due, due_date) values (14, null, false, false, '2022-01-30');
insert into assignment (student, grade, done, past_due, due_date) values (15, 85, true, false, '2022-01-30');
insert into assignment (student, grade, done, past_due, due_date) values (5, null, false, false, '2022-01-30');
insert into assignment (student, grade, done, past_due, due_date) values (8, 75, true, false, '2022-01-30');

-- using TCL to explore transactions
begin;
insert into course (subject, number, name, teacher) values ('PHYS', 201, 'General Relativity', 2);
commit;



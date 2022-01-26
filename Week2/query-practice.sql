select * 
from person;

select * 
from person 
where type = 0;

select * 
from person 
where type = 0
order by last desc;

select first, last 
from person
order by first;

select *
from "assignment" a
where a.grade > 90;

select *
from "assignment" a 
where grade is not null
order by grade desc;

select * 
from "assignment" a;

-- I want to find pending future assignments
select *
from "assignment" a 
where due_date > now();

select *
from "assignment" a 
where due_date > now() and done = false;

select concat(concat(first, ' '), last)
from person p 
where "type" = 1;

select avg("grade")
from "assignment" a
where "student" = 8;

select avg(grade), due_date
from "assignment" a
group by due_date;

select grade, due_date 
from "assignment" a;

select max(grade)
from "assignment" a;

select * 
from "assignment" a 
where grade = (
	select max(grade)
	from "assignment" a
);

update "assignment" 
set grade = 100, done = true
where id = 10;

insert into "assignment" (grade, done, past_due, due_date) values (95, true, false, '2022-01-30;');

-- inner join 
select *
from "assignment" a 
join person p 
on a.student = p.id;

-- full outer join
select first, last, a.id "assignment id", grade
from "assignment" a 
full join person p 
on a.student = p.id;

-- left join 
select first, last, a.id "assignment id", grade
from "assignment" a 
left join person p 
on a.student = p.id;

-- right join 
select first, last, a.id "assignment id", grade
from "assignment" a 
right join person p 
on a.student = p.id;

select first, last, a.id "assignment id", grade
from person p 
left join "assignment" a 
on a.student = p.id;

select p.first, p.last, c.name
from person p
left join course c 
on p.id = c.teacher
where type = 0;

--select p.first, p.last, c.name
select * 
from person p 
join course_student cs 
on p.id = cs.student_id
join course c
on cs.course_id = c.id;


select p.first, p.last, c.name
from person p 
join course_student cs 
on p.id = cs.student_id
join course c
on cs.course_id = c.id;



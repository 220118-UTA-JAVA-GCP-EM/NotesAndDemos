-- using DDL to define a product table 
create table product(
	id serial primary key,
	name varchar(50) not null,
	price numeric(5,2) check (price > 0)
)

-- using DML to insert data into the product table 
insert into product (name, price) values ('toaster',25.00);
insert into product (name, price) values ('bike',120.00);

-- using DQL to request data from our db
select *
from product;

select name
from product;

-- using DDL again to create a department table
create table department(
	id serial primary key,
	name varchar(50) not null
)

-- using DML again to populate our department table
insert into department (name) values ('kitchen appliances');
insert into department (name) values ('sporting goods');
insert into department (name) values ('produce');

-- using DDL to alter the table 
alter table product add column department integer references department(id);

-- using DML to update records and add departments
update product
set department = 2
where id = 2;

insert into product (name, price, department) values ('football',15.00, 2);





drop table if exists product;
create table if not exists product(
productId varchar(10) not null,
pname varchar(20),
unitPrice integer,
descriptions text,
manufacturer varchar(20),
category varchar(20),
unitsInStock long,
conditions varchar(20),
filename varchar(20),
primary key (productId)
);

insert into product values(
'P1234',
'iPhone 6s',
800000,
'4.7-inch, 1334X750 Renina HD display, 8-megapixel iSight Camera',
'Apple',
'Smart Phone',
1000,
'New',
'P1234.png');
insert into product values("P1235", "LG PC ^^ ", 1700000,"13.3-inch, IPS LED display, 5rd Generation Intel Core processors","Notebook","LG",1000,"Refurbished","P1235.png");
insert into product values("P1236", "Galaxy Tab S", 900000,"212.8*125.6*6.6mm,  Super AMOLED display, Octa-Core processor","Tablet","Samsung",1000,"Old","P1236.png");



commit;
select * from product;



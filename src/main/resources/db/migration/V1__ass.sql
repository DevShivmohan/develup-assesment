-- create table
create table assessment(
barcode long not null,
item_desc varchar(60) not null,
group_name varchar(50) not null,
sizee varchar(30) not null,
price double not null,
qty double not null,
profit double not null,
remain_qty double not null
);

-- for search optimization
--create index barcode_index on assessment (barcode,item_desc,group_name,sizee,price,qty,profit,remain_qty);




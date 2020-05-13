use testdb;

-- create table book
create table book(
	id int(6) unsigned primary key not null AUTO_INCREMENT,
    name nvarchar(250) not null,
	description text null,
    price varchar(100) not null,
    star int(1) null,
	author_id int(6) not null,
    category_id int(6) not null,
	image varchar(200) not null,
    created_date datetime null
);

-- create table categorys
create table categorys(
	id int(6) unsigned primary key not null AUTO_INCREMENT,
    name nvarchar(250) not null
);

-- create table author
create table author(
	id int(6) unsigned primary key not null AUTO_INCREMENT,
    name nvarchar(250) not null,
    birthday datetime null
);

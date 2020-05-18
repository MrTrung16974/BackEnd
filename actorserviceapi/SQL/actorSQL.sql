-- create database
CREATE SCHEMA `actordb` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
use actordb;

-- create table book
create table api(
	id int(6) unsigned primary key not null AUTO_INCREMENT,
    name nvarchar(250) not null,
	age int(6) not null,
    country varchar(100) not null
);
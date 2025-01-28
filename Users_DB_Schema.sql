create database testimonialsdb

use testimonialsdb;

create table users (
	userid int,
    username varchar(255) not null,
    password varchar(255) not null,
    email varchar(255) not null,
    domain varchar(255) not null,
    
    constraint pk_userid primary key(userid)
    );

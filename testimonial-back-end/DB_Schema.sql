create database testimonialsdb;

use testimonialsdb;

create table users (
	userid int auto_increment,
    username varchar(255) not null,
    password varchar(255) not null,
    email varchar(255) not null,
    domain varchar(255) not null,
    
    constraint pk_userid primary key(userid)
    );

create table testimonials
(
	testimonialid int auto_increment,
    rating int default(0),
    customername varchar(255) not null,
    picture blob,
    description varchar(255) not null,
    customerabout varchar(255) not null,
    createdat datetime not null,
    isvisible boolean,
	
    constraint pk_testimonial_id primary key (testimonialid)
    );
    
create table customers
( 
	testimonialid int,
    customerid int auto_increment,
    password varchar(255) not null,
    customeremail varchar(255) not null,
    description text not null,
    
    constraint fk_testimonial_id foreign key (testimonialid) references testimonials (testimonialid),
    constraint pk_customer_id primary key (customerid)
);
    
    

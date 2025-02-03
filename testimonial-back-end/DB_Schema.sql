CREATE DATABASE testimonialsdb;

USE testimonialsdb;

CREATE TABLE users (
	userid INT AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    domain VARCHAR(255) NOT NULL,
    
    CONSTRAINT pk_userid PRIMARY KEY(userid)
    );
    
    CREATE TABLE customers
( 
	customerid INT AUTO_INCREMENT,
	customername VARCHAR(255) NOT NULL,
    customeremail VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    
    CONSTRAINT pk_customer_id PRIMARY KEY (customerid)
);
   

CREATE TABLE testimonials
(
	testimonialid INT AUTO_INCREMENT,
    rating INT DEFAULT 0,
	customerid INT,
    
    description VARCHAR(255) NOT NULL,
    customerabout VARCHAR(255) NOT NULL,
    createdat DATETIME NOT NULL,
    isvisible BOOL,
	
    CONSTRAINT pk_testimonial_id PRIMARY KEY (testimonialid),
    CONSTRAINT fk_customer_id FOREIGN KEY (customerid) REFERENCES customers (customerid) ON DELETE CASCADE
    );
	
    

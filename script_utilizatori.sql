
DROP TABLE IF EXISTS sales.users; 
DROP TABLE IF EXISTS sales.authorities; 

CREATE TABLE sales.users (
	username varchar(50),
	password char(60),
	enabled tinyint(1)	,
    PRIMARY KEY(username)
);

CREATE TABLE sales.authorities(
	username varchar(50),
	authority	varchar(50),
    FOREIGN KEY (username) REFERENCES sales.users(username)
);

create unique index ix_auth_username on sales.authorities (username,authority);

insert into sales.users values('userHello','$2a$10$/YvXuJlS3PfHKUts3YKWHO/XsXduM2iEbLDInKbMohgVgs/Fs7H9G',1);
insert into sales.users values('userCustomer','$2a$10$/YvXuJlS3PfHKUts3YKWHO/XsXduM2iEbLDInKbMohgVgs/Fs7H9G',1);

insert into sales.authorities values('userHello','HELLO');
insert into sales.authorities values('userCustomer','HELLO');
insert into sales.authorities values('userCustomer','CUSTOMER');


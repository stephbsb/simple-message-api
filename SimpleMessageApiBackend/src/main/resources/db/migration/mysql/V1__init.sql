create table messages(
id serial,
name varchar(80),
email varchar(50),
message varchar(500),
status varchar(20),
created date,
response_date date,
primary key (id));


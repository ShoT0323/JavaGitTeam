create table lockeruser (
 lockerno serial,
 name varchar(32) not null,
 mail varchar(256) not null unique,
 salt varchar(32) not null,
 password varchar(64) not null,
 created_at timestamp,
 primary key(lockerno)
);
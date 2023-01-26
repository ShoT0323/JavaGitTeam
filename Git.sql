create table lockeruser (
 userid serial,
 name varchar(32) not null,
 mail varchar(256) not null unique,
 salt varchar(32) not null,
 password varchar(64) not null,
 created_at timestamp,
 primary key(userid)
);

create table locker (
 lockerno serial,
 stuff1 varchar(128),
 stuff2 varchar(128),
 stuff3 varchar(128),
 open  integer,
 primary key(lockerno)
);
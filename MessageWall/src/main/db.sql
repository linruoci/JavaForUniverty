


create database MessageWall;

use MessageWall;

drop table if exists message;

create table message(
    `from` varchar(100),
    `to` varchar(100),
    message varchar(100)
);

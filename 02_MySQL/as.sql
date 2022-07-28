show databases;

create database mydb;

use mydb;

show tables;


select * from member;

insert into member(userid, userpwd, username, tel) 
values('goguma', '1234','홍길동','010-1234-1234');

select * from board;
desc board;

use mydb;

select no, subject, userid, hit, date_format(writedate, '%m-$d %H:%i') writedate from board order by no desc;

insert into member(userid, userpwd, username, tel) 
values('sunsin', '1234','이순신','010-1234-1235');





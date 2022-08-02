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

insert into member(userid, userpwd, username, tel) 
values('sunsn', '1234','이신','010-1234-1235');


use mydb;
select * from zipcode;
select zipcode, sido, doro, buildnum1,buildnum2, buildname, dong, num1, num2 from zipcode
where doro like "%마음로%" order by zipcode;

delete from member where userid = 'root1234';



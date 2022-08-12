show databases;

create database mydb;

use mydb;
use travel;

show tables;

desc reply_board;
select * from reply_board;

desc data;

select * from post;
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

select no, subject from board order by no desc;
-- limit
select no, subject, userid, hit, writedate
from board
order by no desc
limit 5;

delete from member where userid = 'root1234';

select * from data;

select a.no, a.subject, a.userid, a.hit, a.writedate, b.reply_count
from
(select no, subject, userid, hit, writedate from board where subject like '%다%'
order by no desc limit 5 offset 0) a left outer join
(select no, count(no) reply_count from reply_board group by no) b
on a.no=b.no;


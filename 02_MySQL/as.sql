show databases;

create database mydb;

use mysql;
use mydb;
use travel;
use genie;

show tables;
select * from user;
select * from administer;
select * from seller;

select count(U.user_id) cnt from user U 
join seller S on U.user_id=S.seller_id
union All 
select count(S.seller_id) cnt from seller S 
join administer A on S.seller_id = A.administer_code;

select sum(cnt) cnt from 
(select count(U.user_id) cnt from user U 
join seller S on U.user_id=S.seller_id
union All 
select count(U.user_id) cnt from user U 
join administer A on U.user_id = A.administer_code) k;

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

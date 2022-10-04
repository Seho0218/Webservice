show databases;

create database mydb;

use mysql;
use mydb;
use travel;
use genie;

select  * from address where genie_id='user';
show tables;
select * from user;
select * from account;
select * from administer;
select * from seller;
select * from address;
select * from product;
select * from product where genie_id='seller';
select * from cart;
select * from tag;
select * from myorder;
ALTER TABLE cart MODIFY cart_num INT NOT NULL AUTO_INCREMENT;
select 
            cart_num,
            genie_id,
            product_id,
            cart_price,
            cart_qty,
            cart_writedate 
        from cart 
        where genie_id='user';
ALTER table cart MODIFY cart_num INT NOT NULL AUTO_INCREMENT;

select product_id, 
            genie_id,
            product_category,
            product_tag,
            product_name,
            product_price,
            product_info,
            product_stock,
            product_quantity,
            product_hit,
            product_like,
            product_writedate,
            product_image1,
            product_image2,
            product_image3,
            product_mbti
from product 
where product_category like '%기념일%' and product_tag like '%배우자%';

select * from product where product_price between 0 and 1000;
SELECT 1 result 
    	FROM DUAL 
    	WHERE EXISTS(
        SELECT 1 
        FROM user 
        WHERE genie_id='user' AND user_email='ghdtpgh8913@naver.com' 
    );
    
select product_tag from product;

insert into user (user_num,genie_id)
(
 select a.genie_num,a.genie_id
 from user u left outer join account a  
 on a.genie_id = u.genie_id
);

insert into address 
select user_name, user_tel, user_zipcode, user_addr, user_detailaddr 
from dual 
where exists(select * from address where user_id='user');

select u.genie_id, u.user_name 
		from user u 
		join account a 
		on a.genie_id=u.genie_id 
		where a.member_type='1' and a.genie_id='user' and genie_pwd=sha2('123',256) and a.withdrawal=1;

	select u.genie_id, u.user_name 
			from account a
				join user u
					on a.genie_id=u.genie_id
		where a.genie_id='user' and a.genie_pwd='123';

select s.genie_id, 
		seller_tel, 
		seller_email, 
		seller_reg_no, 
		company_name, 
		ceo_name, 
		seller_website
	from seller s
    join product p
    on s.genie_id=p.genie_id
where p.product_id='1';


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

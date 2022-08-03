use multi;

select * from emp;

show databases;

-- 테이블 목록alter
show tables;

-- 테이블 생성
create table member(
	mem_id integer primary key, -- 자료가 있다.
    username varchar(30) not null, -- 자료가 무조건 있어야된다.
    depart varchar(30) null,-- 없어도 된다.
    position varchar(20), -- 자릿수가 20
    tel varchar(15) not null,
    writedate datetime default now()
    );
    
    show tables;
    
    select * from member;
    
    -- 테이블 구조
    desc member;
    
    select * from emp;
    -- emp테이블과 같은 테이블 만들기
    create table emp2 as 
    select * from emp;
    
    show tables;
    select * from emp2;
    
    -- 사원번호, 사원명, 급여를 이용하여 테이블 생성하기
    create table emp3
    as
    select empno, ename, sal from emp;
    select * from emp3;
    
    -- manager 업무를 하는 사원을 이용하여 테이블 생성하기
    create table emp4
    as
    select * from emp where job = 'manager';
    select * from emp4;
    
    -- 테이블 구조만으로 테이블 생성하기
    create table emp5
    as
    select * from emp where 1=2; -- 선택할 레코드가 없다.
    
    select * from emp5; -- 레코드는 없고 필드만 있다.
    
    show tables;
    select * from emp2;
    desc emp2;
    
    insert into emp2(empno,ename,deptno,job,sal,comm,mgr,hiredate) -- 테이블( 필드명 나열(순서 없음) )
    values(7777,'홍길동',40,'사무직',5500,100,7788,now()); -- 순서있음
    
    insert into emp2(empno,ename,sal) values(8888,'이순신',7000);
    select * from emp2;
    
    insert into emp2(ename,sal) values('r김길동',2000); -- 오류 이유 2시 6 기존에 등록된 정보 변경 where
    -- 레코드 수정
    -- 사원번호가 7777인 사원의 급여를 4000으로 변경
    set sql_safe_updates=0;
    update emp2 set sal=4000 where empno=7777;
    
    update emp2 set sal = sal*1.1;
    
    -- delete : 레코드 삭제
    
    delete from emp2 where ename ='이순신';
    delete from emp2 where deptno = '10';
    
    select * from emp2;
    
    desc member;
    select * from member;
    insert into member(mem_id,username,depart,position,tel)
    values(1111,'고구마','기획부','사원','01-234-5678');
    
    insert into member(mem_id,username,tel) values(2222,'이순신','02-5678-7777');
    select * from member;
    
    show tables;
    drop table emp2;
    
    select * from member;
    -- 이메일 추가
    alter table member add email varchar(50); -- 2시 40분 설명 not null  안됌.
    
    select mem_id,username,tel,email,depart,position from member; -- 순서 병
-- 필드 수정
alter table member modify depart varchar(50);

-- 필드명 수정
alter table member change tel phone varchar(20); -- tel을 phone으로

-- 필드삭제

alter table member drop column position; -- 데이터가 있으면 같이 삭제

show tables;

use multi;
show tables;

show databases;
use multi;
desc memberTbl;
    
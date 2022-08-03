use multi;
select * from emp;

select job from emp where empno= 7369;

select empno, ename from emp where job = 'clerk';

select empno, ename, sal from emp
where job = (select job from emp where empno = 7369);

select * from emp
where job = (select job from emp where ename = 'adams')
or
deptno = (select deptno from emp where ename = 'scott');

-- 평균 급여보다 많이 받는 사원은?

select * from emp where sal > (select avg(sal) from emp);

-- ford와 같은 부서의 사원중 평균 급여보다 적게 받는 사원은?

select * from emp where deptno = (select deptno from emp where ename = 'ford')
and sal < (select avg(sal) from emp);

-- 다중행 서브쿼리
select* from emp where sal in (select max(sal) from emp group by deptno);

-- 담당 업무별 급여의 합계와 급여의 평균을 구하되 전체 사원의 평균보다 
-- 많이 받는 담당업무를 선택하라.

select job, sum(sal) 급여합계, avg(sal) 급여평균
from emp group by job having avg(sal)>(select avg(sal) from emp);

select empno, ename, job, sal from emp
where sal in (select max(sal) from emp group by job);

-- any 연산자 : 1개의 조건에 만족하면 선택

select * from emp where deptno!=20 and sal < any(select sal from emp where job = 'salesman');

-- all : 모든 값이 만족

select * from emp where deptno!=20 and sal > all(select sal from emp where job = 'salesman');

-- 별칭

select empno, ename, sal from emp e -- 중요
where exists(select empno from emp where e.empno = mgr);

-- 다중 열 서브쿼리
select empno, ename, sal, deptno, comm from emp

where (sal, deptno) in (select sal, deptno from emp where deptno = 30 and comm is not null);
						-- 순서
       
-- 문제) 업무별로 최소급여를 받는 사원의 사번, 이름, 업부, 부서번호를 출력하시오. 단, 업무별로 정렬하세요.

select job, min(sal) from emp group by job;

select empno, ename, job, deptno from emp 
where (job, sal) in (select job, min(sal) from emp group by job) order by job; 

-- from 절에 서브쿼리alter

select empno, ename, job, sal from
(select empno, ename, job, sal comm, hiredate from emp where deptno =10 or deptno = 20) a; -- 하나의 테이블


-- 제약조건

show tables;

select * from emp;
select * from dept;
select * from salgrade;

desc emp;
desc dept;
desc salgrade;

show databases;
use information_schema;
show tables;

-- 제약조건 확인하기
select * from information_schema.table_constraints where table_schema='multi';

use multi;
insert into emp(empno) values(7788);
select * from table_constraints where constraint_schema='multi'; 

-- emp 테이블에 empno를 primarykey 설정
alter table emp add primary key(empno);

delete from emp where empno=7788 and ename is null;

insert into emp(empno,ename) values(7788,'홍길동');
-- dept -> deptno
alter table dept add primary key(deptno);
-- salgrade -> grade
alter table salgrade add primary key(grade);


-- 1시 이후


select * from dept;

-- unique 제약조건						-- 제약조건 이름
alter table dept add constraint uq_dept_dname unique(dname);

insert into dept(deptno,dname,loc) values (50,'기획부','서울 서초구');
insert into dept(deptno,dname,loc) values (60,'기획부','서울 서초구'); -- 오류

update emp set sal = 5000 where ename = 'king';

-- check : 800~8000
alter table emp add constraint ck_emp_sal check(sal >=800 and sal <=8000);
insert into emp(empno,ename,sal) values(8888,'홍길동',7500);

alter table dept add constraint ck_dept_lok check(loc in('NEW YORK','DALLAS','CHICAGO','BOSTON','서울 서초구','서울 강남구'));
insert into dept values(60,'인사부','영등포구'); -- 제약조건 위배 '영등포구'

update emp set deptno= 40 where empno = 7788; -- deptno 추가
-- foreign key no action 변화 x 다른 테이블 정보를 참조하여 데이터 무결성을 처리한다.

alter table emp add constraint fK_emp_deptno
foreign key(deptno) references dept(deptno) on delete cascade on update cascade;
		-- 참조필드				-- 참되는 필드
        
        
-- dept의 부서코드 40 -> 100
update dept set deptno = 100 where deptno=40;
delete from dept where deptno=100;
insert into emp (empno, ename, deptno) values (5555,'이순신',200);

select * from emp; -- where  groupby having orderby
-- 제약조건 확인하기

delete from information_schema.table_constraints where constraint_name = 'ck_dept_loc';
-- 제약조건 삭제
alter table dept drop check ck_dept_loc;

show tables;
select * from member;
select * from membertbl;

desc member;
alter table member add primary key(mem_id);
use multi;
show databases;

show tables;
select *from member;
select mem_id, username, depart, tel, email from member order by mem_id;
select mem_id, username, depart, tel, email from member where username='' order by mem_id;

select * from information_schema.table_constraints;

-- 5시부터 다시 좀 듣기 
-- emp테이블의 사원명, 부서명(dname), 담당업무, 급여를 선택하라.
select ename, dname, job, sal, emp.deptno from emp join dept on emp.deptno=dept.deptno;

-- 양쪽테이블에 둘다 있으면 테이블명을 지정해줘라

select e.ename, d.dname, job, sal, e.deptno from emp e join dept d on e.deptno=d.deptno;

select e.ename, d.dname from emp e, dept d where e. deptno = d.deptno;
select e.ename, d.dname from emp e join dept d on e.deptno=d.deptno;

-- 사원번호, 사원명, 부서명을 선택하는데 담당업무가 manager인 사원을 선택하라.

select e.empno,e.ename,d.dname
from emp e join dept d on e.deptno = d.deptno
where e.job='manager';

select e.empno, e.ename, d.dname, e.job
from (select * from emp where job = 'manager') e join dept d
on e.deptno=d.deptno;

-- 부서별 급여합계, 급여의 평균을 구하되
-- 부서명, 부서코드, 급여합계, 급여평균을 선택하라.
select dname, a.deptno, sal_tot, sal_avg from
(select deptno, sum(sal) sal_tot, avg(sal) sal_avg from emp group by deptno) a
join dept d on a.deptno=d.deptno;



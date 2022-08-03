use multi;

show tables;
select * from emp;
select * from dept;
select * from salgrade;

-- 사원번호, 사원명,급여, 호봉을 선택하라.
select e.empno, e.ename, e.sal, s.grade
from emp e join salgrade s on e.sal between s.losal and s.hisal;

-- q) 사원명, 담당업무, 급여, 호봉을 선택하되
-- 부서코드가 20, 30부서만선택하라.

select e.ename, e.job, e.sal, e.deptno 
from emp e join salgrade s on e.sal between s.losal and s.hisal
where e.deptno in(20,30);

-- 2개 이상의 테이블 조인
select e.ename, d.dname, e.sal, s.grade, e.deptno
from emp e join dept d on e.deptno=d.deptno
join salgrade s on e.sal between s.losal and s.hisal;

-- self 조인
-- 사원번호, 사원명, 사원급여, 매니저이름, 매니저급여
select e1.empno, e1.ename, e1.sal, e2.ename mgr_ename, e2.sal mgr_sal
from emp e1 join emp e2 on e1.mgr= e2.empno;

-- outer join

select e.empno, e.ename, d.dname,d.deptno
from emp e right outer join dept d on e. deptno=d.deptno;

select e.empno, e.ename, e.sal, d.deptno, d.dname, d.loc
from dept d left outer join emp e on d.deptno=e.deptno;

-- king을 포함한 사원의 정보를 선택하라.
-- 사원명, 담당업무, 급여, 관리자명, 관리자급여 필드 선택.

select e1.ename, e1.job, e1.sal,e2.ename, e2.sal from
emp e1 join emp e2 on e1.mgr=e2.empno;


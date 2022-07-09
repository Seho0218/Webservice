-- 1. emp테이블에서 모든 사원에 대한 이름, 부서번호, 부서명을 출력하는 문장을 작성하세요. (부서번호순으로 오름차순 정렬하라.) 10시 40분 부터

select e.name, e.deptno, d.dname from emp e join dept d
on e.deptno = d.deptno order by e.deptno asc;

-- 2. emp테이블에서 NEW YORK에서 근무하고 있는 사원에 대하여 이름, 업무, 급여, 부서명을 출력하는 SELECT문을 작성하세요.

select e.name, e.job, e.sal, d.dname
from emp e join dept d on e.deptno=d.deptno
where d.loc = 'new york';

-- 3. EMP테이블에서 보너스를 받는 사원에 대하여 이름, 부서명, 위치를 출력하는 SELECT문을 작성하세요.

select e.ename, d.dname, d.loc from emp e join dept d on e.deptno = d.deptno
where comm>0;
-- 4. EMP테이블에서 이름 중 L자가 있는 사원에 대해 이름, 업무, 부서명, 위치를 출력하는 문장을 작성하세요.

select e.ename, e.job, d.dname, d.loc from emp e join dept d on e.deptno = d.deptno
where e.ename like '%L%';

-- 5번 11시부터
select e.ename, e.empno, e2.ename mgr, e2.empno mgr_empno
from emp e left outer join emp e2 on e.mgr = e2.empno;
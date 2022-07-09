use start;

select * from emp;
-- 사원명, 담당업무, 급여를 선택하라.
select ename, job, sal from emp;

-- where 절 : 조건절 -> 레코드에 대한 조건식
select ename as 사원명, job 담당업무, sal 급여 from emp; -- 별칭
-- 급여가 3000불 이상인 사원을 선택하라.

select * from emp where sal>=3000;
-- empno : 사원번호 ,ename : 사원명, job: 담당업무, mgr: 상급자 사원번호,
-- hiredate: 입사일, sal : 급여, comm :보너스, deptno: 부서코드

-- 담당 업부가 Manager이거나 급여가 3000불 이상인 사원을 선택하라.

select * from emp where sal>=3000 or job='manager';
select * from emp where empno not between 7500 and 7800;
select empno, ename from emp where sal >=3000;

-- 급여가 2000에서 3000불 사이인 사원을 선택하라;
select * from emp where sal>=2000 and sal<=3000;

-- between : 범위를 지정할때
select * from emp where empno between 7500 and 7800;

-- in 연산자 : or을 뜻한다.
-- 사원번호 7369, 7654,7788인 사원을 선택하라.

select * from emp where empno = 7369 or empno=7654 or empno= 7788;
select * from emp where empno = (7369,7654,7788);
-- like 연산자 : 문자열 내에 특정데이터가 포함된 정보를 선택할때
-- %: 여러문자 , _ : 한문자
-- 사원명이 A로 시작하는 사원을 선택하라.

select *from emp;

select * from emp where ename like 'A%';
select * from emp where ename like '%N' ;
select * from emp where ename like '%a%';
select * from emp where ename like '_A%';

-- 이름에 d가 포함된 사원을 제외한 나머지 사원을 선택하라.
select * from emp where ename NOT like '%d%';

-- 5월에 입사한 사원은?

select *from emp where hiredeate like '____05%';



-- is null
select * from emp where comm >0;
-- comm null인 사원을 선택하라.alter
select *from emp where comm = null;  -- 문자가 null인 것을 가져옴

select *from emp where comm is null;-- 진짜 null을 가져옴

select * from emp where mgr is not null;

-- order by 레코드를 오름차순 또는 내림차순으로 정렬alter
-- 사워명을 오름차순으로 정렬

select *from emp order by ename desc;
-- 정렬기준이 1개 이상일때
-- 부서별 급여순(내림차순)으로 정렬

select deptno, sal, ename from emp order by deptno, sal desc;

select comm, ifnull(comm,1)*100 com2 from emp;


-- 1. emp 테이블의 레코드 중 담당업무가 manager이거나 salesman인 사원의 
-- 사원명, 입사일, 급여를 선택하라.

select ename, hiredate ,sal from emp where job in ('manager','salesman');
select ename, hiredate ,sal from emp where job = 'manager'or job ='salesman';
-- 2. emp 테이블의 레코드 중 사원번호가 7500번 이상인 사원중 급여가 
-- 2000~3000사이인 사원을 선택하라.
-- 단) 사원명을 오름차 순으로 정렬하라.

select * from emp where EMPNO >=7500 and SAL BETWEEN 2000 AND 3000 order by ename asc;

-- 3. 부서코드가 20, 30 인 사원의 사원번호, 입사일 , 급여를 선택하되 
-- 	입사일을 내림차순으로 정렬하여 선택하라.

select ENAME, HIREDATE, SAL from emp where deptno between 20 and 30 order by hiredate desc;
											-- in(20,30)	
-- 4. 사원명에 'm'이 포함되었거나 'o'가 포함된 사원중 보너스를 받는 사원은?

select * from emp where (ename like '%m%' or '%o%') and comm > 0 ; -- 순서가 있음

-- 5. 12월에 입사한 사원중 20부서의 사원은?

select * from emp where hiredate like '_____12%' and deptno = 20;

-- 6 1982년에 입사한 사원을 이름은 오름차순, 급여는 내림차순으로 정렬하여 선택하라.

select * from emp where hiredate like '1982%' order by ename asc, sal desc ;

-- 7. 사원번호, 사원명, 급여, 보너스, 지급액을 선택하라.(중요)
-- 보너스는 NULL은 0으로, 지금액은 급여+보너스

select EMPNO 사원번호, ENAME 사원명, SAL 급여, ifnull(comm,0) 보너스, sal + ifnull(comm,0) 지급액 -- 보너스를 안받으면 지급액도 없는 경우가 잇음
from emp;

-- 8. 보너스를 받지 않는 사원을 사원명 순으로 선택하라

select * from emp where comm is null or comm<=0 order by ENAME ;

-- 9. 담담업무가 Manager가 아닌 사원을 급여순으로 선택하라.

select * from emp where job not like 'manager' order by sal desc; -- not in은 or가 여러개일때
							-- not in('manager')
-- 10. 사원명, 담담업무, 급여, 부서코드를 선택하되 Salesman을 제외하고 선택하라

select ename, job, sal, deptno from emp where job NOT LIKE 'Salesman';

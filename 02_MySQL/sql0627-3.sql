use mysql;

select abs(63);  -- select abs(63); from dual  오라클 가상테이블
select ceil(78.1), floor(19.9);
select mod (10,3), 10%3;
select floor(rand()*6)+5;
select pow(5,3),sqrt(16);
select round(253.2654,2), round(253.845,-2);
select ename, insert(ename,2,2,'*') ename2 from emp order by ename;
select ename, reverse(ename) from emp;
select ename, left(ename,2), right(ename,2) from emp;
select ename, lcase(ename), ucase('abcd') from emp;
select ename, lpad(ename,char_length(ename)+1,'*') from emp;
select concat(trim('    abe    '),'y');
select substring_index('ghdtpgh8913@gmail.com','@',1),substring_index('ghdtpgh8913@gmail.com','@',-1);

select adddate(now(),interval 30 day), subdate(now(),interval 30 day);

select count(ifnull(comm,0)) 사원수, max(sal) 최대값, min(sal) 최소값 from emp;

select count(empno) from emp;

-- 그룹함수

select job 직업, count(empno), sum(sal), avg(sal) from emp group by job;
select job, count(empno), max(sal),min(sal) from emp group by job having count(empno) >=3;

-- 급여가 2500불 이상인 사원을 부서별 급여의 합계, 평균을 구하되 부서별 급여의 평균을 2800불 이상인 부서만 선택하라.

select deptno, sum(sal), avg(sal) from emp where sal>= 2500 group by deptno having avg(sal)>=2800 order by deptno desc;

-- 1981년도에 입사한 사원의 당당업무별 사원수, 급여의 평균, 최고급여, 최저급여를 구하여라.
-- 단, 급여의 평균이 2000불 이상인 업무만 선택하라.

select job, count(empno), avg(sal), max(sal), min(sal) from emp where hiredate like '1981%' group by job having sal>=2000;
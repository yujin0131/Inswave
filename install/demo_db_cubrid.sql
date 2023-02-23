   
CREATE TABLE dept (
	deptno INTEGER NOT NULL,
	dname CHARACTER VARYING (255),
	loc CHARACTER VARYING (4096),
	CONSTRAINT pk PRIMARY KEY(deptno)
)
COLLATE euckr_bin
REUSE_OID;

CREATE TABLE emp (
	empno INTEGER NOT NULL,
	ename CHARACTER VARYING (255),
	job CHARACTER VARYING (255),
	mgr INTEGER,
	hiredate DATE,
	sal DOUBLE,
	comm DOUBLE,
	deptno INTEGER,
	account CLOB,
	CONSTRAINT pk PRIMARY KEY(empno)
)
COLLATE euckr_bin
REUSE_OID;

CREATE TABLE emp_file (
	empno INTEGER NOT NULL,
	file_name CHARACTER VARYING (255),
	file_data BLOB,
	CONSTRAINT pk PRIMARY KEY(empno)
)
COLLATE euckr_bin
REUSE_OID;

   

Insert into DEPT
   (DEPTNO, DNAME, LOC)
 Values
   (10, 'ACCOUNTING', 'NEW YORK');
Insert into DEPT
   (DEPTNO, DNAME, LOC)
 Values
   (20, 'RESEARCH', 'DALLAS');
Insert into DEPT
   (DEPTNO, DNAME, LOC)
 Values
   (30, 'SALES', 'CHICAGO');
Insert into DEPT
   (DEPTNO, DNAME, LOC)
 Values
   (40, 'OPERATIONS', 'BOSTON');

commit;




Insert into EMP
   (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, DEPTNO)
 Values
   (1111, '홍길동 ', '총무 ', 22, cast(SYSDATETIME AS DATE) , 5555, 10);
   
Insert into EMP
   (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, DEPTNO)
 Values
   (7369, 'SMITH', 'CLERK', 7902, cast(SYSDATETIME AS DATE) , 4157.28, 30);
   
Insert into EMP
   (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, DEPTNO)
 Values
   (7499, 'ALLEN', 'SALESMAN', 7698, cast(SYSDATETIME AS DATE) , 1607, 30);
   
Insert into EMP
   (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
 Values
   (7521, 'WARD', 'SALESMAN', 7698, cast(SYSDATETIME AS DATE) , 1250, 500, 30);
   
Insert into EMP
   (EMPNO, ENAME, JOB, MGR, HIREDATE, DEPTNO)
 Values
   (7566, 'JONES', 'MANAGER', 7839, cast(SYSDATETIME AS DATE) , 20);
   
Insert into EMP
   (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
 Values
   (7654, 'MARTIN', 'SALESMAN', 7698, cast(SYSDATETIME AS DATE) , 1250, 1400, 10);
   
Insert into EMP
   (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, DEPTNO)
 Values
   (7698, 'BLAKE', 'MANAGER', 7839, cast(SYSDATETIME AS DATE) , 2850, 30);
   
Insert into EMP
   (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, DEPTNO)
 Values
   (7782, 'CLARK', 'MANAGER', 7839, cast(SYSDATETIME AS DATE) , 2450, 10);
   
Insert into EMP
   (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, DEPTNO)
 Values
   (7788, 'SCOTT', 'ANALYST', 7566, cast(SYSDATETIME AS DATE) , 3000, 20);
   
Insert into EMP
   (EMPNO, ENAME, JOB, HIREDATE, SAL, DEPTNO)
 Values
   (7839, 'KING', 'PRESIDENT', cast(SYSDATETIME AS DATE) , 5000, 10);
   
Insert into EMP
   (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
 Values
   (7844, 'TURNER', 'SALESMAN', 7698, cast(SYSDATETIME AS DATE) , 1500, 0, 30);
   
Insert into EMP
   (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, DEPTNO)
 Values
   (7876, 'ADAMS', 'CLERK', 7788, cast(SYSDATETIME AS DATE) , 1100, 20);
   
Insert into EMP
   (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, DEPTNO)
 Values
   (7900, 'JAMES', 'CLERK', 7698, cast(SYSDATETIME AS DATE) , 950, 30);
   
Insert into EMP
   (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, DEPTNO)
 Values
   (7902, 'FORD', 'ANALYST', 7566, cast(SYSDATETIME AS DATE) , 3000, 20);
   
Insert into EMP
   (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, DEPTNO)
 Values
   (7934, 'MILLER', 'CLERK', 7782, cast(SYSDATETIME AS DATE) , 1300, 10);
 
 commit;
 
 

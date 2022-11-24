USE cognidemo;
select *from worker;
select *from bonus;
SELECT * FROM title;
select * from title;
insert into title value(1,'manager','2016-02-16 00:00:00');
insert into title value(2,'executive','2016-02-16 00:00:00');
insert into title value(8,'executive','2016-02-16 00:00:00');
insert into title value(5,'lead','2016-02-16 00:00:00');
insert into title value(4,'asst. manager','2016-02-16 00:00:00');
insert into title value(7,'executive','2016-02-16 00:00:00');
insert into title value(6,'lead','2016-02-16 00:00:00');
insert into title value(3,'lead','2016-02-16 00:00:00');

select FIRST_NAME as WORKER_NAME from worker;
select UPPER(FIRST_NAME) from worker;
select distinct(DEPARTMENT) from worker;
select FIRST_NAME from worker where FIRST_NAME='___';
select substring(FIRST_NAME,1,3) from worker;
select position('a' in 'Amitabh') as position from worker;
select rtrim(FIRST_NAME) from worker;
select ltrim(DEPARTMENT) from worker;
select distinct(length(DEPARTMENT)) from worker;
select replace(FIRST_NAME, 'a','A') from worker;
select concat(FIRST_NAME," ", LAST_NAME) as COMPLETE_NAME from worker;
select * from worker order by FIRST_NAME; 
select * from worker order by FIRST_NAME Asc  order by DEPARTMENT desc;
select 

 









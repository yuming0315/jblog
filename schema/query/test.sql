desc user;

select * from user;
select * from blog;
select * from category;
select * from post;

select id,title,profile
		 from blog
		 where id = 'yum';

select a.no no,name,count(b.no) postNum
		 from category a left join post b
		 on a.no = b.category_no
		 where a.id='wlals'
         group by a.no;
		 
         
desc blog;

desc category;

desc post;

select no
		 from category
		 where id = 'wlals' and name='기본';

insert
		 into user
		 values ('1234', '1234', password('1234'), now() )
		insert into blog
		 values ('1234','1234',null )
		insert into category
		 values (no, '1234', 기본 )
		


select @@global.time_zone, @@session.time_zone,@@system_time_zone;

SELECT sysdate(), @@system_time_zone AS TimeZone;

select now();
desc user;

select * from user;
select * from blog;
select * from category;

select id,title,profile
		 from blog
		 where id = 'yum';
         
desc blog;

desc category;

desc post;

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
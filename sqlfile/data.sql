use javadb;
insert into student(name,age,gender,grade,type)
 values('홍길동',12,0,1,1 ) ,
 ('김철수',11,0,1,1 )
 ;

 
 select * from student
 ;


insert into subject(name,studentid,score)
 values('국어',2,80),
 ('영어',2,85),
 ('수학',2,95)
 ;


select
	*
    from student st join subject sb
		on st.id = sb.studentid
;

-- update
update student 
set name = '동해물과 백두산', age = 100
where id = 2
;

-- delete
DELETE FROM sudent
WHERE id = 2
;




# Create
insert into student(name, age, gender, grade, type)
 values('홍길동', 12, 0, 1, 1 );
 
insert into subject( name, studentid, score)
 values('국어', 1, 80),
 ('영어', 1, 85),
 ('수학', 1, 95)
 ;

# Read 조회
use javadb;
select * from student;
select * from subject;

select
	*
    from student st left join subject sb
		on st.id = sb.studentid
;


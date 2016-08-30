select * from member;
select * from tab;
select * from account;
select * from grade;

drop table grade;

create sequence seq
increment by 1
start with 1000
nocycle;


create table grade(
    seq number constraint grade_pk primary key,
    grade varchar2(50),
    java number,
    sql number,
    html number,
    javascript number,
    id varchar2(20),
    constraint grade_member_fk foreign key(id)
    references member(id) on delete cascade
);


insert into account (account_no, money, id) values(123456, 5000, 'hong');
insert into grade (seq, grade, java, sql, html, javascript, id) values(seq.nextval, 20, 40, 50, 60, 50, 'hong');

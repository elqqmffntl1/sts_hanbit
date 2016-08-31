---------[내부 스키마:물리적]---------
create table account(
   account_no int primary key,
   money int,
   id varchar2(10),
 constraint account_member_fk foreign key(id)
    references member(id) on delete cascade
);
select * from account;
drop table account;

insert into account(
     account_no,money,id   
)values(
     151235,19900,'song'
);
---------[외부 스키마:논리적]-----
--------------view------
create view account_member
as select * from account;

select * from account_member;

drop view account_member;

-- join 조인

create view account_member as
select 
    g.account_no as account_no,
    g.money as money,
    g.id as id,
    m.pw as pw,
    m.name as name,
    m.reg_date as reg_date,
    m.ssn as ssn
from member m,account g
where m.id = g.id;

select 
       account_no as acc,
       id as id,
       name as name,
       money as money,
       ssn as birth 
from account_member;
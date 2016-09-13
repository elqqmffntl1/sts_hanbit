--CREATE
DROP SEQUENCE grade_seq;
DROP SEQUENCE art_seq;
DROP SEQUENCE subj_seq;
DROP SEQUENCE major_seq;
DROP SEQUENCE exam_seq;
CREATE SEQUENCE grade_seq START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE art_seq START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE subj_seq START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE major_seq START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE exam_seq START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;

-- SELECT SEQUENCE_OWNER, SEQUENCE_NAME FROM ALL_SEQUENCES WHERE SEQUENCE_OWNER = 'HANBIT';

DROP TABLE Major CASCADE CONSTRAINT;
DROP TABLE Member CASCADE CONSTRAINT;
DROP TABLE Grade CASCADE CONSTRAINT; 
DROP TABLE Board CASCADE CONSTRAINT;
DROP TABLE Subject CASCADE CONSTRAINT;
DROP TABLE Exam CASCADE CONSTRAINT;

CREATE TABLE Major(
		 major_seq INT CONSTRAINT major_pk PRIMARY KEY,
		 title VARCHAR2(20) NOT NULL
);   
CREATE TABLE Member(
          mem_id VARCHAR2(20) CONSTRAINT member_pk PRIMARY KEY,
          pw VARCHAR2(20) NOT NULL,
          name VARCHAR2(20) NOT NULL,
          gender VARCHAR2(10) NOT NULL,
          reg_date VARCHAR2(20) NOT NULL,
          ssn VARCHAR2(10) NOT NULL,
          email VARCHAR2(30),
          profile_img VARCHAR2(100) DEFAULT 'default.jpg',
          role VARCHAR2(10) DEFAULT 'STUDENT',
          phone VARCHAR2(13) NOT NULL,
          major_seq INT,
          CONSTRAINT gender_ck CHECK (gender IN ('MALE', 'FEMALE')),
          CONSTRAINT major_member_fk FOREIGN KEY (major_seq) REFERENCES Major(major_seq) ON DELETE CASCADE 
          );
CREATE TABLE Grade(
		  grade_seq INT CONSTRAINT grade_pk PRIMARY KEY,
		  grade VARCHAR2(5) NOT NULL,
		  term VARCHAR2(10) NOT NULL,
		  mem_id VARCHAR2(20) NOT NULL,
		  CONSTRAINT member_grade_fk FOREIGN KEY (mem_id) REFERENCES Member(mem_id) ON DELETE CASCADE 
);
CREATE TABLE Board(
		 art_seq INT CONSTRAINT board_pk PRIMARY KEY,
		 category VARCHAR2(20) NOT NULL,
		 title VARCHAR2(30) DEFAULT 'NO TITLE',
		 reg_date VARCHAR2(20) NOT NULL,
		 content VARCHAR2(100) DEFAULT 'NO CONTENT',
		 mem_id VARCHAR2(20),
		 CONSTRAINT member_board_fk FOREIGN KEY (mem_id) REFERENCES Member(mem_id) ON DELETE CASCADE 
);  
CREATE TABLE Subject(
		 subj_seq INT CONSTRAINT subject_pk PRIMARY KEY,
		 subj_name VARCHAR2(20) NOT NULL,
		 mem_id VARCHAR2(20) NOT NULL,
		 CONSTRAINT member_subject_fk FOREIGN KEY (mem_id) REFERENCES Member(mem_id) ON DELETE CASCADE 
);
CREATE TABLE Exam(
		 examSeq INT CONSTRAINT exam_pk PRIMARY KEY,
		 term VARCHAR2(10) NOT NULL,
		 score INT DEFAULT 0,
		 subjSeq INT,
		 mem_id VARCHAR2(20),
		 CONSTRAINT subject_exam_fk FOREIGN KEY (subj_seq) REFERENCES Subject(subj_seq) ON DELETE CASCADE,
		 CONSTRAINT member_exam_fk FOREIGN KEY (mem_id) REFERENCES Member(mem_id) ON DELETE CASCADE 
); 

CREATE OR REPLACE VIEW Major_view 
AS
SELECT 
	  m.major_seq AS majorSeq,
	  m.title AS majorTitle,
	  u.mem_id AS id,
      u.pw AS pw,
      u.name AS name,
      u.gender AS gender,
      u.reg_date AS regDate,
      u.ssn AS ssn,
      u.email AS email,
      u.profile_img AS profileImg,
      u.role AS role,
      u.phone AS phone 
FROM Major m, Member u 
WHERE m.major_seq = u.major_seq;

CREATE OR REPLACE VIEW Grade_view 
AS
SELECT 
	  u.mem_id AS id,
      u.pw AS pw,
      u.name AS name,
      u.gender AS gender,
      u.reg_date AS regDate,
      u.ssn AS ssn,
      u.email AS email,
      u.profile_img AS profileImg,
      u.role AS role,
      u.phone AS phone,
	  g.grade_seq AS gradeSeq,
	  g.grade AS grade,
	  g.term AS term,
	  s.subj_seq AS subjSeq,
	  s.subj_name AS subjName,
	  x.exam_seq AS examSeq,
	  x.term AS term,
	  x.score AS score 
FROM  Member u, Grade g, Subject s, Exam x 
WHERE u.mem_id = g.mem_id AND u.mem_id = s.mem_id AND u.mem_id = x.mem_id; 

CREATE OR REPLACE VIEW Board_view 
AS
SELECT 
	  u.mem_id AS id,
      u.pw AS pw,
      u.name AS name,
      u.gender AS gender,
      u.reg_date AS writeDate,
      u.ssn AS ssn,
      u.email AS email,
      u.profile_img AS profileImg,
      u.role AS role,
      u.phone AS phone,
	  b.art_seq AS artSeq,
	  b.category AS category,
	  b.title AS title,
	  b.reg_date AS regDate,
	  b.content AS content 
FROM Member u, Board b 
WHERE u.mem_id = b.mem_id;
 
--Major
CREATE OR REPLACE PROCEDURE insertMajor(
	sp_title IN Major.title%TYPE
) AS 
BEGIN
	INSERT INTO Major(major_seq,title)
	VALUES(major_seq.nextval,sp_title)
END insertMajor; 
--Member
CREATE OR REPLACE PROCEDURE insertMember(
	sp_mem_id IN Member.mem_id%TYPE,
	sp_pw IN member.pw%TYPE,
	sp_name IN Member.name%TYPE,
	sp_gender IN Member.gender%TYPE,
	sp_reg_date IN Member.reg_date%TYPE,
	sp_ssn IN Member.ssn%TYPE,
	sp_email IN Member.email%TYPE,
	sp_profile_img IN Member.profile_img%TYPE,
	sp_role IN Member.role%TYPE,
	sp_phone IN Member.phone%TYPE,
	sp_major_seq IN Member.major_seq%TYPE 
) AS 
BEGIN
	INSERT INTO Member(mem_id,pw,name,gender,reg_date,ssn,email,profile_img,role,phone,major_seq)
	VALUES(sp_mem_id,sp_pw,sp_name,sp_gender,sp_reg_date,sp_ssn,sp_email,sp_profile_img,sp_role,sp_phone,sp_major_seq)
END insertMember;
--Grade
CREATE OR REPLACE PROCEDURE insertGrade(
	sp_grade_seq IN Grade.grade_seq%TYPE,
    sp_grade IN Grade.grade%TYPE,
	sp_term IN Grade.term%TYPE,
	sp_mem_id IN Grade.mem_id%TYPE
) AS 
BEGIN
	INSERT INTO Grade(grade_seq,grade,term,mem_id)
	VALUES(sp_grade_seq,sp_grade,sp_term,sp_mem_id)
END insertGrade;
--Board
CREATE OR REPLACE PROCEDURE insertBoard(
	sp_art_seq IN Board.art_seq%TYPE,
	sp_category IN Board.category%TYPE,
	sp_title IN Board.title%TYPE,
	sp_reg_date IN Board.reg_date%TYPE,
	sp_content IN Board.content%TYPE,
	sp_mem_id IN Board.mem_id%TYPE
) AS 
BEGIN
	INSERT INTO Board(art_seq,category,title,reg_date,content,mem_id)
	VALUES(sp_art_seq,sp_category,sp_title,sp_reg_date,sp_content,sp_mem_id)
END insertBoard;
--Subject
CREATE OR REPLACE PROCEDURE insertSubject(
	sp_subj_seq IN Subject.subj_seq%TYPE,
	sp_subj_name IN Subject.subj_name%TYPE,
	sp_mem_id IN Subject.mem_id%TYPE,
) AS 
BEGIN
	INSERT INTO Subject(subj_seq,subj_name,mem_id)
	VALUES(sp_subj_seq,sp_subj_name,sp_mem_id)
END insertSubject;
--Exam
CREATE OR REPLACE PROCEDURE insertExam(
	sp_exam_seq IN Exam.exam_seq%TYPE,
	sp_term IN Exam.term%TYPE,
	sp_score IN Exam.score%TYPE,
	sp_subj_seq IN Exam.subj_seq%TYPE,
	sp_mem_id IN Exam.mem_id%TYPE
) AS 
BEGIN
	INSERT INTO Exam(exam_seq,term,score,subj_seq,mem_id)
	VALUES(sp_exam_seq,sp_term,sp_score,sp_subj_seq,sp_mem_id)
END insertExam;

EXEC insertMajor(major_seq,'컴퓨터 공학');
EXEC insertMember('reper','1','리 퍼','MALE','2016-09-01','910201-1','reper@test.com','reper.jpg','STUDENT','010-3619-9284',1000);

select * from tab;

select * from user_views;

drop table grade;
drop view subject_member;

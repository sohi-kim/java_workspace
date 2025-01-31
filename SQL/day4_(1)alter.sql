/*
 * 테이블 구조  변경 : alter table
 * 참고 : 오라클에서는 테이블,컬럼명 등 식별자 이름에 쓸수 있는 기호  _ , #, $
 */

--CONSTRAINT 제약조건이름 제약조건내용
CREATE TABLE tbl# (
	col1 varchar2(30) CONSTRAINT tbl#_notnull1 NOT NULL,	
	col2 varchar2(10) NOT NULL,  -- CONSTRAINT 키워드 생략 
	col3 varchar2(10),
	col4 number(3)
);   

-- CREATE 는 1번만 실행합니다. 
-- 테이블과 같은 오라클 객체가 생성된 후에 변경사항은 ALTER 명령으로 .

-- alter table   테이블명 [변경내용키워드]  (변경내용)  
-- [변경내용키워드] 
-- 1) *컬럼 이름 변경 : rename column 
-- 2) 테이블 이름 변경 : rename to 
-- 3) *새로운 컬럼 추가 : add
-- 4) *컬럼 데이터 형식 변경 : modify
-- 5) *제약 조건 추가 : add constraint  
-- 6) 기존 컬럼 삭제 : drop
-- 7) *기존 제약 조건 삭제 : drop constraint 제약조건이름


-- 1)컬럼 이름 변경                 현재이름 to 새로운 이름
 ALTER TABLE tbl# RENAME COLUMN col2 TO col22;  
 ALTER TABLE tbl# RENAME COLUMN col22 TO col2;  
SELECT * FROM tbl#;

-- 2) 새로운 컬럼 추가
-- 기본값 확인 
ALTER TABLE tbl# ADD (column5 NUMBER(5) DEFAULT 100); 

-- 2) 번 변경후에 데이터 추가합니다.
INSERT INTO tbl#(col1,col2) VALUES ('테스트11','테스트'); 

-- 오류 : col2 10바이트 초과 -> 한글 3바이트 그외 1바이트 
-- INSERT INTO tbl#(col1,col2) VALUES ('테스트11','테스트22');

-- 3) 기존 컬럼 형식 변경
-- not null 제약조건 있는지 확인하기
ALTER TABLE tbl# MODIFY (col2 varchar2(50)); 
-- col2 에 11바이트 데이터 저장가능.
INSERT INTO tbl#(col1,col2) VALUES ('테스트11','테스트22');

-- 제약조건 키워드없는 not null 을 null로 변경할 때
ALTER TABLE tbl# MODIFY COL2 VARCHAR2(50) NULL;

--  null -> not null로 변경
ALTER TABLE tbl# MODIFY COL3 VARCHAR2(50) NOT NULL;

-- 4) 제약조건 추가 : 기존에 저장된 데이터 때문에 오류가 생길 수 있는 내용입니다.데이터 행 삭제 후 추가하기.
--    col3 기존 데이터 중 null 이 있으면 제약조건 위반하여 오류
ALTER TABLE tbl# ADD CONSTRAINT tbl#_notnull2 CHECK (col3 IS NOT NULL);
--    실행 ? or 오류? -> col4 기존데이터가 제약조건에 맞는 값이다.
ALTER TABLE tbl# ADD CONSTRAINT tbl#_notnull3 CHECK (col4 IS NOT NULL);

-- 5) 제약조건 제거 : 제약조건은 변경은 없습니다. add 와 drop 만 있습니다.
ALTER TABLE tbl# DROP CONSTRAINT tbl#_notnull3;



-- ((참고))테이블의 제약조건 이름 확인하기 : 오라클의 시스템 테이블
SELECT * FROM USER_CONSTRAINTS;

-- ** alter table 로 col1을 primay key 로 변경해보세요. (나중에는 alter table 로 fk 추가도 할 수 있어야 합니다.)
ALTER TABLE "TBL#" MODIFY col1 PRIMARY KEY;
ALTER TABLE "TBL#" MODIFY col1 varchar2(30) PRIMARY KEY;

-- 기본키가 복합컬럼이라면 ADD CONSTRAINT 키워드 써야 합니다.
ALTER TABLE "TBL#" ADD CONSTRAINT tbl#_pk PRIMARY KEY (col1);







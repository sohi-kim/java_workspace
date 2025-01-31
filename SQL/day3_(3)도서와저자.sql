/*
문제 : 조건에 맞는 도서와 저자리스트 출력

1. type 수정 : integer 는 number(8), varchar 는 varchar2(100)
2. book_id 컬럼은 book_id_seq 만들어서 insert 에 활용하세요

3. 2개의 테이블 모두 기본키 설정해 보세요.
4. author 테이블의 참조관계 설정
*/

CREATE TABLE AUTHOR (
	AUTHOR_ID number(8) PRIMARY KEY,
	AUTHOR_NAME varchar2(100) NOT NULL 
);

CREATE TABLE BOOK (
	BOOK_ID number(8) PRIMARY KEY,
	CATEGORY varchar2(100) NOT NULL ,
	AUTHOR_ID number(8) NOT NULL,
	PRICE number(8) NOT NULL,
	PUBLISHED_DATE DATE NOT NULL ,
	FOREIGN KEY (AUTHOR_ID)
	REFERENCES AUTHOR (AUTHOR_ID)
);

-- 데이터 추가 : AUTHOR 먼저 insert -> BOOK 
INSERT INTO AUTHOR VALUES (1,'홍길동');
INSERT INTO AUTHOR VALUES (2,'김영호');


CREATE SEQUENCE book_id_seq ;

INSERT INTO BOOK 
VALUES (book_id_seq.nextval , '인문',1,10000,'2020-01-01');
INSERT INTO BOOK 
VALUES (book_id_seq.nextval , '경제',1,9000,'2021-04-11');
INSERT INTO BOOK 
VALUES (book_id_seq.nextval , '경제',2,11000,'2021-02-05');

SELECT * FROM AUTHOR;
SELECT * FROM BOOK;

-- 같은 이름의 시퀀스를 초기화 못함. 삭제 후 다시 생성
DROP SEQUENCE book_id_seq ;

-- 테이블 간의 참조 관계에서 무결성을 위한 처리 방식 

-- 1) 테이블 삭제 : 참조 테이블이 있으면 테이블 삭제 못합니다.
--			   BOOK 테이블 삭제 후 AUTHOR 삭제하기
DROP TABLE AUTHOR;  --  외래 키에 의해 참조되는 고유/기본 키가 테이블에 있습니다
DROP TABLE BOOK;

-- 2) 데이터 삭제 : 참조 관계 고려해야 합니다.
--               Book 테이블에서 참조하고 있는 값은 삭제 할수 없다.
DELETE FROM AUTHOR WHERE AUTHOR_ID =1 ;


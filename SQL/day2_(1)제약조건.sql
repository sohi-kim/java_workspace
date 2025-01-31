/*
 * 수업 날짜 1월 16일
 * 제약 조건 constraint - 테이블에 저장되는 데이터가 `요구사항에 대한 부적절한 값`을 갖지 않도록 규정.
 * 			
 * 
 * 1) 반드시 값이 있어야한다.(필수 입력)	NULL 허용안함. - NOT NULL
 * 2) 같은 값을 가질수 없다.				UNIQUE (유일한) - NULL 값은 가능함. -> 검색 Index 를 만든다.
 * 3) 입력값이 1~4 범위도로만 한다.		CHECK
 * -------------------------
 * 4) 기본키 :  테이블의 행을 식별(구별)  
 *            where 기본키컬럼=값;	조건실행 헀을 때 1개의 행 조회됩니다.
 * 			  자동으로 인덱스(색인)로 생성이됩니다. 
 * 			  인덱스는 검색(조회) 속도 향상시키는 방법입니다.
 * 			  기본키는 NOT NULL 과 UNIQUE 2가지 제약조건에 해당합니다.
 * 			  기본키는 테이블에서 1개만 가능합니다. 
 *            단, 기본키는 구성하는 컬럼은 1개 이상 (2개,3개...) 가능합니다.
 * 5) 외래키 : 테이블 간의 참조를 위해서 사용합니다.
 * 			 외래키는 테이블 1개에서 여러 개 만들어질 수 있습니다.
 * 	
 * */
-- 제약조건 컬럼레벨 설정하기
CREATE TABLE tbl_constr(	
	aname varchar2(20) NOT NULL,
	bname varchar2(20) UNIQUE,	-- NULL 허용
	cno number(4) NOT NULL UNIQUE,   -- 2개의 제약 조건
	dno number(1) CHECK (dno BETWEEN 1 AND 4),	-- NULL 허용
	eno number(4)		-- number 형식이 맞는 모든 데이터 허용. 
);

INSERT INTO TBL_CONSTR (aname,cno) VALUES ('apple',3);		-- 필수 입력 컬럼
-- 1) 입력 오류 발생하는 경우 : unique 위반
-- INSERT INTO TBL_CONSTR (aname,bname,cno) 
--  values('apple','banana',3);	-- cno 컬럼값 중복

INSERT INTO TBL_CONSTR (aname,bname,cno) 
values('apple','banana',4); 
-- INSERT INTO TBL_CONSTR (aname,bname,cno) 
-- values('apple','banana',5); -- bname 컬럼값 중복

-- 2) 입력 오류 발생하는 경우 : not null 위반
-- INSERT INTO TBL_CONSTR (cno) VALUES (3);	 -- aname 필수 입력

-- 3) 입력 오류 발생하는 경우 : check 위반
INSERT INTO TBL_CONSTR (aname,cno,dno) VALUES ('apple',7,3);
INSERT INTO TBL_CONSTR (aname,cno,dno) VALUES ('apple',8,7);	-- 값의 범위 1~4 아님

SELECT * FROM TBL_CONSTR ;















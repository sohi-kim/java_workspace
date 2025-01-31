/*
 *   예시 :  영어-한글 나만의 사전
 *   <<요구사항>>
 *   1. 영어단어, 한글 뜻은 필수 입력값
 *   2. 난이도 수준을 1~3 으로 설정. null 허용 
 *   3. 영어 단어 동일한 값은 중복 안되도록 함. 
 *   4. 입력한 순서에 따라 일련번호를 부여함. 필수입력값+중복없음. -> 기본키
 * 
 * 
 *   테이블명 : tbl_dict
 *   컬럼명 : english, korean , step , idx
 */

-- 1) 테이블 생성
CREATE TABLE tbl_dict (
	idx number(8) PRIMARY KEY  ,   -- 기본키 (검색의 성능과 관련)
	english varchar2(100) NOT NULL UNIQUE ,
	korean varchar2(100) NOT NULL,
	step number(1) CHECK (step BETWEEN 1 AND 3)
);

-- 3) select 컬럼1,컬럼2, ... from 테이블명 where 조건식 order by 컬럼1,컬럼2,..

--  unique, pk (null 허용 하지 않는 행식별) 컬럼으로 조건식
SELECT * FROM TBL_DICT WHERE idx =2;   -- 오직 1개의 행 추출
SELECT * FROM TBL_DICT WHERE ENGLISH = 'order';

-- order by : 정렬 (오름차순 또는 내림차순)
SELECT * FROM TBL_DICT 
ORDER BY idx ;    -- idx 컬럼값 기준 오름차순. ASC 키워드 생략

SELECT * FROM TBL_DICT 
ORDER BY idx DESC ;  -- idx 컬럼값 기준 내림차순

SELECT * FROM TBL_DICT 
ORDER BY ENGLISH  ;  -- ENGLISH 컬럼값 기준 오름차순

SELECT * FROM TBL_DICT 
ORDER BY ENGLISH  DESC ;   -- ENGLISH 컬럼값 기준 내림차순

SELECT * FROM TBL_DICT
order BY step;			-- step 컬럼은 같은 값을 갖는 행이 많습니다. -> 두번째 정렬 기준 컬럼 지정

SELECT * FROM TBL_DICT
order BY step,idx;     -- 두번째 정렬 기준 컬럼 idx 지정

SELECT * FROM TBL_DICT
order BY step DESC ,english;     -- 두번째 정렬 기준 컬럼 enlish 지정

-- where 먼저, 뒤에 order by
SELECT * FROM TBL_DICT
WHERE STEP =1		
ORDER BY step DESC ,english;


-- 2) 데이터 추가
INSERT INTO tbl_dict VALUES (
		1,
		'public',
		'공용의',
		'1'    -- 문자열 '1' 을 정수 1로 변환
);

INSERT INTO tbl_dict (IDX , ENGLISH ,KOREAN)
	   VALUES (2,'private','사적인');	

INSERT INTO tbl_dict VALUES (
		3,
		'deprecated',
		'비난하다.반대하다.',
		'3'
);	  
	  
INSERT INTO tbl_dict VALUES (
		4,
		'list',
		'목록',
		'2'
);	 
INSERT INTO tbl_dict VALUES (
	5,
	'constraint',
	'제약사항',
	3
);

INSERT INTO tbl_dict VALUES (
	6,
	'order',
	'순서',
	1
);

INSERT INTO tbl_dict VALUES (
	7,
	'main',
	'주요한',
	1
);

INSERT INTO tbl_dict VALUES (
	8,
	'order',
	'순서',
	1
);    -- 'order' 값의 중복 : 무결성 제약조건 위반 오류

INSERT INTO tbl_dict VALUES (
	9,
	'reverse',
	'반대로',
	2
);

INSERT INTO tbl_dict VALUES (
	10,
	'double',
	'이중의',
	1
);








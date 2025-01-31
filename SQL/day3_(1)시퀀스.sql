/*
 *    오라클의 오브젝트 : 테이블, 인덱스, 시퀀스
 *           생성 명령 : create , drop , alter
 *    시퀀스 : 자동으로 값을 생성해 줍니다. (my-sql autoincrement 속성 사용)
 *            기본키 컬럼이 number 타입일 때 , 값을 직접 입력하지 않고 시퀀스 이용합니다.
 */

CREATE TABLE tbl_forseq (
	idx number(8) PRIMARY KEY ,
	name varchar2(50) NOT NULL,
	etc varchar2(50)
);

INSERT INTO tbl_forseq VALUES (1,'사나','테스트');

-- 필요할 때 만들어진 테이블 제거
DROP TABLE TBL_FORSEQ ;

-- 기본키에 사용할 시퀀스 생성
CREATE SEQUENCE test_seq;

-- 시퀀스는 캐쉬크기 만큼 미리 값이 만들어집니다.
-- '현재' 시퀀스값 가져오는 함수 currval
-- '다음' 시퀀스값 가져오는 함수 nextval

SELECT test_seq.nextval FROM dual;
SELECT test_seq.currval FROM dual;

-- pk 컬럼 insert 에 사용
INSERT INTO tbl_forseq 
VALUES (test_seq.nextval,'모모','시퀀스테스트');

-- 시퀀스의 시작값 변경
CREATE SEQUENCE test2_seq
START WITH 1001;

-- 시퀀스의 시작값, 증가값 변경
CREATE SEQUENCE test3_seq
START WITH 1001
INCREMENT BY 10;
-- cache 10



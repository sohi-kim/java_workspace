/*  `트랜잭션` : 
     - 하나의 논리적인 작업 단위. 
     - insert , update , delete DML 명령으로 데이터를 조작할 때 반드시 하나의 단위로 처리해야하는 작업
     - 예시:  모모가 미나한테 5만원 이체를 합니다. 
                `모모 계좌는 -5만원 그리고  미나 계좌는 +5만원`
	  2개의 update 실행은 2개 모두 실행 또는 2개 모두 실행이 안되거나 해야 하는 트랜잭션입니다.
     - 커밋 : DML 명령어로 수행된 변경 사항을 데이터베이스에 영구적으로 반영합니다.
	  자동 커밋은 insert , update , delete 가 바로 테이블에 반영되고, 
	  수동커밋은 명령을 실행하여 반영합니다.	

     - 수동 커밋 옵션에서 실행 명령어
 		commit : 커밋 실행 명령어. 하나의 트랜잭션 완료              
 		rollback :  insert , update , delete  취소 명령어. 
	  
     -  sql plus 커밋 설정 명령어 
		 show autocommit;			--> 현재 자동커밋 여부 확인
		 set autocommit off[on];
    
*/

-- 1) sql plus(사용자 A) 에서 테이블을 만들어 봅니다.
CREATE TABLE tbl_sale(
	sale_id number(5) ,
	user_id varchar2(10)
);  -- SQL plus로 복붙하여 실행

-- 2) 디비버(사용자 B) 에서 조회를 합니다.
 select * from tbl_sale;     -- 데이터가 없는 상태로 조회 잘 됨.
-- DDL 은 항상 자동 커밋.

-- 3) 사용자 A가 행을 추가. sql plus에서 실행하기
INSERT INTO tbl_sale VALUES (1, 'momo');

-- 4) 사용자 B (디비버) 에서 다시 조회
 select * from tbl_sale;     -- 사용자A가 추가한 1, momo 안 보임

-- 5) 사용자 A (Sql plus)에서 커밋  

-- 6) 다시 4번                 -- 사용자A가 추가한 1, momo 잘 보임

-- 결론 : 다중 사용자 환경에서 수동 커밋인 사용자 A 데이터 추가는 사용자 B가
--       바로 조회 할 수 없다. commit 명령으로 트랜잭션을 완료해야 조회 가능하다. 

 -- 7) 사용자 B(디비버) 는 자동 커밋
 INSERT INTO tbl_sale VALUES (2,'sana');
 
/*
 *  - 디비버의 auto commit 해제하고 rollback 테스트 
	 : 데이터베이스 메뉴 - 트랜잭션 모드 - manual commit 으로 변경하기
 */
-- 새로운 트랜잭션 1번 시작
INSERT INTO tbl_sale VALUES (3,'test');
SELECT * FROM tbl_sale;
UPDATE tbl_sale SET USER_ID ='김모모' 
WHERE SALE_ID =3;
rollback ;    -- 트랜잭션 시작했던 상태로 행 되돌림.

-- 새로운 트랜잭션 2번 시작
INSERT INTO tbl_sale VALUES (4,'테스트');
SELECT * FROM tbl_sale;
UPDATE tbl_sale SET USER_ID ='김모모' 
WHERE SALE_ID =4;
commit ;

-- rollback 또는 commit 을 한 후에는 새로운 트랜잭션 

-- 대부분의 관계형 DBMS 는 프로시져로 하나의 비지니스 로직
-- (트랜잭션) 실행을 정의합니다. 프로시저 정의할 때 
-- 오류 처리 내용이 rollback. 정상적 완료는 commit;


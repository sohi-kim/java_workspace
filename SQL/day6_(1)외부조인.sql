/*
	조인 형식:
	1) JOIN ~ ON 컬럼동등비교 조건식   : 동등 조인.  NULL 값은 포함 안됩니다.
	2) LEFT JOIN ~ ON 컬럼동등비교 조건식    : 외부 조인. NULL 값을 포함한 조인
	 (RIGHT)

*/

-- 외부 조인 테스트를 위한 insert (새로운 상품 추가)
INSERT INTO TBL_PRODUCT tp (pcode,category,pname,price)
VALUES ('SNACK99','C1','새우깡번들',5500);
SELECT * FROM TBL_PRODUCT tp ;

-- 크로스 조인 : 새로운 상품 SNACK99 도 결과에 보입니다.(동등 조건식 없을 떄)
--             단, 구매 테이블에는 SNACK99 상품코드 값 없습니다.
SELECT * 
FROM TBL_BUY tb ,TBL_PRODUCT tp
WHERE tp.PCODE = tb.PCODE;   -- 동등비교 조건식(SNACK99 없습니다.)

-- 동등 조인
SELECT *
FROM TBL_PRODUCT tp 
JOIN TBL_BUY tb 
ON tp.PCODE = tb.PCODE ;

-- 외부 조인
SELECT *
FROM TBL_PRODUCT tp 
LEFT JOIN TBL_BUY tb      
-- 왼쪽 테이블의 모든 행을 조인에 포함. 오른쪽 테이블에 pcode 값이 없으면 모두 null
ON tp.PCODE = tb.PCODE ;

SELECT *
FROM TBL_BUY tb      
RIGHT JOIN TBL_PRODUCT tp 
-- 오른쪽 테이블의 모든 행을 조인에 포함.왼쪽 테이블에 pcode 값이 없으면 모두 null
ON tp.PCODE = tb.PCODE ;  

-- 활용 문제 : 구매 이력이 없는 상품 정보(이름, 가격)를 조회하세요.

SELECT tp.PCODE ,tp.PNAME ,tp.PRICE 
FROM TBL_PRODUCT tp 
LEFT JOIN TBL_BUY tb 
ON tp.PCODE = tb.PCODE 
WHERE  tb.CUSTOM_ID IS NULL;   
-- 반드시 WHERE , 외부조인에서는 AND 안됨. 외부조인결과로 조건식 실행해야 합니다. 


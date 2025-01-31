/*
	테이블의 행 row 를 대상으로 하는 연산
	: 행의 합집합, 차집합, 교집합
	
*/

SELECT pcode
FROM TBL_BUY tb ;  -- 중복된 값 모두 조회

SELECT DISTINCT pcode   -- 중복된 값은 제거(오직 한번만 조회)
FROM TBL_BUY tb ;	


-- 합집합
SELECT pcode
FROM TBL_BUY tb
UNION			-- 중복 제거 상품 6개만 조회
SELECT pcode 
FROM TBL_PRODUCT tp ;


SELECT pcode
FROM TBL_BUY tb
UNION ALL			-- 중복 고려하지 않고 합치기 15개 (상품6+구매9)
SELECT pcode 
FROM TBL_PRODUCT tp ;   

-- 차집합 : MINUS. select 하는 순서에 주의.
SELECT pcode
FROM TBL_BUY tb
MINUS 			-- 0개 조회
SELECT pcode 
FROM TBL_PRODUCT tp ;

SELECT pcode 
FROM TBL_PRODUCT tp 
MINUS			-- 1개 조회
SELECT PCODE 
FROM TBL_BUY tb ;

-- 교집합 : INTERSECT
SELECT pcode
FROM TBL_BUY tb
INTERSECT			-- 2개의 테이블에 모두 존재하는 pcode 5개 조회
SELECT pcode 
FROM TBL_PRODUCT tp ;


-- 행 연산 테스트 :

-- 조회하는 행의 컬럼 순서에 따라 데이터 타입 일치하면 연산 가능
-- 연산의 형식보다는 기능에 의미를 두고 문제 해결에 사용하세요.
SELECT pcode, pname 
FROM TBL_PRODUCT tp 
UNION
SELECT custom_id , NAME 
FROM TBL_CUSTOMER tc ;

-- 오류 : pname 은 nvarchar 로 타입 불일치
SELECT pcode , pname
FROM TBL_PRODUCT tp 
UNION 
SELECT custom_id , pcode
FROM TBL_BUY tb ;

-- 오류 : 조회하는 행의 컬럼 데이터 타입 불일치
SELECT pcode 
FROM TBL_PRODUCT tp 
UNION 
SELECT quantity
FROM TBL_BUY tb ;

-- 행 연산의 컬럼 수가 일치하지 않는 경우 오류
--  			ㄴ 질의 블록은 부정확한 수의 결과 열을 가지고 있습니다.
SELECT pcode, pname 
FROM TBL_PRODUCT tp 
UNION
SELECT PCODE 
FROM TBL_BUY tb ;

-- 컬럼수가 부족한 것은 null 로 표기
SELECT pcode, pname 
FROM TBL_PRODUCT tp 
UNION
SELECT PCODE , NULL 
FROM TBL_BUY tb ;


-- https://school.programmers.co.kr/learn/courses/30/lessons/131537
-- 프로그래머스 문제 : 오프라인/온라인 판매 데이터 통합하기

select to_char(SALES_DATE,'yyyy-mm-dd') as SALES_DATE ,
       PRODUCT_ID,USER_ID,SALES_AMOUNT
from 
    (
    SELECT
            SALES_DATE ,PRODUCT_ID,USER_ID,SALES_AMOUNT
        FROM ONLINE_SALE
            UNION
    SELECT
            SALES_DATE ,PRODUCT_ID,NULL,SALES_AMOUNT
        FROM OFFLINE_SALE
    ) 
where
    to_char(SALES_DATE,'yyyy-mm')='2022-03'
order by 
    SALES_DATE ,PRODUCT_ID,USER_ID;









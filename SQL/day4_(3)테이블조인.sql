/*
 * 		테이블의 조인 : 2개의 테이블의 컬럼을 합쳐서 
 * 			  하나의 테이블처럼 조회 결과를 만들어 줍니다.
 *      	  조인을 위해서는 참조관계 컬럼이 있어야 합니다.
 *      예시 : 고객과 구매는 고객_ID , 상품과 구매는 PCODE(상품코드)
 *            고객과 상품은 조인을 할 수 없습니다.
 */

-- 0. 크로스 조인 : 데카르트곱 연산에 조인 조건을 추가
-- 데카르트곱 : 모든 경우의 수로 컬럼을 합치기
SELECT *
FROM TBL_CUSTOMER tc , TBL_BUY tb;

-- 조인 조건 추가
SELECT *
FROM TBL_CUSTOMER tc , TBL_BUY tb     -- 별칭 키워드 AS 생략
-- where 가 없으면 모든 경우의 수
-- where 는 그 중에 CUSTOM_ID  가 같은 의미있는 합치기만 걸러냅니다.
WHERE tc.CUSTOM_ID = tb.CUSTOM_ID ;   

-- 1. 활용 예시
-- 1) 2024년에 상품을 구매한 고객ID, 이름, 구매날짜를 조회하세요.

SELECT tc.CUSTOM_ID , tc.NAME , tb.BUY_DATE    
-- 주의:양쪽 테이블에 모두 있는 컬럼은 별칭 필수로 표기합니다.
FROM TBL_CUSTOMER tc , TBL_BUY tb 
WHERE tc.CUSTOM_ID = tb.CUSTOM_ID 			-- 조인 조건
AND to_char(tb.BUY_DATE,'yyyy') = '2024';   -- 검색 조건


-- 2) twice 가 구매한 상품명과 가격, 구매금액을 조회하세요.
SELECT tp.PNAME , tp.PRICE , tp.PRICE * tb.QUANTITY AS "구매금액"
FROM TBL_PRODUCT tp , TBL_BUY tb 
WHERE tp.PCODE = tb.PCODE     -- 조인 조건
AND tb.CUSTOM_ID ='twice';	  -- 검색 조건

-- -- // 2. 조인 연산 표준 형식 : JOIN ~ ON 키워드 사용 // --

-- 고객 과 구매 테이블 조인
SELECT *
FROM TBL_CUSTOMER tc 
JOIN TBL_BUY tb 					-- 2개의 테이블 연결 JOIN 키워드
ON tc.CUSTOM_ID = tb.CUSTOM_ID ;		-- ON 키워드 뒤에 조인조건식

-- 상품과 구매 테이블 조인
SELECT *
FROM TBL_PRODUCT tp 
JOIN TBL_BUY tb 
ON tp.PCODE = tb.PCODE ;

-- 3. 앞의 활용 예시를 표준 형식으로 변경
-- JOIN 의 특징 : 가독성 더 좋다. 조인조건과 검색조건을 분리.
-- 1) 2024년에 구매한 고객의 아이디,이름, 구매날짜를 조회하기
SELECT tc.CUSTOM_ID , tc.NAME , tb.BUY_DATE 
FROM TBL_CUSTOMER tc 
JOIN TBL_BUY tb 					
ON tc.CUSTOM_ID = tb.CUSTOM_ID 					-- 조인 조건
WHERE to_char(tb.BUY_DATE ,'yyyy')='2024';      -- 검색 조건

-- 2) twice 가 구매한 상품명과 가격, 구매금액을 조회하세요.
SELECT tp.PNAME , tp.PRICE , tp.PRICE * tb.QUANTITY AS "구매금액"
FROM TBL_PRODUCT tp 
JOIN TBL_BUY tb 
ON tp.PCODE = tb.PCODE
WHERE tb.CUSTOM_ID ='twice';

















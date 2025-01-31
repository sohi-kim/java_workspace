-- day4 에서 했던 예제
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

-- 임용주 님 SQL : 상품과 구매 조인
-- 3) 상품가격이 30000원 이상인 제품의 구매자 ID와 구매 날짜를 알고 싶어요.
SELECT tb.CUSTOM_ID ,tb.BUY_DATE 
FROM TBL_PRODUCT tp  
JOIN TBL_BUY tb 
ON tp.PCODE=tb.PCODE
WHERE PRICE >30000;
-- 4) 상품 카테고리 B1 인 상품의 구매자 ID와 상품명과 구매 수량를 알고 싶어요.
SELECT tb.CUSTOM_ID , tp.PNAME , tb.QUANTITY 
FROM TBL_PRODUCT tp 
JOIN TBL_BUY tb 
ON tp.PCODE=tb.PCODE
WHERE CATEGORY = 'B1' ;


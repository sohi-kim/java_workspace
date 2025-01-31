/*
	집계 함수와 조인
    상품,고객,구매 3개의 테이블 중에서 count, sum,avg, min,max 집계함수
    실행할 내용이 있는 테이블은(그룹화 가능한 컬럼 있는지)?
*/
SELECT * FROM TBL_PRODUCT tp ;
SELECT * FROM TBL_CUSTOMER tc ;
SELECT * FROM TBL_BUY tb ;

-- 집계 함수 결과를 동률없이 조회하도록 데이터 추가
INSERT INTO TBL_BUY 
VALUES
(tbl_buy_seq.nextval, 
'hongGD',
'JINRMn5', 
 4, 
 to_date('2025-01-20 18:40:10','yyyy-mm-dd hh24:mi:ss'));

-- 1. 그룹화 연습
-- 1) 고객별로 구매건수 조회
SELECT CUSTOM_ID, count(*) AS "구매건수"
FROM TBL_BUY tb 
GROUP BY CUSTOM_ID 
ORDER BY "구매건수" desc;

-- 2) 상품별로 판매 '건수' 조회
SELECT PCODE, COUNT(*) AS "판매건수" 
FROM TBL_BUY tb 
GROUP BY PCODE 
ORDER BY "판매건수" DESC;

-- 3) 상품별로 판매 '수량 합계' 조회
SELECT PCODE, SUM(QUANTITY)  AS "판매수량합" 
FROM TBL_BUY tb 
GROUP BY PCODE 
ORDER BY "판매수량합" DESC;

-- 2. 그룹화 결과와 조인
-- 1) CUSTOM_ID 가 있는 고객 테이블과 조인
SELECT *
FROM TBL_CUSTOMER tc 
JOIN 
	( -- 조인 대상이 테이블이 아닌 SELECT 결과
	SELECT CUSTOM_ID, count(*) AS "구매건수"
		FROM TBL_BUY tb 
		GROUP BY CUSTOM_ID 
		ORDER BY "구매건수" desc
	) agg
ON tc.CUSTOM_ID = agg.CUSTOM_ID 
WHERE rownum =1 ;  -- 조인한 결과로 가장큰 구매건수만 필터링.
-- 위의 결과로 만들 수 있는 조회 내용 : 구매건수가 제일 많은 사용자의 이름,나이


-- 2) 상품별 판매건수 와 상품 테이블 조인
SELECT  * --tp.PNAME , tp.PRICE , agg."판매건수"
FROM TBL_PRODUCT tp 
JOIN 
	(
		SELECT PCODE, COUNT(*) AS "판매건수" 
		FROM TBL_BUY tb 
		GROUP BY PCODE 
		ORDER BY "판매건수" DESC
	) agg
ON tp.pcode = agg.pcode 
-- WHERE rownum =1;
-- 조회 내용 예시1 : 상품 판매건수 가장 높은 상품명, 단가 , 판매건수
WHERE category='B1';
-- 조회 내용 예시2 : B1 카테고리의 상품명, 판매건수

-- 3) 상품별 판매량 합계 와 상품 테이블 조인

SELECT tp.pcode, tp.pname, tp.price*sale.salesum AS total
FROM TBL_PRODUCT tp 
JOIN 
	(
		SELECT PCODE, SUM(QUANTITY)  AS salesum 
		FROM TBL_BUY tb 
		GROUP BY PCODE 
		ORDER BY salesum DESC
	) sale
ON 	tp.pcode = sale.pcode
--AND total >= 100000    -- 오류 :실행 결과를 서브쿼리로 하는 select 필요 4)번
ORDER BY total DESC ;
-- 조회 내용 예시 : 상품별 판매 금액

-- 4) 3)번 결과로 다시 select 실행하기

WITH finalsale AS (   -- SELECT 결과를 finalsale 이름으로 저장.
			SELECT tp.pcode, tp.pname, tp.price*sale.salesum AS total
			FROM TBL_PRODUCT tp 
			JOIN 
				(
					SELECT PCODE, SUM(QUANTITY)  AS salesum 
					FROM TBL_BUY tb 
					GROUP BY PCODE 
					ORDER BY salesum DESC
				) sale
			ON 	tp.pcode = sale.pcode
			ORDER BY total DESC
)
select * from finalsale 
-- where rownum=1;     -- 판매금액 가장 높은 것
WHERE total > 100000 ; -- 판매금액 10만원 이상만 조회

-- 위의 SQL 쿼리(조회)와 같이 복잡한 구문은 가상 테이블로 저장해 놓고 사용합니다.(View 만들기)

-- 참고 : 집계 함수 서브쿼리 예제
-- step 1. 집계함수 결과 확인
select max(quantity)   -- 수량 최대값
				   from tbl_buy 
				   where pcode='JINRMn5';  -- 상품코드 조건

-- step 2.서브쿼리 사용 확인	
--  APLE5kg 상품을 가장 많이 구매한 고객ID			  
select custom_id  
from tbl_buy
WHERE quantity =  (select max(quantity) 
				   from tbl_buy 
				   where pcode='JINRMn5')
and pcode = 'JINRMn5';

-- 상품코드 검색값을 다른 것으로 바꿔서도 실행해 보세요. JINRMn5

--			=> JOIN 으로 바꿀 수 있을까요?

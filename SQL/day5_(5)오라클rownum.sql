/*
*		오라클 rownum 컬럼 : 조회결과 순서를 저장하는 메타데이터 컬럼
*				ㄴ 순위(RANK) 에 활용
*				ㄴ RANK 함수도 있습니다.
*/
SELECT *
FROM TBL_PRODUCT tp 
ORDER BY price DESC;

SELECT *
FROM TBL_PRODUCT tp;

-- 1) rownum 조회하기 
SELECT rownum , tp.*   -- rownum은 정렬하기 전의 행 순서값
FROM TBL_PRODUCT tp 
ORDER BY price DESC;

-- 2) 정렬 후의 rownum 을 부여

SELECT rownum, tpp.* 
FROM (
		SELECT *
		FROM TBL_PRODUCT tp 
		ORDER BY price DESC
	) tpp;

-- 3) 2)번 쿼리에 rownum 조건식 테스트
-- 정렬한 결과 1번째 행이 가장 높은 가격입니다. - 조회하기
SELECT rownum, tpp.* 
FROM (
		SELECT *
		FROM TBL_PRODUCT tp 
		ORDER BY price DESC
	) tpp
-- WHERE rownum =1;	     -- top 1
-- WHERE rownum <= 3;    -- top 3	
-- WHERE rownum = 2;   -- 조회 안됨
-- where rownum > 2 and rownum < 5; -- 조회 안됨
--WHERE rownum BETWEEN 2 AND 4; -- 조회 안됨. 

-- 결론 : rownum 메타데이터 컬럼이며 첫번째행부터 가져오는것만 가능하다.	
	
	
-- 4) 위의 조회안되는 조건을 해결하는 방법 -> rownum 을 일반 컬럼으로 바꾸기 위해 서브쿼리
SELECT *
FROM 
	(
		SELECT rownum r, tp.*		-- rownum 에 대한 별칭이 필요합니다.
		FROM (
			SELECT *
			FROM TBL_PRODUCT 
			ORDER BY PRICE DESC
	  		 ) tp
	)
WHERE 	
--		r BETWEEN 2 AND 4;	
--		r > 2 AND r < 5;
--		r = 2;



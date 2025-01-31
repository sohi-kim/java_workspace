-- 프로그래머스 문제 : 진료과별 총 예약횟수 출력하기
SELECT MCDP_CD as "진료과코드", count(*) as "5월예약건수"
from APPOINTMENT 
where to_char(APNT_YMD,'yyyy-mm') = '2022-05'
group by MCDP_CD
order by count(*) , MCDP_CD;
--   동명 동물 수 찾기
SELECT name,count(*) from animal_ins 
where name is not null
group by name having count(*) > =2 order by name;

/*
   서브 쿼리 (sub query) : 하나의 쿼리(주 쿼리)에 포함된 다른 쿼리 입니다.
   DML 명령어 insert, update,delete,select 의 조건식 검사에
   다른 쿼리를 실행한 결과로 주 쿼리를 실행합니다.

*/

-- 예시 1 : 성적 테이블의 평균 점수 값보다 큰 점수들을 모두 조회하기
--				ㄴ 평균 구하기
SELECT avg(jumsu) FROM tbl_score;
--				ㄴ 성적 테이블의 점수와 평균을 비교.

-- 1) with 구문 : 서브쿼리 사용하지 않는 방법. 
WITH temp AS  (    -- temp 이름 변수에 저장.
	SELECT avg(jumsu) AS avgjumsu FROM tbl_score
)
SELECT * FROM tbl_score WHERE JUMSU >= 
					(SELECT avgjumsu  FROM temp);


-- 2) 서브쿼리 사용하는 방법
SELECT * 
FROM tbl_score 
WHERE JUMSU >= (SELECT avg(jumsu) AS avgjumsu FROM tbl_score);

-- 예시 2: 국어과목을 수강한 학생의 이름을 조회하기
--         ㄴ 성적테이블에서 국어과목을 수강한 학번 조회
SELECT * FROM TBL_SCORE WHERE SUBJECT = '국어';
--		   ㄴ 위에 조회된 값으로 학생 테이블에서 조회하기

SELECT NAME  FROM TBL_STUDENT 
--		 WHERE stuno IN ('2021001','2019019','2020017');
	WHERE stuno IN 
		(SELECT STUNO  FROM TBL_SCORE WHERE SUBJECT = '국어');
	
-- 서브 쿼리는 조회 성능에 나쁜 영향을 줄 수 있습니다.
--       ㄴ WITH , 조인 으로 더 나은 성능을 갖도록 sql 을 작성할 수 있습니다.

	
-- 프로그래머스 문제 : 카테고리 별 상품 개수 구하기
/*
select CATEGORY , count(*) as PRODUCTS
from 
(SELECT substr(PRODUCT_CODE,1,2)   
            as CATEGORY
    from PRODUCT)
group by CATEGORY
order by CATEGORY;
 */	
	
	

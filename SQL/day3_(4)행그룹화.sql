/*
 * 		특정 컬럼 값이 동일한 행들을 그룹으로 묶고
 *      집계 함수를 그룹단위로 결과값을 조회 할 수 있습니다.
 *      기본키, 유니크(값의 고유성) 컬럼은 그룹화 의미 없습니다. 
 * 
 * 		select 
 * 	    from
 *      [where]
 *      group by  컬럼명    -- 지정된 컬럼의 값으로 그룹화
 *      order by  컬럼명
 */

SELECT * FROM TBL_SCORE ts 

-- 동일한 값이 많은 컬럼으로 정렬
SELECT * FROM TBL_SCORE ORDER BY STUNO ;
SELECT * FROM TBL_SCORE ORDER BY SUBJECT ;
SELECT * FROM TBL_SCORE ORDER BY TEACHER  ;
SELECT * FROM TBL_SCORE ORDER BY TERM  ;

-- 학생별 수강과목수
SELECT STUNO , count(*) AS "수강과목수"   -- AS 별칭부여
FROM TBL_SCORE 
GROUP BY STUNO ;

-- 과목별 수강인원수
SELECT SUBJECT , count(*) AS "수강인원"
FROM TBL_SCORE 
GROUP BY SUBJECT;

-- 교사별 수강인원수
SELECT TEACHER , count(*) AS "수강인원"
FROM TBL_SCORE 
GROUP BY TEACHER;

-- 학기별 수강인원수
SELECT TERM , count(*) AS "수강인원"
FROM TBL_SCORE 
GROUP BY TERM
ORDER BY "수강인원";

--
SELECT * FROM TBL_SCORE ts ;


-- (1) 점수 80점 이상인 행에 대해 과목별 평균구하기
SELECT SUBJECT, count(*) , avg(jumsu)
FROM TBL_SCORE ts 
WHERE JUMSU >=80      -- 조건식 일치하는 행 추출 후,
GROUP BY SUBJECT;     -- 그룹화

-- (2) 과목별 평균
SELECT SUBJECT, count(*) , avg(jumsu)
FROM TBL_SCORE ts 
GROUP BY SUBJECT ;

-- (3) 위의 결과에서 평균이 85점 이상인 과목 조회하기 -(1)번과 다른점은?
SELECT SUBJECT, count(*) , avg(jumsu) AS "과목별평균점수"
FROM TBL_SCORE ts 
GROUP BY SUBJECT             -- 그룹화 후,
HAVING avg(jumsu) >= 85;     -- 그룹화 결과에 대한 조건으로 조회

-- (4) 정렬
SELECT SUBJECT, count(*) , avg(jumsu) AS "과목별평균점수"
FROM TBL_SCORE ts 
GROUP BY SUBJECT             -- 그룹화 후,
HAVING avg(jumsu) >= 85    -- 별칭 사용 못함(오류)
ORDER BY "과목별평균점수" DESC;  -- 별칭 사용 가능

-- 2과목이상 점수가 있는 학생의 학번, 과목수, 평균점수(소수점 2자리로 반올림) 를 구해주세요.
-- 정렬은 학번순으로 합니다.
SELECT STUNO , count(*) ,round(avg(jumsu),2) 
FROM TBL_SCORE ts 
GROUP BY STUNO 
HAVING count(*) > =2;

SELECT * FROM TBL_SCORE ts ;

-- 국어 과목에 대해서만 학기별(term)로 그룹화. -> 학기, 수강인원수, 평균점수 조회 
-- where 또는 having ? where 가 더 쉽습니다.

SELECT term , count(*) ,round(avg(jumsu),2)
FROM TBL_SCORE ts 
WHERE SUBJECT = '국어'
group BY term;






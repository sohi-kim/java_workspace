SELECT count(*)
FROM BIKE_RENT br 
WHERE AREA1 LIKE '%구로%';


SELECT regexp_substr(area1,'[가-힣]+구',1,1) AS gu   -- 정규표현식으로 문자열 추출. xxxx구
	FROM BIKE_RENT br;

SELECT gu, count(*) AS count
FROM 
	(
	SELECT regexp_substr(area1,'[가-힣]+구',1,1) AS gu   -- 정규표현식으로 문자열 추출. xxxx구
	FROM BIKE_RENT br
	)
GROUP BY gu
ORDER BY count desc;

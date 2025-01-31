
-- 
WITH agg_year AS 
(
SELECT to_char(tb.BUY_DATE,'yyyy') AS "BYEAR", tb.pcode, count(*) AS "COUNT"
FROM TBL_PRODUCT tp 
JOIN TBL_BUY tb 
ON tp.PCODE = tb.PCODE 
GROUP BY to_char(tb.BUY_DATE,'yyyy'), tb.pcode
ORDER BY "BYEAR", tb.pcode
)
SELECT ay.byear, ay.pcode, max(ay.count)
FROM agg_year ay
GROUP BY ay.byear, ay.pcode;


WITH agg_pcode AS 
(
SELECT tb.pcode, count(*) AS "COUNT"
FROM TBL_PRODUCT tp 
JOIN TBL_BUY tb 
ON tp.PCODE = tb.PCODE 
GROUP BY tb.pcode
ORDER BY tb.pcode
)
SELECT ap.pcode, max(ap.count)
FROM agg_pcode ap
GROUP BY ap.pcode;



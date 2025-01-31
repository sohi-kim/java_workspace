/*
 * 조건에 부합하는 중고거래 댓글조회 : to_char 함수와 JOIN
   즐겨찾기가 가장많은 식당 정보 출력 : 집계함수 max와 JOIN
 */ 

-- 즐겨찾기가 가장많은 식당 정보 출력
select ri.FOOD_TYPE, REST_ID, REST_NAME, ri.FAVORITES
from REST_INFO ri
join 
(
    SELECT FOOD_TYPE ,Max(FAVORITES) as FAVORITES
    from REST_INFO 
    group by FOOD_TYPE
) foodfav
on ri.FOOD_TYPE = foodfav.FOOD_TYPE
and ri.FAVORITES = foodfav.FAVORITES
order by ri.FOOD_TYPE desc;

SELECT TITLE, 
       ugb.BOARD_ID , 
       REPLY_ID, 
       ugr.WRITER_ID, 
       ugr.CONTENTS,
       to_char(ugr.CREATED_DATE,'yyyy-mm-dd') as CREATED_DATE
FROM USED_GOODS_BOARD ugb
JOIN USED_GOODS_REPLY ugr
ON ugb.BOARD_ID = ugr.BOARD_ID
WHERE to_char(ugb.CREATED_DATE,'yyyy-mm')='2022-10'
order by ugr.CREATED_DATE, TITLE ;
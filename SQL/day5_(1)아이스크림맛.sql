/*
 *  day5 (수업 날짜 : 1월 21일 오전)
 *  프로그래머스 : 과일로 만든 아이스크림 고르기
 *  	      ㄴ 테이블 2개 만들고 데이터 추가 후 조인
 * 			  ㄴ 제약 조건은 not null 만 하시고, PK와 FK 없이 하세요.
 */
SELECT fh.FLAVOR 
FROM FIRST_HALF fh 
JOIN ICECREAM_INFO ii 
ON fh.FLAVOR = ii.FLAVOR 
AND fh.TOTAL_ORDER > 3000
AND ii.INGREDIENT_TYPE = 'fruit_based'
ORDER BY TOTAL_ORDER DESC;



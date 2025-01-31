
-- 키워드로 상품검색 SQL

SELECT * 
FROM TBL_PRODUCT tp 
WHERE 
	PNAME LIKE '%라면%';
	
SELECT * 
FROM TBL_PRODUCT tp 
WHERE 
	PNAME LIKE '%' || '참치' || '%';
	
-- // 예제를 위해 우편번호 추가

insert into tbl_postcode values ('08301', '서울특별시 구로구 가마산로25길 9-24 (구로동, 구로구의회)');
insert into tbl_postcode values ('08299', '서울특별시 구로구 구로중앙로28길 66 (구로동, 구로5동 주민센터, 구로구보건소)');
insert into tbl_postcode values ('08286', '서울특별시 구로구 벚꽃로72길 32 (구로동, 서울아트빌)');
insert into tbl_postcode values ('08268', '서울특별시 구로구 경인로19길 39 (오류동, 서울오류초등학교)');

SELECT * FROM TBL_POSTCODE tp ;

-- 'wonder' 구매한 목록을 조회하기.구매날짜 내림차순 정렬
SELECT *
FROM TBL_BUY tb 
WHERE CUSTOM_ID ='wonder'
ORDER BY BUY_DATE DESC;

-- join 을 이용한 특정 고객의 구매 목록 조회. 상품 정보(상품명,가격,카테고리 등) 포함
SELECT PNAME ,PRICE ,quantity, buy_date ,CATEGORY 
FROM TBL_PRODUCT tp 
JOIN TBL_BUY tb 
ON tp.PCODE = tb.PCODE
WHERE CUSTOM_ID ='wonder'
ORDER BY BUY_DATE DESC;















-- 고객 테이블
CREATE TABLE tbl_customer (
	custom_id varchar2(20) PRIMARY KEY ,   -- 최대 20바이트 
	name nvarchar2(20) NOT NULL,		   -- 최대 20개 문자
	email varchar2(30),
	age number(3) ,		
	reg_date timestamp 
);

-- 상품 테이블 : 
CREATE TABLE tbl_product(
	pcode varchar2(20) PRIMARY KEY ,
	category char(2) ,
	pname nvarchar2(20) NOT NULL,
	price number(9) NOT NULL 
);

-- 구매테이블
-- 	  구매가 발생시 custom_id 와 pcode로 기본키를 만들 수 있을까요? -> 없다.
--    회원의 동일 상품 구매는 여러 번 가능하다.
CREATE TABLE tbl_buy(
	buy_seq number(8) PRIMARY KEY ,		-- 구매 번호(순차적으로 부여하는 식별값)
	custom_id varchar2(20) NOT NULL ,			
	pcode varchar2(20) NOT NULL ,
	quantity number(5) NOT NULL ,		--수량
	buy_date timestamp,
	FOREIGN KEY (custom_id)				-- 이 테이블의 외래키 컬럼
			REFERENCES tbl_customer(custom_id),	-- 참조하는 테이블과 컬럼명
	FOREIGN KEY (pcode)
			REFERENCES tbl_product(pcode)
);

-- 초기화를 위한 테이블 삭제
DROP TABLE tbl_buy; DROP TABLE tbl_customer ; DROP TABLE tbl_product;  

CREATE SEQUENCE tbl_buy_seq START WITH 2001;
DROP SEQUENCE tbl_buy_seq;   -- 초기화 필요할 때


-- 고객 테이블 데이터 추가
INSERT INTO 
	TBL_CUSTOMER 
VALUES
	('mina012', 
	 '김미나', 
	 'kimm@gmail.com', 
	 20, 
--	  '2024-03-10 14:23:25'	-- 시:분:초 포함된 문자열은 자동 변환이 안됩니다.오류!!!
	  to_date('2024-03-10 14:23:25',
	       'yyyy-mm-dd hh24:mi:ss')   
	       -- 함수로 문자열에서 날짜형식 변환. 문자열의 패턴이 필요.
	);
INSERT INTO TBL_CUSTOMER 
VALUES ('hongGD', '홍길동', 'gil@korea.com', 32, to_date('2023-10-21 11:12:23','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO TBL_CUSTOMER 
VALUES ( 'twice', '박모모', 'momo@daum.net', 29, to_date('2023-12-25 19:23:45','yyyy-mm-dd hh24:mi:ss'));
-- age 가 널값인 데이터
INSERT INTO TBL_CUSTOMER (custom_id,name,email,reg_date)
VALUES ('wonder', 
		'이나나', 
		'lee@naver.com',
		to_date('2024-12-31 23:58:59','yyyy-mm-dd hh24:mi:ss'));

SELECT * FROM TBL_CUSTOMER tc ;
	
-- 상품 테이블 데이터 추가
INSERT INTO TBL_PRODUCT  
VALUES ('DOWON123a', 'B2', '동원참치선물세트', 54000);
INSERT INTO TBL_PRODUCT  
VALUES ('CJBAb12g', 'B1', '햇반 12개입', 14500);
INSERT INTO TBL_PRODUCT  
VALUES ('JINRMn5', 'B1', '진라면 5개입', 6350);
INSERT INTO TBL_PRODUCT  
VALUES ('APLE5kg', 'A1', '청송사과 5kg', 66000);
INSERT INTO TBL_PRODUCT  
VALUES ('MANGOTK4r', 'A2', '애플망고 1kg', 32000);

SELECT * FROM TBL_PRODUCT ;

-- 구매 테이블 데이터 추가
--    쇼핑몰 기본 요구사항 : 예를 들면 hongGD  회원은 DOWON123a 상품을 여러번 구매 가능
--	  기본키를 위해 새로운 컬럼 buy_seq 을 추가합니다.
INSERT INTO TBL_BUY 
VALUES 
(tbl_buy_seq.nextval, 
'mina012' , 'CJBAb12g' , 5,to_date('2023-07-15 14:33:15','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO TBL_BUY 
VALUES 
(tbl_buy_seq.nextval, 
'mina012' , 'APLE5kg' , 2,to_date('2023-11-10 14:33:15','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO TBL_BUY 
VALUES (tbl_buy_seq.nextval, 
'mina012' , 'JINRMn5' , 2,to_date('2023-12-09 14:33:15','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO TBL_BUY 
VALUES (tbl_buy_seq.nextval, 
'twice' , 'JINRMn5' , 3 ,to_date('2023-12-21 14:33:15','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO TBL_BUY 
VALUES (tbl_buy_seq.nextval, 
'twice' , 'MANGOTK4r' , 2 ,to_date('2024-01-10 14:33:15','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO TBL_BUY 
VALUES (tbl_buy_seq.nextval, 
'hongGD' , 'DOWON123a' , 1 ,to_date('2024-01-13 14:33:15','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO TBL_BUY 
VALUES (tbl_buy_seq.nextval,  
'hongGD' , 'APLE5kg' , 1 ,to_date('2023-09-09 14:33:15','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO TBL_BUY 
VALUES (tbl_buy_seq.nextval, 
'hongGD' , 'DOWON123a' , 1 ,to_date('2025-01-13 09:33:15','yyyy-mm-dd hh24:mi:ss'));
SELECT * FROM TBL_BUY tb ;



/*
	day4_문제.pdf 파일의 3) 번부터
*/

CREATE TABLE tbl_postcode (
	postcode char(5) PRIMARY KEY ,
	area1 varchar2(200) NOT NULL 
);

-- 4)
ALTER TABLE TBL_CUSTOMER ADD postcode char(5);

-- 5)
ALTER TABLE TBL_CUSTOMER 
	ADD CONSTRAINT  tbl_customer_fk
	FOREIGN KEY (postcode)
	REFERENCES tbl_postcode (postcode);
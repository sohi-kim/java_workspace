/*
 *  뷰(view) 만들기 : create view 
 * 		- 가상 테이블
 * 		- 자주 사용하는 select 조회 결과를 미리 컴파일하여 오라클 뷰 객체로 저장
 * 		- 저장된 뷰는 select 조회 할 때 테이블처럼 모든 형식을 적용 
 * 		- 주로 join 등 복잡한 SQL 을 뷰로 만들어서 사용합니다.
 * 		- with 임시이름 as (select 쿼리) 은 영구 저장이 아닙니다.
 * 		- 가상 테이블이므로 insert, update, delete 제약이 많고 사용을 권하지 않음.
 * 
 *  뷰 생성 권한이 있어야 create view 실행 가능합니다.
 * 		- grant create view to c##idev;
 * 		- 권한 추가 후 디비버는 재연결 실행
 */
-- 뷰를 비롯하여 함수,프로시저,트리거 오라클 객체는 create or replace
CREATE OR REPLACE VIEW v_finalsale
AS
	SELECT tp.pcode, tp.pname, tp.price*sale.salesum AS total
			FROM TBL_PRODUCT tp 
			JOIN 
				(
					SELECT PCODE, SUM(QUANTITY)  AS salesum 
					FROM TBL_BUY tb 
					GROUP BY PCODE 
					ORDER BY salesum DESC
				) sale
			ON 	tp.pcode = sale.pcode
			ORDER BY total DESC;
			
SELECT * FROM v_finalsale;		
SELECT * FROM V_FINALSALE vf 
WHERE rownum =1;
SELECT * FROM V_FINALSALE vf 
WHERE TOTAL  >= 100000;

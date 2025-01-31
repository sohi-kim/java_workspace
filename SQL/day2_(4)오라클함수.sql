-- from dual : 수식 또는 함수 실행하여 결과값 출력하는 임시테이블
SELECT 3+5 FROM dual;

---  // 데이터 타입 : 날짜, 수치, 문자열 관련 함수 //

-- 1. 날짜 함수 : to_char (날짜형식을 문자열로 변환) 와 to_date (문자열을 날짜형식으로 변환)
SELECT SYSDATE, SYSTIMESTAMP FROM dual;	-- systimestamp 는 표준시와의 시차(타임존) 표시
SELECT to_char(SYSDATE,'yyyy"년"') FROM dual;
SELECT to_char(SYSDATE,'mm"월"') FROM dual;
SELECT to_char(SYSDATE,'dd"일"') FROM dual;
SELECT to_char(SYSDATE,'yyyy"년" mm"월" dd"일"') FROM dual;
SELECT to_char(SYSDATE,'yyyy* mm* dd' ) FROM dual;

SELECT to_char(SYSDATE,'yyyy-mm-dd hh24:mi:ss') FROM dual;
SELECT to_char(SYSDATE,'yyyy-mm-dd hh:mi:ss am') FROM dual;

-- yyyy-mm-dd hh24:mi:ss   24시간 기준 
-- yyyy-mm-dd hh:mi:ss am   12시간 기준 (am 대신에 pm 도 가능)


-- `월` 관련 함수 
SELECT ADD_MONTHS(SYSDATE,3)     --오늘날짜  3개월 이후. 첫번째 인자는 날짜 형식. 두번째 더해지는 값
		FROM dual ;

SELECT 
TO_CHAR(ADD_MONTHS(SYSDATE,3),'YYYY/MM/DD')   -- 문자열패턴 기호 - 또는 / 또는 구분기호없음가능
		FROM dual ;

-- 날짜 사이의 간격
	-- 개월
SELECT MONTHS_BETWEEN(SYSDATE  , -- 지정된 2개의 날짜 사이에 간격(월).결과는 소수점
		TO_DATE('2024-09-23')) FROM dual ;
	-- 일
SELECT TRUNC(SYSDATE) FROM dual;   -- truncate(잘라내다)	
SELECT TRUNC(SYSDATE)-TO_DATE('20240923', 'YYYYMMDD') -- 2개의 날짜형식 값 간격(일)
		FROM DUAL;    -- 2개의 날짜의 간격(일) . TRUNC(SYSDATE)는 일(day)까지로 변환

SELECT SYSDATE-TO_DATE('20240923', 'YYYYMMDD') -- 시간을 포함한 계산. 소수점 결과
		FROM DUAL;     

-- 2. 숫자 함수(정수 또는 실수 number를 대상으로 하는 함수)
-- abs(n) : 절대값
-- (1) 결과값 소수점 있는 실수	
-- trunc(숫자,자리수) : 소수점 이하 자리수 맞추기 위해서 버림   3.177567  -> 3.17
SELECT trunc(3.177567,2) FROM dual;

-- round(숫자,자리수) :                  반올림  3.177567 -> 3.18
SELECT round(3.177567,2) FROM dual; 
SELECT round(3.177567,0) FROM dual;    -- 소수점 자리수 0 -> 정수 
SELECT round(3.577567,0) FROM dual;

-- (2) 결과값 정수
-- ceil(숫자) : 실수를 `정수`로 올림으로 변환.   ceil:천장
SELECT ceil(3.177567) FROM dual;		-- 결과값 : 4

-- floor(숫자) : 실수를 `정수`로 내림으로 변환.  floor : 바닥
SELECT floor(3.177567) FROM dual;		-- 결과값 : 3


-- 3. 문자열 함수
SELECT INITCAP('hello')			-- 예상 : Hello 
				FROM dual;   -- initail capital  : 첫번째 대문자 
SELECT UPPER('hello') FROM dual; 	-- 대문자로 변환 . HELLO
SELECT LOWER('OraCle') FROM dual; 	-- 소문자로 변환.  oracle
SELECT LENGTH('oracle') FROM dual;   -- 문자열 길이. 6
SELECT SUBSTR('java program',3,5)   	-- 부분 추출(문자열,위치,길이) 결과 : 
			FROM dual;	  			-- *오라클에서 문자열 위치 인덱스는 1부터 시작.*	
SELECT SUBSTR('java program',-5,3)		-- 부분 추출 결과 : 위치음수이면 뒤에서부터 . 문자열 뒤에서부터 5번째 3개
			FROM dual;
SELECT REPLACE('java program','pro','프로')		--문자열 바꾸기. java 프로gram
			FROM dual;
SELECT instr('java program','og')		-- 자바의 indexOf 
			FROM dual;	--결과 8. 해당 문자열이 없으면 결과 0 
SELECT trim(' java program   ')				-- 공백(불필요한 앞뒤 공백)제거
			FROM dual;
SELECT LENGTH(' java program   ') FROM dual;		-- 공백포함 16
SELECT LENGTH(trim(' java program   ')) FROM dual;  -- 공백제거 후에는 12


-- 프로그래머스 문제
-- 		- 평균 일일 대여 요금 구하기
--		- 특정 옵션이 포함된 자동차 리스트 구하기
		/*
		 * 
		 * 
		 */
--		- 자동차 대여 기록에서 장기/단기 대여 구분하기
		/*
		 *
		SELECT HISTORY_ID, 
		      CAR_ID, 
		      to_char(START_DATE,'yyyy-mm-dd'), 
		      to_char(END_DATE,'yyyy-mm-dd'),
		      CASE
		         WHEN (END_DATE - START_DATE+1) >= 30 THEN '장기 대여' ELSE '단기 대여' 
		      END as RENT_TYPE
		from CAR_RENTAL_COMPANY_RENTAL_HISTORY
		where 
		-- 시작일이 2022년 9월
		   to_char(start_date, 'yyyy-mm') = '2022-09'
		order by HISTORY_ID desc;
		 * 
		 * 
		 * 
		 */











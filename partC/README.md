### 컬렉션 (Collection)

- 자바의 컬렉션은 데이터를 저장하고 처리하기 위한 구조 입니다.
- 대표적인 기능 저장, 추가,삭제,검색 등을 메소드로 지원합니다.

- 인터페이스 정의
  + Collection : List와 Set 의 부모 인터페이스
    + List  : 순서(인덱스)가 있는 방식으로 저장합니다.
    + Set   : 집합. 순서가 없습니다. 동일한 값은 중복없이 한번만 저장.
    + Map   : Key, Value 가 한쌍의 값으로 저장. Key 값은 Set 과 같은 특징

- 클래스
  + Collections : 컬렉션 구현객체를 대상으로하는 static 메소드를 제공합니다.
    - 예시 : Collections.sort(리스트)
  + List 를 구현한 클래스 : ArrayList, LinkedList
  + Set 을 구현한 클래스 : HashSet, TreeSet
  + Map을 구현 클래스  : HashMap, TreeMap

### 예외 (Exception)

- 프로그램 실행 중 발생하는 비정상적인 상황

- 클래스 구조

  java.lang.Throwable 클래스
              ㄴ Error : 에러. 일반적이지 않은 치명적인 상황
              ㄴ Exception : 예외
                      ㄴ 실행 중에 발생하는 RuntimeException 
                      ㄴ 컴파일이 반드시 처리하도록 하는 체크 익셉션이 여러가지 있습니다.
                      (대표적인 것이 IOException)
                      ㄴ 그 외에 많은 자식 클래스 들이 정의되어 있습니다.

- 예외 처리 방법 
 + try ~ catch
 + throws

- 예외 발생하기 : 
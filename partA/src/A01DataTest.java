public class A01DataTest {

  public static void main(String[] args) {
    
    //1. 데이터 저장

    int myage = 23;
    double weight = 60.23;
    boolean isAdult;
    char loc_code = 'A';    //지역코드 ( _ 기호 snake 표기법)

    //2. 출력 (확인)
    System.out.println("나이="+myage);
    System.out.println("몸무게="+weight);
    System.out.println("지역코드="+loc_code);

    // System.out.println("성인 인증 = " + isAdult);   //초기화 안된 변수는 오류
  
    isAdult = true;
    System.out.println("성인 인증 = " + isAdult);

    isAdult = myage >=20;    // 관계식 실행 후 대입
    System.out.println("성인 인증 = " + isAdult);

    myage = 15;
    isAdult = myage >=20;    // 관계식 실행 후 대입
    System.out.println("성인 인증 = " + isAdult);    // 예상값 : false

    String message;
    // 자바에서 문자열 기호는 오직 큰 따옴표입니다.
    message = isAdult ? "성인입니다.":"미성년 입니다.";
    // 조건식 ?  조건식 참일 때 값(수식) : 조건식 거짓일 때 값(수식) 
    System.out.println("메세지 = " + message);

  }
  
}

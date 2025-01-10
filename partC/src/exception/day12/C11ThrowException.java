package exception.day12;

// 예외 발생하기
public class C11ThrowException {


  public static void main(String[] args) throws Exception  {

    // 예외 처리 방법 1
    try {
      new C11ThrowException().checkAge(23);
      new C11ThrowException().checkAge(13);
    
    }catch(Exception e) {
      System.out.println("예외 : " + e.getMessage());
    }

    // 예외 처리 방법 2
    new C11ThrowException().checkAge(11);


    System.out.println("프로그램 종료합니다.");
  }

  public void checkAge(int age) throws Exception{   // 체크 익셉션 메소드로 정의
    // 예시 : 성인 나이 값으로 20세 미만은 예외 발생하기
    if(age < 20){
      // 비정상적인 값이므로 예외 발생 : 클래스는 IllegalArgumentException , Exception 등
      //      내용에 맞는 것으로 선택합니다.
      throw new IllegalArgumentException("잘못된 나이 입력값입니다.");
    }else {
      System.out.println("정상적인 age 값 입니다.");
    }
  }
}
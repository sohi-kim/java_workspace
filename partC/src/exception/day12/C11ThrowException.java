package exception.day12;

// 예외 발생하기
public class C11ThrowException {


  public static void main(String[] args) throws IllegalAgeException  {

    // 예외 처리 방법 1
    try {
      new C11ThrowException().checkAge(23);
      new C11ThrowException().checkAge(13);
      
    }catch(Exception e) {
      System.out.println("예외 : " + e.getMessage());
    }

    // 예외 처리 방법 2 : throws 로 해결
    new C11ThrowException().checkAge(11);
    // jvm 으로 익셉션 처리를 위임. -> jvm 은 오류메시지 출력 -> 기본 동작
    // main 에서는 try~ catch 로 프로그램 내에서 처리되도록 합니다.

    System.out.println("프로그램 종료합니다.");
  }

  // 메소드의 throws 하는 예외는 RuntimeException (언체크 익셉션) 은 적용이 안됩니다.
  public void checkAge(int age) throws IllegalAgeException{   // 체크 익셉션 메소드로 정의
    // 예시 : 성인 나이 값으로 20세 미만은 예외 발생하기
    if(age < 20){
      // 비정상적인 값이므로 예외 발생 : 새로운 익셉션으로 예외 발생
      throw new IllegalAgeException("잘못된 나이 입력값입니다.");
    }else {
      System.out.println("정상적인 age 값 입니다.");
    }
  }
}
// 새로운 Exception 을 정의
class IllegalAgeException extends Exception {

  // 커스텀 생성자 재정의 : 메세지 설정
  IllegalAgeException(String message){
      super(message);
  }
}
package object.day9_interface;

// CharSequence : 자바에서 제공하는 인터페이스 입니다.
public class B27CharSequenceTest {

  public static void main(String[] args) {
    
    // 문자열 생성 방법
    String astr = "Hello Hi~";    // 불변객체 문자열
    String bstr = new String("Good bye~");
    StringBuilder sb = new StringBuilder("하이 Hello~");

    // 문자열에 contains 메소드 실행해보기
    boolean result = "자바 Hello, 파이썬 hi ~".contains("hi");
    System.out.println("결과 : " + result);    // 참

    System.out.println("자바 Hello, 파이썬 hi ~".contains(astr));
    System.out.println("자바 Hello, 파이썬 hi ~".contains(bstr));
    System.out.println("자바 Hello, 파이썬 hi ~".contains(sb));

    // contains 메소드의 인자 타입은 CharSequence 인터페이스 타입
    //              ㄴ String, StringBuilder 는 CharSequence 타입.
  }

}

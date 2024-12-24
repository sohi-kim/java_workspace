package basic.day01;

// 메소드는 함수와 같은 리턴값, 인자 등을 갖고 있습니다.
//          함수와 다른 점은 '객체 또는 클래스의 구성요소'라는 것입니다.
public class A03MethodTest {

  public static void main(String[] args) {
      System.out.println("main 메소드 실행 중입니다.");
      // 다른 메소드 실행(호출)
      hello();
      say("하이하이");
     // say(100);    //오류 : 인자의 데이터 타입 불일치

     // 리턴값이 있는 메소드는 변수에 저장합니다.
      int result = multiply(123, 999);
      System.out.println("multiply(123, 999) =" + result);
      System.out.println("multiply(99999, 56789) =" + multiply(99999, 56789));
      //                  ㄴ //계산기는 5,678,843,211  결과는 1,383,875,915
      //                  ㄴ  리턴 타입이 int 이므로 오버플로우 발생. 정확한 값 아님
      
      result = multiply(99999, 56789);
      System.out.println("multiply(99999, 56789) =" + result);
      //                  ㄴ 변수에 저장할 때에도 같은
      System.out.println("multiplyLong(99999, 56789) =" + multiplyLong(99999, 56789));
      System.out.println("main 메소드 종료!!");
  }

  // 리턴값이 없는 메소드 void
  public static void hello(){
      System.out.println("hello 메소드 실행 중입니다.");
      System.out.println("hello ~~~~~");
      System.out.println("hello 메소드 종료!!");
  }

  // 인자를 갖는 메소드
  public static void say(String message ){
      System.out.println("say 메소드 실행 중입니다.");
      System.out.println("say ~~~~~" +message);
      System.out.println("say 메소드 종료!!");
  }

  // 리턴값, 인자를 갖는 메소드 : 두 개의 정수를 전달 받아서 곱하기 결과를 리턴한다.
  public static int multiply(int x , int y){
    System.out.println("두 개의 정수를 곱하는 메소드 multiply 실행 중");
    return x*y;
  }

  // 메소드 이름 multiplyLong 은 리턴 타입이 long 으로 변경해서 테스트 해보세요.
  public static long multiplyLong(int x , int y){
    System.out.println("두 개의 정수를 곱하는 메소드 multiply 실행 중");
    
    //int 정수 * int 정수 는 결과도 int 정수 형식. => x,y 둘 중 하나를 long 변경

    return (long)x*y;    //x를 long 으로 형변환
  }

}

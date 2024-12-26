package basic.day02;

import basic.day01.A04Quiz;

// 다른 클래스에서 정의된 메소드 사용 예시
// 1) 같은 패키지 클래스 여부 : 다른 패키지 클래스는 import 해서 가져옵니다.
// 2) private 메소드 여부 : private 메소드는 사용 못함.
public class A07ClassTest {

  public static void main(String[] args) {
      // 클래스 이름.메소드 => static 메소드 사용 형식
      int dollar = A04Quiz.dollarToWon(1000000, 1400);
      System.out.println("환전된 금액 : " + dollar + " 원");

      printQuiz();
      
      // private 메소드 호출하기
      // A04Quiz.printQuiz();     //오류. A04Quiz 클래스에서만 사용하는 메소드

  // 자바 jdk 의 클래스들 중에는 java.lang 패키지만 import 없이 사용합니다.
  }  // main end

    // 자신의 클래스 메소드 호출은 메소드 이름만 사용. 
    private static void printQuiz(){
      System.out.println("자바 둘째날 연습 메소드");
    }


}

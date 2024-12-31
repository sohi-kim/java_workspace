package object.day5;

// 자바의 Math 클래스처럼 static 한 구성을 갖도록 정의

public class MyStaticMath {

    // String message;     // 인스턴스 변수
    public static int addValue(int a, int b){
      // message = "hello";   // static 메소드에서 인스턴스 변수 접근 못함. 오류.
      // static 메소드는 실행에 필요한 값을 실행(호출)할 때 전달 받습니다.
      return a+ b;
    }

    public static int substractValue(int a, int b){
      return a-b;
    }

    public static int max(int a, int b){

      return substractValue(a, b) > 0 ? a:b;    // a > b ? a:b;
    }

    public static int min(int a, int b){
      return substractValue(a, b) > 0 ? b: a;   // a > b ? b:a;
    }


}

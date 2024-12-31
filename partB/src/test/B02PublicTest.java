package test;

// 다른 패키지의 클래스는 import 해야 합니다.
import object.day5.MyClass1;

public class B02PublicTest {

  public static void main(String[] args) {
    // 다른 패키지의 클래스는 
    // public 권한의 클래스만 사용 가능
    MyClass1 cls1 = new MyClass1();
    // MyClass2 cls2 = new MyClass2();  // 오류

    // cls1.field1 = "23";    // 오류. filed1 변수는 default 권한

    // public 권한 변수 출력
    System.out.println(MyClass1.TEST_VALUE);
  }

  // 클래스, 메소드, 변수의 접근 권한 : public , default, private


}

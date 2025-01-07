package object.day9_interface;

import java.util.ArrayList;
import java.util.List;

public class B26InterfaceTest {
   public static void main(String[] args) {
      InterfaceA ia = new TestA();    // 인터페이스 타입으로 참조
      InterfaceB ib = new TestB();

      //TestAB 가 구현한 2개의 인터페이스 타입으로 참조 가능
      InterfaceA iab1 = new TestAB();
      InterfaceB iab2 = new TestAB();

      ia.testA("ia 변수");
      ib.methodOfBB("메소드 구현하기");

      iab1.testA("iab1 변수");
      //iab1.methodOfBB("아무거나");    // 오류. InterfaceB 의 메소드
      iab2.methodOfBB("메소드 구현하기22");
      //iab2.testA("iab2 변수");      // 오류. InterfaceA 의 메소드

      List<String> names = new ArrayList<>();
//    List 는 인터페이스, ArrayList 는 List 를 구현한 클래스

      InterfaceA[] arr = new InterfaceA[5];
      // 이 배열에 참조할 수 있는 변수는 ? ia, ib, iab1, iab2
      arr[0]= ia;
      // arr[1]= ib;   //오류
      arr[2]= iab1;
      // arr[3]= iab2; // 오류
      arr[4]= (InterfaceA)iab2;    // iab2 만 캐스팅 가능.


   }

}

// 인터페이스는 바로 객체 생성이 되지 않습니다.
// 인터페이스는 사용(구현)하는 클래스로 객체가 생성됩니다.
class  TestA implements InterfaceA {
   
     @Override
     public void testA(String message) {
        System.out.println("TestA 에서 구현 했습니다. " + message);
     }
}

class TestB implements InterfaceB {

    @Override
    public int methodOfB() {
      return 999;
    }

    @Override
    public void methodOfBB(String task) {
        System.out.println("task : " + task);
    }
}

class TestAB implements InterfaceA, InterfaceB {
    @Override
    public void testA(String message) {
      System.out.println("TestAB 에서 구현 했습니다. " + message);
    }

    @Override
    public int methodOfB() {
      return 9999;
    }

    @Override
    public void methodOfBB(String task) {
        System.out.println("taskAB: " + task);
    }
}
package object.day10;

import object.day9_interface.InterfaceA;

// 익명 클래스는 ? class 를 별도로 정의하지 않은 이름이 없는 클래스
//         객체 사용할 때 메소드 재정의하여 객체 생성
public class B31AnonymousTest {

  public static void main(String[] args) {
    
    // 일반 클래스의 메소드 재정의 (거의 사용안함)
     //   ㄴ 익명 클래스에서 필요시 메소드 재정의
    Shape shape = new Shape()
    {
      @Override
      public long area() {
        return 100;
      }

      @Override
      public long length() {
        return 999;
      }
    };

    // 요약 :" 익명 클래스는 추상클래스 또는 인터페이스로 만듭니다." Shape 과 같은 일반 클래스로
    //        만드는 경우는 거의 없습니다.
    // 추상 클래스의 메소드 재정의
    //   ㄴ 익명 클래스에서 모든 추상 메소드 재정의 필수
    AbstractAnimal animal = new AbstractAnimal(null, null) {
      @Override 
      public void sound() {   }

      @Override
      public boolean isFly() { return false;  }

      @Override
      public String todo(String task) {   return null;  }
    };
  }

  // 인터페이스로 만드는 익명 클래스
  //   ㄴ 익명 클래스에서 모든 추상 메소드 재정의 필수
  InterfaceA  ifa = new InterfaceA() {
    @Override
    public void testA(String message) {
      
    }
  };

}

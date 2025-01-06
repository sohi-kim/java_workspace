package object.day8;

public class B20OverrideTest {

  public static void main(String[] args) {
    //
    Parent p1 = new Child();
    p1.hello("hi");

    System.out.println("====");
    // 메소드 재정의 한 자식 클래스
    Parent p2 = new GoodChild();
    p2.hello("hello~");

  }
}

class GoodChild extends Parent {

  //메소드 오버라이드 : 부모 인스턴스 메소드 실행 내용을 자식이 변경(재정의)
  //              부모 메소드의 리턴과 인자 형식은 변경할 수 없습니다.
  @Override
  void hello(String message) {
    super.hello(message);    //  부모 메소드 실행하는 방법. super 키워드 사용하기
    System.out.println("안녕하세요. 새로운 GoodChild 입니다.");
  }
}
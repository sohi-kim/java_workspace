package object.day8;

// 참고
// Casting(캐스팅) : char, int, long, double 자료형 간의 형식 변경
//                    ㄴ 강제 캐스팅 or 자동 캐스팅
// 상속의 캐스팅을 테스트 합니다.
public class B19ParentChildCasting {

  public static void main(String[] args) {

    //1. 자식 객체를 부모 클래스 타입으로 참조하기 [UpCasting]
    Parent p1 = new Child();

    // 단, 부모 타입으로 참조할 때에는 부모클래스의 인스턴스 요소만 접근 가능.
    p1.hello("hello~~");
    System.out.println("p1 객체 주소 참조값 : " + p1.hashCode());
    // p1.say();   //오류: say() 메소드는 자식 타입 참조 변수로만 접근 가능. => Parent 클래스에는 say() 가 없으므로.

    // 2. 부모 타입으로 참조된 자식 객체를 자식 클래스 타입으로 참조하기[DownCasting]
    Child c1 = (Child) p1;
    System.out.println("c1 객체 주소 참조값 : " + c1.hashCode());   // p1과 값이 같나요? Yes => 동일객체 참조
    c1.hello("헬로우~");
    c1.say();     // 자식 클래스 타입 참조 변수로 say 메소드 실행하기


    
  }
}

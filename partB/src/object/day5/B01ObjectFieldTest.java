package object.day5;

public class B01ObjectFieldTest {

  public static void main(String[] args) {
    //MyClass1 으로 객체를 생성합니다. : new 연산 사용.
    // MyClass1() 객체를 만드는 메소드 (메모리 할당 받기) => 생성자
    MyClass1  cls1 = new MyClass1();
    
    cls1.field1 = "hi~";
    cls1.field2 = 23;

    System.out.println("cls1 필드(속성,프로퍼티) 값 : " + cls1.field1);
    System.out.println("cls1 필드(속성,프로퍼티) 값 : " + cls1.field2);


    MyClass1 cls2 = new MyClass1();
    cls2.field1 = "안녕~";
    cls2.field2=100;
    System.out.println("\ncls2 필드(속성,프로퍼티) 값 : " + cls2.field1);
    System.out.println("cls2 필드(속성,프로퍼티) 값 : " + cls2.field2);

    System.out.println("\nstatic 정정 변수 테스트=====");
    MyClass1.field3 = 3.1419;
    MyClass1.field4 = "static";
    System.out.println("static 필드 값 : " + MyClass1.field3);  // 3.1419
    System.out.println("static 필드 값 : " + MyClass1.field4);  //static

    System.out.println("결론 : static 변수의 값은 객체와 상관이 없다.");
    System.out.println("\nstatic 필드 값 : " + cls1.field3);   // 3.1419
    System.out.println("\nstatic 필드 값 : " + cls2.field3);    // 3.1419
    
    System.out.println("static 필드 값 : " + cls1.field4);  //static
    System.out.println("static 필드 값 : " + cls2.field4);  //static

  }


  //자바에서 데이터를 저장하는 메모리 영역 구분
  // 1. static 저장 영역(method 영역) - 공유 영역
  // 2. 객체 저장 영역(heap)
  // 3. 기본형 변수값, 참조형 변수의 주소값 영역(stack)
}

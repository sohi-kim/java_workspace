package object.day6;

// 클래스의 생성자(Construtor) 테스트 
public class B07ConstructorTest {

  public static void main(String[] args) {
    
    //생성자에 출력문을 작성한 예시
    System.out.println("=== MyClass6 로 객체 생성하기 === ");
    MyClass6 m6 = new MyClass6();
    System.out.println(m6);
    System.out.println("m6 의 인스턴스 필드 값 : " 
                  + m6.field1 + "," + m6.field2);   // null, 0

    // 생성자에서 인스턴스 필드값을 저장한 예시
    System.out.println("=== MyClass7 로 객체 생성하기 === ");
    MyClass7 m7 = new MyClass7();  
    System.out.println(m7);
    System.out.println("m7 의 인스턴스 필드 값 : " 
                  + m7.field1 + "," + m7.field2);   // "hello", 999        

   // 커스텀 생성자에서 인스턴스 필드값을 초기화 예시
   System.out.println("=== MyClass8 로 객체 생성하기 === ");
   MyClass8 m8 = new MyClass8("java", 222);
   System.out.println(m8);
   System.out.println("m8 의 인스턴스 필드 값 : " 
                 + m8.field1 + "," + m8.field2);   // "java", 222   

   // 오류 : The constructor MyClass8() is undefined
  //  MyClass8 m88 = new MyClass8();              
  }
}

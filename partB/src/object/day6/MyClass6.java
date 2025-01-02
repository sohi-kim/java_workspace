package object.day6;

// 생성자 테스트 클래스
public class MyClass6 {

   String field1;
   int field2;

   // 생성자 형식. 
   //1. 기본생성자 : 실행할 내용이 없으면 생략하고 사용합니다.
   //     day5 클래스는 모두 생략했습니다.
   MyClass6(){
        //테스트를 위한 출력
        System.out.println("생성자가 실행됩니다.!!");
   }

}

class MyClass7 {

  String field1;   // 기본값은 참조가 없는 상태 null 
  int field2;      // 기본값은 0

  MyClass7(){
    // 생성자는 인스턴스 필드(변수)값을 특정값으로 초기화하는 목적으로 사용
    this.field1 = "hello";
    this.field2 =999;
  }
}
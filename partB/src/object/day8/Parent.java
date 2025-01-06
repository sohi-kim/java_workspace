package object.day8;

public class Parent {

    private int field1;       // Parent 부모 클래스만 사용
    protected String field2;

    Parent(){
      //확인을 위한 출력
      this.field2 = "java";
      System.out.println("Parent 객체 생성");
    }

    void hello(String message){
      System.out.println(message + ": " + field1);
    }
}

class Child extends Parent{

    Child() {
      super();        // 부모 생성자 호출
      System.out.println("Child 객체 생성 ");
    }

    void say() {
      System.out.println(field2);    // protected 필드. super.field2 에서 super 생략
     // System.out.println(field1);   // 오류 : private 필드는 자식도 사용 못함.
    }
}

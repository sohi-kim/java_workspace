package object.day5;

public class B02PublicTest {

  public static void main(String[] args) {
    MyClass1 cls1 = new MyClass1();
    MyClass2 cls2 = new MyClass2();

    System.out.println("참조형 변수에 저장된 값 확인 ---");
    System.out.println(cls1);  //object.day5.MyClass1@2f92e0f4
    System.out.println(cls2);  //object.day5.MyClass2@28a418fc
  }

}

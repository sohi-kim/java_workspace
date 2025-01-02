package object.day6;

// Getter 와 Setter Test
public class B08GetterSetterTest {

  public static void main(String[] args) {
    
    MyClass my = new MyClass();
    // 오류 : The field MyClass.field1 is not visible 
    // my.field1 = "hello";
    my.setFiled1("hello");
    // System.out.println(my.field1);
    System.out.println("== my 객체 == ");
    System.out.println(my.getField1());     // "hello"
    System.out.println(my.getField2());     // 0

    MyClass mmy = new MyClass("java",999);
    System.out.println("== mmy 객체 == ");
    System.out.println(mmy.getField1());   // "java"
    System.out.println(mmy.getField2());   // 999


  }
}

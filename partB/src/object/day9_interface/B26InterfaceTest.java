package object.day9_interface;

public class B26InterfaceTest {

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
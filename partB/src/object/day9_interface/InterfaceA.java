package object.day9_interface;

public interface InterfaceA {
    // 상수 : public static final 앞 부분에 생략
    int TEST = 12;
    // 추상메소드 : public abstract 앞 부분에 생략
    void testA(String message);

}

interface InterfaceB{

     int methodOfB();
     void methodOfBB(String task);
}

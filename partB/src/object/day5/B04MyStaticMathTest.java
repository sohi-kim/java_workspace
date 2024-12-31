package object.day5;

public class B04MyStaticMathTest {
    public static void main(String[] args) {
      // static 메소드 테스트 

      int a = 456;
      int b = 234;

      int result;

      result = MyStaticMath.addValue(a, b);
      System.out.println("MyStaticMath.addValue(a, b) : " + result);
      result = MyStaticMath.substractValue(a, b);
      System.out.println("MyStaticMath.substractValue(a, b) : " + result);
      result = MyStaticMath.max(a, b);
      System.out.println("MyStaticMath.max(a, b) : " + result);
      result = MyStaticMath.min(a,b);
      System.out.println("MyStaticMath.min(a, b) : " + result);



    }
}

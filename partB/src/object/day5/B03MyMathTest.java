package object.day5;

public class B03MyMathTest {
  public static void main(String[] args) {
    
      MyMath myMath = new MyMath();
      myMath.first = 234;
      myMath.second = 456;
      System.out.println("myMath.add() : " + myMath.add());
      System.out.println("myMath.substract() : " + myMath.substract());

      myMath.print(1);    // 234 + 456 = 690
      myMath.print(2);    // 234 + 456 = -222
      myMath.print(3);    // 234 * 456 = .....

      MyMath temp = new MyMath();
      System.out.println("temp.add() : " + temp.add());
      System.out.println("temp.substract() : " + temp.substract());
  }

}

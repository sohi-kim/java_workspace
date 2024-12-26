package basic.day02;

public class A08Prefix_Postfix {

   public static void main(String[] args) {

      //증감연산자 : ++ 또는 --
      //        ㄴ a = a+1;   또는 a = a-1;

      int start =100;
      //  postfix(후치)
      // 다른 연산 또는 메소드와 함께 쓰일 때, ++ 연산은 나중에 실행됩니다.
      System.out.println(" === postfix 연산 예시 ===");
      System.out.println(start++);    //100
      System.out.println(start++);    //101
      System.out.println(start++);    //102
      System.out.println(start++);
      System.out.println(start++);

      // prefix(전치)
      // 다른 연산 또는 메소드와 함께 쓰일 때, ++ 연산은 먼저 실행됩니다.
      System.out.println(" === prefix 연산 예시 ===");
      start=100;
      System.out.println(++start);   //101
      System.out.println(++start);   //102
      System.out.println(++start);   //103
      System.out.println(++start);
      System.out.println(++start);
   }
}

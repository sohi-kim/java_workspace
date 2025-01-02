package object.day6;

public class B09MyMathApp {

  public static void main(String[] args) {
        MyMathV2 prob1 = new MyMathV2(234, 345, '+');
        System.out.println(prob1.toString());


        MyMathV2 prob2 = new MyMathV2(234, 345, '*');
        System.out.println(prob2.toString());

        MyMathV2 prob3 = new MyMathV2(234, 345, '$');
        System.out.println(prob3.toString());
  }

}

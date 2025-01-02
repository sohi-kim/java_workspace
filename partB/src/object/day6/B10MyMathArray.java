package object.day6;

// 여러개의 객체를 배열의 요소로 지정하기
public class B10MyMathArray {

  public static void main(String[] args) {
        MyMathV2 prob1 = new MyMathV2(234, 345, '+');
        System.out.println(prob1.toString());

        MyMathV2 prob2 = new MyMathV2(234, 345, '*');
        System.out.println(prob2.toString());

        MyMathV2 prob3 = new MyMathV2(234, 345, '$');
        System.out.println(prob3.toString());


        // 객체 배열의 선언
        int[] numbers = new int[10];
        numbers[0]=123;
        MyMathV2[]  probs = new MyMathV2[5];
        // 이미 만들어진 객체는 객체 변수를 대입. (참조값 전달)
        probs[0] = prob1;
        probs[1] = prob2;
        probs[2] = prob3;
        // 직접 객체를 생성하여 대입(참조값 전달)
        probs[3] = new MyMathV2(444,555,'-');
        probs[4] = new MyMathV2(666,555,'-');
        System.out.println("=== 배열 probs 의 객체 반복 실행 ===");
        for(int i=0;i<probs.length;i++){
          System.out.println(probs[i].toString());
        }

        System.out.println("=== 향상 for 문 (forEach 동작) === ");
        for(MyMathV2 temp : probs){
          //probs 배열의 요소를 순서대로 temp 에 대입하여 반복 실행
          System.out.println(temp.toString());
        }

  }
}

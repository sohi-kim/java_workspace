package object.day6;

import java.util.Arrays;
import java.util.Scanner;

public class B11RedPenApp {
  public static void main(String[] args) {
    // 문제는 5개를 배열에 저장하고
    // 사용자에게 답 입력 -> answer 필드에 저장.
    MyMathV3[] probs = new MyMathV3[5];

    System.out.println("배열 선언 : " + Arrays.toString(probs));
    //배열 선언 : [null, null, null, null, null]  
    // 여기서는 참조된 객체가 없는 배열 요소

    probs[0] = new MyMathV3(444, 223, OperationType.ADD);
    probs[1] = new MyMathV3(234, 456, OperationType.ADD);
    probs[2] = new MyMathV3(444, 223, OperationType.SUB);
    probs[3] = new MyMathV3(456, 124, OperationType.SUB);
    probs[4] = new MyMathV3(345, 343, OperationType.ADD);
    System.out.println("배열 참조 상태 : " +Arrays.toString(probs));

    // 사용자에게 문제를 보여 주고 답 입력 받아 answer 필드값 저장하기
    Scanner sc = new Scanner(System.in);   //sc.nextInt()
    System.out.println("/// 문제 시작 ///");
    for(MyMathV3 temp : probs){
      //문제 출력
      temp.printProblem();
      //학생의 답 입력받아 저장
      int answer = sc.nextInt();
      //입력한 답을 answer 필드에 저장
      temp.setAnswer(answer);   //long 타입에 int 는 자동 캐스팅
    }
    System.out.println("/// 정답과 입력한 답안 확인 ///");
    int correct=0;     //맞은 답 개수
    for(MyMathV3 temp : probs) {
      // System.out.println(temp.getAnswer());
      System.out.println("문제 : " + temp.toString() +
                 ", 학생 답: " + temp.getAnswer());
      if(temp.calculate() == temp.getAnswer())
          correct++;
    }
    System.out.println("정답 : " + correct + " 개, 오답 : " + (5-correct));
    sc.close();
  }

}

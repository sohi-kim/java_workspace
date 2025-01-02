package object.day6;

import java.util.Scanner;

public class B11RedPenApp {
  public static void main(String[] args) {
    // 문제는 5개를 배열에 저장하고
    // 사용자에게 답 입력 -> answer 필드에 저장.
    MyMathV3[] probs = new MyMathV3[5];
    probs[0] = new MyMathV3(444, 223, OperationType.ADD);
    probs[1] = new MyMathV3(234, 456, OperationType.ADD);
    probs[2] = new MyMathV3(444, 223, OperationType.SUB);
    probs[3] = new MyMathV3(456, 124, OperationType.SUB);
    probs[4] = new MyMathV3(345, 343, OperationType.ADD);

    // 사용자에게 문제를 보여 주고 답 입력 받아 answer 필드값 저장하기
    Scanner sc = new Scanner(System.in);
    System.out.println("/// 문제 시작 ///");
    for(){


    }
    System.out.println("/// 입력한 답안 확인 ///");
    for(MyMathV3 temp : probs)
        System.out.println(temp.getAnswer());

    sc.close();
  }

}

package basic.day03;

import java.util.Scanner;

public class A20MethodExample {

  // 3개의 정수값을 키보드 입력 받아 저장합니다.
  // 입력받은 3개의 값을 maxOfNumbers(n1,n2,n3) 메소드 실행하여 최대값을 리턴 받습니다.

  public static void main(String[] args) {
    
      int n1,n2,n3;   //초기값 없이 변수 선언.(타입과 이름)
      Scanner sc = new Scanner(System.in);    // 입력 데이터 처리에 대해 다양한 기능을 갖는 Scanner

      System.out.print("n1 입력 >>> ");
      n1 = sc.nextInt();        // 입력문자열을 정수값으로 변환하여 저장합니다.

      System.out.print("n2 입력 >>> ");
      n2 = sc.nextInt();

      System.out.print("n3 입력 >>> ");
      n3 = sc.nextInt();

      int max = maxOfNumbers(n1,n2,n3);
      System.out.println("n1,n2,n3 중 최대값은\t" + max);


      int min = minOfNumbers(n1,n2,n3);
      System.out.println("n1,n2,n3 중 최솟값은\n" + min);
 
  } // main end

  public static int minOfNumbers(int n1, int n2, int n3){
    int min;
    if(n1>n2){
      min = n2;
    }else{
      min = n1;
    }

    if(min > n3){
      min = n3;
    }

    return min;
  }


  // 최대값 구하는 메소드
  public static int maxOfNumbers(int n1 , int n2, int n3){
     int max;
     // 1) n1, n2 중 큰값을 max 임시로 저장
     if(n1>n2){
       max = n1;
     }else {
       max = n2;
     }

     // 2) max 임시값과 남은 n3 비교
     if(max < n3) {
      max = n3;  // 남은 n3 이 더 크면 max 변경하기
     }
     return max;
  }


} // class end

package basic.day04;

import java.util.Scanner;

public class A23ScannerInputMethod {

  // Scanner sc = new Scanner(System.in)
  //         sc 로 사용할 수 있는 메소드 : next() , nextLine() , nextInt()
  
  // 전역변수
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
   
    
   // 키보드 입력 내용은 입력 버퍼에 저장되고 메소드마다 동작 방식 차이가 있습니다.
    
    nextLineTest();
    sc.close();

  }

  public static void nextTest(){
    // 2. next() 메소드는 공백 또는 엔터까지를 하나의 문자열로 만들어서 변수에 저장.
    String str1 = sc.next();
    String str2 = sc.next();

    System.out.println("str1: " + str1 + ", str2 : " + str2);
  }

  public static void nextLineTest(){
       // 1. nextLine() 메소드
      String str3 = sc.nextLine();
      String str4 = sc.next();
            
      System.out.println("str3: " + str3 + ", str4 : " + str4);
  }

  public static void nextIntTest() {
    // 3. nextInt() 메소드는 공백 또는 엔터까지를 하나의 정수값으로 만들어서 변수에 저장.
    //                    숫자가 아닌 문자입력은 오류 발생.
    int num1 = sc.nextInt();
    int num2 = sc.nextInt();

    System.out.println("num1: " + num1 + ", num2 : " + num2);
  }
}

package basic.day02;

import java.util.Scanner;

// 표준 출력 : 콘솔(화면장치) 출력 System.out.println("문자열")
// 표준 입력 : 콘솔(키보드) 입력 System.in.read()
//                                ㄴ 딱 1문자만 입력
// 문자열 입력 : Scanner 클래스의 기능을 사용.
public class A12StringInput {

  public static void main(String[] args) {
    
    // 여러개의 문자를 입력받아 문자열을 리턴해주는 메소드 지원
      Scanner sc = new Scanner(System.in);

      System.out.println("사용자 아이디를 입력하세요.↓↓↓↓↓↓");
      String userid = sc.nextLine();   
      //커서 위치 입력하여 실행하기. 입력을 끝내려면 Enter
      // 유효한 userid : isBlank 가 아니고 길이가 5 글자 이상.
      if(userid.isBlank() || userid.length() < 5){
         System.out.println("유효한 아이디 입력이 아닙니다.");
      } 
      // else if(userid.length() < 5 ){
      //   System.out.println("유효한 아이디 입력이 아닙니다.");
      // }
      else {
        System.out.println("입력한 아이디 확인 : " + userid);
        
      }

      sc.close();     //입력 자원 사용 종료(닫기)
  }
}

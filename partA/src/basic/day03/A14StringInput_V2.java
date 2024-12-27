package basic.day03;

import java.util.Scanner;

public class A14StringInput_V2 {

  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      boolean run=true;
    
      // 유효한 아이디 : isBlank 가 아니고 길이는 5 이상. 첫글자는 영문으로 시작해야한다.
      //              ㄴ A19MyCharMethod 클래스의 메소드를 활용
      while(run){
        System.out.println("사용자 아이디를 입력하세요.↓↓↓↓↓↓");
        String userid = sc.nextLine();   
        if(userid.isBlank() || userid.length() < 5 
                    || !A19MyCharMethod.isAlphabet(userid.charAt(0))){
          System.out.println("유효한 아이디 입력이 아닙니다.");
        } 
        else {
          System.out.println("입력한 아이디 확인 : " + userid);
        }
        System.out.print("계속하시겠습니까 (Y/N) ? ");
        // if(sc.nextLine().toUpperCase().equals("N"))      // N 이면
        if(!sc.nextLine().toUpperCase().equals("Y"))  // Y가 아니면
              run=false;
      }
     
// 단, 계속하시겠습니까 (Y/N) ? 로 확인 입력을 받고 N(또는 n) 입력하면 while 종료.
      sc.close();    
  }

}
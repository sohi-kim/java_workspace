package basic.day02;

import java.util.Scanner;

public class A14Exam {

  // A12 번 while 문으로 유효한 아이디 입력할 때 까지 반복시키기
  public static void main(String[] args) {

     Scanner sc = new Scanner(System.in);
     boolean run = true;
     
     while(run){   
        System.out.println("사용자 아이디를 입력하세요.↓↓↓↓↓↓");
        String userid = sc.nextLine();   
        if(userid.isBlank() || userid.length() < 5){
          System.out.println("유효한 아이디 입력이 아닙니다.");
        } 
        else {
          System.out.println("입력한 아이디 확인 : " + userid);
        }
        System.out.print("계속 하시겠습니까(Y/n) ? ");
        if(sc.nextLine().equals("N"))
                     run=false; 
    }
    sc.close();     //입력 자원 사용 종료(닫기)
  }
}

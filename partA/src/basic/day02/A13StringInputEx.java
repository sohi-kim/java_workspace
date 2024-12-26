package basic.day02;

import java.util.Scanner;

public class A13StringInputEx {

  public static void main(String[] args) {
    
      // CLI 프로그램은 명령창에서 텍스트 기반으로 개발합니다.
      // => 이 때 필요한 선택 메뉴를 예시로 만들어 봅시다.

      String menu;
      Scanner sc = new Scanner(System.in);
      boolean run = true;

      System.out.println(":: 쇼핑몰 마이페이지 메뉴 입니다. ::");
      while(run){
          System.out.println("1: 장바구니   2: 배송조회    3: 구매 목록    "
                              +"  4: 종료");
          System.out.print("선택 하세요 >>>> ");
          menu = sc.nextLine();

          switch (menu) {
            case "1":    // menu.equals("1")
              System.out.println("장바구니 🛒🛒 .. 많이 담아 주세요.");
              break;
            case "2":    // menu.equals("2")
              System.out.println("배송 조회 🚙🛺 ..달려가는 중입니다.");
              break;
            case "3":   // menu.equals("3")
              System.out.println("주문 목록 👕🥼 ..감사합니다. ");
              break;
            case "4":   // menu.equals("4")
              System.out.println("종료합니다. 😀😁");
              // 조건식을 참고하여 종료 조건 설정을 합니다.
              run=false;
              break;
            default:
              System.out.println("메뉴 선택 다시 하세요.");
              break;
          } // switch end

      }  // while end
      sc.close();

  }   // main end

}  // class end

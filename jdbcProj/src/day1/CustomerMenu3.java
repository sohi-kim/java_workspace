package day1;

public class CustomerMenu3 {

  public static void main(String[] args) {
    System.out.println("=====고객 등록 (회원 가입) 메뉴 입니다.======");
    System.out.print(" 아이디 입력 >>> ");
    String customid = System.console().readLine();     
    System.out.print(" 이름 입력 >>> ");
    String name = System.console().readLine();
    System.out.print(" 이메일 입력 >>> ");
    String email = System.console().readLine();
    System.out.print(" 나이 입력 >>> ");
    int age = Integer.parseInt(System.console().readLine());   

    // 각자 완성하세요.
  }

}

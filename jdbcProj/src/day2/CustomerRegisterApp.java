package day2;

import dao.day2.TblCustomerDao;
import vo.day1.Customer;

public class CustomerRegisterApp {

  public static void main(String[] args) {
    
    modify();


  }


  public static void modify() {
    System.out.println("===== 고객 정보 수정 메뉴 입니다. ======");
    System.out.print(" 아이디 입력 >>> ");
    String customid = System.console().readLine();     
    System.out.print(" 이메일 입력 >>> ");
    String email = System.console().readLine();
    System.out.print(" 우편번호 입력 >>> ");
    String postcode = System.console().readLine();

    // dao 클래스 메소드 사용하기
  }


  public static void register(){
    System.out.println("===== 고객 등록 (회원 가입) 메뉴 입니다. ======");
    System.out.print(" 아이디 입력 >>> ");
    String customid = System.console().readLine();     
    System.out.print(" 이름 입력 >>> ");
    String name = System.console().readLine();
    System.out.print(" 이메일 입력 >>> ");
    String email = System.console().readLine();
    System.out.print(" 나이 입력 >>> ");
    int age = Integer.parseInt(System.console().readLine());   

    // Custmer 객체 만들기
    Customer customer = new Customer(customid, name, email, age, null);

    //dao 클래스 사용하기 
    TblCustomerDao customerDao = new TblCustomerDao();
    int result = customerDao.insert(customer);

    if(result==0){
      System.out.println("고객 등록 실패!!");
    } else {
      System.out.println("고객 등록 성공!!");
    }
  }

}

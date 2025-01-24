package day2;

import java.util.function.ToLongBiFunction;

import dao.day2.TblCustomerDao;
import vo.day1.Customer;

public class CustomerRegisterApp {

  public static void main(String[] args) {
            // remove();
            // modify();
      System.out.println("[[[고객 관리 APP]]]");
      boolean run = true;
      while(run) {
          System.out.println("선택 메뉴 : 1. 고객 등록  2. 고객정보 조회   3. 고객정보 수정 ");
          System.out.println("            4. 고객 회원 탈퇴     5.종료");
          System.out.print("메뉴 선택 >>> ");
          String menu = System.console().readLine();
          switch (menu) {
            case "1":
              register();
              break;
            case "2":
              print_customer_info();
              break;
            case "3":
              modify();
              break;
            case "4":
              remove();
              break;
            case "5":
              run=false;
              break;
            default:
              break;
          }
      }
      System.out.println("프로그램 종료합니다.");  
  }

  public static void print_customer_info(){
    System.out.println("===== 고객 조회 메뉴 입니다. ======");
    System.out.print(" 아이디 입력 >>> ");
    String customid = System.console().readLine();  

    // TblCustomerDao customerDao = new TblCustomerDao();   // 싱글톤 패턴 정의하면 오류
    TblCustomerDao customerDao = TblCustomerDao.getInstance();

    Customer customer = customerDao.selectByPk(customid);
    System.out.println("[이름] " + customer.getName());
    System.out.println("[이메일] " + customer.getEmail());
    System.out.println("[나이] " + customer.getAge());
    System.out.println("[가입일자] " + customer.getRegDate());
    System.out.println("[우편번호] " + customer.getPostcode());
  }


  public static void remove() {
    System.out.println("===== 회원(고객) 탈퇴 메뉴 입니다. ======");
    System.out.print(" 아이디 입력 >>> ");
    String customid = System.console().readLine();  
    

    // TblCustomerDao customerDao = new TblCustomerDao();   // 싱글톤 패턴 정의하면 오류
    TblCustomerDao customerDao = TblCustomerDao.getInstance();

    int result = customerDao.delete(customid);

    if(result ==0){
      System.out.println("회원 탈퇴 실패!!");
    }else {
      System.out.println("회원 탈퇴 성공!!");
    }
  }

  public static void modify() {
 
    // TblCustomerDao customerDao = new TblCustomerDao();   // 싱글톤 패턴 정의하면 오류
    TblCustomerDao customerDao = TblCustomerDao.getInstance();

    System.out.println("===== 고객 정보 수정 메뉴 입니다. ======");
    System.out.print(" 아이디 입력 >>> ");
    String customid = System.console().readLine();   
    
    System.out.println("~~ 고객님 현재 정보 ~~");
    Customer customer = customerDao.selectByPk(customid);
    System.out.println(customer);
    
    System.out.println("~~ 이메일,우편번호 수정해 주세요. ~~");
    System.out.print(" 이메일 입력 >>> ");
    String email = System.console().readLine();
    System.out.print(" 우편번호 입력 >>> ");
    String postcode = System.console().readLine();

    // dao 클래스 메소드 사용하기
    customer = new Customer(customid, null, email, 0, null,postcode);
   
    int result = customerDao.update(customer);

    if(result==0){
      System.out.println("고객 정보 변경 실패!!");
    } else {
      System.out.println("고객 정보 변경 성공!!");
      customer = customerDao.selectByPk(customid);
      System.out.println(customer);
    }
  }

  public static void register(){
   
    // TblCustomerDao customerDao = new TblCustomerDao();   // 싱글톤 패턴 정의하면 오류
    TblCustomerDao customerDao = TblCustomerDao.getInstance();
    
    System.out.println("===== 고객 등록 (회원 가입) 메뉴 입니다. ======");
    boolean run = true;
    String customid = null;
    while(run){
      System.out.print(" 사용할 아이디 입력 >>> ");
      customid = System.console().readLine();
      if(customerDao.selectByPk(customid)!=null){
        System.out.println("중복된 아이디가 있습니다.");
      }else {
        System.out.print("사용가능 합니다. 해당 아이디를 사용하시겠습니까? (Y/N)");
        if(System.console().readLine().toUpperCase().equals("Y")) break;
      }
    }
    System.out.print(" 이름 입력 >>> ");
    String name = System.console().readLine();
    System.out.print(" 이메일 입력 >>> ");
    String email = System.console().readLine();
    System.out.print(" 나이 입력 >>> ");
    int age = Integer.parseInt(System.console().readLine());   

    // Custmer 객체 만들기
    Customer customer = new Customer(customid, name, email, age, null);

    //dao 클래스 사용하기 
    
    int result = customerDao.insert(customer);

    if(result==0){
      System.out.println("고객 등록 실패!!");
    } else {
      System.out.println("고객 등록 성공!!");
    }
  }

}

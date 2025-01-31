package day3;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dao.TblBuyDao;
import dao.TblProductDao;
import vo.BuyVo;
import vo.CustomerOrderVO;
import vo.Product;

// 구매 테이블의 데이터를 조작하는 예제
// 장바구니 구현 예제
// 트랜잭션 테스트 예제
public class CartMenu {
  // 필요한 전역변수(클래스의 프로퍼티) 선언
  // 장바구니 : 구매할 상품을 저장하는 목록
  private List<BuyVo> list = new ArrayList<>();
  // Dao -> 싱글톤 패턴 수정 예정
  private TblBuyDao dao = new TblBuyDao();
  private TblProductDao productDao = TblProductDao.getInstance();

  // 로그인한 사용자
  private String customerId;

  // 상품 가격표 
  private Map<String,Integer> priceTables;

  // 편의상 메인을 같은 클래스 작성하고 실행합니다.
  public static void main(String[] args) {
    CartMenu cart = new CartMenu();
    cart.start();
    // switch 완성해서 장바구니 테스트 해보세요.
  }

  public void showMyOrderList(){
    System.out.println("~~~~~" + this.customerId + " 님 구매 목록~~~~~");
    // List<BuyVo> myOrderList = dao.selectByCustomerId(this.customerId);
    // for문 출력                    ㄴ 조회 결과는 날짜 내림차순 정렬 
    // for(BuyVo b : myOrderList) {
    //   System.out.println(String.format("%-20s  %-15s  %-10s ",b.getPcode(),b.getQuantity(),b.getBuy_date()));
    // }
    List<CustomerOrderVO> myOrderList = dao.selectCustomerOrderList(customerId);
    // 날짜와 시간 출력 형식 지정.
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    for(CustomerOrderVO c : myOrderList) {
        System.out.println(String.format("%-20s \t%,6d  %3d  %-20s  %-4s ",
                c.getPname(),c.getPrice(),c.getQuantity(),
                sdf.format(c.getBuy_date()),c.getCategory()));
    }
  }

  public void showMenu(){
    System.out.println(".".repeat(70));
    System.out.println("[C] 카테고리별 상품 조회    [P] 상품명 키워드 검색  [M]나의 구매내역");
    System.out.println("[B] 바로 구매하기     [X] 구매 종료");
    System.out.println("::장바구니::[A] 담기  [L] 목록  [R] 삭제   [Y] 모두 구매 ");
    System.out.println(".".repeat(70));
  }

  public void start() {
    System.out.println("[[[[ 우리 쇼핑몰 ]]]]");
    System.out.print("사용자 아이디 입력하세요. >>> ");
    customerId = System.console().readLine();
    // 1. 아이디 존재 여부 확인 필요. 아이디 존재할때만 아래 실행하기-> 각자 해보세요
    // 상품 가격표 보여주기
    this.priceTables = productDao.getPriceTable();
    System.out.println("쇼핑몰 상품 가격표 : " + priceTables);
    // 메뉴 보여주기
    showMenu();
    boolean run=true;
    while(run){
      System.out.print("메뉴 선택 하세요. >>> ");
      String menu = System.console().readLine();
      switch (menu) {
        case "M","m":
          showMyOrderList();         // sql SELECT 실행 - tbl_buy 테이블
          break;
        case "C","c":
          showProductByCategory();    // sql SELECT 실행 - tbl_product 테이블
          break;
        case "P","p":
          showProductByKeyword();    // sql SELECT 실행 - tbl_product 테이블
          break;
        case "A","a":
          addCartItem();            // cart 리스트 항목 추가
          break;
        case "L","l":
          showCartList();          // cart 리스트 목록 출력
          break;
        case "R","r":
          removeCartItem();        // cart 리스트 항목 삭제
          break;
        case "B","b":
          buyOneItem();           // sql INSERT 실행 - tbl_buy 테이블
          break;
        case "Y","y":
          buyCartItems();         // sql INSERT 여러개 batch 실행 - tbl_buy 테이블
          break;  
        case "X","x":
          run=false;
          break;
        default:
          break;
      }
    }
  }
  
  public void showProductByCategory(){
    System.out.println("카테고리 : A1-과일 A2-수입과일  B1-인스턴트 식품  B2-선물세트 C1-과자류");
    System.out.print("카테고리 입력 >>> ");
    String category = System.console().readLine().toUpperCase();
    List<Product> list = productDao.selectByCategory(category);
    // 조회 결과 for 문으로 출력하기 (상품명, 상품코드, 가격)
    for(Product p : list) {
      System.out.println(String.format("%-20s  %-15s  %,6d ",p.getPname(),p.getPcode(),p.getPrice()));
    }

  }

  public void showProductByKeyword(){
      System.out.print("상품명 키워드 입력 >>> ");
      String pname = System.console().readLine();
      List<Product> list = productDao.searchByKeyword(pname);
    // 조회 결과 for 문으로 출력하기 (상품명, 상품코드, 가격)
    for(Product p : list) {
      System.out.println(String.format("%-20s  %-15s  %,6d ",p.getPname(),p.getPcode(),p.getPrice()));
    }

  }

  // 바로 구매하기 - 1개 행 insert 
  public void buyOneItem(){
    System.out.println("----- 상품 바로 구매 -----");
    System.out.print("    구매할 상품 코드 >>> ");
    String pcode = System.console().readLine();
    
    System.out.print("    구매할 수량 >>> ");
    int quantity = Integer.parseInt(System.console().readLine());

    BuyVo vo = new BuyVo();
    vo.setCustom_id(this.customerId);
    vo.setPcode(pcode); vo.setQuantity(quantity); 

    if(dao.insertOne(vo)==1){
      System.out.println("구매 완료되었습니다.");
    }else {
      System.out.println("구매 처리 중 오류 발생!!");
    }
  }


  // 장바구니 목록으로 구매하기 - n개 행 insert (트랜잭션)
  public void buyCartItems() {
    System.out.println("----- 장바구니 상품 모두 구매 -----");
    //3. 장바구니에 상품이 있을 때만 실행하기
    if(list.size()>0) {
      int count = dao.insertMany(list);
      if (count > 0) {
        System.out.println("상품 구매가 완료 되었습니다.");
        list.clear();     // 장바구니 비우기
      } else {
        System.out.println("상품 구매가 비정상적으로 종료되었습니다.");
      }
    } else {
      System.out.println("장바구니가 비었습니다.");
    }
  }

  // 장바구니의 추가/삭제/목록 은 dao 상관없이 List 조작입니다.
  public void showCartList(){
    int totalPrice=0;    // 결제금액 초기화
    System.out.println("----- 장바구니 목록 -----");
    // 상품코드, 수량
    for(int i =0;i<list.size();i++){
      BuyVo temp = list.get(i);
      System.out.println(i + "\t" + temp.getPcode() + "\t" + temp.getQuantity());
      totalPrice += (temp.getQuantity()*priceTables.get(temp.getPcode()));    
                   // 
    }
    // 장바구니 상품들 총 결제금액을 구할 예정
    System.out.println("총 결제 금액 : " + totalPrice);
  }

  public void addCartItem(){
    System.out.println("----- 장바구니 상품 추가 -----");
    boolean run= true;

    while(run)
    {  
      System.out.print("    구매할 상품 코드 >>> ");
      String pcode = System.console().readLine();
      
      System.out.print("    구매할 수량 >>> ");
      int quantity = Integer.parseInt(System.console().readLine());

      BuyVo vo = new BuyVo();
      vo.setPcode(pcode); vo.setQuantity(quantity); 
      vo.setCustom_id(this.customerId);
      list.add(vo);

      System.out.print("계속 구매하시려면 엔터를 누르세요.종료는 N 입니다. ");
      if(System.console().readLine().toUpperCase().equals("N")) 
              run=false;
    }
  }  //메소드 끝

  public void removeCartItem() {
    System.out.println("----- 장바구니 상품 삭제 -----");
    System.out.print("    삭제할 상품 번호(인덱스) >>> ");
    
    int index = Integer.parseInt(System.console().readLine());
    //2. 인덱스값 범위 검사하기
    if(index >=0 && index < list.size()) {
      //List 저장 목록의 항목 삭제
      list.remove(index);
    }else {
      System.out.println("잘못된 인덱스 값입니다.");
    }
    
  }


}

package basic.day01;

public class A04Quiz {

  public static void main(String[] args) {
    
    // 환율 : 1달러 1450원

    // 여행을 갑니다. 여행 경비 500000 을 환전하려고 합니다.
    // 환전 금액은 얼마인가?
    int money = 500000;
    int rateWon = 1450;

    // 환전금액 구하는 메소드 wonToDollar(money,rateWon) 
    //  => 리턴 값(int) 으로 환전금액 출력하기
    int result = wonToDollar(money,rateWon);
    System.out.println("wonToDollar(money, rateWon) : "+ result);

    double resultDouble = wonToDollarDouble(money, rateWon);
    System.out.println("wonToDollarDouble(money, rateWon) : "+ resultDouble);
    // 여행을 다녀와서 귀국했습니다. 경비가 12달러가 남았습니다.
    // 원화로 환전합니다.


        // 환전 금액 구하는 메소드 dollarToWon(money,rateWon)
        //  => 리턴 값(int) 으로 환전금액 출력하기
        result = dollarToWon(money,rateWon);
    
      } // main end
    

      // wonToDollar 메소드 정의
      // money, rateWon 은 wonToDollar 메소드 { } 스콥에서만 사용하는 지역변수
      public static int wonToDollar(int money , int rateWon){
          return money / rateWon;
      }

      // dollarToWon 메소드 정의
      // money, rateWon 은 dollarToWon 메소드 { } 스콥에서만 사용하는 지역변수
      public static int dollarToWon(int money, int rateWon){
          return money * rateWon;
      }
  
      public static double wonToDollarDouble(int money , int rateWon){
        return money / rateWon;
      }

      public static double dollarToWonDouble(int money, int rateWon){
        return money * rateWon;
    }
  


} // class end

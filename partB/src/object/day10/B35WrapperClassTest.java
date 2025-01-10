package object.day10;

import java.util.ArrayList;
import java.util.List;

public class B35WrapperClassTest {

  public static void main(String[] args) {
    
    List<Integer> list = new ArrayList<>();
    list.add(10);   // Boxing

    //1. 기본형 값으로 직접 클래스 타입 변경 - valueOf 메소드
    Integer test = Integer.valueOf(123);
    Double dtest = Double.valueOf(3.14); 

    //2. 문자열로 클래스 타입 변경
    test = Integer.valueOf("1234");
    // test = Integer.valueOf("abc");  
    // 오류. 숫자가 아닌 "abc"는 정수객체로 변환 못함.

    dtest = Double.valueOf("3.1419");

    //*** 3. parseXXXX() 메소드 : 문자열에서 기본형 타입으로 변경 ***
    int a = Integer.parseInt("123");
    double b = Double.parseDouble("3.1419");

    // *** 4. 16진수 등 radix (2,8,16) 관련 메소드
    for(int i=32;i<60;i++){
      System.out.println("10진수 = " + i + ", 16진수 = " + Integer.toHexString(i));
    }
    // 16진수 3b => 3*16 + b(11) = 48+11

    // 16진수 FFFF 가 10진수 얼마인지 구하기
    int result = Integer.parseInt("FFFF", 16);
    System.out.println(result);    //65535
    // 2진수 1111111111111111 가 10진수 얼마?
    result = Integer.parseInt("1111111111111111", 2);   
                                    // 1이 16개
    System.out.println(result);    //65535


    System.out.println(" // 2진수와 16진수 비교 //");
    for(int i=0;i<16;i++){
      System.out.println(
        String.format("%2d  %4s  %s",
              i,
              Integer.toBinaryString(i),
              Integer.toHexString(i))
      );
    }
    // 2진수 자리 가중치 값을 순서대로 8,4,2,1 을 적용해서 검증해 보세요.
    // 16진수 a (10), b(11) , c(12) , d(13) , e(14) , f(15)

  }

}

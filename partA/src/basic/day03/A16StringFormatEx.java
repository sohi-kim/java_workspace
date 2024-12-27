package basic.day03;

// %d , %f 
public class A16StringFormatEx {


  public static void main(String[] args) {
    
    int i = 23;
    System.out.println("=== 정수 형식 %d (int, long) 테스트 === ");
    System.out.println("12345678901234567890");
    System.out.println(String.format("%d", i));
    // 출력 자리수 5자리. 기본 정렬 위치 오른쪽. 남는 자리는 공백으로 표시
    System.out.println(String.format("%5d", i));   
    // 정렬 위치 왼쪽
    System.out.println(String.format("%-5d", i));
    // 남는 자리는 0 으로 표시
    System.out.println(String.format("%05d", i));


    double n = 123.56789;
    System.out.println("=== 실수 형식 %f (float, double) 테스트 === ");
    System.out.println(3.4);    //변수 저장하지 않고 그냥 출력
    System.out.println(n);
    System.out.println("서식 문자 %f 는 소수 아래 6자리");
    System.out.println("12345678901234567890");
    System.out.println(String.format("%f", 3.4));  // 3.400000
    System.out.println(String.format("%.4f", n));  //123.5679
    System.out.println(String.format("%15f", n));     //     123.567890   
    // 15는 . 포함 전체 자리수
    System.out.println(String.format("%15.2f", n));   //         123.57
    System.out.println(String.format("%015.2f", n));  //000000000123.57

    System.out.println(" === 큰 정수값 long 테스트 ===");
    long now = System.currentTimeMillis();
    System.out.println("123456789012345678901234567890");
    System.out.println(now);
    // 3자리 구분 기호 , 를 출력. 자리수 20에 , 개수 포함됩니다.
    System.out.println(String.format("%,20d", now));
  }
}

package basic.day02;

public class A09WhileTest {

  public static void main(String[] args) {
    
      //반복문 : for, while

      int start =100;
      System.out.println("--- prefix ---");
      while(start < 105){
        System.out.println(++start);
      }
      //101,102,103,104,105

      System.out.println("--- postfix ---");
      // start=105
      start=100;      // 아래 반복문 테스트를 위해 다시 초기화
      // for(start=100;start<105;start++) { ... }
      while (start < 105) {
        System.out.println(start++);    
      }
      // 100,101,102,103,104

      // 1부터 100까지 더하는 반복문
      start=1;
      // 덧셈을 반복하면서 결과를 저장하는 변수 필요
      int sum =0; 
      // 반복문의 동작 :1) sum 에 start 를 더합니다.2) start를 +1 증가. 
      //          3) 조건식이 참이면 다시 1)번부터 실행
      while(start <=100){
          sum += start; // sum = sum + start; 
          System.out.println("start=" + start + ",sum = " + sum);
          start++;
      }

      System.out.println("-----------------------");
      // 출력문을 작성하지 않을 때
      start = 1;        //start=0; 으로 하면 sum += ++start; => ++ 하고 덧셈
      sum=0;
      while(start <=100){
        sum += start++;    //  덧셈 하고 ++
      }
      System.out.println("1부터 100까지의 합 = " + sum);

      int n = 10;
      int m = 20;
      sum=0;
      while(n<=m){
        sum += n++;    // 11번 반복
      }
      System.out.println("🤶n=10부터 m=20 까지의 합 = " + sum);

  }

}

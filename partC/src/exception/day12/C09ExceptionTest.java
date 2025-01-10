package exception.day12;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// 예외(exception) : 프로그램 실행이 비정상적을 상황을 만나는 것. -> 비정상적 종료
//              ㄴ 사용자의 입력값 오류, 프로그램의 오류 , 하드웨어 또는 네트워크 오류.....
// 예외를 처리하는 구문 필요 : try {   } catch { }  또는 throws
// 예외 타입의 최상위 클래스 : Exception 
//        자식 타입 예외 클래스 :   RuntimeException - 컴파일러는 모르고 실행 중에 발생하는 예외
public class C09ExceptionTest {

    // RuntimeException 처리
    public static void main(String[] args) {

      
      try {
         System.out.println(new C09ExceptionTest().userInput());
          new C09ExceptionTest().indexException();
      } 
      // catch(Exception e ){      
      // catch(RuntimeException e) {          
      // catch(NumberFormatException e) {
      catch(NumberFormatException | IndexOutOfBoundsException e) {
        // 예외가 발생하면 변수 e 에 예외 객체가 생성되어 참조됩니다.
        //      -> 예외 관련 정보 저장
          System.out.println("예외가 발생했습니다. : " + e.getMessage());
          e.printStackTrace();
      }

      // new C09ExceptionTest().listIndexException();
      new C09ExceptionTest().nullPointer();

      System.out.println("프로그램 실행 중입니다.");
      System.out.println("프로그램 종료합니다.");
    }

    public void nullPointer() {
      List<String> list = List.of("a","bb",null,"ccc");
      // 2번 인덱스는 참조가 없는 상태
      
      System.out.println(list.get(2).length());
      //java.lang.NullPointerException

      // 참고 : NullPointerException 을 방지하는 if 문을 작성해야 합니다.
      if(list.get(2)!=null){
        System.out.println(list.get(2).length());
      }

    }

    public void listIndexException() {
      List<String> list = List.of("a","bb","ccc");
      System.out.println(list.get(3));  //java.lang.ArrayIndexOutOfBoundsException
    }

    public void indexException(){
        int[] nums = new int[5];
        nums[2] =23;
        nums[5] =33;  // java.lang.ArrayIndexOutOfBoundsException  : 코드 오류
        System.out.println(Arrays.toString(nums));
    }

    public int userInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("정수값 입력해 주세요.");
       // int num = sc.nextInt();     // java.util.InputMismatchException : 잘못된 사용자 입력
        int num = Integer.parseInt(sc.nextLine());  //java.lang.NumberFormatException : 잘못된 사용자 입력
        sc.close();
        return num;
    }

}

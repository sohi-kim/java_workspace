package basic.day04;
import java.util.Arrays;

// Arrays 클래스(자바 jdk)의 메소드 테스트 
public class A26ArraysMethod {

  // Arrays.xxxxx(...) 와 같은 형식입니다. 아래 7개 메소드는 static 메소드

  public static void main(String[] args) {
        int[] arr1 = {110,620,930,540,250,880};
        int[] arr2 = new int[10];
        
     // 1. 배열 요소들을 , 로 연결하여 하나의 문자열로 생성
      String temp = Arrays.toString(arr1);  // [110, 620, 930, 540, 250, 880]
      System.out.println("arr1 : " + temp);
      System.out.println("arr2 : " +Arrays.toString(arr2));

    // 2. 배열의 모든 요소를 특정 값으로 저장하기
       System.out.println("2. Arrays.fill(arr2, 111)");
       Arrays.fill(arr2, 111);     //리턴없고, arr2 값을 변경  
       System.out.println("arr2 : " +Arrays.toString(arr2));
    
    // 3. 배열을 복사하기   
      int[] newarr = Arrays.copyOf(arr1, arr1.length);
      System.out.println("3. Arrays.copyOf(배열, 배열크기)");
      System.out.println("newarr : " + Arrays.toString(newarr)); 

    // 4. 배열의 요소값을 오름차순으로 정렬하기 (작은 값부터 큰값 순서로 나열)
      Arrays.sort(newarr);     //리턴없고, newarr 값을 변경 
      System.out.println("4. Arrays.sort(newarr)");  
      System.out.println("newarr : " + Arrays.toString(newarr)); 

    // 5. 서로 다른 2개의 배열 요소값 동등 비교
    int[] arr3 = {110,620,930,540,250,880};
    boolean isEqual = Arrays.equals(arr1, arr3);
    System.out.println("5. Arrays.equals(배열1, 배열2) ");
    System.out.println("arr1과 arr3은 내용이 같다 ? " + isEqual);   //true
    System.out.println("arr1과 newarr은 내용이 같다 ? " 
                    + Arrays.equals(arr1, newarr));   //false

   // 6. 배열 요소 값 찾기 : 리턴값이 0보다 크거나 같을 때만 찾기 성공
   int index = Arrays.binarySearch(newarr, 540);    // 2
   System.out.println("6. 배열 요소의 인덱스 찾기");
   System.out.println("binarySearch(newarr, 540) : " + index);                 
   System.out.println("binarySearch(newarr, 550) : " 
                  + Arrays.binarySearch(newarr, 550));   
                  //찾는 값이 없으면 0 보다 작은값
   
    System.out.println("7. 2개의 배열에서 서로 다른 값 인덱스 찾기");              
    System.out.println(Arrays.mismatch(newarr, 
              new int[]{110, 250, 550, 620, 880,930}));  //2
    System.out.println(Arrays.mismatch(arr1, 
              new int[]{110, 620, 930, 550, 250, 880}));  
              //정렬되지 않은 배열도 순서대로 비교하여 찾기  . 3

             


  }

}

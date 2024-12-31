package basic.day05;

import java.util.Arrays;

// 배열 복습
public class A28ArrayReview {

  public static void main(String[] args) {

    int[] iArr = {1,15,98,54,32};
    double[] dArr = {3.14, 5.789, 2.345, 7.2, 1.3};
    char[] cArr = {'H','e','l','l','o'};

    System.out.println("1. 배열 변수는 참조형 입니다. 저장된 값은 주소로 출력 ");
    System.out.println("정수 배열 iArr :  " + iArr); //[I@372f7a8d
    System.out.println("실수 배열 dArr :  " + dArr); //[D@85ede7b
    System.out.println("문자 배열 cArr :  " + cArr); //[C@5674cd4d

    System.out.println("2. 배열 요소를 모두 출력하는 Arrays 클래스 메소드");
    //  toString() 메소드의 인자가 배열. 배열의 주소를 전달.
    System.out.println(Arrays.toString(iArr));  
    System.out.println(Arrays.toString(dArr));
    System.out.println(Arrays.toString(cArr));

    System.out.println("3. 배열의 길이(개수) 속성 - length");
    System.out.println("iArr 의 요소 개수(길이) : " + iArr.length);
    System.out.println("dArr 의 요소 개수(길이) : " + dArr.length);
    System.out.println("cArr 의 요소 개수(길이) : " + cArr.length);

    System.out.println("4. 문자열을 char 배열로 만들어 주는 메소드");
    String test = "Hello, java!";

    char[] temp = test.toCharArray();   //test.charAt(i)
    System.out.println(Arrays.toString(temp));
    System.out.println(temp.length);     //배열의 길이는 속성에 저장
    System.out.println(test.length());   //문자열의 길이는 메소드 실행하여 리턴
    
    System.out.println("5. 배열의 참조값 이해");
    cArr = temp;      // 같은 타입의 배열일 때 대입문. 2개 변수 모두 char[]

    System.out.println("cArr = temp 의 결과 -------");
    // char[] 배열은 단독으로 출력하면 알아서 문자열로 취급하여 출력
    //System.out.println(cArr);    // Hello, Java! 출력
    System.out.println("cArr :" + cArr);  // [C@19469ea2
    System.out.println("temp : " + temp); // [C@19469ea2 
    System.out.println(Arrays.toString(cArr));
    temp[6]='*';
    System.out.println(Arrays.toString(cArr));
    // temp 변수로 인덱스 6 번 값 변경한것이 cArr 변수로 접근해도 
    // 인덱스 6번은 변경되어 있습니다. 
    // 같은 메모리 위치를 2개의 변수가 지정하고 있기 때문입니다.
  }

}

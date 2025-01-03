package object.day7;

import java.util.ArrayList;

// 배열처럼 여러개의 데이터를 저장하는 '자료구조'.
// 좋은 점: 1) 크기가 고정되어 있지 않다.(크기가 동적)   2) 추가(삽입)와 삭제 메소드가 있다.
// 문법적 특징 : Generic Type 기호 <> 에 저장할 데이터의 타입을 지정합니다.
public class B14ArrayList {

  public static void main(String[] args) {

     ArrayList<String> list = new ArrayList<>();
     System.out.println("현재 리스트의 크기 (데이터 갯수) : " + list.size());   // 0

     // 1. 데이터를 리스트에 저장(추가)하기
     list.add("트와이스");
     list.add("아이브");
     list.add("소녀시대");
     list.add("뉴진스");
     System.out.println("현재 리스트의 크기 (데이터 갯수) : " + list.size());  // 4


     //2.  데이터를 가져와서 저장 또는 출력하기 - 인덱스로 지정.
    System.out.println(list.get(0));   // 트와이스
    System.out.println(list.get(1));   // 아이브
    System.out.println(list.get(2));   // 소녀시대
    System.out.println(list.get(3));   // 뉴진스
    //IndexOutOfBoundsException: Index 4 out of bounds for length 4
    // System.out.println(list.get(4));   // 오류

    //3. 중간 삽입
    list.add(2,"아이오아이");

    //4. 리스트의 요소들을 출력하기 - 내부적으로 문자열 생성하는 메소드 정의
    System.out.println(list);      // 참고 : 배열 Arrays.toString(배열변수)

    // 5. 기존 값 수정
    list.set(3,"마마무");
    System.out.println(list);

    //6. 기존 값 삭제
  //  list.remove("마마무");
    System.out.println(list);

  //  list.remove(0);
    System.out.println(list);


    //7. 리스트에 반복문 적용하기
    for(String str : list){
       System.out.println("값 : " + str + ", 길이 : " + str.length());
    }
  }
}
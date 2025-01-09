package collection.day11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//ArrayList
public class C01ArrayListTest {
  // 메소드 : add(값) , get(인덱스) , remove(값 또는 인덱스) , set(인덱스, 값)
  //          contains(값) , indexOf(값)
  public static void main(String[] args) {

        //리스트를 만드는 방법 1
        List<String> list = new ArrayList<>();  
        // list 변수로 사용하는 메소드는 only List 인터페이스 -> List 타입으로 선언

        list.add("sana"); list.add("momo"); list.add("nana");

        // 방법 2 : List 의 static 메소드로 데이터를 저장하면서 생성
        List<String> test = List.of("sana","momo","nana","dahyen");

        // 방법 3 : 배열을 리스트로 변환 (기존에 배열에 저장한 것을 리스트로 변환하여 검색)
        String[] arr = {"sana","momo","nana","사나"};

        List<String> alist = Arrays.asList(arr);


        System.out.println("ArrayList : " + list + "("+ list.size()+")");
        System.out.println("List.of : " + test + "("+ test.size()+")" );
        System.out.println("Arrays.asList : " + alist + "("+ alist.size()+")");
      //list,test, alist 변수 출력하면 참조값이 아니라 문자열로 출력.
      //    -> 자바 JDK 에서 List 의 'toString 메소드를 재정의 '했습니다.


        // 방법 1은 가변 객체 List , 방법 2와 3은 불변 객체 List
    
  }
}

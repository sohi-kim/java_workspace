package object.day7;

import java.util.ArrayList;

// 리스트 자료구조에 객체를 저장하기
public class B15ObjectArrayList {

  public static void main(String[] args) {

    ArrayList<MyRandomMath> list = new ArrayList<>();

    //객체를 10개 생성하고 순서대로 리스트에 저장하기
    for(int i=0;i<10;i++){
      System.out.println("\n-----" + i + "------- ");
      list.add(new MyRandomMath());   // 추가하면 인덱스 값은 순서대로 0,1,2,3,......
      System.out.println(list.get(i).toString());    // 0 + 0 = 0
      list.get(i).makeNumber(50, 99);   // 리스트 자료구조도 인덱스 사용하여 접근.
      System.out.println(list.get(i).toString());    // ... + ... = ....
      System.out.println("현재 리스트의 크기 : " + list.size());
    }
    // System.out.println("리스트의 크기 : " + list.size());
    // System.out.println("샘플 인덱스 3번 출력 : " + list.get(3).toString());
    System.out.println("==== 리스트의 수식 전체 출력하기 ====");
    // for(MyRandomMath temp : list){
    //   System.out.println(temp.toString());
    // }

    //for(int i=0;i<list.size();i++){
    //   System.out.println(list.get(i).toString());
    //}
  }
}


class MyRandomMath {

      private int first;
      private int second;

      //기본생성자로 객체를 만듭니다. -> 생성자 정의 코드는 생략.
      
      public void makeNumber(int start, int end){
        this.first = (int)(Math.random()*(end-start+1)) + start;
        this.second = (int)(Math.random()*(end-start+1)) + start;
      }

      public String toString(){
            return String.format("%d + %d = %d", 
                    this.first, this.second, this.first+this.second);
      }

}
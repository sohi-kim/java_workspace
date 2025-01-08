package object.day10;

import java.util.Arrays;

public class B30ComparatorTest {
  public static void main(String[] args) {
    // 객체는 여러 필드로 구성된 데이터입니다. 비교(정렬)할 때 기준필드값이 필요합니다.
    // 그 기준값을 전달하는 방법이 Comparable , Comparator 인터페이스 사용입니다.
    Member[] members = new Member[4];
    members[0] = new Member("sana", 23);
    members[1] = new Member("momo", 27);
    members[2] = new Member("nayeon", 33);
    members[3] = new Member("dahyeon", 25);

    //Comparator 인터페이스 활용한 Arrays.sort 실행하기
    //    ㄴ 구현을 어디에 하는지 찾아보기?
    // Arrays.sort(members, Comparator 를 구현한 클래스 객체)

      Arrays.sort(members, new AscendingNameComparator());
      System.out.println("이름 필드 오름차순 정렬한 결과 //");
      System.out.println(Arrays.toString(members));

      //?
      Arrays.sort(members, new DecendingNameComparator());
      System.out.println("이름 필드 내림차순 정렬한 결과 //");
      System.out.println(Arrays.toString(members));
  }
}

class Member  {
  private String name;
  private int age;

  Member(String name, int age){
    this.name=name;
    this.age=age;
  }

  @Override
  public String toString() {
    return "Member [name=" + name + ", age=" + age + "]";
  }

}
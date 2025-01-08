package object.day10;

import java.util.Comparator;

// Comparator 구현 클래스 입니다. -> sort 할 때에는 객체생성(구현체)해서 전달
public class AscendingNameComparator implements Comparator<Member>{   
  // '이름'으로 오름 차순

   @Override
   public int compare(Member o1, Member o2) {
     return o1.getName().compareTo(o2.getName());
   }  

}

class DecendingNameComparator implements Comparator<Member>{   
  // '이름'으로 내림 차순

   @Override
   public int compare(Member o1, Member o2) {
     return o2.getName().compareTo(o1.getName());
   }  

}


class Member  {
  private String name;     // String은 Comparable 타입 - compareTo 메소드로 비교 가능
  private int age;

  Member(String name, int age){
    this.name=name;
    this.age=age;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }
  
  @Override
  public String toString() {
    return "Member [name=" + name + ", age=" + age + "]";
  }

}
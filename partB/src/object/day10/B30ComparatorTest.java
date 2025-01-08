package object.day10;

public class B30ComparatorTest {
  public static void main(String[] args) {

    Member[] members = new Member[4];
    members[0] = new Member("sana", 23);
    members[1] = new Member("momo", 27);
    members[2] = new Member("nayeon", 33);
    members[3] = new Member("dahyeon", 25);

    //Comparator 인터페이스 활용한 Arrays.sort 실행하기
    //    ㄴ 구현을 어디에 하는지 찾아보기?
    // Arrays.sort(members, Comparator 를 구현한 클래스 객체)


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
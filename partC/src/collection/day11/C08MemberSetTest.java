package collection.day11;

import java.util.HashSet;
import java.util.Set;

// Set 은 동일한 값은 한번만 저장한다.
public class C08MemberSetTest {

  public static void main(String[] args) {
    Set<Member> members = new HashSet<>();
    members.add(new Member("사나", 11111));
    members.add(new Member("모모", 22222));
    members.add(new Member("사나", 11111));
    System.out.println(members.size());   //3

    Member m1 = new Member("사나", 11111);
    Member m2 = new Member("사나", 11111);
    System.out.println(m1.hashCode()==m2.hashCode());  //false
    System.out.println(m1.equals(m2));   //false


    Set<Person> persons = new HashSet<>();
    persons.add(new Person("사나", 11111));
    persons.add(new Person("모모", 22222));
    persons.add(new Person("사나", 11111));
    System.out.println(persons.size());   // 2
    Person p1 = new Person("사나", 11111);
    Person p2 = new Person("사나", 11111);
    System.out.println(p1.hashCode()==p2.hashCode());   //true
    System.out.println(p1.equals(p2));  //true

  }
}

// Value Object : 일반적인 값처럼 동작시키는 클래스 정의입니다.
//      setter 없고 생성자에서 초기화 하므로 불변 객체
//      hashcode() , equals() 메소드 재정의하여 객체의 동일성 검사 가능
class Person {
  private String name;
  private int id;

  Person(String name, int id){
    this.name = name;
    this.id=id;
  }

  // Object 클래스가 물려준 2개의 메소드 재정의
  // -> 동일 객체를 정의하기 위한 것. 

  // name, id 필드값이 같으면 hashcode(주소 참조값) 가 같은 값으로 계산되는 수식
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + id;
    return result;
  }
// name, id 필드값이 같으면 equals 가 참이 되는 조건식
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Person other = (Person) obj;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (id != other.id)
      return false;
    return true;
  }

   

}


class Member {
  private String name;
  private int id;

  Member(String name, int id){
    this.name=name;
    this.id=id;
  }
}

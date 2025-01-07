package object.day9_interface;

import java.util.Arrays;

// sort : 여러 개 데이터를 값의 순서에 따라 나열하는 것(오름차순 또는 내림차순)
public class B29ArraysSortTest {

  public static void main(String[] args) {
    // Arrays.sort(배열변수) : 배열의 요소를 정렬합니다. 
    //    -> sort 메소드의 인자 타입을 알아보세요.(배열 타입)

    String[] names = {"sana","momo","nayeon", "dahyeon","Nana"};
    Arrays.sort(names);  // 정렬 결과로 names 배열 요소 순서를 변경
    System.out.println(Arrays.toString(names));

    Person[] persons = new Person[4];
    persons[0] = new Person("sana", 23);
    persons[1] = new Person("momo", 27);
    persons[2] = new Person("nayeon", 33);
    persons[3] = new Person("dahyeon", 25);

    // 객체를 정렬하기 - 정렬기준이 되는 필드를 선택
    //                    ㄴ Comparator(비교자), Comparable(비교가능한) 인터페이스 중 하나로 구현하기

    Arrays.sort(persons);    // 배열의 타입이 Comparable 타입이어야 합니다.
    // String 은 Comparable<String> 구현체 입니다.-> sort 메소드 실행 가능
    // 오류 -> 가능하게 하려면 Person 을 Comparable 인터페이스로 구현
    System.out.println(Arrays.toString(persons));
  }
}

// Person 에 비교 기능을 추가 -> 정렬
class Person implements Comparable<Person> {
  private String name;
  private int age;

  Person(String name, int age){
    this.name=name;
    this.age=age;
  }

  @Override
  public String toString() {
    return "Person [name=" + name + ", age=" + age + "]";
  }

  // Comparable 의 추상메소드
  @Override
  public int compareTo(Person o) {    // 인자 o 변수는 비교대상을 참조
    // return o.name.compareTo(this.name);    // 이름 name 필드값으로  정렬할 때(내림차순)
    // return this.name.compareTo(o.name);    // 이름 name 필드값으로  정렬할 때(오름차순)
    
    // return this.age.comparTo(o.age);    // age 필드가 Integer 일때 가능
      return this.age - o.age;       // 오름 차순
      // return o.age - this.age;    // 내림차순
  }
  
}
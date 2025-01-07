package object.day9;

import java.util.ArrayList;

public class B25AbstractAnimal {

  public static void main(String[] args) {
    
    ArrayList<AbstractAnimal> farm = new ArrayList<>();
    farm.add(new ACat("후추", "black"));
    farm.add(new ADog("마루", "brown"));
    farm.add(new ADog("해피", "white"));
    farm.add(new AFrog("케로로", "gray"));
    farm.add(new AFrog("아로미", "green"));

    Person sana = new Person("사나", 17);
    boolean result = sana.isAdopt(farm.get(2));     //사나가 2번 객체를 분양 받을 수 있나?
    System.out.println("sana의 dog 분양 가능 : " + result);   //true
    System.out.println("sana의 cat 분양 가능 : " + sana.isAdopt(farm.get(0)));  // false
  }
}

// Person 클래스의 메소드가 AbstractAnimal 클래스를 '사용'하게 됩니다.
class Person {
    
    private String name;
    private int age;
    private AbstractAnimal animal;     //반려동물 객체를 저장하는 필드

    Person(String name, int age){
      this.name = name;
      this.age= age;
    }

    // 분양 여부에 대한 처리 방법:
    // 고양이는 20세 이상, 강아지는 15세 이상, 개구리는 10세 이상 입양가능함.
 
    public boolean isAdopt(AbstractAnimal animal){
        boolean result = false;
        if(animal instanceof ACat && this.age >=20) result=true;
        else if(animal instanceof ADog && this.age >=15)  result=true;
        else if(animal instanceof AFrog && this.age >=10) result=true;

         return result;
    }
    
}
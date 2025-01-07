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

    
  }
}

class Person {
    
    private String name;
    private int age;

    Person(String name, int age){
      this.name = name;
      this.age= age;
    }

    // 고양이는 20세 이상, 강아지는 15세 이상, 개구리는 10세 이상 입양가능함.
 

    
}
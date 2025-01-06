package object.day8;

import java.util.ArrayList;

public class B21AnimalChildTest {

  public static void main(String[] args) {
      // 다형성 예시
      Eagle eagle = new Eagle();
      Frog frog1= new Frog();
      Frog frog2= new Frog();
      Dog dog = new Dog();


      ArrayList<Animal> farm = new ArrayList<>();
      // 리스트의 타입이 Animal 부모 클래스 타입입니다.=> Animal 의 자식 객체를 이 리스트에 저장
      // 할 수 있다.(UpCasting)
      farm.add(eagle);
      farm.add(frog1);
      farm.add(frog2);
      farm.add(dog);

      System.out.println("우리 동물 농장의 동물들 " + farm.size() + "마리");
      for(Animal ani : farm){
        System.out.println(ani.toString());
        ani.sound();    //**
        System.out.println("--");
      }
      // 메소드 오버라이드는 상속받은 sound() 메소드를 각각 자식 객체가 다르게 실행되도록
      // 합니다. - 다형성 예시

      


  }

}

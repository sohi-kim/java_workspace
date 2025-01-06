package object.day8;

public class Animal {

  protected String aniName;
  protected int age;
  protected String color;

  public void sound(){
    System.out.println("동물 소리 들어보기//");
  }

}

class Eagle extends Animal {

  // 1. 자식 클래스의 인스턴스 메소드
    public void fly(){
      System.out.println("시속 100km 로 날수 있습니다.");
    }

  // 2. 부모 클래스의 인스턴스 메소드 재정의
  @Override
  public void sound() {
     super.sound();
     System.out.println("🐦휘이잉");
  }  

}

class Frog extends Animal {
  
  // 1. 자식 클래스의 인스턴스 메소드
  public void jump(){
    System.out.println("높이 1m 로 점프 할 수 있습니다.");
  }

  //2. 
  @Override
  public void sound() {
    super.sound();
    System.out.println("개굴개굴 🐸");
  }
}

class Dog extends Animal {

  // 1. 자식 클래스의 인스턴스 메소드
  public void home(){
    System.out.println("집을 잘 지킵니다.");
  }

  //2. 
  @Override
  public void sound() {
    super.sound();
    System.out.println("멍멍 멍멍멍 🐶");
  }
}
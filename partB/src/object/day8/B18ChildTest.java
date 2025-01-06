package object.day8;

public class B18ChildTest {
  public static void main(String[] args) {
    Child ch1 = new Child();    
    // 항상 new Parent() 실행하여 부모 객체를 만들고 추가된 자식 인스턴스로 자식 객체가 완성.
    ch1.say();
    /*  실행 결과: 
     *  Parent 객체 생성
        Child 객체 생성 
        java
     * 
     */
    ch1.hello("하이~");    // 부모가 물려준 메소드 실행
    System.out.println("//// 새로운 child 생성하기 /////");
    Child ch2 = new Child(3.1419);
    // 항상 new Parent() 실행
    ch2.hello("굿바이 ~");


    // 생성자의 문제
    ErrorChild ech = new ErrorChild();
    // 항상 new ErrorParent() 실행 - 부모의 기본생성자 정의가 없으면 오류
  }

}
/*
 *  여기까지 테스트는 부모의 코드를 자식이 재사용 할수 있는 상속을 확인했습니다.
 *  
 *  메소드의 인자로 클래스 타입을 사용할 때 상속 관계가 갖는 주요 특징 있습니다. => 다형성 예시
 */

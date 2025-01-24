package day2;

public class SingletonTest {

  public static void main(String[] args) {

    // TestDao dao = new TestDao();   // 오류: private 생성자
    TestDao dao = TestDao.getInstance();
    dao.hello();
    dao.goodbye();

  }

}

// 싱글톤 패턴으로 정의
//    ㄴ 값을 저장하지 않는 클래스 정의로 만들어진 객체는 여러번 생성할 필요가 없습니다.
//    ㄴ new TestDao() 는 메모리를 새로 할당 받습니다. 그러나 , dao 와 같이 데이터를 저장하지
//       않고 메소드 실행만 하는 경우 싱글톤 패턴으로 정의할 수 있습니다.
class TestDao{
  // 싱글톤 패턴 정의 순서

  //순서 2. 자신타입의 static 변수 선언. 초기값으로 객체 할당
  private static TestDao dao = new TestDao();

  //순서 1. private 생성자 정의
  private TestDao() {   // private 생성자 : 이 클래스 정의안에서만 사용
  }

  //순서 3. 자신 타입의 객체(순서 2) 리턴할 메소드 static 메소드 정의. 이름은 getXXXXX
  public static TestDao getInstance(){
    return dao;
  }

  public void hello(){
    System.out.println("hello");
  }

  public void goodbye(){
    System.out.println("goodbye~");
  }
}

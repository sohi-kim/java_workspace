package object.day9;

public class B23InstanceofTest {

  // '부모타입으로 업캐스팅'된 자식 타입의 객체를 검사 => 다운캐스팅 클래스타입을 결정
  public static void main(String[] args) {
      // 부모타입 참조
      Shape sh1 = new Circle(26);
      Shape sh2 = new Rectangle(25, 25);
      Shape sh3 = new Rectangle(40, 20);
      Shape sh4 = new Triangle(40, 40);

      // 업캐스팅 변수 sh1,sh2,sh3,sh4 의 객체 타입 검사하기
      boolean result = sh1 instanceof Triangle;
      System.out.println("각 도형 객체가 삼각형인지 검사하기 //");
      System.out.println("sh1 instanceof Triangle : " + result);
      System.out.println("sh2 instanceof Triangle : " + (sh2 instanceof Triangle));
      System.out.println("sh3 instanceof Triangle : " + (sh3 instanceof Triangle));
      System.out.println("sh4 instanceof Triangle : " + (sh4 instanceof Triangle));

      // 연습 메소드 활용
      System.out.println("각 도형 객체가 원 인지 검사하기 //");
      System.out.println("isCircle(sh1) : " + isCircle(sh1));
      System.out.println("isCircle(sh2) : " + isCircle(sh2));
      System.out.println("isCircle(sh3) : " + isCircle(sh3));
      System.out.println("isCircle(sh4) : " + isCircle(sh4));


      // 다운 캐스팅 : 업캐스팅 한 참조변수를 자식 타입으로 변환
      // java.lang.ClassCastException: class object.day9.Circle cannot be cast 
      //                            to class object.day9.Triangle
      //Triangle tri = (Triangle)sh1;    // 오류: 자식 타입 불일치
      
      Triangle tri=null;      
      // if 조건이 거짓이면 tri 출력문 오류. 초기화 안되었음.=> null 초기화 필요
      if(sh4 instanceof Triangle)
         tri = (Triangle)sh4;
      System.out.println(tri);      
  }


  // 인자로 전달된  도형이 Circle 객체인지 검사하는 메소드 (참, 거짓 리턴)
  public static boolean isCircle(Shape shape){    //퀴즈 ()안에 인자 선언은?

    if(shape instanceof Circle)
        return true;
    return false;
  }

  public static boolean isRectangle(Shape shape){

    return shape instanceof Rectangle? true : false;
  }

}

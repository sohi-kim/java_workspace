package object.day5.solution;

public class B05RectangleTest {

  public static void main(String[] args) {
    Rectangle red = new Rectangle();
    red.width = 220;
    red.height = 300;
    red.shapeName = "Red 사각형";
    System.out.println("red 참조 사각형 의 넓이 : " + red.getArea());
    System.out.println("red 참조 사각형 의 둘레 길이 : " + red.getLength());
    System.out.println(red.draw("🟥"));

    Rectangle blue = new Rectangle();
    blue.width = 450;
    blue.height = 234;
    blue.shapeName = "Blue 사각형";
    System.out.println(blue.draw("🟦"));
    
    System.out.println(red);        // object.day5.solution.Rectangle@16b98e56 는 패키지이름.클래스이름@주소참조값
    System.out.println(blue);       // object.day5.solution.Rectangle@7ef20235

    System.out.println("=== 객체.hashcode() : 주소참조값을 10진수로 리턴 ===");
    System.out.println("red.hashCode() : " + red.hashCode());   // 381259350
    System.out.println("blue.hashCode() : " + blue.hashCode()); //  2129789493

    System.out.println("=== 객체 hashcode 값을 16진수로 출력합니다. === ");
    //int 데이터형을 클래스로 Wrap 한 클래스 Integer
    System.out.println(Integer.toHexString(red.hashCode()));
    System.out.println(Integer.toHexString(blue.hashCode()));

    //Integer, Long, Double, Float 등의 클래스는 기본데이터타입에 대한 Wrapper 클래스라고 합니다.

   
  }

}

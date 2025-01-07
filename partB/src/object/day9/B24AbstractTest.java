package object.day9;

public class B24AbstractTest {
// Shape 과 AbstractShape 비교

   public static void main(String[] args) {

       //1. 부모 객체 생성 가능
       Shape sh = new Shape();
       System.out.println(sh + ", 넓이 = " + sh.area());

      //2. 부모 객체 생성 불가 : AbstractShape는 추상클래스이기 때문에.
      // AbstractShape absh = new AbstractShape(230,450);   // 오류

      System.out.println("추상클래스 테스트 //");
      AbstractShape tri = new ATriangle(45, 34);
      System.out.println(tri);

      AbstractShape rec = new ARectangle(45, 34);
      System.out.println(rec);

      //3. 추상클래스로 익명 클래스 정의
      //   AbstractShape 클래스 기본생성자가 없었으므로 커스텀 생성자로 만듭니다.
      //   익명 클래스 : '이름이 없는 자식 클래스'. 추상클래스의 추상메소드를 new 연산에서 정의합니다.
      //            -> 클래스 정의를 하면서 객체를 생성합니다.
      AbstractShape absh = new AbstractShape(0,0) 
      // 익명 클래스 정의 부분 - 이름이 없어서 재사용 못함.(1회용)
      {

        int radius = 20;   //반지름. 익명클래스에서 추가로 필드(지역변수) 정의 가능.
        @Override
        public long area() {    // 원의 넓이
          return (long)((this.radius * this.radius) * 3.1419);
        }

        @Override
        public long length() {   // 원의 둘레
          return (long)(2*3.1419*this.radius);
        }

        // 익명 클래스 내용에 맞게 toString 재정의 하기
        @Override
        public String toString() {
          return "AbstractShape [반지름=" + radius +  ", 원의 둘레 = " + length() +
          ", area()=" + area() + ", getClass()=" + getClass() + "]";
        }
      };  // 익명 클래스 끝

      System.out.println(absh);
      
   }  // main end
}

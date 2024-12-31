package object.day5;

// 자바의 Math클래스는 static 메소드로 이루어져 있습니다.
// 우리의 MyMath 는 사칙연산을 하는 인스턴스 메소드를 만들어보겠습니다.

public class MyMath {
      // 클래스의 인스턴스 변수 선언 : 객체를 생성한 후 값을 대입
      int first;
      int second;
      int result;    // 사용 보류

      // 인스턴스 메소드 정의  : 생성된 객체의 데이터(인스턴스 변수)를 다루는 메소드
      public int add(){
        return first + second;
      }

      public int substract(){
        return first - second;
      }

      public int multiply(){
        return first * second;
      }


      public void print(int type) {
          // switch 문을 이용하여 type 1,2,3 각각에 대해
          // 2 + 3 = 5  또는 2 - 3 = -1 또는 2 * 3 = 6 과 같이 '출력 해보기'
          // -> print 메소드에서 add(), substract(), multiply() 메소드를 호출하여 결과값 구합니다.
          switch (type) {
            case 1:
              System.out.println(String.format("null", null));
              break;
            case 2:
            
              break;
            case 3:

              break;
            default:
              break;
          }
        
      }

}

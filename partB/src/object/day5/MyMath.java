package object.day5;

// 자바의 Math클래스는 static 메소드로 이루어져 있습니다.
// 우리의 MyMath 는 사칙연산을 하는 인스턴스 메소드를 만들어보겠습니다.

public class MyMath {
      // 클래스의 인스턴스 변수 선언 : 객체를 생성한 후 값을 대입
      int first;
      int second;
      int result;    // 사용 보류

      // 상수 static final 활용
      static final int ADD = 1;
      static final int SUB = 2;
      static final int MUL = 3;

      // 인스턴스 메소드 정의  : 생성된 객체의 데이터(인스턴스 변수)를 다루는 메소드
      // 유형 1: 각각의 연산을 실행한 결과로 리턴값을 전달하는 메소드
      public int add(){
        return first + second;
      }

      public int substract(){
        return first - second;
      }

      public int multiply(){
        return first * second;
      }

      // 유형2: 인자로 전달된 타입으로 연산을 선택하여 실행하고 출력하는 메소드.리턴없음
      public void print(int type) {
          // switch 문을 이용하여 type 1,2,3 각각에 대해
          // 2 + 3 = 5  또는 2 - 3 = -1 또는 2 * 3 = 6 과 같이 '출력 해보기'
          // -> print 메소드에서 add(), substract(), multiply() 메소드를 호출하여 결과값 구합니다.
          switch (type) {
            case 1:
            // 234 + 456 = 690
              System.out.println(String.format("%d + %d = %,d",
                                              this.first,this.second,add()));
              break;
            case 2:
            // 234 - 456 = -222
              System.out.println(String.format("%d - %d = %,d",
                                              this.first,this.second,substract()));
              break;
            case 3:
              System.out.println(String.format("%d x %d = %,d",
                                                this.first,this.second,multiply()));
              break;
            default:
              System.out.println("잘못된 타입입니다.");
              break;
          }
        
      }


      // *유형 3*: 유형 2와 동작은 유사. 단, 문자열 리턴값을 갖고 static final 상수(기호) 활용.
      public String mathToString(int type){
        String result;   //선언
        switch (type) {
          case ADD:    // 정수값 1 비교
            result = String.format("%d + %d = %d", this.first,this.second,add());
            break;
          case SUB:
            result = String.format("%d - %d = %d", this.first,this.second,substract());
            break;
          case MUL:
            result = String.format("%d x %d = %d", this.first,this.second,multiply());
            break;
          default:
            result = "잘못된 type 입니다.";
            break;
        }
        return result;
      }

}

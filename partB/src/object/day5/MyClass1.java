package object.day5;

// 클래스 정의 기본 : 변수
public class MyClass1 {
     
      // 인스턴스 속성(변수) :'객체를 생성'하여 접근하는 변수. MyClass1 원본을 바탕을 복사본.
      //                : '객체를 생성'할 때마다 다른 값을 저장.
      String field1;
      int field2;

      // static 속성(변수) : 클래스 이름으로 접근하는 변수. 정적 변수
      //            : 객체를 생성하지 않고 사용하는 변수. 객체와 상관없이 같은 값을 저장.
      static double field3;
      static String field4;

      // final 키워드 : 값을 변경할 수 없는 변수. 초기값을 반드시 저장해야 합니다.
      // static final : 상수(대문자로 표기). 자바스크립트의 const 같은 성질.
      public static final int TEST_VALUE = 1234;


}

// public 이 아닌 것은 default 접근 클래스
// -> 같은 패키지에서만 사용하는 클래스
class MyClass2 {
    String name;
    int age;

    static int type;
}
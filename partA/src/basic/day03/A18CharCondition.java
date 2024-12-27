package basic.day03;

public class A18CharCondition {

  //  char 타입 데이터의 조건식
   public static void main(String[] args) {

            char test ='c';
            boolean result;

            //test 에 저장된 문자가 대문자? 
           result = (test >='A' && test <= 'Z');   // && 그리고
           //     코드값 >= 65 && 코드값 <= 90
           System.out.println("test 에 저장된 문자 대문자 검사 : " + result);   // false

           //test 에 저장된 문자가 소문자?
           result = (test >='a' && test <= 'z');
           //     코드값 >= 97 && 코드값 <= 122
           System.out.println("test 에 저장된 문자 소문자 검사 : " + result);   // true

            //test 에 저장된 문자가 영문자?
           result = (test >='A' && test <= 'Z') || (test >='a' && test <= 'z');   // || 또는
           System.out.println("test 에 저장된 문자 영문자 검사 : " + result);     // true

           test = '4';
           // test 에 저장된 문자가 숫자인가?
           result = (test >= '0' && test <='9');      // true
           System.out.println("test 에 저장된 문자 숫자 검사 : " + result); 
   }

}

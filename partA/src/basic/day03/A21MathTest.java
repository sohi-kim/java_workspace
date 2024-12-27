package basic.day03;

// 자바 jdk 에서 제공하는 Math 클래스의 메소드 확인 - 수학 관련 공식
//                        Character 클래스 - 대소문자 검사
public class A21MathTest {

  public static void main(String[] args) {

        int n1=23, n2=34;

        System.out.println("Math.min(n1, n2) : " + Math.min(n1, n2));
        System.out.println("Math.max(n1, n2) : " + Math.max(n1, n2));

        int n3 = 45;
        System.out.println(Math.max(Math.max(n1, n2),n3) + "=> 가장 큰값");
    
        // 실수의 반올림, 올림, 내림 하여 변환 
        double dval = 5.64;
        System.out.println("Math.round(dval) : " + Math.round(dval));   // 반올림

        System.out.println("Math.ceil(dval) : " + Math.ceil(dval));   // 올림

        System.out.println("Math.floor(dval) : " + Math.floor(dval));    // 내림
 
        //
        System.out.println(Character.toUpperCase('a'));   // 대문자 검사
        System.out.println(Character.isLowerCase('A'));   // 소문자 변환
        
 
      }

}

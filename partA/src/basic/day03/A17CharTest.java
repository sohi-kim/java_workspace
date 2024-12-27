package basic.day03;

// 문자열은 "" 기호 안에 작성. 문자열은 개수(length) 에 제한이 없다.
// 문자(Character) 는 '' 기호 안에 작성. 꼭 1개의 문자를 표기
// char 키워드로 타입 지정. 
public class A17CharTest {

     public static void main(String[] args) {
         
          char test_ch = 'a';

          System.out.println(
            String.format("테스트 문자 : %c , %s", test_ch,test_ch)
          );  // 서식 문자 %c 또는 %s 사용 가능

          System.out.println("==char 타입 변수 증감 연산자 테스트==");
          System.out.println(test_ch++);   // a 출력. test_ch는 'b'
          System.out.println(test_ch++);   // b 출력. test_ch는 'c'
          System.out.println(test_ch++);   // c 출력. test_ch는 'd'
          
          System.out.println(--test_ch);   // test_ch는 'c' . c 출력
          // char 타입으로 실행할 수 있는 산술연산은 ++ 또는 --
          // + 와 - 은 정수와 실수로만 할 수 있습니다.

          ////////////////////////////////////////////////////
          // 문자는 각각 이진수값으로 표현해서 컴퓨터가  처리 합니다.
          //             이진수값을 만드는 체계에 따라 여러 인코딩 방식이 있습니다.
          // 현재 UTF-8 인코딩 방식을 사용합니다. 'char를 int 로 타입 변환'하면 코드값을 저장.
          test_ch = 'a';
          int code = test_ch;           // 자동캐스팅 
          System.out.println(code);    // 97('a')  99('c')
          
          // char 타입으로는 할 수 없는 연산 +=, -= , + , -
          code += 2;          // 99
          System.out.println("- code 값 출력 -");
          System.out.println(String.format("%d", code));   // 99
          // code 정수값에 해당되는 문자가 있으면 문자로 자동캐스팅 출력
          System.out.println(String.format("%c", code));   // c 

          //
          char ga = '가';
          char hit = '힣';

          // 각각의 코드값을 출력. 출력된 값을 이용해서 '가'~'힣' 사이에 몇개의 문자가 있는지 
          // 뺄셈으로 구해보세요.
          int code_ga = ga;
          int code_hit = hit;
          System.out.println(code_ga);
          System.out.println(code_hit);
          System.out.println("한글 음절의 갯수 : " + (code_hit-code_ga+1));

          System.out.println(String.format("가 = %d , %x", code_ga,code_ga));   // ac00
          System.out.println(String.format("힣 = %d , %x", code_hit,code_hit)); // d7a3

          // 정수 코드값 50000 은 무슨 글자일까요?
          System.out.println(String.format("%c", 50000));   //자동 캐스팅
          int some = 50000;
          char some_code = (char)some;   //강제 캐스팅
          System.out.println(some_code);
     }

}

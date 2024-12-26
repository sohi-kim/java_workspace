package basic.day02;

// 문자열 저장 및 활용 : 자바에서 문자열은 String 클래스 타입입니다.
//                                  ㄴ 참조타입 변수(그림 참고)
// int, long, double,boolean 등은 기본형(primitive) 데이터 타입.
public class A10StringTest {

  public static void main(String[] args) {
      // 문자열을 저장하기 위한 변수 선언
      String message = "Hello~ Java. 자바";

      System.out.println(message);
      // 문자열의 길이: 문자 갯수
      // 메소드의 인자 없음. 리턴 있음
      System.out.println("message.length() : "+ message.length());
      System.out.println("message.toUpperCase() :" + message.toUpperCase());
      // 소문자로 변환하는 것은 toLowerCase()

      // 메소드의 인자 있음. 리턴 있음
      System.out.println("message.charAt(4) : " + message.charAt(4)); // 'o'
      System.out.println("message.indexOf(\"Java\") :" 
                    + message.indexOf("Java"));  // 
      // 2개의 문자열을 연결하기
      String result = message.concat("🤶🎅");
      System.out.println("result : " + result);
      System.out.println("result.length():" + result.length());   
      // 예상값 17  결과값 19 (이모지는 3~4바이트를 사용. 자바에서 2바이트까지 1글자 )

      // 주요 문자열 메소드
      message.substring(3);    //인덱스 3 부터 끝까지 추출
      message.substring(3,7);   // lo~ 
      message.replace(" ", "**"); //공백을 ** 로 치환
      message.startsWith("Hello");   // 참 (대소문자 구분)
      message.endsWith("Hello");     // 거짓
      message.lastIndexOf(" ");       // 마지막 매칭되는 문자열의 위치


  }

}

package io.day12;

import java.io.FileOutputStream;
import java.io.IOException;

// '표준 입력' 스트림 -> '파일' 출력 스트림
//  파일 입력 또는 파일 출력 장치는 프로그램 종료할 때 장치 '닫기'를 실행합니다.
//        -> try ~ catch ~ finally  사용해서 finally 에 작성합니다.
public class C13FileOutputTest {

   public static void main(String[] args) {
        FileOutputStream fos=null;    // 파일 출력 스트림 변수 선언
        int b;
        int count=0;
        try {
          fos = new FileOutputStream("메모장.txt");   // 파일 출력 스트림 객체 생성
                                      //     ㄴ 파일명
          System.out.println("입력하세요. ↓↓↓↓↓↓↓↓");
          while ((b=System.in.read()) !=-1) {
            // System.out.write(b);  
            fos.write(b);
            count++;
          }
          System.out.println("저장 바이트 수 : " + count);
        } catch (Exception e) {
          System.out.println("예외 : " + e.getMessage());
        } finally {
            try { 
              fos.close();
            } catch (IOException e) {  };
        }

   }
}

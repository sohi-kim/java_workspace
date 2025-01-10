package io.day12;

import java.io.FileOutputStream;

// 표준 입력 스트림 -> 파일 출력 스트림
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
        }

   }
}

package io.day12;

import java.io.FileInputStream;
import java.io.IOException;

// 파일 입력 스트림 -> 표준 출력 스트림
public class C14FileInputTest {

  public static void main(String[] args) {
    
    FileInputStream fis = null;
    int b=0;
    int count=0;

    try {
        fis = new FileInputStream("README.md");
        while((b=fis.read())!=-1){
          System.out.write(b);
          count++;
        }
        System.out.println("읽어온 바이트 수 : " + count);

    } catch (IOException e) {
      System.out.println("예외 : " + e.getMessage());
    }


  }

}

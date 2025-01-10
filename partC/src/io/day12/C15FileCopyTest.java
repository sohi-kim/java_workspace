package io.day12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// 파일 복사 : javaio.png 을 javaio_copy.png 로 복사
// '파일 입력' 스트림 -> '파일 출력' 스트림
public class C15FileCopyTest {

  public static void main(String[] args) {

    FileInputStream fis = null;
    FileOutputStream fos = null;
    try {
      int b;
      int count=0;
      fis = new FileInputStream("javaio.png");
      fos = new FileOutputStream("javaio_copy.png");
      while((b=fis.read()) !=-1){   // 파일의 끝 EOF 는 -1
        fos.write(b);
        count++;
      }
      System.out.println(count + " 바이트 복사되었습니다.");
      
    } catch (IOException e) {
      // TODO: handle exception
    }

    
  }

}

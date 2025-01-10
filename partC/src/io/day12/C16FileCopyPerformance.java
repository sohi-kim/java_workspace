package io.day12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C16FileCopyPerformance {

  public static void main(String[] args) {

      //실행 시작한 시간 저장
      long start = System.nanoTime();   // 10억분의 1초
      copyByByteArray();
      //실행 종료한 시간 저장
      long end = System.nanoTime();
      System.out.println("소요 시간 : " + (double)(end-start)/1000000000 + " 초");
    
  }

  public static void copyByByteArray(){   // 바이트배열을 이용하여 입출력단위를 개선
    FileInputStream fis = null;
    FileOutputStream fos = null;
    byte[] buffer = new byte[1024];  //1kb

    try {
      int b;
      int count=0;
      fis = new FileInputStream("C:\\Users\\Class01\\Downloads\\test.jpg");  
      fos = new FileOutputStream("C:\\Users\\Class01\\Downloads\\skyview_copy2.jpg");
      while((b=fis.read(buffer,0,buffer.length)) !=-1){   // 파일의 끝 EOF 는 -1
        // 실제 읽은 바이트 수는 b 에 저장.
        fos.write(buffer,0,b);   // 읽은 바이트 수만큼 출력
        count+=b;
      }
      System.out.println(count + " 바이트 복사되었습니다.");
      
    } catch (IOException e) {
      // TODO: handle exception
    } finally {
      try { 
        fis.close();
        fos.close();
      } catch (IOException e) {  };
  }
  }


  public static void copyByByte(){   // 바이트 단위로 복사
    FileInputStream fis = null;
    FileOutputStream fos = null;
    try {
      int b;
      int count=0;
      fis = new FileInputStream("C:\\Users\\Class01\\Downloads\\skyview.jpg");  
      fos = new FileOutputStream("C:\\Users\\Class01\\Downloads\\skyview_copy.jpg");
      while((b=fis.read()) !=-1){   // 파일의 끝 EOF 는 -1
        fos.write(b);
        count++;
      }
      System.out.println(count + " 바이트 복사되었습니다.");
      
    } catch (IOException e) {
      // TODO: handle exception
    } finally {
      try { 
        fis.close();
        fos.close();
      } catch (IOException e) {  };
  }
  }

}

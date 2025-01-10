package io.day12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFrame;
import java.awt.FileDialog;

// 파일 복사 : javaio.png 을 javaio_copy.png 로 복사
// '파일 입력' 스트림 -> '파일 출력' 스트림
public class C15FileCopyTest {

  public static void main(String[] args) {

    FileInputStream fis = null;
    FileOutputStream fos = null;
    try {
      int b;
      int count=0;
      String filename_in = showFileDialog("파일 복사 선택", FileDialog.LOAD);
      String filename_out = showFileDialog("파일 복사 저장", FileDialog.SAVE);
      // fis = new FileInputStream("javaio.png");  // 현재(실행명령창 프롬프트) 디렉토리
      // fos = new FileOutputStream("javaio_copy.png");
      fis = new FileInputStream(filename_in);
      fos = new FileOutputStream(filename_out);
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

  // 운영체제의 파일선택 GUI 활용
  public static String showFileDialog(String title,int type){
    // 윈도우 창 객체 생성. 
    JFrame jf = new JFrame();
    jf.setVisible(false);

    FileDialog fd = new FileDialog(jf,title,type); // 대화상자의 제목(title)과 버튼이름(type) 설정
    fd.setVisible(true);

    System.out.println("선택한 폴더 : " + fd.getDirectory());   // 폴더 위치
    System.out.println("선택한 파일 : " + fd.getFile());      // 파일명
    jf.dispose();    // 프레임 해제

    return fd.getDirectory() + fd.getFile();
  }

}

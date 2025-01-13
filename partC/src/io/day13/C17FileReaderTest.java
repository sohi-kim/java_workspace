package io.day13;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class C17FileReaderTest {

  public static void main(String[] args) {

    readUTF();
    
  } // main end

  //3.  파일 인코딩 방식에 따라 읽어오기
  public static void readUTF(){
    String line = null;
    int count =0;
    InputStreamReader isr = null;
    Scanner sc = null;
    String filename = "입출력.md";    // UTF-8 인코딩 파일
    try {
      isr = new InputStreamReader(new FileInputStream(filename),StandardCharsets.UTF_8);
      int ch;
      while((ch=isr.read()) !=-1){
        System.out.print((char)ch);    // 파일에 엔터 있을 때 줄바꿈
        count++;
      }
      System.out.println("입력 문자 갯수 : " + count);
    }catch (Exception e) {

    }finally{
      try {
        isr.close();
        
      } catch (Exception e) {
      }
    }

  }

  // 2. 텍스트 파일 라인(줄) 단위로 읽어오기
  public static void readByLine(){
    // int ch;
    String line=null;
    int count=0;
    FileReader fr = null;
    Scanner sc = null;
    StringBuilder sb = new StringBuilder();
    try {
      fr = new FileReader("C:\\Class241129\\연습.txt");  //C:\\Class241129\\연습.txt
      sc = new Scanner(fr);  //파일을 읽기 위해서 Reader 타입 클래스를 인자로 합니다.
      // hasXXX 은 iterator(반복자) 를 통해서 다음 내용이 있을 때 동작하는 방식
      // Iterator 인터페이스 구현 클래스 : hasNext() 메소드, nextXXX() 메소드가 있습니다.
      while(sc.hasNext()){      // 읽어올 다음 줄이 있느냐? 참이면
        line = sc.nextLine();    // 다음 줄 읽어오기
        System.out.println(line);
        count++;
      }
      // System.out.println(sb.toString());
      System.out.println("읽은 라인 개수 : " + count);
    } catch (Exception e) {
      System.out.println("예외 : " + e.getMessage());
    } finally {
      try {
        fr.close();
        sc.close();
      } catch (Exception e) {
      }
    }
  }

  // 1. 텍스트 파일을 한 글자씩 읽어오기
  public static void readText(){
    int ch;
    int count=0;
    FileReader fr = null;
    StringBuilder sb = new StringBuilder();
    try {
      fr = new FileReader("C:\\Class241129\\연습.txt");
      while((ch=fr.read()) !=-1){
        // System.out.println((char)ch);
        sb.append((char)ch);    // 읽은 문자 한개씩을 문자열로 만들기 위해 추가
        count++;
      }
      System.out.println(sb.toString());
      System.out.println("읽은 문자 개수 : " + count);
    } catch (Exception e) {
      System.out.println("예외 : " + e.getMessage());
    } finally {
      try {
        fr.close();
      } catch (Exception e) {
      }
    }
  }

}

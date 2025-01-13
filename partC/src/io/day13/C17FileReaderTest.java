package io.day13;

import java.io.FileReader;
import java.util.Scanner;

public class C17FileReaderTest {

  public static void main(String[] args) {

    readText();
    
  } // main end

  public static void readByLine(){
    int ch;
    int count=0;
    FileReader fr = null;
    Scanner sc = null;
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
        sc.close();
      } catch (Exception e) {
      }
    }
  }

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

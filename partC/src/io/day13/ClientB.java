package io.day13;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientB {

  public static void main(String[] args) {
    Socket socket = null;
    Scanner sc = null;
    try {
      System.out.println("[클라이언트] 프로그램 입니다.");
      socket = new Socket();

      ///// 서버에게 연결 요청////
      /// 연결하려는 서버의 ip, port 를 정확히 설정하여 연결 요청을 보냅니다.
      // socket.connect(new InetSocketAddress("localhost", 5050));
      socket.connect(new InetSocketAddress("localhost", 5050));

      //////////// 데이터 송수신할 입출력 스트림 객체 생성하기
      InputStream is = socket.getInputStream();
      OutputStream os = socket.getOutputStream();

     System.out.println("파일 업로드 준비가 되면 엔터를 치세요.");
     String message = System.console().readLine();

     String filepath =  "C:\\Users\\Class01\\Downloads\\skyview.jpg";
     // 클라이언트 컴퓨터(입력)의 이미지파일을 인터넷(출력)을 통해 서버로 업로드
     BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filepath));
     BufferedOutputStream bos = new BufferedOutputStream(os);
     int b; int count=0;
     while((b=bis.read())!=-1){
      bos.write(b);
      count++;
     }
    System.out.println( count + " 바이트 파일을 업로드 완료했습니다.");
    
    } catch (IOException e) {
      System.out.println("예외 : " + e.getMessage());
    } finally {
      try {
        socket.close();  
      } catch (Exception e) {    }
    }
  }
}

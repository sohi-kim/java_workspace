package io.day13;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientA {

  public static void main(String[] args) {

    Socket socket = null;
    Scanner sc = null;
    try {
      System.out.println("[클라이언트] 프로그램 입니다.");
      socket = new Socket();

      ///// 서버에게 연결 요청////
      /// 연결하려는 서버의 ip, port 를 정확히 설정하여 연결 요청을 보냅니다.
      socket.connect(new InetSocketAddress("localhost", 5050));

      //////////// 데이터 송수신할 입출력 스트림 객체 생성하기
      InputStream is = socket.getInputStream();
      OutputStream os = socket.getOutputStream();

      /// 문자기반 입출력스트림 생성하기
      sc = new Scanner(is);                   // 서버가 보낸 데이터를 받을 때
      PrintWriter pw = new PrintWriter(os);   // 서버에게 데이터를 보낼 때

      ////// 데이터 수신 (스레드 사용하지 않으면 송신과 수신 순서를 맞춰서 코드 작성)
      String message = sc.nextLine();
      System.out.println(message);      // 수신 데이터 화면에 출력하기


      

    } catch (IOException e) {
      System.out.println("예외 : " + e.getMessage());
    } finally {
      try {
        socket.close(); sc.close(); 
      } catch (Exception e) {    }
    }

  }

}

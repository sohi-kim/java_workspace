package io.day13;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

// socket (java.net 패키지)
//  ㄴ 네트워크 통신의 양끝 종단점(end point)
//  ㄴ 일반적으로 서버/클라이언트 역할에 따라 소켓 설정이 다릅니다.
//  ㄴ 서버는 서비스를 제공, 클라이언트는 서비스를 사용하기 위해 서버 연결 요청 합니다.
//  ㄴ 서버와 클라이언트 간의 데이터 송수신 테스트 합니다.
public class ServerA {

  public static void main(String[] args) {

      ServerSocket serverSocket = null;
      Socket socket = null;
      Scanner sc = null;
      try {
        serverSocket = new ServerSocket();
        // hostname : 서버의 IP, port : 서비스 구분 정수값
        //     ㄴ localhost 는 stand alone. (한 컴퓨터에서 서버와 클라이언트 동작을 할때)
        serverSocket.bind(new InetSocketAddress("localhost", 5050));
        System.out.println("[서버] : 연결 요청을 기다리는 중입니다.");

        ///////////// 연결 요청이 오면 승인을 합니다. /////
        /// accept 로 데이터 송수신에 사용할 일반 Socket 이 만들어 집니다.
        socket = serverSocket.accept();
        
        //////////// 데이터 송수신할 입출력 스트림 객체 생성하기
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        // 문자기반 입출력 스트림
        sc = new Scanner(is);         // 클라이언트가 보낸 데이터 받을 때
        PrintWriter pw = new PrintWriter(os);    // 클라이언트에게 데이터 보낼 때

        /////////// 데이터 보내기 
        pw.println("From 서버 : 연결이 성공하였습니다.");   // 클라이언트가 수신



      } catch (IOException e) {
        System.out.println("예외 : " + e.getMessage());
      }finally {
        try {
          socket.close(); sc.close(); 
        } catch (Exception e) {    }
      }
    
  }

}

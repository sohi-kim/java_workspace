package io.day13;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

// 파일 업로드 
public class ServerB {


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
        
        // 서버는 인터넷(입력)에서 파일을 받아 서버 컴퓨터(출력)로 저장.
        System.out.println("클라이언트로부터 파일 업로드 받습니다.");
        String filepath = "c:\\Class241129\\client.jpg";
        
        BufferedInputStream bis = new BufferedInputStream(is);   // 소켓 입력
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filepath));  //서버컴퓨터
        int b; int count=0;
        while ((b=bis.read())!=-1) {
            bos.write(b);
            count++;
        }
        System.out.println(count + " 바이트 파일이 저장되었습니다.");

      } catch (IOException e) {
        System.out.println("예외 : " + e.getMessage());
      }finally {
        try {
          socket.close(); sc.close(); 
        } catch (Exception e) {    }
      }
   }
}

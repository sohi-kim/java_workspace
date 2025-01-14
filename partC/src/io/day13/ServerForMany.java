package io.day13;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerForMany {

  public static void main(String[] args) {
    Socket[] socket = new Socket[10];
    Scanner[] scs = new Scanner[10];
    PrintWriter[] pws = new PrintWriter[10];
    ServerSocket serverSocket = null;
    try{
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress("192.168.0.253",5050));
            System.out.println("[서버 프로그램 시작] : 연결 요청 기다리는 중입니다.");
            // server.setReuseAddress(true);
           
            for(int i=0;i<10;i++) {
                socket[i] = serverSocket.accept();
               
                OutputStream os = socket[i].getOutputStream();
                InputStream is = socket[i].getInputStream();
                pws[i] = new PrintWriter(os,true);
                scs[i] = new Scanner(is);
               /////////// 데이터 보내기 
               pws[i].println("From 서버 : 연결이 성공하였습니다. i=" + i );   // 클라이언트가 수신
               System.out.println("연결 승인 하였습니다.");

               // 데이터 받기
               String message = scs[i].nextLine();
               System.out.println(message);    // 화면 출력
            }
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("통신 중 예외 발생 : " + e.getMessage());
        }finally {
            try {
              serverSocket.close();
            } catch (Exception e) {
              // TODO: handle exception
            }
        }
  }
}

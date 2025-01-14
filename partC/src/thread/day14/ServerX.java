package thread.day14;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerX {

  public static void main(String[] args) {
    
    ServerSocket serverSocket = null;
    try {
      serverSocket = new ServerSocket();
      serverSocket.bind(new InetSocketAddress("localhost",5050));
      System.out.println("[서버]연결 요청을 기다리는 중입니다.");
      
      Socket socket = serverSocket.accept();
      // ㄴ 클라이언트가 connect 요청을 보낼때까지 blocking(대기)
      System.out.println("클라이언트와 연결되었습니다.");
      // 데이터 송수신 담당 스레드 시작시키기
      Thread receiver = new Thread(new ReceiverTask(socket));
      Thread sender = new Thread(new SenderTask(socket,"서버X"));
      receiver.start();
      sender.start();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}

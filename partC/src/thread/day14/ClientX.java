package thread.day14;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientX {

  public static void main(String[] args) {

      try {
        System.out.println("[클라이언트] 프로그램 입니다.");
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("192.168.0.253", 5050));
        System.out.println("서버와 연결되었습니다.");
           // 데이터 송수신 담당 스레드 시작시키기
        Thread receiver = new Thread(new ReceiverTask(socket));
        Thread sender = new Thread(new SenderTask(socket,"xxxxx"));
        receiver.start();
        sender.start();

      }catch(IOException e){
          e.printStackTrace();
      }
  }

}

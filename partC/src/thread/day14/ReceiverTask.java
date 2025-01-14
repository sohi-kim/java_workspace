package thread.day14;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

// 데이터 수신을 담당하는 동작.
// 입력 스트림 : 인터넷 (소켓)
public class ReceiverTask  implements Runnable{
  private DataInputStream dis;     
  // 데이터 전송을 int,double,String 이진 형식(데이터 타입 유지)으로 처리하는 보조스트림
  // DataInputStream 은  DataOutputStream 으로 보낸 데이터만 받을 수 있습니다.

  ReceiverTask(Socket socket){
      try {
        this.dis = new DataInputStream(socket.getInputStream());
      } catch (IOException e) {
        System.out.println("수신 생성자 예외 : " + e.getMessage());
      }
  }


  @Override
  public void run() {
    try {
      while(dis !=null) {
        String message = dis.readUTF();
        System.out.println("받은 데이터 : " + message);
      }
    } catch (IOException e) {
      System.out.println("수신 run 예외 : " + e.getMessage());
    }
  }

}

package thread.day14;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

// 데이터 송신(보내기) 동작
// 출력 스트림 : 인터넷(소켓)
public class SenderTask implements Runnable{
  private DataOutputStream dos;

  SenderTask(Socket socket){
    try {
      this.dos = new DataOutputStream(socket.getOutputStream());
    } catch (IOException e) {
     System.out.println("송신 생성자 예외 : " + e.getMessage());
    }
  }

  @Override
  public void run() {
     // 보낼 데이터를 키보드 입력. System.console()
    try {
      while (dos!=null) {
        String message = System.console().readLine();    // 키보드 입력
        dos.writeUTF(message);
      }

    } catch (IOException e) {
      System.out.println("송식 run 예외 : " + e.getMessage());
    
  }
}
}

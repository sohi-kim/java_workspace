package thread.day14;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

// 데이터 송신(보내기) 동작
// 출력 스트림 : 인터넷(소켓)
public class SenderTask_ implements Runnable{
  // private Socket socket;
  private DataOutputStream dos;
  private PrintWriter pw;
  private String prompt = "from  ";

  SenderTask_(Socket socket,String name){
    // this.socket=socket;
    this.prompt +=name + " >> ";
    try {
      this.dos = new DataOutputStream(socket.getOutputStream());
      this.pw = new PrintWriter(socket.getOutputStream());
    } catch (IOException e) {
     System.out.println("송신 생성자 예외 : " + e.getMessage());
    }
  }

  @Override
  public void run() {
     // 보낼 데이터를 키보드 입력. System.console()
    try {
      String message;
      while (pw!=null) {
        message = System.console().readLine();    // 키보드 입력
        System.out.println(message);
        //  dos.writeUTF(prompt + message);
        pw.println(prompt+message);
        pw.flush();
        // pw.println(new String("테스트"));
      }

    } catch (Exception e) {
      System.out.println("송신 run 예외 : " + e.getMessage());
    
  }
}
}

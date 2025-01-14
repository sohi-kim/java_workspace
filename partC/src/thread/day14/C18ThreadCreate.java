package thread.day14;

public class C18ThreadCreate {
  // Thread 생성 방법 : 1) Thread 클래스를 상속받아 구현하는 클래스 정의하기
  //                    2) new Thread() 의 인자로 Runnable 인터페이스 구현체 전달하기

        public static void main(String[] args) {
          
          System.out.println("메인스레드 2초간 중지");
          // 스레드 객체 생성하고 실행시키기 - 10초 소요
          Thread th1 = new CharPrintThread();     //1)
          th1.start();    // 실행

          // Thread th2 = new Thread(new BeepTask());      // 2)
          Thread th2 = new Thread(
                () -> {
                  for (int i=0;i < 10;i++){
                    System.out.print("띵동...");
                    try {
                      Thread.sleep(500);   //0.5초 중지
                    } catch (InterruptedException e) {
                        //  e.printStackTrace();
                         break;
                    }
                  }
                }
          );
          th2.start();

          try {
            Thread.sleep(2000);
          } catch (InterruptedException e) {
          }      // 현재 실행 중인 스레드를 시간(ms)만큼 중지
          System.out.println("다시 실행 중....");

          // th1.interrupt();
          th2.interrupt();       // th2.stop() 더 이상 사용하지 않는 메소드. deprecated
                                 // th2 스레드에 인터럽트 발생되면서 Exception 
        
        }

}
// 방법 2) 스레드가 할일을 Runnable 인터페이스 구현체로 정의하기
class BeepTask implements Runnable {

  @Override
  public void run() {
       
        for (int i=0;i < 10;i++){
          System.out.print("띵동...");
          try {
            Thread.sleep(500);   //0.5초 중지
          } catch (InterruptedException e) {
            
          }
        }
    
  }

}

// 방법 1) 스레드가 할일을 run() 메소드 재정의
class CharPrintThread extends Thread {

  @Override
  public void run() {
      // 테스트를 위해서 반복문을 실행.
      for(int i=0; i<10;i++){
        System.out.print("테스트 ....");
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) { 
            e.printStackTrace();
        }
      }
  }
}
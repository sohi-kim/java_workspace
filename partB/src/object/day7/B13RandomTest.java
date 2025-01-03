package object.day7;

// Math.random() 메소드 활용
public class B13RandomTest {

  // 실행에 필요한 데이터 : 값을 직접 대입 / 표준 입력(키보드)  / 다량의 임의 데이터를 만들기

  public static void main(String[] args) {
    
      System.out.println("임의의 double 값 5개 만들기 : 값의 범위는 0 ~ 1 사이의 실수");
      System.out.println(Math.random());
      System.out.println(Math.random());
      System.out.println(Math.random());
      System.out.println(Math.random());
      System.out.println(Math.random());

      System.out.println("\n수식을 적용합니다. : 0 ~ 100 사이의 실수 값");
      System.out.println(Math.random()*100);
      System.out.println(Math.random()*100);
      System.out.println(Math.random()*100);
      System.out.println(Math.random()*100);
      System.out.println(Math.random()*100);

      System.out.println("\n정수타입으로 변경하기");
      System.out.println((int)(Math.random()*100));
      System.out.println((int)(Math.random()*100));
      System.out.println((int)(Math.random()*100));
      System.out.println((int)(Math.random()*100));
      System.out.println((int)(Math.random()*100));

      // 0 < 난수 < 1    => 로또 값처럼 1 <= 로또번호 <= 45
      //  원래 난수값 범위에 *45를 하고       0 < 난수*45 < 45   
      //  그 값에 다시 +1 하면 됩니다.        1 < 난수*45+1 < 46
      //  난수의 범위를 start ~ end 범위로 조정하려면
      //  (start ~ end 사이의 정수값을 랜덤 생성한다면)
      // (int)(Math.random()*(end-start+1)) + start

      System.out.println("\n 1~45 범위의 정수값 난수 6개 만들기");
      int start=1, end=45  ;
      for(int i=0;i<6;i++)
        System.out.println((int)(Math.random()*(end-start+1)) + start);

      System.out.println("\n두자리 정수 랜덤 만들기");
      // 수학 학습지 문제의 숫자를 랜덤하게 만들기 : 두자리 덧셈과 뺄셈.11~99
      start=11; end=99  ;
      for(int i=0;i<6;i++)
        System.out.println((int)(Math.random()*(end-start+1)) + start);

  }

}

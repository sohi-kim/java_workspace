package object.day10;

import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class B34ReviewTest {

  public static void main(String[] args) {
    // B33 의 4가지 Runnable,Consumer,Supplier,Function를 람다식 말고 new 연산으로 생성해보세요.

    // 1. 추상메소드가 인자,리턴 모두 없으면 Runnable 타입으로 객체 생성하고 대입
    Runnable runnable = new Runnable(){
      @Override
      public void run() {
       System.out.println("현재 시간 : " + new Date());
        
      }
    };

    runnable.run();

    // 2. 추상메소드가 인자가 1개 있고,리턴 없으면 Consumer 타입으로 객체 생성하고 대입
    Consumer<String> consumer = new Consumer<String>() {
      @Override
      public void accept(String message) {
        System.out.println("메세지 = " + message);
        
      }
    };
    consumer.accept("******");

    // 3. 추상메소드가 인자 없고,리턴 있으면 Supplier 타입으로 객체 생성하고 대입
    Supplier<Long> supplier = new Supplier<Long>() {
      @Override
      public Long get() {
        return System.currentTimeMillis();
      }
    };
    System.out.println(supplier.get());

    // 4. 추상메소드가 인자1개와 리턴 있으면 Function 타입으로 객체 생성하고 대입
    Function<Double, Double> function = new Function<Double,Double>() {
        @Override
        public Double apply(Double d) {
          return Math.pow(2, d);
        }
    };

    System.out.println(function.apply(10.0));
  }

}

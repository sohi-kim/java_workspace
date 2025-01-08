package object.day10;

import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class B33FuntionalInterface {

  public static void main(String[] args) {
    
    // 1. Runnable 타입 익명 클래스를 람다식으로 정의 
    //     ㄴ 리턴과 인자가 둘다 없는 추상메소드 run() 를 갖는다.
    Runnable runnable = () -> System.out.println("현재 시간 : " + new Date());
    // 실행
    runnable.run();

    // 2. Consumer<T> 타입 익명 클래스를 람다식으로 정의
    //          ㄴ T는 인자의 타입 설정. void accpet(T t) 추상 메소드를 갖는다.
    Consumer<String> consumer = (message) -> System.out.println("메세지=" + message);
    //실행
    consumer.accept("굿바이~~");

    // 3. Supplier<T> 타입 익명 클래스를 람다식으로 정의
    //            ㄴ T는 리턴 타입.   T get() 추상메소드를 갖는다.
    Supplier<Long> supplier = () -> System.currentTimeMillis();     // return 생략
    // 실행
    System.out.println(supplier.get());
    
    //4. Function<T,R> 타입 익명 클래스를 람다식으로 정의
    //            ㄴ T는 인자 타입, R은 리턴 타입. R apply(T t) 추상 메소드를 갖는다.
    Function<Double, Double> function = (d) -> Math.pow(2,d);     // return 생략
    // Math.pow(a,b) 는 a의 b승 구합니다.
    // 실행
    System.out.println(function.apply(10.0));    // 2의 10승 

  }
}

package object.day10;

// 아래 4개의 인터페이스는 리턴과 인자 유무에 따라 4가지 조합으로 만든 테스트용 입니다.
//    -> 자바 JDK 는 아래 4개 유형의 인터페이스가 이미 만들져 있고 사용만 하면 됩니다.
//  1. Runnable - 실행할 수 있는  . run()
//  2. Consumer - 소비자 (인자만 가져가 사용한다.)   accept()
//  3. Supplier - 공급자 (인자 없이 리턴을 준다.)    get() 
//  4. Function - 인자값을 갖고 처리결과를 리턴하는 함수    apply()
//  -> 4개 유형 함수 인터페이스의 추상 메소드 알아내기
@FunctionalInterface
public interface TestFunction {

    // 리턴과 인자 모두 없는 형식의 함수
    void execute();
}

@FunctionalInterface
interface Test2Function {

    void execute(String message);
  
}

@FunctionalInterface
interface Test4Function {
    int execute();
}

@FunctionalInterface
interface Test3Function {

    int execute(int a, int b);

}



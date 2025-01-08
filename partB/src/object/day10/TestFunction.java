package object.day10;

@FunctionalInterface
public interface TestFunction {

    // 리턴과 인자 유무에 따라 4가지 조합

    // 리턴과 인자 모두 없는 형식의 함수
    void execute();

}

@FunctionalInterface
interface Test2Function {

    void execute(String message);
  
}


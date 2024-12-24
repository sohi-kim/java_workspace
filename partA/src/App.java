// 자바 소스파일은 클래스 안에서 만들어져야 합니다.-객체지향 프로그래밍
//     class 키워드 : 클래스 정의.   App 은 클래스 이름(개발자 정의). 
//     하나의 소스파일에 클래스는 여러개 정의될 수 있습니다. public 클래스는 오직 1개.
//     소스 파일명은 public 클래스 이름과 같아야 합니다.
public class App {

    // main 메소드는 프로그램 실행의 시작점. void - main 메소드는 리턴이 없다.
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        // System : 자바의 클래스. 운영체제 또는 컴퓨터 시스템과 관련된 기능을 제공
        //              ㄴ 객체를 만들지 않고도 클래스 자체로 지원 기능을 사용
        // out : System 클래스에 속한 속성. 콘솔 출력 기능을 갖고 있는 속성.(객체)
        // println : 콘솔에 데이터를 출력하는 메소드. out 객체의 구성요소.

        //          자바 명령어의 기본형식 : 클래스이름(객체).메소드(인자1,인자2, ....)
        //                                       ㄴ 메소드 종류에 따라 리턴값이 있습니다.

        System.out.println("내가 작성한 출력 코드- 현재 시스템 시간");
        System.out.println(System.currentTimeMillis() + " ms");
    }
}

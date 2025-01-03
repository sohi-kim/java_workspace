package object.day7;

public class Day6ReviewApp {
    public static void main(String[] args) {
      // 새로운 클래스 Score 로 데이터 저장과 관련 기능을 활용하는 예시.
      // 요구 사항  -> 성적데이터 최대 10개로 성적관리 프로그램을 개발한다. => 배열 선언

      Score[] stuScores = new Score[10];

      //커스텀 생성자로 필드값 초기화하여 객체를 각각 생성하기
      stuScores[0] = new Score("사나", GradeType.GRD1, "객체지향프로그래밍", 90);
      stuScores[1] = new Score("모모", GradeType.GRD1, "객체지향프로그래밍", 84);
      stuScores[2] = new Score("나연", GradeType.GRD2, "알고리즘", 72);
      stuScores[3] = new Score("정현", GradeType.GRD2, "알고리즘", 91);
      stuScores[4] = new Score("지효", GradeType.GRD3, "파이썬", 88);

      // toScore 메소드를 이용하여 각 객체의 필드값을 출력하기
      System.out.println("=== 성적 데이터 출력 ===");
      for(int i=0;i<5;i++){
        String temp = stuScores[0].toScore();
        System.out.println(temp);
      }

      System.out.println("========================");
      for(int i=0;i<5;i++){
        String temp = stuScores[i].toScore();
        System.out.println(temp);
      }


    }
}

//요구사항 : 성적데이터에 이름, 학년(열거형) , 과목명1개, 점수1개 저장해야 한다.
//           -> 성적데이터 최대 10개로 성적관리 프로그램을 개발한다. (main 메소드)
//    => 클래스 설계는 개발자가 합니다.
class Score {
    // 규칙: private 한 필드 선언
    private String name;
    private GradeType grade;
    private String subject;     //과목명
    private int jumsu;

    // 커스텀한 생성자 : private 필드의 초기값을 저장
    public Score(String name, GradeType grade, String subject, int jumsu){
      this.name = name;
      // 객체의 필드 name = 인자name => 인자와 필드 변수명이 같을 때 필드는 this.필드 필수
      this.grade=grade;
      this.subject=subject;
      this.jumsu=jumsu;
    }

    // private 한 필드에 접근하는 메소드 : getter, setter 


    // 기능과 관련 인스턴스 메소드 
    //      1. 모든 값을 출력할 때 사용할 문자열 만들기
    public String toScore(){
          return grade + ": 이름 = " + name + ", 과목명 = " + subject + ", 점수 = " + jumsu;
          // return grade + ": 이름 = " + this.name + 
          //          ", 과목명 = " + this.subject + ", 점수 = " + this.jumsu;
    }

}
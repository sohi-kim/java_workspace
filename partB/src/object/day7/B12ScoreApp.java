package object.day7;

import java.util.Scanner;

// 클래스 객체와 배열 : 기본 예제.
public class B12ScoreApp {

  public static void main(String[] args) {
    // 'Score 클래스로 만들어진 객체들을 참조'하기 위한 배열을 선언. 배열 크기는 10
       Score[] stuScores = new Score[10];

      //커스텀 생성자로 필드값 초기화하여 '객체를 각각 생성'하기. 배열에 저장되는 값은 객체의 주소 참조값
      stuScores[0] = new Score("사나", GradeType.GRD1, "객체지향프로그래밍", 90);
      stuScores[1] = new Score("모모", GradeType.GRD1, "객체지향프로그래밍", 84);
      stuScores[2] = new Score("나연", GradeType.GRD2, "알고리즘", 72);
      stuScores[3] = new Score("정현", GradeType.GRD2, "알고리즘", 91);
      stuScores[4] = new Score("지효", GradeType.GRD3, "파이썬", 88);

      System.out.println("=== 새로운 성적 입력하기 (CLI) ===");
      // 길동, GRD3, SQL , 78
      // 길순, GRD2, 파이썬, 88
      Scanner sc = new Scanner(System.in);
      boolean run=true;
      int index =5;     // 설명:
      while(run){
        System.out.print(" 이름 >>> ");
        String name = sc.next();
        System.out.print(" 학년(1,2,3) >>> ");
        int grade = sc.nextInt();
        
        // 설명: 자바12부터 사용되는 switch 문법으로 대입문과 함께 사용
        GradeType gradeType = switch(grade){
          case 1 -> GradeType.GRD1;
          case 2 -> GradeType.GRD2;
          case 3 -> GradeType.GRD3;
          default -> null;
        };
        System.out.print(" 과목명 >>> ");
        String subject = sc.next();
        System.out.print(" 점수 >>> ");
        int jumsu = sc.nextInt();
        // 위의 입력값으로 새로운 Score 객체를 만듭니다.-> 배열에 저장합니다.
        stuScores[index] = new Score(name, gradeType, subject, jumsu);  // 설명:

        //새로만든 객체의 출력 : toScore 메소드 사용하세요.
        System.out.println("객체가 생성되었습니다. " + stuScores[index].toScore() );

        System.out.print("\n계속할까요?");
        if(sc.next().equals("n")) run=false;
        else
          index++;
      }

      System.out.println(" ==== 점수 통계(점수 합계와 평균) ====");
      /*
       for(int i=0;i<stuScores.length;i++) {
            System.out.println(stuScores[i]);
      } */
      int sum=0;
      for( Score  temp : stuScores){    // 설명:
        System.out.println(temp);
        if(temp!=null){      // 설명: 가져온 참조값이 null 이 아닌지 검사.
            sum += temp.getJumsu();     // null 참조는 객체의 메소드 실행하면 오류.
        }
        System.out.println("중간 합계 : "+ sum);
      }
      System.out.println("총 점수 합계 : " + sum);
      System.out.println("점수 평균 : " + (double)sum/(index+1));  // 설명:
      sc.close();

  }

}

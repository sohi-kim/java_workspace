package collection.day11;

// main 의 static 인 특징 때문에 전역변수, 메소드를 모두 static 으로 만드는 것 대신에
//         클래스 객체를 생성하여 메소드를 작성하고 실행합니다.
public class C03ArraySearchTest {

  private String[] names = {"모모","나나","다현","사나"};

  public static void main(String[] args) {
    
        int index = new C03ArraySearchTest().indexOf("나나");
        System.out.println(index);
        System.out.println(new C03ArraySearchTest().indexOf("나무"));

  }

  public int indexOf(String text){    // 인스턴스 메소드
          int index=-1;
          // 배열의 모든 요소를 검사
          for(int i=0;i<names.length;i++){
            if(names[i].equals(text)){
                index=i;    // 찾는 문자열과 일치하는 i 를 결과 변수 index 에 저장
                break;      // 문자열 찾고 for 종료
            }
          }
          return index;
  }

}

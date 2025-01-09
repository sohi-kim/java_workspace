package collection.day11;

import java.util.Arrays;
import java.util.List;

// 프로그래머스 문제 이름 : 추억 점수
public class C04PictureJumsu {

      public static void main(String[] args) {
        // 문자열 2차원 배열 : 배열의 배열. 2차원 배열은 인덱스가 2개
            String[][] photo = {
                {"may","kein","kain","radi"},    // photo[0]
                {"may","kein","brin","deny"},    // photo[1]
                {"kon","kain","may","coni"}      // photo[2]
            };

        // 2차원 배열 요소들을 모두 가져와 반복하기    

         for(int i=0;i<photo.length;i++) {    // 큰 배열 반복
              System.out.println(Arrays.toString(photo[i]));   //큰 배열 출력

              for(int j=0;j<photo[i].length;j++) {    // 작은 배열 값 하나씩 출력
                System.out.println(photo[i][j]);
              }
            
          }         
          
          System.out.println("// 문제 풀이 //");
          String[] name = {"kali","mari","don"};    //{"may","kein","kain","radi"};
          int[] yearning = {11,1,55};   //{5,10,1,3};
          String[][] photo2 = {
                {"kali","mari","don"},
                {"pony","tom","teddy"},
                {"con","mona","don"}
          };

          int[] result = new Solution().solution(name, yearning, photo2);
          System.out.println(Arrays.toString(result));  // 답 출력

          
  } // main end
}

class Solution {
  public int[] solution(String[] name, int[] yearning, String[][] photo) {
    int[] answer = new int[photo.length];   // 답 저장 배열

    for(int i=0;i<photo.length;i++) {    // 큰 배열 반복
          int sum=0;    // 각 사진의 점수 함계
          List<String> list = Arrays.asList(name);  //인덱스 검색을 위한 변환
          for(int j=0;j<photo[i].length;j++) {    // 작은 배열 값 하나씩 출력
            // System.out.println(photo[i][j]);
            int idx = list.indexOf(photo[i][j]);   //사진 인물의 인덱스
            if(idx > -1) {
              sum += yearning[idx];   // 같은 인덱스 위치에서 점수 가져오기
              System.out.println("idx=" + idx + ", 점수 =" + yearning[idx]);
            }
          answer[i]=sum;
        }      // for end
        System.out.println(i + " 위치의 점수 =" + answer[i]); 
        // 19 , 15 , 16
    }  // for end

      return answer;
  }
}

class Test {

  void test(String[][] photo){

            System.out.println("// 배열의 길이 확인 //");
            System.out.println("photo.length : " + photo.length);
            System.out.println("photo[0].length : " + photo[0].length);   //4
            System.out.println("photo[1].length : " + photo[1].length);   //4
            System.out.println("photo[2].length : " + photo[2].length);   //4

            System.out.println("// 배열의 값 확인 //");
            System.out.println("photo[0] : " + Arrays.toString(photo[0]));
            System.out.println(photo[0][0]);
            System.out.println(photo[0][1]);
            System.out.println(photo[0][2]);
            System.out.println(photo[0][3]);
            System.out.println("photo[1] : " + Arrays.toString(photo[1]));
            // 23~26 라인 출력을 인덱스 사용 for 문으로 도전!!
            for(int i=0;i<photo[1].length;i++) {
              System.out.println(photo[1][i]);
            }
            System.out.println("photo[2] : " + Arrays.toString(photo[2]));
            // 23~26 라인 출력을 향상 for 문으로 도전!!
            for (String t : photo[2]){
              System.out.println(t);
            }
  }
  
}
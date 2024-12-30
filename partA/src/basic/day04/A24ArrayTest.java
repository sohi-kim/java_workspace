package basic.day04;

public class A24ArrayTest {

  //자바스크립트 배열과 다른 점 : 1) 기호 사용 :  값은 { } , 선언은  []   
  //              2) 배열 선언(정의)할때 요소의 개수를 정해야 합니다.

  public static void main(String[] args) {
        // 일반 변수는 값 1개만 저장. 여러개 데이터를 저장할 때 사용.(=> 변수이름은 1개)
        //정수 배열 
        int[] arr1 = {10,20,30,40,50};        // arr1 배열은 항상 5개의 요소만 저장
        int[] arr2 = new int[10];             // 초기값은 ?    항상 10개의 요소만 저장


        // 배열 요소의 갯수를 알아내는 속성
        System.out.println("arr1 배열의 요소 개수 : " + arr1.length);    // 5
        System.out.println("arr2 배열의 요소 개수 : " + arr2.length);    // 10

        // 요소에 접근(저장,출력)은 인덱스 사용
        System.out.println("arr1[0]=" + arr1[0]);    //10
        System.out.println("arr2[0]=" + arr2[0]);    // 0 (기본 초기값)

        // arr2 배열의 모든 요소값을 100으로 한다면
       for(int i=0;i<arr2.length;i++){
             arr2[i]=100;
             System.out.print(arr2[i] + "\t");
       }
       System.out.println(arr2);     
       System.out.println(arr1);     
       // [I@72ea2f77  에서 [ 기호는 배열 I 는 정수 , 
       // 72ea2f77 는 arr2 배열의 메모리 주소 참조값(16진수 8자리 = 32비트 , 4바이트)
    
  }

}

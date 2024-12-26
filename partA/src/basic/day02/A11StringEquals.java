package basic.day02;

public class A11StringEquals {

  // 문자열의 비교 
  // 1) == 기호 는 저장된 주소를 비교합니다.
  // 2) equals 메소드는 저장된 내용을 비교합니다.

  public static void main(String[] args) {

     // 문자열의 내용이 같은지 비교
     System.out.println("3 > 0 = " + (3 > 0));
     boolean test = (3==3);  // 경고 이유 : 리터럴끼리 비교
     System.out.println("3==3 = " + test);
     test = (3!=3);
     System.out.println("3!=3 = " + test);

     // '문자열 내용 비교'에  == 사용안함. == 는 주소 비교.
     System.out.println("문자열 주소 동등 비교 : " 
                                 + ("Hello"=="Hello"));   //true
     String name = "Java";     //name 변수는 문자열의 주소 저장
     String title = "Java";    //title         "
     System.out.println("문자열 주소 동등 비교 : " 
                       + (name == title));    //true (name,title의 주소가 같음)

 // ㄴ 결론 : 자바는 문자열 리터럴의 내용이 같으면 메모리 두 번 저장하지 않습니다.
     
 // new String("문자열") 새롭게 메모리를 할당 받아서 "Java" 문자열을 저장    
     String lesson = new String("Java");                           
     System.out.println("문자열 주소 동등 비교 : " 
                     + (lesson == title));    //false(lesson,title의 주소가 다름)

 // 문자열의 내용 비교 메소드
    System.out.println("lesson.equals(title) : " + lesson.equals(title));


  }

}

package object.day6;

public class MyClass8 {

  String field1;
  int field2;

  //2. 커스텀 생성자 : 인자를 갖는 생성자
  //        인자의 개수는 제한은 없습니다.
  //       **"인스턴스 필드가 초기화가 목적."**
  MyClass8(String field1, int field2){
    // this는 자신 객체를 나타내는 키워드
    this.field1 = field1;
    this.field2 = field2;
  }
  // 커스텀 생성자가 정의되면 기본생성자는 생략하고 쓸 수 없습니다.
  // 필요하면 기본생성자 정의 합니다.

}

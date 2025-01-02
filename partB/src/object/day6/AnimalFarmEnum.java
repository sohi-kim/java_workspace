package object.day6;

// Animal 의 인스턴스 필드 type 을 열거형 적용.
public class AnimalFarmEnum {
    public static void main(String[] args) {
      
      Animal2 maru = new Animal2(AnimalEnum.DOG, "마루",12, "브라운");
      Animal2 pepper = new Animal2(AnimalEnum.CAT, "후추",4, "블랙");
      Animal2 donald = new Animal2(AnimalEnum.DUCK, "도날드",6, "그레이");
      // 열거형에 정의된 상수로만 값의 제한을 확실히 함.
      // Animal donald2 = new Animal(AnimalEnum.RABBIT, "도날드",6, "그레이");
      System.out.println(maru.toString());
      System.out.println(pepper.toString());
      System.out.println(donald.toString());

      // Animal 타입 배열 선언 : 크기는 5
      Animal2[] farm = new Animal2[5];
      farm[0]=maru;
      farm[1]=pepper;
      farm[2]=donald;
      farm[4] = new Animal2(AnimalEnum.MOUSE, "미키", 1, "화이트");
      System.out.println("== 배열 테스트 ==");
      for(Animal2 a : farm){
          if(a !=null)   //NullPointerException 방지를 위한 조건식.
                System.out.println(a.toString());
      }
// 오류 : **NullPointerException**: 
//     Cannot invoke "object.day6.Animal2.toString()" ** because "a" is null**
//  farm 배열의 인덱스 3번이 객체 참조가 없으므로 null. 
//  null일때에는 인스턴스 메소드 실행할 수 없습니다.(오류)
   }
}

class Animal2 {
  
  //String 형식을 열거형 AnimalEnum 으로 변경함. -> 생성자, getter,setter, sound 메소드 수정
  private AnimalEnum type;
  private String name;
  private int age;
  private String color;
  
  public Animal2(AnimalEnum type, String name,int age, String color) {
    this.type = type;
    this.name = name;
    this.age = age;
    this.color = color;
  }


  public String sound() {
    String result="";
    switch (this.type) {   // type 필드는 AnimalEnum 형식. => 상수로 검사
      case CAT:
        result  = "야옹야옹";
        break;
      case DOG:
        result="멍멍";
        break;
      case MOUSE:
        result="찍찍";
        break;
      case DUCK:
        result="꽥꽥";
        break;
      default:
        break;
    }
    return result;
  }

  public AnimalEnum getType() {
    return type;
  }

  public void setType(AnimalEnum type) {
    this.type = type;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }



  public String toString() {
    return "Animal [type=" + this.type + ", name=" + this.name + ", age=" 
                  + this.age + ", color=" + this.color + "] " + sound();
  }
  

  


}
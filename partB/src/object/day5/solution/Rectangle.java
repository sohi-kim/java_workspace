package object.day5.solution;

public class Rectangle {
  String shapeName;
  int width;
  int height;

  public int getArea(){
    return width * height;
  }

  public int getLength() {
    return (width + height)*2;
  }

  // 문자열 1개 이모지를 인자로 전달 받는 예시
  public String draw(String emoji){
    return String.format("%s %s (%d x %d) 를 그립니다.",
         this.shapeName,emoji,this.width,this.height);
  }
}

package object.day5.solution;

public class B05RectangleTest {

  public static void main(String[] args) {
    Rectangle red = new Rectangle();
    red.width = 220;
    red.height = 300;
    red.shapeName = "Red 사각형";
    System.out.println(red.draw("🟥"));

    Rectangle blue = new Rectangle();
    blue.width = 450;
    blue.height = 234;
    blue.shapeName = "Blue 사각형";
    System.out.println(blue.draw("🟦"));
    


  }

}

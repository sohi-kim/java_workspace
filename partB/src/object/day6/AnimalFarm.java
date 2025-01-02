package object.day6;

public class AnimalFarm {
    public static void main(String[] args) {
      
      Animal maru = new Animal("DOG", "마루",12, "브라운");
      Animal pepper = new Animal("CAT", "후추",4, "블랙");
      Animal donald = new Animal("DUCK", "도날드",4, "블랙");
      System.out.println(maru.toString());
      System.out.println(pepper.toString());
      System.out.println(donald.toString());
    }
}

class Animal {
    
  private String type;
  private String name;
  private int age;
  private String color;
  
  public Animal(String type, String name,int age, String color) {
    this.type = type;
    this.name = name;
    this.age = age;
    this.color = color;
  }


  public String sound() {
    String result="";
    switch (this.type) {
      case "CAT":
        result  = "야옹야옹";
        break;
      case "DOG":
        result="멍멍";
        break;
      case "MOUSE":
        result="찍찍";
        break;
      case "DUCK":
        result="꽥꽥";
        break;
      default:
        break;
    }
    return result;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
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
    return "Animal [type=" + type + ", name=" + name + ", age=" + age + ", color=" + color + "] " + sound();
  }
  

  


}
package object.day9;

public abstract class AbstractAnimal {

      protected String aniName;
      protected String color;

      AbstractAnimal(String aniName, String color){
          this.aniName = aniName;
          this.color = color;
      }

      public abstract void sound();
      public abstract boolean isFly();
      public abstract String todo();

      @Override
      public String toString() {
        return "AbstractAnimal [aniName=" + aniName + ", color=" + color + ", isFly()=" + isFly() + "]";
      }

}

class ACat extends AbstractAnimal {

    ACat(String aniName, String color){
        super(aniName, color);
    }

    @Override
    public void sound() {
      System.out.println("야옹 야옹~ 😼");
      
    }

    @Override
    public boolean isFly() {
    return false;
    }

    @Override
    public String todo() {
    return "catch a mouse";
    }
}



class ADog extends AbstractAnimal {

  ADog(String aniName, String color){
      super(aniName, color);
  }

  @Override
  public void sound() {
    System.out.println("멍멍 멍멍멍~ 🐶");
    
  }

  @Override
  public boolean isFly() {
  return false;
  }

  @Override
  public String todo() {
  return "집 지키기";
  }
}

class AFrog extends AbstractAnimal {

  AFrog(String aniName, String color){
      super(aniName, color);
  }

  @Override
  public void sound() {
    System.out.println("개굴 개굴~ 🐸");
    
  }

  @Override
  public boolean isFly() {
  return false;
  }

  @Override
  public String todo() {
  return "rain forecast";
  }
}
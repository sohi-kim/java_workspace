package thread.day14;

public class CurrencyRate {
  //  cur_unit , ttb , tts , cur_nm  
  private String cur_unit;
  private String ttb;    //살 때 가격
  private String tts;    //팔 때 가격
  private String cur_nm;
  
  public CurrencyRate(String cur_unit, String ttb, String tts, String cur_nm) {
    this.cur_unit = cur_unit;
    this.ttb = ttb;
    this.tts = tts;
    this.cur_nm = cur_nm;
  }


  @Override
  public String toString() {
    return "CurrencyRate [cur_unit=" + cur_unit + ", ttb=" + ttb + 
                  ", tts=" + tts + ", cur_nm=" + cur_nm + "]";
  }

  
  // json 문자열을 자바객체로 바꾸기 : 역직렬화 (Open API 사용)
  // 자바객체를 json 문자열로 바꾸기 : 직렬화

}

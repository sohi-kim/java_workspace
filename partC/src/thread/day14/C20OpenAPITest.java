package thread.day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;

public class C20OpenAPITest {

  public static void main(String[] args) {

      // 요청시 필요한 값 저장
      String authkey="AluENEwBXPhUPGfCO8dy3cfaqFJD8yb9";
      String searchdate="20250113";
      HttpURLConnection connection=null;
      // 가변객체 문자열을 저장하기
      StringBuilder url = 
      new StringBuilder("https://www.koreaexim.go.kr/site/program/financial/exchangeJSON");

      try{
        // 요청 URL 문자열
        url.append("?authkey=").append(authkey)
           .append("&searchdate=").append(searchdate)
           .append("&data=AP01");
        URL fullUrl = new URL(url.toString());     // 요청 URL 객체
        connection = (HttpURLConnection) fullUrl.openConnection();   
        // http 요청 객체 생성하여 연결
      }catch(IOException e){
          System.out.println("API 요청 예외 :" + e.getMessage());
      }

      String line=null;
      String jsonStr="";
      try( 
        	InputStreamReader ir=new InputStreamReader(connection.getInputStream(),StandardCharsets.UTF_8);			
        	BufferedReader br=new BufferedReader(ir);
        	)
      {
            while((line=br.readLine())!=null){		
                jsonStr+=line;				
            }
      }catch (IOException e) {
            e.printStackTrace();
      }
      
        Map<String,CurrencyRate> map = deserialize(jsonStr);
        //key 값을 이용한 검색으로 list 보다 효율적이다.
        System.out.println("~~~~~~~ 검색 테스트 ~~~~~");
        String key ="USD";
        String tts = map.get(key).getTts();
        System.out.println("찾는 화폐 : " + key);
        System.out.println("tts : " + tts);
        System.out.println("ttb : " + map.get(key).getTtb());
    

  }  // main end
 // {"result":1,"cur_unit":"AED","ttb":"393.71","tts":"401.66",,,,"cur_nm":"아랍에미리트 디르함"}
 //   ㄴ 하나씩 객체로 변환하여 Map 에 저장하기
  public static Map<String,CurrencyRate> deserialize(String jsonStr) {
    String[] temp = jsonStr.substring(2, jsonStr.length()-2).split("\\},\\{");
    Gson gson = new Gson();
    Map<String,CurrencyRate> map = new HashMap<>();
    for(String t : temp){
      t="{"+t+"}";
      System.out.println("문자열 t : " + t);
      CurrencyRate cr = gson.fromJson(t, CurrencyRate.class);    // 
      System.out.println("역직렬화 객체 : " + cr);
      map.put(cr.getCur_unit(),cr);
    }

    return map;
  }
}

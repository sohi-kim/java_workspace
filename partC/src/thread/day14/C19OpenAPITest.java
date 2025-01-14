package thread.day14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class C19OpenAPITest {

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
      String filename = "환율20250113.txt";

      // try with resources 구문 : close 해야할 자원들을 자동 처리
      // close 해야할 입출력 스트림 선언을 try 뒤에 () 안에 합니다.
        try( 
        	//HttpURLConnection 객체를 통해 문자기반 입력 스트림 생성하기
        	InputStreamReader ir=new InputStreamReader(connection.getInputStream());			
       		//문자기반 파일 출력스트림
        	PrintWriter pw =new PrintWriter(new File(filename));		//자동 flush 기능이 있는 메소드 사용.
        		
        	//문자기반 입출력 보조 스트림
       		BufferedWriter	bw = new BufferedWriter(pw);
        	BufferedReader br=new BufferedReader(ir);
        	)
        {
            while((line=br.readLine())!=null){		//문자 기반 스트림에는 line 단위로 읽는 메소드가 있습니다.
            			//줄 단위로 읽기. 여기서는 데이터가 1개 라인에 모두 저장하여 사실은 반복문 필요없음.
                jsonStr+=line;				
            }
            System.out.println("----------- HttpsURLConnection 으로 읽어온 응답 문자열  -------------");
            System.out.println(jsonStr);	//콘솔 출력
            bw.write(jsonStr);		//파일 출력
//          bw.flush();     //버퍼를 사용하는 출력일 때는 필요함.pw가 flush 기능이 있으므로 여기서는 생략가능.
        }catch (IOException e) {
            e.printStackTrace();
        }
      //  System.out.println(jsonToList(jsonStr).size());
        					//문자열을 자바 리스트로 변환하는 메소드-개발자 정의



  }  // main end

}

package day1;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleConnectionTest {

  public static void main(String[] args) {
    
      Connection connection = null;
      String url = "jdbc:oracle:thin:@//localhost:1521/xe";
      //                               서버IP:포트번호/db이름
      String username = "c##idev";
      String password = "1234";
      String driver = "oracle.jdbc.driver.OracleDriver";

      try {

        // jdk 8 이전에는 직접 오라클 드라이버 로드 코딩 해야합니다.
        // Class.forName(driver);
        
        // getConnection 메소드 : dbms 드라이버에 맞는 Connection 타입 객체 생성
        connection = DriverManager.getConnection(url, username, password);
        System.out.println("연결 객체 상태 : " + connection);
        System.out.println("Connection 인터페이스의 구현 클래스는?");
        System.out.println(connection.getClass().getName());
        // 오라클 드라이버에 포함된 클래스 oracle.jdbc.driver.T4CConnection  
      } catch (Exception e) {
        System.out.println("데이터베이스 연결 실패. : " + e.getMessage());
      } finally {
        try {
          connection.close();
        } catch (Exception e) {    }
      }

  }
}
/*
 * 참고 : jdbc 코딩에 사용되는 인터페이스가 많습니다.
 *        Connection 도 인터페이스입니다.
 *        ㄴ 인터페이스는 객체를 직접 만들 수 없습니다. 구현클래스를 통해서 객체가 만들어집니다.
 *        ㄴ jdbc 에서는 DriverManager 로 드라이버가 메모리에 로딩되면
 *           필요한 구현 클래스 선택과 객체생성은 드라이버로 만들어집니다.
 *        Connection 객체는 SQL 실행을 위해 db와 연결상태값을 저장하고 있어야 합니다.
 * 
 */
package day1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CustomerMenu2 {

  public static void main(String[] args) {
    System.out.println("=====고객 회원 탈퇴 메뉴 입니다.======");
    System.out.print(" 아이디 입력 >>> ");
    String customid = System.console().readLine();  

    String sql = "DELETE FROM ";    //1) delete sql . 매개변수 설정

    Connection connection = OracleConnectionUtil.getConnection();
    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

        // 2) sql 실행. 매개변수 전달
      
    } catch (Exception e) {
      System.out.println("DELETE 실행 예외 : " + e.getMessage());
    }

    OracleConnectionUtil.close(connection);
  }

}

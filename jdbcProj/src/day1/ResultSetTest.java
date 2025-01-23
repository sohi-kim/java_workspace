package day1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// select sql .
//    ㄴ 데이터를 조회. 테이블의 행 집합을 결과로 얻습니다.
//    ㄴ 'ResultSet' 타입 객체는 행 집합을 저장합니다. select 쿼리에서 사용되는 리턴 타입.
//    ㄴ select 결과로 얻어지는 행의 갯수는 알 수 없습니다. 반복문 while 사용
//       단, PK 조회는 행이 0 또는 1개 조회됩니다.
public class ResultSetTest {

  public static void main(String[] args) {
      System.out.println("=========== 고객 조회 메뉴 입니다. =========");
      String customId ="hongGD";
      String sql ="SELECT * FROM tbl_customer WHERE custom_id = ? ";    // 1) select sql. 매개변수 설정

      Connection connection = OracleConnectionUtil.getConnection();
      try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

          // 2) 실행. 매개변수 전달
          pstmt.setString(1, customId);
          ResultSet rs = pstmt.executeQuery();    // select 

         // 3) 조회된 행 집합 확인
         // 행집합은 커서(포인터)를 이용해서 한 개의 행만 읽어옵니다.
         //           다음 행을 읽어오려면 next() 메소드로 커서를 이동. boolean 리턴.
         //               ㄴ 참 : 데이터 있음, 거짓 : 데이터 없음
         //           커서의 초기상태는 조회된 첫번째 행의 앞을 가리킵니다.
         System.out.println("조회 결과가 있나요?");
         System.out.println(rs.next());

         // rs 가 가리키는 행의 컬럼 값을 가져옵니다. 컬럼의 형식을 getXXX 메소드에 설정합니다.
         // rs.next() 가 false 이면 아래의 getXXX 은 오류 입니다.
         System.out.println("rs 가 가리키는 행의 컬럼 값");
         System.out.println(rs.getString(1));
         System.out.println(rs.getString(2));
         System.out.println(rs.getString(3));
         System.out.println(rs.getInt(4));   // 나이
         System.out.println(rs.getDate(5));  // 가입날짜
         System.out.println(rs.getString(6));

         System.out.println("데이터가 또 있나요?");
         System.out.println(rs.next());

      } catch (Exception e) {
        // TODO: handle exception
      }
    
  }
}

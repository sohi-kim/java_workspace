package day2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import day1.OracleConnectionUtil;
import vo.Customer;

// select 다양한 검색 조건으로 실행하면 행의 개수가 n 개 입니다.
// 1.     -> while 반복. 조건식은 rs.next()
//                      ㄴ 행 커서를 다음으로 이동시키고 이동된 행이 null 이면 false 리턴
//                         조회할 행이 있으면 true 리턴
// 2. 검색결과 n개 행은 자바 콘솔 출력이 아니고 브라우저 출력해야 합니다.
//        -> List 자료구조 에 저장.
public class ListMappingTest {

  public static void main(String[] args) {

      //예시 :  ? 년도에 가입한 회원 조회(검색)

      Connection connection = OracleConnectionUtil.getConnection();

      String year = "2025";
      String sql = "SELECT * FROM tbl_customer WHERE to_char(reg_date,'yyyy') = ?";

      try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

        pstmt.setString(1, year);
        ResultSet rs = pstmt.executeQuery();

        // 가입년도를 이용한 '회원'(tbl_customer 테이블) 검색
        //  <-> Customer 자바 클래스 정의하여 데이터는 객체로 저장.
        Customer customer = null;
        List<Customer> list = new ArrayList<>();
        while(rs.next()){
              String customId = rs.getString(1);
              String name = rs.getString(2);
              String email = rs.getString(3);
              int age = rs.getInt(4);
              Date regDate = rs.getDate(5);
              customer = new Customer(customId, name, email, age, regDate);
              System.out.println(customer);
              list.add(customer);       // 리스트 자료구조에 위에서 만든 객체 저장
        }

        // System.out.println("조회 결과 : " + list);   
        // 브라우저 출력은 행, 컬럼 각각 출력
        System.out.println("=== "+year + " 년도에 가입한 회원 ===");
        for(Customer cus : list){

          System.out.println(cus.getCustomId() + "\t" + cus.getName() + "\t" +
                cus.getEmail() + "\t" + cus.getAge() + "\t" + cus.getRegDate());
        }     

      } catch (Exception e) {
        System.out.println("검색 SELECT 실행 예외 : " + e.getMessage());
      }

      OracleConnectionUtil.close(connection);
    
  }

}

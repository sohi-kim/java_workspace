package day1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.day1.Customer;

// select 조회 결과를 자바 오브젝트로 매핑(연관)하기
// 기본키로 조회하여 행의 갯수 1개 (없으면 0개)
public class ObjectMappingTest {

  public static void main(String[] args) {
    
        Connection connection = OracleConnectionUtil.getConnection();
        String customId ="hongGS";
        String sql="SELECT * FROM tbl_customer WHERE custom_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
          
            pstmt.setString(1, customId);
            ResultSet rs = pstmt.executeQuery();

            // 조회 결과를 자바 객체로 매핑
            Customer customer = null;
            if(rs.next()){   //조회된 행이 있을 때만
                // 컬럼값을 객체로 매핑
                customer = new Customer(rs.getString(1), 
                                rs.getString(2), 
                                rs.getString(3), 
                                rs.getInt(4), 
                                rs.getDate(5));
            }

            System.out.println("조회 결과 : " + customer);
        } catch (SQLException e) {
          System.out.println("SELECT 실행 예외 : " + e.getMessage());
        }
        OracleConnectionUtil.close(connection);

  }

}

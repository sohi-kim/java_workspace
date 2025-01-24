package dao.day2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import vo.day1.Customer;

public class TblCustomerDao {

    // db연결 정보를 상수로 정의합니다.
    private static final String URL = "jdbc:oracle:thin:@//localhost:1521/xe";
    private static final String USERNAME ="c##idev";
    private static final String PASSWORD ="1234";

    // db연결 객체 만드는 메소드를 dao 에서만 사용할 수 있도록 정의
    private Connection getConnection() throws SQLException {
      return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    // sql 실행 메소드 정의 -> 각 sql connection 만들어서 사용하고 sql 실행 후 close()
    public int insert(Customer vo ){
      int result=0;
      String sql="INSERT INTO tbl_customer(custom_id, name, email, age, reg_date) " +
                 "VALUES (?, ?, ?, ? , sysdate) ";
      try (Connection connection = getConnection();
           PreparedStatement pstmt = connection.prepareStatement(sql);
          ) {
            pstmt.setString(1, vo.getCustomId());
            pstmt.setString(2, vo.getName());
            pstmt.setString(3, vo.getEmail());
            pstmt.setInt(4, vo.getAge());

            result = pstmt.executeUpdate();
      } catch (Exception e) {
            System.out.println("예외 : " + e.getMessage());
      }
      return result;
    }

    public int update(Customer vo) {
      int result =0;
      // 이메일, 우편번호 업데이트
      String sql="UPDATE tbl_customer SET email = ?, postcode = ? WHERE custom_id = ?";
      try (Connection connection = getConnection();
           PreparedStatement pstmt = connection.prepareStatement(sql);
          ) {
            pstmt.setString(1, vo.getEmail());
            pstmt.setString(2, vo.getPostcode());
            pstmt.setString(3,vo.getCustomId());
            result=pstmt.executeUpdate();
        
      } catch (Exception e) {
        System.out.println("예외 : " + e.getMessage());
      }
      return result;
    }

    // 기본키 값으로 삭제
    public int delete(String customId) {
      int result =0;
      String sql="DELETE FROM tbl_customer WHERE custom_id = ?";
      try (Connection connection = getConnection();
           PreparedStatement pstmt = connection.prepareStatement(sql);
          ) {
            pstmt.setString(1, customId);
            result = pstmt.executeUpdate();
      } catch (Exception e) {
        System.out.println("예외 : " + e.getMessage());
      }
      return result;
    }

    // 기본키 값으로 조회
    public Customer selectByPk(){
      String sql="";
      try (Connection connection = getConnection();
           PreparedStatement pstmt = connection.prepareStatement(sql);
          ) {
        
      } catch (Exception e) {
        System.out.println("예외 : " + e.getMessage());
      }
      return null;
    } 
}

package day2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import day1.OracleConnectionUtil;
import vo.day1.Product;

public class ProductMenu2 {
  public static void main(String[] args) {
    System.out.println("키워드로 상품을 검색하는 메뉴입니다.");
    // 상품 키워드 입력
    System.out.print("검색 키워드 입력 >>> ");
    String keyword = System.console().readLine();
    Connection connection = OracleConnectionUtil.getConnection();

    String sql="SELECT * \r\n" + 
                "FROM TBL_PRODUCT tp \r\n" + 
                "WHERE \r\n" + 
                "PNAME LIKE '%' || ? || '%'";
    List<Product> list = new ArrayList<>();
    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
      pstmt.setString(1, keyword);
      ResultSet rs = pstmt.executeQuery();
      Product product = null;
      while (rs.next()) {
            product = new Product(rs.getString(1), 
                                  rs.getString(2), 
                                  rs.getString(3), 
                                  rs.getInt(4));
            list.add(product);
      }
      
      for(Product p : list) {
        System.out.println(String.format("%-20s   %-20s  %4s  %9d", 
                    p.getPcode(),p.getPname(),p.getCategory(),p.getPrice()));
      }

    } catch (Exception e) {
      System.out.println("예외 : " + e.getMessage());
    }




  }

}

package day2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import day1.OracleConnectionUtil;
import vo.day1.Product;

public class ProductMenu1 {
  public static void main(String[] args) {
    System.out.println("가격대로 상품을 검색하는 메뉴입니다.");
    // 가격1 ~ 가격2
    System.out.print("시작(최소) 가격 입력 >>> ");
    int price1= Integer.parseInt(System.console().readLine());
    System.out.print("마지막(최대) 가격 입력 >>> ");
    int price2= Integer.parseInt(System.console().readLine());

    Connection connection = OracleConnectionUtil.getConnection();

    String sql="SELECT * FROM tbl_product WHERE price BETWEEN ? AND ? ";
    List<Product> list = new ArrayList<>();
    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
      pstmt.setInt(1, price1);
      pstmt.setInt(2, price2);

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

package dao.day2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import day3.BuyVo;
import vo.day1.Product;

public class TblProductDao {
    // 싱글톤 패턴 정의
    private static TblProductDao dao = new TblProductDao();
    private TblProductDao(){ }
    public static TblProductDao getInstance(){
        return dao;
    }

    // db 연결 정보를 상수로 정의합니다.
    private static final String URL = "jdbc:oracle:thin:@//localhost:1521/xe";
    private static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";

    // db 연결 객체 만드는 메소드 dao 에서만 사용할 수 있도록 정의
    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    // SQL 메소드 정의 각 sql connection 만들어서 사용하고 sql 실행 후 close()
    // 상품 등록하기 
    public int insert(Product vo){
        int result =0;
        String sql = "INSERT INTO TBL_PRODUCT(pcode, category, pname, price)" + 
                        "VALUES(?, ?, ?, ?)";
        try (Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ) {
                pstmt.setString(1, vo.getPcode());
                pstmt.setString(2, vo.getCategory());
                pstmt.setString(3, vo.getPname());
                pstmt.setInt(4, vo.getPrice());

                result = pstmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("예외 : " + e.getMessage());
        }
        return result;
    }

    // 상품명, 가격 업데이트
    public int update(Product vo){
        int result =0;
        String sql ="UPDATE TBL_PRODOCT SET pname = ?, price = ? WHERE pcode = ?";
        try (Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ) {
                pstmt.setString(1, vo.getPname());
                pstmt.setInt(2, vo.getPrice());
                pstmt.setString(3, vo.getPcode());

                result = pstmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("예외 : " + e.getMessage());
        }
        return result;
    }

    // 기본키 값으로 삭제
    public int delete(String pname){
        int result=0;
        String sql = "DELETE FROM tbl_product WHERE pname = ?";
        try (Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ) {
                pstmt.setString(1, pname);

                result = pstmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("예외 : " + e.getMessage());
        }
        return result;
    }

    // 기본키 값으로 조회
    public Product selectByPk(String pcode){
        String sql = "SELECT * FROM TBL_PRODUCT WHERE pcode = ?";
        Product product = null;
        try (Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ) {
                pstmt.setString(1, pcode);
                ResultSet rs = pstmt.executeQuery();
                if(rs.next()){
                    product = new Product(rs.getString(1),
                                          rs.getString(2),
                                          rs.getString(3),
                                          rs.getInt(4));
                }
            
        } catch (Exception e) {
            System.out.println("예외 : " + e.getMessage());
        }
        return product;
    }

    // 상품 키워드로 조회
    public List<Product> searchByKeyword(String pname){
        String sql = "SELECT * FROM TBL_PRODUCT LIKE '%' || ? || '%' ";
        List<Product> list = new ArrayList<>();
        try (Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ) {
                pstmt.setString(1, pname);

                ResultSet rs = pstmt.executeQuery();
                Product product = null;
            while (rs.next()) {
                product = new Product(rs.getString(1),
                                      rs.getString(2),
                                      rs.getString(3),
                                      rs.getInt(4));
                list.add(product);
            }
           
        } catch (Exception e) {
            System.out.println("예외 : " + e.getMessage());
        }
        return list; 
    }

    // 상품 가격 정보를 Map 에 저장하기 - map 연습 예제
    //  ㄴ Map 에 저장한 데이터는 검색 성능이 좋습니다.
    // 상품 가격표
    public Map<String, Integer> getPriceTable() {
        Map<String, Integer> map = new HashMap<>();
        String sql = "select pcode,price from tbl_product";
        try(
            Connection conn = getConnection();
            PreparedStatement psmt = conn.prepareStatement(sql))
		{
		    ResultSet rs = psmt.executeQuery();
		    while(rs.next()) {  
			        map.put(rs.getString(1),   //key는 조회된 첫번째 컬럼 pcode
                       rs.getInt(2));    //value는 조회된 두번째 컬럼 price
		    }
        }catch(SQLException e){
            System.out.println("getPriceTable 예외 발생 : " + e.getMessage());
        }

        return map;
    }

    public Map<String,Product> selectAll(){
      Map<String,Product> map = new HashMap<>();
      String sql = "SELECT * FROM tbl_product";    // 모든행, 모든컬럼 조회
      try (
           Connection connection = getConnection();
           PreparedStatement pstmt = connection.prepareStatement(sql)
      ) {
           ResultSet rs = pstmt.executeQuery();
           while(rs.next()){
              // map 에 조회된 행들을 추가
              Product vo = new Product(rs.getString(1), 
                      rs.getString(2), 
                      rs.getString(3), 
                      rs.getInt(4));
              map.put(rs.getString(1),vo);  //value 타입이 Product 
           }
      } catch (Exception e) {
        System.out.println("예외 : " + e.getMessage());
      }


      return map;
    }

}
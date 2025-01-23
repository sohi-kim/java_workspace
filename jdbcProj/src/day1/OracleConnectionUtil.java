package day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnectionUtil {
   
    private static final String URL ="jdbc:oracle:thin:@//localhost:1521/xe";
    private static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";
    
    public static Connection getConnection() {
        Connection conn = null;
        try {
            
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch(SQLException  e){
            System.out.println("데이터베이스 연결 예외  : \n\t " + e.getMessage());
        }  
        
        return conn;
    }
   
    public static void close(Connection conn){
        try {
            if(conn !=null) conn.close();
        } catch (SQLException e) {
            System.out.println("데이터베이스 연결 해제 예외 발생 \n\t: " + e.getMessage());
        }
    }

}

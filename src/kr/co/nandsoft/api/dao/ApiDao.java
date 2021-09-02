package kr.co.nandsoft.api.dao;

import kr.co.nandsoft.api.model.ApiResultVo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ApiDao {
    private static Connection getConnection() throws SQLException {
        Connection conn = null;
// study 중간에 cj.이 들어가는지 모르고 고생했다. 버전마다 다르단걸 꼭 확인하자.
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
/* study DB에 내 계정을 미리 생성하여 작업하자. root는 가급적 쓰지말자. #생성해도 안된다면 grant 권한 부여 확인해보기.
    그래도 안된다면 DB마다 대소문자 구분하는 방식이 0,1,2 로 다르니 꼭 serach 해볼것!
 */
            String url = "jdbc:mysql://127.0.0.1:3306/bus";
            conn = DriverManager.getConnection(url, "yuihmoo", "dydehf12##");
        }
        catch (ClassNotFoundException e) {
            System.out.println(" 드라이버 로딩 실패 ");
        }

        return conn;
    }

    public static void insert(ApiResultVo vo) {
        boolean result = false;
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = getConnection();

            String sql = "INSERT INTO bus_station(mobileId, stationId, stationName, searchDate, location) VALUES (?, ?, ?, ?, ?);";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, vo.getMobileId());
            pstmt.setString(2, vo.getStationId());
            pstmt.setString(3, vo.getStationName());
            pstmt.setString(4, vo.getSearchDate());
            pstmt.setString(5, vo.getLocation());
            int count = pstmt.executeUpdate();

            result = (count == 1);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if( conn != null ) {
                    conn.close();
                }
                if( pstmt != null ) {
                    pstmt.close();
                }
            }
            catch(SQLException e) {
                e.printStackTrace();
            }
        }

    }
}

package kr.co.nandsoft.api.dao;

import kr.co.nandsoft.api.model.SelectVo;

import java.sql.*;
import java.util.*;

public class SelectDao {
// study class 안에 메소드나 변수 타입 설정하는게 익숙치 않아서 고생했다. 더 열심히 공부하자. 네이밍도 고민해보기
    public static List<String> DoSelect(SelectVo selectVo) {
        selectVo = new SelectVo();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://127.0.0.1:3306/bus";
            conn = DriverManager.getConnection(url, "yuihmoo", "dydehf12##");

                stmt = conn.createStatement();
                //study JDBC에서 SELECT문 쓸때는 ;(세미콜론)이 생략된다. 몰라서 고생했으니까 복습하자.
                String sql = "SELECT mobileId, stationId, stationName, searchDate, location FROM bus_station WHERE searchDate = '2019-01-01' and location = '대구광역시 북구 동천동'";

                rs = stmt.executeQuery(sql);
                //study 분명히 객체 형태로 저장할 다른 방법이 있을것이다. 찾아보자.
                HashMap<String, Object> map = new HashMap();

                while(rs.next()) {
                    selectVo.setMobileId(rs.getString(1));
                    selectVo.setStationId(rs.getString(2));
                    selectVo.setStationName(rs.getString(3));
                    selectVo.setSearchDate(rs.getString(4));
                    selectVo.setLocation(rs.getString(5));
//                String moibleId = rs.getString(1);
//                String stationId = rs.getString(2);

                map.put(rs.getString(2),rs.getString(3));
            }
            selectVo.setResult(map);
        }
        catch( ClassNotFoundException e){
            System.out.println("드라이버 로딩 실패");
        }
        catch( SQLException e){
            System.out.println("에러 " + e);
        }
        finally{
            try{
                if( conn != null && !conn.isClosed()){
                    conn.close();
                }
                if( stmt != null && !stmt.isClosed()){
                    stmt.close();
                }
                if( rs != null && !rs.isClosed()){
                    rs.close();
                }
            }
            catch( SQLException e){
                e.printStackTrace();
            }
        }
        LinkedList<String> result = new LinkedList<>();
        return result;
    }
}
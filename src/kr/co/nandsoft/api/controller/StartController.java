package kr.co.nandsoft.api.controller;

import kr.co.nandsoft.api.service.BusStationApiService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

public class StartController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        JSONParser jsonParse = new JSONParser();
//        String json = String.valueOf(BusStationApiService.getJsonDate());
//        try {
//            JSONObject obj = (JSONObject) jsonParse.parse(json); // java.util Stirng을 JSON String으로 형변환(고생했다..)
//            String jsonString = obj.toJSONString();
//
//            JSONObject jsonObject = (JSONObject) obj;
//
//            JSONArray jsonArray = (JSONArray) obj.get("data"); // array로 형변환
//
//            LinkedList<String> stationList = new LinkedList();
//            LinkedList<String> locationList = new LinkedList();
//            LinkedList<String> stationIDList = new LinkedList<>();
//            LinkedList<String> sumList = new LinkedList<>();
//
//
//            for (int i = 0; i < jsonArray.size(); i++) { // 각 key 값마다 value 뽑기
//                JSONObject jsonObj = (JSONObject) jsonArray.get(i);
//
//                stationList.add((String) jsonObj.get("정류소명"));
//                locationList.add((String) jsonObj.get("행정구역"));
//                stationIDList.add((String) jsonObj.get("정류소ID"));
//                sumList.add((String) jsonObj.get("합계"));
//
//            }
//            request.setAttribute("stationIDList", stationIDList);
//            request.setAttribute("locationList", locationList);
//            request.setAttribute("stationList", stationList);
//            request.setAttribute("sumList", sumList);
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);

    }

}
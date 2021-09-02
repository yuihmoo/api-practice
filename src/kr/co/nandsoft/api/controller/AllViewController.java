package kr.co.nandsoft.api.controller;

import com.google.gson.Gson;
import kr.co.nandsoft.api.model.ApiResultVo;
import kr.co.nandsoft.api.service.BusStationApiService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AllViewController extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try {
//            Gson gson = new Gson();
//            Map data = gson.fromJson(BusStationApiService.getJsonDate(),Map.class);
//
//            List<Map> list = (List)data.get("data");
//
//            list.stream()
//                    .forEach(x -> {
//                        x.put("mobileId", x.get("모바일ID"));
//                        x.put("stationId", x.get("정류소ID"));
//                        x.put("stationName", x.get("정류소명"));
//                        x.put("searchDate", x.get("조회일자"));
//                        x.put("location", x.get("행정구역"));
//                        for (int i = 5; i <= 23; i++) {
//                            x.put("hour_" + i, x.get(String.format("%02d시",i)));
//                        }
//                    });
//
//            List<ApiResultVo> apiVoList = list.stream()
//                    .map(x -> {
//                        String jsonStr = gson.toJson(x);
//                        return gson.fromJson(jsonStr, ApiResultVo.class);
//                    })
//                    .collect(Collectors.toList());
//
//            for(ApiResultVo sel : apiVoList) {
//                System.out.println(sel.getStationName());
//            }
//
//            request.setAttribute("list", list);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index2.jsp");
        dispatcher.forward(request, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);

    }

}
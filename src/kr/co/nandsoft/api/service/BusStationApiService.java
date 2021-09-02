package kr.co.nandsoft.api.service;

import com.google.gson.Gson;
import kr.co.nandsoft.api.dao.ApiDao;
import kr.co.nandsoft.api.model.ApiResultVo;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BusStationApiService {
    {

    }

    private static final String USER_AGENT = "chrome";
    private static final String GET_API_URL = "https://api.odcloud.kr/api/15050942/v1/uddi:5140939e-5c7c-4acb-9fbd-9dd176472bcc?page=%d";
    private static final String SUB_URL = "&perPage=1000&serviceKey=OZfg3yV%2Fy9p7Hhg7rcXEtBxKVBDWToIRwRUDN9vRdjTzwjQxKHsSPI24KaNL8Onpko35dLUiKYXHJLiLcJpT9A%3D%3D";

    /**
     * @return
     * @see <p>버스 정류장 승차 관련 공공 API 호출 메서드</p>
     */
    public static void main(String[] args) {
        String json = null;
        /* 각 (page = i) 당 1000개의 perpage를 가져온다.
        GET_API_URL 과 USER_AGENT 는 바뀌지 않을 값이기 때문에 변수 할당하여 static final 처리 해주었다.
        메모리 흐름을 좋게하고 실수를 줄여준다.
         */

        for (int i = 50; i < 101; i++) {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(String.format(GET_API_URL, i) + SUB_URL);
            httpGet.addHeader("User-Agent", USER_AGENT);
            httpGet.addHeader("Content-type", "application/json");

            CloseableHttpResponse response = null;
            try {
                response = client.execute(httpGet);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //study 책임님이 짜주신 코드다. 제대로 이해할 때 까지 복습하자.
            json = null;
            try {
                json = EntityUtils.toString(response.getEntity(), "UTF-8");
                Map busstopInfo = new Gson().fromJson(json, Map.class);
//                System.out.println(busstopInfo.toString());
                List<Map> data = (List) busstopInfo.get("data");
                for (Map<String, Object> row : data) {
//                    System.out.println(row);
                }
            } catch (Exception ioException) {
                ioException.printStackTrace();
            }
            System.out.println(json);
            Gson gson = new Gson();
            Map data = gson.fromJson(json, Map.class);

            List<Map> list = (List) data.get("data");
            // study 책임님이 짜주신 코드다. 제대로 이해할 때 까지 stream 과 람다식을 찾아보자.
            list.stream()
                    .forEach(x -> {
                        x.put("mobileId", x.get("모바일ID"));
                        x.put("stationId", x.get("정류소ID"));
                        x.put("stationName", x.get("정류소명"));
                        x.put("searchDate", x.get("조회일자"));
                        x.put("location", x.get("행정구역"));
                        for (int j = 5; j <= 23; j++) {
                            x.put("hour_" + j, x.get(String.format("%02d시", j)));
                        }
                    });

            List<ApiResultVo> apiVoList = list.stream()
                    .map(x -> {
                        String jsonStr = gson.toJson(x);
                        return gson.fromJson(jsonStr, ApiResultVo.class);
                    })
                    .collect(Collectors.toList());
            // study 향상된 for문도 복습할 필요가 있다.
            for (ApiResultVo sel : apiVoList) {
                ApiResultVo vo = new ApiResultVo();
                vo.setMobileId((String) sel.getMobileId());
                vo.setStationId((String) sel.getStationId());
                vo.setStationName((String) sel.getStationName());
                vo.setSearchDate((String) sel.getSearchDate());
                vo.setLocation((String) sel.getLocation());

                ApiDao dao = new ApiDao();
                dao.insert(vo);
            }
        }
    }
}


package kr.co.nandsoft.api.model;

import java.util.ArrayList;
import java.util.HashMap;

public class SelectVo {
    private static String mobileId;
    private static String stationId;
    private static String stationName;
    private static String searchDate;
    private static String location;
    private static HashMap<String, Object> result;


    public static HashMap<String, Object> getResult() {
        return result;
    }

    public void setResult(HashMap<String, Object> result) {
        this.result = result;
    }

    public String getMobileId() {
        return mobileId;
    }

    public String setMobileId(String mobileId) {
        this.mobileId = mobileId;
        return mobileId;
    }

    public String getStationId() {
        return stationId;
    }

    public String setStationId(String stationId) {
        this.stationId = stationId;
        return stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public String setStationName(String stationName) {
        this.stationName = stationName;
        return stationName;
    }

    public String getSearchDate() {
        return searchDate;
    }

    public String setSearchDate(String searchDate) {
        this.searchDate = searchDate;
        return searchDate;
    }

    public String getLocation() {
        return location;
    }

    public String setLocation(String location) {
        this.location = location;
        return location;
    }

}


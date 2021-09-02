package kr.co.nandsoft.api.model;

public class ImmutableApiResultVo {

    private final String mobileId;
    private final String stationId;
    private final String stationName;
    private final String searchDate;
    private final String location;

    public ImmutableApiResultVo(String mobileId, String stationId, String stationName, String searchDate, String location) {
        this.mobileId = mobileId;
        this.stationId = stationId;
        this.stationName = stationName;
        this.searchDate = searchDate;
        this.location = location;
    }

    public String getMobileId() {
        return mobileId;
    }

    public String getStationId() {
        return stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public String getSearchDate() {
        return searchDate;
    }

    public String getLocation() {
        return location;
    }
}

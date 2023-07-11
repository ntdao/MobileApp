package com.example.mobileprogramming;

public class AQIResponse {
    private String stationId;
    private String content;
    private double aqi;
    private double lat;
    private double lon;

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getAqi() {
        return aqi;
    }

    public void setAqi(double aqi) {
        this.aqi = aqi;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "AQIResponse{" +
                "stationId='" + stationId + '\'' +
                ", content='" + content + '\'' +
                ", aqi=" + aqi +
                ", lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}

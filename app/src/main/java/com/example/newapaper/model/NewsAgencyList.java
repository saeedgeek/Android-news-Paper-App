package com.example.newapaper.model;

public class NewsAgencyList {
    private  String status;
    private   NewsAgency[] sources;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public NewsAgency[] getSources() {
        return sources;
    }

    public void setSources(NewsAgency[] sources) {
        this.sources = sources;
    }

    @Override
    public String toString() {
        return "NewsAgencyList{" +
                "status='" + status + '\'' +
                ", sources='" + sources + '\'' +
                '}';
    }
}

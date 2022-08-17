package com.wonit.springbootplayground;

public class Dispatcher {

    private String eventType;
    private String eventVersion;
    private String commendHandler;
    private String eventToCommendConverter;

    public Dispatcher(String eventType, String eventVersion, String commendHandler, String eventToCommendConverter) {
        this.eventType = eventType;
        this.eventVersion = eventVersion;
        this.commendHandler = commendHandler;
        this.eventToCommendConverter = eventToCommendConverter;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventVersion() {
        return eventVersion;
    }

    public void setEventVersion(String eventVersion) {
        this.eventVersion = eventVersion;
    }

    public String getCommendHandler() {
        return commendHandler;
    }

    public void setCommendHandler(String commendHandler) {
        this.commendHandler = commendHandler;
    }

    public String getEventToCommendConverter() {
        return eventToCommendConverter;
    }

    public void setEventToCommendConverter(String eventToCommendConverter) {
        this.eventToCommendConverter = eventToCommendConverter;
    }

    @Override
    public String toString() {
        return "Dispatcher{" +
                "eventType='" + eventType + '\'' +
                ", eventVersion='" + eventVersion + '\'' +
                ", commendHandler='" + commendHandler + '\'' +
                ", eventToCommendConverter='" + eventToCommendConverter + '\'' +
                '}';
    }


}
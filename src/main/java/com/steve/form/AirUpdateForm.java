package com.steve.form;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class AirUpdateForm {

    private Integer id;
    private Integer districtId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date monitorTime;
    private Integer pm10;
    private Integer pm25;
    private String monitoringStation;

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public void setMonitorTime(Date monitorTime) {
        this.monitorTime = monitorTime;
    }

    public void setPm10(Integer pm10) {
        this.pm10 = pm10;
    }

    public void setPm25(Integer pm25) {
        this.pm25 = pm25;
    }

    public void setMonitoringStation(String monitoringStation) {
        this.monitoringStation = monitoringStation;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public Date getMonitorTime() {
        return monitorTime;
    }

    public Integer getPm10() {
        return pm10;
    }

    public Integer getPm25() {
        return pm25;
    }

    public String getMonitoringStation() {
        return monitoringStation;
    }
}

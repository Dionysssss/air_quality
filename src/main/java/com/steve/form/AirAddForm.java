package com.steve.form;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class AirAddForm {

    @NotNull(message = "检测区域为必选项")
    private Integer districtId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "检测时间为必选项")
    private Date monitorTime;
    @NotNull(message = "pm10为必选项")
    private Integer pm10;
    @NotNull(message = "pm25为必选项")
    private Integer pm25;
    @NotBlank(message = "检测站为必须项")
    private String monitoringStation;

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

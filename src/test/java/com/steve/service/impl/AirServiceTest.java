package com.steve.service.impl;

import com.steve.form.AirAddForm;
import com.steve.form.AirUpdateForm;
import com.steve.service.AirService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class AirServiceTest {

    @Autowired
    private AirService airService;

    @Test
    @Transactional
    void add() {
        AirAddForm air = new AirAddForm();
        air.setDistrictId(1);
        air.setMonitorTime(new Date());
        air.setPm10(10);
        air.setPm25(25);
        air.setMonitoringStation("LA检测站");
        airService.add(air);
    }

    @Test
    void update(){
        AirUpdateForm air = new AirUpdateForm();
        air.setId(7);
        air.setDistrictId(1);
        air.setMonitorTime(new Date());
        air.setPm10(10);
        air.setPm25(25);
        air.setMonitoringStation("LA检测站_!!");
        airService.updateById(air);
    }
}
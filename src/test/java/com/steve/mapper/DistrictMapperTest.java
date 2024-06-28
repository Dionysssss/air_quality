package com.steve.mapper;

import com.steve.controller.AirController;
import com.steve.entity.District;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DistrictMapperTest {

    @Autowired
    private DistrictMapper districtMapper;
    @Autowired
    private AirController airController;

    @Test
    public void findAll() {
        List<District> list = districtMapper.findAll();
        System.out.println(list);
    }

    @Test
    public void districtList(){
        System.out.println(airController.districtList());
    }
}
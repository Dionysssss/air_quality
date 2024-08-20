package com.steve.mapper;

import com.github.pagehelper.PageInfo;
import com.steve.entity.Air;
import com.steve.service.AirService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



@RunWith(SpringRunner.class)
@SpringBootTest
public class AirMapperTest {

    @Autowired
    private AirMapper airMapper;
    @Autowired
    private AirService airService;

    @Test
    public void findByDistrictId(){
        List<Air> list = airMapper.findByDistrictId(null);
        for (Air air:  list){
            System.out.println(air);
        }
    }

    @Test
    public void findAirByDistricIdAndPage(){
        PageInfo pageInfo = airService.findAirByDistrictIdAndPage(1, 5, null);
        List list = pageInfo.getList();
        for (Object o : list) {
            System.out.println(o);
        }
        System.out.println(pageInfo.getTotal());
    }


}
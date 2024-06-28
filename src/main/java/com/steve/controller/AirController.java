package com.steve.controller;

import com.steve.entity.District;
import com.steve.service.AirService;
import com.steve.util.R;
import com.steve.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Map;
import java.util.List;

@RestController
public class AirController {

    @Autowired
    private AirService airService;

    @GetMapping("/district/list")
    public ResultVO districtList(){
        List<District> districtList = airService.findDistrictList();
        return R.ok(districtList);

    }
}

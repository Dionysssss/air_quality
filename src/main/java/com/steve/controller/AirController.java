package com.steve.controller;

import com.github.pagehelper.PageInfo;
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

    /**
     * 分页&条件查询空气质量信息
     * GET	http://localhost:8080/air/list
     *
     *  请求参数
     *      page = 1 (当前页，默认1)
     *      size = 5 (每页显示条数，默认5)
     *      districtId = null (区域条件)
     */
    @GetMapping("/air/list")
    public ResultVO airList(@RequestParam(defaultValue = "1")Integer page,
                            @RequestParam(defaultValue = "5")Integer size,
                            Integer districtId){
        PageInfo pageInfo = airService.findAirByDistrictIdAndPage(page, size, districtId);
        return R.ok(pageInfo);
    }
}

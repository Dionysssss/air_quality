package com.steve.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.steve.entity.Air;
import com.steve.entity.District;
import com.steve.mapper.AirMapper;
import com.steve.mapper.DistrictMapper;
import com.steve.service.AirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirServiceImpl implements AirService {

    @Autowired
    private DistrictMapper districtMapper;

    @Autowired
    private AirMapper airMapper;

    @Override
    public List<District> findDistrictList() {
        List<District> districtList = districtMapper.findAll();
        return districtList;
    }

    @Override
    public PageInfo findAirByDistrictIdAndPage(Integer page, Integer size, Integer districtId) {
        PageHelper.startPage(page, size);

        List<Air> airList = airMapper.findByDistrictId(districtId);

        PageInfo pageInfo = new PageInfo(airList);

        return pageInfo;
    }
}

package com.steve.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.steve.entity.Air;
import com.steve.entity.District;
import com.steve.form.AirAddForm;
import com.steve.form.AirUpdateForm;
import com.steve.mapper.AirMapper;
import com.steve.mapper.DistrictMapper;
import com.steve.service.AirService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.TimeoutException;

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

    @Override
    @Transactional
    public void add(AirAddForm airAddForm) {
        // 1. 封装数据
        Air air = new Air();
        BeanUtils.copyProperties(airAddForm, air);

        // 2. 添加数据
        int count = airMapper.insert(air);

        // 3. 判断count
        if (count != 1){
            System.out.println("添加空气质量 失败");
            throw new RuntimeException("添加空气质量 失败");
        }

    }

    @Override
    @Transactional
    public void updateById(AirUpdateForm airUpdateForm) {

        // 1. 封装数据
        Air air = new Air();
        BeanUtils.copyProperties(airUpdateForm, air);

        // 2. 修改数据
        int count = airMapper.updateById(air);

        // 3. 不成功，扔异常
        if (count != 1){
            System.out.println("修改空气质量 修改失败");
            throw new RuntimeException("修改空气质量 修改失败！！！");
        }
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        // 1. 删除数据
        int count = airMapper.deleteById(id);

        // 2. 不成功 扔异常
        if (count != 1){
            System.out.println("修改空气质量 修改失败");
            throw new RuntimeException("修改空气质量 修改失败！！！");
        }
    }
}

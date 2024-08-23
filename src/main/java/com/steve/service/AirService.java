package com.steve.service;

import com.steve.entity.Air;
import com.steve.entity.District;
import com.github.pagehelper.PageInfo;
import com.steve.form.AirAddForm;
import com.steve.form.AirUpdateForm;

import java.util.List;

public interface AirService {

    List<District> findDistrictList();

    /**
     * 分页&条件查询空气质量信息
     * @param page
     * @param size
     * @param districtId
     * @return
     */
    PageInfo findAirByDistrictIdAndPage(Integer page, Integer size, Integer districtId);

    /**
     * 添加空气质量信息
     * @param airAddForm
     */
    void add(AirAddForm airAddForm);

    /**
     *
     * @param air
     */
    void updateById(AirUpdateForm air);

    void deleteById(Integer id);
}

package com.steve.mapper;

import com.steve.entity.Air;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AirMapper {

    // 查询 扔mapper

    List<Air> findByDistrictId(@Param("districtId")Integer districtId);
}

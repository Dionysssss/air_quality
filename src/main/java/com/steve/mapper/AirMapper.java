package com.steve.mapper;

import com.steve.entity.Air;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AirMapper {

    // 查询 扔mapper

    List<Air> findByDistrictId(@Param("districtId")Integer districtId);

    @Insert("insert into air (district_id, monitor_time, pm10, pm25, monitoring_station) values (#{districtId},#{monitorTime},#{pm10},#{pm25},#{monitoringStation})")
    int insert(Air air);


//    @Insert("update air set district_id = #{districtId}, monitor_time = #{monitorTime}, pm10 = #{pm10}, pm25 = #{pm25}, monitoring_station = #{monitoringStation} where id = #{id}")
    int updateById(Air air);

    @Delete("delete from air where id = #{id}")
    int deleteById(@Param("id") Integer id);
}

package com.steve.controller;

import com.github.pagehelper.PageInfo;
import com.steve.entity.Air;
import com.steve.entity.District;
import com.steve.form.AirAddForm;
import com.steve.form.AirUpdateForm;
import com.steve.service.AirService;
import com.steve.util.R;
import com.steve.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
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

    /**
     * # 请求方式&路径
     *  POST http://localhost:8080/air/add
     *
     * # 请求参数
     * districtId = Integer (必)
     * monitorTime = yyyy-MM-dd (必)
     * pm10 = Integer (必)
     * pm25 = Integer (必)
     * monitoringStation = String (必)
     *
     * # 业务流程
     * 1. 接收参数
     * 2. 做参数的非空校验
     * 3. 数据扔到数据库
     *
     * # 响应数据
     * 成功响应：
     * {
     *     "code": 0,
     *     "msg": ""
     * }
     * 失败响应：
     * {
     *     "code": 错误编码，
     *     "msg": "错误信息"
     * }
     */

    @PostMapping("/air/add")
    public ResultVO addAir(@Valid AirAddForm airAddForm, BindingResult result){
    // 1. 查看参数是否合法
        if(result.hasErrors())
        {
            String message = result.getFieldError().getDefaultMessage();
            return R.error(400, message);
        }

    airService.add(airAddForm);

    return R.ok();
    }

    /**
     * # 请求方式&路径
     *  POST http://localhost:8080/air/update
     *
     * # 请求参数
     * id = Integer
     * districtId = Integer (非)
     * monitorTime = yyyy-MM-dd (非)
     * pm10 = Integer (非)
     * pm25 = Integer (非)
     * monitoringStation = String (非)
     *
     * # 业务流程
     * 1. 接收参数
     * 2. 做参数的非空校验
     * 3. 修改指定id对数据
     *
     * # 响应数据
     * 成功响应：
     * {
     *     "code": 0,
     *     "msg": ""
     * }
     * 失败响应：
     * {
     *     "code": 错误编码，
     *     "msg": "错误信息"
     * }
     */
    @PostMapping("/air/update")
    public ResultVO airUpdate(AirUpdateForm air){
        // 1. 接收参数做非空校验
        Integer id = air.getId();
        if(id == null){
            return R.error(400, "参数不合法");
        }

        // 2. 找Service修改数据
        airService.updateById(air);

        // 3. 返回
        return R.ok();
    }

    /**
     * 删除空气质量信息
     * # 请求方式&路径
     *  Delete http://localhost:8080/air/delete{id}
     *
     * # 请求参数
     * id = Integer
     *
     * # 业务流程
     * 1. 接收参数
     * 2. 删除指定id的数据
     *
     * # 响应数据
     * 成功响应：
     * {
     *     "code": 0,
     *     "msg": ""
     * }
     * 失败响应：
     * {
     *     "code": 错误编码，
     *     "msg": "错误信息"
     * }
     */
    @DeleteMapping("air/delete/{id}")
    public ResultVO airDelete(@PathVariable Integer id) {
        // 1. 删除操作
        airService.deleteById(id);

        // 2. 返回ok
        return R.ok();

    }
}

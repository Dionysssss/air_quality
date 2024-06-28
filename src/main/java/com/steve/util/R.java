package com.steve.util;


import com.steve.vo.ResultVO;

public class R {

    public static ResultVO ok(){
        ResultVO vo = new ResultVO();
        vo.setCode(0);
        vo.setMsg("");
        return vo;
    }

    public static ResultVO ok(Object data) {
        ResultVO vo = ok();
        vo.setData(data);
        return vo;
    }
}

package com.steve.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ResultVO {
    private Integer code;

    private String msg;

    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    private Long total;

    private Object data;

    public Long getTotal() { return total; }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public ResultVO() {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ResultVO{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

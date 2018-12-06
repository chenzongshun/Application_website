package com.shun.utils;

import java.io.Serializable;
import java.util.List;


/**
 * 商品上传成功后的返回处理类
 */
public class ylfResult implements Serializable {

	private static final long serialVersionUID = 1L;

    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    public static ylfResult build(Integer status, String msg, Object data) {
        return new ylfResult(status, msg, data);
    }

    public static ylfResult ok(Object data) {
        return new ylfResult(data);
    }

    public static ylfResult ok() {
        return new ylfResult(null);
    }

    public ylfResult() {

    }

    public static ylfResult build(Integer status, String msg) {
        return new ylfResult(status, msg, null);
    }

    public ylfResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ylfResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

//    public Boolean isOK() {
//        return this.status == 200;
//    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

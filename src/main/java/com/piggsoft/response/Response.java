package com.piggsoft.response;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by piggs on 2016/10/23.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    public static Response createSuccess() {
        Response response = new Response();
        response.setCode("0");
        response.setMsg("success");
        return response;
    }

    public static Response createSuccess(Object data) {
        Response response = createSuccess();
        response.setData(data);
        return response;
    }

    private String code;
    private String msg;
    private Object data;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

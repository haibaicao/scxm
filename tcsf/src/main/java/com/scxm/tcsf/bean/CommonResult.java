package com.scxm.tcsf.bean;

public class CommonResult<T> {
    private String code;//00为成功其他都为失败
    private String messge;
    private T data;//当code不为00时data为null
    public CommonResult(String code,String messge,T data){
        this.code=code;
        this.messge=messge;
        this.data=data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessge() {
        return messge;
    }

    public void setMessge(String messge) {
        this.messge = messge;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "code='" + code + '\'' +
                ", messge='" + messge + '\'' +
                ", data=" + data +
                '}';
    }
}

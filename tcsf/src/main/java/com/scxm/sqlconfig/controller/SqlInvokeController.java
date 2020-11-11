package com.scxm.sqlconfig.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.scxm.sqlconfig.bean.CommonResult;
import com.scxm.sqlconfig.bean.PageParam;
import com.scxm.sqlconfig.service.SqlInvokeService;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Set;

@RestController
public class SqlInvokeController{
    @Resource
    SqlInvokeService sqlInvokeService;

    @PostMapping(value="invoke")
    public CommonResult invoke(PageParam param){
        CommonResult commonResult= new CommonResult("500","请求出错！",null);
        try{
            commonResult=sqlInvokeService.InvokeSql(param);
        }catch (Exception e){
            e.printStackTrace();
            commonResult.setCode("99");
            commonResult.setMessge(e.getMessage());
        }
        return commonResult;
    }

    @PostMapping(value="query")
    public CommonResult invoke(String param){
        CommonResult commonResult= new CommonResult("500","请求出错！",null);
        try{
            String jsonStr = new String(Base64Utils.decodeFromString(param),"utf-8");
            PageParam pageParam = JSON.parseObject(jsonStr,PageParam.class);
            commonResult=sqlInvokeService.InvokeSql(pageParam);
        }catch (Exception e){
            e.printStackTrace();
            commonResult.setCode("99");
            commonResult.setMessge(e.getMessage());
        }
        return commonResult;
    }

    @GetMapping(value="invokeTest")
    public CommonResult test(){
        PageParam param = new PageParam();
        param.setSqlxh("100002");
        param.setPageIndex(1);
        param.setPageSize(50);
        param.setQueryParams("[{name:'hydm',value:'7297',type:'string'}]");
        CommonResult commonResult = sqlInvokeService.InvokeSql(param);
        return commonResult;
    }
}

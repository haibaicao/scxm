package com.scxm.tcsf.controller;

import com.scxm.tcsf.bean.CommonResult;
import com.scxm.tcsf.bean.YwTcjl;
import com.scxm.tcsf.service.YwService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
public class JkController {
    @Resource
    YwService ywService;

    @GetMapping(value="tcrk")
    public CommonResult tcrk(){
        YwTcjl ywJyJl = new YwTcjl();
        ywJyJl.setYwlsh("234234werweert");
        ywJyJl.setSxzt("00");
        ywJyJl.setSyr("admin");
        ywJyJl.setSzt("00");
        ywJyJl.setSbbh("123123");
        ywJyJl.setTrsj(new Date());
        ywJyJl.setCdate(new Date());
        CommonResult CommonResult = ywService.clrk(ywJyJl);
        return CommonResult;
    }


}

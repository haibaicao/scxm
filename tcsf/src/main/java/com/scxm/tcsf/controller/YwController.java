package com.scxm.tcsf.controller;

import com.scxm.tcsf.service.YwService;
import com.scxm.tcsf.bean.CommonResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Map;

@Controller
public class YwController {
    @Resource
    YwService ywService;

    @RequestMapping(value="pay/{sbbh}")
    public String pay(Model model,@PathVariable String sbbh){
        //String sbbh="111";
        if(sbbh==null){
            sbbh="111";
        }//仅用与测试
        CommonResult CommonResult=ywService.yjje(sbbh);
        Map<String,String> rtn = (Map<String, String>) CommonResult.getData();
        model.addAllAttributes(rtn);
        return "pay";
    }
}

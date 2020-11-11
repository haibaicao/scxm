package com.scxm.tcsf.controller;

import com.scxm.tcsf.bean.JcSbgl;
import com.scxm.tcsf.dao.JcDao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class JcController {
    @Resource
    JcDao dao;

    @GetMapping(value="test")
    public JcSbgl test(){
        JcSbgl sb = dao.getSbxx("111");
        return sb;
    }


}

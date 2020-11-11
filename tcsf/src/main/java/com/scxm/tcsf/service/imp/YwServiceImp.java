package com.scxm.tcsf.service.imp;

import com.scxm.tcsf.dao.YwDao;
import com.scxm.tcsf.service.YwService;
import com.scxm.tcsf.bean.CommonResult;
import com.scxm.tcsf.bean.YwTcjl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class YwServiceImp implements YwService {
    @Resource
    YwDao ywDao;

    public CommonResult clrk(YwTcjl jyjl) {
        String code="99";
        String messge = "";
        //1、验证车位器是否注册
        //2、创建停车记录
        int i = ywDao.createYwdj(jyjl);
        if(i>0){
            code="00";
            messge="成功";
        }
        return new CommonResult(code,messge,jyjl);
    }

    @Override
    public CommonResult yjje(String sbbh) {
        String code="99";
        String messge = "";
        YwTcjl tcjl = ywDao.cxywjl(sbbh);
        System.out.println(tcjl);
        Date tcsj = tcjl.getTrsj();
        System.out.println(tcsj);
        Long tjsj =System.currentTimeMillis()-tcsj.getTime();
        Long d=tjsj/(1000*24*60*60L);
        Long h=tjsj%(1000*24*60*60L)/(1000*60*60L);
        Long mi=tjsj%(1000*60*60L)/(1000*60L);
        String tcsc = "";
        if(d!=0){
            tcsc=tcsc+d+"天";
        }
        if(h!=0){
            tcsc=tcsc+h+"时";
        }
        if(mi!=0){
            tcsc=tcsc+mi+"分";
        }
        Map<String,String> rtnMap = new HashMap<String,String>();
        rtnMap.put("tcsc",tcsc);
        rtnMap.put("tcsj",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(tcsj));
        rtnMap.put("yjje",tjsj/(1000*60*60L)*5L+"");
        System.out.println(d+"天"+h+"时"+mi+"分");
        //BigDecimal
        return new CommonResult(code,messge,rtnMap);
    }

    @Override
    public int ewm(String sbbh) {
        return 0;
    }


}
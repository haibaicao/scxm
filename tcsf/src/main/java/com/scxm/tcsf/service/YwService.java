package com.scxm.tcsf.service;

import com.scxm.tcsf.bean.CommonResult;
import com.scxm.tcsf.bean.YwTcjl;

public interface YwService {
    /**
     * @function 车辆入库
     * @param jyjl
     * @return
     */
    public CommonResult clrk(YwTcjl jyjl);

    /**
     * @function 扫码支付
     * @param sbbh
     * @return
     */
    public CommonResult yjje(String sbbh);

    /**
     * @function 对应设备生成对应支付二维嘛
     * @param sbbh
     * @return
     */
    public int ewm(String sbbh);
}

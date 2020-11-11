package com.scxm.sqlconfig.service;


import com.scxm.sqlconfig.bean.CommonResult;
import com.scxm.sqlconfig.bean.PageParam;

public interface SqlInvokeService {
    public CommonResult InvokeSql(PageParam param);
}

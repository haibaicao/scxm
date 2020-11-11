package com.scxm.tcsf.dao;

import com.scxm.tcsf.bean.YwTcjl;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface YwDao {
    public int createYwdj(YwTcjl jyjl);
    //public int UpdateYwdj(YwJyJl jyjl);
    public YwTcjl cxywjl(String sbbh);
}

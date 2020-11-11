package com.scxm.tcsf.dao;

import com.scxm.tcsf.bean.JcSbgl;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JcDao {
    public JcSbgl getSbxx(String sbbh);
    //public int saveSbxx(JcSbgl sbxx);
}

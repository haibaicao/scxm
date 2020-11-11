package com.scxm.tcsf.bean;

import java.util.Date;

public class YwTcjl {
    private String id;
    private String ywlsh;
    private String sxzt;
    private String syr;
    private String sbbh;
    private Date trsj;
    private String szt;
    private Date cdate;
    private Date zfsj;
    private String zffs;
    private Date lcsj;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYwlsh() {
        return ywlsh;
    }

    public void setYwlsh(String ywlsh) {
        this.ywlsh = ywlsh;
    }

    public String getSxzt() {
        return sxzt;
    }

    public void setSxzt(String sxzt) {
        this.sxzt = sxzt;
    }

    public String getSyr() {
        return syr;
    }

    public void setSyr(String syr) {
        this.syr = syr;
    }

    public String getSbbh() {
        return sbbh;
    }

    public void setSbbh(String sbbh) {
        this.sbbh = sbbh;
    }

    public Date getTrsj() {
        return trsj;
    }

    public void setTrsj(Date trsj) {
        this.trsj = trsj;
    }

    public String getSzt() {
        return szt;
    }

    public void setSzt(String szt) {
        this.szt = szt;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public Date getZfsj() {
        return zfsj;
    }

    public void setZfsj(Date zfsj) {
        this.zfsj = zfsj;
    }

    public String getZffs() {
        return zffs;
    }

    public void setZffs(String zffs) {
        this.zffs = zffs;
    }

    public Date getLcsj() {
        return lcsj;
    }

    public void setLcsj(Date lcsj) {
        this.lcsj = lcsj;
    }

    @Override
    public String toString() {
        return "YwJyJl{" +
                "id='" + id + '\'' +
                ", ywlsh='" + ywlsh + '\'' +
                ", sxzt='" + sxzt + '\'' +
                ", syr='" + syr + '\'' +
                ", sbbh='" + sbbh + '\'' +
                ", trsj=" + trsj +
                ", szt='" + szt + '\'' +
                ", cdate=" + cdate +
                ", zfsj=" + zfsj +
                ", zffs='" + zffs + '\'' +
                ", lcsj=" + lcsj +
                '}';
    }
}

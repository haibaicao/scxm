package com.scxm.sqlconfig.bean;

import java.util.Date;

public class SqlInvoke {
    private String id;
    private String sqlxh;
    private String method;
    private String text;
    private String bz;
    private String yxbz;
    private Date gxsj;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSqlxh() {
        return sqlxh;
    }

    public void setSqlxh(String sqlxh) {
        this.sqlxh = sqlxh;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getYxbz() {
        return yxbz;
    }

    public void setYxbz(String yxbz) {
        this.yxbz = yxbz;
    }

    public Date getGxsj() {
        return gxsj;
    }

    public void setGxsj(Date gxsj) {
        this.gxsj = gxsj;
    }

    @Override
    public String toString() {
        return "SqlInvoke{" +
                "id=" + id +
                ", sqlxh='" + sqlxh + '\'' +
                ", method='" + method + '\'' +
                ", text='" + text + '\'' +
                ", bz='" + bz + '\'' +
                ", yxbz='" + yxbz + '\'' +
                ", gxsj=" + gxsj +
                '}';
    }
}

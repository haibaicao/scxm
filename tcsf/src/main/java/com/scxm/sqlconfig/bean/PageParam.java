package com.scxm.sqlconfig.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.session.RowBounds;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageParam {
    private String sqlxh;//sql序号
    private int pageIndex=1;//页号
    private int pageSize=50;//每页记录条数
    private int total;//总记录数，如果当次查询需要获取总记录数，查询时会取count返回；如果不获取就原样返回
    private Boolean doTotal;//是否在查询时获取总记录数
    private String queryParams;//查询条件。该参数是json串，格式为[{“name”:”条件名”,”value”:”条件值”,”type”:”string/number/date/arrays”},…]
    private String requester;//请求人标示，为8位字符串
    private String ticket;//请求票根。该参数为私钥串+请求人+时间戳然后进行md5加密成的32为字符串(大写)
    private Long timestamp;//时间戳
    private Object data;//返回JSON列表数据

    public String getResultJson() {
        JSONObject jo = new JSONObject();
        jo.put("total",total);
        jo.put("rows",data);
        return jo.toJSONString();
    }

    public RowBounds getRowBounds(){
        return new RowBounds((pageIndex-1)*pageSize,pageSize);
    }

    public Map<String,Object> getMapParams() {
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("sqlxh",sqlxh);
        paramMap.put("pageIndex",pageIndex);
        paramMap.put("pageSize",pageSize);
        if(queryParams!=null && queryParams.length()>0){
                List<Map<String,Object>> paramList = JSON.parseObject(queryParams, List.class);
                for(Map<String,Object> tmpMap: paramList){
                    String name=(String)tmpMap.get("name");
                    Object value=tmpMap.get("value");
                    String type=(String)tmpMap.get("type");
                    if(type!=null){
                        if(type.equals("string")){
                            paramMap.put(name,value);
                        }else if(type.equals("number")){
                            paramMap.put(name,value);
                        }else if(type.equals("date")){
                            paramMap.put(name,value);
                        }else if(type.equals("boolean")){
                            paramMap.put(name,value);
                        }else if(type.equals("arrays")){//以逗号分隔的字符串
                            String[] strs=value.toString().split(",");
                            paramMap.put(name, Arrays.asList(strs));
                        }
                    }else{
                        paramMap.put(name,value);
                    }
                }
        }
        return paramMap;
    }

    public String getSqlxh() {
        return sqlxh;
    }

    public void setSqlxh(String sqlxh) {
        this.sqlxh = sqlxh;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Boolean getDoTotal() {
        return doTotal;
    }

    public void setDoTotal(Boolean doTotal) {
        this.doTotal = doTotal;
    }

    public String getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(String queryParams) {
        this.queryParams = queryParams;
    }

    public String getRequester() {
        return requester;
    }

    public void setRequester(String requester) {
        this.requester = requester;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PageParam{" +
                "sqlxh='" + sqlxh + '\'' +
                ", pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", total=" + total +
                ", doTotal=" + doTotal +
                ", queryParams='" + queryParams + '\'' +
                ", requester='" + requester + '\'' +
                ", ticket='" + ticket + '\'' +
                ", timestamp=" + timestamp +
                ", data=" + data +
                '}';
    }
}
package com.scxm.sqlconfig.service.imp;


import com.scxm.sqlconfig.bean.CommonResult;
import com.scxm.sqlconfig.bean.PageParam;
import com.scxm.sqlconfig.bean.SqlInvoke;
import com.scxm.sqlconfig.service.SqlInvokeService;
import com.scxm.sqlconfig.util.SqlMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class SqlInvokeServiceImp implements SqlInvokeService {
    @Resource
    private SqlSessionFactory sqlSessionFactory;

    public CommonResult InvokeSql(PageParam param){
        CommonResult<Object> rtn = new CommonResult<>("00", "查询成功", null);
        Long start = System.currentTimeMillis();
        try {
            SqlSession session = sqlSessionFactory.openSession();
            try {
                SqlMapper sqlMapper = new SqlMapper(session);
                boolean flag=true;
                String sql = "";
                String method = "";
                String sqlxh = param.getSqlxh();
                Map<String,Object> params = param.getMapParams();
                if(sqlxh==null || sqlxh.length()==0){
                    flag = false;
                    rtn.setCode("input.sqlxh.null");
                    rtn.setMessge("输入SQL序号不能为空！");
                }
                if(flag){
                    List<SqlInvoke> sqlList=sqlMapper.selectList("SELECT * FROM PT_PZ_SQL_CONFIG WHERE SQLXH=#{sqlxh} AND YXBZ='Y'",params,SqlInvoke.class);
                    if(sqlList==null || sqlList.size()==0){
                        flag = false;
                        rtn.setCode("sqlxh.result.null");
                        rtn.setMessge("sqlxh不存在！");
                    }else if(sqlList.size()>1){
                        flag = false;
                        rtn.setCode("sqlxh.result.more");
                        rtn.setMessge("当前sqlxh库中存在多个，请联系管理员处理！");
                    }
                    if(flag){
                        SqlInvoke sqlInvoke = sqlList.get(0);
                        sql=sqlInvoke.getText();
                        int pageSize = param.getPageSize();
                        int pageIndex = param.getPageIndex();
                        if(pageSize>100000){
                            flag = false;
                            rtn.setCode("input.pageSize.tolarge");
                            rtn.setMessge("输入pageSize必须小于100000！");
                        }else if(pageIndex==0){
                            flag = false;
                            rtn.setCode("input.pageIndex.zero");
                            rtn.setMessge("输入pageIndex最小为1！");
                        }else if(sql!=null && sql.length()>0){
                            if(sql.contains("</")){
                                sql= "<script>"+sql+"</script>";
                            }
                            System.out.println(sql);
                            System.out.println(params);
                            method=sqlInvoke.getMethod();
                            if(method==null || method.length()==0){
                                method="select";
                            }
                        }else{
                            flag = false;
                            rtn.setCode("input.sql.null");
                            rtn.setMessge("输入SQL不能为空！");
                        }
                    }
                }
                if(flag){
                    if(method.equals("select")){
                        List<Map<String,Object>> list = sqlMapper.selectList(sql,params,param.getRowBounds());
                        param.setData(list);
                        param.setTotal(list!=null?list.size():0);
                        rtn.setData(param.getResultJson());
                    }else if(method.equals("update")){
                        rtn.setData(sqlMapper.update(sql,params));
                    }else if(method.equals("delete")){
                        rtn.setData(sqlMapper.delete(sql,params));
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
                rtn.setCode("99");
                rtn.setMessge(e.getMessage());
            }finally {
                session.close();
            }
        }catch (Exception e){
            e.printStackTrace();
            rtn.setCode("44");
            rtn.setMessge(e.getMessage());
        }
        rtn.setTime(System.currentTimeMillis()-start);
        return rtn;
    }
}

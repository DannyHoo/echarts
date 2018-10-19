package com.danny.echarts.dao;

import com.alibaba.fastjson.JSON;
import com.danny.echarts.dao.data.BorrowerDO;
import com.danny.echarts.dao.jpa.BorrowerDAO;
import com.danny.echarts.dao.jpa.CommonDAO;
import com.danny.echarts.model.StatisticsResult;
import org.apache.commons.beanutils.ConvertUtils;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Danny
 * @Title: CommonDAOTest
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-10-13 17:47:06
 */
public class CommonDAOTest extends BaseDaoSpringTest {

    @Autowired
    private BorrowerDAO borrowerDAO;
    @Autowired
    private CommonDAO commonDAO;

    @Test
    public void findTest() {

        String sql="select  t1.provinceName as title,count(*) as contractNum from t_loan_open t1,t_asset_project_relation t2\n" +
                "where t1.assetNo=t2.assetNo and t2.projectNo=1 group by t1.provinceName";

        List<Object[]> queryResult= commonDAO.queryBySql(sql);
        List<StatisticsResult> statisticsResultList=convertStatisticsResult(queryResult);
        JSON.toJSONString(statisticsResultList);

    }

    public List<StatisticsResult> convertStatisticsResult(List<Object[]> queryResult){
        List<StatisticsResult> statisticsResultList=new ArrayList<>(queryResult.size());
        for (int i=0;i<queryResult.size();i++){
            Object[] tempObject=queryResult.get(i);
            statisticsResultList.add(new StatisticsResult(String.valueOf(tempObject[0]),Integer.valueOf(tempObject[1].toString())));
        }
        return statisticsResultList;
    }

    public List<?> queryListEntity(String sql, Map<String, Object> params, Class<?> clazz){

        List<Map<String, Object>> result = null;
        if (clazz != null) {
            List<Object>  entityList = convert(clazz, result);
            return entityList;
        }
        return result;
    }

    private List<Object> convert(Class<?> clazz, List<Map<String, Object>> list) {
        List<Object> result;
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        result = new ArrayList<Object>();
        try {
            PropertyDescriptor[] props = Introspector.getBeanInfo(clazz).getPropertyDescriptors();
            for (Map<String, Object> map : list) {
                Object obj = clazz.newInstance();
                for (String key:map.keySet()) {
                    String attrName = key.toLowerCase();
                    for (PropertyDescriptor prop : props) {
                        attrName = removeUnderLine(attrName);
                        if (!attrName.equals(prop.getName())) {
                            continue;
                        }
                        Method method = prop.getWriteMethod();
                        Object value = map.get(key);
                        if (value != null) {
                            value = ConvertUtils.convert(value,prop.getPropertyType());
                        }
                        method.invoke(obj,value);
                    }
                }
                result.add(obj);
            }
        } catch (Exception e) {
            throw new RuntimeException("数据转换错误");
        }
        return result;
    }
    private String removeUnderLine(String attrName) {
        //去掉数据库字段的下划线
        if(attrName.contains("_")) {
            String[] names = attrName.split("_");
            String firstPart = names[0];
            String otherPart = "";
            for (int i = 1; i < names.length; i++) {
                String word = names[i].replaceFirst(names[i].substring(0, 1), names[i].substring(0, 1).toUpperCase());
                otherPart += word;
            }
            attrName = firstPart + otherPart;
        }
        return attrName;
    }

}

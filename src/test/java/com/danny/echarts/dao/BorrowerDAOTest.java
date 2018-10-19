package com.danny.echarts.dao;

import com.alibaba.fastjson.JSON;
import com.danny.echarts.dao.data.BorrowerDO;
import com.danny.echarts.dao.jpa.BorrowerDAO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Danny
 * @Title: BorrowerDAOTest
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-10-13 17:10:37
 */
public class BorrowerDAOTest extends BaseDaoSpringTest {

    @Autowired
    private BorrowerDAO borrowerDAO;

    @Test
    public void findTest() {

        BorrowerDO borrowerDO = borrowerDAO.findOne(1L);
        System.out.println(JSON.toJSONString(borrowerDO));

    }
}

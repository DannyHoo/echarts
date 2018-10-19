package com.danny.echarts.dao.jpa;

import com.danny.echarts.dao.data.LoanOpenDO;
import com.danny.echarts.dao.jpa.base.BaseDao;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Danny
 * @Title: BorrowerDAO
 * @Description:
 * @Created on 2017-02-18 14:54:43
 */
public interface LoanOpenDAO extends BaseDao<LoanOpenDO>,PagingAndSortingRepository<LoanOpenDO, Long> {

}

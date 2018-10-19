package com.danny.echarts.dao.jpa;

import com.danny.echarts.dao.data.AssetProjectRelationDO;
import com.danny.echarts.dao.data.BorrowerDO;
import com.danny.echarts.dao.jpa.base.BaseDao;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Danny
 * @Title: BorrowerDAO
 * @Description:
 * @Created on 2017-02-18 14:54:43
 */
public interface AssetProjectRelationDAO extends BaseDao<AssetProjectRelationDO>,PagingAndSortingRepository<AssetProjectRelationDO, Long> {

}

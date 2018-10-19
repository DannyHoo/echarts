package com.danny.echarts.dao.jpa.base;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author Danny
 * @Title: BaseDao
 * @Description:
 * @Created on 2017-03-12 14:41:17
 */
@NoRepositoryBean
public interface BaseDao<T> extends PagingAndSortingRepository<T,Long>{

    int update(T t);

    void batchInsert(List<T> list);

    void batchUpdate(List<T> list);

    List queryBySql(String sql);
}

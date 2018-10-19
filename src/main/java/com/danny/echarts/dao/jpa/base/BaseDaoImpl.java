package com.danny.echarts.dao.jpa.base;

import com.alibaba.fastjson.JSON;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * @author Danny
 * @Title: BaseDaoImpl
 * @Description:
 * @Created on 2017-03-12 14:41:56
 */
public class BaseDaoImpl<T> extends SimpleJpaRepository<T, Long> implements BaseDao<T> {

    protected EntityManager entityManager;

    public BaseDaoImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    public BaseDaoImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager = entityManager;
    }


    @Override
    public int update(T t) {
        T result = entityManager.merge(t);
        if (result != null) {
            entityManager.flush();
            entityManager.clear();
            return 1;
        }
        return 0;
    }

    @Override
    public List queryBySql(String sql) {
        //执行原生SQL
        Query nativeQuery = entityManager.createNativeQuery(sql);
        //指定返回对象类型
        //nativeQuery.unwrap(SQLQuery.class).setResultTransformer(Transformers.aliasToBean(clazz));
        //返回对象
        List resultList = nativeQuery.getResultList();
        return resultList;
    }



    @Override
    public void batchInsert(List list) {
        for (int i = 0; i < list.size(); i++) {
            entityManager.persist(list.get(i));
            System.out.println("insert end:" + JSON.toJSONString(list.get(i)));
            if (i % 30 == 0) {
                entityManager.flush();
                entityManager.clear();
            }
        }
    }

    @Override
    public void batchUpdate(List list) {
        for (int i = 0; i < list.size(); i++) {
            entityManager.merge(list.get(i));
            if (i % 30 == 0) {
                entityManager.flush();
                entityManager.clear();
            }
        }
    }


}

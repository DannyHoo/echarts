package com.danny.echarts.dao.data;


import com.danny.echarts.dao.data.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author Danny
 * @Title: LoanOpenDO
 * @Description:
 * @Created on 2017-03-12 14:04:55
 */
@Entity
@Table(name = "t_borrower")
public class LoanOpenDO extends BaseEntity {
    private String assetNo;
    private String provinceName;

    public String getAssetNo() {
        return assetNo;
    }

    public LoanOpenDO setAssetNo(String assetNo) {
        this.assetNo = assetNo;
        return this;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public LoanOpenDO setProvinceName(String provinceName) {
        this.provinceName = provinceName;
        return this;
    }
}

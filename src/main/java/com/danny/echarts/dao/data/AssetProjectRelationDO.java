package com.danny.echarts.dao.data;


import com.danny.echarts.dao.data.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author Danny
 * @Title: AssetProjectRelationDO
 * @Description:
 * @Created on 2017-03-12 14:04:55
 */
@Entity
@Table(name = "t_asset_project_relation")
public class AssetProjectRelationDO extends BaseEntity {
    private String assetNo;
    private String projectNo;

    public String getAssetNo() {
        return assetNo;
    }

    public AssetProjectRelationDO setAssetNo(String assetNo) {
        this.assetNo = assetNo;
        return this;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public AssetProjectRelationDO setProjectNo(String projectNo) {
        this.projectNo = projectNo;
        return this;
    }
}

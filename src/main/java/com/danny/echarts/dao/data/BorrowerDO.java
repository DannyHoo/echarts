package com.danny.echarts.dao.data;


import com.danny.echarts.dao.data.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author Danny
 * @Title: BorrowerDO
 * @Description:
 * @Created on 2017-03-12 14:04:55
 */
@Entity
@Table(name = "t_borrower")
public class BorrowerDO extends BaseEntity {
    private String assetNo;
    private String realName;
    private String sex;
    private Date birthDate;
    private String profession;
    private String yearIncomeAmt;

    public String getAssetNo() {
        return assetNo;
    }

    public BorrowerDO setAssetNo(String assetNo) {
        this.assetNo = assetNo;
        return this;
    }

    public String getRealName() {
        return realName;
    }

    public BorrowerDO setRealName(String realName) {
        this.realName = realName;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public BorrowerDO setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public BorrowerDO setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public String getProfession() {
        return profession;
    }

    public BorrowerDO setProfession(String profession) {
        this.profession = profession;
        return this;
    }

    public String getYearIncomeAmt() {
        return yearIncomeAmt;
    }

    public BorrowerDO setYearIncomeAmt(String yearIncomeAmt) {
        this.yearIncomeAmt = yearIncomeAmt;
        return this;
    }
}

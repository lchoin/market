package com.jzf.market.pojo.auto;

import java.io.Serializable;
import java.util.Date;

public class TbEarnings implements Serializable {
    private Long eId;

    private String eType;

    private Integer eValue;

    private Date eCreateDate;

    private String eRemark;

    public Long geteId() {
        return eId;
    }

    public void seteId(Long eId) {
        this.eId = eId;
    }

    public String geteType() {
        return eType;
    }

    public void seteType(String eType) {
        this.eType = eType == null ? null : eType.trim();
    }

    public Integer geteValue() {
        return eValue;
    }

    public void seteValue(Integer eValue) {
        this.eValue = eValue;
    }

    public Date geteCreateDate() {
        return eCreateDate;
    }

    public void seteCreateDate(Date eCreateDate) {
        this.eCreateDate = eCreateDate;
    }

    public String geteRemark() {
        return eRemark;
    }

    public void seteRemark(String eRemark) {
        this.eRemark = eRemark == null ? null : eRemark.trim();
    }
}
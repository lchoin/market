package com.jzf.market.pojo.auto;

import java.io.Serializable;
import java.util.Date;

public class TbAuthentication implements Serializable{
    private Long aId;

    private Long aUId;

    private String aRealName;

    private String aIdentityCard;

    private String aIdentityCardPicture;

    private Date aCreateDate;

    private String aRemark;

    public Long getaId() {
        return aId;
    }

    public void setaId(Long aId) {
        this.aId = aId;
    }

    public Long getaUId() {
        return aUId;
    }

    public void setaUId(Long aUId) {
        this.aUId = aUId;
    }

    public String getaRealName() {
        return aRealName;
    }

    public void setaRealName(String aRealName) {
        this.aRealName = aRealName == null ? null : aRealName.trim();
    }

    public String getaIdentityCard() {
        return aIdentityCard;
    }

    public void setaIdentityCard(String aIdentityCard) {
        this.aIdentityCard = aIdentityCard == null ? null : aIdentityCard.trim();
    }

    public String getaIdentityCardPicture() {
        return aIdentityCardPicture;
    }

    public void setaIdentityCardPicture(String aIdentityCardPicture) {
        this.aIdentityCardPicture = aIdentityCardPicture == null ? null : aIdentityCardPicture.trim();
    }

    public Date getaCreateDate() {
        return aCreateDate;
    }

    public void setaCreateDate(Date aCreateDate) {
        this.aCreateDate = aCreateDate;
    }

    public String getaRemark() {
        return aRemark;
    }

    public void setaRemark(String aRemark) {
        this.aRemark = aRemark == null ? null : aRemark.trim();
    }
}
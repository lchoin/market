package com.jzf.market.pojo.auto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbGoods implements Serializable {
    private Long gId;

    private String gName;

    private String gPicture;

    private BigDecimal gPrice;

    private BigDecimal gFreight;

    private Long gQuantity;

    private Long gMonthSales;

    private Long gInventory;

    private String gDetails;

    private Date gCreateDate;

    private Date gUpdateDate;

    private String gRemark;

    public Long getgId() {
        return gId;
    }

    public void setgId(Long gId) {
        this.gId = gId;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName == null ? null : gName.trim();
    }

    public String getgPicture() {
        return gPicture;
    }

    public void setgPicture(String gPicture) {
        this.gPicture = gPicture == null ? null : gPicture.trim();
    }

    public BigDecimal getgPrice() {
        return gPrice;
    }

    public void setgPrice(BigDecimal gPrice) {
        this.gPrice = gPrice;
    }

    public BigDecimal getgFreight() {
        return gFreight;
    }

    public void setgFreight(BigDecimal gFreight) {
        this.gFreight = gFreight;
    }

    public Long getgQuantity() {
        return gQuantity;
    }

    public void setgQuantity(Long gQuantity) {
        this.gQuantity = gQuantity;
    }

    public Long getgMonthSales() {
        return gMonthSales;
    }

    public void setgMonthSales(Long gMonthSales) {
        this.gMonthSales = gMonthSales;
    }

    public Long getgInventory() {
        return gInventory;
    }

    public void setgInventory(Long gInventory) {
        this.gInventory = gInventory;
    }

    public String getgDetails() {
        return gDetails;
    }

    public void setgDetails(String gDetails) {
        this.gDetails = gDetails == null ? null : gDetails.trim();
    }

    public Date getgCreateDate() {
        return gCreateDate;
    }

    public void setgCreateDate(Date gCreateDate) {
        this.gCreateDate = gCreateDate;
    }

    public Date getgUpdateDate() {
        return gUpdateDate;
    }

    public void setgUpdateDate(Date gUpdateDate) {
        this.gUpdateDate = gUpdateDate;
    }

    public String getgRemark() {
        return gRemark;
    }

    public void setgRemark(String gRemark) {
        this.gRemark = gRemark == null ? null : gRemark.trim();
    }
}
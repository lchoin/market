package com.jzf.market.pojo.auto;

import java.io.Serializable;
import java.util.Date;

public class TbPersonIndent implements Serializable {
    private String piId;

    private Long piGId;

    private Long piUId;

    private Long daId;

    private String daPhone;

    private String daDetailAddress;

    private String piEvaluateLanguage;

    private String piEvaluateGrade;

    private String piStatus;

    private Date piCreateDate;

    private Date piShipmentsDate;

    private Date piArrivalDate;

    private Integer piQuantity;

    private String piTrackingNumber;

    private String piCarrierCode;

    public String getPiId() {
        return piId;
    }

    public void setPiId(String piId) {
        this.piId = piId == null ? null : piId.trim();
    }

    public Long getPiGId() {
        return piGId;
    }

    public void setPiGId(Long piGId) {
        this.piGId = piGId;
    }

    public Long getPiUId() {
        return piUId;
    }

    public void setPiUId(Long piUId) {
        this.piUId = piUId;
    }

    public Long getDaId() {
        return daId;
    }

    public void setDaId(Long daId) {
        this.daId = daId;
    }

    public String getDaPhone() {
        return daPhone;
    }

    public void setDaPhone(String daPhone) {
        this.daPhone = daPhone == null ? null : daPhone.trim();
    }

    public String getDaDetailAddress() {
        return daDetailAddress;
    }

    public void setDaDetailAddress(String daDetailAddress) {
        this.daDetailAddress = daDetailAddress == null ? null : daDetailAddress.trim();
    }

    public String getPiEvaluateLanguage() {
        return piEvaluateLanguage;
    }

    public void setPiEvaluateLanguage(String piEvaluateLanguage) {
        this.piEvaluateLanguage = piEvaluateLanguage == null ? null : piEvaluateLanguage.trim();
    }

    public String getPiEvaluateGrade() {
        return piEvaluateGrade;
    }

    public void setPiEvaluateGrade(String piEvaluateGrade) {
        this.piEvaluateGrade = piEvaluateGrade == null ? null : piEvaluateGrade.trim();
    }

    public String getPiStatus() {
        return piStatus;
    }

    public void setPiStatus(String piStatus) {
        this.piStatus = piStatus == null ? null : piStatus.trim();
    }

    public Date getPiCreateDate() {
        return piCreateDate;
    }

    public void setPiCreateDate(Date piCreateDate) {
        this.piCreateDate = piCreateDate;
    }

    public Date getPiShipmentsDate() {
        return piShipmentsDate;
    }

    public void setPiShipmentsDate(Date piShipmentsDate) {
        this.piShipmentsDate = piShipmentsDate;
    }

    public Date getPiArrivalDate() {
        return piArrivalDate;
    }

    public void setPiArrivalDate(Date piArrivalDate) {
        this.piArrivalDate = piArrivalDate;
    }

    public Integer getPiQuantity() {
        return piQuantity;
    }

    public void setPiQuantity(Integer piQuantity) {
        this.piQuantity = piQuantity;
    }

    public String getPiTrackingNumber() {
        return piTrackingNumber;
    }

    public void setPiTrackingNumber(String piTrackingNumber) {
        this.piTrackingNumber = piTrackingNumber == null ? null : piTrackingNumber.trim();
    }

    public String getPiCarrierCode() {
        return piCarrierCode;
    }

    public void setPiCarrierCode(String piCarrierCode) {
        this.piCarrierCode = piCarrierCode == null ? null : piCarrierCode.trim();
    }
}
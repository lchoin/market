package com.jzf.market.pojo.auto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbUser implements Serializable {
    private Long uId;

    private String uName;

    private String uAccount;

    private String uPassword;

    private String uPhone;

    private String uAuthentication;

    private String uType;

    private String uSex;

    private String uHeadPortrait;

    private String uProvince;

    private String uCity;

    private String uAddress;

    private Date uCreateDate;

    private Date uAuthDate;

    private String uReisterRecommender;

    private String uReisterRecommenderAccount;

    private BigDecimal uSumMoney;

    private BigDecimal uUsableMoney;

    private Integer uConsumptionNumber;

    private String uRemark;

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName == null ? null : uName.trim();
    }

    public String getuAccount() {
        return uAccount;
    }

    public void setuAccount(String uAccount) {
        this.uAccount = uAccount == null ? null : uAccount.trim();
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword == null ? null : uPassword.trim();
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone == null ? null : uPhone.trim();
    }

    public String getuAuthentication() {
        return uAuthentication;
    }

    public void setuAuthentication(String uAuthentication) {
        this.uAuthentication = uAuthentication == null ? null : uAuthentication.trim();
    }

    public String getuType() {
        return uType;
    }

    public void setuType(String uType) {
        this.uType = uType == null ? null : uType.trim();
    }

    public String getuSex() {
        return uSex;
    }

    public void setuSex(String uSex) {
        this.uSex = uSex == null ? null : uSex.trim();
    }

    public String getuHeadPortrait() {
        return uHeadPortrait;
    }

    public void setuHeadPortrait(String uHeadPortrait) {
        this.uHeadPortrait = uHeadPortrait == null ? null : uHeadPortrait.trim();
    }

    public String getuProvince() {
        return uProvince;
    }

    public void setuProvince(String uProvince) {
        this.uProvince = uProvince == null ? null : uProvince.trim();
    }

    public String getuCity() {
        return uCity;
    }

    public void setuCity(String uCity) {
        this.uCity = uCity == null ? null : uCity.trim();
    }

    public String getuAddress() {
        return uAddress;
    }

    public void setuAddress(String uAddress) {
        this.uAddress = uAddress == null ? null : uAddress.trim();
    }

    public Date getuCreateDate() {
        return uCreateDate;
    }

    public void setuCreateDate(Date uCreateDate) {
        this.uCreateDate = uCreateDate;
    }

    public Date getuAuthDate() {
        return uAuthDate;
    }

    public void setuAuthDate(Date uAuthDate) {
        this.uAuthDate = uAuthDate;
    }

    public String getuReisterRecommender() {
        return uReisterRecommender;
    }

    public void setuReisterRecommender(String uReisterRecommender) {
        this.uReisterRecommender = uReisterRecommender == null ? null : uReisterRecommender.trim();
    }

    public String getuReisterRecommenderAccount() {
        return uReisterRecommenderAccount;
    }

    public void setuReisterRecommenderAccount(String uReisterRecommenderAccount) {
        this.uReisterRecommenderAccount = uReisterRecommenderAccount == null ? null : uReisterRecommenderAccount.trim();
    }

    public BigDecimal getuSumMoney() {
        return uSumMoney;
    }

    public void setuSumMoney(BigDecimal uSumMoney) {
        this.uSumMoney = uSumMoney;
    }

    public BigDecimal getuUsableMoney() {
        return uUsableMoney;
    }

    public void setuUsableMoney(BigDecimal uUsableMoney) {
        this.uUsableMoney = uUsableMoney;
    }

    public Integer getuConsumptionNumber() {
        return uConsumptionNumber;
    }

    public void setuConsumptionNumber(Integer uConsumptionNumber) {
        this.uConsumptionNumber = uConsumptionNumber;
    }

    public String getuRemark() {
        return uRemark;
    }

    public void setuRemark(String uRemark) {
        this.uRemark = uRemark == null ? null : uRemark.trim();
    }
}
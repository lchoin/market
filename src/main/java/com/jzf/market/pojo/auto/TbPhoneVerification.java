package com.jzf.market.pojo.auto;

import java.io.Serializable;
import java.util.Date;

public class TbPhoneVerification implements Serializable {
    private Long pvId;

    private String pvPhone;

    private String pvVerificationCode;

    private Date pvCreateDate;

    public Long getPvId() {
        return pvId;
    }

    public void setPvId(Long pvId) {
        this.pvId = pvId;
    }

    public String getPvPhone() {
        return pvPhone;
    }

    public void setPvPhone(String pvPhone) {
        this.pvPhone = pvPhone == null ? null : pvPhone.trim();
    }

    public String getPvVerificationCode() {
        return pvVerificationCode;
    }

    public void setPvVerificationCode(String pvVerificationCode) {
        this.pvVerificationCode = pvVerificationCode == null ? null : pvVerificationCode.trim();
    }

    public Date getPvCreateDate() {
        return pvCreateDate;
    }

    public void setPvCreateDate(Date pvCreateDate) {
        this.pvCreateDate = pvCreateDate;
    }
}
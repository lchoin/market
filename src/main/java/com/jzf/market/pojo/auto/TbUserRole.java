package com.jzf.market.pojo.auto;

import java.io.Serializable;

public class TbUserRole implements Serializable {
    private Long urId;

    private Long urRId;

    private Long urUId;

    public Long getUrId() {
        return urId;
    }

    public void setUrId(Long urId) {
        this.urId = urId;
    }

    public Long getUrRId() {
        return urRId;
    }

    public void setUrRId(Long urRId) {
        this.urRId = urRId;
    }

    public Long getUrUId() {
        return urUId;
    }

    public void setUrUId(Long urUId) {
        this.urUId = urUId;
    }
}
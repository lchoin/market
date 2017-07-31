package com.jzf.market.pojo.auto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbGoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbGoodsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andGIdIsNull() {
            addCriterion("g_id is null");
            return (Criteria) this;
        }

        public Criteria andGIdIsNotNull() {
            addCriterion("g_id is not null");
            return (Criteria) this;
        }

        public Criteria andGIdEqualTo(Long value) {
            addCriterion("g_id =", value, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdNotEqualTo(Long value) {
            addCriterion("g_id <>", value, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdGreaterThan(Long value) {
            addCriterion("g_id >", value, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdGreaterThanOrEqualTo(Long value) {
            addCriterion("g_id >=", value, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdLessThan(Long value) {
            addCriterion("g_id <", value, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdLessThanOrEqualTo(Long value) {
            addCriterion("g_id <=", value, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdIn(List<Long> values) {
            addCriterion("g_id in", values, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdNotIn(List<Long> values) {
            addCriterion("g_id not in", values, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdBetween(Long value1, Long value2) {
            addCriterion("g_id between", value1, value2, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdNotBetween(Long value1, Long value2) {
            addCriterion("g_id not between", value1, value2, "gId");
            return (Criteria) this;
        }

        public Criteria andGNameIsNull() {
            addCriterion("g_name is null");
            return (Criteria) this;
        }

        public Criteria andGNameIsNotNull() {
            addCriterion("g_name is not null");
            return (Criteria) this;
        }

        public Criteria andGNameEqualTo(String value) {
            addCriterion("g_name =", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameNotEqualTo(String value) {
            addCriterion("g_name <>", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameGreaterThan(String value) {
            addCriterion("g_name >", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameGreaterThanOrEqualTo(String value) {
            addCriterion("g_name >=", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameLessThan(String value) {
            addCriterion("g_name <", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameLessThanOrEqualTo(String value) {
            addCriterion("g_name <=", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameLike(String value) {
            addCriterion("g_name like", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameNotLike(String value) {
            addCriterion("g_name not like", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameIn(List<String> values) {
            addCriterion("g_name in", values, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameNotIn(List<String> values) {
            addCriterion("g_name not in", values, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameBetween(String value1, String value2) {
            addCriterion("g_name between", value1, value2, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameNotBetween(String value1, String value2) {
            addCriterion("g_name not between", value1, value2, "gName");
            return (Criteria) this;
        }

        public Criteria andGPictureIsNull() {
            addCriterion("g_picture is null");
            return (Criteria) this;
        }

        public Criteria andGPictureIsNotNull() {
            addCriterion("g_picture is not null");
            return (Criteria) this;
        }

        public Criteria andGPictureEqualTo(String value) {
            addCriterion("g_picture =", value, "gPicture");
            return (Criteria) this;
        }

        public Criteria andGPictureNotEqualTo(String value) {
            addCriterion("g_picture <>", value, "gPicture");
            return (Criteria) this;
        }

        public Criteria andGPictureGreaterThan(String value) {
            addCriterion("g_picture >", value, "gPicture");
            return (Criteria) this;
        }

        public Criteria andGPictureGreaterThanOrEqualTo(String value) {
            addCriterion("g_picture >=", value, "gPicture");
            return (Criteria) this;
        }

        public Criteria andGPictureLessThan(String value) {
            addCriterion("g_picture <", value, "gPicture");
            return (Criteria) this;
        }

        public Criteria andGPictureLessThanOrEqualTo(String value) {
            addCriterion("g_picture <=", value, "gPicture");
            return (Criteria) this;
        }

        public Criteria andGPictureLike(String value) {
            addCriterion("g_picture like", value, "gPicture");
            return (Criteria) this;
        }

        public Criteria andGPictureNotLike(String value) {
            addCriterion("g_picture not like", value, "gPicture");
            return (Criteria) this;
        }

        public Criteria andGPictureIn(List<String> values) {
            addCriterion("g_picture in", values, "gPicture");
            return (Criteria) this;
        }

        public Criteria andGPictureNotIn(List<String> values) {
            addCriterion("g_picture not in", values, "gPicture");
            return (Criteria) this;
        }

        public Criteria andGPictureBetween(String value1, String value2) {
            addCriterion("g_picture between", value1, value2, "gPicture");
            return (Criteria) this;
        }

        public Criteria andGPictureNotBetween(String value1, String value2) {
            addCriterion("g_picture not between", value1, value2, "gPicture");
            return (Criteria) this;
        }

        public Criteria andGPriceIsNull() {
            addCriterion("g_price is null");
            return (Criteria) this;
        }

        public Criteria andGPriceIsNotNull() {
            addCriterion("g_price is not null");
            return (Criteria) this;
        }

        public Criteria andGPriceEqualTo(BigDecimal value) {
            addCriterion("g_price =", value, "gPrice");
            return (Criteria) this;
        }

        public Criteria andGPriceNotEqualTo(BigDecimal value) {
            addCriterion("g_price <>", value, "gPrice");
            return (Criteria) this;
        }

        public Criteria andGPriceGreaterThan(BigDecimal value) {
            addCriterion("g_price >", value, "gPrice");
            return (Criteria) this;
        }

        public Criteria andGPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("g_price >=", value, "gPrice");
            return (Criteria) this;
        }

        public Criteria andGPriceLessThan(BigDecimal value) {
            addCriterion("g_price <", value, "gPrice");
            return (Criteria) this;
        }

        public Criteria andGPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("g_price <=", value, "gPrice");
            return (Criteria) this;
        }

        public Criteria andGPriceIn(List<BigDecimal> values) {
            addCriterion("g_price in", values, "gPrice");
            return (Criteria) this;
        }

        public Criteria andGPriceNotIn(List<BigDecimal> values) {
            addCriterion("g_price not in", values, "gPrice");
            return (Criteria) this;
        }

        public Criteria andGPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("g_price between", value1, value2, "gPrice");
            return (Criteria) this;
        }

        public Criteria andGPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("g_price not between", value1, value2, "gPrice");
            return (Criteria) this;
        }

        public Criteria andGFreightIsNull() {
            addCriterion("g_freight is null");
            return (Criteria) this;
        }

        public Criteria andGFreightIsNotNull() {
            addCriterion("g_freight is not null");
            return (Criteria) this;
        }

        public Criteria andGFreightEqualTo(BigDecimal value) {
            addCriterion("g_freight =", value, "gFreight");
            return (Criteria) this;
        }

        public Criteria andGFreightNotEqualTo(BigDecimal value) {
            addCriterion("g_freight <>", value, "gFreight");
            return (Criteria) this;
        }

        public Criteria andGFreightGreaterThan(BigDecimal value) {
            addCriterion("g_freight >", value, "gFreight");
            return (Criteria) this;
        }

        public Criteria andGFreightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("g_freight >=", value, "gFreight");
            return (Criteria) this;
        }

        public Criteria andGFreightLessThan(BigDecimal value) {
            addCriterion("g_freight <", value, "gFreight");
            return (Criteria) this;
        }

        public Criteria andGFreightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("g_freight <=", value, "gFreight");
            return (Criteria) this;
        }

        public Criteria andGFreightIn(List<BigDecimal> values) {
            addCriterion("g_freight in", values, "gFreight");
            return (Criteria) this;
        }

        public Criteria andGFreightNotIn(List<BigDecimal> values) {
            addCriterion("g_freight not in", values, "gFreight");
            return (Criteria) this;
        }

        public Criteria andGFreightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("g_freight between", value1, value2, "gFreight");
            return (Criteria) this;
        }

        public Criteria andGFreightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("g_freight not between", value1, value2, "gFreight");
            return (Criteria) this;
        }

        public Criteria andGQuantityIsNull() {
            addCriterion("g_quantity is null");
            return (Criteria) this;
        }

        public Criteria andGQuantityIsNotNull() {
            addCriterion("g_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andGQuantityEqualTo(Long value) {
            addCriterion("g_quantity =", value, "gQuantity");
            return (Criteria) this;
        }

        public Criteria andGQuantityNotEqualTo(Long value) {
            addCriterion("g_quantity <>", value, "gQuantity");
            return (Criteria) this;
        }

        public Criteria andGQuantityGreaterThan(Long value) {
            addCriterion("g_quantity >", value, "gQuantity");
            return (Criteria) this;
        }

        public Criteria andGQuantityGreaterThanOrEqualTo(Long value) {
            addCriterion("g_quantity >=", value, "gQuantity");
            return (Criteria) this;
        }

        public Criteria andGQuantityLessThan(Long value) {
            addCriterion("g_quantity <", value, "gQuantity");
            return (Criteria) this;
        }

        public Criteria andGQuantityLessThanOrEqualTo(Long value) {
            addCriterion("g_quantity <=", value, "gQuantity");
            return (Criteria) this;
        }

        public Criteria andGQuantityIn(List<Long> values) {
            addCriterion("g_quantity in", values, "gQuantity");
            return (Criteria) this;
        }

        public Criteria andGQuantityNotIn(List<Long> values) {
            addCriterion("g_quantity not in", values, "gQuantity");
            return (Criteria) this;
        }

        public Criteria andGQuantityBetween(Long value1, Long value2) {
            addCriterion("g_quantity between", value1, value2, "gQuantity");
            return (Criteria) this;
        }

        public Criteria andGQuantityNotBetween(Long value1, Long value2) {
            addCriterion("g_quantity not between", value1, value2, "gQuantity");
            return (Criteria) this;
        }

        public Criteria andGMonthSalesIsNull() {
            addCriterion("g_month_sales is null");
            return (Criteria) this;
        }

        public Criteria andGMonthSalesIsNotNull() {
            addCriterion("g_month_sales is not null");
            return (Criteria) this;
        }

        public Criteria andGMonthSalesEqualTo(Long value) {
            addCriterion("g_month_sales =", value, "gMonthSales");
            return (Criteria) this;
        }

        public Criteria andGMonthSalesNotEqualTo(Long value) {
            addCriterion("g_month_sales <>", value, "gMonthSales");
            return (Criteria) this;
        }

        public Criteria andGMonthSalesGreaterThan(Long value) {
            addCriterion("g_month_sales >", value, "gMonthSales");
            return (Criteria) this;
        }

        public Criteria andGMonthSalesGreaterThanOrEqualTo(Long value) {
            addCriterion("g_month_sales >=", value, "gMonthSales");
            return (Criteria) this;
        }

        public Criteria andGMonthSalesLessThan(Long value) {
            addCriterion("g_month_sales <", value, "gMonthSales");
            return (Criteria) this;
        }

        public Criteria andGMonthSalesLessThanOrEqualTo(Long value) {
            addCriterion("g_month_sales <=", value, "gMonthSales");
            return (Criteria) this;
        }

        public Criteria andGMonthSalesIn(List<Long> values) {
            addCriterion("g_month_sales in", values, "gMonthSales");
            return (Criteria) this;
        }

        public Criteria andGMonthSalesNotIn(List<Long> values) {
            addCriterion("g_month_sales not in", values, "gMonthSales");
            return (Criteria) this;
        }

        public Criteria andGMonthSalesBetween(Long value1, Long value2) {
            addCriterion("g_month_sales between", value1, value2, "gMonthSales");
            return (Criteria) this;
        }

        public Criteria andGMonthSalesNotBetween(Long value1, Long value2) {
            addCriterion("g_month_sales not between", value1, value2, "gMonthSales");
            return (Criteria) this;
        }

        public Criteria andGInventoryIsNull() {
            addCriterion("g_inventory is null");
            return (Criteria) this;
        }

        public Criteria andGInventoryIsNotNull() {
            addCriterion("g_inventory is not null");
            return (Criteria) this;
        }

        public Criteria andGInventoryEqualTo(Long value) {
            addCriterion("g_inventory =", value, "gInventory");
            return (Criteria) this;
        }

        public Criteria andGInventoryNotEqualTo(Long value) {
            addCriterion("g_inventory <>", value, "gInventory");
            return (Criteria) this;
        }

        public Criteria andGInventoryGreaterThan(Long value) {
            addCriterion("g_inventory >", value, "gInventory");
            return (Criteria) this;
        }

        public Criteria andGInventoryGreaterThanOrEqualTo(Long value) {
            addCriterion("g_inventory >=", value, "gInventory");
            return (Criteria) this;
        }

        public Criteria andGInventoryLessThan(Long value) {
            addCriterion("g_inventory <", value, "gInventory");
            return (Criteria) this;
        }

        public Criteria andGInventoryLessThanOrEqualTo(Long value) {
            addCriterion("g_inventory <=", value, "gInventory");
            return (Criteria) this;
        }

        public Criteria andGInventoryIn(List<Long> values) {
            addCriterion("g_inventory in", values, "gInventory");
            return (Criteria) this;
        }

        public Criteria andGInventoryNotIn(List<Long> values) {
            addCriterion("g_inventory not in", values, "gInventory");
            return (Criteria) this;
        }

        public Criteria andGInventoryBetween(Long value1, Long value2) {
            addCriterion("g_inventory between", value1, value2, "gInventory");
            return (Criteria) this;
        }

        public Criteria andGInventoryNotBetween(Long value1, Long value2) {
            addCriterion("g_inventory not between", value1, value2, "gInventory");
            return (Criteria) this;
        }

        public Criteria andGDetailsIsNull() {
            addCriterion("g_details is null");
            return (Criteria) this;
        }

        public Criteria andGDetailsIsNotNull() {
            addCriterion("g_details is not null");
            return (Criteria) this;
        }

        public Criteria andGDetailsEqualTo(String value) {
            addCriterion("g_details =", value, "gDetails");
            return (Criteria) this;
        }

        public Criteria andGDetailsNotEqualTo(String value) {
            addCriterion("g_details <>", value, "gDetails");
            return (Criteria) this;
        }

        public Criteria andGDetailsGreaterThan(String value) {
            addCriterion("g_details >", value, "gDetails");
            return (Criteria) this;
        }

        public Criteria andGDetailsGreaterThanOrEqualTo(String value) {
            addCriterion("g_details >=", value, "gDetails");
            return (Criteria) this;
        }

        public Criteria andGDetailsLessThan(String value) {
            addCriterion("g_details <", value, "gDetails");
            return (Criteria) this;
        }

        public Criteria andGDetailsLessThanOrEqualTo(String value) {
            addCriterion("g_details <=", value, "gDetails");
            return (Criteria) this;
        }

        public Criteria andGDetailsLike(String value) {
            addCriterion("g_details like", value, "gDetails");
            return (Criteria) this;
        }

        public Criteria andGDetailsNotLike(String value) {
            addCriterion("g_details not like", value, "gDetails");
            return (Criteria) this;
        }

        public Criteria andGDetailsIn(List<String> values) {
            addCriterion("g_details in", values, "gDetails");
            return (Criteria) this;
        }

        public Criteria andGDetailsNotIn(List<String> values) {
            addCriterion("g_details not in", values, "gDetails");
            return (Criteria) this;
        }

        public Criteria andGDetailsBetween(String value1, String value2) {
            addCriterion("g_details between", value1, value2, "gDetails");
            return (Criteria) this;
        }

        public Criteria andGDetailsNotBetween(String value1, String value2) {
            addCriterion("g_details not between", value1, value2, "gDetails");
            return (Criteria) this;
        }

        public Criteria andGCreateDateIsNull() {
            addCriterion("g_create_date is null");
            return (Criteria) this;
        }

        public Criteria andGCreateDateIsNotNull() {
            addCriterion("g_create_date is not null");
            return (Criteria) this;
        }

        public Criteria andGCreateDateEqualTo(Date value) {
            addCriterion("g_create_date =", value, "gCreateDate");
            return (Criteria) this;
        }

        public Criteria andGCreateDateNotEqualTo(Date value) {
            addCriterion("g_create_date <>", value, "gCreateDate");
            return (Criteria) this;
        }

        public Criteria andGCreateDateGreaterThan(Date value) {
            addCriterion("g_create_date >", value, "gCreateDate");
            return (Criteria) this;
        }

        public Criteria andGCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("g_create_date >=", value, "gCreateDate");
            return (Criteria) this;
        }

        public Criteria andGCreateDateLessThan(Date value) {
            addCriterion("g_create_date <", value, "gCreateDate");
            return (Criteria) this;
        }

        public Criteria andGCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("g_create_date <=", value, "gCreateDate");
            return (Criteria) this;
        }

        public Criteria andGCreateDateIn(List<Date> values) {
            addCriterion("g_create_date in", values, "gCreateDate");
            return (Criteria) this;
        }

        public Criteria andGCreateDateNotIn(List<Date> values) {
            addCriterion("g_create_date not in", values, "gCreateDate");
            return (Criteria) this;
        }

        public Criteria andGCreateDateBetween(Date value1, Date value2) {
            addCriterion("g_create_date between", value1, value2, "gCreateDate");
            return (Criteria) this;
        }

        public Criteria andGCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("g_create_date not between", value1, value2, "gCreateDate");
            return (Criteria) this;
        }

        public Criteria andGUpdateDateIsNull() {
            addCriterion("g_update_date is null");
            return (Criteria) this;
        }

        public Criteria andGUpdateDateIsNotNull() {
            addCriterion("g_update_date is not null");
            return (Criteria) this;
        }

        public Criteria andGUpdateDateEqualTo(Date value) {
            addCriterion("g_update_date =", value, "gUpdateDate");
            return (Criteria) this;
        }

        public Criteria andGUpdateDateNotEqualTo(Date value) {
            addCriterion("g_update_date <>", value, "gUpdateDate");
            return (Criteria) this;
        }

        public Criteria andGUpdateDateGreaterThan(Date value) {
            addCriterion("g_update_date >", value, "gUpdateDate");
            return (Criteria) this;
        }

        public Criteria andGUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("g_update_date >=", value, "gUpdateDate");
            return (Criteria) this;
        }

        public Criteria andGUpdateDateLessThan(Date value) {
            addCriterion("g_update_date <", value, "gUpdateDate");
            return (Criteria) this;
        }

        public Criteria andGUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("g_update_date <=", value, "gUpdateDate");
            return (Criteria) this;
        }

        public Criteria andGUpdateDateIn(List<Date> values) {
            addCriterion("g_update_date in", values, "gUpdateDate");
            return (Criteria) this;
        }

        public Criteria andGUpdateDateNotIn(List<Date> values) {
            addCriterion("g_update_date not in", values, "gUpdateDate");
            return (Criteria) this;
        }

        public Criteria andGUpdateDateBetween(Date value1, Date value2) {
            addCriterion("g_update_date between", value1, value2, "gUpdateDate");
            return (Criteria) this;
        }

        public Criteria andGUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("g_update_date not between", value1, value2, "gUpdateDate");
            return (Criteria) this;
        }

        public Criteria andGRemarkIsNull() {
            addCriterion("g_remark is null");
            return (Criteria) this;
        }

        public Criteria andGRemarkIsNotNull() {
            addCriterion("g_remark is not null");
            return (Criteria) this;
        }

        public Criteria andGRemarkEqualTo(String value) {
            addCriterion("g_remark =", value, "gRemark");
            return (Criteria) this;
        }

        public Criteria andGRemarkNotEqualTo(String value) {
            addCriterion("g_remark <>", value, "gRemark");
            return (Criteria) this;
        }

        public Criteria andGRemarkGreaterThan(String value) {
            addCriterion("g_remark >", value, "gRemark");
            return (Criteria) this;
        }

        public Criteria andGRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("g_remark >=", value, "gRemark");
            return (Criteria) this;
        }

        public Criteria andGRemarkLessThan(String value) {
            addCriterion("g_remark <", value, "gRemark");
            return (Criteria) this;
        }

        public Criteria andGRemarkLessThanOrEqualTo(String value) {
            addCriterion("g_remark <=", value, "gRemark");
            return (Criteria) this;
        }

        public Criteria andGRemarkLike(String value) {
            addCriterion("g_remark like", value, "gRemark");
            return (Criteria) this;
        }

        public Criteria andGRemarkNotLike(String value) {
            addCriterion("g_remark not like", value, "gRemark");
            return (Criteria) this;
        }

        public Criteria andGRemarkIn(List<String> values) {
            addCriterion("g_remark in", values, "gRemark");
            return (Criteria) this;
        }

        public Criteria andGRemarkNotIn(List<String> values) {
            addCriterion("g_remark not in", values, "gRemark");
            return (Criteria) this;
        }

        public Criteria andGRemarkBetween(String value1, String value2) {
            addCriterion("g_remark between", value1, value2, "gRemark");
            return (Criteria) this;
        }

        public Criteria andGRemarkNotBetween(String value1, String value2) {
            addCriterion("g_remark not between", value1, value2, "gRemark");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
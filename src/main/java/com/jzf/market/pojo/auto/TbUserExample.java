package com.jzf.market.pojo.auto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbUserExample() {
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

        public Criteria andUIdIsNull() {
            addCriterion("u_id is null");
            return (Criteria) this;
        }

        public Criteria andUIdIsNotNull() {
            addCriterion("u_id is not null");
            return (Criteria) this;
        }

        public Criteria andUIdEqualTo(Long value) {
            addCriterion("u_id =", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotEqualTo(Long value) {
            addCriterion("u_id <>", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThan(Long value) {
            addCriterion("u_id >", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThanOrEqualTo(Long value) {
            addCriterion("u_id >=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThan(Long value) {
            addCriterion("u_id <", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThanOrEqualTo(Long value) {
            addCriterion("u_id <=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdIn(List<Long> values) {
            addCriterion("u_id in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotIn(List<Long> values) {
            addCriterion("u_id not in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdBetween(Long value1, Long value2) {
            addCriterion("u_id between", value1, value2, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotBetween(Long value1, Long value2) {
            addCriterion("u_id not between", value1, value2, "uId");
            return (Criteria) this;
        }

        public Criteria andUNameIsNull() {
            addCriterion("u_name is null");
            return (Criteria) this;
        }

        public Criteria andUNameIsNotNull() {
            addCriterion("u_name is not null");
            return (Criteria) this;
        }

        public Criteria andUNameEqualTo(String value) {
            addCriterion("u_name =", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameNotEqualTo(String value) {
            addCriterion("u_name <>", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameGreaterThan(String value) {
            addCriterion("u_name >", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameGreaterThanOrEqualTo(String value) {
            addCriterion("u_name >=", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameLessThan(String value) {
            addCriterion("u_name <", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameLessThanOrEqualTo(String value) {
            addCriterion("u_name <=", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameLike(String value) {
            addCriterion("u_name like", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameNotLike(String value) {
            addCriterion("u_name not like", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameIn(List<String> values) {
            addCriterion("u_name in", values, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameNotIn(List<String> values) {
            addCriterion("u_name not in", values, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameBetween(String value1, String value2) {
            addCriterion("u_name between", value1, value2, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameNotBetween(String value1, String value2) {
            addCriterion("u_name not between", value1, value2, "uName");
            return (Criteria) this;
        }

        public Criteria andUAccountIsNull() {
            addCriterion("u_account is null");
            return (Criteria) this;
        }

        public Criteria andUAccountIsNotNull() {
            addCriterion("u_account is not null");
            return (Criteria) this;
        }

        public Criteria andUAccountEqualTo(String value) {
            addCriterion("u_account =", value, "uAccount");
            return (Criteria) this;
        }

        public Criteria andUAccountNotEqualTo(String value) {
            addCriterion("u_account <>", value, "uAccount");
            return (Criteria) this;
        }

        public Criteria andUAccountGreaterThan(String value) {
            addCriterion("u_account >", value, "uAccount");
            return (Criteria) this;
        }

        public Criteria andUAccountGreaterThanOrEqualTo(String value) {
            addCriterion("u_account >=", value, "uAccount");
            return (Criteria) this;
        }

        public Criteria andUAccountLessThan(String value) {
            addCriterion("u_account <", value, "uAccount");
            return (Criteria) this;
        }

        public Criteria andUAccountLessThanOrEqualTo(String value) {
            addCriterion("u_account <=", value, "uAccount");
            return (Criteria) this;
        }

        public Criteria andUAccountLike(String value) {
            addCriterion("u_account like", value, "uAccount");
            return (Criteria) this;
        }

        public Criteria andUAccountNotLike(String value) {
            addCriterion("u_account not like", value, "uAccount");
            return (Criteria) this;
        }

        public Criteria andUAccountIn(List<String> values) {
            addCriterion("u_account in", values, "uAccount");
            return (Criteria) this;
        }

        public Criteria andUAccountNotIn(List<String> values) {
            addCriterion("u_account not in", values, "uAccount");
            return (Criteria) this;
        }

        public Criteria andUAccountBetween(String value1, String value2) {
            addCriterion("u_account between", value1, value2, "uAccount");
            return (Criteria) this;
        }

        public Criteria andUAccountNotBetween(String value1, String value2) {
            addCriterion("u_account not between", value1, value2, "uAccount");
            return (Criteria) this;
        }

        public Criteria andUPasswordIsNull() {
            addCriterion("u_password is null");
            return (Criteria) this;
        }

        public Criteria andUPasswordIsNotNull() {
            addCriterion("u_password is not null");
            return (Criteria) this;
        }

        public Criteria andUPasswordEqualTo(String value) {
            addCriterion("u_password =", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordNotEqualTo(String value) {
            addCriterion("u_password <>", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordGreaterThan(String value) {
            addCriterion("u_password >", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("u_password >=", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordLessThan(String value) {
            addCriterion("u_password <", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordLessThanOrEqualTo(String value) {
            addCriterion("u_password <=", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordLike(String value) {
            addCriterion("u_password like", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordNotLike(String value) {
            addCriterion("u_password not like", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordIn(List<String> values) {
            addCriterion("u_password in", values, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordNotIn(List<String> values) {
            addCriterion("u_password not in", values, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordBetween(String value1, String value2) {
            addCriterion("u_password between", value1, value2, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordNotBetween(String value1, String value2) {
            addCriterion("u_password not between", value1, value2, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPhoneIsNull() {
            addCriterion("u_phone is null");
            return (Criteria) this;
        }

        public Criteria andUPhoneIsNotNull() {
            addCriterion("u_phone is not null");
            return (Criteria) this;
        }

        public Criteria andUPhoneEqualTo(String value) {
            addCriterion("u_phone =", value, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneNotEqualTo(String value) {
            addCriterion("u_phone <>", value, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneGreaterThan(String value) {
            addCriterion("u_phone >", value, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("u_phone >=", value, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneLessThan(String value) {
            addCriterion("u_phone <", value, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneLessThanOrEqualTo(String value) {
            addCriterion("u_phone <=", value, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneLike(String value) {
            addCriterion("u_phone like", value, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneNotLike(String value) {
            addCriterion("u_phone not like", value, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneIn(List<String> values) {
            addCriterion("u_phone in", values, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneNotIn(List<String> values) {
            addCriterion("u_phone not in", values, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneBetween(String value1, String value2) {
            addCriterion("u_phone between", value1, value2, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneNotBetween(String value1, String value2) {
            addCriterion("u_phone not between", value1, value2, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUAuthenticationIsNull() {
            addCriterion("u_authentication is null");
            return (Criteria) this;
        }

        public Criteria andUAuthenticationIsNotNull() {
            addCriterion("u_authentication is not null");
            return (Criteria) this;
        }

        public Criteria andUAuthenticationEqualTo(String value) {
            addCriterion("u_authentication =", value, "uAuthentication");
            return (Criteria) this;
        }

        public Criteria andUAuthenticationNotEqualTo(String value) {
            addCriterion("u_authentication <>", value, "uAuthentication");
            return (Criteria) this;
        }

        public Criteria andUAuthenticationGreaterThan(String value) {
            addCriterion("u_authentication >", value, "uAuthentication");
            return (Criteria) this;
        }

        public Criteria andUAuthenticationGreaterThanOrEqualTo(String value) {
            addCriterion("u_authentication >=", value, "uAuthentication");
            return (Criteria) this;
        }

        public Criteria andUAuthenticationLessThan(String value) {
            addCriterion("u_authentication <", value, "uAuthentication");
            return (Criteria) this;
        }

        public Criteria andUAuthenticationLessThanOrEqualTo(String value) {
            addCriterion("u_authentication <=", value, "uAuthentication");
            return (Criteria) this;
        }

        public Criteria andUAuthenticationLike(String value) {
            addCriterion("u_authentication like", value, "uAuthentication");
            return (Criteria) this;
        }

        public Criteria andUAuthenticationNotLike(String value) {
            addCriterion("u_authentication not like", value, "uAuthentication");
            return (Criteria) this;
        }

        public Criteria andUAuthenticationIn(List<String> values) {
            addCriterion("u_authentication in", values, "uAuthentication");
            return (Criteria) this;
        }

        public Criteria andUAuthenticationNotIn(List<String> values) {
            addCriterion("u_authentication not in", values, "uAuthentication");
            return (Criteria) this;
        }

        public Criteria andUAuthenticationBetween(String value1, String value2) {
            addCriterion("u_authentication between", value1, value2, "uAuthentication");
            return (Criteria) this;
        }

        public Criteria andUAuthenticationNotBetween(String value1, String value2) {
            addCriterion("u_authentication not between", value1, value2, "uAuthentication");
            return (Criteria) this;
        }

        public Criteria andUTypeIsNull() {
            addCriterion("u_type is null");
            return (Criteria) this;
        }

        public Criteria andUTypeIsNotNull() {
            addCriterion("u_type is not null");
            return (Criteria) this;
        }

        public Criteria andUTypeEqualTo(String value) {
            addCriterion("u_type =", value, "uType");
            return (Criteria) this;
        }

        public Criteria andUTypeNotEqualTo(String value) {
            addCriterion("u_type <>", value, "uType");
            return (Criteria) this;
        }

        public Criteria andUTypeGreaterThan(String value) {
            addCriterion("u_type >", value, "uType");
            return (Criteria) this;
        }

        public Criteria andUTypeGreaterThanOrEqualTo(String value) {
            addCriterion("u_type >=", value, "uType");
            return (Criteria) this;
        }

        public Criteria andUTypeLessThan(String value) {
            addCriterion("u_type <", value, "uType");
            return (Criteria) this;
        }

        public Criteria andUTypeLessThanOrEqualTo(String value) {
            addCriterion("u_type <=", value, "uType");
            return (Criteria) this;
        }

        public Criteria andUTypeLike(String value) {
            addCriterion("u_type like", value, "uType");
            return (Criteria) this;
        }

        public Criteria andUTypeNotLike(String value) {
            addCriterion("u_type not like", value, "uType");
            return (Criteria) this;
        }

        public Criteria andUTypeIn(List<String> values) {
            addCriterion("u_type in", values, "uType");
            return (Criteria) this;
        }

        public Criteria andUTypeNotIn(List<String> values) {
            addCriterion("u_type not in", values, "uType");
            return (Criteria) this;
        }

        public Criteria andUTypeBetween(String value1, String value2) {
            addCriterion("u_type between", value1, value2, "uType");
            return (Criteria) this;
        }

        public Criteria andUTypeNotBetween(String value1, String value2) {
            addCriterion("u_type not between", value1, value2, "uType");
            return (Criteria) this;
        }

        public Criteria andUSexIsNull() {
            addCriterion("u_sex is null");
            return (Criteria) this;
        }

        public Criteria andUSexIsNotNull() {
            addCriterion("u_sex is not null");
            return (Criteria) this;
        }

        public Criteria andUSexEqualTo(String value) {
            addCriterion("u_sex =", value, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexNotEqualTo(String value) {
            addCriterion("u_sex <>", value, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexGreaterThan(String value) {
            addCriterion("u_sex >", value, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexGreaterThanOrEqualTo(String value) {
            addCriterion("u_sex >=", value, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexLessThan(String value) {
            addCriterion("u_sex <", value, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexLessThanOrEqualTo(String value) {
            addCriterion("u_sex <=", value, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexLike(String value) {
            addCriterion("u_sex like", value, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexNotLike(String value) {
            addCriterion("u_sex not like", value, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexIn(List<String> values) {
            addCriterion("u_sex in", values, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexNotIn(List<String> values) {
            addCriterion("u_sex not in", values, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexBetween(String value1, String value2) {
            addCriterion("u_sex between", value1, value2, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexNotBetween(String value1, String value2) {
            addCriterion("u_sex not between", value1, value2, "uSex");
            return (Criteria) this;
        }

        public Criteria andUHeadPortraitIsNull() {
            addCriterion("u_head_portrait is null");
            return (Criteria) this;
        }

        public Criteria andUHeadPortraitIsNotNull() {
            addCriterion("u_head_portrait is not null");
            return (Criteria) this;
        }

        public Criteria andUHeadPortraitEqualTo(String value) {
            addCriterion("u_head_portrait =", value, "uHeadPortrait");
            return (Criteria) this;
        }

        public Criteria andUHeadPortraitNotEqualTo(String value) {
            addCriterion("u_head_portrait <>", value, "uHeadPortrait");
            return (Criteria) this;
        }

        public Criteria andUHeadPortraitGreaterThan(String value) {
            addCriterion("u_head_portrait >", value, "uHeadPortrait");
            return (Criteria) this;
        }

        public Criteria andUHeadPortraitGreaterThanOrEqualTo(String value) {
            addCriterion("u_head_portrait >=", value, "uHeadPortrait");
            return (Criteria) this;
        }

        public Criteria andUHeadPortraitLessThan(String value) {
            addCriterion("u_head_portrait <", value, "uHeadPortrait");
            return (Criteria) this;
        }

        public Criteria andUHeadPortraitLessThanOrEqualTo(String value) {
            addCriterion("u_head_portrait <=", value, "uHeadPortrait");
            return (Criteria) this;
        }

        public Criteria andUHeadPortraitLike(String value) {
            addCriterion("u_head_portrait like", value, "uHeadPortrait");
            return (Criteria) this;
        }

        public Criteria andUHeadPortraitNotLike(String value) {
            addCriterion("u_head_portrait not like", value, "uHeadPortrait");
            return (Criteria) this;
        }

        public Criteria andUHeadPortraitIn(List<String> values) {
            addCriterion("u_head_portrait in", values, "uHeadPortrait");
            return (Criteria) this;
        }

        public Criteria andUHeadPortraitNotIn(List<String> values) {
            addCriterion("u_head_portrait not in", values, "uHeadPortrait");
            return (Criteria) this;
        }

        public Criteria andUHeadPortraitBetween(String value1, String value2) {
            addCriterion("u_head_portrait between", value1, value2, "uHeadPortrait");
            return (Criteria) this;
        }

        public Criteria andUHeadPortraitNotBetween(String value1, String value2) {
            addCriterion("u_head_portrait not between", value1, value2, "uHeadPortrait");
            return (Criteria) this;
        }

        public Criteria andUProvinceIsNull() {
            addCriterion("u_province is null");
            return (Criteria) this;
        }

        public Criteria andUProvinceIsNotNull() {
            addCriterion("u_province is not null");
            return (Criteria) this;
        }

        public Criteria andUProvinceEqualTo(String value) {
            addCriterion("u_province =", value, "uProvince");
            return (Criteria) this;
        }

        public Criteria andUProvinceNotEqualTo(String value) {
            addCriterion("u_province <>", value, "uProvince");
            return (Criteria) this;
        }

        public Criteria andUProvinceGreaterThan(String value) {
            addCriterion("u_province >", value, "uProvince");
            return (Criteria) this;
        }

        public Criteria andUProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("u_province >=", value, "uProvince");
            return (Criteria) this;
        }

        public Criteria andUProvinceLessThan(String value) {
            addCriterion("u_province <", value, "uProvince");
            return (Criteria) this;
        }

        public Criteria andUProvinceLessThanOrEqualTo(String value) {
            addCriterion("u_province <=", value, "uProvince");
            return (Criteria) this;
        }

        public Criteria andUProvinceLike(String value) {
            addCriterion("u_province like", value, "uProvince");
            return (Criteria) this;
        }

        public Criteria andUProvinceNotLike(String value) {
            addCriterion("u_province not like", value, "uProvince");
            return (Criteria) this;
        }

        public Criteria andUProvinceIn(List<String> values) {
            addCriterion("u_province in", values, "uProvince");
            return (Criteria) this;
        }

        public Criteria andUProvinceNotIn(List<String> values) {
            addCriterion("u_province not in", values, "uProvince");
            return (Criteria) this;
        }

        public Criteria andUProvinceBetween(String value1, String value2) {
            addCriterion("u_province between", value1, value2, "uProvince");
            return (Criteria) this;
        }

        public Criteria andUProvinceNotBetween(String value1, String value2) {
            addCriterion("u_province not between", value1, value2, "uProvince");
            return (Criteria) this;
        }

        public Criteria andUCityIsNull() {
            addCriterion("u_city is null");
            return (Criteria) this;
        }

        public Criteria andUCityIsNotNull() {
            addCriterion("u_city is not null");
            return (Criteria) this;
        }

        public Criteria andUCityEqualTo(String value) {
            addCriterion("u_city =", value, "uCity");
            return (Criteria) this;
        }

        public Criteria andUCityNotEqualTo(String value) {
            addCriterion("u_city <>", value, "uCity");
            return (Criteria) this;
        }

        public Criteria andUCityGreaterThan(String value) {
            addCriterion("u_city >", value, "uCity");
            return (Criteria) this;
        }

        public Criteria andUCityGreaterThanOrEqualTo(String value) {
            addCriterion("u_city >=", value, "uCity");
            return (Criteria) this;
        }

        public Criteria andUCityLessThan(String value) {
            addCriterion("u_city <", value, "uCity");
            return (Criteria) this;
        }

        public Criteria andUCityLessThanOrEqualTo(String value) {
            addCriterion("u_city <=", value, "uCity");
            return (Criteria) this;
        }

        public Criteria andUCityLike(String value) {
            addCriterion("u_city like", value, "uCity");
            return (Criteria) this;
        }

        public Criteria andUCityNotLike(String value) {
            addCriterion("u_city not like", value, "uCity");
            return (Criteria) this;
        }

        public Criteria andUCityIn(List<String> values) {
            addCriterion("u_city in", values, "uCity");
            return (Criteria) this;
        }

        public Criteria andUCityNotIn(List<String> values) {
            addCriterion("u_city not in", values, "uCity");
            return (Criteria) this;
        }

        public Criteria andUCityBetween(String value1, String value2) {
            addCriterion("u_city between", value1, value2, "uCity");
            return (Criteria) this;
        }

        public Criteria andUCityNotBetween(String value1, String value2) {
            addCriterion("u_city not between", value1, value2, "uCity");
            return (Criteria) this;
        }

        public Criteria andUAddressIsNull() {
            addCriterion("u_address is null");
            return (Criteria) this;
        }

        public Criteria andUAddressIsNotNull() {
            addCriterion("u_address is not null");
            return (Criteria) this;
        }

        public Criteria andUAddressEqualTo(String value) {
            addCriterion("u_address =", value, "uAddress");
            return (Criteria) this;
        }

        public Criteria andUAddressNotEqualTo(String value) {
            addCriterion("u_address <>", value, "uAddress");
            return (Criteria) this;
        }

        public Criteria andUAddressGreaterThan(String value) {
            addCriterion("u_address >", value, "uAddress");
            return (Criteria) this;
        }

        public Criteria andUAddressGreaterThanOrEqualTo(String value) {
            addCriterion("u_address >=", value, "uAddress");
            return (Criteria) this;
        }

        public Criteria andUAddressLessThan(String value) {
            addCriterion("u_address <", value, "uAddress");
            return (Criteria) this;
        }

        public Criteria andUAddressLessThanOrEqualTo(String value) {
            addCriterion("u_address <=", value, "uAddress");
            return (Criteria) this;
        }

        public Criteria andUAddressLike(String value) {
            addCriterion("u_address like", value, "uAddress");
            return (Criteria) this;
        }

        public Criteria andUAddressNotLike(String value) {
            addCriterion("u_address not like", value, "uAddress");
            return (Criteria) this;
        }

        public Criteria andUAddressIn(List<String> values) {
            addCriterion("u_address in", values, "uAddress");
            return (Criteria) this;
        }

        public Criteria andUAddressNotIn(List<String> values) {
            addCriterion("u_address not in", values, "uAddress");
            return (Criteria) this;
        }

        public Criteria andUAddressBetween(String value1, String value2) {
            addCriterion("u_address between", value1, value2, "uAddress");
            return (Criteria) this;
        }

        public Criteria andUAddressNotBetween(String value1, String value2) {
            addCriterion("u_address not between", value1, value2, "uAddress");
            return (Criteria) this;
        }

        public Criteria andUCreateDateIsNull() {
            addCriterion("u_create_date is null");
            return (Criteria) this;
        }

        public Criteria andUCreateDateIsNotNull() {
            addCriterion("u_create_date is not null");
            return (Criteria) this;
        }

        public Criteria andUCreateDateEqualTo(Date value) {
            addCriterion("u_create_date =", value, "uCreateDate");
            return (Criteria) this;
        }

        public Criteria andUCreateDateNotEqualTo(Date value) {
            addCriterion("u_create_date <>", value, "uCreateDate");
            return (Criteria) this;
        }

        public Criteria andUCreateDateGreaterThan(Date value) {
            addCriterion("u_create_date >", value, "uCreateDate");
            return (Criteria) this;
        }

        public Criteria andUCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("u_create_date >=", value, "uCreateDate");
            return (Criteria) this;
        }

        public Criteria andUCreateDateLessThan(Date value) {
            addCriterion("u_create_date <", value, "uCreateDate");
            return (Criteria) this;
        }

        public Criteria andUCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("u_create_date <=", value, "uCreateDate");
            return (Criteria) this;
        }

        public Criteria andUCreateDateIn(List<Date> values) {
            addCriterion("u_create_date in", values, "uCreateDate");
            return (Criteria) this;
        }

        public Criteria andUCreateDateNotIn(List<Date> values) {
            addCriterion("u_create_date not in", values, "uCreateDate");
            return (Criteria) this;
        }

        public Criteria andUCreateDateBetween(Date value1, Date value2) {
            addCriterion("u_create_date between", value1, value2, "uCreateDate");
            return (Criteria) this;
        }

        public Criteria andUCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("u_create_date not between", value1, value2, "uCreateDate");
            return (Criteria) this;
        }

        public Criteria andUAuthDateIsNull() {
            addCriterion("u_auth_date is null");
            return (Criteria) this;
        }

        public Criteria andUAuthDateIsNotNull() {
            addCriterion("u_auth_date is not null");
            return (Criteria) this;
        }

        public Criteria andUAuthDateEqualTo(Date value) {
            addCriterion("u_auth_date =", value, "uAuthDate");
            return (Criteria) this;
        }

        public Criteria andUAuthDateNotEqualTo(Date value) {
            addCriterion("u_auth_date <>", value, "uAuthDate");
            return (Criteria) this;
        }

        public Criteria andUAuthDateGreaterThan(Date value) {
            addCriterion("u_auth_date >", value, "uAuthDate");
            return (Criteria) this;
        }

        public Criteria andUAuthDateGreaterThanOrEqualTo(Date value) {
            addCriterion("u_auth_date >=", value, "uAuthDate");
            return (Criteria) this;
        }

        public Criteria andUAuthDateLessThan(Date value) {
            addCriterion("u_auth_date <", value, "uAuthDate");
            return (Criteria) this;
        }

        public Criteria andUAuthDateLessThanOrEqualTo(Date value) {
            addCriterion("u_auth_date <=", value, "uAuthDate");
            return (Criteria) this;
        }

        public Criteria andUAuthDateIn(List<Date> values) {
            addCriterion("u_auth_date in", values, "uAuthDate");
            return (Criteria) this;
        }

        public Criteria andUAuthDateNotIn(List<Date> values) {
            addCriterion("u_auth_date not in", values, "uAuthDate");
            return (Criteria) this;
        }

        public Criteria andUAuthDateBetween(Date value1, Date value2) {
            addCriterion("u_auth_date between", value1, value2, "uAuthDate");
            return (Criteria) this;
        }

        public Criteria andUAuthDateNotBetween(Date value1, Date value2) {
            addCriterion("u_auth_date not between", value1, value2, "uAuthDate");
            return (Criteria) this;
        }

        public Criteria andUReisterRecommenderIsNull() {
            addCriterion("u_reister_recommender is null");
            return (Criteria) this;
        }

        public Criteria andUReisterRecommenderIsNotNull() {
            addCriterion("u_reister_recommender is not null");
            return (Criteria) this;
        }

        public Criteria andUReisterRecommenderEqualTo(String value) {
            addCriterion("u_reister_recommender =", value, "uReisterRecommender");
            return (Criteria) this;
        }

        public Criteria andUReisterRecommenderNotEqualTo(String value) {
            addCriterion("u_reister_recommender <>", value, "uReisterRecommender");
            return (Criteria) this;
        }

        public Criteria andUReisterRecommenderGreaterThan(String value) {
            addCriterion("u_reister_recommender >", value, "uReisterRecommender");
            return (Criteria) this;
        }

        public Criteria andUReisterRecommenderGreaterThanOrEqualTo(String value) {
            addCriterion("u_reister_recommender >=", value, "uReisterRecommender");
            return (Criteria) this;
        }

        public Criteria andUReisterRecommenderLessThan(String value) {
            addCriterion("u_reister_recommender <", value, "uReisterRecommender");
            return (Criteria) this;
        }

        public Criteria andUReisterRecommenderLessThanOrEqualTo(String value) {
            addCriterion("u_reister_recommender <=", value, "uReisterRecommender");
            return (Criteria) this;
        }

        public Criteria andUReisterRecommenderLike(String value) {
            addCriterion("u_reister_recommender like", value, "uReisterRecommender");
            return (Criteria) this;
        }

        public Criteria andUReisterRecommenderNotLike(String value) {
            addCriterion("u_reister_recommender not like", value, "uReisterRecommender");
            return (Criteria) this;
        }

        public Criteria andUReisterRecommenderIn(List<String> values) {
            addCriterion("u_reister_recommender in", values, "uReisterRecommender");
            return (Criteria) this;
        }

        public Criteria andUReisterRecommenderNotIn(List<String> values) {
            addCriterion("u_reister_recommender not in", values, "uReisterRecommender");
            return (Criteria) this;
        }

        public Criteria andUReisterRecommenderBetween(String value1, String value2) {
            addCriterion("u_reister_recommender between", value1, value2, "uReisterRecommender");
            return (Criteria) this;
        }

        public Criteria andUReisterRecommenderNotBetween(String value1, String value2) {
            addCriterion("u_reister_recommender not between", value1, value2, "uReisterRecommender");
            return (Criteria) this;
        }

        public Criteria andUReisterRecommenderAccountIsNull() {
            addCriterion("u_reister_recommender_account is null");
            return (Criteria) this;
        }

        public Criteria andUReisterRecommenderAccountIsNotNull() {
            addCriterion("u_reister_recommender_account is not null");
            return (Criteria) this;
        }

        public Criteria andUReisterRecommenderAccountEqualTo(String value) {
            addCriterion("u_reister_recommender_account =", value, "uReisterRecommenderAccount");
            return (Criteria) this;
        }

        public Criteria andUReisterRecommenderAccountNotEqualTo(String value) {
            addCriterion("u_reister_recommender_account <>", value, "uReisterRecommenderAccount");
            return (Criteria) this;
        }

        public Criteria andUReisterRecommenderAccountGreaterThan(String value) {
            addCriterion("u_reister_recommender_account >", value, "uReisterRecommenderAccount");
            return (Criteria) this;
        }

        public Criteria andUReisterRecommenderAccountGreaterThanOrEqualTo(String value) {
            addCriterion("u_reister_recommender_account >=", value, "uReisterRecommenderAccount");
            return (Criteria) this;
        }

        public Criteria andUReisterRecommenderAccountLessThan(String value) {
            addCriterion("u_reister_recommender_account <", value, "uReisterRecommenderAccount");
            return (Criteria) this;
        }

        public Criteria andUReisterRecommenderAccountLessThanOrEqualTo(String value) {
            addCriterion("u_reister_recommender_account <=", value, "uReisterRecommenderAccount");
            return (Criteria) this;
        }

        public Criteria andUReisterRecommenderAccountLike(String value) {
            addCriterion("u_reister_recommender_account like", value, "uReisterRecommenderAccount");
            return (Criteria) this;
        }

        public Criteria andUReisterRecommenderAccountNotLike(String value) {
            addCriterion("u_reister_recommender_account not like", value, "uReisterRecommenderAccount");
            return (Criteria) this;
        }

        public Criteria andUReisterRecommenderAccountIn(List<String> values) {
            addCriterion("u_reister_recommender_account in", values, "uReisterRecommenderAccount");
            return (Criteria) this;
        }

        public Criteria andUReisterRecommenderAccountNotIn(List<String> values) {
            addCriterion("u_reister_recommender_account not in", values, "uReisterRecommenderAccount");
            return (Criteria) this;
        }

        public Criteria andUReisterRecommenderAccountBetween(String value1, String value2) {
            addCriterion("u_reister_recommender_account between", value1, value2, "uReisterRecommenderAccount");
            return (Criteria) this;
        }

        public Criteria andUReisterRecommenderAccountNotBetween(String value1, String value2) {
            addCriterion("u_reister_recommender_account not between", value1, value2, "uReisterRecommenderAccount");
            return (Criteria) this;
        }

        public Criteria andUSumMoneyIsNull() {
            addCriterion("u_sum_money is null");
            return (Criteria) this;
        }

        public Criteria andUSumMoneyIsNotNull() {
            addCriterion("u_sum_money is not null");
            return (Criteria) this;
        }

        public Criteria andUSumMoneyEqualTo(BigDecimal value) {
            addCriterion("u_sum_money =", value, "uSumMoney");
            return (Criteria) this;
        }

        public Criteria andUSumMoneyNotEqualTo(BigDecimal value) {
            addCriterion("u_sum_money <>", value, "uSumMoney");
            return (Criteria) this;
        }

        public Criteria andUSumMoneyGreaterThan(BigDecimal value) {
            addCriterion("u_sum_money >", value, "uSumMoney");
            return (Criteria) this;
        }

        public Criteria andUSumMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("u_sum_money >=", value, "uSumMoney");
            return (Criteria) this;
        }

        public Criteria andUSumMoneyLessThan(BigDecimal value) {
            addCriterion("u_sum_money <", value, "uSumMoney");
            return (Criteria) this;
        }

        public Criteria andUSumMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("u_sum_money <=", value, "uSumMoney");
            return (Criteria) this;
        }

        public Criteria andUSumMoneyIn(List<BigDecimal> values) {
            addCriterion("u_sum_money in", values, "uSumMoney");
            return (Criteria) this;
        }

        public Criteria andUSumMoneyNotIn(List<BigDecimal> values) {
            addCriterion("u_sum_money not in", values, "uSumMoney");
            return (Criteria) this;
        }

        public Criteria andUSumMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("u_sum_money between", value1, value2, "uSumMoney");
            return (Criteria) this;
        }

        public Criteria andUSumMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("u_sum_money not between", value1, value2, "uSumMoney");
            return (Criteria) this;
        }

        public Criteria andUUsableMoneyIsNull() {
            addCriterion("u_usable_money is null");
            return (Criteria) this;
        }

        public Criteria andUUsableMoneyIsNotNull() {
            addCriterion("u_usable_money is not null");
            return (Criteria) this;
        }

        public Criteria andUUsableMoneyEqualTo(BigDecimal value) {
            addCriterion("u_usable_money =", value, "uUsableMoney");
            return (Criteria) this;
        }

        public Criteria andUUsableMoneyNotEqualTo(BigDecimal value) {
            addCriterion("u_usable_money <>", value, "uUsableMoney");
            return (Criteria) this;
        }

        public Criteria andUUsableMoneyGreaterThan(BigDecimal value) {
            addCriterion("u_usable_money >", value, "uUsableMoney");
            return (Criteria) this;
        }

        public Criteria andUUsableMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("u_usable_money >=", value, "uUsableMoney");
            return (Criteria) this;
        }

        public Criteria andUUsableMoneyLessThan(BigDecimal value) {
            addCriterion("u_usable_money <", value, "uUsableMoney");
            return (Criteria) this;
        }

        public Criteria andUUsableMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("u_usable_money <=", value, "uUsableMoney");
            return (Criteria) this;
        }

        public Criteria andUUsableMoneyIn(List<BigDecimal> values) {
            addCriterion("u_usable_money in", values, "uUsableMoney");
            return (Criteria) this;
        }

        public Criteria andUUsableMoneyNotIn(List<BigDecimal> values) {
            addCriterion("u_usable_money not in", values, "uUsableMoney");
            return (Criteria) this;
        }

        public Criteria andUUsableMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("u_usable_money between", value1, value2, "uUsableMoney");
            return (Criteria) this;
        }

        public Criteria andUUsableMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("u_usable_money not between", value1, value2, "uUsableMoney");
            return (Criteria) this;
        }

        public Criteria andUConsumptionNumberIsNull() {
            addCriterion("u_consumption_number is null");
            return (Criteria) this;
        }

        public Criteria andUConsumptionNumberIsNotNull() {
            addCriterion("u_consumption_number is not null");
            return (Criteria) this;
        }

        public Criteria andUConsumptionNumberEqualTo(Integer value) {
            addCriterion("u_consumption_number =", value, "uConsumptionNumber");
            return (Criteria) this;
        }

        public Criteria andUConsumptionNumberNotEqualTo(Integer value) {
            addCriterion("u_consumption_number <>", value, "uConsumptionNumber");
            return (Criteria) this;
        }

        public Criteria andUConsumptionNumberGreaterThan(Integer value) {
            addCriterion("u_consumption_number >", value, "uConsumptionNumber");
            return (Criteria) this;
        }

        public Criteria andUConsumptionNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("u_consumption_number >=", value, "uConsumptionNumber");
            return (Criteria) this;
        }

        public Criteria andUConsumptionNumberLessThan(Integer value) {
            addCriterion("u_consumption_number <", value, "uConsumptionNumber");
            return (Criteria) this;
        }

        public Criteria andUConsumptionNumberLessThanOrEqualTo(Integer value) {
            addCriterion("u_consumption_number <=", value, "uConsumptionNumber");
            return (Criteria) this;
        }

        public Criteria andUConsumptionNumberIn(List<Integer> values) {
            addCriterion("u_consumption_number in", values, "uConsumptionNumber");
            return (Criteria) this;
        }

        public Criteria andUConsumptionNumberNotIn(List<Integer> values) {
            addCriterion("u_consumption_number not in", values, "uConsumptionNumber");
            return (Criteria) this;
        }

        public Criteria andUConsumptionNumberBetween(Integer value1, Integer value2) {
            addCriterion("u_consumption_number between", value1, value2, "uConsumptionNumber");
            return (Criteria) this;
        }

        public Criteria andUConsumptionNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("u_consumption_number not between", value1, value2, "uConsumptionNumber");
            return (Criteria) this;
        }

        public Criteria andURemarkIsNull() {
            addCriterion("u_remark is null");
            return (Criteria) this;
        }

        public Criteria andURemarkIsNotNull() {
            addCriterion("u_remark is not null");
            return (Criteria) this;
        }

        public Criteria andURemarkEqualTo(String value) {
            addCriterion("u_remark =", value, "uRemark");
            return (Criteria) this;
        }

        public Criteria andURemarkNotEqualTo(String value) {
            addCriterion("u_remark <>", value, "uRemark");
            return (Criteria) this;
        }

        public Criteria andURemarkGreaterThan(String value) {
            addCriterion("u_remark >", value, "uRemark");
            return (Criteria) this;
        }

        public Criteria andURemarkGreaterThanOrEqualTo(String value) {
            addCriterion("u_remark >=", value, "uRemark");
            return (Criteria) this;
        }

        public Criteria andURemarkLessThan(String value) {
            addCriterion("u_remark <", value, "uRemark");
            return (Criteria) this;
        }

        public Criteria andURemarkLessThanOrEqualTo(String value) {
            addCriterion("u_remark <=", value, "uRemark");
            return (Criteria) this;
        }

        public Criteria andURemarkLike(String value) {
            addCriterion("u_remark like", value, "uRemark");
            return (Criteria) this;
        }

        public Criteria andURemarkNotLike(String value) {
            addCriterion("u_remark not like", value, "uRemark");
            return (Criteria) this;
        }

        public Criteria andURemarkIn(List<String> values) {
            addCriterion("u_remark in", values, "uRemark");
            return (Criteria) this;
        }

        public Criteria andURemarkNotIn(List<String> values) {
            addCriterion("u_remark not in", values, "uRemark");
            return (Criteria) this;
        }

        public Criteria andURemarkBetween(String value1, String value2) {
            addCriterion("u_remark between", value1, value2, "uRemark");
            return (Criteria) this;
        }

        public Criteria andURemarkNotBetween(String value1, String value2) {
            addCriterion("u_remark not between", value1, value2, "uRemark");
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
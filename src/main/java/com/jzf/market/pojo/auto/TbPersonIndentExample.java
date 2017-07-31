package com.jzf.market.pojo.auto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbPersonIndentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbPersonIndentExample() {
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

        public Criteria andPiIdIsNull() {
            addCriterion("pi_id is null");
            return (Criteria) this;
        }

        public Criteria andPiIdIsNotNull() {
            addCriterion("pi_id is not null");
            return (Criteria) this;
        }

        public Criteria andPiIdEqualTo(String value) {
            addCriterion("pi_id =", value, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdNotEqualTo(String value) {
            addCriterion("pi_id <>", value, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdGreaterThan(String value) {
            addCriterion("pi_id >", value, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdGreaterThanOrEqualTo(String value) {
            addCriterion("pi_id >=", value, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdLessThan(String value) {
            addCriterion("pi_id <", value, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdLessThanOrEqualTo(String value) {
            addCriterion("pi_id <=", value, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdLike(String value) {
            addCriterion("pi_id like", value, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdNotLike(String value) {
            addCriterion("pi_id not like", value, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdIn(List<String> values) {
            addCriterion("pi_id in", values, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdNotIn(List<String> values) {
            addCriterion("pi_id not in", values, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdBetween(String value1, String value2) {
            addCriterion("pi_id between", value1, value2, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdNotBetween(String value1, String value2) {
            addCriterion("pi_id not between", value1, value2, "piId");
            return (Criteria) this;
        }

        public Criteria andPiGIdIsNull() {
            addCriterion("pi_g_id is null");
            return (Criteria) this;
        }

        public Criteria andPiGIdIsNotNull() {
            addCriterion("pi_g_id is not null");
            return (Criteria) this;
        }

        public Criteria andPiGIdEqualTo(Long value) {
            addCriterion("pi_g_id =", value, "piGId");
            return (Criteria) this;
        }

        public Criteria andPiGIdNotEqualTo(Long value) {
            addCriterion("pi_g_id <>", value, "piGId");
            return (Criteria) this;
        }

        public Criteria andPiGIdGreaterThan(Long value) {
            addCriterion("pi_g_id >", value, "piGId");
            return (Criteria) this;
        }

        public Criteria andPiGIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pi_g_id >=", value, "piGId");
            return (Criteria) this;
        }

        public Criteria andPiGIdLessThan(Long value) {
            addCriterion("pi_g_id <", value, "piGId");
            return (Criteria) this;
        }

        public Criteria andPiGIdLessThanOrEqualTo(Long value) {
            addCriterion("pi_g_id <=", value, "piGId");
            return (Criteria) this;
        }

        public Criteria andPiGIdIn(List<Long> values) {
            addCriterion("pi_g_id in", values, "piGId");
            return (Criteria) this;
        }

        public Criteria andPiGIdNotIn(List<Long> values) {
            addCriterion("pi_g_id not in", values, "piGId");
            return (Criteria) this;
        }

        public Criteria andPiGIdBetween(Long value1, Long value2) {
            addCriterion("pi_g_id between", value1, value2, "piGId");
            return (Criteria) this;
        }

        public Criteria andPiGIdNotBetween(Long value1, Long value2) {
            addCriterion("pi_g_id not between", value1, value2, "piGId");
            return (Criteria) this;
        }

        public Criteria andPiUIdIsNull() {
            addCriterion("pi_u_id is null");
            return (Criteria) this;
        }

        public Criteria andPiUIdIsNotNull() {
            addCriterion("pi_u_id is not null");
            return (Criteria) this;
        }

        public Criteria andPiUIdEqualTo(Long value) {
            addCriterion("pi_u_id =", value, "piUId");
            return (Criteria) this;
        }

        public Criteria andPiUIdNotEqualTo(Long value) {
            addCriterion("pi_u_id <>", value, "piUId");
            return (Criteria) this;
        }

        public Criteria andPiUIdGreaterThan(Long value) {
            addCriterion("pi_u_id >", value, "piUId");
            return (Criteria) this;
        }

        public Criteria andPiUIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pi_u_id >=", value, "piUId");
            return (Criteria) this;
        }

        public Criteria andPiUIdLessThan(Long value) {
            addCriterion("pi_u_id <", value, "piUId");
            return (Criteria) this;
        }

        public Criteria andPiUIdLessThanOrEqualTo(Long value) {
            addCriterion("pi_u_id <=", value, "piUId");
            return (Criteria) this;
        }

        public Criteria andPiUIdIn(List<Long> values) {
            addCriterion("pi_u_id in", values, "piUId");
            return (Criteria) this;
        }

        public Criteria andPiUIdNotIn(List<Long> values) {
            addCriterion("pi_u_id not in", values, "piUId");
            return (Criteria) this;
        }

        public Criteria andPiUIdBetween(Long value1, Long value2) {
            addCriterion("pi_u_id between", value1, value2, "piUId");
            return (Criteria) this;
        }

        public Criteria andPiUIdNotBetween(Long value1, Long value2) {
            addCriterion("pi_u_id not between", value1, value2, "piUId");
            return (Criteria) this;
        }

        public Criteria andDaIdIsNull() {
            addCriterion("da_id is null");
            return (Criteria) this;
        }

        public Criteria andDaIdIsNotNull() {
            addCriterion("da_id is not null");
            return (Criteria) this;
        }

        public Criteria andDaIdEqualTo(Long value) {
            addCriterion("da_id =", value, "daId");
            return (Criteria) this;
        }

        public Criteria andDaIdNotEqualTo(Long value) {
            addCriterion("da_id <>", value, "daId");
            return (Criteria) this;
        }

        public Criteria andDaIdGreaterThan(Long value) {
            addCriterion("da_id >", value, "daId");
            return (Criteria) this;
        }

        public Criteria andDaIdGreaterThanOrEqualTo(Long value) {
            addCriterion("da_id >=", value, "daId");
            return (Criteria) this;
        }

        public Criteria andDaIdLessThan(Long value) {
            addCriterion("da_id <", value, "daId");
            return (Criteria) this;
        }

        public Criteria andDaIdLessThanOrEqualTo(Long value) {
            addCriterion("da_id <=", value, "daId");
            return (Criteria) this;
        }

        public Criteria andDaIdIn(List<Long> values) {
            addCriterion("da_id in", values, "daId");
            return (Criteria) this;
        }

        public Criteria andDaIdNotIn(List<Long> values) {
            addCriterion("da_id not in", values, "daId");
            return (Criteria) this;
        }

        public Criteria andDaIdBetween(Long value1, Long value2) {
            addCriterion("da_id between", value1, value2, "daId");
            return (Criteria) this;
        }

        public Criteria andDaIdNotBetween(Long value1, Long value2) {
            addCriterion("da_id not between", value1, value2, "daId");
            return (Criteria) this;
        }

        public Criteria andDaPhoneIsNull() {
            addCriterion("da_phone is null");
            return (Criteria) this;
        }

        public Criteria andDaPhoneIsNotNull() {
            addCriterion("da_phone is not null");
            return (Criteria) this;
        }

        public Criteria andDaPhoneEqualTo(String value) {
            addCriterion("da_phone =", value, "daPhone");
            return (Criteria) this;
        }

        public Criteria andDaPhoneNotEqualTo(String value) {
            addCriterion("da_phone <>", value, "daPhone");
            return (Criteria) this;
        }

        public Criteria andDaPhoneGreaterThan(String value) {
            addCriterion("da_phone >", value, "daPhone");
            return (Criteria) this;
        }

        public Criteria andDaPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("da_phone >=", value, "daPhone");
            return (Criteria) this;
        }

        public Criteria andDaPhoneLessThan(String value) {
            addCriterion("da_phone <", value, "daPhone");
            return (Criteria) this;
        }

        public Criteria andDaPhoneLessThanOrEqualTo(String value) {
            addCriterion("da_phone <=", value, "daPhone");
            return (Criteria) this;
        }

        public Criteria andDaPhoneLike(String value) {
            addCriterion("da_phone like", value, "daPhone");
            return (Criteria) this;
        }

        public Criteria andDaPhoneNotLike(String value) {
            addCriterion("da_phone not like", value, "daPhone");
            return (Criteria) this;
        }

        public Criteria andDaPhoneIn(List<String> values) {
            addCriterion("da_phone in", values, "daPhone");
            return (Criteria) this;
        }

        public Criteria andDaPhoneNotIn(List<String> values) {
            addCriterion("da_phone not in", values, "daPhone");
            return (Criteria) this;
        }

        public Criteria andDaPhoneBetween(String value1, String value2) {
            addCriterion("da_phone between", value1, value2, "daPhone");
            return (Criteria) this;
        }

        public Criteria andDaPhoneNotBetween(String value1, String value2) {
            addCriterion("da_phone not between", value1, value2, "daPhone");
            return (Criteria) this;
        }

        public Criteria andDaDetailAddressIsNull() {
            addCriterion("da_detail_address is null");
            return (Criteria) this;
        }

        public Criteria andDaDetailAddressIsNotNull() {
            addCriterion("da_detail_address is not null");
            return (Criteria) this;
        }

        public Criteria andDaDetailAddressEqualTo(String value) {
            addCriterion("da_detail_address =", value, "daDetailAddress");
            return (Criteria) this;
        }

        public Criteria andDaDetailAddressNotEqualTo(String value) {
            addCriterion("da_detail_address <>", value, "daDetailAddress");
            return (Criteria) this;
        }

        public Criteria andDaDetailAddressGreaterThan(String value) {
            addCriterion("da_detail_address >", value, "daDetailAddress");
            return (Criteria) this;
        }

        public Criteria andDaDetailAddressGreaterThanOrEqualTo(String value) {
            addCriterion("da_detail_address >=", value, "daDetailAddress");
            return (Criteria) this;
        }

        public Criteria andDaDetailAddressLessThan(String value) {
            addCriterion("da_detail_address <", value, "daDetailAddress");
            return (Criteria) this;
        }

        public Criteria andDaDetailAddressLessThanOrEqualTo(String value) {
            addCriterion("da_detail_address <=", value, "daDetailAddress");
            return (Criteria) this;
        }

        public Criteria andDaDetailAddressLike(String value) {
            addCriterion("da_detail_address like", value, "daDetailAddress");
            return (Criteria) this;
        }

        public Criteria andDaDetailAddressNotLike(String value) {
            addCriterion("da_detail_address not like", value, "daDetailAddress");
            return (Criteria) this;
        }

        public Criteria andDaDetailAddressIn(List<String> values) {
            addCriterion("da_detail_address in", values, "daDetailAddress");
            return (Criteria) this;
        }

        public Criteria andDaDetailAddressNotIn(List<String> values) {
            addCriterion("da_detail_address not in", values, "daDetailAddress");
            return (Criteria) this;
        }

        public Criteria andDaDetailAddressBetween(String value1, String value2) {
            addCriterion("da_detail_address between", value1, value2, "daDetailAddress");
            return (Criteria) this;
        }

        public Criteria andDaDetailAddressNotBetween(String value1, String value2) {
            addCriterion("da_detail_address not between", value1, value2, "daDetailAddress");
            return (Criteria) this;
        }

        public Criteria andPiEvaluateLanguageIsNull() {
            addCriterion("pi_evaluate_language is null");
            return (Criteria) this;
        }

        public Criteria andPiEvaluateLanguageIsNotNull() {
            addCriterion("pi_evaluate_language is not null");
            return (Criteria) this;
        }

        public Criteria andPiEvaluateLanguageEqualTo(String value) {
            addCriterion("pi_evaluate_language =", value, "piEvaluateLanguage");
            return (Criteria) this;
        }

        public Criteria andPiEvaluateLanguageNotEqualTo(String value) {
            addCriterion("pi_evaluate_language <>", value, "piEvaluateLanguage");
            return (Criteria) this;
        }

        public Criteria andPiEvaluateLanguageGreaterThan(String value) {
            addCriterion("pi_evaluate_language >", value, "piEvaluateLanguage");
            return (Criteria) this;
        }

        public Criteria andPiEvaluateLanguageGreaterThanOrEqualTo(String value) {
            addCriterion("pi_evaluate_language >=", value, "piEvaluateLanguage");
            return (Criteria) this;
        }

        public Criteria andPiEvaluateLanguageLessThan(String value) {
            addCriterion("pi_evaluate_language <", value, "piEvaluateLanguage");
            return (Criteria) this;
        }

        public Criteria andPiEvaluateLanguageLessThanOrEqualTo(String value) {
            addCriterion("pi_evaluate_language <=", value, "piEvaluateLanguage");
            return (Criteria) this;
        }

        public Criteria andPiEvaluateLanguageLike(String value) {
            addCriterion("pi_evaluate_language like", value, "piEvaluateLanguage");
            return (Criteria) this;
        }

        public Criteria andPiEvaluateLanguageNotLike(String value) {
            addCriterion("pi_evaluate_language not like", value, "piEvaluateLanguage");
            return (Criteria) this;
        }

        public Criteria andPiEvaluateLanguageIn(List<String> values) {
            addCriterion("pi_evaluate_language in", values, "piEvaluateLanguage");
            return (Criteria) this;
        }

        public Criteria andPiEvaluateLanguageNotIn(List<String> values) {
            addCriterion("pi_evaluate_language not in", values, "piEvaluateLanguage");
            return (Criteria) this;
        }

        public Criteria andPiEvaluateLanguageBetween(String value1, String value2) {
            addCriterion("pi_evaluate_language between", value1, value2, "piEvaluateLanguage");
            return (Criteria) this;
        }

        public Criteria andPiEvaluateLanguageNotBetween(String value1, String value2) {
            addCriterion("pi_evaluate_language not between", value1, value2, "piEvaluateLanguage");
            return (Criteria) this;
        }

        public Criteria andPiEvaluateGradeIsNull() {
            addCriterion("pi_evaluate_grade is null");
            return (Criteria) this;
        }

        public Criteria andPiEvaluateGradeIsNotNull() {
            addCriterion("pi_evaluate_grade is not null");
            return (Criteria) this;
        }

        public Criteria andPiEvaluateGradeEqualTo(String value) {
            addCriterion("pi_evaluate_grade =", value, "piEvaluateGrade");
            return (Criteria) this;
        }

        public Criteria andPiEvaluateGradeNotEqualTo(String value) {
            addCriterion("pi_evaluate_grade <>", value, "piEvaluateGrade");
            return (Criteria) this;
        }

        public Criteria andPiEvaluateGradeGreaterThan(String value) {
            addCriterion("pi_evaluate_grade >", value, "piEvaluateGrade");
            return (Criteria) this;
        }

        public Criteria andPiEvaluateGradeGreaterThanOrEqualTo(String value) {
            addCriterion("pi_evaluate_grade >=", value, "piEvaluateGrade");
            return (Criteria) this;
        }

        public Criteria andPiEvaluateGradeLessThan(String value) {
            addCriterion("pi_evaluate_grade <", value, "piEvaluateGrade");
            return (Criteria) this;
        }

        public Criteria andPiEvaluateGradeLessThanOrEqualTo(String value) {
            addCriterion("pi_evaluate_grade <=", value, "piEvaluateGrade");
            return (Criteria) this;
        }

        public Criteria andPiEvaluateGradeLike(String value) {
            addCriterion("pi_evaluate_grade like", value, "piEvaluateGrade");
            return (Criteria) this;
        }

        public Criteria andPiEvaluateGradeNotLike(String value) {
            addCriterion("pi_evaluate_grade not like", value, "piEvaluateGrade");
            return (Criteria) this;
        }

        public Criteria andPiEvaluateGradeIn(List<String> values) {
            addCriterion("pi_evaluate_grade in", values, "piEvaluateGrade");
            return (Criteria) this;
        }

        public Criteria andPiEvaluateGradeNotIn(List<String> values) {
            addCriterion("pi_evaluate_grade not in", values, "piEvaluateGrade");
            return (Criteria) this;
        }

        public Criteria andPiEvaluateGradeBetween(String value1, String value2) {
            addCriterion("pi_evaluate_grade between", value1, value2, "piEvaluateGrade");
            return (Criteria) this;
        }

        public Criteria andPiEvaluateGradeNotBetween(String value1, String value2) {
            addCriterion("pi_evaluate_grade not between", value1, value2, "piEvaluateGrade");
            return (Criteria) this;
        }

        public Criteria andPiStatusIsNull() {
            addCriterion("pi_status is null");
            return (Criteria) this;
        }

        public Criteria andPiStatusIsNotNull() {
            addCriterion("pi_status is not null");
            return (Criteria) this;
        }

        public Criteria andPiStatusEqualTo(String value) {
            addCriterion("pi_status =", value, "piStatus");
            return (Criteria) this;
        }

        public Criteria andPiStatusNotEqualTo(String value) {
            addCriterion("pi_status <>", value, "piStatus");
            return (Criteria) this;
        }

        public Criteria andPiStatusGreaterThan(String value) {
            addCriterion("pi_status >", value, "piStatus");
            return (Criteria) this;
        }

        public Criteria andPiStatusGreaterThanOrEqualTo(String value) {
            addCriterion("pi_status >=", value, "piStatus");
            return (Criteria) this;
        }

        public Criteria andPiStatusLessThan(String value) {
            addCriterion("pi_status <", value, "piStatus");
            return (Criteria) this;
        }

        public Criteria andPiStatusLessThanOrEqualTo(String value) {
            addCriterion("pi_status <=", value, "piStatus");
            return (Criteria) this;
        }

        public Criteria andPiStatusLike(String value) {
            addCriterion("pi_status like", value, "piStatus");
            return (Criteria) this;
        }

        public Criteria andPiStatusNotLike(String value) {
            addCriterion("pi_status not like", value, "piStatus");
            return (Criteria) this;
        }

        public Criteria andPiStatusIn(List<String> values) {
            addCriterion("pi_status in", values, "piStatus");
            return (Criteria) this;
        }

        public Criteria andPiStatusNotIn(List<String> values) {
            addCriterion("pi_status not in", values, "piStatus");
            return (Criteria) this;
        }

        public Criteria andPiStatusBetween(String value1, String value2) {
            addCriterion("pi_status between", value1, value2, "piStatus");
            return (Criteria) this;
        }

        public Criteria andPiStatusNotBetween(String value1, String value2) {
            addCriterion("pi_status not between", value1, value2, "piStatus");
            return (Criteria) this;
        }

        public Criteria andPiCreateDateIsNull() {
            addCriterion("pi_create_date is null");
            return (Criteria) this;
        }

        public Criteria andPiCreateDateIsNotNull() {
            addCriterion("pi_create_date is not null");
            return (Criteria) this;
        }

        public Criteria andPiCreateDateEqualTo(Date value) {
            addCriterion("pi_create_date =", value, "piCreateDate");
            return (Criteria) this;
        }

        public Criteria andPiCreateDateNotEqualTo(Date value) {
            addCriterion("pi_create_date <>", value, "piCreateDate");
            return (Criteria) this;
        }

        public Criteria andPiCreateDateGreaterThan(Date value) {
            addCriterion("pi_create_date >", value, "piCreateDate");
            return (Criteria) this;
        }

        public Criteria andPiCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("pi_create_date >=", value, "piCreateDate");
            return (Criteria) this;
        }

        public Criteria andPiCreateDateLessThan(Date value) {
            addCriterion("pi_create_date <", value, "piCreateDate");
            return (Criteria) this;
        }

        public Criteria andPiCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("pi_create_date <=", value, "piCreateDate");
            return (Criteria) this;
        }

        public Criteria andPiCreateDateIn(List<Date> values) {
            addCriterion("pi_create_date in", values, "piCreateDate");
            return (Criteria) this;
        }

        public Criteria andPiCreateDateNotIn(List<Date> values) {
            addCriterion("pi_create_date not in", values, "piCreateDate");
            return (Criteria) this;
        }

        public Criteria andPiCreateDateBetween(Date value1, Date value2) {
            addCriterion("pi_create_date between", value1, value2, "piCreateDate");
            return (Criteria) this;
        }

        public Criteria andPiCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("pi_create_date not between", value1, value2, "piCreateDate");
            return (Criteria) this;
        }

        public Criteria andPiShipmentsDateIsNull() {
            addCriterion("pi_shipments_date is null");
            return (Criteria) this;
        }

        public Criteria andPiShipmentsDateIsNotNull() {
            addCriterion("pi_shipments_date is not null");
            return (Criteria) this;
        }

        public Criteria andPiShipmentsDateEqualTo(Date value) {
            addCriterion("pi_shipments_date =", value, "piShipmentsDate");
            return (Criteria) this;
        }

        public Criteria andPiShipmentsDateNotEqualTo(Date value) {
            addCriterion("pi_shipments_date <>", value, "piShipmentsDate");
            return (Criteria) this;
        }

        public Criteria andPiShipmentsDateGreaterThan(Date value) {
            addCriterion("pi_shipments_date >", value, "piShipmentsDate");
            return (Criteria) this;
        }

        public Criteria andPiShipmentsDateGreaterThanOrEqualTo(Date value) {
            addCriterion("pi_shipments_date >=", value, "piShipmentsDate");
            return (Criteria) this;
        }

        public Criteria andPiShipmentsDateLessThan(Date value) {
            addCriterion("pi_shipments_date <", value, "piShipmentsDate");
            return (Criteria) this;
        }

        public Criteria andPiShipmentsDateLessThanOrEqualTo(Date value) {
            addCriterion("pi_shipments_date <=", value, "piShipmentsDate");
            return (Criteria) this;
        }

        public Criteria andPiShipmentsDateIn(List<Date> values) {
            addCriterion("pi_shipments_date in", values, "piShipmentsDate");
            return (Criteria) this;
        }

        public Criteria andPiShipmentsDateNotIn(List<Date> values) {
            addCriterion("pi_shipments_date not in", values, "piShipmentsDate");
            return (Criteria) this;
        }

        public Criteria andPiShipmentsDateBetween(Date value1, Date value2) {
            addCriterion("pi_shipments_date between", value1, value2, "piShipmentsDate");
            return (Criteria) this;
        }

        public Criteria andPiShipmentsDateNotBetween(Date value1, Date value2) {
            addCriterion("pi_shipments_date not between", value1, value2, "piShipmentsDate");
            return (Criteria) this;
        }

        public Criteria andPiArrivalDateIsNull() {
            addCriterion("pi_arrival_date is null");
            return (Criteria) this;
        }

        public Criteria andPiArrivalDateIsNotNull() {
            addCriterion("pi_arrival_date is not null");
            return (Criteria) this;
        }

        public Criteria andPiArrivalDateEqualTo(Date value) {
            addCriterion("pi_arrival_date =", value, "piArrivalDate");
            return (Criteria) this;
        }

        public Criteria andPiArrivalDateNotEqualTo(Date value) {
            addCriterion("pi_arrival_date <>", value, "piArrivalDate");
            return (Criteria) this;
        }

        public Criteria andPiArrivalDateGreaterThan(Date value) {
            addCriterion("pi_arrival_date >", value, "piArrivalDate");
            return (Criteria) this;
        }

        public Criteria andPiArrivalDateGreaterThanOrEqualTo(Date value) {
            addCriterion("pi_arrival_date >=", value, "piArrivalDate");
            return (Criteria) this;
        }

        public Criteria andPiArrivalDateLessThan(Date value) {
            addCriterion("pi_arrival_date <", value, "piArrivalDate");
            return (Criteria) this;
        }

        public Criteria andPiArrivalDateLessThanOrEqualTo(Date value) {
            addCriterion("pi_arrival_date <=", value, "piArrivalDate");
            return (Criteria) this;
        }

        public Criteria andPiArrivalDateIn(List<Date> values) {
            addCriterion("pi_arrival_date in", values, "piArrivalDate");
            return (Criteria) this;
        }

        public Criteria andPiArrivalDateNotIn(List<Date> values) {
            addCriterion("pi_arrival_date not in", values, "piArrivalDate");
            return (Criteria) this;
        }

        public Criteria andPiArrivalDateBetween(Date value1, Date value2) {
            addCriterion("pi_arrival_date between", value1, value2, "piArrivalDate");
            return (Criteria) this;
        }

        public Criteria andPiArrivalDateNotBetween(Date value1, Date value2) {
            addCriterion("pi_arrival_date not between", value1, value2, "piArrivalDate");
            return (Criteria) this;
        }

        public Criteria andPiQuantityIsNull() {
            addCriterion("pi_quantity is null");
            return (Criteria) this;
        }

        public Criteria andPiQuantityIsNotNull() {
            addCriterion("pi_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andPiQuantityEqualTo(Integer value) {
            addCriterion("pi_quantity =", value, "piQuantity");
            return (Criteria) this;
        }

        public Criteria andPiQuantityNotEqualTo(Integer value) {
            addCriterion("pi_quantity <>", value, "piQuantity");
            return (Criteria) this;
        }

        public Criteria andPiQuantityGreaterThan(Integer value) {
            addCriterion("pi_quantity >", value, "piQuantity");
            return (Criteria) this;
        }

        public Criteria andPiQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("pi_quantity >=", value, "piQuantity");
            return (Criteria) this;
        }

        public Criteria andPiQuantityLessThan(Integer value) {
            addCriterion("pi_quantity <", value, "piQuantity");
            return (Criteria) this;
        }

        public Criteria andPiQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("pi_quantity <=", value, "piQuantity");
            return (Criteria) this;
        }

        public Criteria andPiQuantityIn(List<Integer> values) {
            addCriterion("pi_quantity in", values, "piQuantity");
            return (Criteria) this;
        }

        public Criteria andPiQuantityNotIn(List<Integer> values) {
            addCriterion("pi_quantity not in", values, "piQuantity");
            return (Criteria) this;
        }

        public Criteria andPiQuantityBetween(Integer value1, Integer value2) {
            addCriterion("pi_quantity between", value1, value2, "piQuantity");
            return (Criteria) this;
        }

        public Criteria andPiQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("pi_quantity not between", value1, value2, "piQuantity");
            return (Criteria) this;
        }

        public Criteria andPiTrackingNumberIsNull() {
            addCriterion("pi_tracking_number is null");
            return (Criteria) this;
        }

        public Criteria andPiTrackingNumberIsNotNull() {
            addCriterion("pi_tracking_number is not null");
            return (Criteria) this;
        }

        public Criteria andPiTrackingNumberEqualTo(String value) {
            addCriterion("pi_tracking_number =", value, "piTrackingNumber");
            return (Criteria) this;
        }

        public Criteria andPiTrackingNumberNotEqualTo(String value) {
            addCriterion("pi_tracking_number <>", value, "piTrackingNumber");
            return (Criteria) this;
        }

        public Criteria andPiTrackingNumberGreaterThan(String value) {
            addCriterion("pi_tracking_number >", value, "piTrackingNumber");
            return (Criteria) this;
        }

        public Criteria andPiTrackingNumberGreaterThanOrEqualTo(String value) {
            addCriterion("pi_tracking_number >=", value, "piTrackingNumber");
            return (Criteria) this;
        }

        public Criteria andPiTrackingNumberLessThan(String value) {
            addCriterion("pi_tracking_number <", value, "piTrackingNumber");
            return (Criteria) this;
        }

        public Criteria andPiTrackingNumberLessThanOrEqualTo(String value) {
            addCriterion("pi_tracking_number <=", value, "piTrackingNumber");
            return (Criteria) this;
        }

        public Criteria andPiTrackingNumberLike(String value) {
            addCriterion("pi_tracking_number like", value, "piTrackingNumber");
            return (Criteria) this;
        }

        public Criteria andPiTrackingNumberNotLike(String value) {
            addCriterion("pi_tracking_number not like", value, "piTrackingNumber");
            return (Criteria) this;
        }

        public Criteria andPiTrackingNumberIn(List<String> values) {
            addCriterion("pi_tracking_number in", values, "piTrackingNumber");
            return (Criteria) this;
        }

        public Criteria andPiTrackingNumberNotIn(List<String> values) {
            addCriterion("pi_tracking_number not in", values, "piTrackingNumber");
            return (Criteria) this;
        }

        public Criteria andPiTrackingNumberBetween(String value1, String value2) {
            addCriterion("pi_tracking_number between", value1, value2, "piTrackingNumber");
            return (Criteria) this;
        }

        public Criteria andPiTrackingNumberNotBetween(String value1, String value2) {
            addCriterion("pi_tracking_number not between", value1, value2, "piTrackingNumber");
            return (Criteria) this;
        }

        public Criteria andPiCarrierCodeIsNull() {
            addCriterion("pi_carrier_code is null");
            return (Criteria) this;
        }

        public Criteria andPiCarrierCodeIsNotNull() {
            addCriterion("pi_carrier_code is not null");
            return (Criteria) this;
        }

        public Criteria andPiCarrierCodeEqualTo(String value) {
            addCriterion("pi_carrier_code =", value, "piCarrierCode");
            return (Criteria) this;
        }

        public Criteria andPiCarrierCodeNotEqualTo(String value) {
            addCriterion("pi_carrier_code <>", value, "piCarrierCode");
            return (Criteria) this;
        }

        public Criteria andPiCarrierCodeGreaterThan(String value) {
            addCriterion("pi_carrier_code >", value, "piCarrierCode");
            return (Criteria) this;
        }

        public Criteria andPiCarrierCodeGreaterThanOrEqualTo(String value) {
            addCriterion("pi_carrier_code >=", value, "piCarrierCode");
            return (Criteria) this;
        }

        public Criteria andPiCarrierCodeLessThan(String value) {
            addCriterion("pi_carrier_code <", value, "piCarrierCode");
            return (Criteria) this;
        }

        public Criteria andPiCarrierCodeLessThanOrEqualTo(String value) {
            addCriterion("pi_carrier_code <=", value, "piCarrierCode");
            return (Criteria) this;
        }

        public Criteria andPiCarrierCodeLike(String value) {
            addCriterion("pi_carrier_code like", value, "piCarrierCode");
            return (Criteria) this;
        }

        public Criteria andPiCarrierCodeNotLike(String value) {
            addCriterion("pi_carrier_code not like", value, "piCarrierCode");
            return (Criteria) this;
        }

        public Criteria andPiCarrierCodeIn(List<String> values) {
            addCriterion("pi_carrier_code in", values, "piCarrierCode");
            return (Criteria) this;
        }

        public Criteria andPiCarrierCodeNotIn(List<String> values) {
            addCriterion("pi_carrier_code not in", values, "piCarrierCode");
            return (Criteria) this;
        }

        public Criteria andPiCarrierCodeBetween(String value1, String value2) {
            addCriterion("pi_carrier_code between", value1, value2, "piCarrierCode");
            return (Criteria) this;
        }

        public Criteria andPiCarrierCodeNotBetween(String value1, String value2) {
            addCriterion("pi_carrier_code not between", value1, value2, "piCarrierCode");
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
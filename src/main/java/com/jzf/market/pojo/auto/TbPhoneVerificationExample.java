package com.jzf.market.pojo.auto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbPhoneVerificationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbPhoneVerificationExample() {
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

        public Criteria andPvIdIsNull() {
            addCriterion("pv_id is null");
            return (Criteria) this;
        }

        public Criteria andPvIdIsNotNull() {
            addCriterion("pv_id is not null");
            return (Criteria) this;
        }

        public Criteria andPvIdEqualTo(Long value) {
            addCriterion("pv_id =", value, "pvId");
            return (Criteria) this;
        }

        public Criteria andPvIdNotEqualTo(Long value) {
            addCriterion("pv_id <>", value, "pvId");
            return (Criteria) this;
        }

        public Criteria andPvIdGreaterThan(Long value) {
            addCriterion("pv_id >", value, "pvId");
            return (Criteria) this;
        }

        public Criteria andPvIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pv_id >=", value, "pvId");
            return (Criteria) this;
        }

        public Criteria andPvIdLessThan(Long value) {
            addCriterion("pv_id <", value, "pvId");
            return (Criteria) this;
        }

        public Criteria andPvIdLessThanOrEqualTo(Long value) {
            addCriterion("pv_id <=", value, "pvId");
            return (Criteria) this;
        }

        public Criteria andPvIdIn(List<Long> values) {
            addCriterion("pv_id in", values, "pvId");
            return (Criteria) this;
        }

        public Criteria andPvIdNotIn(List<Long> values) {
            addCriterion("pv_id not in", values, "pvId");
            return (Criteria) this;
        }

        public Criteria andPvIdBetween(Long value1, Long value2) {
            addCriterion("pv_id between", value1, value2, "pvId");
            return (Criteria) this;
        }

        public Criteria andPvIdNotBetween(Long value1, Long value2) {
            addCriterion("pv_id not between", value1, value2, "pvId");
            return (Criteria) this;
        }

        public Criteria andPvPhoneIsNull() {
            addCriterion("pv_phone is null");
            return (Criteria) this;
        }

        public Criteria andPvPhoneIsNotNull() {
            addCriterion("pv_phone is not null");
            return (Criteria) this;
        }

        public Criteria andPvPhoneEqualTo(String value) {
            addCriterion("pv_phone =", value, "pvPhone");
            return (Criteria) this;
        }

        public Criteria andPvPhoneNotEqualTo(String value) {
            addCriterion("pv_phone <>", value, "pvPhone");
            return (Criteria) this;
        }

        public Criteria andPvPhoneGreaterThan(String value) {
            addCriterion("pv_phone >", value, "pvPhone");
            return (Criteria) this;
        }

        public Criteria andPvPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("pv_phone >=", value, "pvPhone");
            return (Criteria) this;
        }

        public Criteria andPvPhoneLessThan(String value) {
            addCriterion("pv_phone <", value, "pvPhone");
            return (Criteria) this;
        }

        public Criteria andPvPhoneLessThanOrEqualTo(String value) {
            addCriterion("pv_phone <=", value, "pvPhone");
            return (Criteria) this;
        }

        public Criteria andPvPhoneLike(String value) {
            addCriterion("pv_phone like", value, "pvPhone");
            return (Criteria) this;
        }

        public Criteria andPvPhoneNotLike(String value) {
            addCriterion("pv_phone not like", value, "pvPhone");
            return (Criteria) this;
        }

        public Criteria andPvPhoneIn(List<String> values) {
            addCriterion("pv_phone in", values, "pvPhone");
            return (Criteria) this;
        }

        public Criteria andPvPhoneNotIn(List<String> values) {
            addCriterion("pv_phone not in", values, "pvPhone");
            return (Criteria) this;
        }

        public Criteria andPvPhoneBetween(String value1, String value2) {
            addCriterion("pv_phone between", value1, value2, "pvPhone");
            return (Criteria) this;
        }

        public Criteria andPvPhoneNotBetween(String value1, String value2) {
            addCriterion("pv_phone not between", value1, value2, "pvPhone");
            return (Criteria) this;
        }

        public Criteria andPvVerificationCodeIsNull() {
            addCriterion("pv_verification_code is null");
            return (Criteria) this;
        }

        public Criteria andPvVerificationCodeIsNotNull() {
            addCriterion("pv_verification_code is not null");
            return (Criteria) this;
        }

        public Criteria andPvVerificationCodeEqualTo(String value) {
            addCriterion("pv_verification_code =", value, "pvVerificationCode");
            return (Criteria) this;
        }

        public Criteria andPvVerificationCodeNotEqualTo(String value) {
            addCriterion("pv_verification_code <>", value, "pvVerificationCode");
            return (Criteria) this;
        }

        public Criteria andPvVerificationCodeGreaterThan(String value) {
            addCriterion("pv_verification_code >", value, "pvVerificationCode");
            return (Criteria) this;
        }

        public Criteria andPvVerificationCodeGreaterThanOrEqualTo(String value) {
            addCriterion("pv_verification_code >=", value, "pvVerificationCode");
            return (Criteria) this;
        }

        public Criteria andPvVerificationCodeLessThan(String value) {
            addCriterion("pv_verification_code <", value, "pvVerificationCode");
            return (Criteria) this;
        }

        public Criteria andPvVerificationCodeLessThanOrEqualTo(String value) {
            addCriterion("pv_verification_code <=", value, "pvVerificationCode");
            return (Criteria) this;
        }

        public Criteria andPvVerificationCodeLike(String value) {
            addCriterion("pv_verification_code like", value, "pvVerificationCode");
            return (Criteria) this;
        }

        public Criteria andPvVerificationCodeNotLike(String value) {
            addCriterion("pv_verification_code not like", value, "pvVerificationCode");
            return (Criteria) this;
        }

        public Criteria andPvVerificationCodeIn(List<String> values) {
            addCriterion("pv_verification_code in", values, "pvVerificationCode");
            return (Criteria) this;
        }

        public Criteria andPvVerificationCodeNotIn(List<String> values) {
            addCriterion("pv_verification_code not in", values, "pvVerificationCode");
            return (Criteria) this;
        }

        public Criteria andPvVerificationCodeBetween(String value1, String value2) {
            addCriterion("pv_verification_code between", value1, value2, "pvVerificationCode");
            return (Criteria) this;
        }

        public Criteria andPvVerificationCodeNotBetween(String value1, String value2) {
            addCriterion("pv_verification_code not between", value1, value2, "pvVerificationCode");
            return (Criteria) this;
        }

        public Criteria andPvCreateDateIsNull() {
            addCriterion("pv_create_date is null");
            return (Criteria) this;
        }

        public Criteria andPvCreateDateIsNotNull() {
            addCriterion("pv_create_date is not null");
            return (Criteria) this;
        }

        public Criteria andPvCreateDateEqualTo(Date value) {
            addCriterion("pv_create_date =", value, "pvCreateDate");
            return (Criteria) this;
        }

        public Criteria andPvCreateDateNotEqualTo(Date value) {
            addCriterion("pv_create_date <>", value, "pvCreateDate");
            return (Criteria) this;
        }

        public Criteria andPvCreateDateGreaterThan(Date value) {
            addCriterion("pv_create_date >", value, "pvCreateDate");
            return (Criteria) this;
        }

        public Criteria andPvCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("pv_create_date >=", value, "pvCreateDate");
            return (Criteria) this;
        }

        public Criteria andPvCreateDateLessThan(Date value) {
            addCriterion("pv_create_date <", value, "pvCreateDate");
            return (Criteria) this;
        }

        public Criteria andPvCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("pv_create_date <=", value, "pvCreateDate");
            return (Criteria) this;
        }

        public Criteria andPvCreateDateIn(List<Date> values) {
            addCriterion("pv_create_date in", values, "pvCreateDate");
            return (Criteria) this;
        }

        public Criteria andPvCreateDateNotIn(List<Date> values) {
            addCriterion("pv_create_date not in", values, "pvCreateDate");
            return (Criteria) this;
        }

        public Criteria andPvCreateDateBetween(Date value1, Date value2) {
            addCriterion("pv_create_date between", value1, value2, "pvCreateDate");
            return (Criteria) this;
        }

        public Criteria andPvCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("pv_create_date not between", value1, value2, "pvCreateDate");
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
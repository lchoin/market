package com.jzf.market.pojo.auto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbRoleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbRoleExample() {
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

        public Criteria andRIdIsNull() {
            addCriterion("r_id is null");
            return (Criteria) this;
        }

        public Criteria andRIdIsNotNull() {
            addCriterion("r_id is not null");
            return (Criteria) this;
        }

        public Criteria andRIdEqualTo(Long value) {
            addCriterion("r_id =", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdNotEqualTo(Long value) {
            addCriterion("r_id <>", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdGreaterThan(Long value) {
            addCriterion("r_id >", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdGreaterThanOrEqualTo(Long value) {
            addCriterion("r_id >=", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdLessThan(Long value) {
            addCriterion("r_id <", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdLessThanOrEqualTo(Long value) {
            addCriterion("r_id <=", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdIn(List<Long> values) {
            addCriterion("r_id in", values, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdNotIn(List<Long> values) {
            addCriterion("r_id not in", values, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdBetween(Long value1, Long value2) {
            addCriterion("r_id between", value1, value2, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdNotBetween(Long value1, Long value2) {
            addCriterion("r_id not between", value1, value2, "rId");
            return (Criteria) this;
        }

        public Criteria andRNameIsNull() {
            addCriterion("r_name is null");
            return (Criteria) this;
        }

        public Criteria andRNameIsNotNull() {
            addCriterion("r_name is not null");
            return (Criteria) this;
        }

        public Criteria andRNameEqualTo(String value) {
            addCriterion("r_name =", value, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameNotEqualTo(String value) {
            addCriterion("r_name <>", value, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameGreaterThan(String value) {
            addCriterion("r_name >", value, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameGreaterThanOrEqualTo(String value) {
            addCriterion("r_name >=", value, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameLessThan(String value) {
            addCriterion("r_name <", value, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameLessThanOrEqualTo(String value) {
            addCriterion("r_name <=", value, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameLike(String value) {
            addCriterion("r_name like", value, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameNotLike(String value) {
            addCriterion("r_name not like", value, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameIn(List<String> values) {
            addCriterion("r_name in", values, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameNotIn(List<String> values) {
            addCriterion("r_name not in", values, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameBetween(String value1, String value2) {
            addCriterion("r_name between", value1, value2, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameNotBetween(String value1, String value2) {
            addCriterion("r_name not between", value1, value2, "rName");
            return (Criteria) this;
        }

        public Criteria andRCreateDateIsNull() {
            addCriterion("r_create_date is null");
            return (Criteria) this;
        }

        public Criteria andRCreateDateIsNotNull() {
            addCriterion("r_create_date is not null");
            return (Criteria) this;
        }

        public Criteria andRCreateDateEqualTo(Date value) {
            addCriterion("r_create_date =", value, "rCreateDate");
            return (Criteria) this;
        }

        public Criteria andRCreateDateNotEqualTo(Date value) {
            addCriterion("r_create_date <>", value, "rCreateDate");
            return (Criteria) this;
        }

        public Criteria andRCreateDateGreaterThan(Date value) {
            addCriterion("r_create_date >", value, "rCreateDate");
            return (Criteria) this;
        }

        public Criteria andRCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("r_create_date >=", value, "rCreateDate");
            return (Criteria) this;
        }

        public Criteria andRCreateDateLessThan(Date value) {
            addCriterion("r_create_date <", value, "rCreateDate");
            return (Criteria) this;
        }

        public Criteria andRCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("r_create_date <=", value, "rCreateDate");
            return (Criteria) this;
        }

        public Criteria andRCreateDateIn(List<Date> values) {
            addCriterion("r_create_date in", values, "rCreateDate");
            return (Criteria) this;
        }

        public Criteria andRCreateDateNotIn(List<Date> values) {
            addCriterion("r_create_date not in", values, "rCreateDate");
            return (Criteria) this;
        }

        public Criteria andRCreateDateBetween(Date value1, Date value2) {
            addCriterion("r_create_date between", value1, value2, "rCreateDate");
            return (Criteria) this;
        }

        public Criteria andRCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("r_create_date not between", value1, value2, "rCreateDate");
            return (Criteria) this;
        }

        public Criteria andRRemarkIsNull() {
            addCriterion("r_remark is null");
            return (Criteria) this;
        }

        public Criteria andRRemarkIsNotNull() {
            addCriterion("r_remark is not null");
            return (Criteria) this;
        }

        public Criteria andRRemarkEqualTo(String value) {
            addCriterion("r_remark =", value, "rRemark");
            return (Criteria) this;
        }

        public Criteria andRRemarkNotEqualTo(String value) {
            addCriterion("r_remark <>", value, "rRemark");
            return (Criteria) this;
        }

        public Criteria andRRemarkGreaterThan(String value) {
            addCriterion("r_remark >", value, "rRemark");
            return (Criteria) this;
        }

        public Criteria andRRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("r_remark >=", value, "rRemark");
            return (Criteria) this;
        }

        public Criteria andRRemarkLessThan(String value) {
            addCriterion("r_remark <", value, "rRemark");
            return (Criteria) this;
        }

        public Criteria andRRemarkLessThanOrEqualTo(String value) {
            addCriterion("r_remark <=", value, "rRemark");
            return (Criteria) this;
        }

        public Criteria andRRemarkLike(String value) {
            addCriterion("r_remark like", value, "rRemark");
            return (Criteria) this;
        }

        public Criteria andRRemarkNotLike(String value) {
            addCriterion("r_remark not like", value, "rRemark");
            return (Criteria) this;
        }

        public Criteria andRRemarkIn(List<String> values) {
            addCriterion("r_remark in", values, "rRemark");
            return (Criteria) this;
        }

        public Criteria andRRemarkNotIn(List<String> values) {
            addCriterion("r_remark not in", values, "rRemark");
            return (Criteria) this;
        }

        public Criteria andRRemarkBetween(String value1, String value2) {
            addCriterion("r_remark between", value1, value2, "rRemark");
            return (Criteria) this;
        }

        public Criteria andRRemarkNotBetween(String value1, String value2) {
            addCriterion("r_remark not between", value1, value2, "rRemark");
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
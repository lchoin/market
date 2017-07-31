package com.jzf.market.pojo.auto;

import java.util.ArrayList;
import java.util.List;

public class TbUserRoleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbUserRoleExample() {
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

        public Criteria andUrIdIsNull() {
            addCriterion("ur_id is null");
            return (Criteria) this;
        }

        public Criteria andUrIdIsNotNull() {
            addCriterion("ur_id is not null");
            return (Criteria) this;
        }

        public Criteria andUrIdEqualTo(Long value) {
            addCriterion("ur_id =", value, "urId");
            return (Criteria) this;
        }

        public Criteria andUrIdNotEqualTo(Long value) {
            addCriterion("ur_id <>", value, "urId");
            return (Criteria) this;
        }

        public Criteria andUrIdGreaterThan(Long value) {
            addCriterion("ur_id >", value, "urId");
            return (Criteria) this;
        }

        public Criteria andUrIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ur_id >=", value, "urId");
            return (Criteria) this;
        }

        public Criteria andUrIdLessThan(Long value) {
            addCriterion("ur_id <", value, "urId");
            return (Criteria) this;
        }

        public Criteria andUrIdLessThanOrEqualTo(Long value) {
            addCriterion("ur_id <=", value, "urId");
            return (Criteria) this;
        }

        public Criteria andUrIdIn(List<Long> values) {
            addCriterion("ur_id in", values, "urId");
            return (Criteria) this;
        }

        public Criteria andUrIdNotIn(List<Long> values) {
            addCriterion("ur_id not in", values, "urId");
            return (Criteria) this;
        }

        public Criteria andUrIdBetween(Long value1, Long value2) {
            addCriterion("ur_id between", value1, value2, "urId");
            return (Criteria) this;
        }

        public Criteria andUrIdNotBetween(Long value1, Long value2) {
            addCriterion("ur_id not between", value1, value2, "urId");
            return (Criteria) this;
        }

        public Criteria andUrRIdIsNull() {
            addCriterion("ur_r_id is null");
            return (Criteria) this;
        }

        public Criteria andUrRIdIsNotNull() {
            addCriterion("ur_r_id is not null");
            return (Criteria) this;
        }

        public Criteria andUrRIdEqualTo(Long value) {
            addCriterion("ur_r_id =", value, "urRId");
            return (Criteria) this;
        }

        public Criteria andUrRIdNotEqualTo(Long value) {
            addCriterion("ur_r_id <>", value, "urRId");
            return (Criteria) this;
        }

        public Criteria andUrRIdGreaterThan(Long value) {
            addCriterion("ur_r_id >", value, "urRId");
            return (Criteria) this;
        }

        public Criteria andUrRIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ur_r_id >=", value, "urRId");
            return (Criteria) this;
        }

        public Criteria andUrRIdLessThan(Long value) {
            addCriterion("ur_r_id <", value, "urRId");
            return (Criteria) this;
        }

        public Criteria andUrRIdLessThanOrEqualTo(Long value) {
            addCriterion("ur_r_id <=", value, "urRId");
            return (Criteria) this;
        }

        public Criteria andUrRIdIn(List<Long> values) {
            addCriterion("ur_r_id in", values, "urRId");
            return (Criteria) this;
        }

        public Criteria andUrRIdNotIn(List<Long> values) {
            addCriterion("ur_r_id not in", values, "urRId");
            return (Criteria) this;
        }

        public Criteria andUrRIdBetween(Long value1, Long value2) {
            addCriterion("ur_r_id between", value1, value2, "urRId");
            return (Criteria) this;
        }

        public Criteria andUrRIdNotBetween(Long value1, Long value2) {
            addCriterion("ur_r_id not between", value1, value2, "urRId");
            return (Criteria) this;
        }

        public Criteria andUrUIdIsNull() {
            addCriterion("ur_u_id is null");
            return (Criteria) this;
        }

        public Criteria andUrUIdIsNotNull() {
            addCriterion("ur_u_id is not null");
            return (Criteria) this;
        }

        public Criteria andUrUIdEqualTo(Long value) {
            addCriterion("ur_u_id =", value, "urUId");
            return (Criteria) this;
        }

        public Criteria andUrUIdNotEqualTo(Long value) {
            addCriterion("ur_u_id <>", value, "urUId");
            return (Criteria) this;
        }

        public Criteria andUrUIdGreaterThan(Long value) {
            addCriterion("ur_u_id >", value, "urUId");
            return (Criteria) this;
        }

        public Criteria andUrUIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ur_u_id >=", value, "urUId");
            return (Criteria) this;
        }

        public Criteria andUrUIdLessThan(Long value) {
            addCriterion("ur_u_id <", value, "urUId");
            return (Criteria) this;
        }

        public Criteria andUrUIdLessThanOrEqualTo(Long value) {
            addCriterion("ur_u_id <=", value, "urUId");
            return (Criteria) this;
        }

        public Criteria andUrUIdIn(List<Long> values) {
            addCriterion("ur_u_id in", values, "urUId");
            return (Criteria) this;
        }

        public Criteria andUrUIdNotIn(List<Long> values) {
            addCriterion("ur_u_id not in", values, "urUId");
            return (Criteria) this;
        }

        public Criteria andUrUIdBetween(Long value1, Long value2) {
            addCriterion("ur_u_id between", value1, value2, "urUId");
            return (Criteria) this;
        }

        public Criteria andUrUIdNotBetween(Long value1, Long value2) {
            addCriterion("ur_u_id not between", value1, value2, "urUId");
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
package com.woniuxy.domain;

import java.util.ArrayList;
import java.util.List;

public class ApplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ApplyExample() {
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

        public Criteria andApidIsNull() {
            addCriterion("apid is null");
            return (Criteria) this;
        }

        public Criteria andApidIsNotNull() {
            addCriterion("apid is not null");
            return (Criteria) this;
        }

        public Criteria andApidEqualTo(Integer value) {
            addCriterion("apid =", value, "apid");
            return (Criteria) this;
        }

        public Criteria andApidNotEqualTo(Integer value) {
            addCriterion("apid <>", value, "apid");
            return (Criteria) this;
        }

        public Criteria andApidGreaterThan(Integer value) {
            addCriterion("apid >", value, "apid");
            return (Criteria) this;
        }

        public Criteria andApidGreaterThanOrEqualTo(Integer value) {
            addCriterion("apid >=", value, "apid");
            return (Criteria) this;
        }

        public Criteria andApidLessThan(Integer value) {
            addCriterion("apid <", value, "apid");
            return (Criteria) this;
        }

        public Criteria andApidLessThanOrEqualTo(Integer value) {
            addCriterion("apid <=", value, "apid");
            return (Criteria) this;
        }

        public Criteria andApidIn(List<Integer> values) {
            addCriterion("apid in", values, "apid");
            return (Criteria) this;
        }

        public Criteria andApidNotIn(List<Integer> values) {
            addCriterion("apid not in", values, "apid");
            return (Criteria) this;
        }

        public Criteria andApidBetween(Integer value1, Integer value2) {
            addCriterion("apid between", value1, value2, "apid");
            return (Criteria) this;
        }

        public Criteria andApidNotBetween(Integer value1, Integer value2) {
            addCriterion("apid not between", value1, value2, "apid");
            return (Criteria) this;
        }

        public Criteria andApbusiIsNull() {
            addCriterion("apbusi is null");
            return (Criteria) this;
        }

        public Criteria andApbusiIsNotNull() {
            addCriterion("apbusi is not null");
            return (Criteria) this;
        }

        public Criteria andApbusiEqualTo(Integer value) {
            addCriterion("apbusi =", value, "apbusi");
            return (Criteria) this;
        }

        public Criteria andApbusiNotEqualTo(Integer value) {
            addCriterion("apbusi <>", value, "apbusi");
            return (Criteria) this;
        }

        public Criteria andApbusiGreaterThan(Integer value) {
            addCriterion("apbusi >", value, "apbusi");
            return (Criteria) this;
        }

        public Criteria andApbusiGreaterThanOrEqualTo(Integer value) {
            addCriterion("apbusi >=", value, "apbusi");
            return (Criteria) this;
        }

        public Criteria andApbusiLessThan(Integer value) {
            addCriterion("apbusi <", value, "apbusi");
            return (Criteria) this;
        }

        public Criteria andApbusiLessThanOrEqualTo(Integer value) {
            addCriterion("apbusi <=", value, "apbusi");
            return (Criteria) this;
        }

        public Criteria andApbusiIn(List<Integer> values) {
            addCriterion("apbusi in", values, "apbusi");
            return (Criteria) this;
        }

        public Criteria andApbusiNotIn(List<Integer> values) {
            addCriterion("apbusi not in", values, "apbusi");
            return (Criteria) this;
        }

        public Criteria andApbusiBetween(Integer value1, Integer value2) {
            addCriterion("apbusi between", value1, value2, "apbusi");
            return (Criteria) this;
        }

        public Criteria andApbusiNotBetween(Integer value1, Integer value2) {
            addCriterion("apbusi not between", value1, value2, "apbusi");
            return (Criteria) this;
        }

        public Criteria andApinfoIsNull() {
            addCriterion("apinfo is null");
            return (Criteria) this;
        }

        public Criteria andApinfoIsNotNull() {
            addCriterion("apinfo is not null");
            return (Criteria) this;
        }

        public Criteria andApinfoEqualTo(String value) {
            addCriterion("apinfo =", value, "apinfo");
            return (Criteria) this;
        }

        public Criteria andApinfoNotEqualTo(String value) {
            addCriterion("apinfo <>", value, "apinfo");
            return (Criteria) this;
        }

        public Criteria andApinfoGreaterThan(String value) {
            addCriterion("apinfo >", value, "apinfo");
            return (Criteria) this;
        }

        public Criteria andApinfoGreaterThanOrEqualTo(String value) {
            addCriterion("apinfo >=", value, "apinfo");
            return (Criteria) this;
        }

        public Criteria andApinfoLessThan(String value) {
            addCriterion("apinfo <", value, "apinfo");
            return (Criteria) this;
        }

        public Criteria andApinfoLessThanOrEqualTo(String value) {
            addCriterion("apinfo <=", value, "apinfo");
            return (Criteria) this;
        }

        public Criteria andApinfoLike(String value) {
            addCriterion("apinfo like", value, "apinfo");
            return (Criteria) this;
        }

        public Criteria andApinfoNotLike(String value) {
            addCriterion("apinfo not like", value, "apinfo");
            return (Criteria) this;
        }

        public Criteria andApinfoIn(List<String> values) {
            addCriterion("apinfo in", values, "apinfo");
            return (Criteria) this;
        }

        public Criteria andApinfoNotIn(List<String> values) {
            addCriterion("apinfo not in", values, "apinfo");
            return (Criteria) this;
        }

        public Criteria andApinfoBetween(String value1, String value2) {
            addCriterion("apinfo between", value1, value2, "apinfo");
            return (Criteria) this;
        }

        public Criteria andApinfoNotBetween(String value1, String value2) {
            addCriterion("apinfo not between", value1, value2, "apinfo");
            return (Criteria) this;
        }

        public Criteria andApstateIsNull() {
            addCriterion("apstate is null");
            return (Criteria) this;
        }

        public Criteria andApstateIsNotNull() {
            addCriterion("apstate is not null");
            return (Criteria) this;
        }

        public Criteria andApstateEqualTo(Integer value) {
            addCriterion("apstate =", value, "apstate");
            return (Criteria) this;
        }

        public Criteria andApstateNotEqualTo(Integer value) {
            addCriterion("apstate <>", value, "apstate");
            return (Criteria) this;
        }

        public Criteria andApstateGreaterThan(Integer value) {
            addCriterion("apstate >", value, "apstate");
            return (Criteria) this;
        }

        public Criteria andApstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("apstate >=", value, "apstate");
            return (Criteria) this;
        }

        public Criteria andApstateLessThan(Integer value) {
            addCriterion("apstate <", value, "apstate");
            return (Criteria) this;
        }

        public Criteria andApstateLessThanOrEqualTo(Integer value) {
            addCriterion("apstate <=", value, "apstate");
            return (Criteria) this;
        }

        public Criteria andApstateIn(List<Integer> values) {
            addCriterion("apstate in", values, "apstate");
            return (Criteria) this;
        }

        public Criteria andApstateNotIn(List<Integer> values) {
            addCriterion("apstate not in", values, "apstate");
            return (Criteria) this;
        }

        public Criteria andApstateBetween(Integer value1, Integer value2) {
            addCriterion("apstate between", value1, value2, "apstate");
            return (Criteria) this;
        }

        public Criteria andApstateNotBetween(Integer value1, Integer value2) {
            addCriterion("apstate not between", value1, value2, "apstate");
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
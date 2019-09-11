package com.woniuxy.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LogExample() {
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

        public Criteria andLigIsNull() {
            addCriterion("lig is null");
            return (Criteria) this;
        }

        public Criteria andLigIsNotNull() {
            addCriterion("lig is not null");
            return (Criteria) this;
        }

        public Criteria andLigEqualTo(Integer value) {
            addCriterion("lig =", value, "lig");
            return (Criteria) this;
        }

        public Criteria andLigNotEqualTo(Integer value) {
            addCriterion("lig <>", value, "lig");
            return (Criteria) this;
        }

        public Criteria andLigGreaterThan(Integer value) {
            addCriterion("lig >", value, "lig");
            return (Criteria) this;
        }

        public Criteria andLigGreaterThanOrEqualTo(Integer value) {
            addCriterion("lig >=", value, "lig");
            return (Criteria) this;
        }

        public Criteria andLigLessThan(Integer value) {
            addCriterion("lig <", value, "lig");
            return (Criteria) this;
        }

        public Criteria andLigLessThanOrEqualTo(Integer value) {
            addCriterion("lig <=", value, "lig");
            return (Criteria) this;
        }

        public Criteria andLigIn(List<Integer> values) {
            addCriterion("lig in", values, "lig");
            return (Criteria) this;
        }

        public Criteria andLigNotIn(List<Integer> values) {
            addCriterion("lig not in", values, "lig");
            return (Criteria) this;
        }

        public Criteria andLigBetween(Integer value1, Integer value2) {
            addCriterion("lig between", value1, value2, "lig");
            return (Criteria) this;
        }

        public Criteria andLigNotBetween(Integer value1, Integer value2) {
            addCriterion("lig not between", value1, value2, "lig");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andLtimeIsNull() {
            addCriterion("ltime is null");
            return (Criteria) this;
        }

        public Criteria andLtimeIsNotNull() {
            addCriterion("ltime is not null");
            return (Criteria) this;
        }

        public Criteria andLtimeEqualTo(Date value) {
            addCriterion("ltime =", value, "ltime");
            return (Criteria) this;
        }

        public Criteria andLtimeNotEqualTo(Date value) {
            addCriterion("ltime <>", value, "ltime");
            return (Criteria) this;
        }

        public Criteria andLtimeGreaterThan(Date value) {
            addCriterion("ltime >", value, "ltime");
            return (Criteria) this;
        }

        public Criteria andLtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ltime >=", value, "ltime");
            return (Criteria) this;
        }

        public Criteria andLtimeLessThan(Date value) {
            addCriterion("ltime <", value, "ltime");
            return (Criteria) this;
        }

        public Criteria andLtimeLessThanOrEqualTo(Date value) {
            addCriterion("ltime <=", value, "ltime");
            return (Criteria) this;
        }

        public Criteria andLtimeIn(List<Date> values) {
            addCriterion("ltime in", values, "ltime");
            return (Criteria) this;
        }

        public Criteria andLtimeNotIn(List<Date> values) {
            addCriterion("ltime not in", values, "ltime");
            return (Criteria) this;
        }

        public Criteria andLtimeBetween(Date value1, Date value2) {
            addCriterion("ltime between", value1, value2, "ltime");
            return (Criteria) this;
        }

        public Criteria andLtimeNotBetween(Date value1, Date value2) {
            addCriterion("ltime not between", value1, value2, "ltime");
            return (Criteria) this;
        }

        public Criteria andLoptionIsNull() {
            addCriterion("loption is null");
            return (Criteria) this;
        }

        public Criteria andLoptionIsNotNull() {
            addCriterion("loption is not null");
            return (Criteria) this;
        }

        public Criteria andLoptionEqualTo(String value) {
            addCriterion("loption =", value, "loption");
            return (Criteria) this;
        }

        public Criteria andLoptionNotEqualTo(String value) {
            addCriterion("loption <>", value, "loption");
            return (Criteria) this;
        }

        public Criteria andLoptionGreaterThan(String value) {
            addCriterion("loption >", value, "loption");
            return (Criteria) this;
        }

        public Criteria andLoptionGreaterThanOrEqualTo(String value) {
            addCriterion("loption >=", value, "loption");
            return (Criteria) this;
        }

        public Criteria andLoptionLessThan(String value) {
            addCriterion("loption <", value, "loption");
            return (Criteria) this;
        }

        public Criteria andLoptionLessThanOrEqualTo(String value) {
            addCriterion("loption <=", value, "loption");
            return (Criteria) this;
        }

        public Criteria andLoptionLike(String value) {
            addCriterion("loption like", value, "loption");
            return (Criteria) this;
        }

        public Criteria andLoptionNotLike(String value) {
            addCriterion("loption not like", value, "loption");
            return (Criteria) this;
        }

        public Criteria andLoptionIn(List<String> values) {
            addCriterion("loption in", values, "loption");
            return (Criteria) this;
        }

        public Criteria andLoptionNotIn(List<String> values) {
            addCriterion("loption not in", values, "loption");
            return (Criteria) this;
        }

        public Criteria andLoptionBetween(String value1, String value2) {
            addCriterion("loption between", value1, value2, "loption");
            return (Criteria) this;
        }

        public Criteria andLoptionNotBetween(String value1, String value2) {
            addCriterion("loption not between", value1, value2, "loption");
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
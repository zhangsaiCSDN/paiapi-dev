package com.woniuxy.domain;

import java.util.ArrayList;
import java.util.List;

public class CardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CardExample() {
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

        public Criteria andCidIsNull() {
            addCriterion("cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(Integer value) {
            addCriterion("cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(Integer value) {
            addCriterion("cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(Integer value) {
            addCriterion("cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(Integer value) {
            addCriterion("cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(Integer value) {
            addCriterion("cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<Integer> values) {
            addCriterion("cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<Integer> values) {
            addCriterion("cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(Integer value1, Integer value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(Integer value1, Integer value2) {
            addCriterion("cid not between", value1, value2, "cid");
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

        public Criteria andCfrontIsNull() {
            addCriterion("cfront is null");
            return (Criteria) this;
        }

        public Criteria andCfrontIsNotNull() {
            addCriterion("cfront is not null");
            return (Criteria) this;
        }

        public Criteria andCfrontEqualTo(String value) {
            addCriterion("cfront =", value, "cfront");
            return (Criteria) this;
        }

        public Criteria andCfrontNotEqualTo(String value) {
            addCriterion("cfront <>", value, "cfront");
            return (Criteria) this;
        }

        public Criteria andCfrontGreaterThan(String value) {
            addCriterion("cfront >", value, "cfront");
            return (Criteria) this;
        }

        public Criteria andCfrontGreaterThanOrEqualTo(String value) {
            addCriterion("cfront >=", value, "cfront");
            return (Criteria) this;
        }

        public Criteria andCfrontLessThan(String value) {
            addCriterion("cfront <", value, "cfront");
            return (Criteria) this;
        }

        public Criteria andCfrontLessThanOrEqualTo(String value) {
            addCriterion("cfront <=", value, "cfront");
            return (Criteria) this;
        }

        public Criteria andCfrontLike(String value) {
            addCriterion("cfront like", value, "cfront");
            return (Criteria) this;
        }

        public Criteria andCfrontNotLike(String value) {
            addCriterion("cfront not like", value, "cfront");
            return (Criteria) this;
        }

        public Criteria andCfrontIn(List<String> values) {
            addCriterion("cfront in", values, "cfront");
            return (Criteria) this;
        }

        public Criteria andCfrontNotIn(List<String> values) {
            addCriterion("cfront not in", values, "cfront");
            return (Criteria) this;
        }

        public Criteria andCfrontBetween(String value1, String value2) {
            addCriterion("cfront between", value1, value2, "cfront");
            return (Criteria) this;
        }

        public Criteria andCfrontNotBetween(String value1, String value2) {
            addCriterion("cfront not between", value1, value2, "cfront");
            return (Criteria) this;
        }

        public Criteria andCbackIsNull() {
            addCriterion("cback is null");
            return (Criteria) this;
        }

        public Criteria andCbackIsNotNull() {
            addCriterion("cback is not null");
            return (Criteria) this;
        }

        public Criteria andCbackEqualTo(String value) {
            addCriterion("cback =", value, "cback");
            return (Criteria) this;
        }

        public Criteria andCbackNotEqualTo(String value) {
            addCriterion("cback <>", value, "cback");
            return (Criteria) this;
        }

        public Criteria andCbackGreaterThan(String value) {
            addCriterion("cback >", value, "cback");
            return (Criteria) this;
        }

        public Criteria andCbackGreaterThanOrEqualTo(String value) {
            addCriterion("cback >=", value, "cback");
            return (Criteria) this;
        }

        public Criteria andCbackLessThan(String value) {
            addCriterion("cback <", value, "cback");
            return (Criteria) this;
        }

        public Criteria andCbackLessThanOrEqualTo(String value) {
            addCriterion("cback <=", value, "cback");
            return (Criteria) this;
        }

        public Criteria andCbackLike(String value) {
            addCriterion("cback like", value, "cback");
            return (Criteria) this;
        }

        public Criteria andCbackNotLike(String value) {
            addCriterion("cback not like", value, "cback");
            return (Criteria) this;
        }

        public Criteria andCbackIn(List<String> values) {
            addCriterion("cback in", values, "cback");
            return (Criteria) this;
        }

        public Criteria andCbackNotIn(List<String> values) {
            addCriterion("cback not in", values, "cback");
            return (Criteria) this;
        }

        public Criteria andCbackBetween(String value1, String value2) {
            addCriterion("cback between", value1, value2, "cback");
            return (Criteria) this;
        }

        public Criteria andCbackNotBetween(String value1, String value2) {
            addCriterion("cback not between", value1, value2, "cback");
            return (Criteria) this;
        }

        public Criteria andCstateIsNull() {
            addCriterion("cstate is null");
            return (Criteria) this;
        }

        public Criteria andCstateIsNotNull() {
            addCriterion("cstate is not null");
            return (Criteria) this;
        }

        public Criteria andCstateEqualTo(Integer value) {
            addCriterion("cstate =", value, "cstate");
            return (Criteria) this;
        }

        public Criteria andCstateNotEqualTo(Integer value) {
            addCriterion("cstate <>", value, "cstate");
            return (Criteria) this;
        }

        public Criteria andCstateGreaterThan(Integer value) {
            addCriterion("cstate >", value, "cstate");
            return (Criteria) this;
        }

        public Criteria andCstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("cstate >=", value, "cstate");
            return (Criteria) this;
        }

        public Criteria andCstateLessThan(Integer value) {
            addCriterion("cstate <", value, "cstate");
            return (Criteria) this;
        }

        public Criteria andCstateLessThanOrEqualTo(Integer value) {
            addCriterion("cstate <=", value, "cstate");
            return (Criteria) this;
        }

        public Criteria andCstateIn(List<Integer> values) {
            addCriterion("cstate in", values, "cstate");
            return (Criteria) this;
        }

        public Criteria andCstateNotIn(List<Integer> values) {
            addCriterion("cstate not in", values, "cstate");
            return (Criteria) this;
        }

        public Criteria andCstateBetween(Integer value1, Integer value2) {
            addCriterion("cstate between", value1, value2, "cstate");
            return (Criteria) this;
        }

        public Criteria andCstateNotBetween(Integer value1, Integer value2) {
            addCriterion("cstate not between", value1, value2, "cstate");
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
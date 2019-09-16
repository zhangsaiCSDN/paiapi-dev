package com.woniuxy.domain;

import java.util.ArrayList;
import java.util.List;

public class AddressExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AddressExample() {
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

        public Criteria andAidIsNull() {
            addCriterion("aid is null");
            return (Criteria) this;
        }

        public Criteria andAidIsNotNull() {
            addCriterion("aid is not null");
            return (Criteria) this;
        }

        public Criteria andAidEqualTo(Integer value) {
            addCriterion("aid =", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotEqualTo(Integer value) {
            addCriterion("aid <>", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThan(Integer value) {
            addCriterion("aid >", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThanOrEqualTo(Integer value) {
            addCriterion("aid >=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThan(Integer value) {
            addCriterion("aid <", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThanOrEqualTo(Integer value) {
            addCriterion("aid <=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidIn(List<Integer> values) {
            addCriterion("aid in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotIn(List<Integer> values) {
            addCriterion("aid not in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidBetween(Integer value1, Integer value2) {
            addCriterion("aid between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotBetween(Integer value1, Integer value2) {
            addCriterion("aid not between", value1, value2, "aid");
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

        public Criteria andAinfoIsNull() {
            addCriterion("ainfo is null");
            return (Criteria) this;
        }

        public Criteria andAinfoIsNotNull() {
            addCriterion("ainfo is not null");
            return (Criteria) this;
        }

        public Criteria andAinfoEqualTo(String value) {
            addCriterion("ainfo =", value, "ainfo");
            return (Criteria) this;
        }

        public Criteria andAinfoNotEqualTo(String value) {
            addCriterion("ainfo <>", value, "ainfo");
            return (Criteria) this;
        }

        public Criteria andAinfoGreaterThan(String value) {
            addCriterion("ainfo >", value, "ainfo");
            return (Criteria) this;
        }

        public Criteria andAinfoGreaterThanOrEqualTo(String value) {
            addCriterion("ainfo >=", value, "ainfo");
            return (Criteria) this;
        }

        public Criteria andAinfoLessThan(String value) {
            addCriterion("ainfo <", value, "ainfo");
            return (Criteria) this;
        }

        public Criteria andAinfoLessThanOrEqualTo(String value) {
            addCriterion("ainfo <=", value, "ainfo");
            return (Criteria) this;
        }

        public Criteria andAinfoLike(String value) {
            addCriterion("ainfo like", value, "ainfo");
            return (Criteria) this;
        }

        public Criteria andAinfoNotLike(String value) {
            addCriterion("ainfo not like", value, "ainfo");
            return (Criteria) this;
        }

        public Criteria andAinfoIn(List<String> values) {
            addCriterion("ainfo in", values, "ainfo");
            return (Criteria) this;
        }

        public Criteria andAinfoNotIn(List<String> values) {
            addCriterion("ainfo not in", values, "ainfo");
            return (Criteria) this;
        }

        public Criteria andAinfoBetween(String value1, String value2) {
            addCriterion("ainfo between", value1, value2, "ainfo");
            return (Criteria) this;
        }

        public Criteria andAinfoNotBetween(String value1, String value2) {
            addCriterion("ainfo not between", value1, value2, "ainfo");
            return (Criteria) this;
        }

        public Criteria andApostIsNull() {
            addCriterion("apost is null");
            return (Criteria) this;
        }

        public Criteria andApostIsNotNull() {
            addCriterion("apost is not null");
            return (Criteria) this;
        }

        public Criteria andApostEqualTo(String value) {
            addCriterion("apost =", value, "apost");
            return (Criteria) this;
        }

        public Criteria andApostNotEqualTo(String value) {
            addCriterion("apost <>", value, "apost");
            return (Criteria) this;
        }

        public Criteria andApostGreaterThan(String value) {
            addCriterion("apost >", value, "apost");
            return (Criteria) this;
        }

        public Criteria andApostGreaterThanOrEqualTo(String value) {
            addCriterion("apost >=", value, "apost");
            return (Criteria) this;
        }

        public Criteria andApostLessThan(String value) {
            addCriterion("apost <", value, "apost");
            return (Criteria) this;
        }

        public Criteria andApostLessThanOrEqualTo(String value) {
            addCriterion("apost <=", value, "apost");
            return (Criteria) this;
        }

        public Criteria andApostLike(String value) {
            addCriterion("apost like", value, "apost");
            return (Criteria) this;
        }

        public Criteria andApostNotLike(String value) {
            addCriterion("apost not like", value, "apost");
            return (Criteria) this;
        }

        public Criteria andApostIn(List<String> values) {
            addCriterion("apost in", values, "apost");
            return (Criteria) this;
        }

        public Criteria andApostNotIn(List<String> values) {
            addCriterion("apost not in", values, "apost");
            return (Criteria) this;
        }

        public Criteria andApostBetween(String value1, String value2) {
            addCriterion("apost between", value1, value2, "apost");
            return (Criteria) this;
        }

        public Criteria andApostNotBetween(String value1, String value2) {
            addCriterion("apost not between", value1, value2, "apost");
            return (Criteria) this;
        }

        public Criteria andAphoneIsNull() {
            addCriterion("aphone is null");
            return (Criteria) this;
        }

        public Criteria andAphoneIsNotNull() {
            addCriterion("aphone is not null");
            return (Criteria) this;
        }

        public Criteria andAphoneEqualTo(String value) {
            addCriterion("aphone =", value, "aphone");
            return (Criteria) this;
        }

        public Criteria andAphoneNotEqualTo(String value) {
            addCriterion("aphone <>", value, "aphone");
            return (Criteria) this;
        }

        public Criteria andAphoneGreaterThan(String value) {
            addCriterion("aphone >", value, "aphone");
            return (Criteria) this;
        }

        public Criteria andAphoneGreaterThanOrEqualTo(String value) {
            addCriterion("aphone >=", value, "aphone");
            return (Criteria) this;
        }

        public Criteria andAphoneLessThan(String value) {
            addCriterion("aphone <", value, "aphone");
            return (Criteria) this;
        }

        public Criteria andAphoneLessThanOrEqualTo(String value) {
            addCriterion("aphone <=", value, "aphone");
            return (Criteria) this;
        }

        public Criteria andAphoneLike(String value) {
            addCriterion("aphone like", value, "aphone");
            return (Criteria) this;
        }

        public Criteria andAphoneNotLike(String value) {
            addCriterion("aphone not like", value, "aphone");
            return (Criteria) this;
        }

        public Criteria andAphoneIn(List<String> values) {
            addCriterion("aphone in", values, "aphone");
            return (Criteria) this;
        }

        public Criteria andAphoneNotIn(List<String> values) {
            addCriterion("aphone not in", values, "aphone");
            return (Criteria) this;
        }

        public Criteria andAphoneBetween(String value1, String value2) {
            addCriterion("aphone between", value1, value2, "aphone");
            return (Criteria) this;
        }

        public Criteria andAphoneNotBetween(String value1, String value2) {
            addCriterion("aphone not between", value1, value2, "aphone");
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
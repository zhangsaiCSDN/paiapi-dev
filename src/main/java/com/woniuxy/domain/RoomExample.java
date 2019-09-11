package com.woniuxy.domain;

import java.util.ArrayList;
import java.util.List;

public class RoomExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoomExample() {
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

        public Criteria andRmidIsNull() {
            addCriterion("rmid is null");
            return (Criteria) this;
        }

        public Criteria andRmidIsNotNull() {
            addCriterion("rmid is not null");
            return (Criteria) this;
        }

        public Criteria andRmidEqualTo(Integer value) {
            addCriterion("rmid =", value, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidNotEqualTo(Integer value) {
            addCriterion("rmid <>", value, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidGreaterThan(Integer value) {
            addCriterion("rmid >", value, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidGreaterThanOrEqualTo(Integer value) {
            addCriterion("rmid >=", value, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidLessThan(Integer value) {
            addCriterion("rmid <", value, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidLessThanOrEqualTo(Integer value) {
            addCriterion("rmid <=", value, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidIn(List<Integer> values) {
            addCriterion("rmid in", values, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidNotIn(List<Integer> values) {
            addCriterion("rmid not in", values, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidBetween(Integer value1, Integer value2) {
            addCriterion("rmid between", value1, value2, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidNotBetween(Integer value1, Integer value2) {
            addCriterion("rmid not between", value1, value2, "rmid");
            return (Criteria) this;
        }

        public Criteria andGidIsNull() {
            addCriterion("gid is null");
            return (Criteria) this;
        }

        public Criteria andGidIsNotNull() {
            addCriterion("gid is not null");
            return (Criteria) this;
        }

        public Criteria andGidEqualTo(Integer value) {
            addCriterion("gid =", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotEqualTo(Integer value) {
            addCriterion("gid <>", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThan(Integer value) {
            addCriterion("gid >", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThanOrEqualTo(Integer value) {
            addCriterion("gid >=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThan(Integer value) {
            addCriterion("gid <", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThanOrEqualTo(Integer value) {
            addCriterion("gid <=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidIn(List<Integer> values) {
            addCriterion("gid in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotIn(List<Integer> values) {
            addCriterion("gid not in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidBetween(Integer value1, Integer value2) {
            addCriterion("gid between", value1, value2, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotBetween(Integer value1, Integer value2) {
            addCriterion("gid not between", value1, value2, "gid");
            return (Criteria) this;
        }

        public Criteria andSaleridIsNull() {
            addCriterion("salerid is null");
            return (Criteria) this;
        }

        public Criteria andSaleridIsNotNull() {
            addCriterion("salerid is not null");
            return (Criteria) this;
        }

        public Criteria andSaleridEqualTo(Integer value) {
            addCriterion("salerid =", value, "salerid");
            return (Criteria) this;
        }

        public Criteria andSaleridNotEqualTo(Integer value) {
            addCriterion("salerid <>", value, "salerid");
            return (Criteria) this;
        }

        public Criteria andSaleridGreaterThan(Integer value) {
            addCriterion("salerid >", value, "salerid");
            return (Criteria) this;
        }

        public Criteria andSaleridGreaterThanOrEqualTo(Integer value) {
            addCriterion("salerid >=", value, "salerid");
            return (Criteria) this;
        }

        public Criteria andSaleridLessThan(Integer value) {
            addCriterion("salerid <", value, "salerid");
            return (Criteria) this;
        }

        public Criteria andSaleridLessThanOrEqualTo(Integer value) {
            addCriterion("salerid <=", value, "salerid");
            return (Criteria) this;
        }

        public Criteria andSaleridIn(List<Integer> values) {
            addCriterion("salerid in", values, "salerid");
            return (Criteria) this;
        }

        public Criteria andSaleridNotIn(List<Integer> values) {
            addCriterion("salerid not in", values, "salerid");
            return (Criteria) this;
        }

        public Criteria andSaleridBetween(Integer value1, Integer value2) {
            addCriterion("salerid between", value1, value2, "salerid");
            return (Criteria) this;
        }

        public Criteria andSaleridNotBetween(Integer value1, Integer value2) {
            addCriterion("salerid not between", value1, value2, "salerid");
            return (Criteria) this;
        }

        public Criteria andRmtitleIsNull() {
            addCriterion("rmtitle is null");
            return (Criteria) this;
        }

        public Criteria andRmtitleIsNotNull() {
            addCriterion("rmtitle is not null");
            return (Criteria) this;
        }

        public Criteria andRmtitleEqualTo(String value) {
            addCriterion("rmtitle =", value, "rmtitle");
            return (Criteria) this;
        }

        public Criteria andRmtitleNotEqualTo(String value) {
            addCriterion("rmtitle <>", value, "rmtitle");
            return (Criteria) this;
        }

        public Criteria andRmtitleGreaterThan(String value) {
            addCriterion("rmtitle >", value, "rmtitle");
            return (Criteria) this;
        }

        public Criteria andRmtitleGreaterThanOrEqualTo(String value) {
            addCriterion("rmtitle >=", value, "rmtitle");
            return (Criteria) this;
        }

        public Criteria andRmtitleLessThan(String value) {
            addCriterion("rmtitle <", value, "rmtitle");
            return (Criteria) this;
        }

        public Criteria andRmtitleLessThanOrEqualTo(String value) {
            addCriterion("rmtitle <=", value, "rmtitle");
            return (Criteria) this;
        }

        public Criteria andRmtitleLike(String value) {
            addCriterion("rmtitle like", value, "rmtitle");
            return (Criteria) this;
        }

        public Criteria andRmtitleNotLike(String value) {
            addCriterion("rmtitle not like", value, "rmtitle");
            return (Criteria) this;
        }

        public Criteria andRmtitleIn(List<String> values) {
            addCriterion("rmtitle in", values, "rmtitle");
            return (Criteria) this;
        }

        public Criteria andRmtitleNotIn(List<String> values) {
            addCriterion("rmtitle not in", values, "rmtitle");
            return (Criteria) this;
        }

        public Criteria andRmtitleBetween(String value1, String value2) {
            addCriterion("rmtitle between", value1, value2, "rmtitle");
            return (Criteria) this;
        }

        public Criteria andRmtitleNotBetween(String value1, String value2) {
            addCriterion("rmtitle not between", value1, value2, "rmtitle");
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
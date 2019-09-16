package com.woniuxy.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrdersExample() {
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

        public Criteria andOdidIsNull() {
            addCriterion("odid is null");
            return (Criteria) this;
        }

        public Criteria andOdidIsNotNull() {
            addCriterion("odid is not null");
            return (Criteria) this;
        }

        public Criteria andOdidEqualTo(Integer value) {
            addCriterion("odid =", value, "odid");
            return (Criteria) this;
        }

        public Criteria andOdidNotEqualTo(Integer value) {
            addCriterion("odid <>", value, "odid");
            return (Criteria) this;
        }

        public Criteria andOdidGreaterThan(Integer value) {
            addCriterion("odid >", value, "odid");
            return (Criteria) this;
        }

        public Criteria andOdidGreaterThanOrEqualTo(Integer value) {
            addCriterion("odid >=", value, "odid");
            return (Criteria) this;
        }

        public Criteria andOdidLessThan(Integer value) {
            addCriterion("odid <", value, "odid");
            return (Criteria) this;
        }

        public Criteria andOdidLessThanOrEqualTo(Integer value) {
            addCriterion("odid <=", value, "odid");
            return (Criteria) this;
        }

        public Criteria andOdidIn(List<Integer> values) {
            addCriterion("odid in", values, "odid");
            return (Criteria) this;
        }

        public Criteria andOdidNotIn(List<Integer> values) {
            addCriterion("odid not in", values, "odid");
            return (Criteria) this;
        }

        public Criteria andOdidBetween(Integer value1, Integer value2) {
            addCriterion("odid between", value1, value2, "odid");
            return (Criteria) this;
        }

        public Criteria andOdidNotBetween(Integer value1, Integer value2) {
            addCriterion("odid not between", value1, value2, "odid");
            return (Criteria) this;
        }

        public Criteria andOdmoneyIsNull() {
            addCriterion("odmoney is null");
            return (Criteria) this;
        }

        public Criteria andOdmoneyIsNotNull() {
            addCriterion("odmoney is not null");
            return (Criteria) this;
        }

        public Criteria andOdmoneyEqualTo(Double value) {
            addCriterion("odmoney =", value, "odmoney");
            return (Criteria) this;
        }

        public Criteria andOdmoneyNotEqualTo(Double value) {
            addCriterion("odmoney <>", value, "odmoney");
            return (Criteria) this;
        }

        public Criteria andOdmoneyGreaterThan(Double value) {
            addCriterion("odmoney >", value, "odmoney");
            return (Criteria) this;
        }

        public Criteria andOdmoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("odmoney >=", value, "odmoney");
            return (Criteria) this;
        }

        public Criteria andOdmoneyLessThan(Double value) {
            addCriterion("odmoney <", value, "odmoney");
            return (Criteria) this;
        }

        public Criteria andOdmoneyLessThanOrEqualTo(Double value) {
            addCriterion("odmoney <=", value, "odmoney");
            return (Criteria) this;
        }

        public Criteria andOdmoneyIn(List<Double> values) {
            addCriterion("odmoney in", values, "odmoney");
            return (Criteria) this;
        }

        public Criteria andOdmoneyNotIn(List<Double> values) {
            addCriterion("odmoney not in", values, "odmoney");
            return (Criteria) this;
        }

        public Criteria andOdmoneyBetween(Double value1, Double value2) {
            addCriterion("odmoney between", value1, value2, "odmoney");
            return (Criteria) this;
        }

        public Criteria andOdmoneyNotBetween(Double value1, Double value2) {
            addCriterion("odmoney not between", value1, value2, "odmoney");
            return (Criteria) this;
        }

        public Criteria andOdtimeIsNull() {
            addCriterion("odtime is null");
            return (Criteria) this;
        }

        public Criteria andOdtimeIsNotNull() {
            addCriterion("odtime is not null");
            return (Criteria) this;
        }

        public Criteria andOdtimeEqualTo(Date value) {
            addCriterion("odtime =", value, "odtime");
            return (Criteria) this;
        }

        public Criteria andOdtimeNotEqualTo(Date value) {
            addCriterion("odtime <>", value, "odtime");
            return (Criteria) this;
        }

        public Criteria andOdtimeGreaterThan(Date value) {
            addCriterion("odtime >", value, "odtime");
            return (Criteria) this;
        }

        public Criteria andOdtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("odtime >=", value, "odtime");
            return (Criteria) this;
        }

        public Criteria andOdtimeLessThan(Date value) {
            addCriterion("odtime <", value, "odtime");
            return (Criteria) this;
        }

        public Criteria andOdtimeLessThanOrEqualTo(Date value) {
            addCriterion("odtime <=", value, "odtime");
            return (Criteria) this;
        }

        public Criteria andOdtimeIn(List<Date> values) {
            addCriterion("odtime in", values, "odtime");
            return (Criteria) this;
        }

        public Criteria andOdtimeNotIn(List<Date> values) {
            addCriterion("odtime not in", values, "odtime");
            return (Criteria) this;
        }

        public Criteria andOdtimeBetween(Date value1, Date value2) {
            addCriterion("odtime between", value1, value2, "odtime");
            return (Criteria) this;
        }

        public Criteria andOdtimeNotBetween(Date value1, Date value2) {
            addCriterion("odtime not between", value1, value2, "odtime");
            return (Criteria) this;
        }

        public Criteria andBuyeridIsNull() {
            addCriterion("buyerid is null");
            return (Criteria) this;
        }

        public Criteria andBuyeridIsNotNull() {
            addCriterion("buyerid is not null");
            return (Criteria) this;
        }

        public Criteria andBuyeridEqualTo(Integer value) {
            addCriterion("buyerid =", value, "buyerid");
            return (Criteria) this;
        }

        public Criteria andBuyeridNotEqualTo(Integer value) {
            addCriterion("buyerid <>", value, "buyerid");
            return (Criteria) this;
        }

        public Criteria andBuyeridGreaterThan(Integer value) {
            addCriterion("buyerid >", value, "buyerid");
            return (Criteria) this;
        }

        public Criteria andBuyeridGreaterThanOrEqualTo(Integer value) {
            addCriterion("buyerid >=", value, "buyerid");
            return (Criteria) this;
        }

        public Criteria andBuyeridLessThan(Integer value) {
            addCriterion("buyerid <", value, "buyerid");
            return (Criteria) this;
        }

        public Criteria andBuyeridLessThanOrEqualTo(Integer value) {
            addCriterion("buyerid <=", value, "buyerid");
            return (Criteria) this;
        }

        public Criteria andBuyeridIn(List<Integer> values) {
            addCriterion("buyerid in", values, "buyerid");
            return (Criteria) this;
        }

        public Criteria andBuyeridNotIn(List<Integer> values) {
            addCriterion("buyerid not in", values, "buyerid");
            return (Criteria) this;
        }

        public Criteria andBuyeridBetween(Integer value1, Integer value2) {
            addCriterion("buyerid between", value1, value2, "buyerid");
            return (Criteria) this;
        }

        public Criteria andBuyeridNotBetween(Integer value1, Integer value2) {
            addCriterion("buyerid not between", value1, value2, "buyerid");
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

        public Criteria andOdfeeIsNull() {
            addCriterion("odfee is null");
            return (Criteria) this;
        }

        public Criteria andOdfeeIsNotNull() {
            addCriterion("odfee is not null");
            return (Criteria) this;
        }

        public Criteria andOdfeeEqualTo(Double value) {
            addCriterion("odfee =", value, "odfee");
            return (Criteria) this;
        }

        public Criteria andOdfeeNotEqualTo(Double value) {
            addCriterion("odfee <>", value, "odfee");
            return (Criteria) this;
        }

        public Criteria andOdfeeGreaterThan(Double value) {
            addCriterion("odfee >", value, "odfee");
            return (Criteria) this;
        }

        public Criteria andOdfeeGreaterThanOrEqualTo(Double value) {
            addCriterion("odfee >=", value, "odfee");
            return (Criteria) this;
        }

        public Criteria andOdfeeLessThan(Double value) {
            addCriterion("odfee <", value, "odfee");
            return (Criteria) this;
        }

        public Criteria andOdfeeLessThanOrEqualTo(Double value) {
            addCriterion("odfee <=", value, "odfee");
            return (Criteria) this;
        }

        public Criteria andOdfeeIn(List<Double> values) {
            addCriterion("odfee in", values, "odfee");
            return (Criteria) this;
        }

        public Criteria andOdfeeNotIn(List<Double> values) {
            addCriterion("odfee not in", values, "odfee");
            return (Criteria) this;
        }

        public Criteria andOdfeeBetween(Double value1, Double value2) {
            addCriterion("odfee between", value1, value2, "odfee");
            return (Criteria) this;
        }

        public Criteria andOdfeeNotBetween(Double value1, Double value2) {
            addCriterion("odfee not between", value1, value2, "odfee");
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
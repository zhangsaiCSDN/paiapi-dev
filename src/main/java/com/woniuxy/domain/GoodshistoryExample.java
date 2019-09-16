package com.woniuxy.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodshistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodshistoryExample() {
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

        public Criteria andGhidIsNull() {
            addCriterion("ghid is null");
            return (Criteria) this;
        }

        public Criteria andGhidIsNotNull() {
            addCriterion("ghid is not null");
            return (Criteria) this;
        }

        public Criteria andGhidEqualTo(Integer value) {
            addCriterion("ghid =", value, "ghid");
            return (Criteria) this;
        }

        public Criteria andGhidNotEqualTo(Integer value) {
            addCriterion("ghid <>", value, "ghid");
            return (Criteria) this;
        }

        public Criteria andGhidGreaterThan(Integer value) {
            addCriterion("ghid >", value, "ghid");
            return (Criteria) this;
        }

        public Criteria andGhidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ghid >=", value, "ghid");
            return (Criteria) this;
        }

        public Criteria andGhidLessThan(Integer value) {
            addCriterion("ghid <", value, "ghid");
            return (Criteria) this;
        }

        public Criteria andGhidLessThanOrEqualTo(Integer value) {
            addCriterion("ghid <=", value, "ghid");
            return (Criteria) this;
        }

        public Criteria andGhidIn(List<Integer> values) {
            addCriterion("ghid in", values, "ghid");
            return (Criteria) this;
        }

        public Criteria andGhidNotIn(List<Integer> values) {
            addCriterion("ghid not in", values, "ghid");
            return (Criteria) this;
        }

        public Criteria andGhidBetween(Integer value1, Integer value2) {
            addCriterion("ghid between", value1, value2, "ghid");
            return (Criteria) this;
        }

        public Criteria andGhidNotBetween(Integer value1, Integer value2) {
            addCriterion("ghid not between", value1, value2, "ghid");
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

        public Criteria andGhmoneyIsNull() {
            addCriterion("ghmoney is null");
            return (Criteria) this;
        }

        public Criteria andGhmoneyIsNotNull() {
            addCriterion("ghmoney is not null");
            return (Criteria) this;
        }

        public Criteria andGhmoneyEqualTo(Double value) {
            addCriterion("ghmoney =", value, "ghmoney");
            return (Criteria) this;
        }

        public Criteria andGhmoneyNotEqualTo(Double value) {
            addCriterion("ghmoney <>", value, "ghmoney");
            return (Criteria) this;
        }

        public Criteria andGhmoneyGreaterThan(Double value) {
            addCriterion("ghmoney >", value, "ghmoney");
            return (Criteria) this;
        }

        public Criteria andGhmoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("ghmoney >=", value, "ghmoney");
            return (Criteria) this;
        }

        public Criteria andGhmoneyLessThan(Double value) {
            addCriterion("ghmoney <", value, "ghmoney");
            return (Criteria) this;
        }

        public Criteria andGhmoneyLessThanOrEqualTo(Double value) {
            addCriterion("ghmoney <=", value, "ghmoney");
            return (Criteria) this;
        }

        public Criteria andGhmoneyIn(List<Double> values) {
            addCriterion("ghmoney in", values, "ghmoney");
            return (Criteria) this;
        }

        public Criteria andGhmoneyNotIn(List<Double> values) {
            addCriterion("ghmoney not in", values, "ghmoney");
            return (Criteria) this;
        }

        public Criteria andGhmoneyBetween(Double value1, Double value2) {
            addCriterion("ghmoney between", value1, value2, "ghmoney");
            return (Criteria) this;
        }

        public Criteria andGhmoneyNotBetween(Double value1, Double value2) {
            addCriterion("ghmoney not between", value1, value2, "ghmoney");
            return (Criteria) this;
        }

        public Criteria andGhtimeIsNull() {
            addCriterion("ghtime is null");
            return (Criteria) this;
        }

        public Criteria andGhtimeIsNotNull() {
            addCriterion("ghtime is not null");
            return (Criteria) this;
        }

        public Criteria andGhtimeEqualTo(Date value) {
            addCriterion("ghtime =", value, "ghtime");
            return (Criteria) this;
        }

        public Criteria andGhtimeNotEqualTo(Date value) {
            addCriterion("ghtime <>", value, "ghtime");
            return (Criteria) this;
        }

        public Criteria andGhtimeGreaterThan(Date value) {
            addCriterion("ghtime >", value, "ghtime");
            return (Criteria) this;
        }

        public Criteria andGhtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ghtime >=", value, "ghtime");
            return (Criteria) this;
        }

        public Criteria andGhtimeLessThan(Date value) {
            addCriterion("ghtime <", value, "ghtime");
            return (Criteria) this;
        }

        public Criteria andGhtimeLessThanOrEqualTo(Date value) {
            addCriterion("ghtime <=", value, "ghtime");
            return (Criteria) this;
        }

        public Criteria andGhtimeIn(List<Date> values) {
            addCriterion("ghtime in", values, "ghtime");
            return (Criteria) this;
        }

        public Criteria andGhtimeNotIn(List<Date> values) {
            addCriterion("ghtime not in", values, "ghtime");
            return (Criteria) this;
        }

        public Criteria andGhtimeBetween(Date value1, Date value2) {
            addCriterion("ghtime between", value1, value2, "ghtime");
            return (Criteria) this;
        }

        public Criteria andGhtimeNotBetween(Date value1, Date value2) {
            addCriterion("ghtime not between", value1, value2, "ghtime");
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

        public Criteria andGhdesIsNull() {
            addCriterion("ghdes is null");
            return (Criteria) this;
        }

        public Criteria andGhdesIsNotNull() {
            addCriterion("ghdes is not null");
            return (Criteria) this;
        }

        public Criteria andGhdesEqualTo(String value) {
            addCriterion("ghdes =", value, "ghdes");
            return (Criteria) this;
        }

        public Criteria andGhdesNotEqualTo(String value) {
            addCriterion("ghdes <>", value, "ghdes");
            return (Criteria) this;
        }

        public Criteria andGhdesGreaterThan(String value) {
            addCriterion("ghdes >", value, "ghdes");
            return (Criteria) this;
        }

        public Criteria andGhdesGreaterThanOrEqualTo(String value) {
            addCriterion("ghdes >=", value, "ghdes");
            return (Criteria) this;
        }

        public Criteria andGhdesLessThan(String value) {
            addCriterion("ghdes <", value, "ghdes");
            return (Criteria) this;
        }

        public Criteria andGhdesLessThanOrEqualTo(String value) {
            addCriterion("ghdes <=", value, "ghdes");
            return (Criteria) this;
        }

        public Criteria andGhdesLike(String value) {
            addCriterion("ghdes like", value, "ghdes");
            return (Criteria) this;
        }

        public Criteria andGhdesNotLike(String value) {
            addCriterion("ghdes not like", value, "ghdes");
            return (Criteria) this;
        }

        public Criteria andGhdesIn(List<String> values) {
            addCriterion("ghdes in", values, "ghdes");
            return (Criteria) this;
        }

        public Criteria andGhdesNotIn(List<String> values) {
            addCriterion("ghdes not in", values, "ghdes");
            return (Criteria) this;
        }

        public Criteria andGhdesBetween(String value1, String value2) {
            addCriterion("ghdes between", value1, value2, "ghdes");
            return (Criteria) this;
        }

        public Criteria andGhdesNotBetween(String value1, String value2) {
            addCriterion("ghdes not between", value1, value2, "ghdes");
            return (Criteria) this;
        }

        public Criteria andGhdeadlineIsNull() {
            addCriterion("ghdeadline is null");
            return (Criteria) this;
        }

        public Criteria andGhdeadlineIsNotNull() {
            addCriterion("ghdeadline is not null");
            return (Criteria) this;
        }

        public Criteria andGhdeadlineEqualTo(Date value) {
            addCriterion("ghdeadline =", value, "ghdeadline");
            return (Criteria) this;
        }

        public Criteria andGhdeadlineNotEqualTo(Date value) {
            addCriterion("ghdeadline <>", value, "ghdeadline");
            return (Criteria) this;
        }

        public Criteria andGhdeadlineGreaterThan(Date value) {
            addCriterion("ghdeadline >", value, "ghdeadline");
            return (Criteria) this;
        }

        public Criteria andGhdeadlineGreaterThanOrEqualTo(Date value) {
            addCriterion("ghdeadline >=", value, "ghdeadline");
            return (Criteria) this;
        }

        public Criteria andGhdeadlineLessThan(Date value) {
            addCriterion("ghdeadline <", value, "ghdeadline");
            return (Criteria) this;
        }

        public Criteria andGhdeadlineLessThanOrEqualTo(Date value) {
            addCriterion("ghdeadline <=", value, "ghdeadline");
            return (Criteria) this;
        }

        public Criteria andGhdeadlineIn(List<Date> values) {
            addCriterion("ghdeadline in", values, "ghdeadline");
            return (Criteria) this;
        }

        public Criteria andGhdeadlineNotIn(List<Date> values) {
            addCriterion("ghdeadline not in", values, "ghdeadline");
            return (Criteria) this;
        }

        public Criteria andGhdeadlineBetween(Date value1, Date value2) {
            addCriterion("ghdeadline between", value1, value2, "ghdeadline");
            return (Criteria) this;
        }

        public Criteria andGhdeadlineNotBetween(Date value1, Date value2) {
            addCriterion("ghdeadline not between", value1, value2, "ghdeadline");
            return (Criteria) this;
        }

        public Criteria andPaystateIsNull() {
            addCriterion("paystate is null");
            return (Criteria) this;
        }

        public Criteria andPaystateIsNotNull() {
            addCriterion("paystate is not null");
            return (Criteria) this;
        }

        public Criteria andPaystateEqualTo(Integer value) {
            addCriterion("paystate =", value, "paystate");
            return (Criteria) this;
        }

        public Criteria andPaystateNotEqualTo(Integer value) {
            addCriterion("paystate <>", value, "paystate");
            return (Criteria) this;
        }

        public Criteria andPaystateGreaterThan(Integer value) {
            addCriterion("paystate >", value, "paystate");
            return (Criteria) this;
        }

        public Criteria andPaystateGreaterThanOrEqualTo(Integer value) {
            addCriterion("paystate >=", value, "paystate");
            return (Criteria) this;
        }

        public Criteria andPaystateLessThan(Integer value) {
            addCriterion("paystate <", value, "paystate");
            return (Criteria) this;
        }

        public Criteria andPaystateLessThanOrEqualTo(Integer value) {
            addCriterion("paystate <=", value, "paystate");
            return (Criteria) this;
        }

        public Criteria andPaystateIn(List<Integer> values) {
            addCriterion("paystate in", values, "paystate");
            return (Criteria) this;
        }

        public Criteria andPaystateNotIn(List<Integer> values) {
            addCriterion("paystate not in", values, "paystate");
            return (Criteria) this;
        }

        public Criteria andPaystateBetween(Integer value1, Integer value2) {
            addCriterion("paystate between", value1, value2, "paystate");
            return (Criteria) this;
        }

        public Criteria andPaystateNotBetween(Integer value1, Integer value2) {
            addCriterion("paystate not between", value1, value2, "paystate");
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
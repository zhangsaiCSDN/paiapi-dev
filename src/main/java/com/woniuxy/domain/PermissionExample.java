package com.woniuxy.domain;

import java.util.ArrayList;
import java.util.List;

public class PermissionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PermissionExample() {
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

        public Criteria andPmsidIsNull() {
            addCriterion("pmsid is null");
            return (Criteria) this;
        }

        public Criteria andPmsidIsNotNull() {
            addCriterion("pmsid is not null");
            return (Criteria) this;
        }

        public Criteria andPmsidEqualTo(Integer value) {
            addCriterion("pmsid =", value, "pmsid");
            return (Criteria) this;
        }

        public Criteria andPmsidNotEqualTo(Integer value) {
            addCriterion("pmsid <>", value, "pmsid");
            return (Criteria) this;
        }

        public Criteria andPmsidGreaterThan(Integer value) {
            addCriterion("pmsid >", value, "pmsid");
            return (Criteria) this;
        }

        public Criteria andPmsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("pmsid >=", value, "pmsid");
            return (Criteria) this;
        }

        public Criteria andPmsidLessThan(Integer value) {
            addCriterion("pmsid <", value, "pmsid");
            return (Criteria) this;
        }

        public Criteria andPmsidLessThanOrEqualTo(Integer value) {
            addCriterion("pmsid <=", value, "pmsid");
            return (Criteria) this;
        }

        public Criteria andPmsidIn(List<Integer> values) {
            addCriterion("pmsid in", values, "pmsid");
            return (Criteria) this;
        }

        public Criteria andPmsidNotIn(List<Integer> values) {
            addCriterion("pmsid not in", values, "pmsid");
            return (Criteria) this;
        }

        public Criteria andPmsidBetween(Integer value1, Integer value2) {
            addCriterion("pmsid between", value1, value2, "pmsid");
            return (Criteria) this;
        }

        public Criteria andPmsidNotBetween(Integer value1, Integer value2) {
            addCriterion("pmsid not between", value1, value2, "pmsid");
            return (Criteria) this;
        }

        public Criteria andPmsnameIsNull() {
            addCriterion("pmsname is null");
            return (Criteria) this;
        }

        public Criteria andPmsnameIsNotNull() {
            addCriterion("pmsname is not null");
            return (Criteria) this;
        }

        public Criteria andPmsnameEqualTo(String value) {
            addCriterion("pmsname =", value, "pmsname");
            return (Criteria) this;
        }

        public Criteria andPmsnameNotEqualTo(String value) {
            addCriterion("pmsname <>", value, "pmsname");
            return (Criteria) this;
        }

        public Criteria andPmsnameGreaterThan(String value) {
            addCriterion("pmsname >", value, "pmsname");
            return (Criteria) this;
        }

        public Criteria andPmsnameGreaterThanOrEqualTo(String value) {
            addCriterion("pmsname >=", value, "pmsname");
            return (Criteria) this;
        }

        public Criteria andPmsnameLessThan(String value) {
            addCriterion("pmsname <", value, "pmsname");
            return (Criteria) this;
        }

        public Criteria andPmsnameLessThanOrEqualTo(String value) {
            addCriterion("pmsname <=", value, "pmsname");
            return (Criteria) this;
        }

        public Criteria andPmsnameLike(String value) {
            addCriterion("pmsname like", value, "pmsname");
            return (Criteria) this;
        }

        public Criteria andPmsnameNotLike(String value) {
            addCriterion("pmsname not like", value, "pmsname");
            return (Criteria) this;
        }

        public Criteria andPmsnameIn(List<String> values) {
            addCriterion("pmsname in", values, "pmsname");
            return (Criteria) this;
        }

        public Criteria andPmsnameNotIn(List<String> values) {
            addCriterion("pmsname not in", values, "pmsname");
            return (Criteria) this;
        }

        public Criteria andPmsnameBetween(String value1, String value2) {
            addCriterion("pmsname between", value1, value2, "pmsname");
            return (Criteria) this;
        }

        public Criteria andPmsnameNotBetween(String value1, String value2) {
            addCriterion("pmsname not between", value1, value2, "pmsname");
            return (Criteria) this;
        }

        public Criteria andPmsdesIsNull() {
            addCriterion("pmsdes is null");
            return (Criteria) this;
        }

        public Criteria andPmsdesIsNotNull() {
            addCriterion("pmsdes is not null");
            return (Criteria) this;
        }

        public Criteria andPmsdesEqualTo(String value) {
            addCriterion("pmsdes =", value, "pmsdes");
            return (Criteria) this;
        }

        public Criteria andPmsdesNotEqualTo(String value) {
            addCriterion("pmsdes <>", value, "pmsdes");
            return (Criteria) this;
        }

        public Criteria andPmsdesGreaterThan(String value) {
            addCriterion("pmsdes >", value, "pmsdes");
            return (Criteria) this;
        }

        public Criteria andPmsdesGreaterThanOrEqualTo(String value) {
            addCriterion("pmsdes >=", value, "pmsdes");
            return (Criteria) this;
        }

        public Criteria andPmsdesLessThan(String value) {
            addCriterion("pmsdes <", value, "pmsdes");
            return (Criteria) this;
        }

        public Criteria andPmsdesLessThanOrEqualTo(String value) {
            addCriterion("pmsdes <=", value, "pmsdes");
            return (Criteria) this;
        }

        public Criteria andPmsdesLike(String value) {
            addCriterion("pmsdes like", value, "pmsdes");
            return (Criteria) this;
        }

        public Criteria andPmsdesNotLike(String value) {
            addCriterion("pmsdes not like", value, "pmsdes");
            return (Criteria) this;
        }

        public Criteria andPmsdesIn(List<String> values) {
            addCriterion("pmsdes in", values, "pmsdes");
            return (Criteria) this;
        }

        public Criteria andPmsdesNotIn(List<String> values) {
            addCriterion("pmsdes not in", values, "pmsdes");
            return (Criteria) this;
        }

        public Criteria andPmsdesBetween(String value1, String value2) {
            addCriterion("pmsdes between", value1, value2, "pmsdes");
            return (Criteria) this;
        }

        public Criteria andPmsdesNotBetween(String value1, String value2) {
            addCriterion("pmsdes not between", value1, value2, "pmsdes");
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
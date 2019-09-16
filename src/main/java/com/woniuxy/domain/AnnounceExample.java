package com.woniuxy.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnnounceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AnnounceExample() {
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

        public Criteria andAnidIsNull() {
            addCriterion("anid is null");
            return (Criteria) this;
        }

        public Criteria andAnidIsNotNull() {
            addCriterion("anid is not null");
            return (Criteria) this;
        }

        public Criteria andAnidEqualTo(Integer value) {
            addCriterion("anid =", value, "anid");
            return (Criteria) this;
        }

        public Criteria andAnidNotEqualTo(Integer value) {
            addCriterion("anid <>", value, "anid");
            return (Criteria) this;
        }

        public Criteria andAnidGreaterThan(Integer value) {
            addCriterion("anid >", value, "anid");
            return (Criteria) this;
        }

        public Criteria andAnidGreaterThanOrEqualTo(Integer value) {
            addCriterion("anid >=", value, "anid");
            return (Criteria) this;
        }

        public Criteria andAnidLessThan(Integer value) {
            addCriterion("anid <", value, "anid");
            return (Criteria) this;
        }

        public Criteria andAnidLessThanOrEqualTo(Integer value) {
            addCriterion("anid <=", value, "anid");
            return (Criteria) this;
        }

        public Criteria andAnidIn(List<Integer> values) {
            addCriterion("anid in", values, "anid");
            return (Criteria) this;
        }

        public Criteria andAnidNotIn(List<Integer> values) {
            addCriterion("anid not in", values, "anid");
            return (Criteria) this;
        }

        public Criteria andAnidBetween(Integer value1, Integer value2) {
            addCriterion("anid between", value1, value2, "anid");
            return (Criteria) this;
        }

        public Criteria andAnidNotBetween(Integer value1, Integer value2) {
            addCriterion("anid not between", value1, value2, "anid");
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

        public Criteria andAncontentIsNull() {
            addCriterion("ancontent is null");
            return (Criteria) this;
        }

        public Criteria andAncontentIsNotNull() {
            addCriterion("ancontent is not null");
            return (Criteria) this;
        }

        public Criteria andAncontentEqualTo(String value) {
            addCriterion("ancontent =", value, "ancontent");
            return (Criteria) this;
        }

        public Criteria andAncontentNotEqualTo(String value) {
            addCriterion("ancontent <>", value, "ancontent");
            return (Criteria) this;
        }

        public Criteria andAncontentGreaterThan(String value) {
            addCriterion("ancontent >", value, "ancontent");
            return (Criteria) this;
        }

        public Criteria andAncontentGreaterThanOrEqualTo(String value) {
            addCriterion("ancontent >=", value, "ancontent");
            return (Criteria) this;
        }

        public Criteria andAncontentLessThan(String value) {
            addCriterion("ancontent <", value, "ancontent");
            return (Criteria) this;
        }

        public Criteria andAncontentLessThanOrEqualTo(String value) {
            addCriterion("ancontent <=", value, "ancontent");
            return (Criteria) this;
        }

        public Criteria andAncontentLike(String value) {
            addCriterion("ancontent like", value, "ancontent");
            return (Criteria) this;
        }

        public Criteria andAncontentNotLike(String value) {
            addCriterion("ancontent not like", value, "ancontent");
            return (Criteria) this;
        }

        public Criteria andAncontentIn(List<String> values) {
            addCriterion("ancontent in", values, "ancontent");
            return (Criteria) this;
        }

        public Criteria andAncontentNotIn(List<String> values) {
            addCriterion("ancontent not in", values, "ancontent");
            return (Criteria) this;
        }

        public Criteria andAncontentBetween(String value1, String value2) {
            addCriterion("ancontent between", value1, value2, "ancontent");
            return (Criteria) this;
        }

        public Criteria andAncontentNotBetween(String value1, String value2) {
            addCriterion("ancontent not between", value1, value2, "ancontent");
            return (Criteria) this;
        }

        public Criteria andAnstartIsNull() {
            addCriterion("anstart is null");
            return (Criteria) this;
        }

        public Criteria andAnstartIsNotNull() {
            addCriterion("anstart is not null");
            return (Criteria) this;
        }

        public Criteria andAnstartEqualTo(Date value) {
            addCriterion("anstart =", value, "anstart");
            return (Criteria) this;
        }

        public Criteria andAnstartNotEqualTo(Date value) {
            addCriterion("anstart <>", value, "anstart");
            return (Criteria) this;
        }

        public Criteria andAnstartGreaterThan(Date value) {
            addCriterion("anstart >", value, "anstart");
            return (Criteria) this;
        }

        public Criteria andAnstartGreaterThanOrEqualTo(Date value) {
            addCriterion("anstart >=", value, "anstart");
            return (Criteria) this;
        }

        public Criteria andAnstartLessThan(Date value) {
            addCriterion("anstart <", value, "anstart");
            return (Criteria) this;
        }

        public Criteria andAnstartLessThanOrEqualTo(Date value) {
            addCriterion("anstart <=", value, "anstart");
            return (Criteria) this;
        }

        public Criteria andAnstartIn(List<Date> values) {
            addCriterion("anstart in", values, "anstart");
            return (Criteria) this;
        }

        public Criteria andAnstartNotIn(List<Date> values) {
            addCriterion("anstart not in", values, "anstart");
            return (Criteria) this;
        }

        public Criteria andAnstartBetween(Date value1, Date value2) {
            addCriterion("anstart between", value1, value2, "anstart");
            return (Criteria) this;
        }

        public Criteria andAnstartNotBetween(Date value1, Date value2) {
            addCriterion("anstart not between", value1, value2, "anstart");
            return (Criteria) this;
        }

        public Criteria andAnendIsNull() {
            addCriterion("anend is null");
            return (Criteria) this;
        }

        public Criteria andAnendIsNotNull() {
            addCriterion("anend is not null");
            return (Criteria) this;
        }

        public Criteria andAnendEqualTo(Date value) {
            addCriterion("anend =", value, "anend");
            return (Criteria) this;
        }

        public Criteria andAnendNotEqualTo(Date value) {
            addCriterion("anend <>", value, "anend");
            return (Criteria) this;
        }

        public Criteria andAnendGreaterThan(Date value) {
            addCriterion("anend >", value, "anend");
            return (Criteria) this;
        }

        public Criteria andAnendGreaterThanOrEqualTo(Date value) {
            addCriterion("anend >=", value, "anend");
            return (Criteria) this;
        }

        public Criteria andAnendLessThan(Date value) {
            addCriterion("anend <", value, "anend");
            return (Criteria) this;
        }

        public Criteria andAnendLessThanOrEqualTo(Date value) {
            addCriterion("anend <=", value, "anend");
            return (Criteria) this;
        }

        public Criteria andAnendIn(List<Date> values) {
            addCriterion("anend in", values, "anend");
            return (Criteria) this;
        }

        public Criteria andAnendNotIn(List<Date> values) {
            addCriterion("anend not in", values, "anend");
            return (Criteria) this;
        }

        public Criteria andAnendBetween(Date value1, Date value2) {
            addCriterion("anend between", value1, value2, "anend");
            return (Criteria) this;
        }

        public Criteria andAnendNotBetween(Date value1, Date value2) {
            addCriterion("anend not between", value1, value2, "anend");
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
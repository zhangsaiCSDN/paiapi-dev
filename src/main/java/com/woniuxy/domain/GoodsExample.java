package com.woniuxy.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsExample() {
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

        public Criteria andDidIsNull() {
            addCriterion("did is null");
            return (Criteria) this;
        }

        public Criteria andDidIsNotNull() {
            addCriterion("did is not null");
            return (Criteria) this;
        }

        public Criteria andDidEqualTo(Integer value) {
            addCriterion("did =", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidNotEqualTo(Integer value) {
            addCriterion("did <>", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidGreaterThan(Integer value) {
            addCriterion("did >", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidGreaterThanOrEqualTo(Integer value) {
            addCriterion("did >=", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidLessThan(Integer value) {
            addCriterion("did <", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidLessThanOrEqualTo(Integer value) {
            addCriterion("did <=", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidIn(List<Integer> values) {
            addCriterion("did in", values, "did");
            return (Criteria) this;
        }

        public Criteria andDidNotIn(List<Integer> values) {
            addCriterion("did not in", values, "did");
            return (Criteria) this;
        }

        public Criteria andDidBetween(Integer value1, Integer value2) {
            addCriterion("did between", value1, value2, "did");
            return (Criteria) this;
        }

        public Criteria andDidNotBetween(Integer value1, Integer value2) {
            addCriterion("did not between", value1, value2, "did");
            return (Criteria) this;
        }

        public Criteria andGtidIsNull() {
            addCriterion("gtid is null");
            return (Criteria) this;
        }

        public Criteria andGtidIsNotNull() {
            addCriterion("gtid is not null");
            return (Criteria) this;
        }

        public Criteria andGtidEqualTo(Integer value) {
            addCriterion("gtid =", value, "gtid");
            return (Criteria) this;
        }

        public Criteria andGtidNotEqualTo(Integer value) {
            addCriterion("gtid <>", value, "gtid");
            return (Criteria) this;
        }

        public Criteria andGtidGreaterThan(Integer value) {
            addCriterion("gtid >", value, "gtid");
            return (Criteria) this;
        }

        public Criteria andGtidGreaterThanOrEqualTo(Integer value) {
            addCriterion("gtid >=", value, "gtid");
            return (Criteria) this;
        }

        public Criteria andGtidLessThan(Integer value) {
            addCriterion("gtid <", value, "gtid");
            return (Criteria) this;
        }

        public Criteria andGtidLessThanOrEqualTo(Integer value) {
            addCriterion("gtid <=", value, "gtid");
            return (Criteria) this;
        }

        public Criteria andGtidIn(List<Integer> values) {
            addCriterion("gtid in", values, "gtid");
            return (Criteria) this;
        }

        public Criteria andGtidNotIn(List<Integer> values) {
            addCriterion("gtid not in", values, "gtid");
            return (Criteria) this;
        }

        public Criteria andGtidBetween(Integer value1, Integer value2) {
            addCriterion("gtid between", value1, value2, "gtid");
            return (Criteria) this;
        }

        public Criteria andGtidNotBetween(Integer value1, Integer value2) {
            addCriterion("gtid not between", value1, value2, "gtid");
            return (Criteria) this;
        }

        public Criteria andGnameIsNull() {
            addCriterion("gname is null");
            return (Criteria) this;
        }

        public Criteria andGnameIsNotNull() {
            addCriterion("gname is not null");
            return (Criteria) this;
        }

        public Criteria andGnameEqualTo(String value) {
            addCriterion("gname =", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotEqualTo(String value) {
            addCriterion("gname <>", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameGreaterThan(String value) {
            addCriterion("gname >", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameGreaterThanOrEqualTo(String value) {
            addCriterion("gname >=", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameLessThan(String value) {
            addCriterion("gname <", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameLessThanOrEqualTo(String value) {
            addCriterion("gname <=", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameLike(String value) {
            addCriterion("gname like", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotLike(String value) {
            addCriterion("gname not like", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameIn(List<String> values) {
            addCriterion("gname in", values, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotIn(List<String> values) {
            addCriterion("gname not in", values, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameBetween(String value1, String value2) {
            addCriterion("gname between", value1, value2, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotBetween(String value1, String value2) {
            addCriterion("gname not between", value1, value2, "gname");
            return (Criteria) this;
        }

        public Criteria andGpriceIsNull() {
            addCriterion("gprice is null");
            return (Criteria) this;
        }

        public Criteria andGpriceIsNotNull() {
            addCriterion("gprice is not null");
            return (Criteria) this;
        }

        public Criteria andGpriceEqualTo(BigDecimal value) {
            addCriterion("gprice =", value, "gprice");
            return (Criteria) this;
        }

        public Criteria andGpriceNotEqualTo(BigDecimal value) {
            addCriterion("gprice <>", value, "gprice");
            return (Criteria) this;
        }

        public Criteria andGpriceGreaterThan(BigDecimal value) {
            addCriterion("gprice >", value, "gprice");
            return (Criteria) this;
        }

        public Criteria andGpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("gprice >=", value, "gprice");
            return (Criteria) this;
        }

        public Criteria andGpriceLessThan(BigDecimal value) {
            addCriterion("gprice <", value, "gprice");
            return (Criteria) this;
        }

        public Criteria andGpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("gprice <=", value, "gprice");
            return (Criteria) this;
        }

        public Criteria andGpriceIn(List<BigDecimal> values) {
            addCriterion("gprice in", values, "gprice");
            return (Criteria) this;
        }

        public Criteria andGpriceNotIn(List<BigDecimal> values) {
            addCriterion("gprice not in", values, "gprice");
            return (Criteria) this;
        }

        public Criteria andGpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gprice between", value1, value2, "gprice");
            return (Criteria) this;
        }

        public Criteria andGpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gprice not between", value1, value2, "gprice");
            return (Criteria) this;
        }

        public Criteria andGstartIsNull() {
            addCriterion("gstart is null");
            return (Criteria) this;
        }

        public Criteria andGstartIsNotNull() {
            addCriterion("gstart is not null");
            return (Criteria) this;
        }

        public Criteria andGstartEqualTo(Date value) {
            addCriterion("gstart =", value, "gstart");
            return (Criteria) this;
        }

        public Criteria andGstartNotEqualTo(Date value) {
            addCriterion("gstart <>", value, "gstart");
            return (Criteria) this;
        }

        public Criteria andGstartGreaterThan(Date value) {
            addCriterion("gstart >", value, "gstart");
            return (Criteria) this;
        }

        public Criteria andGstartGreaterThanOrEqualTo(Date value) {
            addCriterion("gstart >=", value, "gstart");
            return (Criteria) this;
        }

        public Criteria andGstartLessThan(Date value) {
            addCriterion("gstart <", value, "gstart");
            return (Criteria) this;
        }

        public Criteria andGstartLessThanOrEqualTo(Date value) {
            addCriterion("gstart <=", value, "gstart");
            return (Criteria) this;
        }

        public Criteria andGstartIn(List<Date> values) {
            addCriterion("gstart in", values, "gstart");
            return (Criteria) this;
        }

        public Criteria andGstartNotIn(List<Date> values) {
            addCriterion("gstart not in", values, "gstart");
            return (Criteria) this;
        }

        public Criteria andGstartBetween(Date value1, Date value2) {
            addCriterion("gstart between", value1, value2, "gstart");
            return (Criteria) this;
        }

        public Criteria andGstartNotBetween(Date value1, Date value2) {
            addCriterion("gstart not between", value1, value2, "gstart");
            return (Criteria) this;
        }

        public Criteria andGendIsNull() {
            addCriterion("gend is null");
            return (Criteria) this;
        }

        public Criteria andGendIsNotNull() {
            addCriterion("gend is not null");
            return (Criteria) this;
        }

        public Criteria andGendEqualTo(Date value) {
            addCriterion("gend =", value, "gend");
            return (Criteria) this;
        }

        public Criteria andGendNotEqualTo(Date value) {
            addCriterion("gend <>", value, "gend");
            return (Criteria) this;
        }

        public Criteria andGendGreaterThan(Date value) {
            addCriterion("gend >", value, "gend");
            return (Criteria) this;
        }

        public Criteria andGendGreaterThanOrEqualTo(Date value) {
            addCriterion("gend >=", value, "gend");
            return (Criteria) this;
        }

        public Criteria andGendLessThan(Date value) {
            addCriterion("gend <", value, "gend");
            return (Criteria) this;
        }

        public Criteria andGendLessThanOrEqualTo(Date value) {
            addCriterion("gend <=", value, "gend");
            return (Criteria) this;
        }

        public Criteria andGendIn(List<Date> values) {
            addCriterion("gend in", values, "gend");
            return (Criteria) this;
        }

        public Criteria andGendNotIn(List<Date> values) {
            addCriterion("gend not in", values, "gend");
            return (Criteria) this;
        }

        public Criteria andGendBetween(Date value1, Date value2) {
            addCriterion("gend between", value1, value2, "gend");
            return (Criteria) this;
        }

        public Criteria andGendNotBetween(Date value1, Date value2) {
            addCriterion("gend not between", value1, value2, "gend");
            return (Criteria) this;
        }

        public Criteria andGcountIsNull() {
            addCriterion("gcount is null");
            return (Criteria) this;
        }

        public Criteria andGcountIsNotNull() {
            addCriterion("gcount is not null");
            return (Criteria) this;
        }

        public Criteria andGcountEqualTo(Integer value) {
            addCriterion("gcount =", value, "gcount");
            return (Criteria) this;
        }

        public Criteria andGcountNotEqualTo(Integer value) {
            addCriterion("gcount <>", value, "gcount");
            return (Criteria) this;
        }

        public Criteria andGcountGreaterThan(Integer value) {
            addCriterion("gcount >", value, "gcount");
            return (Criteria) this;
        }

        public Criteria andGcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("gcount >=", value, "gcount");
            return (Criteria) this;
        }

        public Criteria andGcountLessThan(Integer value) {
            addCriterion("gcount <", value, "gcount");
            return (Criteria) this;
        }

        public Criteria andGcountLessThanOrEqualTo(Integer value) {
            addCriterion("gcount <=", value, "gcount");
            return (Criteria) this;
        }

        public Criteria andGcountIn(List<Integer> values) {
            addCriterion("gcount in", values, "gcount");
            return (Criteria) this;
        }

        public Criteria andGcountNotIn(List<Integer> values) {
            addCriterion("gcount not in", values, "gcount");
            return (Criteria) this;
        }

        public Criteria andGcountBetween(Integer value1, Integer value2) {
            addCriterion("gcount between", value1, value2, "gcount");
            return (Criteria) this;
        }

        public Criteria andGcountNotBetween(Integer value1, Integer value2) {
            addCriterion("gcount not between", value1, value2, "gcount");
            return (Criteria) this;
        }

        public Criteria andGgapIsNull() {
            addCriterion("ggap is null");
            return (Criteria) this;
        }

        public Criteria andGgapIsNotNull() {
            addCriterion("ggap is not null");
            return (Criteria) this;
        }

        public Criteria andGgapEqualTo(BigDecimal value) {
            addCriterion("ggap =", value, "ggap");
            return (Criteria) this;
        }

        public Criteria andGgapNotEqualTo(BigDecimal value) {
            addCriterion("ggap <>", value, "ggap");
            return (Criteria) this;
        }

        public Criteria andGgapGreaterThan(BigDecimal value) {
            addCriterion("ggap >", value, "ggap");
            return (Criteria) this;
        }

        public Criteria andGgapGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ggap >=", value, "ggap");
            return (Criteria) this;
        }

        public Criteria andGgapLessThan(BigDecimal value) {
            addCriterion("ggap <", value, "ggap");
            return (Criteria) this;
        }

        public Criteria andGgapLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ggap <=", value, "ggap");
            return (Criteria) this;
        }

        public Criteria andGgapIn(List<BigDecimal> values) {
            addCriterion("ggap in", values, "ggap");
            return (Criteria) this;
        }

        public Criteria andGgapNotIn(List<BigDecimal> values) {
            addCriterion("ggap not in", values, "ggap");
            return (Criteria) this;
        }

        public Criteria andGgapBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ggap between", value1, value2, "ggap");
            return (Criteria) this;
        }

        public Criteria andGgapNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ggap not between", value1, value2, "ggap");
            return (Criteria) this;
        }

        public Criteria andGpasstimeIsNull() {
            addCriterion("gpasstime is null");
            return (Criteria) this;
        }

        public Criteria andGpasstimeIsNotNull() {
            addCriterion("gpasstime is not null");
            return (Criteria) this;
        }

        public Criteria andGpasstimeEqualTo(Date value) {
            addCriterion("gpasstime =", value, "gpasstime");
            return (Criteria) this;
        }

        public Criteria andGpasstimeNotEqualTo(Date value) {
            addCriterion("gpasstime <>", value, "gpasstime");
            return (Criteria) this;
        }

        public Criteria andGpasstimeGreaterThan(Date value) {
            addCriterion("gpasstime >", value, "gpasstime");
            return (Criteria) this;
        }

        public Criteria andGpasstimeGreaterThanOrEqualTo(Date value) {
            addCriterion("gpasstime >=", value, "gpasstime");
            return (Criteria) this;
        }

        public Criteria andGpasstimeLessThan(Date value) {
            addCriterion("gpasstime <", value, "gpasstime");
            return (Criteria) this;
        }

        public Criteria andGpasstimeLessThanOrEqualTo(Date value) {
            addCriterion("gpasstime <=", value, "gpasstime");
            return (Criteria) this;
        }

        public Criteria andGpasstimeIn(List<Date> values) {
            addCriterion("gpasstime in", values, "gpasstime");
            return (Criteria) this;
        }

        public Criteria andGpasstimeNotIn(List<Date> values) {
            addCriterion("gpasstime not in", values, "gpasstime");
            return (Criteria) this;
        }

        public Criteria andGpasstimeBetween(Date value1, Date value2) {
            addCriterion("gpasstime between", value1, value2, "gpasstime");
            return (Criteria) this;
        }

        public Criteria andGpasstimeNotBetween(Date value1, Date value2) {
            addCriterion("gpasstime not between", value1, value2, "gpasstime");
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
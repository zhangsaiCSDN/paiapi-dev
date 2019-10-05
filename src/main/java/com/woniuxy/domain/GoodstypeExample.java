package com.woniuxy.domain;

import java.util.ArrayList;
import java.util.List;

public class GoodstypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    
    
    
    private String gtname;
    private String month;
    private Double odmoney;
    
    
    
    
    
    
    public String getGtname() {
		return gtname;
	}

	public void setGtname(String gtname) {
		this.gtname = gtname;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Double getOdmoney() {
		return odmoney;
	}

	public void setOdmoney(Double odmoney) {
		this.odmoney = odmoney;
	}

	public GoodstypeExample() {
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

        public Criteria andGtnameIsNull() {
            addCriterion("gtname is null");
            return (Criteria) this;
        }

        public Criteria andGtnameIsNotNull() {
            addCriterion("gtname is not null");
            return (Criteria) this;
        }

        public Criteria andGtnameEqualTo(String value) {
            addCriterion("gtname =", value, "gtname");
            return (Criteria) this;
        }

        public Criteria andGtnameNotEqualTo(String value) {
            addCriterion("gtname <>", value, "gtname");
            return (Criteria) this;
        }

        public Criteria andGtnameGreaterThan(String value) {
            addCriterion("gtname >", value, "gtname");
            return (Criteria) this;
        }

        public Criteria andGtnameGreaterThanOrEqualTo(String value) {
            addCriterion("gtname >=", value, "gtname");
            return (Criteria) this;
        }

        public Criteria andGtnameLessThan(String value) {
            addCriterion("gtname <", value, "gtname");
            return (Criteria) this;
        }

        public Criteria andGtnameLessThanOrEqualTo(String value) {
            addCriterion("gtname <=", value, "gtname");
            return (Criteria) this;
        }

        public Criteria andGtnameLike(String value) {
            addCriterion("gtname like", value, "gtname");
            return (Criteria) this;
        }

        public Criteria andGtnameNotLike(String value) {
            addCriterion("gtname not like", value, "gtname");
            return (Criteria) this;
        }

        public Criteria andGtnameIn(List<String> values) {
            addCriterion("gtname in", values, "gtname");
            return (Criteria) this;
        }

        public Criteria andGtnameNotIn(List<String> values) {
            addCriterion("gtname not in", values, "gtname");
            return (Criteria) this;
        }

        public Criteria andGtnameBetween(String value1, String value2) {
            addCriterion("gtname between", value1, value2, "gtname");
            return (Criteria) this;
        }

        public Criteria andGtnameNotBetween(String value1, String value2) {
            addCriterion("gtname not between", value1, value2, "gtname");
            return (Criteria) this;
        }

        public Criteria andImgIsNull() {
            addCriterion("img is null");
            return (Criteria) this;
        }

        public Criteria andImgIsNotNull() {
            addCriterion("img is not null");
            return (Criteria) this;
        }

        public Criteria andImgEqualTo(String value) {
            addCriterion("img =", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotEqualTo(String value) {
            addCriterion("img <>", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThan(String value) {
            addCriterion("img >", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThanOrEqualTo(String value) {
            addCriterion("img >=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThan(String value) {
            addCriterion("img <", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThanOrEqualTo(String value) {
            addCriterion("img <=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLike(String value) {
            addCriterion("img like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotLike(String value) {
            addCriterion("img not like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgIn(List<String> values) {
            addCriterion("img in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotIn(List<String> values) {
            addCriterion("img not in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgBetween(String value1, String value2) {
            addCriterion("img between", value1, value2, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotBetween(String value1, String value2) {
            addCriterion("img not between", value1, value2, "img");
            return (Criteria) this;
        }

        public Criteria andGtdesIsNull() {
            addCriterion("gtdes is null");
            return (Criteria) this;
        }

        public Criteria andGtdesIsNotNull() {
            addCriterion("gtdes is not null");
            return (Criteria) this;
        }

        public Criteria andGtdesEqualTo(String value) {
            addCriterion("gtdes =", value, "gtdes");
            return (Criteria) this;
        }

        public Criteria andGtdesNotEqualTo(String value) {
            addCriterion("gtdes <>", value, "gtdes");
            return (Criteria) this;
        }

        public Criteria andGtdesGreaterThan(String value) {
            addCriterion("gtdes >", value, "gtdes");
            return (Criteria) this;
        }

        public Criteria andGtdesGreaterThanOrEqualTo(String value) {
            addCriterion("gtdes >=", value, "gtdes");
            return (Criteria) this;
        }

        public Criteria andGtdesLessThan(String value) {
            addCriterion("gtdes <", value, "gtdes");
            return (Criteria) this;
        }

        public Criteria andGtdesLessThanOrEqualTo(String value) {
            addCriterion("gtdes <=", value, "gtdes");
            return (Criteria) this;
        }

        public Criteria andGtdesLike(String value) {
            addCriterion("gtdes like", value, "gtdes");
            return (Criteria) this;
        }

        public Criteria andGtdesNotLike(String value) {
            addCriterion("gtdes not like", value, "gtdes");
            return (Criteria) this;
        }

        public Criteria andGtdesIn(List<String> values) {
            addCriterion("gtdes in", values, "gtdes");
            return (Criteria) this;
        }

        public Criteria andGtdesNotIn(List<String> values) {
            addCriterion("gtdes not in", values, "gtdes");
            return (Criteria) this;
        }

        public Criteria andGtdesBetween(String value1, String value2) {
            addCriterion("gtdes between", value1, value2, "gtdes");
            return (Criteria) this;
        }

        public Criteria andGtdesNotBetween(String value1, String value2) {
            addCriterion("gtdes not between", value1, value2, "gtdes");
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
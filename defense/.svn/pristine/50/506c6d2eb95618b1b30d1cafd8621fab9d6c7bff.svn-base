package com.yagout.defense.dal.model;

import java.util.ArrayList;
import java.util.List;

public class StrategyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StrategyExample() {
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

        public Criteria andDefenseIdIsNull() {
            addCriterion("defense_id is null");
            return (Criteria) this;
        }

        public Criteria andDefenseIdIsNotNull() {
            addCriterion("defense_id is not null");
            return (Criteria) this;
        }

        public Criteria andDefenseIdEqualTo(Integer value) {
            addCriterion("defense_id =", value, "defenseId");
            return (Criteria) this;
        }

        public Criteria andDefenseIdNotEqualTo(Integer value) {
            addCriterion("defense_id <>", value, "defenseId");
            return (Criteria) this;
        }

        public Criteria andDefenseIdGreaterThan(Integer value) {
            addCriterion("defense_id >", value, "defenseId");
            return (Criteria) this;
        }

        public Criteria andDefenseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("defense_id >=", value, "defenseId");
            return (Criteria) this;
        }

        public Criteria andDefenseIdLessThan(Integer value) {
            addCriterion("defense_id <", value, "defenseId");
            return (Criteria) this;
        }

        public Criteria andDefenseIdLessThanOrEqualTo(Integer value) {
            addCriterion("defense_id <=", value, "defenseId");
            return (Criteria) this;
        }

        public Criteria andDefenseIdIn(List<Integer> values) {
            addCriterion("defense_id in", values, "defenseId");
            return (Criteria) this;
        }

        public Criteria andDefenseIdNotIn(List<Integer> values) {
            addCriterion("defense_id not in", values, "defenseId");
            return (Criteria) this;
        }

        public Criteria andDefenseIdBetween(Integer value1, Integer value2) {
            addCriterion("defense_id between", value1, value2, "defenseId");
            return (Criteria) this;
        }

        public Criteria andDefenseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("defense_id not between", value1, value2, "defenseId");
            return (Criteria) this;
        }

        public Criteria andInvadeIdIsNull() {
            addCriterion("invade_id is null");
            return (Criteria) this;
        }

        public Criteria andInvadeIdIsNotNull() {
            addCriterion("invade_id is not null");
            return (Criteria) this;
        }

        public Criteria andInvadeIdEqualTo(Integer value) {
            addCriterion("invade_id =", value, "invadeId");
            return (Criteria) this;
        }

        public Criteria andInvadeIdNotEqualTo(Integer value) {
            addCriterion("invade_id <>", value, "invadeId");
            return (Criteria) this;
        }

        public Criteria andInvadeIdGreaterThan(Integer value) {
            addCriterion("invade_id >", value, "invadeId");
            return (Criteria) this;
        }

        public Criteria andInvadeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("invade_id >=", value, "invadeId");
            return (Criteria) this;
        }

        public Criteria andInvadeIdLessThan(Integer value) {
            addCriterion("invade_id <", value, "invadeId");
            return (Criteria) this;
        }

        public Criteria andInvadeIdLessThanOrEqualTo(Integer value) {
            addCriterion("invade_id <=", value, "invadeId");
            return (Criteria) this;
        }

        public Criteria andInvadeIdIn(List<Integer> values) {
            addCriterion("invade_id in", values, "invadeId");
            return (Criteria) this;
        }

        public Criteria andInvadeIdNotIn(List<Integer> values) {
            addCriterion("invade_id not in", values, "invadeId");
            return (Criteria) this;
        }

        public Criteria andInvadeIdBetween(Integer value1, Integer value2) {
            addCriterion("invade_id between", value1, value2, "invadeId");
            return (Criteria) this;
        }

        public Criteria andInvadeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("invade_id not between", value1, value2, "invadeId");
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
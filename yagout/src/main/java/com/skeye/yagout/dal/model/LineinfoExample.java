package com.skeye.yagout.dal.model;

import java.util.ArrayList;
import java.util.List;

public class LineinfoExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table lineinfo
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table lineinfo
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table lineinfo
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lineinfo
     *
     * @mbggenerated
     */
    public LineinfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lineinfo
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lineinfo
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lineinfo
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lineinfo
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lineinfo
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lineinfo
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lineinfo
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lineinfo
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lineinfo
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lineinfo
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table lineinfo
     *
     * @mbggenerated
     */
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

        public Criteria andLineidIsNull() {
            addCriterion("LineID is null");
            return (Criteria) this;
        }

        public Criteria andLineidIsNotNull() {
            addCriterion("LineID is not null");
            return (Criteria) this;
        }

        public Criteria andLineidEqualTo(Integer value) {
            addCriterion("LineID =", value, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidNotEqualTo(Integer value) {
            addCriterion("LineID <>", value, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidGreaterThan(Integer value) {
            addCriterion("LineID >", value, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidGreaterThanOrEqualTo(Integer value) {
            addCriterion("LineID >=", value, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidLessThan(Integer value) {
            addCriterion("LineID <", value, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidLessThanOrEqualTo(Integer value) {
            addCriterion("LineID <=", value, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidIn(List<Integer> values) {
            addCriterion("LineID in", values, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidNotIn(List<Integer> values) {
            addCriterion("LineID not in", values, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidBetween(Integer value1, Integer value2) {
            addCriterion("LineID between", value1, value2, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidNotBetween(Integer value1, Integer value2) {
            addCriterion("LineID not between", value1, value2, "lineid");
            return (Criteria) this;
        }

        public Criteria andLinetypeIsNull() {
            addCriterion("LineType is null");
            return (Criteria) this;
        }

        public Criteria andLinetypeIsNotNull() {
            addCriterion("LineType is not null");
            return (Criteria) this;
        }

        public Criteria andLinetypeEqualTo(Integer value) {
            addCriterion("LineType =", value, "linetype");
            return (Criteria) this;
        }

        public Criteria andLinetypeNotEqualTo(Integer value) {
            addCriterion("LineType <>", value, "linetype");
            return (Criteria) this;
        }

        public Criteria andLinetypeGreaterThan(Integer value) {
            addCriterion("LineType >", value, "linetype");
            return (Criteria) this;
        }

        public Criteria andLinetypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("LineType >=", value, "linetype");
            return (Criteria) this;
        }

        public Criteria andLinetypeLessThan(Integer value) {
            addCriterion("LineType <", value, "linetype");
            return (Criteria) this;
        }

        public Criteria andLinetypeLessThanOrEqualTo(Integer value) {
            addCriterion("LineType <=", value, "linetype");
            return (Criteria) this;
        }

        public Criteria andLinetypeIn(List<Integer> values) {
            addCriterion("LineType in", values, "linetype");
            return (Criteria) this;
        }

        public Criteria andLinetypeNotIn(List<Integer> values) {
            addCriterion("LineType not in", values, "linetype");
            return (Criteria) this;
        }

        public Criteria andLinetypeBetween(Integer value1, Integer value2) {
            addCriterion("LineType between", value1, value2, "linetype");
            return (Criteria) this;
        }

        public Criteria andLinetypeNotBetween(Integer value1, Integer value2) {
            addCriterion("LineType not between", value1, value2, "linetype");
            return (Criteria) this;
        }

        public Criteria andLineidentityIsNull() {
            addCriterion("LineIdentity is null");
            return (Criteria) this;
        }

        public Criteria andLineidentityIsNotNull() {
            addCriterion("LineIdentity is not null");
            return (Criteria) this;
        }

        public Criteria andLineidentityEqualTo(String value) {
            addCriterion("LineIdentity =", value, "lineidentity");
            return (Criteria) this;
        }

        public Criteria andLineidentityNotEqualTo(String value) {
            addCriterion("LineIdentity <>", value, "lineidentity");
            return (Criteria) this;
        }

        public Criteria andLineidentityGreaterThan(String value) {
            addCriterion("LineIdentity >", value, "lineidentity");
            return (Criteria) this;
        }

        public Criteria andLineidentityGreaterThanOrEqualTo(String value) {
            addCriterion("LineIdentity >=", value, "lineidentity");
            return (Criteria) this;
        }

        public Criteria andLineidentityLessThan(String value) {
            addCriterion("LineIdentity <", value, "lineidentity");
            return (Criteria) this;
        }

        public Criteria andLineidentityLessThanOrEqualTo(String value) {
            addCriterion("LineIdentity <=", value, "lineidentity");
            return (Criteria) this;
        }

        public Criteria andLineidentityLike(String value) {
            addCriterion("LineIdentity like", value, "lineidentity");
            return (Criteria) this;
        }

        public Criteria andLineidentityNotLike(String value) {
            addCriterion("LineIdentity not like", value, "lineidentity");
            return (Criteria) this;
        }

        public Criteria andLineidentityIn(List<String> values) {
            addCriterion("LineIdentity in", values, "lineidentity");
            return (Criteria) this;
        }

        public Criteria andLineidentityNotIn(List<String> values) {
            addCriterion("LineIdentity not in", values, "lineidentity");
            return (Criteria) this;
        }

        public Criteria andLineidentityBetween(String value1, String value2) {
            addCriterion("LineIdentity between", value1, value2, "lineidentity");
            return (Criteria) this;
        }

        public Criteria andLineidentityNotBetween(String value1, String value2) {
            addCriterion("LineIdentity not between", value1, value2, "lineidentity");
            return (Criteria) this;
        }

        public Criteria andRegaddressIsNull() {
            addCriterion("RegAddress is null");
            return (Criteria) this;
        }

        public Criteria andRegaddressIsNotNull() {
            addCriterion("RegAddress is not null");
            return (Criteria) this;
        }

        public Criteria andRegaddressEqualTo(String value) {
            addCriterion("RegAddress =", value, "regaddress");
            return (Criteria) this;
        }

        public Criteria andRegaddressNotEqualTo(String value) {
            addCriterion("RegAddress <>", value, "regaddress");
            return (Criteria) this;
        }

        public Criteria andRegaddressGreaterThan(String value) {
            addCriterion("RegAddress >", value, "regaddress");
            return (Criteria) this;
        }

        public Criteria andRegaddressGreaterThanOrEqualTo(String value) {
            addCriterion("RegAddress >=", value, "regaddress");
            return (Criteria) this;
        }

        public Criteria andRegaddressLessThan(String value) {
            addCriterion("RegAddress <", value, "regaddress");
            return (Criteria) this;
        }

        public Criteria andRegaddressLessThanOrEqualTo(String value) {
            addCriterion("RegAddress <=", value, "regaddress");
            return (Criteria) this;
        }

        public Criteria andRegaddressLike(String value) {
            addCriterion("RegAddress like", value, "regaddress");
            return (Criteria) this;
        }

        public Criteria andRegaddressNotLike(String value) {
            addCriterion("RegAddress not like", value, "regaddress");
            return (Criteria) this;
        }

        public Criteria andRegaddressIn(List<String> values) {
            addCriterion("RegAddress in", values, "regaddress");
            return (Criteria) this;
        }

        public Criteria andRegaddressNotIn(List<String> values) {
            addCriterion("RegAddress not in", values, "regaddress");
            return (Criteria) this;
        }

        public Criteria andRegaddressBetween(String value1, String value2) {
            addCriterion("RegAddress between", value1, value2, "regaddress");
            return (Criteria) this;
        }

        public Criteria andRegaddressNotBetween(String value1, String value2) {
            addCriterion("RegAddress not between", value1, value2, "regaddress");
            return (Criteria) this;
        }

        public Criteria andRegphoneIsNull() {
            addCriterion("Regphone is null");
            return (Criteria) this;
        }

        public Criteria andRegphoneIsNotNull() {
            addCriterion("Regphone is not null");
            return (Criteria) this;
        }

        public Criteria andRegphoneEqualTo(String value) {
            addCriterion("Regphone =", value, "regphone");
            return (Criteria) this;
        }

        public Criteria andRegphoneNotEqualTo(String value) {
            addCriterion("Regphone <>", value, "regphone");
            return (Criteria) this;
        }

        public Criteria andRegphoneGreaterThan(String value) {
            addCriterion("Regphone >", value, "regphone");
            return (Criteria) this;
        }

        public Criteria andRegphoneGreaterThanOrEqualTo(String value) {
            addCriterion("Regphone >=", value, "regphone");
            return (Criteria) this;
        }

        public Criteria andRegphoneLessThan(String value) {
            addCriterion("Regphone <", value, "regphone");
            return (Criteria) this;
        }

        public Criteria andRegphoneLessThanOrEqualTo(String value) {
            addCriterion("Regphone <=", value, "regphone");
            return (Criteria) this;
        }

        public Criteria andRegphoneLike(String value) {
            addCriterion("Regphone like", value, "regphone");
            return (Criteria) this;
        }

        public Criteria andRegphoneNotLike(String value) {
            addCriterion("Regphone not like", value, "regphone");
            return (Criteria) this;
        }

        public Criteria andRegphoneIn(List<String> values) {
            addCriterion("Regphone in", values, "regphone");
            return (Criteria) this;
        }

        public Criteria andRegphoneNotIn(List<String> values) {
            addCriterion("Regphone not in", values, "regphone");
            return (Criteria) this;
        }

        public Criteria andRegphoneBetween(String value1, String value2) {
            addCriterion("Regphone between", value1, value2, "regphone");
            return (Criteria) this;
        }

        public Criteria andRegphoneNotBetween(String value1, String value2) {
            addCriterion("Regphone not between", value1, value2, "regphone");
            return (Criteria) this;
        }

        public Criteria andRelationIsNull() {
            addCriterion("Relation is null");
            return (Criteria) this;
        }

        public Criteria andRelationIsNotNull() {
            addCriterion("Relation is not null");
            return (Criteria) this;
        }

        public Criteria andRelationEqualTo(String value) {
            addCriterion("Relation =", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationNotEqualTo(String value) {
            addCriterion("Relation <>", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationGreaterThan(String value) {
            addCriterion("Relation >", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationGreaterThanOrEqualTo(String value) {
            addCriterion("Relation >=", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationLessThan(String value) {
            addCriterion("Relation <", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationLessThanOrEqualTo(String value) {
            addCriterion("Relation <=", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationLike(String value) {
            addCriterion("Relation like", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationNotLike(String value) {
            addCriterion("Relation not like", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationIn(List<String> values) {
            addCriterion("Relation in", values, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationNotIn(List<String> values) {
            addCriterion("Relation not in", values, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationBetween(String value1, String value2) {
            addCriterion("Relation between", value1, value2, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationNotBetween(String value1, String value2) {
            addCriterion("Relation not between", value1, value2, "relation");
            return (Criteria) this;
        }

        public Criteria andRegtimeIsNull() {
            addCriterion("RegTime is null");
            return (Criteria) this;
        }

        public Criteria andRegtimeIsNotNull() {
            addCriterion("RegTime is not null");
            return (Criteria) this;
        }

        public Criteria andRegtimeEqualTo(Integer value) {
            addCriterion("RegTime =", value, "regtime");
            return (Criteria) this;
        }

        public Criteria andRegtimeNotEqualTo(Integer value) {
            addCriterion("RegTime <>", value, "regtime");
            return (Criteria) this;
        }

        public Criteria andRegtimeGreaterThan(Integer value) {
            addCriterion("RegTime >", value, "regtime");
            return (Criteria) this;
        }

        public Criteria andRegtimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("RegTime >=", value, "regtime");
            return (Criteria) this;
        }

        public Criteria andRegtimeLessThan(Integer value) {
            addCriterion("RegTime <", value, "regtime");
            return (Criteria) this;
        }

        public Criteria andRegtimeLessThanOrEqualTo(Integer value) {
            addCriterion("RegTime <=", value, "regtime");
            return (Criteria) this;
        }

        public Criteria andRegtimeIn(List<Integer> values) {
            addCriterion("RegTime in", values, "regtime");
            return (Criteria) this;
        }

        public Criteria andRegtimeNotIn(List<Integer> values) {
            addCriterion("RegTime not in", values, "regtime");
            return (Criteria) this;
        }

        public Criteria andRegtimeBetween(Integer value1, Integer value2) {
            addCriterion("RegTime between", value1, value2, "regtime");
            return (Criteria) this;
        }

        public Criteria andRegtimeNotBetween(Integer value1, Integer value2) {
            addCriterion("RegTime not between", value1, value2, "regtime");
            return (Criteria) this;
        }

        public Criteria andMarkIsNull() {
            addCriterion("Mark is null");
            return (Criteria) this;
        }

        public Criteria andMarkIsNotNull() {
            addCriterion("Mark is not null");
            return (Criteria) this;
        }

        public Criteria andMarkEqualTo(String value) {
            addCriterion("Mark =", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotEqualTo(String value) {
            addCriterion("Mark <>", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThan(String value) {
            addCriterion("Mark >", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThanOrEqualTo(String value) {
            addCriterion("Mark >=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThan(String value) {
            addCriterion("Mark <", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThanOrEqualTo(String value) {
            addCriterion("Mark <=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLike(String value) {
            addCriterion("Mark like", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotLike(String value) {
            addCriterion("Mark not like", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkIn(List<String> values) {
            addCriterion("Mark in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotIn(List<String> values) {
            addCriterion("Mark not in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkBetween(String value1, String value2) {
            addCriterion("Mark between", value1, value2, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotBetween(String value1, String value2) {
            addCriterion("Mark not between", value1, value2, "mark");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table lineinfo
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table lineinfo
     *
     * @mbggenerated
     */
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
package com.yagout.defense.dal.model;

import java.util.ArrayList;
import java.util.List;

public class ApVisitorExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ap_visitor
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ap_visitor
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ap_visitor
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ap_visitor
     *
     * @mbggenerated
     */
    public ApVisitorExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ap_visitor
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ap_visitor
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ap_visitor
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ap_visitor
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ap_visitor
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ap_visitor
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ap_visitor
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
     * This method corresponds to the database table ap_visitor
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
     * This method corresponds to the database table ap_visitor
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ap_visitor
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
     * This class corresponds to the database table ap_visitor
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

        public Criteria andMacIsNull() {
            addCriterion("mac is null");
            return (Criteria) this;
        }

        public Criteria andMacIsNotNull() {
            addCriterion("mac is not null");
            return (Criteria) this;
        }

        public Criteria andMacEqualTo(String value) {
            addCriterion("mac =", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotEqualTo(String value) {
            addCriterion("mac <>", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacGreaterThan(String value) {
            addCriterion("mac >", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacGreaterThanOrEqualTo(String value) {
            addCriterion("mac >=", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacLessThan(String value) {
            addCriterion("mac <", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacLessThanOrEqualTo(String value) {
            addCriterion("mac <=", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacLike(String value) {
            addCriterion("mac like", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotLike(String value) {
            addCriterion("mac not like", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacIn(List<String> values) {
            addCriterion("mac in", values, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotIn(List<String> values) {
            addCriterion("mac not in", values, "mac");
            return (Criteria) this;
        }

        public Criteria andMacBetween(String value1, String value2) {
            addCriterion("mac between", value1, value2, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotBetween(String value1, String value2) {
            addCriterion("mac not between", value1, value2, "mac");
            return (Criteria) this;
        }

        public Criteria andSsidIsNull() {
            addCriterion("ssid is null");
            return (Criteria) this;
        }

        public Criteria andSsidIsNotNull() {
            addCriterion("ssid is not null");
            return (Criteria) this;
        }

        public Criteria andSsidEqualTo(String value) {
            addCriterion("ssid =", value, "ssid");
            return (Criteria) this;
        }

        public Criteria andSsidNotEqualTo(String value) {
            addCriterion("ssid <>", value, "ssid");
            return (Criteria) this;
        }

        public Criteria andSsidGreaterThan(String value) {
            addCriterion("ssid >", value, "ssid");
            return (Criteria) this;
        }

        public Criteria andSsidGreaterThanOrEqualTo(String value) {
            addCriterion("ssid >=", value, "ssid");
            return (Criteria) this;
        }

        public Criteria andSsidLessThan(String value) {
            addCriterion("ssid <", value, "ssid");
            return (Criteria) this;
        }

        public Criteria andSsidLessThanOrEqualTo(String value) {
            addCriterion("ssid <=", value, "ssid");
            return (Criteria) this;
        }

        public Criteria andSsidLike(String value) {
            addCriterion("ssid like", value, "ssid");
            return (Criteria) this;
        }

        public Criteria andSsidNotLike(String value) {
            addCriterion("ssid not like", value, "ssid");
            return (Criteria) this;
        }

        public Criteria andSsidIn(List<String> values) {
            addCriterion("ssid in", values, "ssid");
            return (Criteria) this;
        }

        public Criteria andSsidNotIn(List<String> values) {
            addCriterion("ssid not in", values, "ssid");
            return (Criteria) this;
        }

        public Criteria andSsidBetween(String value1, String value2) {
            addCriterion("ssid between", value1, value2, "ssid");
            return (Criteria) this;
        }

        public Criteria andSsidNotBetween(String value1, String value2) {
            addCriterion("ssid not between", value1, value2, "ssid");
            return (Criteria) this;
        }

        public Criteria andPwdIsNull() {
            addCriterion("pwd is null");
            return (Criteria) this;
        }

        public Criteria andPwdIsNotNull() {
            addCriterion("pwd is not null");
            return (Criteria) this;
        }

        public Criteria andPwdEqualTo(String value) {
            addCriterion("pwd =", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotEqualTo(String value) {
            addCriterion("pwd <>", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdGreaterThan(String value) {
            addCriterion("pwd >", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdGreaterThanOrEqualTo(String value) {
            addCriterion("pwd >=", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLessThan(String value) {
            addCriterion("pwd <", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLessThanOrEqualTo(String value) {
            addCriterion("pwd <=", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLike(String value) {
            addCriterion("pwd like", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotLike(String value) {
            addCriterion("pwd not like", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdIn(List<String> values) {
            addCriterion("pwd in", values, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotIn(List<String> values) {
            addCriterion("pwd not in", values, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdBetween(String value1, String value2) {
            addCriterion("pwd between", value1, value2, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotBetween(String value1, String value2) {
            addCriterion("pwd not between", value1, value2, "pwd");
            return (Criteria) this;
        }

        public Criteria andMakerIsNull() {
            addCriterion("maker is null");
            return (Criteria) this;
        }

        public Criteria andMakerIsNotNull() {
            addCriterion("maker is not null");
            return (Criteria) this;
        }

        public Criteria andMakerEqualTo(String value) {
            addCriterion("maker =", value, "maker");
            return (Criteria) this;
        }

        public Criteria andMakerNotEqualTo(String value) {
            addCriterion("maker <>", value, "maker");
            return (Criteria) this;
        }

        public Criteria andMakerGreaterThan(String value) {
            addCriterion("maker >", value, "maker");
            return (Criteria) this;
        }

        public Criteria andMakerGreaterThanOrEqualTo(String value) {
            addCriterion("maker >=", value, "maker");
            return (Criteria) this;
        }

        public Criteria andMakerLessThan(String value) {
            addCriterion("maker <", value, "maker");
            return (Criteria) this;
        }

        public Criteria andMakerLessThanOrEqualTo(String value) {
            addCriterion("maker <=", value, "maker");
            return (Criteria) this;
        }

        public Criteria andMakerLike(String value) {
            addCriterion("maker like", value, "maker");
            return (Criteria) this;
        }

        public Criteria andMakerNotLike(String value) {
            addCriterion("maker not like", value, "maker");
            return (Criteria) this;
        }

        public Criteria andMakerIn(List<String> values) {
            addCriterion("maker in", values, "maker");
            return (Criteria) this;
        }

        public Criteria andMakerNotIn(List<String> values) {
            addCriterion("maker not in", values, "maker");
            return (Criteria) this;
        }

        public Criteria andMakerBetween(String value1, String value2) {
            addCriterion("maker between", value1, value2, "maker");
            return (Criteria) this;
        }

        public Criteria andMakerNotBetween(String value1, String value2) {
            addCriterion("maker not between", value1, value2, "maker");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andPrivacyIsNull() {
            addCriterion("privacy is null");
            return (Criteria) this;
        }

        public Criteria andPrivacyIsNotNull() {
            addCriterion("privacy is not null");
            return (Criteria) this;
        }

        public Criteria andPrivacyEqualTo(Integer value) {
            addCriterion("privacy =", value, "privacy");
            return (Criteria) this;
        }

        public Criteria andPrivacyNotEqualTo(Integer value) {
            addCriterion("privacy <>", value, "privacy");
            return (Criteria) this;
        }

        public Criteria andPrivacyGreaterThan(Integer value) {
            addCriterion("privacy >", value, "privacy");
            return (Criteria) this;
        }

        public Criteria andPrivacyGreaterThanOrEqualTo(Integer value) {
            addCriterion("privacy >=", value, "privacy");
            return (Criteria) this;
        }

        public Criteria andPrivacyLessThan(Integer value) {
            addCriterion("privacy <", value, "privacy");
            return (Criteria) this;
        }

        public Criteria andPrivacyLessThanOrEqualTo(Integer value) {
            addCriterion("privacy <=", value, "privacy");
            return (Criteria) this;
        }

        public Criteria andPrivacyIn(List<Integer> values) {
            addCriterion("privacy in", values, "privacy");
            return (Criteria) this;
        }

        public Criteria andPrivacyNotIn(List<Integer> values) {
            addCriterion("privacy not in", values, "privacy");
            return (Criteria) this;
        }

        public Criteria andPrivacyBetween(Integer value1, Integer value2) {
            addCriterion("privacy between", value1, value2, "privacy");
            return (Criteria) this;
        }

        public Criteria andPrivacyNotBetween(Integer value1, Integer value2) {
            addCriterion("privacy not between", value1, value2, "privacy");
            return (Criteria) this;
        }

        public Criteria andReserved1IsNull() {
            addCriterion("reserved1 is null");
            return (Criteria) this;
        }

        public Criteria andReserved1IsNotNull() {
            addCriterion("reserved1 is not null");
            return (Criteria) this;
        }

        public Criteria andReserved1EqualTo(Integer value) {
            addCriterion("reserved1 =", value, "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved1NotEqualTo(Integer value) {
            addCriterion("reserved1 <>", value, "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved1GreaterThan(Integer value) {
            addCriterion("reserved1 >", value, "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved1GreaterThanOrEqualTo(Integer value) {
            addCriterion("reserved1 >=", value, "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved1LessThan(Integer value) {
            addCriterion("reserved1 <", value, "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved1LessThanOrEqualTo(Integer value) {
            addCriterion("reserved1 <=", value, "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved1In(List<Integer> values) {
            addCriterion("reserved1 in", values, "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved1NotIn(List<Integer> values) {
            addCriterion("reserved1 not in", values, "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved1Between(Integer value1, Integer value2) {
            addCriterion("reserved1 between", value1, value2, "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved1NotBetween(Integer value1, Integer value2) {
            addCriterion("reserved1 not between", value1, value2, "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved2IsNull() {
            addCriterion("reserved2 is null");
            return (Criteria) this;
        }

        public Criteria andReserved2IsNotNull() {
            addCriterion("reserved2 is not null");
            return (Criteria) this;
        }

        public Criteria andReserved2EqualTo(Integer value) {
            addCriterion("reserved2 =", value, "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved2NotEqualTo(Integer value) {
            addCriterion("reserved2 <>", value, "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved2GreaterThan(Integer value) {
            addCriterion("reserved2 >", value, "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved2GreaterThanOrEqualTo(Integer value) {
            addCriterion("reserved2 >=", value, "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved2LessThan(Integer value) {
            addCriterion("reserved2 <", value, "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved2LessThanOrEqualTo(Integer value) {
            addCriterion("reserved2 <=", value, "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved2In(List<Integer> values) {
            addCriterion("reserved2 in", values, "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved2NotIn(List<Integer> values) {
            addCriterion("reserved2 not in", values, "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved2Between(Integer value1, Integer value2) {
            addCriterion("reserved2 between", value1, value2, "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved2NotBetween(Integer value1, Integer value2) {
            addCriterion("reserved2 not between", value1, value2, "reserved2");
            return (Criteria) this;
        }

        public Criteria andBeaconSizeIsNull() {
            addCriterion("beacon_size is null");
            return (Criteria) this;
        }

        public Criteria andBeaconSizeIsNotNull() {
            addCriterion("beacon_size is not null");
            return (Criteria) this;
        }

        public Criteria andBeaconSizeEqualTo(Integer value) {
            addCriterion("beacon_size =", value, "beaconSize");
            return (Criteria) this;
        }

        public Criteria andBeaconSizeNotEqualTo(Integer value) {
            addCriterion("beacon_size <>", value, "beaconSize");
            return (Criteria) this;
        }

        public Criteria andBeaconSizeGreaterThan(Integer value) {
            addCriterion("beacon_size >", value, "beaconSize");
            return (Criteria) this;
        }

        public Criteria andBeaconSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("beacon_size >=", value, "beaconSize");
            return (Criteria) this;
        }

        public Criteria andBeaconSizeLessThan(Integer value) {
            addCriterion("beacon_size <", value, "beaconSize");
            return (Criteria) this;
        }

        public Criteria andBeaconSizeLessThanOrEqualTo(Integer value) {
            addCriterion("beacon_size <=", value, "beaconSize");
            return (Criteria) this;
        }

        public Criteria andBeaconSizeIn(List<Integer> values) {
            addCriterion("beacon_size in", values, "beaconSize");
            return (Criteria) this;
        }

        public Criteria andBeaconSizeNotIn(List<Integer> values) {
            addCriterion("beacon_size not in", values, "beaconSize");
            return (Criteria) this;
        }

        public Criteria andBeaconSizeBetween(Integer value1, Integer value2) {
            addCriterion("beacon_size between", value1, value2, "beaconSize");
            return (Criteria) this;
        }

        public Criteria andBeaconSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("beacon_size not between", value1, value2, "beaconSize");
            return (Criteria) this;
        }

        public Criteria andBeaconIsNull() {
            addCriterion("beacon is null");
            return (Criteria) this;
        }

        public Criteria andBeaconIsNotNull() {
            addCriterion("beacon is not null");
            return (Criteria) this;
        }

        public Criteria andBeaconEqualTo(String value) {
            addCriterion("beacon =", value, "beacon");
            return (Criteria) this;
        }

        public Criteria andBeaconNotEqualTo(String value) {
            addCriterion("beacon <>", value, "beacon");
            return (Criteria) this;
        }

        public Criteria andBeaconGreaterThan(String value) {
            addCriterion("beacon >", value, "beacon");
            return (Criteria) this;
        }

        public Criteria andBeaconGreaterThanOrEqualTo(String value) {
            addCriterion("beacon >=", value, "beacon");
            return (Criteria) this;
        }

        public Criteria andBeaconLessThan(String value) {
            addCriterion("beacon <", value, "beacon");
            return (Criteria) this;
        }

        public Criteria andBeaconLessThanOrEqualTo(String value) {
            addCriterion("beacon <=", value, "beacon");
            return (Criteria) this;
        }

        public Criteria andBeaconLike(String value) {
            addCriterion("beacon like", value, "beacon");
            return (Criteria) this;
        }

        public Criteria andBeaconNotLike(String value) {
            addCriterion("beacon not like", value, "beacon");
            return (Criteria) this;
        }

        public Criteria andBeaconIn(List<String> values) {
            addCriterion("beacon in", values, "beacon");
            return (Criteria) this;
        }

        public Criteria andBeaconNotIn(List<String> values) {
            addCriterion("beacon not in", values, "beacon");
            return (Criteria) this;
        }

        public Criteria andBeaconBetween(String value1, String value2) {
            addCriterion("beacon between", value1, value2, "beacon");
            return (Criteria) this;
        }

        public Criteria andBeaconNotBetween(String value1, String value2) {
            addCriterion("beacon not between", value1, value2, "beacon");
            return (Criteria) this;
        }

        public Criteria andProbeResponseSizeIsNull() {
            addCriterion("probe_response_size is null");
            return (Criteria) this;
        }

        public Criteria andProbeResponseSizeIsNotNull() {
            addCriterion("probe_response_size is not null");
            return (Criteria) this;
        }

        public Criteria andProbeResponseSizeEqualTo(Integer value) {
            addCriterion("probe_response_size =", value, "probeResponseSize");
            return (Criteria) this;
        }

        public Criteria andProbeResponseSizeNotEqualTo(Integer value) {
            addCriterion("probe_response_size <>", value, "probeResponseSize");
            return (Criteria) this;
        }

        public Criteria andProbeResponseSizeGreaterThan(Integer value) {
            addCriterion("probe_response_size >", value, "probeResponseSize");
            return (Criteria) this;
        }

        public Criteria andProbeResponseSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("probe_response_size >=", value, "probeResponseSize");
            return (Criteria) this;
        }

        public Criteria andProbeResponseSizeLessThan(Integer value) {
            addCriterion("probe_response_size <", value, "probeResponseSize");
            return (Criteria) this;
        }

        public Criteria andProbeResponseSizeLessThanOrEqualTo(Integer value) {
            addCriterion("probe_response_size <=", value, "probeResponseSize");
            return (Criteria) this;
        }

        public Criteria andProbeResponseSizeIn(List<Integer> values) {
            addCriterion("probe_response_size in", values, "probeResponseSize");
            return (Criteria) this;
        }

        public Criteria andProbeResponseSizeNotIn(List<Integer> values) {
            addCriterion("probe_response_size not in", values, "probeResponseSize");
            return (Criteria) this;
        }

        public Criteria andProbeResponseSizeBetween(Integer value1, Integer value2) {
            addCriterion("probe_response_size between", value1, value2, "probeResponseSize");
            return (Criteria) this;
        }

        public Criteria andProbeResponseSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("probe_response_size not between", value1, value2, "probeResponseSize");
            return (Criteria) this;
        }

        public Criteria andProbeResponseIsNull() {
            addCriterion("probe_response is null");
            return (Criteria) this;
        }

        public Criteria andProbeResponseIsNotNull() {
            addCriterion("probe_response is not null");
            return (Criteria) this;
        }

        public Criteria andProbeResponseEqualTo(String value) {
            addCriterion("probe_response =", value, "probeResponse");
            return (Criteria) this;
        }

        public Criteria andProbeResponseNotEqualTo(String value) {
            addCriterion("probe_response <>", value, "probeResponse");
            return (Criteria) this;
        }

        public Criteria andProbeResponseGreaterThan(String value) {
            addCriterion("probe_response >", value, "probeResponse");
            return (Criteria) this;
        }

        public Criteria andProbeResponseGreaterThanOrEqualTo(String value) {
            addCriterion("probe_response >=", value, "probeResponse");
            return (Criteria) this;
        }

        public Criteria andProbeResponseLessThan(String value) {
            addCriterion("probe_response <", value, "probeResponse");
            return (Criteria) this;
        }

        public Criteria andProbeResponseLessThanOrEqualTo(String value) {
            addCriterion("probe_response <=", value, "probeResponse");
            return (Criteria) this;
        }

        public Criteria andProbeResponseLike(String value) {
            addCriterion("probe_response like", value, "probeResponse");
            return (Criteria) this;
        }

        public Criteria andProbeResponseNotLike(String value) {
            addCriterion("probe_response not like", value, "probeResponse");
            return (Criteria) this;
        }

        public Criteria andProbeResponseIn(List<String> values) {
            addCriterion("probe_response in", values, "probeResponse");
            return (Criteria) this;
        }

        public Criteria andProbeResponseNotIn(List<String> values) {
            addCriterion("probe_response not in", values, "probeResponse");
            return (Criteria) this;
        }

        public Criteria andProbeResponseBetween(String value1, String value2) {
            addCriterion("probe_response between", value1, value2, "probeResponse");
            return (Criteria) this;
        }

        public Criteria andProbeResponseNotBetween(String value1, String value2) {
            addCriterion("probe_response not between", value1, value2, "probeResponse");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ap_visitor
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
     * This class corresponds to the database table ap_visitor
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
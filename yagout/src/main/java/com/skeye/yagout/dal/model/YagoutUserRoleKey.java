package com.skeye.yagout.dal.model;

public class YagoutUserRoleKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yagout_user_role.role_no
     *
     * @mbggenerated
     */
    private Integer roleNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yagout_user_role.user_id
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yagout_user_role.role_no
     *
     * @return the value of yagout_user_role.role_no
     *
     * @mbggenerated
     */
    public Integer getRoleNo() {
        return roleNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yagout_user_role.role_no
     *
     * @param roleNo the value for yagout_user_role.role_no
     *
     * @mbggenerated
     */
    public void setRoleNo(Integer roleNo) {
        this.roleNo = roleNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yagout_user_role.user_id
     *
     * @return the value of yagout_user_role.user_id
     *
     * @mbggenerated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yagout_user_role.user_id
     *
     * @param userId the value for yagout_user_role.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
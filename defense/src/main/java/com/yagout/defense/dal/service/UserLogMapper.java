package com.yagout.defense.dal.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yagout.defense.dal.model.UserLog;
import com.yagout.defense.dal.model.UserLogExample;

public interface UserLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_log
     *
     * @mbggenerated
     */
    int countByExample(UserLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_log
     *
     * @mbggenerated
     */
    int deleteByExample(UserLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_log
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_log
     *
     * @mbggenerated
     */
    int insert(UserLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_log
     *
     * @mbggenerated
     */
    int insertSelective(UserLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_log
     *
     * @mbggenerated
     */
    List<UserLog> selectByExampleWithBLOBs(UserLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_log
     *
     * @mbggenerated
     */
    List<UserLog> selectByExample(UserLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_log
     *
     * @mbggenerated
     */
    UserLog selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_log
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") UserLog record, @Param("example") UserLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_log
     *
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") UserLog record, @Param("example") UserLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_log
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") UserLog record, @Param("example") UserLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_log
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(UserLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_log
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(UserLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_log
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(UserLog record);
    
    int insertByList(List<UserLog> list);
}
package com.xqls.dal.service;

import com.xqls.dal.model.Permission;
import com.xqls.dal.model.PermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PermissionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbggenerated
     */
    int countByExample(PermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbggenerated
     */
    int deleteByExample(PermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String permId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbggenerated
     */
    int insert(Permission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbggenerated
     */
    int insertSelective(Permission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbggenerated
     */
    List<Permission> selectByExample(PermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbggenerated
     */
    Permission selectByPrimaryKey(String permId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Permission record, @Param("example") PermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Permission record, @Param("example") PermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Permission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Permission record);
    
    int insertByList(List<Permission> list);
}
package com.example.demo1.service;

import com.example.demo1.entity.Organization;
import com.example.demo1.entity.OrganizationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrganizationService {

    int countByExample(OrganizationExample example) throws Exception;

    int deleteByExample(OrganizationExample example) throws Exception;

    int deleteByPrimaryKey(Integer id) throws Exception;

    int insert(Organization record) throws Exception;

    int insertSelective(Organization record) throws Exception;

    List<Organization> selectByExample(OrganizationExample example) throws Exception;

    Organization selectByPrimaryKey(Integer id) throws Exception;

    int updateByExampleSelective(@Param("record") Organization record, @Param("example") OrganizationExample example) throws Exception;

    int updateByExample(@Param("record") Organization record, @Param("example") OrganizationExample example) throws Exception;

    int updateByPrimaryKeySelective(Organization record) throws Exception;

    int updateByPrimaryKey(Organization record) throws Exception;

    List<Organization> query(Organization record);

}

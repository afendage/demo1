package com.example.demo1.service;

import com.example.demo1.entity.Organization;
import com.example.demo1.entity.OrganizationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrganizationService {

    int countByExample(OrganizationExample example);

    int deleteByExample(OrganizationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Organization record);

    int insertSelective(Organization record);

    List<Organization> selectByExample(OrganizationExample example);

    Organization selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Organization record, @Param("example") OrganizationExample example);

    int updateByExample(@Param("record") Organization record, @Param("example") OrganizationExample example);

    int updateByPrimaryKeySelective(Organization record);

    int updateByPrimaryKey(Organization record);

}

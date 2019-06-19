package com.example.demo1.mapper;

import com.example.demo1.entity.GroupRoleRelation;
import com.example.demo1.entity.GroupRoleRelationExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GroupRoleRelationMapper {
    int countByExample(GroupRoleRelationExample example);

    int deleteByExample(GroupRoleRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GroupRoleRelation record);

    int insertSelective(GroupRoleRelation record);

    List<GroupRoleRelation> selectByExample(GroupRoleRelationExample example);

    GroupRoleRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GroupRoleRelation record, @Param("example") GroupRoleRelationExample example);

    int updateByExample(@Param("record") GroupRoleRelation record, @Param("example") GroupRoleRelationExample example);

    int updateByPrimaryKeySelective(GroupRoleRelation record);

    int updateByPrimaryKey(GroupRoleRelation record);
}
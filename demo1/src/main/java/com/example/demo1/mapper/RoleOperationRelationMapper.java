package com.example.demo1.mapper;

import com.example.demo1.entity.RoleOperationRelation;
import com.example.demo1.entity.RoleOperationRelationExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RoleOperationRelationMapper {
    int countByExample(RoleOperationRelationExample example);

    int deleteByExample(RoleOperationRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoleOperationRelation record);

    int insertSelective(RoleOperationRelation record);

    List<RoleOperationRelation> selectByExample(RoleOperationRelationExample example);

    RoleOperationRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoleOperationRelation record, @Param("example") RoleOperationRelationExample example);

    int updateByExample(@Param("record") RoleOperationRelation record, @Param("example") RoleOperationRelationExample example);

    int updateByPrimaryKeySelective(RoleOperationRelation record);

    int updateByPrimaryKey(RoleOperationRelation record);
}
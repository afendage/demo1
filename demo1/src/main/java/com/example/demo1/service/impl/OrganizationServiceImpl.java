package com.example.demo1.service.impl;

import com.example.demo1.entity.Organization;
import com.example.demo1.entity.OrganizationExample;
import com.example.demo1.mapper.OrganizationMapper;
import com.example.demo1.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationMapper organizationMapper;

    @Override
    public int countByExample(OrganizationExample example) {
        return organizationMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(OrganizationExample example) {
        return organizationMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return organizationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Organization record) {
        return organizationMapper.insert(record);
    }

    @Override
    public int insertSelective(Organization record) {
        return organizationMapper.insertSelective(record);
    }

    @Override
    public List<Organization> selectByExample(OrganizationExample example) {
        return organizationMapper.selectByExample(example);
    }

    @Override
    public Organization selectByPrimaryKey(Integer id) {
        return organizationMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Organization record, OrganizationExample example) {
        return organizationMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Organization record, OrganizationExample example) {
        return organizationMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Organization record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Organization record) {
        return organizationMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Organization> query(Organization record) {
        return organizationMapper.query(record);
    }
}

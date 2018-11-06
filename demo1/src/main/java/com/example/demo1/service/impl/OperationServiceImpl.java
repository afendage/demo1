package com.example.demo1.service.impl;

import com.example.demo1.entity.Operation;
import com.example.demo1.entity.OperationExample;
import com.example.demo1.mapper.OperationMapper;
import com.example.demo1.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    private OperationMapper operationMapper;

    @Override
    public int countByExample(OperationExample example) {
        return operationMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(OperationExample example) {
        return operationMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return operationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Operation record) {
        return operationMapper.insert(record);
    }

    @Override
    public int insertSelective(Operation record) {
        return operationMapper.insertSelective(record);
    }

    @Override
    public List<Operation> selectByExample(OperationExample example) {
        return operationMapper.selectByExample(example);
    }

    @Override
    public Operation selectByPrimaryKey(Integer id) {
        return operationMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Operation record, OperationExample example) {
        return operationMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Operation record, OperationExample example) {
        return operationMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Operation record) {
        return operationMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Operation record) {
        return operationMapper.updateByPrimaryKey(record);
    }
}

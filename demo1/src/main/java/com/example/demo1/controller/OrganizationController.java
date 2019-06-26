package com.example.demo1.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo1.common.ResultInfo;
import com.example.demo1.entity.Organization;
import com.example.demo1.service.OrganizationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 组织结构控制层
 */
@Controller
@RequestMapping("/organization/")
@Slf4j
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @RequestMapping("save")
    public ResultInfo save(HttpServletRequest request,Organization organization){
        try {
            if(null ==organization.getId()){
                organizationService.insertSelective(organization);
            }else{
                organizationService.updateByPrimaryKey(organization);
            }
        } catch (Exception e) {
            log.error("OrganizationController.save error msg:{},param:{}",e.getMessage(), JSONObject.toJSONString(organization));
            return ResultInfo.FAILURE();
        }
        return ResultInfo.SUCCESS();
    }

    public ResultInfo del(HttpServletRequest request,Integer id){
        try {
            Organization organization = new Organization();
            organization.setId(id);
            organization.setStatus(-1);
            organizationService.updateByPrimaryKey(organization);
        } catch (Exception e) {
            log.error("OrganizationController.del error msg:{},param:{}",e.getMessage(),id);
            return ResultInfo.FAILURE();
        }
        return ResultInfo.SUCCESS();
    }

    public ResultInfo query(HttpServletRequest request,Organization organization){
        List<Organization> list=null;
        try {
            list = organizationService.query(organization);
        } catch (Exception e) {
            log.error("OrganizationController.query error msg:{},param:{}",e.getMessage(),JSONObject.toJSONString(organization));
        }
        return ResultInfo.SUCCESS(list);
    }

}

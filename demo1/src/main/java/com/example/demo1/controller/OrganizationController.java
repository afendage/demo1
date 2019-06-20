package com.example.demo1.controller;

import com.example.demo1.common.ResultInfo;
import org.springframework.stereotype.Controller;

@Controller
public class OrganizationController {

    public ResultInfo save(){
        return ResultInfo.SUCCESS();
    }

}

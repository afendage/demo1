package com.example.demo1.entity;

import lombok.Data;

@Data
public class Organization {
    private Integer id;

    private String name;

    private String code;

    private String address;

    private Integer status;
}
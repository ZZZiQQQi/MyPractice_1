package com.example.studentdemo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Student {
    private Integer id;

    private String name;

    private Date birthday;

    private String sex;


}

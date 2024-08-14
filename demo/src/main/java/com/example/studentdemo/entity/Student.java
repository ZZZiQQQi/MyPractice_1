package com.example.studentdemo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private Date birthday;

    private String sex;


}

package com.example.studentdemo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName(value = "student")
@ApiModel(description = "学生表实体")
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    @ApiModelProperty("学生id")
    private Integer id;

    @ApiModelProperty("学生姓名")
    @JsonProperty("name")
    private String name;

    @ApiModelProperty("出生日期")
    private Date birthday;

    @ApiModelProperty("性别")
    private String sex;


}

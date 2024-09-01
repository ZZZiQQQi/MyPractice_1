package com.example.studentdemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

//为什么实现这个 Serializable 接口都在什么时候会用到这个
@Data
public class SampleRoundStatusModel implements Serializable {

    private final static long serialVersionUID = 1L;

//    @JsonProperty
    private Date createTime;

    private Date updateTime;


    private String taskName;

    private Integer sampleId;

    private Integer round;


}

package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.example.demo.config.ListTypeHandler;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
//autoResultMap = true
@TableName(value = "airline")
@Data
@EqualsAndHashCode(callSuper = false)
public class Airline implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String lineName;

    private LocalDateTime createTime;

//    @TableField(jdbcType = JdbcType.VARCHAR, typeHandler = ListTypeHandler.class)
//    typeHandler = JacksonTypeHandler.class
//    @TableField(typeHandler = JacksonTypeHandler.class)
    @TableField(typeHandler = ListTypeHandler.class)
    private List<LineDetails> lineDetails;

}

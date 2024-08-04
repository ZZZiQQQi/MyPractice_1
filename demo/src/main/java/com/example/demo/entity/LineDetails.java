package com.example.demo.entity;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class LineDetails implements Serializable {

    @Serial
    private static final long serialVersionUID = 1l;

    private Integer id;

    private Double position;

    private Double lat;

    private Double lng;

}

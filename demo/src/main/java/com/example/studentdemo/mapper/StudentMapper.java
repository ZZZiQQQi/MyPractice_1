package com.example.studentdemo.mapper;

import com.example.studentdemo.entity.Student;
import org.springframework.stereotype.Component;

import java.util.List;

public interface StudentMapper {

    List<Student> selectByIds(List<Integer> ids);


}

package com.example.studentdemo.service;

import com.example.studentdemo.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getByIds(List<Integer> ids);

    //TODO 返回新增记录的主键id
    void add(Student student);
}

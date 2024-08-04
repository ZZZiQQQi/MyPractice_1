package com.example.studentdemo.service.impl;

import com.example.studentdemo.entity.Student;
import com.example.studentdemo.mapper.StudentMapper;
import com.example.studentdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public List<Student> getByIds(List<Integer> ids) {

        return studentMapper.selectByIds(ids);
    }
}

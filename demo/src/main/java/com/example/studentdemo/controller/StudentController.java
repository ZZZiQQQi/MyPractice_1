package com.example.studentdemo.controller;

import com.example.studentdemo.entity.Student;
import com.example.studentdemo.mapper.StudentMapper;
import com.example.studentdemo.result.Result;
import com.example.studentdemo.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/student")
@RestController
@Api(tags = "学生管理接口")
public class StudentController {

    @Autowired
    StudentService studentService;

    @ApiOperation("根据id查询学生列表")
    @GetMapping("/students")
    public List<Student> selectByIds(@RequestParam List<Integer> ids) {
        return studentService.getByIds(ids);
    }

    @ApiOperation("添加学生记录")
    @PostMapping("/add")
    public Student add(@RequestBody Student student) {
        System.out.println("你好"+student);
        studentService.add(student);
        return student;
    }
}

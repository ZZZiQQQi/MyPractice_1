package com.example.studentdemo.controller;

import com.example.studentdemo.entity.Student;
import com.example.studentdemo.mapper.StudentMapper;
import com.example.studentdemo.result.Result;
import com.example.studentdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/student")
@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public List<Student> selectByIds(@RequestParam List<Integer> ids) {
        return studentService.getByIds(ids);
    }

    @PostMapping("/add")
    public Result<Student> add(@RequestBody Student student) {
        System.out.println("你好"+student);
        studentService.add(student);
        return Result.success(student);
    }
}

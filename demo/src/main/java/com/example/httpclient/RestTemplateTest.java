package com.example.httpclient;

import com.alibaba.fastjson.JSONObject;
import com.example.studentdemo.entity.Student;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@Data
@RestController()
@RequestMapping("/restTemplate")
public class RestTemplateTest {
    @Value("${address}")
    private String address;


    @PostMapping("student/add")
    public void post(@RequestBody JSONObject jsonObject) {

        String url = address + "/student/add";

        ResponseEntity responseEntity = RestTemplateUtils.postJson(url,jsonObject, Student.class);

        System.out.println(responseEntity.getBody());
    }

    @GetMapping("student/students")
    public void getStudents(@RequestParam("id") Integer id) {


    }
}

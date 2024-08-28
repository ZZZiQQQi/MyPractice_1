package com.example.httpclient;

import com.alibaba.fastjson.JSONObject;
import com.example.studentdemo.entity.Student;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@Data
@RestController()
@RequestMapping("/restTemplate")
public class RestTemplateTest {
    @Value("${address}")
    private String address;


    @PostMapping("student/add")
    public void post(@RequestBody JSONObject jsonObject) {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<JSONObject> entity = new HttpEntity<>(jsonObject, headers);

        System.out.println(address+"/student/add");

        ResponseEntity<Student> response =
                restTemplate.exchange(address+"/student/add", HttpMethod.POST,entity,Student.class);

        System.out.println(response.getHeaders().getContentType());
        System.out.println(response.getBody());
    }
}

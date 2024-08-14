package com.example.httpclient;

import com.alibaba.fastjson.JSON;
import com.example.studentdemo.entity.Student;
import com.example.studentdemo.result.Result;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/http")
public class HttpClientTest {

    @PostMapping("/add")
    public Result<Student> add(@RequestBody Student student) {
        System.out.println("学生"+student);

        String studentJson  = JSON.toJSONString(student);

        System.out.println("json参数"+studentJson);
        try(CloseableHttpClient httpClient = HttpClients.createDefault()){

            HttpPost httpPost = new HttpPost("http://localhost:8081/myapp/student/add");
            httpPost.setEntity(new StringEntity(studentJson,"UTF-8"));
            httpPost.setHeader("Content-Type", "application/json");

            HttpResponse response = httpClient.execute(httpPost);

            System.out.println("Response message: " + response.getStatusLine());
            System.out.println("Response entity: " + EntityUtils.toString(response.getEntity()));
            System.out.println(response.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Result.success(student);
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.setId(1);
        student.setName("张子奇");
        student.setSex("男");
        System.out.println(JSON.toJSONString(student));
    }
}

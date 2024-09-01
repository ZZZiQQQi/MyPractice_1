package com.example.studentdemo.controller;

import com.example.studentdemo.entity.SampleRoundStatusModel;
import com.example.studentdemo.service.ITaskService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/task")
@Api("任务管理")
public class TaskController {

    @Autowired
    ITaskService taskService;

    @GetMapping("/taskInfo")
    public List<SampleRoundStatusModel> getTaskInfo(){

        return taskService.getTaskInfo();
    }

    @GetMapping("/sampleInfo/{id}")
    public List<SampleRoundStatusModel> getSampleInfo(@PathVariable Integer id){
        return taskService.getSampleInfo(id);
    }

}

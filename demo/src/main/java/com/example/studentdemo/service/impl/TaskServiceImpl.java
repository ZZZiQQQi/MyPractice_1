package com.example.studentdemo.service.impl;

import com.example.studentdemo.entity.SampleRoundStatusModel;
import com.example.studentdemo.mapper.SampleRoundStatusModelMapper;
import com.example.studentdemo.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements ITaskService {

    @Autowired
    SampleRoundStatusModelMapper mapper;


    @Override
    public List<SampleRoundStatusModel> getTaskInfo() {
        return mapper.getTaskInfo();
    }

    @Override
    public List<SampleRoundStatusModel> getSampleInfo(Integer id) {
        return mapper.getSampleInfo(id);
    }
}

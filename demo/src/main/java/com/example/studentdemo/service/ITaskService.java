package com.example.studentdemo.service;

import com.example.studentdemo.entity.SampleRoundStatusModel;

import java.util.List;

public interface ITaskService {
    public List<SampleRoundStatusModel> getTaskInfo();

    public List<SampleRoundStatusModel> getSampleInfo(Integer id);
}

package com.example.studentdemo.mapper;

import com.example.studentdemo.entity.SampleRoundStatusModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface SampleRoundStatusModelMapper {

   List<SampleRoundStatusModel> getTaskInfo();

   List<SampleRoundStatusModel> getSampleInfo(Integer id);
}

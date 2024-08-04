package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Airline;
import com.example.demo.mapper.AirlineMapper;
import com.example.demo.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
//@Transactional
public class AirlineServiceImpl extends ServiceImpl<AirlineMapper, Airline> implements AirlineService {
}

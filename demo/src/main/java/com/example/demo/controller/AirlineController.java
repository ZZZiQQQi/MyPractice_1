package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.Airline;
import com.example.demo.resutl.Result;
import com.example.demo.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/airLine")
public class AirlineController {

    @Autowired
    AirlineService airlineService;

    @PostMapping("/save")
    public void addAirline(@RequestBody Airline airline){

        airline.setCreateTime(LocalDateTime.now());

        airlineService.save(airline);
    }

    @GetMapping("/getAll")
    public List<Airline> getAllAirlines(){
        List<Airline> airlines;
        airlines = airlineService.list();
        System.out.println(airlines);
        return airlines;
    }

//    @GetMapping("/airlines")
//    public List<Airline> getAirLines(){
//
//    }
    @GetMapping("/getOne")
    public Result<Airline> getOneAirline(@RequestParam("id") Integer id){
        QueryWrapper<Airline> wrapper = new QueryWrapper<>();
        wrapper.select("lineName","createTime","lineDetails");
        wrapper.eq("id", id);
        Airline airline = airlineService.getOne(wrapper);
        return Result.success(airline);
    }
}

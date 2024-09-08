package com.example.websocket.controller;

import com.example.demo.resutl.Result;
import com.example.websocket.RemoteServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/socket")
public class SocketController {

    @Autowired
    RemoteServerService remoteServerService;

    @Value("${remoteUrl}")
    String remoteUrl;

    @GetMapping("/start")
    public Result socketStart() {

        remoteServerService.connectToRemoteServer(remoteUrl);

        return Result.success("与远程websocket建立成功，开始接收数据");
    }
}

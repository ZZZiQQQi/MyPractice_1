package com.example.demo.config;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint("/websocket")
@Component
public class MyWebSocket {

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("new connection" + session.getId());
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        System.out.println("receive message" + message);
        session.getBasicRemote().sendText("接收到消息"+message);
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        System.out.println("session closed" + session.getId());
    }

}

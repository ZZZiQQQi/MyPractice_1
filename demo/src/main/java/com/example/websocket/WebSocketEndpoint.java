package com.example.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
@ServerEndpoint("/websocket1")
@CrossOrigin
public class WebSocketEndpoint {

    private static final Map<String, List<Session>> sessionMap = new ConcurrentHashMap<>();

    @Autowired
    private RemoteServerService remoteServerService;

    @OnOpen
    public void onOpen(Session session) {
//        System.out.println(session.getId());
//        String userId = getUserIdFromSession(session);
        sessionMap.computeIfAbsent("userId", k -> new CopyOnWriteArrayList<>()).add(session);
    }

    @OnClose
    public void onClose(Session session) {
        String userId = getUserIdFromSession(session);
        sessionMap.getOrDefault(userId, Collections.emptyList()).remove(session);
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        String userId = getUserIdFromSession(session);

        // 处理客户端发送的消息,例如将消息转发给远程服务器
        remoteServerService.sendMessageToRemoteServer(userId, message);
    }

    @OnError
    public void onError(Throwable error) {
        // 处理WebSocket连接或通信过程中的错误
        error.printStackTrace();
    }

    private String getUserIdFromSession(Session session) {
        // 从Session中获取用户标识符,例如从HTTP握手请求的查询参数中获取
        return session.getRequestParameterMap().get("userId").get(0);
    }

    public void sendMessageToUser(String userId, String message) {
        // 向指定用户发送消息
        for (Session session : sessionMap.get(userId)) {
            session.getAsyncRemote().sendText(message);
        }

    }
}


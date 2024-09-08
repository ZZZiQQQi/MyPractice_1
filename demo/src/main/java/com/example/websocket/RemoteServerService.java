package com.example.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@ClientEndpoint
public class RemoteServerService {

    private final Map<String, Session> remoteSessions = new ConcurrentHashMap<>();

    @Autowired
    private ApplicationContext applicationContext;

    public void connectToRemoteServer(String remoteUrl) {
        try {
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            Session session = container.connectToServer(this, new URI(remoteUrl));
            remoteSessions.put(remoteUrl, session);
        } catch (Exception e) {
            // 处理连接远程服务器时的异常
            e.printStackTrace();
        }
    }

    public void disconnectFromRemoteServer(String remoteUrl) {
        Session session = remoteSessions.remove(remoteUrl);
        if (session != null) {
            try {
                session.close();
            } catch (IOException e) {
                // 处理关闭连接时的异常
                e.printStackTrace();
            }
        }
    }

    public void sendMessageToRemoteServer(String userId, String message) {
        // 将消息发送给远程服务器
        for (Session session : remoteSessions.values()) {
            session.getAsyncRemote().sendText("User " + userId + ": " + message);
        }
    }

    @OnMessage
    public void onMessageFromRemoteServer(String message, Session session) {
        // 处理从远程服务器接收到的消息
        // 可以根据需要将消息转发给客户端
        WebSocketEndpoint webSocketEndpoint = applicationContext.getBean(WebSocketEndpoint.class);
        webSocketEndpoint.sendMessageToUser("userId", "Remote Server: " + message);
    }
}
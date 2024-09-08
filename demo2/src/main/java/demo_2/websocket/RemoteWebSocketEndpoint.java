package demo_2.websocket;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
@ServerEndpoint("/websocket2")
public class RemoteWebSocketEndpoint {

    private static final Set<Session> sessions = new CopyOnWriteArraySet<>();
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();;



    @OnOpen
    public void onOpen(Session session) {
        executor.scheduleAtFixedRate(() -> {
            try {
                // 模拟远程服务器发送数据
                String message = generateRandomMessage();
                session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, 0, 1, TimeUnit.SECONDS);
    }

    @OnClose
    public void onClose(Session session) {
        sessions.remove(session);
        System.out.println("WebSocket连接关闭: " + session.getId());
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("收到来自客户端的消息: " + message);

        // 处理收到的消息,例如将消息广播给所有连接的客户端
        broadcastMessage("服务器接收到消息: " + message);
    }

    @OnError
    public void onError(Throwable error) {
        System.out.println("WebSocket连接发生错误: " + error.getMessage());
    }

    private void broadcastMessage(String message) {
        for (Session session : sessions) {
            try {
                session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String generateRandomMessage() {
        // 生成随机消息的逻辑
        // 这里只是一个简单的示例,你可以根据实际需求生成适当的消息
        return "Random message from remote server: " + Math.random();
    }
}

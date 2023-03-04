package com.tjf.spring.config.webSocket;

import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

@ServerEndpoint("/wsUrl")
public class WebsocketEndPoint {
    //连接人数
    private static int onlineCounts=0;
    private Timer timer;
    private static final Logger LOGGER = LoggerFactory.getLogger(WebsocketEndPoint.class);
    private static Map<Object,WebSocketSession> users;
    static {
        users=new HashMap<Object,WebSocketSession>();
    }
    @OnOpen
    public void opOpen(Session session){
        LOGGER.info("连接建立后处理方法");
//        users.put((HttpSession)session.getAttributes().get("USER_ID"),session);
//        timer = new Timer(true);
//        LoadDataTask task = new LoadDataTask(session);
//        timer.schedule(task, 1000, 1000);
    }
    @OnMessage
    protected void handleTextMessage(String message,Session session){
        LOGGER.info("返回报文");
    }

    @OnClose
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        if (!session.isOpen()) {
            LOGGER.info("连接已关闭");
            timer.cancel();
        }
        LOGGER.info("连接关闭后处理方法");
    }

    @OnError
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        LOGGER.info("抛出异常时处理方法");
    }

    // 内部类实现数据获取
//    class LoadDataTask extends TimerTask {
//        private WebSocketSession session;
//
//        public WebSocketSession getSession() {
//            return session;
//        }
//
//        public void setSession(WebSocketSession session) {
//            this.session = session;
//        }
//
//        public LoadDataTask() {
//            super();
//        }

//        public LoadDataTask(WebSocketSession session) {
//            super();
//            this.session = session;
//        }
//
//        @Override
//        public void run() {
//            Set<String> set = RandomUtils.getInfo(6);// 生成一个不重复随机数set
//            System.out.println(set);
//            String jsonObject = JSONObject.toJSONString(set);
//            System.out.println(jsonObject);
//            TextMessage textMessage = new TextMessage(jsonObject);
//            try {
//                handleTextMessage(session, textMessage);
//            } catch (Exception e) {
//                e.printStackTrace();
//                LOGGER.error(e.getMessage(), e);
//            }
//        }
//
//    }
}

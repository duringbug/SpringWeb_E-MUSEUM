package com.tjf.spring.config.webSocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import javax.servlet.http.HttpSession;
import java.util.Map;

public class HandshakeInterceptor extends HttpSessionHandshakeInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(HandshakeInterceptor.class);

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
            Exception ex) {
        LOGGER.info("创建握手后...");
        super.afterHandshake(request, response, wsHandler, ex);
    }

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
            Map<String, Object> attributes) throws Exception {
        LOGGER.info("握手完成前...");
        if (request instanceof HttpRequest){
            ServletServerHttpRequest httpRequest=(ServletServerHttpRequest) request;
            HttpSession session = httpRequest.getServletRequest().getSession();
            if (session!=null){
                //放入attributes中在wsHandler中调用websocketSession.getAttributes.get("cueEnetSession")即可获得session
                attributes.put("currentSession",session);
            }
        }
        return super.beforeHandshake(request, response, wsHandler, attributes);
    }
}

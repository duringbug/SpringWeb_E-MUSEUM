package com.tjf.spring.config.webSocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author 唐健峰
 * @version 1.0
 * @date 2023/1/23 09:15
 * @description:webSocket的配置类
 */
@Configuration
//@EnableWebSocket
public class WebSocketConfig/* implements WebSocketConfigurer*/{
    @Bean
    public WebsocketEndPoint websocketEndPoint(){
        return new WebsocketEndPoint();
    }
    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
//    @Override
//    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//        registry.addHandler(myHandler(), "/wsUrl")
//                .addInterceptors(new HandshakeInterceptor())
//                .setAllowedOrigins("*");
//        registry.addHandler(myHandler(), "/sockjs")
//                .addInterceptors(new HandshakeInterceptor())
//                .setAllowedOrigins("*").withSockJS();
//    }
//
//    @Bean
//    public WebSocketHandler myHandler() {
//        return new WebsocketEndPoint();
//    }
//    @Bean
//    public HttpSessionHandshakeInterceptor httpSessionHandshakeInterceptor(){
//        return  new HttpSessionHandshakeInterceptor();
//    }
//    @Bean
//    public ServerEndpointExporter serverEndpointExporter(){
//        return new ServerEndpointExporter();
//    }
}

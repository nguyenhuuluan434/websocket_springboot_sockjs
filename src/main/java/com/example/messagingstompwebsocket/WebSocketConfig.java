package com.example.messagingstompwebsocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/*indicate that it is a Spring configuration*/
@Configuration
/* enables WebSocket message handling, backed by a message broker.*/
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    /*to configure the message broker*/
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        /*enable a simple memory-based message broker to carry the greeting messages back to the client on destinations prefixed with /topic*/
        registry.enableSimpleBroker("/topic");
        /*It also designates the /app prefix for messages that are bound for methods annotated with @MessageMapping*/
        /*This prefix will be used to define all the message mappings*/
        registry.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
/*The registerStompEndpoints() method registers the /gs-guide-websocket endpoint,
 enabling SockJS fallback options so that alternate transports can be used if WebSocket is not available.
  The SockJS client will attempt to connect to /gs-guide-websocket and use the best available transport (websocket, xhr-streaming, xhr-polling, and so on).
 */
        registry.addEndpoint("/gs-guide-websocket").withSockJS();
    }
}

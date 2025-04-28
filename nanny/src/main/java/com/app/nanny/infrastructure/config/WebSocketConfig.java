package com.app.nanny.infrastructure.config;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{


    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Endpoint para conectar desde el frontend
        registry.addEndpoint("/ws").setAllowedOriginPatterns("*").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // Canales donde se puede suscribir el cliente
        config.enableSimpleBroker("/topic");
        // Prefijo para los mensajes enviados desde el cliente
        config.setApplicationDestinationPrefixes("/app");
    }
}

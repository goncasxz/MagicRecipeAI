package dev.java10x.MagicFridgeAI.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Value("${gemini.api.url}")
    private String geminiApiUrl;

    @Value("${gemini.api.key}")
    private String geminiApiKey;

    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        return builder
        .baseUrl(geminiApiUrl + "?key=" + geminiApiKey)
                .defaultHeader("Content-Type", "application/json")
                .build();
    }
}

package com.example.api_logs.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class ExternalApi {
    private final WebClient webClient;


    public ExternalApi(WebClient webClient) {
        this.webClient = webClient;
    }

    public String getUsers() {
        return webClient.get()
                .uri("/users")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public String getPosts() {
        return webClient.get()
                .uri("/posts")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }


    public String getAlbums() {
        return webClient.get()
                .uri("/albums")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }


}

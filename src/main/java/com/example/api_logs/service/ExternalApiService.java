package com.example.api_logs.service;

import com.example.api_logs.client.ExternalApi;
import org.springframework.stereotype.Service;

@Service
public class ExternalApiService {
    private final ExternalApi externalApi;

    public ExternalApiService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public void getUser(){
        externalApi.getUsers();
    }
}

package com.example.api_logs.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LogResponseDto {
    private Long id;
    private String method;
    private String endpoint;
    private String response;
    private LocalDate createdAt;

    public LogResponseDto(long id, String method, String endpoint, String response, LocalDate createdAt) {
    }
}

package com.example.api_logs.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LogRequestDto {
    private String method;
    private String endpoint;
    private String response;
}

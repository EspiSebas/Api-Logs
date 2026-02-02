package com.example.api_logs.dto;

import lombok.Data;

@Data
public class PostDto {
    private Long userId;
    private Long id;
    private String title;
    private String body;

}

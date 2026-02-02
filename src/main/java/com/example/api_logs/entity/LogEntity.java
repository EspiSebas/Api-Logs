package com.example.api_logs.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name="logs")
@NoArgsConstructor
@Data
@Getter
@Setter
@AllArgsConstructor
public class LogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String method;
    private String endpoint;
    @Lob
    @Column(name = "data_response",columnDefinition = "TEXT")
    private String response;
    private LocalDate createdAt;
}

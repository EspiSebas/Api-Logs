package com.example.api_logs.service;

import com.example.api_logs.dto.LogRequestDto;
import com.example.api_logs.dto.LogResponseDto;
import com.example.api_logs.entity.LogEntity;
import com.example.api_logs.repository.LogsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LogService {
    private final LogsRepository logsRepository;

    public LogService(LogsRepository logsRepository) {
        this.logsRepository = logsRepository;
    }

    public void createLog(String method,String endpoint, String response){
        LogEntity log = new LogEntity();
        log.setMethod(method);
        log.setEndpoint(endpoint);
        log.setResponse(response);
        log.setCreatedAt(LocalDate.now());
        logsRepository.save(log);
    }


    public List<LogResponseDto> getAllLogs(){
        return logsRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
    }


    private LogResponseDto mapToDto(LogEntity log) {
        LogResponseDto dto = new LogResponseDto();
        dto.setId(log.getId());
        dto.setMethod(log.getMethod());
        dto.setEndpoint(log.getEndpoint());
        dto.setResponse(log.getResponse());
        dto.setCreatedAt(log.getCreatedAt());
        return dto;
    }

    public void deleteLog(Long id){
        logsRepository.deleteById(id);
    }


    public LogResponseDto updateLog(Long id, LogRequestDto request) {

        LogEntity log = logsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Log not found"));

        if (request.getMethod() != null) {
            log.setMethod(request.getMethod());
        }
        if (request.getEndpoint() != null) {
            log.setEndpoint(request.getEndpoint());
        }
        if (request.getResponse() != null) {
            log.setResponse(request.getResponse());
        }

        logsRepository.save(log);

        return new LogResponseDto(
                log.getId(),
                log.getMethod(),
                log.getEndpoint(),
                log.getResponse(),
                log.getCreatedAt()
        );
    }

}

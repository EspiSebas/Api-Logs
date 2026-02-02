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
                .map(l->new LogResponseDto(
                        l.getId(),
                        l.getMethod(),
                        l.getEndpoint(),
                        l.getResponse(),
                        l.getCreatedAt()
                ))
                .toList();
    }

    public void deleteLog(Long id){
        logsRepository.deleteById(id);
    }
}

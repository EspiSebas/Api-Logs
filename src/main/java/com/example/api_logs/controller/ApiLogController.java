package com.example.api_logs.controller;


import com.example.api_logs.dto.LogRequestDto;
import com.example.api_logs.dto.LogResponseDto;
import com.example.api_logs.service.LogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiLogController {
    private final LogService logService;

    public ApiLogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/logs/all")
    public List<LogResponseDto> getAllLogs() {
        return logService.getAllLogs();
    }

    @DeleteMapping("/log/delete/{id}")
    public ResponseEntity<String> deleteLog(@PathVariable Long id){
        logService.deleteLog(id);
        return ResponseEntity.ok("Logs deleted successfully");
    }

    @PatchMapping("/log/update/{id}")
    public ResponseEntity<LogResponseDto> updateLog(
            @PathVariable Long id,
            @RequestBody LogRequestDto request
    ) {
        LogResponseDto updated = logService.updateLog(id, request);
        return ResponseEntity.ok(updated);
    }

}

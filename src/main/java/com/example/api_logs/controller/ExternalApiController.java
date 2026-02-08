package com.example.api_logs.controller;

import com.example.api_logs.dto.AlbumDto;
import com.example.api_logs.dto.PostDto;
import com.example.api_logs.dto.UserDto;
import com.example.api_logs.service.ExternalApiService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/external")
public class ExternalApiController {
    private final ExternalApiService externalApiService;

    public ExternalApiController(ExternalApiService externalApiService) {
        this.externalApiService = externalApiService;
    }

    @GetMapping("/users")
    public List<UserDto> getUsers(){
        return externalApiService.getUser();
    }

    @GetMapping("/posts")
    public List<PostDto> getPosts(){
        return externalApiService.getPosts();
    }

    @GetMapping("albums")
    public List<AlbumDto> getAlbumByUser(@RequestParam("userId") Long userId){
        return externalApiService.getAlbumByUser(userId);
    }


}

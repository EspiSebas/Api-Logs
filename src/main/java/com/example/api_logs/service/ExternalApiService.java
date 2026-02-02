package com.example.api_logs.service;

import com.example.api_logs.client.ExternalApi;
import com.example.api_logs.dto.AlbumDto;
import com.example.api_logs.dto.PostDto;
import com.example.api_logs.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExternalApiService {


    private final ExternalApi externalApi;
    private final LogService logService;

    public ExternalApiService(ExternalApi externalApi, LogService logService) {
        this.externalApi = externalApi;
        this.logService = logService;
    }

    public List<UserDto> getUser(){
        List<UserDto> users = externalApi.getUsers();
        logService.createLog("GET","/users", users.toString());
        return users;
    }

    public List<PostDto> getPosts(){
        List<PostDto> posts = externalApi.getPosts();
        logService.createLog("GET","/posts", posts.toString());
        return posts;
    }

    public List<AlbumDto> getAlbumByUser(Long id){
        List<AlbumDto> albumByUser = externalApi.getAlbumByUser(id);
        logService.createLog("GET","/albums?userId=" + id, albumByUser.toString());
        return albumByUser;
    }

}

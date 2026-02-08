package com.example.api_logs.service;

import com.example.api_logs.client.ExternalApi;
import com.example.api_logs.dto.AlbumDto;
import com.example.api_logs.dto.PostDto;
import com.example.api_logs.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExternalApiService {

    private static final String method = "GET";
    private static final String response = "HTTP 200 OK";

    private final ExternalApi externalApi;
    private final LogService logService;

    public ExternalApiService(ExternalApi externalApi, LogService logService) {
        this.externalApi = externalApi;
        this.logService = logService;
    }

    public List<UserDto> getUser(){
        List<UserDto> users = externalApi.getUsers();
        logService.createLog(method,"/users",response);
        return users;
    }

    public List<PostDto> getPosts(){
        List<PostDto> posts = externalApi.getPosts();
        logService.createLog(method,"/posts", response);
        return posts;
    }

    public List<AlbumDto> getAlbumByUser(Long id){
        List<AlbumDto> albumByUser = externalApi.getAlbumByUser(id);
        logService.createLog(method,"/albums?userId=" + id, response);
        return albumByUser;
    }

    public List<PostDto> getPostByUser(Long id){
        List<PostDto> postByUser = externalApi.getPostByUser(id);
        logService.createLog(method,"/posts?userId="+id,response);
        return postByUser;
    }

}

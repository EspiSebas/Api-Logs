package com.example.api_logs.client;

import com.example.api_logs.dto.AlbumDto;
import com.example.api_logs.dto.PostDto;
import com.example.api_logs.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "externalApi",
        url = "https://jsonplaceholder.typicode.com")
public interface ExternalApi {
    @GetMapping("/users")
    List<UserDto> getUsers();

    @GetMapping("/posts")
    List<PostDto> getPosts();

    @GetMapping("/albums")
    List<AlbumDto> getAlbumByUser(@RequestParam Long userId);
}

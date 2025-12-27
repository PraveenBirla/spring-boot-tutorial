package com.example.demo.Controllers;

import com.example.demo.dto.PostsDTO;
import com.example.demo.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {


     private final PostService postService;

    @PostMapping
    public PostsDTO addPost(@RequestBody PostsDTO postsDTO){
        return postService.addPost(postsDTO);
    }
}

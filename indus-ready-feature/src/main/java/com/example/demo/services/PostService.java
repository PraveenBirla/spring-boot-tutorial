package com.example.demo.services;

import com.example.demo.dto.PostsDTO;
import com.example.demo.entities.PostEntity;
import com.example.demo.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final ModelMapper modelMapper;

   private final PostRepository postRepository;
    public PostsDTO addPost(PostsDTO postsDTO) {
       PostEntity postEntity =  modelMapper.map(postsDTO , PostEntity.class);
        postRepository.save(postEntity);

       return modelMapper.map(postEntity , PostsDTO.class);

    }
}

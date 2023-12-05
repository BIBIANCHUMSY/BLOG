package com.fashion.blog.service.impl;

import com.fashion.blog.entity.Like;
import com.fashion.blog.entity.Post;
import com.fashion.blog.exception.ResourceNotFoundException;
import com.fashion.blog.payload.LikeDto;
import com.fashion.blog.repository.LikeRepository;
import com.fashion.blog.repository.PostRepository;
import com.fashion.blog.service.LikeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService {
    private final ModelMapper mapper;
    private final PostRepository postRepository;
    private final LikeRepository likeRepository;

    @Autowired
    public LikeServiceImpl(ModelMapper mapper, LikeRepository likeRepository, PostRepository postRepository) {
        this.mapper = mapper;
        this.likeRepository = likeRepository;
        this.postRepository = postRepository;
    }

    //Using Model Mapper Dependency mapper.map
    private LikeDto mapToDto(Like like){
        LikeDto likeDto = mapper.map(like, LikeDto.class);
        return likeDto;
    }

    //converted DTO to Entity
    //Using Model Mapper Dependency mapper.map
    private Like mapToEntity(LikeDto likeDto){
        Like like = mapper.map(likeDto, Like.class);

        return like;
    }


    @Override
    public LikeDto createLike(Long postId, LikeDto likeDto) {
        Like like = mapToEntity(likeDto);

        Post post = postRepository.findById(postId).orElseThrow(
                ()-> new ResourceNotFoundException("Post", "id", postId));

        like.setPost(post);

        Like newLike = likeRepository.save(like);

        return mapToDto(newLike);
    }
}

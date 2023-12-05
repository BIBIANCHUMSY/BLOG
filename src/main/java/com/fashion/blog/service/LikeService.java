package com.fashion.blog.service;

import com.fashion.blog.payload.LikeDto;

public interface LikeService {

    LikeDto createLike(Long postId, LikeDto likeDto);
}

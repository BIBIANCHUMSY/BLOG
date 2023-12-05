package com.fashion.blog.service;

import com.fashion.blog.payload.CommentDto;

import java.util.List;

public interface CommentService {

    CommentDto createComments(Long postId, CommentDto commentDto);

    List<CommentDto> getCommentsByPostId(Long postId);

    CommentDto getCommentById(Long postId, Long commentId);

    CommentDto updateComment(Long postId, Long commentId, CommentDto commentRequest);

    void deleteComment(Long postId, Long commentId);
}

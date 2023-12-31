package com.fashion.blog.controller;

import com.fashion.blog.entity.Comment;
import com.fashion.blog.payload.CommentDto;
import com.fashion.blog.service.CommentService;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CommentController {
    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable(value = "postId") Long postId,
                                                    @RequestBody @Valid CommentDto commentDto){
        return new ResponseEntity<>(commentService.createComments(postId,commentDto), HttpStatus.CREATED);
    }

    @GetMapping("/posts/{postId}/comments")
    public List<CommentDto> getCommentsByPostId(@PathVariable (value = "postId") Long postId){
        return commentService.getCommentsByPostId(postId);
    }

    @GetMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable(value = "postId") Long postId,
                                                     @PathVariable(value = "id") Long commentId){
        CommentDto commentDto = commentService.getCommentById(postId, commentId);
        return new ResponseEntity<>(commentDto, HttpStatus.OK);

    }

    @PutMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDto> updateComment(
            @PathVariable (value = "postId") Long postId,
            @PathVariable (value = "id") Long commentId,
            @RequestBody @Valid CommentDto commentDto){

        CommentDto updatedComment = commentService.updateComment(postId, commentId, commentDto);
        return new ResponseEntity<>(updatedComment,HttpStatus.OK);

    }

    @DeleteMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable(value = "postId") Long postId,
                                                @PathVariable(value = "id") Long commentId){
        commentService.deleteComment(postId,commentId);

        return new ResponseEntity<>("Comment deleted successfully", HttpStatus.OK);
    }
}

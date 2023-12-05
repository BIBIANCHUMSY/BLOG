package com.fashion.blog.controller;

import com.fashion.blog.payload.LikeDto;
import com.fashion.blog.service.LikeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class LikeController {

    private final LikeService likeservice;

    @Autowired
    public LikeController(LikeService likeservice) {
        this.likeservice = likeservice;
    }

    @PostMapping("{postId}/like")
    public ResponseEntity<LikeDto> createLike(@PathVariable(value = "postId") Long postId,
                                             @RequestBody @Valid LikeDto likeDto
                                             ){
        return new ResponseEntity<>(likeservice.createLike(postId, likeDto), HttpStatus.CREATED);
    }
}

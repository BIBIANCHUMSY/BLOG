package com.fashion.blog.payload;

import com.fashion.blog.entity.Emogi;
import com.fashion.blog.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LikeDto {
    private Long id;
    private String name;
    private String email;
    private String emogi;
    private Post post;
}

package com.fashion.blog.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private Long id;

    @NotEmpty
    @Size(min = 2, message = "Post title should have at least2 characters")
    private String title;

    @NotEmpty
    @Size(min = 10, message = "Post description should have at least 10 characters ")
    private String description;

    @NotEmpty
    private String content;
    private Set<CommentDto> comments;
}

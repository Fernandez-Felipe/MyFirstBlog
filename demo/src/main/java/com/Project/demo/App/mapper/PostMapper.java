package com.Project.demo.App.mapper;

import com.Project.demo.App.domain.Post;
import com.Project.demo.App.dto.PostDto;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {

    public Post mapToPost(PostDto postInput){
        return Post.builder()
                .title(postInput.getTitle())
                .description(postInput.getDescription())
                .body(postInput.getBody())
                .slug(postInput.getSlug())
                .poststatus(postInput.getPostStatus())
                .build();
    }

    public PostDto mapToPostDto(Post post){
        return  PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .description(post.getDescription())
                .body(post.getBody())
                .slug(post.getSlug())
                .postStatus(post.getPoststatus())
                .build();
    }

}

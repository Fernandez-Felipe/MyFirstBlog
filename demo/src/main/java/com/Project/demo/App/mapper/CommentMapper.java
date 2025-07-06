package com.Project.demo.App.mapper;

import com.Project.demo.App.Repository.PostRepository;
import com.Project.demo.App.domain.Comment;
import com.Project.demo.App.domain.Post;
import com.Project.demo.App.dto.CommentDto;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CommentMapper {

    public Comment mapToComment(CommentDto commentDto, Post post){

        return Comment.builder()
                .title(commentDto.getTitle())
                .authorname(commentDto.getAuthor())
                .body(commentDto.getBody())
                .post(post)
                .build();
    }

    public CommentDto mapToCommentDto(Comment comment){
        return CommentDto.builder()
                .id(comment.getId())
                .title(comment.getTitle())
                .author(comment.getAuthorname())
                .body(comment.getBody()).build();
    }

}

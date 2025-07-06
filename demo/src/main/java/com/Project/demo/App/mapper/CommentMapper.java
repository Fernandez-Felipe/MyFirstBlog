package com.Project.demo.App.mapper;

import com.Project.demo.App.domain.Comment;
import com.Project.demo.App.domain.Post;
import com.Project.demo.App.dto.CommentDto;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {

    public Comment mapToComment(CommentDto commentDto){
        return Comment.builder().title(commentDto.getTitle())
                .authorname(commentDto.getAuthor())
                .body(commentDto.getBody()).build();
    }

    public CommentDto mapToCommentDto(Comment comment){
        return CommentDto.builder().id(comment.getId())
                .author(comment.getAuthorname())
                .body(comment.getBody()).build();
    }

}

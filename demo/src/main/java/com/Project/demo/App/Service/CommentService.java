package com.Project.demo.App.Service;

import com.Project.demo.App.Exceptions.SpringBlogException;
import com.Project.demo.App.Repository.CommentRepository;
import com.Project.demo.App.domain.Comment;
import com.Project.demo.App.dto.CommentDto;
import com.Project.demo.App.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    public CommentDto save(CommentDto commentDto){
        Comment comment = commentMapper.mapToComment(commentDto);
        Comment SavedComment = commentRepository.save(comment);
        commentDto.setId(SavedComment.getId());
        return commentDto;
    }

    public List<CommentDto> findAllComments(){
        return commentRepository.findAll().stream().map(commentMapper::mapToCommentDto).toList();
    }

    public CommentDto updateComment(CommentDto commentDto){
        Comment comment = commentRepository.findById(commentDto.getId())
                .orElseThrow(() -> new SpringBlogException("comment with id "+
                        commentDto.getId()+" doesnt exist"));
        Comment saveComment = commentMapper.mapToComment(commentDto);
        saveComment.setId(comment.getId());
        commentRepository.save(saveComment);
        return  commentDto;
    }

    public void delete(Long id){
        commentRepository.deleteById(id);
    }

}

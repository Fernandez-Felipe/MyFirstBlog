package com.Project.demo.App.Service;

import com.Project.demo.App.Exceptions.SpringBlogException;
import com.Project.demo.App.Repository.CommentRepository;
import com.Project.demo.App.domain.Comment;
import com.Project.demo.App.domain.Post;
import com.Project.demo.App.dto.CommentDto;
import com.Project.demo.App.dto.PostDto;
import com.Project.demo.App.mapper.CommentMapper;
import com.Project.demo.App.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostService postService;
    private final CommentMapper commentMapper;
    private final PostMapper postMapper;

    public CommentDto save(CommentDto commentDto, String slug){

        Post post = postMapper.mapToPost(postService.findPostBySlug(slug));

        Comment comment = commentMapper.mapToComment(commentDto, post);
        Comment SavedComment = commentRepository.save(comment);
        commentDto.setId(SavedComment.getId());
        return commentDto;
    }

    public List<CommentDto> findAllCommentsBySlug(String slug){

        PostDto postDto = postService.findPostBySlug(slug);
        Post post = postMapper.mapToPost(postDto);

        List<Comment> Comments = commentRepository.findByPost(post);

        return Comments.stream().map(commentMapper::mapToCommentDto).toList();
    }

    public CommentDto updateComment(CommentDto commentDto){

        Comment comment = commentRepository.findById(commentDto.getId())
                .orElseThrow(() -> new SpringBlogException("comment with id "+
                        commentDto.getId()+" doesnt exist"));

        Comment saveComment = commentMapper.mapToComment(commentDto, comment.getPost());
        saveComment.setId(comment.getId());
        commentRepository.save(saveComment);
        return  commentMapper.mapToCommentDto(saveComment);
    }

    public void delete(Long id){
        commentRepository.deleteById(id);
    }

}

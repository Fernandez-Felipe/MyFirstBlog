package com.Project.demo.App.Controller;

import com.Project.demo.App.Service.CommentService;
import com.Project.demo.App.dto.CommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/posts/{slug}/comments")
public class CommentController {

    private CommentService commentService;

    @GetMapping
    public List<CommentDto> commentDtoList(@PathVariable String slug){
        return commentService.findAllCommentsBySlug(slug);
    }

    @PostMapping
    public CommentDto addComment(@PathVariable String slug, @RequestBody CommentDto commentDto){
        return commentService.save(commentDto,slug);
    }

    @PutMapping
    public CommentDto updateComment(@RequestBody CommentDto commentDto){
        return  commentService.updateComment(commentDto);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id){
        commentService.delete(id);
    }

}

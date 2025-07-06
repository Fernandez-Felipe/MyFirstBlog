package com.Project.demo.App.Controller;

import com.Project.demo.App.Service.CommentService;
import com.Project.demo.App.dto.CommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/posts/{slug}/comments")
public class CommentController {

    private CommentService commentService;

    @GetMapping
    public List<CommentDto> commentDtoList(){
        return commentService.findAllComments();
    }

}

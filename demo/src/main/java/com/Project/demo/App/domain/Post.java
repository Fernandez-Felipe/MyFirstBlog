package com.Project.demo.App.domain;

import com.Project.demo.App.Validation.PostTitleAlreadyExits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@PostTitleAlreadyExits
public class Post {

    private Integer id;

    @NotNull
    @Size(min = 3, max = 50)
    private String title;

    @NotNull
    @Size(min = 3, max = 500)
    private String description;

    @NotNull
    @Size(min = 3, max = 500)
    private String body;

    private String slug;
    private PostStatus poststatus;
    private LocalDateTime createdon;
    private LocalDateTime publicatedon;

    private List<Comment> coments;

}

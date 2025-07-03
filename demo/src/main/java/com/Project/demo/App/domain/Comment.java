package com.Project.demo.App.domain;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    private Integer id;

    @NotNull
    @Size(min = 3, max = 50, message = "Title must be minimun 3 character, and maximun 50 characters of length")
    private String title;

    @NotNull
    private String authorname;


    @NotNull
    @Size(min = 3, max = 5000, message = "Body must be 3 characters minimun, and 5000 characters of length")
    private String body;

    private LocalDateTime createdon;
    private LocalDateTime publishedon;


}

package com.Project.demo.App.domain;

import com.Project.demo.App.Validation.PostTitleAlreadyExits;
import jakarta.persistence.*;
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
@Entity
@Table
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

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

    @OneToMany(mappedBy = "post" ,  cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Comment> comments;

}

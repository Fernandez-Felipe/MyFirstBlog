package com.Project.demo.App.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 3, max = 50, message = "Title must be minimun 3 character, and maximun 50 characters of length")
    private String title;

    @NotNull
    private String authorname;


    @NotNull
    @Size(min = 3, max = 5000, message = "Body must be 3 characters minimun, and 5000 characters of length")
    private String body;

    private LocalTime createdon;
    private LocalTime publishedon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="post_id")
    private Post post;


}

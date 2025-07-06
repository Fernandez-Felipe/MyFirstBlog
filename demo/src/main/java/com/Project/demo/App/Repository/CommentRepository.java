package com.Project.demo.App.Repository;

import com.Project.demo.App.domain.Comment;
import com.Project.demo.App.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByPost(Post post);

}

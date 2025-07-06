package com.Project.demo.App.Repository;

import com.Project.demo.App.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}

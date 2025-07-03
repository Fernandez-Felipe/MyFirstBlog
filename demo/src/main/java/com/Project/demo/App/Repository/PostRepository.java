package com.Project.demo.App.Repository;


import com.Project.demo.App.Exceptions.SpringBlogException;
import com.Project.demo.App.domain.Post;
import org.springframework.stereotype.Repository;


import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;


@Repository
public class PostRepository {
    private final Set<Post> posts = new CopyOnWriteArraySet<>();
    public void addPost(Post post) {
        posts.add(post);
    }

    public Set<Post> findAllPosts() {
        return posts;
    }

    public Post findOnePost(Integer postId) {
        return posts.stream().filter(post -> post.getId().equals(postId))
                .findFirst()
                .orElseThrow(() -> new SpringBlogException("Cannot find post by id: " + postId));
    }

}
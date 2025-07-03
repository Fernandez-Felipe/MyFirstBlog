package com.Project.demo.App.Service;

import com.Project.demo.App.Repository.PostRepository;
import com.Project.demo.App.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@RequiredArgsConstructor
@Service
public class PostService{

    private final PostRepository postRepository;

    public void addPost(Post post){
        postRepository.addPost(post);
    }

    public Set<Post> findAllPost(){
        return postRepository.findAllPosts();
    }

    public boolean postExistsWithTitle(String title){
        return postRepository.findAllPosts().stream().anyMatch(post -> post.getTitle().equals(title));
    }

    public Post findOnePost(int id){
        return postRepository.findOnePost(id);
    }
}

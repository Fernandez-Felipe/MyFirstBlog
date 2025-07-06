package com.Project.demo.App.Service;

import com.Project.demo.App.Exceptions.SpringBlogException;
import com.Project.demo.App.Repository.PostRepository;
import com.Project.demo.App.domain.Post;
import com.Project.demo.App.dto.PostDto;
import com.Project.demo.App.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class PostService{

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    public PostDto save(PostDto postDto){
        Post post = postMapper.mapToPost(postDto);
        Post savedPost = postRepository.save(post);
        postDto.setId(savedPost.getId());
        return postDto;
    }

    public List<PostDto> findAllPost(){
        return postRepository.findAll().stream().map(postMapper::mapToPostDto).toList();
    }


    public boolean postExistsWithTitle(String title){
        return postRepository.existsByTitle(title);
    }

    public PostDto updatePost(PostDto postDto){
        Post post = postRepository.findById(postDto.getId())
                .orElseThrow(() -> new SpringBlogException("Cannot find the post qith id: "+ postDto.getId()));
        Post savedPost = postMapper.mapToPost(postDto);
        savedPost.setId(post.getId());
        postRepository.save(savedPost);
        return postDto;
    }

    public Optional<Post> findOnePost(long id){
        return postRepository.findById(id);
    }

    public void delete(Long id){
        postRepository.deleteById(id);
    }

    public PostDto findPostBySlug(String slug){
        Post post = postRepository.findBySlug(slug)
                    .orElseThrow(() -> new SpringBlogException("cannot find the post with slug: "+slug));

        return postMapper.mapToPostDto(post);
    }

}

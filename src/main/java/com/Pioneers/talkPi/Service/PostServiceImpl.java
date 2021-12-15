package com.Pioneers.talkPi.Service;

import com.Pioneers.talkPi.Model.Post;
import com.Pioneers.talkPi.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> getAllPost() {
        return null;
    }

    @Override
    public void savePost(Post post) {
        this.postRepository.save(post);

    }

    @Override
    public Optional<Post> getPostById(Long postId) {
        return postRepository.findPostByPostId(postId);
    }

    @Override
    public Post getPostByUserId(Long user_id) {
        return postRepository.findPostByUserId(user_id);
    }

    @Override
    public Post getPostByPostTitle(String postTitle) {
        return postRepository.findPostByPostTitle(postTitle);
    }

    @Override
    public Post getPostByPostBody(String postBody) {
        return postRepository.findPostByPostBody(postBody);
    }
}

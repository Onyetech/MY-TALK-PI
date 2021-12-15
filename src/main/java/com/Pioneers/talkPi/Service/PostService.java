package com.Pioneers.talkPi.Service;

import com.Pioneers.talkPi.Model.Post;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PostService {

    List<Post> getAllPost();

    void savePost(Post post);
    Optional<Post> getPostById(Long postId);
    Post getPostByUserId(Long user_id);
    Post getPostByPostTitle(String postTitle);
    Post getPostByPostBody(String postBody);


}

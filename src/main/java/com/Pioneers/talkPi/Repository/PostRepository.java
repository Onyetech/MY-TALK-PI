package com.Pioneers.talkPi.Repository;

import com.Pioneers.talkPi.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository <Post, Long>{

    @Transactional
//    void deletePostByPostId(Long postId, Long userId);
//    Post findPostByPostIdAndUsersId(Long postId, Long userId);
    Post findPostByPostTitleAndAndPostBody(String postTitle, String postBody);
    Optional<Post> findPostByPostId(Long postId);
    Post findPostByPostTitle(String postTitle);
    Post findPostByPostBody(String postBody);
    String findPostByUserId(Long user_id);


}

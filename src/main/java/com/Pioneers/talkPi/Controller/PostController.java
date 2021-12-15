package com.Pioneers.talkPi.Controller;

import com.Pioneers.talkPi.Model.Post;
import com.Pioneers.talkPi.Model.Users;
import com.Pioneers.talkPi.Repository.PostRepository;
import com.Pioneers.talkPi.Service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@MultipartConfig
@Slf4j
public class PostController {

    final PostRepository postRepository;
    final PostService postService;


    @Autowired
    public PostController(PostRepository postRepository, PostService postService) {

        this.postService = postService;
        this.postRepository = postRepository;

    }

    @GetMapping(value = "/createPost")
    public String getPostPage(Model model, HttpSession session, Users users){

        Users users1 = new Users();

        Post post = new Post();

        model.addAttribute("userPost", post);
        users = (Users) session.getAttribute("user");


        model.addAttribute("thisUser", users);
        model.addAttribute("allPosts", postService.getAllPost());

        log.error("no error here -testing");
        log.info("here is another");
        return "createPost";
    }


    @PostMapping("/blog")
    public String submitPost(@ModelAttribute("userPost") Post post, Model model, HttpSession session, HttpServletRequest request){
        session = request.getSession();

        Post authentic = postRepository.findPostByPostTitleAndAndPostBody(post.getPostTitle(), post.getPostBody());

        if (authentic != null){
            session.setAttribute("user", authentic);

            System.out.println(post);

            model.addAttribute("thisUserPost", authentic);
            model.addAttribute("user1", new Users());

            postService.savePost(post);

            return "blog";
        }

        else {
            session.setAttribute("messageFour", "No field should be empty");
            return "/createPost";
        }

    }

}




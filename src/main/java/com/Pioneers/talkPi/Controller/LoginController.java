package com.Pioneers.talkPi.Controller;

import com.Pioneers.talkPi.Model.Post;
import com.Pioneers.talkPi.Model.Users;
import com.Pioneers.talkPi.Repository.PostRepository;
import com.Pioneers.talkPi.Repository.UsersRepository;
import com.Pioneers.talkPi.Service.PostService;
import com.Pioneers.talkPi.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

@Controller
public class LoginController {

    private UsersService usersService;
    private PostRepository postRepository;
    private UsersRepository usersRepository;
    private Users users;
    private  PostService postService;

    public LoginController(Users users) {
        this.users = users;
    }

    @Autowired
    public LoginController (UsersRepository usersRepository,
                           UsersService usersService, PostRepository postRepository, PostService postService) {

        this.usersRepository = usersRepository;
        this.usersService = usersService;
        this.postRepository = postRepository;
        this.postService = postService;
    }



    @GetMapping("/login")
    public String showLoginForm(Model model) {

        model.addAttribute("userLogin", new Users());
        System.out.println("showLoginForm is working now");
        return "/login";
    }

    @PostMapping("/login")
    public String loginSuccess(@ModelAttribute("userLogin") Users users, Model model,
                               HttpSession session, HttpServletRequest request) {

        session = request.getSession();
        Users authenticatedUser = usersService.authUserLogin(users.getEmail(), users.getPasswordOne());

        if (authenticatedUser != null)
            {
            session.setAttribute("user", authenticatedUser);

            System.out.println(users);

            model.addAttribute("thisUser", authenticatedUser);

//                Users users = (Users) session.getAttribute("user");

                List<Post> allPosts = postService.getAllPost();
                Collections.reverse(postService.getAllPost());
                model.addAttribute("allPosts", allPosts);
//                session.getAttribute("users");

            return "blog";
            }

        else {
            session.setAttribute("messageFour", "Invalid inputs combination, try again.");
            return "/login";
            }

    }
}

package com.Pioneers.talkPi.Controller;

import com.Pioneers.talkPi.Model.Users;
import com.Pioneers.talkPi.Repository.UsersRepository;
import com.Pioneers.talkPi.Service.UsersService;
import com.Pioneers.talkPi.Service.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    private UsersServiceImpl usersServiceImpl;
    private UsersRepository usersRepository;
    private UsersService usersService;
    private Users users;

    public LoginController(Users users) {
        this.users = users;
    }

    @Autowired
    public LoginController(UsersService usersService, UsersRepository usersRepository,
    UsersServiceImpl usersServiceImpl) {

        this.usersService = usersService;
        this.usersRepository = usersRepository;
        this.usersServiceImpl = usersServiceImpl;
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
        Users authenticated = usersServiceImpl.authUserLogin(users.getEmail(), users.getPasswordOne());

        if (authenticated != null)
            {
            session.setAttribute("user", authenticated);

            System.out.println(users);

            model.addAttribute("thisUser", authenticated);

            return "blog";
            }

        else {
            session.setAttribute("messageFour", "Invalid inputs combination, try again.");
            return "/login";
            }

    }
}

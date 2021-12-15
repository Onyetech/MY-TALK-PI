package com.Pioneers.talkPi.Controller;

import com.Pioneers.talkPi.Model.Users;
import com.Pioneers.talkPi.Repository.UsersRepository;
import com.Pioneers.talkPi.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UsersController {


    private UsersRepository usersRepository;
    private UsersService usersService;
    private Users users;

    public UsersController(Users users) {
        this.users = users;
    }

    @Autowired
    public UsersController(UsersService usersService, UsersRepository usersRepository) {

        this.usersService = usersService;
        this.usersRepository = usersRepository;
    }

    @GetMapping("/")
    public String viewRegistrationPage(Model model){
        model.addAttribute("users", usersService.getAllUsers());
        return "index";
    }

    @GetMapping("/signup")
    public String showRegisterPage(Model model){
        model.addAttribute("usersRegister", new Users());
        return "signup";
    }

    @PostMapping("/registered")
    public String saveUser(@ModelAttribute Users users, HttpSession session) {
        System.out.println("Register request: " + users);


        Users newUser = new Users();

        newUser.setUsername(users.getUsername());
        newUser.setEmail(users.getEmail());
        newUser.setFullName(users.getFullName());
        newUser.setPasswordOne(users.getPasswordOne());
        newUser.setPasswordTwo(users.getPasswordTwo());

        if (newUser.getPasswordOne().equals(newUser.getPasswordTwo())) {

            usersService.saveUsers(newUser);
            System.out.println("User of id: " + newUser.getId() + ", has been saved.");

            return "/login";
        } else {
            session.setAttribute("messageOne", "The Passwords Does Not Match!!!");
            return "/signup";
        }
    }









//        if (usersRepository.existsByUsername(users.getUsername())){
//
//                session.setAttribute("messageTwo","The username is Taken, pick another.");
//
//                return "/signup";
//        }
//        else
//        {
//            usersService.saveUsers(newUser);
//            System.out.println("User of id: " +newUser.getId() + ", has been saved.");
//
//            return "/login";
//        }

//        if (usersRepository.existsByEmail(users.getEmail())){
//            session.setAttribute("messageThree","The email already exist in the database.");
//            return "/signup";
//        }
//        else
//        {
//            usersService.saveUsers(newUser);
//            System.out.println("User of id: " +newUser.getId() + ", has been saved.");
//
//            return "/login";
//        }

    }



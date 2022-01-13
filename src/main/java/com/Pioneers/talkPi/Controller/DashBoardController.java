package com.Pioneers.talkPi.Controller;

import com.Pioneers.talkPi.Model.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class DashBoardController {

    @GetMapping("/profile")
    public String showDashBoardForm(Model model) {
        model.addAttribute("userDashBoard", new Users());
        System.out.println("showDashBoardForm is working now");
        return "profile";
    }

//    @PostMapping("/dashboard")
//    public String getDashBoard(Model model, HttpServletRequest request) {
//
//        HttpSession session = request.getSession();
//        Users users = (Users) session.getAttribute("user");
//
//        System.out.println(users);
//        model.addAttribute("thisUser", users);
//
//        model.addAttribute("dashBoard", new Users());
//
//        System.out.println("myDashBoard is working now");
//
//        return "profile";
//    }
}

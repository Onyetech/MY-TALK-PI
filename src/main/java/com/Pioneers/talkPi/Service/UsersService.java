package com.Pioneers.talkPi.Service;

import com.Pioneers.talkPi.Model.Users;

import java.util.List;

public interface UsersService {

    List<Users> getAllUsers();

    void saveUsers(Users users);
    Users getUsersById(Long id);
    Users authUserLogin(String email, String password);
    String findUserByEMail(String email);
    String findUserByPasswordOne(String passwordOne);
    Users findByUsersName(String username);
    String existsByEmail(String email);
    String existsByPasswordOne(String password);
    Users existsById(Long id);

}

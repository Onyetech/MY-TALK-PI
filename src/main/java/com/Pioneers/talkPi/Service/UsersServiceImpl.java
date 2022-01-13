package com.Pioneers.talkPi.Service;

import com.Pioneers.talkPi.Model.Users;
import com.Pioneers.talkPi.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService{

    private UsersRepository usersRepository;
    private Users users;




    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UsersServiceImpl(Users users) {
        this.users = users;
    }

    @Override
    public List<Users> getAllUsers() {
        List<Users> users = usersRepository.findAll();
        Collections.reverse(users);

        return users;
    }

    @Override
    public void saveUsers(Users users) {
        this.usersRepository.save(users);
    }

    @Override
    public Users getUsersById(Long id) {

        return usersRepository.getById(id);
    }

    @Override
    public Users existsById(Long id) {
        return getUsersById(id);
    }

    @Override
    public Users findByUsersName(String username) {
        Users users = usersRepository.findByUsername(username);
        return users;
    }

    @Override
    public String existsByEmail(String email) {
        return findUserByEMail(users.getEmail());
    }

    @Override
    public String existsByPasswordOne(String password) {
        return findUserByPasswordOne(users.getPasswordOne());
    }

    @Override
    public String findUserByEMail(String email){
       return users.getEmail();
    }

    @Override
    public String findUserByPasswordOne(String passwordOne){
        return users.getPasswordOne();
    }

    public String findUserByPasswordTwo(String passwordTwo){
        return users.getPasswordTwo();
    }

    public String findUserByUsername(String username){
        return users.getUsername();
    }

   @Override
    public Users authUserLogin(String email, String password) {
        return usersRepository.findByEmailAndPasswordOne(email, password).orElse(null);
    }

}

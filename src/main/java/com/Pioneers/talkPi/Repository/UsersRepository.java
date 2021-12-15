package com.Pioneers.talkPi.Repository;

import com.Pioneers.talkPi.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{


        Users findByUsername(String username);
        boolean existsByUsername(String username);
        boolean existsByEmail(String email);
        boolean existsByPasswordOne(String password);
        boolean existsById(Long id);
        Users findByEmail(String email);
        boolean findUsersByEmail(String email);
        Users findUsersByPasswordOne(String passwordOne);
        Users findUsersByPasswordTwo(String passwordTwo);

        Optional<Users> findByEmailAndPasswordOne(String email, String password);
    }





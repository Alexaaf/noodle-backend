package com.example.noodle.service;

import com.example.noodle.model.User;
import com.example.noodle.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
// for CORS policy error in browser @CrossOrigin
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAll(){
       return userRepository.findAll();
    }

    public User saveUser(User user) {

        return userRepository.save(user);
    }

    public List <User> findById(Long id) {
        return userRepository.findStudentById(id);
    }

    public List <User> findByEmail(String email) {
        List<User> u = new ArrayList<>();
        try{
            return userRepository.findStudentByEmail(email);
        }catch (Exception e)
        {
            System.out.println(e.toString());
            return u;
        }
    }
}

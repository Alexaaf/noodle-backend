package com.example.noodle.controller;

import com.example.noodle.model.Grade;
import com.example.noodle.model.User;
import com.example.noodle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.mindrot.jbcrypt.BCrypt;


import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/test")
    public ResponseEntity<String> getPage(){
        return new ResponseEntity<String>("Welcome", HttpStatus.OK);
    }

    @GetMapping(value = "/observer")
    public Grade sendObserver(Grade g){
      return  g;
    }

    @GetMapping(value = "/all")
    public List<User> getUsers(){
        return  userService.findAll();
    }


    @PostMapping (value = "/addUser")
    public String addUser(@RequestBody User user)
    {
        user.setHash(BCrypt.gensalt());
        user.setPassword(BCrypt.hashpw(user.getPassword(), user.getHash()));

        try{
            userService.saveUser(user);
            return "New user added";
        }catch (Exception e)
        {
            System.out.println(e.toString());
            return e.toString();
        }

    }
//
//    @PostMapping(value = "/save")
//    public String saveUser(@RequestBody User user){
//        userRepo.save(user);
//        return "Saved...";
//    }
//
    @RequestMapping (value = "findById/{id}")
    public List<User> getUserById(@PathVariable Long id){
        return userService.findById(id);
    }

    @RequestMapping (value = "findByEmail/{email}/{password}")
    public User getUserByEmail(@PathVariable String email, @PathVariable String password){
        System.out.println(password);
        User u = new User();
        try{
            List<User> users = userService.findByEmail(email); //aici nu era important sa fie lista, da e mai usor de scos din DB
            System.out.println(users.get(0).getPassword());
            if(BCrypt.checkpw(password, users.get(0).getPassword())){ //am verificat numai parola ptc da eroare daca nu exista email ul
                u.setEmail(email);
                u.setPassword(password);
                u.setId(users.get(0).getId());
                return u;
            }
            return u;
        }catch (Exception e){
            return u;
        }
    }



//    @DeleteMapping(value = "/delete/{id}")
//    public String deleteUser(@PathVariable long id){
//        User deletedUser = userRepo.findById(id).get();
//        userRepo.delete(deletedUser);
//        return "User with id " + id + " has been deleted.";
//    }
}
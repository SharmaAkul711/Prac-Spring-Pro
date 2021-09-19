package com.pracSpringPro.Controllers;


import com.pracSpringPro.Entities.User;
import com.pracSpringPro.Exceptions.UserNotFoundException;
import com.pracSpringPro.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Long id){

        User user = userService.findUserById(id);
        if(user==null){
            throw new UserNotFoundException("Id-" + id);
        }
        return user;
    }

    @PostMapping("/")
    public User addUser(@Valid @RequestBody User user){

        return userService.saveUser(user);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUserEmail(@PathVariable Long id, String email){

        User user = userService.findUserById(id);
        if(user==null){
            throw new UserNotFoundException("Id-" + id);
        }
        userService.updateUserEmail(id, email);

        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        User user = userService.findUserById(id);
        if(user==null){
            throw new UserNotFoundException("Id-" + id);
        }
        userService.deleteUserById(id);

        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}

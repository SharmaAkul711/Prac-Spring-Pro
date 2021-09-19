package com.pracSpringPro.Services;


import com.pracSpringPro.Entities.User;
import com.pracSpringPro.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User findUserById(Long id) {
        return userRepository.findUserById(id);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void updateUserEmail(Long id, String email){

        User user = userRepository.findUserById(id);
        user.setEmail(email);
        userRepository.save(user);
    }

    public void deleteUserById(Long id) {
        User user = userRepository.findUserById(id);
        userRepository.delete(user);
    }
}

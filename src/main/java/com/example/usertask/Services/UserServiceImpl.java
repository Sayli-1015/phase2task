package com.example.usertask.Services;

import com.example.usertask.Model.User;
import com.example.usertask.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.scheduling.annotation.Scheduled;
import java.util.Date;


import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User>getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User existingUser = userOptional.get();
//            existingUser.setName(user.getName());
            return userRepository.save(existingUser);
        }
        return null;
    }

    @Override
    public String deleteUser(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            userRepository.deleteById(id);
            return "User deleted successfully";
        }
        return "User not found";
    }

    @Override
    public List<User> findByNameAndLastname(String name, String lastname) {
        return userRepository.findByNameAndLastname(name, lastname);
    }

//    @Scheduled(fixedDelay = 5000) // Run every 5 seconds
//    public void scheduledTask() {
//        System.out.println("Scheduled task executed at: " + new Date());
//
//    }

    // scheduled task to fetch users at 12:00 am
    @Scheduled(cron = "0 0 0 * * ?")
    public void fetchUsersAtMidnight() {

        List<User> users = userRepository.findAll();
        for (User user : users) {
            System.out.println("User: " + user.getName());
        }
    }
}

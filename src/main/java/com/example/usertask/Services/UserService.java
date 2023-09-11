package com.example.usertask.Services;

import com.example.usertask.Model.User;

import java.util.List;
public interface UserService {

    List<User> getAllUsers();
    User getUserById(Long id);
    User createUser(User user);
    User updateUser(Long id, User user);
    String deleteUser(Long id);

    List<User> findByNameAndLastname(String name, String lastname);
}

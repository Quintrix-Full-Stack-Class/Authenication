package com.sha.springbootjwtauthorization.security.jwt.service;

import com.sha.springbootjwtauthorization.model.Role;
import com.sha.springbootjwtauthorization.model.User;

import java.util.List;
import java.util.Optional;


public interface UserService
{
    User saveUser(User user);

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);
    void changeRole(Role newRole, String username);

    List<User> findAllUsers();
}

package com.example.springcourse.CRUD2appBoot.DAO;


import com.example.springcourse.CRUD2appBoot.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    void saveUser(User user);

    void update(User user);

    void removeUserById(Long id);

    List<User> getAllUsers();

    Optional<User> getUserById(Long id);
}

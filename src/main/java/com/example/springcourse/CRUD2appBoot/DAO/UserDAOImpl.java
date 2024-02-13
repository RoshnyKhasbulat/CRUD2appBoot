package com.example.springcourse.CRUD2appBoot.DAO;


import com.example.springcourse.CRUD2appBoot.exeptions.NotFoundException;
import com.example.springcourse.CRUD2appBoot.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDAOImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(User user) {
        User existingUser = getUserById(user.getId()).orElseThrow(() -> new NotFoundException("User not found"));
        entityManager.detach(existingUser);
        existingUser.setName(user.getName());
        entityManager.merge(existingUser);
    }

    @Override
    public void removeUserById(Long id) {
//        entityManager.remove(getUserById(id));
        getUserById(id).ifPresent(entityManager::remove);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u").getResultList();
    }

    @Override
    public Optional<User> getUserById(final Long id) {
        return Optional.ofNullable(entityManager.find(User.class, id));
    }
}

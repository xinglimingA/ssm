package com.xlm.dao;

import com.xlm.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserDao {
    void addUser(User user);
    void updateUser(User user);
    User getUserById(String id);
    List<User> getAllUser();
    void deleteUser(String id);
}
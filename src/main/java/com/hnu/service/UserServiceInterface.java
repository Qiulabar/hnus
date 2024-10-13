package com.hnu.service;

import com.hnu.entity.User;
import java.util.List;

public interface UserServiceInterface {
    public User findUser(String username);
    public User findUser(long id);
    public List<User> getUserAll();
    public int verifyUser(String username, String password);
    public boolean registerUser(User newuser);
    public boolean delUser(long id);
    public boolean editUser(long id, User user);

}


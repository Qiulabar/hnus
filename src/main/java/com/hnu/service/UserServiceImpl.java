package com.hnu.service;

import com.hnu.entity.User;
import java.util.List;
import com.hnu.dao.UserMgrImpl;
import com.hnu.dao.UserMgrInterface;

public class UserServiceImpl implements UserServiceInterface {

    private UserMgrInterface userDAO = (UserMgrInterface) new UserMgrImpl();

    @Override
    public List<User> getUserAll() {
        return userDAO.selectAll();
    }
    @Override
    public int verifyUser(String username, String password) {
        int userType = -1;
        User record = userDAO.select(username);
        if (record != null) {
            String pwd = record.getPassword();
            if (pwd != null && pwd.equals(password)) {
                userType = record.getUserType();
            }
        }
        return userType;
    }

    @Override
    public boolean registerUser(User newuser) {

        return userDAO.insert(newuser);
    }

    @Override
    public boolean delUser(long id) {
        return userDAO.delete(id);
    }

    @Override
    public boolean editUser(long id,User user) {
        return userDAO.update(user);
    }

    @Override
    public User findUser(String username) {
        return userDAO.select(username);
    }
    @Override
    public User findUser(long id) {
        return userDAO.select(id);
    }

    public UserMgrInterface getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserMgrInterface userDAO) {
        this.userDAO = userDAO;
    }
}



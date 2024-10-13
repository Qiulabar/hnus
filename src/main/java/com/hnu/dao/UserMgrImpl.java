package com.hnu.dao;

import com.hnu.entity.User;
import java.util.ArrayList;
import java.util.List;

public class UserMgrImpl implements UserMgrInterface{
    private static ArrayList<User> userList = new ArrayList<User>(){{
        add(new User(1,"user1","123", 0, "张三", 0));
        add(new User(2,"user2","123", 1, "李四", 1));
        add(new User(3,"admin","123", 1, "王五", 2));

    }};

    public UserMgrImpl() {

    }

    public int verifyUser(String username, String password){
        int userType = -1;
        for(User user : userList){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                userType = user.getUserType();
            }
        }
        return userType;
    }

    @Override
    public User select(long id) {
        User usertemp = new User();
        for(User user : userList){
            if(user.getId() == id ){
                usertemp = user;
                break;
            }
        }
        return usertemp;
    }

    public User select(String username) {
        User usertemp = new User();
        for(User user : userList){
            if(user.getUsername().equals(username) ){
                usertemp = user;
                break;
            }
        }
        return usertemp;
    }

    @Override
    public List<User> selectAll() {
        return userList;
    }

    @Override
    public boolean insert(User newuser) {
        for(User user : userList){
            if(user.getUsername().equals(newuser.getUsername()) ){
                return false;
            }
        }
        userList.add(newuser);
        return true;
    }

    @Override
    public boolean update(User eidtedUser) {
        for(User user : userList){
            if(user.getUsername().equals(eidtedUser.getUsername()) ){
                userList.remove(user);
                userList.add(eidtedUser);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        for(User user : userList) {
            if (user.getId() == id) {
                userList.remove(user);
                return true;
            }
        }
        return false;
    }
}



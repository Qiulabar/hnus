package com.hnu.dao;

import com.hnu.entity.User;
import java.util.List;

public interface UserMgrInterface {
    public User select(long id);
    public User select(String username);
    public List<User> selectAll();
    public boolean insert(User newuser);
    public boolean update(User user);
    public boolean delete(long id);
}


